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
public class Inhabitant {
    int idInhabitant;
    int idHouse;
    String name;
    String surname;
    int age;
    String pol;
    
    
    public Inhabitant(int idInhabitant,int idHouse,String name,String surname,int age, String pol){
        this.idInhabitant = idInhabitant;
        this.idHouse = idHouse;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.pol=pol;
    }
    
    
    @Override
    public String toString(){
        return "Inhabitant: "+ " idInhabitant = "+idInhabitant+ ". idHouse = "+idHouse+". name = "+name+". surname = "+surname+". age = "+age+". pol = "+pol;
    }

}
