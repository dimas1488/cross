/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kroos_platf_lab1;

/**
 *
 * @author Димас
 */
public class House{
    int idHouse;
    String numberHouse;
    String streetHouse;
    String cityHouse;
    
    
    
    public House(int idHouse,String numberHouse,String streetHouse, String cityHouse){
        this.idHouse = idHouse;
        this.numberHouse = numberHouse;
        this.streetHouse = streetHouse;
        this.cityHouse = cityHouse;
    }
    
    
    @Override
    public String toString(){
        return "House: "+ " idHouse = "+idHouse+ ". numberHouse = "+numberHouse+". streetHouse = "+streetHouse+". cityHouse = "+cityHouse;
    }
}
