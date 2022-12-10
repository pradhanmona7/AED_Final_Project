/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrg;
import Business.Organization.Organisation;
import Business.UserAccount.UserAccount;
import UI.DoctorRole.DoctorPanel;
import javax.swing.JPanel;
/**
 *
 * @author krishna
 */
public class DoctorRole extends Role{
    @Override
    public JPanel workPanel(JPanel userProcessContainer, UserAccount acc, Organisation org, Enterprise ent, Network net, EcoSystem system) {
        return new DoctorPanel(userProcessContainer, acc, (DoctorOrg)org, ent, net);

    }
    
     @Override
    public String toString() {
        return Type.Doctor.getType();
    }
}
