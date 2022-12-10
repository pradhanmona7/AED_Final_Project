/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
/**
 *
 * @author krishna
 */
public class Employee {
    private int id;
    private static int cnt = 1;
    
    private String name;
    private String sex;
    private String phNo;
    private LocalDate dob = LocalDate.now();
    private String email;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public enum Type{
        Volunteer("Volunteer");
        
        private String empType;

        public String getEmpType() {
            return empType;
        }

        private Type(String empType) {
            this.empType = empType;
        }
 
    }

    public Employee() {
        id = cnt;
        cnt++;
    }
    
    public int ageCalculator(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
    @Override
    public String toString() {
        return name;
    }
}
