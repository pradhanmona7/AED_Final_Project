/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Organization;

import Model.Role.DoctorRole;
import Model.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Mrinalini
 */
public class DoctorOrg extends Organisation{
        public DoctorOrg() {
        super(Organisation.Type.Doctor.getOrgType());
    }
    
    @Override
    public ArrayList<Role> getRoleList() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DoctorRole());
        return roles;
    }
}
