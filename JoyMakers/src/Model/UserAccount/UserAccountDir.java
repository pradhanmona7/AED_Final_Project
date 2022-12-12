/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.UserAccount;

import Model.Employee.Employee;
import Model.Employee.Volunteer;
import static Model.Organization.Organisation.Type.Volunteer;
import Model.Role.Role;
import java.util.ArrayList;
/**
 *
 * @author Mrinalini
 */
public class UserAccountDir {
    private ArrayList<UserAccount> userAccList;

    public ArrayList<UserAccount> getUserAccList() {
        return userAccList;
    }

    public void setUserAccList(ArrayList<UserAccount> userAccList) {
        this.userAccList = userAccList;
    }

    public UserAccountDir() {
        userAccList = new ArrayList();
    }
    
    public UserAccount authentication(String uname, String pwd){
        for (UserAccount userAcc : userAccList)
            if (userAcc.getUname().equals(uname) && userAcc.getPwd().equals(pwd)){
                return userAcc;
            }
        return null;
    }
    
    public UserAccount createAccount(String uname, String pwd, Employee emp, Role role){
        UserAccount ua = new UserAccount();
        ua.setUname(uname);
        ua.setPwd(pwd);
        ua.setEmp(emp);
        ua.setRole(role);
        userAccList.add(ua);
        return ua;
    }
    
    public UserAccount createAccount(String uname, String pwd, Volunteer vol, Role role){
        UserAccount ua = new UserAccount();
        ua.setUname(uname);
        ua.setPwd(pwd);
        ua.setEmp(vol);
        ua.setRole(role);
        userAccList.add(ua);
        return ua;
    }
    
    public boolean UniqueUsername(String uname){
        for (UserAccount user : userAccList){
            if (user.getUname().equals(uname))
                return false;
        }
        return true;
    }
}
