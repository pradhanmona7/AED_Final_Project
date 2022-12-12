/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Role;

import Model.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.Network.Network;
import Model.Organization.HealthOrg;
import Model.Organization.Organisation;
import Model.UserAccount.UserAccount;
import javax.swing.JPanel;
import UI.HealthRole.DoctorWorkAreaJPanel;
import UI.HealthRole.HospitalDeptJPanel;
/**
 *
 * @author krishna
 */
public class HealthRole extends Role{
    @Override
    public JPanel workPanel(JPanel userProcessContainer, UserAccount acc,Organisation  org, Enterprise ent, Network net, EcoSystem system) {
        return new HospitalDeptJPanel(userProcessContainer, acc, (HealthOrg) org, ent, net);
    }
    
     @Override
    public String toString() {
        return Type.Health.getType();
    }
}
