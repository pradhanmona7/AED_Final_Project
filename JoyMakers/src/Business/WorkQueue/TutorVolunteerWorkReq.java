/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author monalikapradhan
 */
public class TutorVolunteerWorkReq extends WorkRequest{
    private String Title;
    private Date date;
    private String time;
    private String address;
    private String area;
    private int numOfStudents;
    private String numOfhours;
    private int numOfVolunteers;
    private int vacancy;
    private ArrayList<UserAccount> usersList;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }

    public String getNumOfhours() {
        return numOfhours;
    }

    public void setNumOfhours(String numOfhours) {
        this.numOfhours = numOfhours;
    }

    public int getNumOfVolunteers() {
        return numOfVolunteers;
    }

    public void setNumOfVolunteers(int numOfVolunteers) {
        this.numOfVolunteers = numOfVolunteers;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public ArrayList<UserAccount> getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList<UserAccount> usersList) {
        this.usersList = usersList;
    }
    
    public TutorVolunteerWorkReq(){
        usersList = new ArrayList<UserAccount>(); 
    }   
    
    
    @Override
    public String toString() {
        String id = String.valueOf(this.Title);//To change body of generated methods, choose Tools | Templates.
        return id;
    }
}
