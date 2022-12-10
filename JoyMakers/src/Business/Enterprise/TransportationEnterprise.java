/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author monalikapradhan
 */
public class TransportationEnterprise extends Enterprise{
    
    public enum Type{
       Transport("Transport Organization");
        private String type;

        public String getType() {
            return type;
        }

        private Type(String type) {
            this.type = type;
        }

    }
    
    public TransportationEnterprise(String name){
        super(name, EntType.Transpotation);
    }
    @Override
    public ArrayList<Role> getRoleList() {
        return null;
    }
}
