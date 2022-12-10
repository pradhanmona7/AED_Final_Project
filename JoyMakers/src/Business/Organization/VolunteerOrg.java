/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.VolunteerRole;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;
/**
 *
 * @author Mrinalini
 */
public class VolunteerOrg extends Organisation{
    private WorkQueue donate;
    public VolunteerOrg() {
         super(Organisation.Type.Volunteer.getOrgType());
         donate = new WorkQueue();
    }
    
    @Override
    public ArrayList<Role> getRoleList() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new VolunteerRole());
        return roles;
    }
}
