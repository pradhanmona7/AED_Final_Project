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
import UI.AdminRole.AdminWorkAreaJPanel;
import javax.swing.JPanel;
/**
 *
 * @author krishna
 */
public class AdminRole extends Role{
    @Override
    public JPanel workPanel(JPanel userProcessContainer, UserAccount acc, Organisation org, Enterprise ent,Network net, EcoSystem system) {
        return new AdminWorkAreaJPanel(userProcessContainer,net, ent);
    }
    
     @Override
    public String toString() {
        return Type.Admin.getType();
    }

}
