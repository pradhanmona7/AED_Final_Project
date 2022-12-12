/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.WorkQueue;

/**
 *
 * @author monalikapradhan
 */
public class LaboratoryTestWorkReq extends WorkRequest{
    private String Result;

    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }
}
