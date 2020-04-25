package com.example.miroboadvisor1_0;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Usuarios implements Serializable {

    private String DNI;
    private String Nombre;
    private String Apellidos;
    private String Pais;
    private String Ciudad;
    private String Domicilio;
    private String Iban;
    private String Telefono;
    private String Email;
    private String Contraseña;

    public Usuarios(){

    }

    public Usuarios(String DNI, String nombre, String apellidos, String pais, String ciudad, String domicilio, String iban, String telefono, String email, String contraseña) {
        this.DNI = DNI;
        Nombre = nombre;
        Apellidos = apellidos;
        Pais = pais;
        Ciudad = ciudad;
        Domicilio = domicilio;
        Iban = iban;
        Telefono = telefono;
        Email = email;
        Contraseña = contraseña;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String domicilio) {
        Domicilio = domicilio;
    }

    public String getIban() {
        return Iban;
    }

    public void setIban(String iban) {
        Iban = iban;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "DNI='" + DNI + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Pais='" + Pais + '\'' +
                ", Ciudad='" + Ciudad + '\'' +
                ", Domicilio='" + Domicilio + '\'' +
                ", Iban='" + Iban + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Email='" + Email + '\'' +
                ", Contraseña='" + Contraseña + '\'' +
                '}';
    }
}
