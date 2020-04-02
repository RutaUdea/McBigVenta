package com.example.mcbigventa;

import java.io.Serializable;

public class VentasDB implements Serializable {

    private String proVentasDia="0";

    private String dia="1";

    private String realMostraDes="0";
    private String realMostraAlm="0";
    private String realMostraTard="0";
    private String realMostraCena="0";
    private String realMostraExt="0";

    private String realAutoDes="0";
    private String realAutoAlm="0";
    private String realAutoTard="0";
    private String realAutoCena="0";
    private String realAutoaExt="0";

    private String realMcEnDes="0";
    private String realMcEnAlm="0";
    private String realMcEnTard="0";
    private String realMcEnCena="0";
    private String realMcEnExt="0";

    private String realMcCaDes="0";
    private String realMcCaAlm="0";
    private String realMcCaTard="0";
    private String realMcCaCena="0";

    public VentasDB(String dia,String proVentasDia, String realMostraDes, String realMostraAlm, String realMostraTard, String realMostraCena, String realMostraExt, String realAutoDes, String realAutoAlm, String realAutoTard, String realAutoCena, String realAutoaExt, String realMcEnDes, String realMcEnAlm, String realMcEnTard, String realMcEnCena, String realMcEnExt, String realMcCaDes, String realMcCaAlm, String realMcCaTard, String realMcCaCena) {
        this.dia=dia;
        this.proVentasDia = proVentasDia;
        this.realMostraDes = realMostraDes;
        this.realMostraAlm = realMostraAlm;
        this.realMostraTard = realMostraTard;
        this.realMostraCena = realMostraCena;
        this.realMostraExt = realMostraExt;
        this.realAutoDes = realAutoDes;
        this.realAutoAlm = realAutoAlm;
        this.realAutoTard = realAutoTard;
        this.realAutoCena = realAutoCena;
        this.realAutoaExt = realAutoaExt;
        this.realMcEnDes = realMcEnDes;
        this.realMcEnAlm = realMcEnAlm;
        this.realMcEnTard = realMcEnTard;
        this.realMcEnCena = realMcEnCena;
        this.realMcEnExt = realMcEnExt;
        this.realMcCaDes = realMcCaDes;
        this.realMcCaAlm = realMcCaAlm;
        this.realMcCaTard = realMcCaTard;
        this.realMcCaCena = realMcCaCena;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getProVentasDia() {
        return proVentasDia;
    }

    public void setProVentasDia(String proVentasDia) {
        this.proVentasDia = proVentasDia;
    }

    public String getRealMostraDes() {
        return realMostraDes;
    }

    public void setRealMostraDes(String realMostraDes) {
        this.realMostraDes = realMostraDes;
    }

    public String getRealMostraAlm() {
        return realMostraAlm;
    }

    public void setRealMostraAlm(String realMostraAlm) {
        this.realMostraAlm = realMostraAlm;
    }

    public String getRealMostraTard() {
        return realMostraTard;
    }

    public void setRealMostraTard(String realMostraTard) {
        this.realMostraTard = realMostraTard;
    }

    public String getRealMostraCena() {
        return realMostraCena;
    }

    public void setRealMostraCena(String realMostraCena) {
        this.realMostraCena = realMostraCena;
    }

    public String getRealMostraExt() {
        return realMostraExt;
    }

    public void setRealMostraExt(String realMostraExt) {
        this.realMostraExt = realMostraExt;
    }

    public String getRealAutoDes() {
        return realAutoDes;
    }

    public void setRealAutoDes(String realAutoDes) {
        this.realAutoDes = realAutoDes;
    }

    public String getRealAutoAlm() {
        return realAutoAlm;
    }

    public void setRealAutoAlm(String realAutoAlm) {
        this.realAutoAlm = realAutoAlm;
    }

    public String getRealAutoTard() {
        return realAutoTard;
    }

    public void setRealAutoTard(String realAutoTard) {
        this.realAutoTard = realAutoTard;
    }

    public String getRealAutoCena() {
        return realAutoCena;
    }

    public void setRealAutoCena(String realAutoCena) {
        this.realAutoCena = realAutoCena;
    }

    public String getRealAutoaExt() {
        return realAutoaExt;
    }

    public void setRealAutoaExt(String realAutoaExt) {
        this.realAutoaExt = realAutoaExt;
    }

    public String getRealMcEnDes() {
        return realMcEnDes;
    }

    public void setRealMcEnDes(String realMcEnDes) {
        this.realMcEnDes = realMcEnDes;
    }

    public String getRealMcEnAlm() {
        return realMcEnAlm;
    }

    public void setRealMcEnAlm(String realMcEnAlm) {
        this.realMcEnAlm = realMcEnAlm;
    }

    public String getRealMcEnTard() {
        return realMcEnTard;
    }

    public void setRealMcEnTard(String realMcEnTard) {
        this.realMcEnTard = realMcEnTard;
    }

    public String getRealMcEnCena() {
        return realMcEnCena;
    }

    public void setRealMcEnCena(String realMcEnCena) {
        this.realMcEnCena = realMcEnCena;
    }

    public String getRealMcEnExt() {
        return realMcEnExt;
    }

    public void setRealMcEnExt(String realMcEnExt) {
        this.realMcEnExt = realMcEnExt;
    }

    public String getRealMcCaDes() {
        return realMcCaDes;
    }

    public void setRealMcCaDes(String realMcCaDes) {
        this.realMcCaDes = realMcCaDes;
    }

    public String getRealMcCaAlm() {
        return realMcCaAlm;
    }

    public void setRealMcCaAlm(String realMcCaAlm) {
        this.realMcCaAlm = realMcCaAlm;
    }

    public String getRealMcCaTard() {
        return realMcCaTard;
    }

    public void setRealMcCaTard(String realMcCaTard) {
        this.realMcCaTard = realMcCaTard;
    }

    public String getRealMcCaCena() {
        return realMcCaCena;
    }

    public void setRealMcCaCena(String realMcCaCena) {
        this.realMcCaCena = realMcCaCena;
    }
}
