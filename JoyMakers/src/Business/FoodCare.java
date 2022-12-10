/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import java.time.LocalDate;
import java.util.Date;
/**
 *
 * @author monalikapradhan
 */
public class FoodCare {
    private String food_name;
    private int food_quantity;
    private LocalDate ordDt;

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public int getFood_quantity() {
        return food_quantity;
    }

    public void setFood_quantity(int food_quantity) {
        this.food_quantity = food_quantity;
    }

    public LocalDate getOrdDt() {
        return ordDt;
    }

    public void setOrdDt(LocalDate ordDt) {
        this.ordDt = ordDt;
    }
    
            
    public FoodCare(String name, int quantity, LocalDate ordDate){
        this.food_name = name;
        this.food_quantity = quantity;
        this.ordDt = ordDate;
    }
    
        
    @Override
    public String toString(){
        return food_name;
    }
}
