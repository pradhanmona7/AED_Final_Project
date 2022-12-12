/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.WorkQueue;

import Model.Medicare;
import Model.UserAccount.UserAccount;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
/**
 *
 * @author monalikapradhan
 */
public class HospitalPharmacyWorkReq extends WorkRequest{
    
    private int id;
    public static int count=1;
    private List<Medicare> medList = null;
    private String prescription = null;
    private String street = null;
    private String area=null;
    private String city=null;
    private String state=null;
    private String pinCode=null;
    private String address=null;
    private String ngo=null;
    private String message=null;    
    private String senderAdd=null;
    private String recieverAdd=null;
    private String senderNo=null;
    private String recieverNo=null;
    private String deliveryNo=null;
    private UserAccount delivery=null;
    private Date pickupDate=null;
    private Date expectedDelivery=null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        HospitalPharmacyWorkReq.count = count;
    }

    public List<Medicare> getMedList() {
        return medList;
    }

    public void setMedList(List<Medicare> medList) {
        this.medList = medList;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNgo() {
        return ngo;
    }

    public void setNgo(String ngo) {
        this.ngo = ngo;
    }

    public String getSenderAdd() {
        return senderAdd;
    }

    public void setSenderAdd(String senderAdd) {
        this.senderAdd = senderAdd;
    }

    public String getRecieverAdd() {
        return recieverAdd;
    }

    public void setRecieverAdd(String recieverAdd) {
        this.recieverAdd = recieverAdd;
    }

    public String getSenderNo() {
        return senderNo;
    }

    public void setSenderNo(String senderNo) {
        this.senderNo = senderNo;
    }

    public String getRecieverNo() {
        return recieverNo;
    }

    public void setRecieverNo(String recieverNo) {
        this.recieverNo = recieverNo;
    }

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public UserAccount getDelivery() {
        return delivery;
    }

    public void setDelivery(UserAccount delivery) {
        this.delivery = delivery;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(Date expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public HospitalPharmacyWorkReq(){
        super();
        id = count;
        count++;
    }
   
    @Override
    public String toString(){
        return id+"";
    }
}
