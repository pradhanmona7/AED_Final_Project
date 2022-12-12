/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Organization;

import Model.Enterprise.ResturantEnterprise;
import Model.Enterprise.HospitalEnterprise;
import Model.Enterprise.TransportationEnterprise;
import Model.Enterprise.NGOEnterprise;
import Model.Organization.Organisation.Type;
import java.util.ArrayList;
/**
 *
 * @author Mrinalini
 */
public class OrganisationDirectory {
    private ArrayList<Organisation> orgList;

    public ArrayList<Organisation> getOrgList() {
        return orgList;
    }
    
    public OrganisationDirectory() {
        orgList = new ArrayList();
    }
    
    public Organisation createHospOrg(HospitalEnterprise.Type type){
        Organisation org = null;
        if (type.getType().equals(Type.Doctor.getOrgType())){
            org = new DoctorOrg();
            orgList.add(org);
        }
        else if (type.getType().equals(Type.Pharmacy.getOrgType())){
            
            org = new PharmacyOrg();
            orgList.add(org);
        }
        return org;
    }
    
    public Organisation createNGOOrg(NGOEnterprise.Type type){
        Organisation org = null;
        System.out.println("====calling----");
        if (type.getType().equals(Type.Health.getOrgType())){
            System.out.println("====health");
            org = new HealthOrg();
            orgList.add(org);
        }
        else if (type.getType().equals(Type.Tutor.getOrgType())){
                        System.out.println("====tutor");
            org = new TutorOrg();
            orgList.add(org);
        }
        else if (type.getType().equals(Type.Volunteer.getOrgType())){
                        System.out.println("====vol");

            org = new VolunteerOrg();
            orgList.add(org);
        }
        else if (type.getType().equals(Type.Storage.getOrgType())){
                        System.out.println("====storagr");

            org = new StorageOrg();
            orgList.add(org);
        }
        return org;
    }
     
    public Organisation createRestaurantOrg(ResturantEnterprise.Type type){
        Organisation org = null;
        if(type.getType().equals(Type.Restaurant.getOrgType())){
            org = new RestaurantOrg();
            orgList.add(org);
        }
        return org;
    }
    
    public Organisation createLTranportationOrg(TransportationEnterprise.Type type){
        Organisation org = null;
        if(type.getType().equals(Type.Transport.getOrgType())){
            org = new TransportOrg();
            orgList.add(org);
        }
        return org;
    }
}
