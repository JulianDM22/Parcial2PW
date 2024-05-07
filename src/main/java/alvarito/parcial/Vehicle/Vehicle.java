package alvarito.parcial.Vehicle;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="vehicles", uniqueConstraints = {@UniqueConstraint(columnNames = {"paca"})})
public class Vehicle {
	@Id
    @GeneratedValue
    Integer id;
    @Basic
    @Column(nullable = false)
    int placa;
    @Column(nullable = false)
    int horaEntrada;
    int horaSalida;
    
}
