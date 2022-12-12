/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Organization;

import Model.Role.HealthRole;
import Model.Role.StorageRole;
import Model.Role.Role;
import java.util.ArrayList;
/**
 *
 * @author Mrinalini
 */
public class StorageOrg extends Organisation{
    public StorageOrg() {
        super(Organisation.Type.Storage.getOrgType());
    }
    
    @Override
    public ArrayList<Role> getRoleList() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new StorageRole());
        return roles;
    }
}
