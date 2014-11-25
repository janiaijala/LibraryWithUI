/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjastographui;

import java.time.LocalDateTime;

/**
 *
 * @author Jani-Meiju
 */
public class CD extends TeosInfo{
    private String kplMaara;

    public String getKplMaara() {
        return kplMaara;
    }

    public void setKplMaara(String kplMaara) {
        this.kplMaara = kplMaara;
    }

    @Override
    public String tulosta(TeosInfo teos) {
        return ("Teoksen nimi: " +teos.getTeoksenNimi() + "\n" +
                "Valmistusvuosi: " +teos.getVuosi() + "\n" +
                "Tekija: " + teos.getTekija() + "\n" + 
                "ISBN: " + teos.getISBN() + "\n" +
                "Raitojen määrä: " + this.getKplMaara() + "\n" +
                "Kirja lainassa: " + teos.isLainattu() +"\n"+
                "Lainan eräpäivä: " + teos.getLainaLoppu() + "\n");
    }

    @Override
    public void lainaaTeos() {
        this.setLainattu(true);
        this.setLainaAlku(LocalDateTime.now());
        this.setLainaLoppu(this.getLainaAlku().plusMonths(1));}
    
}
