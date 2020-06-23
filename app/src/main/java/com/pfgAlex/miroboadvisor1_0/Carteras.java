package com.pfgAlex.miroboadvisor1_0;

import java.io.Serializable;

public class Carteras implements Serializable {

    private String nom_cartera;
    private String tipo_riesgo;
    private String tipo_objetivo;
    private String tipo_ocupacion;
    private String tipo_perdida;
    private String num_ahorros;
    private String num_ingresos;
    private String num_patrimonio;
    private String num_edad;
    private String num_importe;

    public Carteras(){

    }

    public Carteras(String nom_cartera, String tipo_riesgo, String tipo_objetivo, String tipo_ocupacion, String tipo_perdida, String num_ahorros, String num_ingresos, String num_patrimonio, String num_edad, String num_importe) {
        this.nom_cartera = nom_cartera;
        this.tipo_riesgo = tipo_riesgo;
        this.tipo_objetivo = tipo_objetivo;
        this.tipo_ocupacion = tipo_ocupacion;
        this.tipo_perdida = tipo_perdida;
        this.num_ahorros = num_ahorros;
        this.num_ingresos = num_ingresos;
        this.num_patrimonio = num_patrimonio;
        this.num_edad = num_edad;
        this.num_importe = num_importe;
    }

    public String getNom_cartera() {
        return nom_cartera;
    }

    public void setNom_cartera(String nom_cartera) {
        this.nom_cartera = nom_cartera;
    }

    public String getTipo_riesgo() {
        return tipo_riesgo;
    }

    public void setTipo_riesgo(String tipo_riesgo) {
        this.tipo_riesgo = tipo_riesgo;
    }

    public String getTipo_objetivo() {
        return tipo_objetivo;
    }

    public void setTipo_objetivo(String tipo_objetivo) {
        this.tipo_objetivo = tipo_objetivo;
    }

    public String getTipo_ocupacion() {
        return tipo_ocupacion;
    }

    public void setTipo_ocupacion(String tipo_ocupacion) {
        this.tipo_ocupacion = tipo_ocupacion;
    }

    public String getTipo_perdida() {
        return tipo_perdida;
    }

    public void setTipo_perdida(String tipo_perdida) {
        this.tipo_perdida = tipo_perdida;
    }

    public String getNum_ahorros() {
        return num_ahorros;
    }

    public void setNum_ahorros(String num_ahorros) {
        this.num_ahorros = num_ahorros;
    }

    public String getNum_ingresos() {
        return num_ingresos;
    }

    public void setNum_ingresos(String num_ingresos) {
        this.num_ingresos = num_ingresos;
    }

    public String getNum_patrimonio() {
        return num_patrimonio;
    }

    public void setNum_patrimonio(String num_patrimonio) {
        this.num_patrimonio = num_patrimonio;
    }

    public String getNum_edad() {
        return num_edad;
    }

    public void setNum_edad(String num_edad) {
        this.num_edad = num_edad;
    }

    public String getNum_importe() {
        return num_importe;
    }

    public void setNum_importe(String num_importe) {
        this.num_importe = num_importe;
    }

    @Override
    public String toString() {
        return "Carteras{" +
                "nom_cartera='" + nom_cartera + '\'' +
                ", tipo_riesgo='" + tipo_riesgo + '\'' +
                ", tipo_objetivo='" + tipo_objetivo + '\'' +
                ", tipo_ocupacion='" + tipo_ocupacion + '\'' +
                ", tipo_perdida='" + tipo_perdida + '\'' +
                ", num_ahorros='" + num_ahorros + '\'' +
                ", num_ingresos='" + num_ingresos + '\'' +
                ", num_patrimonio='" + num_patrimonio + '\'' +
                ", num_edad='" + num_edad + '\'' +
                ", num_importe='" + num_importe + '\'' +
                '}';
    }
}
