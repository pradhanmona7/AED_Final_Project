/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Role;

import Model.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.Network.Network;
import Model.Organization.Organisation;
import Model.UserAccount.UserAccount;
import javax.swing.JPanel;
/**
 *
 * @author krishna
 */
public abstract class Role {
    
    public enum Type{
        Admin("Admin Role"),
        Doctor("Doctor Role"),
        Health("Health Role"),
        Pharmacy("Pharmacy Role"),
        Storage("Storage Role"),
        Transportor("Transportor Role"),
        Tutor("Tutor Role"),
        Restaurant("Restaurant Role"),
        Volunteer("Volunteer Role");
        
        private String type;

        public String getType() {
            return type;
        }

        private Type(String type) {
            this.type = type;
        }


        @Override
        public String toString() {
            return type;
        }
    }
    
    public abstract JPanel workPanel(JPanel userProcessContainer,UserAccount acc,Organisation org,Enterprise ent,Network net,EcoSystem system);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
