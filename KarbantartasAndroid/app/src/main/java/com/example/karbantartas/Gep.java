package com.example.karbantartas;

public class Gep {
    private String azonosito;
    private String helyszin;
    private String varos;
    private String cim;
    private String kesz;
    private String utolsoKarb;

    public Gep(String azonosito, String helyszin, String varos, String cim, String kesz, String utolsoKarb) {
        this.azonosito = azonosito;
        this.helyszin = helyszin;
        this.varos = varos;
        this.cim = cim;
        this.kesz = kesz;
        this.utolsoKarb = utolsoKarb;
    }
    public String getAzonosito() {
        return azonosito;
    }

    public void setAzonosito(String azonosito) {
        this.azonosito = azonosito;
    }

    public String getHelyszin() {
        return helyszin;
    }

    public void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getKesz() {
        return kesz;
    }

    public void setKesz(String kesz) {
        this.kesz = kesz;
    }

    public String getUtolsoKarb() {
        return utolsoKarb;
    }

    public void setUtolsoKarb(String utolsoKarb) {
        this.utolsoKarb = utolsoKarb;
    }

}
