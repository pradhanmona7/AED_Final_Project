/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;


import Business.UserAccount.UserAccount;
import java.util.Date;
/**
 *
 * @author monalikapradhan
 */
public class WorkRequest {
    
    private String message=null;
    private UserAccount sender=null;
    private UserAccount receiver=null;
    private String status=null;
    private Date reqDate=null;
    private Date resDate=null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }
    
   public WorkRequest(){
        reqDate = new Date();
    }
}
