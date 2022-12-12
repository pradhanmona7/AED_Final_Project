/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Enterprise;

import Model.Organization.OrganisationDirectory;
import java.util.ArrayList;
/**
 *
 * @author monalikapradhan
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> entList;

    public ArrayList<Enterprise> getEntList() {
        return entList;
    }

    public void setEntList(ArrayList<Enterprise> entList) {
        this.entList = entList;
    }
    
    public EnterpriseDirectory(){
        entList=new ArrayList<Enterprise>();
    }
    
    public Enterprise createEnt(String name, Enterprise.EntType type){
        Enterprise ent=null;
        
        if(type==Enterprise.EntType.Hospital){
            ent=new HospitalEnterprise(name);
            entList.add(ent);
        }
        if(type==Enterprise.EntType.NGO){
            ent=new NGOEnterprise(name);
            entList.add(ent);
        }
        if(type==Enterprise.EntType.Transpotation){
            ent=new TransportationEnterprise(name);
            entList.add(ent);
        }

        if(type==Enterprise.EntType.Resturant){
            ent = new ResturantEnterprise(name);
            entList.add(ent);
        }
        return ent;
    }
    

}
