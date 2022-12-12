/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;
import java.util.Date;
/**
 *
 * @author monalikapradhan
 */
public class Medicare {
    private String med_name;
    private int med_quantity;
    private LocalDate ordDt;

    public String getMed_name() {
        return med_name;
    }

    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }

    public int getMed_quantity() {
        return med_quantity;
    }

    public void setMed_quantity(int med_quantity) {
        this.med_quantity = med_quantity;
    }

    public LocalDate getOrdDt() {
        return ordDt;
    }

    public void setOrdDt(LocalDate ordDt) {
        this.ordDt = ordDt;
    }
    
        
    public Medicare(String name, int quantity, LocalDate ordDate){
        this.med_name = name;
        this.med_quantity = quantity;
        this.ordDt = ordDate;
    }
    
        
    @Override
    public String toString(){
        return med_name;
    }
}
