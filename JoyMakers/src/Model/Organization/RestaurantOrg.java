/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Organization;

import java.util.ArrayList;
import Model.Role.Role;
import Model.Role.RestaurantRole;

/**
 *
 * @author Mrinalini
 */
public class RestaurantOrg extends Organisation{
    public RestaurantOrg(){
        super(Organisation.Type.Restaurant.getOrgType());
    }
    
    @Override
    public ArrayList<Role> getRoleList(){
       ArrayList<Role> role = new ArrayList();
       role.add(new RestaurantRole() );
       return role;
    }
}
