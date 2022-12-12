/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Organization;

import Model.Role.Role;
import Model.Role.PharmacistRole;
import java.util.ArrayList;

/**
 *
 * @author Mrinalini
 */
public class PharmacyOrg extends Organisation{
    public PharmacyOrg(){
        super(Organisation.Type.Pharmacy.getOrgType());
    }
    
    @Override
    public ArrayList<Role> getRoleList(){
       ArrayList<Role> role = new ArrayList();
       role.add(new PharmacistRole());
       return role;
    }
}
