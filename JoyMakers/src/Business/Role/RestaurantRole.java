/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organisation;
import Business.Organization.RestaurantOrg;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import UI.RestaurantRole.RestaurantPanel;

/**
 *
 * @author krishna
 */
public class RestaurantRole extends Role{

        @Override
    public JPanel workPanel(JPanel userProcessContainer, UserAccount acc, Organisation org, Enterprise ent, Network net, EcoSystem system) {
        return new RestaurantPanel(userProcessContainer,acc,(RestaurantOrg)org,net,ent);
    }
    
    @Override
    public String toString() {
        return Type.Restaurant.getType();
    }
}
