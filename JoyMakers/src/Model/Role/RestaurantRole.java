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
import Model.Organization.RestaurantOrg;
import Model.UserAccount.UserAccount;
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
