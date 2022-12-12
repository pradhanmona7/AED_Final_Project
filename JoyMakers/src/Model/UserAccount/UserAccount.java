/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.UserAccount;

import Model.Employee.Employee;
import Model.Employee.Volunteer;
import static Model.Organization.Organisation.Type.Volunteer;
import Model.Medicare;
import Model.Role.Role;
import Model.WorkQueue.WorkQueue;
import Model.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author Mrinalini
 */
public class UserAccount {
    
    private String uname;
    private String pwd;
    private Employee emp;
    private Role role;
    private WorkQueue workQueue;
    private List<Medicare> medicalHistory;
    private List<Medicare> medList;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
    public Volunteer getVolunteer() {
        return (Volunteer) emp;
    }

    public List<Medicare> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<Medicare> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public List<Medicare> getMedList() {
        return medList;
    }

    public void setMedList(List<Medicare> medList) {
        this.medList = medList;
    }
    
    public UserAccount() {
        workQueue = new WorkQueue();
        medList = new ArrayList<Medicare>();
        medicalHistory = new ArrayList<Medicare>();
    }

    @Override
    public String toString() {
        return emp.getName();
    }
    
    public boolean checkUniqueRequest(WorkRequest workreq){
        for(WorkRequest wr : workQueue.getWrList()){
            if(wr == workreq){
                return true;
            }  
        }
        return false;
    }
}
