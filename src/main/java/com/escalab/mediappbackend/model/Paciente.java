package com.escalab.mediappbackend.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@ApiModel(description = "Información o propiedades del paciente")
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @ApiModelProperty(notes = "Nombre dene tener como minimo 5 caracteres")
    @Size(min = 5, max = 50, message = "El nombre debe contener mínimo 5 caracteres")
    @Column(name = "nombres", nullable = true, length = 50)
    private String nombres;

    @Size(min = 5, max = 50, message = "Los apellidos debe contener mínimo 5 caracteres")
    @Column(name = "apellidos", nullable = true, length = 50)
    private String apellidos;

    @Size(min = 8, max = 10, message = "El DNI no debe ser mayor ni menor de 9")
    @Column(name = "dni", nullable = true)
    private String dni;

    @Size(min = 9, max = 9, message = "El telefono no debe ser mayor ni menor de 9")
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Size(max = 200, message = "La dirección no debe tener máximo 200")
    @Column(name = "direccion", nullable = true)
    private String direccion;

    @Email
    @Column(name = "email")
    private String email;

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
