/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.TutorOrg;
import Business.Organization.StorageOrg;
import Business.Organization.Organisation;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import UI.TutorRole.TutorPanel;
import UI.StorageRole.StoragePanel;

/**
 *
 * @author krishna
 */
public class StorageRole extends Role{
        
    @Override
    public JPanel workPanel(JPanel userProcessContainer, UserAccount acc, Organisation org, Enterprise ent,Network net, EcoSystem system) {
        return new StoragePanel(userProcessContainer, acc, (StorageOrg)org, ent,net);
    }
    
    @Override
    public String toString() {
        return Type.Storage.getType();
    }
}
