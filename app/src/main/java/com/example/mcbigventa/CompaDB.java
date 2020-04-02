package com.example.mcbigventa;

import java.io.Serializable;

public class CompaDB implements Serializable {

    private String ventas;
    private String gcs;

    public CompaDB(String ventas, String gcs) {
        this.ventas=ventas;
        this.gcs=gcs;
    }

    public String getVentas() {
        return ventas;
    }

    public void setVentas(String ventas) {
        this.ventas = ventas;
    }

    public String getGcs() {
        return gcs;
    }

    public void setGcs(String gcs) {
        this.gcs = gcs;
    }
}
