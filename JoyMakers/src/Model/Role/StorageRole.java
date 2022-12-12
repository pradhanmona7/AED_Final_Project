/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Role;

import Model.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.Network.Network;
import Model.Organization.TutorOrg;
import Model.Organization.StorageOrg;
import Model.Organization.Organisation;
import Model.UserAccount.UserAccount;
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
