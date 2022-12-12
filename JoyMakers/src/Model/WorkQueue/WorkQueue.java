/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author monalikapradhan
 */
public class WorkQueue {
    private ArrayList<WorkRequest> wrList;

    public ArrayList<WorkRequest> getWrList() {
        return wrList;
    }
    
    public WorkQueue() {
        wrList = new ArrayList();
    }
    
    public void delRequest(WorkRequest wrRequest){
        wrList.remove(wrRequest);
    }
}
