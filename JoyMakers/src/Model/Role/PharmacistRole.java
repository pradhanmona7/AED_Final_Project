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
import Model.Organization.PharmacyOrg;
import Model.UserAccount.UserAccount;
import javax.swing.JPanel;
import UI.PharmacistRole.PharmacistPanel;
/**
 *
 * @author krishna
 */
public class PharmacistRole extends Role{
    @Override
    public JPanel workPanel(JPanel userProcessContainer, UserAccount acc, Organisation org, Enterprise ent, Network net, EcoSystem system) {
        return new PharmacistPanel(userProcessContainer,acc,(PharmacyOrg)org,net,ent);
    }
    
    @Override
    public String toString() {
        return Type.Pharmacy.getType();
    }
}
