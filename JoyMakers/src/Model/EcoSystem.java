/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Network.Network;
import Model.Organization.Organisation;
import Model.Role.Role;
import Model.Role.SysAdminRole;
import java.util.ArrayList;

/**
 *
 * @author monalikapradhan
 */
public class EcoSystem extends Organisation{
     private static EcoSystem system;
    private ArrayList<Network> netList;
    
    public static EcoSystem getInstance(){
        if(system==null){
            system=new EcoSystem();
        }
        return system;
    }
    
    public Network createNetwork(){
        Network net=new Network();
        netList.add(net);
        return net;
    }
    
    @Override
    public ArrayList<Role> getRoleList() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SysAdminRole());
        return roleList;
    }
    
    private EcoSystem(){
        super(null);
        netList=new ArrayList<Network>();
    }

    public ArrayList<Network> getNetList() {
        return netList;
    }

    public void setNetList(ArrayList<Network> netList) {
        this.netList = netList;
    }
    
    public boolean checkUniqueUser(String userName){
        if(!this.getUserAccDir().UniqueUsername(userName)){
            return false;
        }
        return true;
    }
}
