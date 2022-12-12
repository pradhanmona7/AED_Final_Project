/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Employee;

import Model.Organization.Organisation;
import Model.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author krishna
 */
public class Volunteer  extends Employee{
    private String address = null;
    private String pincode=null;
    private String engProficent=null;
    private ArrayList<String> languages = new ArrayList();
    private ArrayList<String> skillList = new ArrayList();
    private String degree=null;
    private ArrayList<String> expertise = new ArrayList();
    private String skills=null;
    private Map<String, String> eduList = new HashMap<String, String>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getEngProficent() {
        return engProficent;
    }

    public void setEngProficent(String engProficent) {
        this.engProficent = engProficent;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public ArrayList<String> getSkillList() {
        return skillList;
    }

    public void setSkillList(ArrayList<String> skillList) {
        this.skillList = skillList;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public ArrayList<String> getExpertise() {
        return expertise;
    }

    public void setExpertise(ArrayList<String> expertise) {
        this.expertise = expertise;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Map<String, String> getEduList() {
        return eduList;
    }

    public void setEduList(Map<String, String> eduList) {
        this.eduList = eduList;
    }

}
