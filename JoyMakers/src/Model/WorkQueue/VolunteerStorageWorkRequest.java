/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.WorkQueue;

import Model.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author monalikapradhan
 */
public class VolunteerStorageWorkRequest extends WorkRequest{
    private ArrayList<String> category=null;
    private ArrayList<Integer> quantity=null;
    private ArrayList<String> description=null;
    private Date pickupDate=null;
    private Date expectedDelivery=null;
    private static int cnt=0;
    private int ordID=0;
    private String senderAddress=null;
    private String recieverAddress=null;
    private String senderNumber=null;
    private String recieverNumber=null;
    private String deliveryNumber=null;
    private UserAccount delivery=null;

    public ArrayList<String> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
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

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        VolunteerStorageWorkRequest.cnt = cnt;
    }

    public int getOrdID() {
        return ordID;
    }

    public void setOrdID(int ordID) {
        this.ordID = ordID;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getRecieverAddress() {
        return recieverAddress;
    }

    public void setRecieverAddress(String recieverAddress) {
        this.recieverAddress = recieverAddress;
    }

    public String getSenderNumber() {
        return senderNumber;
    }

    public void setSenderNumber(String senderNumber) {
        this.senderNumber = senderNumber;
    }

    public String getRecieverNumber() {
        return recieverNumber;
    }

    public void setRecieverNumber(String recieverNumber) {
        this.recieverNumber = recieverNumber;
    }

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public UserAccount getDelivery() {
        return delivery;
    }

    public void setDelivery(UserAccount delivery) {
        this.delivery = delivery;
    }
    
    public VolunteerStorageWorkRequest() {
        category= new ArrayList();
        quantity = new ArrayList();
        description = new ArrayList();
        ++cnt;
        ordID = cnt;
    }
    
    public String toString() {
        String id = String.valueOf(this.ordID);//To change body of generated methods, choose Tools | Templates.
        return id;
    }
}
