/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Organization;

import Model.Role.HealthRole;
import Model.Role.Role;
import java.util.ArrayList;
/**
 *
 * @author Mrinalini
 */
public class HealthOrg extends Organisation{
    public HealthOrg() {
        super(Organisation.Type.Health.getOrgType());
    }
    
    @Override
    public ArrayList<Role> getRoleList() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new HealthRole());
        return roles;
    }
}
