package com.pfgAlex.miroboadvisor1_0;

public class MostrarCarteras {
    private String nombre_cartera;
    private String tipo_riesgo;
    private String categoria;

    public MostrarCarteras(String nombre_cartera, String tipo_riesgo, String categoria) {
        this.nombre_cartera = nombre_cartera;
        this.tipo_riesgo = tipo_riesgo;
        this.categoria = categoria;
    }

    public String getNombre_cartera() {
        return nombre_cartera;
    }

    public void setNombre_cartera(String nombre_cartera) {
        this.nombre_cartera = nombre_cartera;
    }

    public String getTipo_riesgo() {
        return tipo_riesgo;
    }

    public void setTipo_riesgo(String tipo_riesgo) {
        this.tipo_riesgo = tipo_riesgo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
