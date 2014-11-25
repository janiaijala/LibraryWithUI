/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjastographui;

import java.time.LocalDateTime;
import javafx.scene.control.TextField;

/**
 *
 * @author Jani-Meiju
 */
abstract class TeosInfo {
    private String teoksenNimi;
    private String vuosi;    
    private String tekija;
    private String ISBN;
    protected LocalDateTime lainaAlku;
    protected LocalDateTime lainaLoppu;
    private boolean lainattu;
    private boolean varaus;
    
    public abstract String tulosta(TeosInfo teos);
    public abstract void lainaaTeos();

    public LocalDateTime getLainaAlku() {
        return lainaAlku;
    }

    public void setLainaAlku(LocalDateTime lainaAlku) {
        this.lainaAlku = lainaAlku;
    }

    public LocalDateTime getLainaLoppu() {
        return lainaLoppu;
    }

    public void setLainaLoppu(LocalDateTime lainaLoppu) {
        this.lainaLoppu = lainaLoppu;
    }

    public boolean isLainattu() {
        return lainattu;
    }

    public void setLainattu(boolean lainattu) {
        this.lainattu = lainattu;
    }

    public boolean isVaraus() {
        return varaus;
    }

    public void setVaraus(boolean varaus) {
        this.varaus = varaus;
    }

    public String getTeoksenNimi() {
        return teoksenNimi;
    }

    public void setTeoksenNimi(String teoksenNimi) {
        this.teoksenNimi = teoksenNimi;
    }

    public String getVuosi() {
        return vuosi;
    }

    public void setVuosi(String vuosi) {
        this.vuosi = vuosi;
    }

    public String getTekija() {
        return tekija;
    }

    public void setTekija(String tekija) {
        this.tekija = tekija;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    
}
