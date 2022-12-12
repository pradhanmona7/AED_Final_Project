/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Employee.Employee;
import Model.Role.SysAdminRole;
import Model.UserAccount.UserAccount;

/**
 *
 * @author monalikapradhan
 */
public class Config {
    public static EcoSystem config(){
        
        EcoSystem sys = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Employee emp = sys.getEmpDir().createEmp("sysadmin");
        
        UserAccount useraccount = sys.getUserAccDir().createAccount("sysadmin", "sysadmin", emp, new SysAdminRole());
        
        return sys;
    }
}