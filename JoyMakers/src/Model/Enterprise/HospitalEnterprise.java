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
public class HospitalEnterprise extends Enterprise{
    
    public enum Type{
       Doctor("Doctor Organization"), Pharmacy("Pharmacy Organization");
        private String type;

        public String getType() {
            return type;
        }

        private Type(String type) {
            this.type = type;
        }
    }
    public HospitalEnterprise(String name){
        super(name,EntType.Hospital);
    }
    @Override
    public ArrayList<Role> getRoleList() {
        return null;
    }
}
