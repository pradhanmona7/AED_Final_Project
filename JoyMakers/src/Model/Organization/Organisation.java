/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Organization;

import Model.Employee.EmployeeDirectory;
import Model.Role.Role;
import Model.UserAccount.UserAccountDir;
import Model.WorkQueue.WorkQueue;
import java.util.ArrayList;
/**
 *
 * @author Mrinalini
 */
public abstract class Organisation {
    
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory empDir;
    private UserAccountDir userAccDir;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
    public EmployeeDirectory getEmpDir() {
        return empDir;
    }

    public UserAccountDir getUserAccDir() {
        return userAccDir;
    }

    public int getOrgID() {
        return orgID;
    }
    private int orgID;
    private static int cnt=0;
    
    
    public enum Type{
        Admin("Admin Organization"), Doctor("Doctor Organization"), Pharmacy("Pharmacy Organization"),
        Transport("Transport Organization"), Hotel("Hotel Organization"), Storage("Storage Organization"),
        Health("Health Organization"), Volunteer("Volunteer Organization"), Restaurant("Restaurant Organization"),Tutor("Tutor Organization");
        
        private String orgType;

        public String getOrgType() {
            return orgType;
        }

        private Type(String orgType) {
            this.orgType = orgType;
        }
        

    }

    public Organisation(String name) {
        this.name = name; 
        workQueue = new WorkQueue();
        empDir = new EmployeeDirectory();
        userAccDir = new UserAccountDir();
        orgID = cnt;
        ++cnt;
    }

    public abstract ArrayList<Role> getRoleList();

    @Override
    public String toString() {
        return name;
    }
}
