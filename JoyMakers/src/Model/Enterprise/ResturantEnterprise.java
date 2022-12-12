/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Enterprise;

import Model.Role.Role;
import java.util.ArrayList;
/**
 *
 * @author monalikapradhan
 */
public class ResturantEnterprise extends Enterprise{
    
    public enum Type{
       Restaurant("Restaurant Organization");
        private String type;
        public String getType() {
            return type;
        }

        private Type(String type) {
            this.type = type;
        }
    }
    
    public ResturantEnterprise(String name){
        super(name,EntType.Resturant);
    }
    @Override
    public ArrayList<Role> getRoleList() {
        return null;
    }  
}
