/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.FoodCare;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author monalikapradhan
 */
public class VolunteerRestaurantWorkRequest extends WorkRequest{
    private int id;
    public static int count=1;
    private List<FoodCare> foodList = null;

    public List<FoodCare> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<FoodCare> foodList) {
        this.foodList = foodList;
    }
    private String pinCode=null;
    private String address=null;
    private String ngoName=null;
    private String message=null;    
    private String restAdd=null;
    private String recieverAdd=null;
    private String restNo=null;
    private String recieverNo=null;
    private String deliveryNo=null;
    private UserAccount delivery=null;
    private Date pickupDate=null;
    private Date expectedDelivery=null;
    private String quantity = null;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

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
        VolunteerRestaurantWorkRequest.count = count;
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

    public String getNgoName() {
        return ngoName;
    }

    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRestAdd() {
        return restAdd;
    }

    public void setRestAdd(String restAdd) {
        this.restAdd = restAdd;
    }

    public String getRecieverAdd() {
        return recieverAdd;
    }

    public void setRecieverAdd(String recieverAdd) {
        this.recieverAdd = recieverAdd;
    }

    public String getRestNo() {
        return restNo;
    }

    public void setRestNo(String restNo) {
        this.restNo = restNo;
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
    public VolunteerRestaurantWorkRequest(){
        super();
        id = count;
        count++;
    }
   
    @Override
    public String toString(){
        return id+"";
    }
}
