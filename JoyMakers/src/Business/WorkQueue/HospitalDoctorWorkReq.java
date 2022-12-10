/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Date;

/**
 *
 * @author monalikapradhan
 */
public class HospitalDoctorWorkReq extends WorkRequest{
    private String docType=null;
    private String caseType=null;
    private int noOfPatients;
    private String patientType=null;
    private Date date=null;
    private String time=null;
    private String docName=null;
    private String number;
    private String address=null;

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public int getNoOfPatients() {
        return noOfPatients;
    }

    public void setNoOfPatients(int noOfPatients) {
        this.noOfPatients = noOfPatients;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
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

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        String id = String.valueOf(this.docType);//To change body of generated methods, choose Tools | Templates.
        return id;
    }
}
