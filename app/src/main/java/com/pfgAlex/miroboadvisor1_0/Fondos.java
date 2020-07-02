package com.pfgAlex.miroboadvisor1_0;

import java.io.Serializable;

public class Fondos implements Serializable {

    private String Nombre;
    private Integer Riesgo;
    private Double ano1;
    private Double ano3;
    private Double ano5;
    private Double YTD;
    private Long IMI;
    private String Categoria;

    public Fondos (){

    }

    public Fondos(String nombre, Integer riesgo, Double ano1, Double ano3, Double ano5, Double YTD, Long IMI, String categoria) {
        Nombre = nombre;
        Riesgo = riesgo;
        this.ano1 = ano1;
        this.ano3 = ano3;
        this.ano5 = ano5;
        this.YTD = YTD;
        this.IMI = IMI;
        Categoria = categoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getRiesgo() {
        return Riesgo;
    }

    public void setRiesgo(Integer riesgo) {
        Riesgo = riesgo;
    }

    public Double getAno1() {
        return ano1;
    }

    public void setAno1(Double ano1) {
        this.ano1 = ano1;
    }

    public Double getAno3() {
        return ano3;
    }

    public void setAno3(Double ano3) {
        this.ano3 = ano3;
    }

    public Double getAno5() {
        return ano5;
    }

    public void setAno5(Double ano5) {
        this.ano5 = ano5;
    }

    public Double getYTD() {
        return YTD;
    }

    public void setYTD(Double YTD) {
        this.YTD = YTD;
    }

    public Long getIMI() {
        return IMI;
    }

    public void setIMI(Long IMI) {
        this.IMI = IMI;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    @Override
    public String toString() {
        return "Fondos{" +
                "Nombre='" + Nombre + '\'' +
                ", Riesgo=" + Riesgo +
                ", ano1=" + ano1 +
                ", ano3=" + ano3 +
                ", ano5=" + ano5 +
                ", YTD=" + YTD +
                ", IMI=" + IMI +
                ", Categoria='" + Categoria + '\'' +
                '}';
    }
}
