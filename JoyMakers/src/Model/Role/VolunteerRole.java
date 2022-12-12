/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Role;


import Model.EcoSystem;
import Model.Employee.Volunteer;
import Model.Enterprise.Enterprise;
import Model.Network.Network;
import Model.Organization.Organisation;
import Model.UserAccount.UserAccount;
import javax.swing.JPanel;
import UI.VolunteerRole.VolunteerWorkAreaJPanel;
/**
 *
 * @author krishna
 */
public class VolunteerRole extends Role{
        
    @Override
    public JPanel workPanel(JPanel userProcessContainer, UserAccount acc, Organisation org, Enterprise ent,Network net, EcoSystem system) {
       return new VolunteerWorkAreaJPanel(userProcessContainer, acc, org, system, ent,net);   
    }
    
    @Override
    public String toString() {
        return Type.Volunteer.getType();
    }
}
