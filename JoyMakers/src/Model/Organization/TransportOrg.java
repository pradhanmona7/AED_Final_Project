/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Organization;

import Model.Role.Role;
import Model.Role.TransportorRole;
//import Business.Role.VolunteerRole;
import java.util.ArrayList;
/**
 *
 * @author Mrinalini
 */
public class TransportOrg extends Organisation{
    public TransportOrg() {
        super(Organisation.Type.Transport.getOrgType());
    }
    
    @Override
    public ArrayList<Role> getRoleList() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new TransportorRole());
        return roles;
    }
}
