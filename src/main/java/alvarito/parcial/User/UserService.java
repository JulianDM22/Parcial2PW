package alvarito.parcial.User;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository; 

    @Transactional
    public UserResponse updateUser(UserRequest userRequest) {
       
        User user = User.builder()
        .id(userRequest.id)
        .firstname(userRequest.getFirstname())
        .lastname(userRequest.lastname)
        .role(Role.USER)
        .build();
        
        userRepository.updateUser(user.id, user.firstname, user.lastname);

        return new UserResponse("El usuario se registró satisfactoriamente");
    }

    public UserDTO getUser(Integer id) {
        User user= userRepository.findById(id).orElse(null);
       
        if (user!=null)
        {
            UserDTO userDTO = UserDTO.builder()
            .id(user.id)
            .username(user.username)
            .firstname(user.firstname)
            .lastname(user.lastname)
            .build();
            return userDTO;
        }
        return null;
    }
}