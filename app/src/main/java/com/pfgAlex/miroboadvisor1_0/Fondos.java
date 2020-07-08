package com.pfgAlex.miroboadvisor1_0;

import java.io.Serializable;

public class Fondos implements Serializable {

    private Integer Id;
    private String Nombre;
    private Integer Riesgo;
    private Float ano1;
    private Float ano3;
    private Float ano5;
    private Float YTD;
    private Long IMI;
    private String Categoria;

    public Fondos (){

    }

    public Fondos(Integer id, String nombre, Integer riesgo, Float ano1, Float ano3, Float ano5, Float YTD, Long IMI, String categoria) {
        Id = id;
        Nombre = nombre;
        Riesgo = riesgo;
        this.ano1 = ano1;
        this.ano3 = ano3;
        this.ano5 = ano5;
        this.YTD = YTD;
        this.IMI = IMI;
        Categoria = categoria;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public Float getAno1() {
        return ano1;
    }

    public void setAno1(Float ano1) {
        this.ano1 = ano1;
    }

    public Float getAno3() {
        return ano3;
    }

    public void setAno3(Float ano3) {
        this.ano3 = ano3;
    }

    public Float getAno5() {
        return ano5;
    }

    public void setAno5(Float ano5) {
        this.ano5 = ano5;
    }

    public Float getYTD() {
        return YTD;
    }

    public void setYTD(Float YTD) {
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
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
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
