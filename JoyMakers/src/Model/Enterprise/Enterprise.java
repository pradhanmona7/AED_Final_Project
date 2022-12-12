/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Enterprise;

import Model.Organization.Organisation;
import Model.Organization.OrganisationDirectory;
/**
 *
 * @author monalikapradhan
 */
public abstract class Enterprise  extends Organisation{
    
    private EntType entType;
    private OrganisationDirectory orgDir;

    public EntType getEntType() {
        return entType;
    }

    public void setEntType(EntType entType) {
        this.entType = entType;
    }
    
    public OrganisationDirectory getOrgDir() {
        return orgDir;
    }
    
    public enum EntType{
        Hospital("Hospital"), 
        NGO("NGO"),
        Transpotation("Transportation"),
        Resturant("Restaurant");
        
        private String type;

        public String getType() {
            return type;
        }

        private EntType(String type) {
            this.type = type;
        }
 
        @Override
        public String toString(){
        return type;
    }
    }
    
    public Enterprise(String name,EntType type){
        super(name);
        this.entType=type;
        orgDir=new OrganisationDirectory();
    }
}
