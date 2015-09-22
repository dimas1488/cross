/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kroos_platf_lab1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Димас
 */
public class Obrabotchik {
     private static ControllerSql kontr=null;
    
     public static void main (String ... arw) throws SQLException{
        System.out.println("Оберіть довідник:");
        System.out.println("1) Будинки.");
        System.out.println("2) Мешканці");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n==1){
            try {
              kontr = new ControllerSql(new My_conn("org.sqlite.JDBC", "jdbc:sqlite:Comunalka.sqlite").getCon());
              ResultSet  rs=kontr.readHouse();
              while(rs.next()){
               int id = rs.getInt(1);
               String numberHouse = rs.getString(2);
               String street = rs.getString(3);
               String city = rs.getString(4);
               House house =  new House(id,numberHouse,street,city);
                  System.out.println(house.toString());
              }
                   } catch (SQLException ex) {
            Logger.getLogger(Obrabotchik.class.getName()).log(Level.SEVERE, null, ex);
        }
             System.out.println("Оберіть дію:");
        System.out.println("1) Створити запис.");
        System.out.println("2) Видалити запис");
        System.out.println("3) Змінити запис");
        System.out.println("4) Читати запис");
        scan = new Scanner(System.in);
        n = scan.nextInt();
            if(n==1){
             try {
              kontr = new ControllerSql(new My_conn("org.sqlite.JDBC", "jdbc:sqlite:Comunalka.sqlite").getCon());
                System.out.println("Введіть id:");
                int id  = scan.nextInt();
                System.out.println("Введіть Номер:");
                String number  = scan.next();
                System.out.println("Введіть Вулицю:");
                String street  = scan.next();
                System.out.println("Введіть Місто:");
                String city  = scan.next();
                House house  = new House(id, number, street, city);
                kontr.createHouse(house);
                   } catch (SQLException ex) {
            Logger.getLogger(Obrabotchik.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
            else if(n==2){
                kontr = new ControllerSql(new My_conn("org.sqlite.JDBC", "jdbc:sqlite:Comunalka.sqlite").getCon());
                System.out.println("Введіть id:");
                int id  = scan.nextInt();
                kontr.deleteHouse(id);
            }
              else if(n==3){
                kontr = new ControllerSql(new My_conn("org.sqlite.JDBC", "jdbc:sqlite:Comunalka.sqlite").getCon());
                System.out.println("Введіть id будинку, який змінюємо:");
                int id  = scan.nextInt();
                System.out.println("Введіть новий id будинку:");
                int id1  = scan.nextInt();
                System.out.println("Введіть Номер:");
                String number  = scan.next();
                System.out.println("Введіть Вулицю:");
                String street  = scan.next();
                System.out.println("Введіть Місто:");
                String city  = scan.next();
                House house  = new House(id1, number, street, city);
                kontr.updateHouse(house,id);
              }
             else if(n==4){
            try {
              kontr = new ControllerSql(new My_conn("org.sqlite.JDBC", "jdbc:sqlite:Comunalka.sqlite").getCon());
                System.out.println("Введіть id:");
                int id  = scan.nextInt();
                ResultSet rs = kontr.readHouse(id);
                 while(rs.next()){
                id = rs.getInt(1);
               String numberHouse = rs.getString(2);
               String street = rs.getString(3);
               String city = rs.getString(4);
               House house =  new House(id,numberHouse,street,city);
                  System.out.println(house.toString());
              }
                   } catch (SQLException ex) {
            Logger.getLogger(Obrabotchik.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            }
            }
             
            
            
        else if(n==2){
         try {
              kontr = new ControllerSql(new My_conn("org.sqlite.JDBC", "jdbc:sqlite:Comunalka.sqlite").getCon());
              ResultSet  rs=kontr.readInhabitant();
              while(rs.next()){
               int idInhab = rs.getInt(1);
               int idHouse = rs.getInt(2);
               String name = rs.getString(3);
               String surname = rs.getString(4);
               int age = rs.getInt(5);
               String pol = rs.getString(6);
               Inhabitant inhab =  new Inhabitant(idInhab,idHouse,name,surname,age,pol);
               System.out.println( inhab.toString());
              }
                   } catch (SQLException ex) {
            Logger.getLogger(Obrabotchik.class.getName()).log(Level.SEVERE, null, ex);
        }
         
               System.out.println("Оберіть дію:");
        System.out.println("1) Створити запис.");
        System.out.println("2) Видалити запис");
        System.out.println("3) Змінити запис");
        System.out.println("4) Читати запис");
        System.out.println("5) Знайти запис");
        scan = new Scanner(System.in);
        n = scan.nextInt();
            if(n==1){
             try {
              kontr = new ControllerSql(new My_conn("org.sqlite.JDBC", "jdbc:sqlite:Comunalka.sqlite").getCon());
                System.out.println("Введіть id жильця:");
                int idinhab  = scan.nextInt();
                System.out.println("Введіть id будинку:");
                int idhouse  = scan.nextInt();
                System.out.println("Введіть імя:");
                String name  = scan.next();
                System.out.println("Введіть прізвище:");
                String surname  = scan.next();
                System.out.println("Введіть вік:");
                int age  = scan.nextInt();
                System.out.println("Введіть стать:");
                String pol  = scan.next();
                Inhabitant inhab  = new Inhabitant(idinhab,idhouse,name,surname,age,pol);
                kontr.createInhabitant(inhab);
                   } catch (SQLException ex) {
            Logger.getLogger(Obrabotchik.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
            else if(n==2){
                kontr = new ControllerSql(new My_conn("org.sqlite.JDBC", "jdbc:sqlite:Comunalka.sqlite").getCon());
                System.out.println("Введіть id:");
                int id  = scan.nextInt();
                kontr.deleteInhabitant(id);
            }
              else if(n==3){
             kontr = new ControllerSql(new My_conn("org.sqlite.JDBC", "jdbc:sqlite:Comunalka.sqlite").getCon());
                System.out.println("Введіть id жильця, який змінюємо:");
                int idinhab  = scan.nextInt();
                System.out.println("Введіть новий id жильця:");
                int idinhab1  = scan.nextInt();
                System.out.println("Введіть id будинку:");
                int idhouse  = scan.nextInt();
                System.out.println("Введіть імя:");
                String name  = scan.next();
                System.out.println("Введіть прізвище:");
                String surname  = scan.next();
                System.out.println("Введіть вік:");
                int age  = scan.nextInt();
                System.out.println("Введіть стать:");
                String pol  = scan.next();
                Inhabitant inhab  = new Inhabitant(idinhab1,idhouse,name,surname,age,pol);
                kontr.updateInhabitant(inhab,idinhab);
            }
              else if(n==4){
            try {
              kontr = new ControllerSql(new My_conn("org.sqlite.JDBC", "jdbc:sqlite:Comunalka.sqlite").getCon());
                System.out.println("Введіть id:");
                int id  = scan.nextInt();
                ResultSet rs = kontr.readInhabitant(id);
                 while(rs.next()){
               int idInhab = rs.getInt(1);
               int idHouse = rs.getInt(2);
               String name = rs.getString(3);
               String surname = rs.getString(4);
               int age = rs.getInt(5);
               String pol = rs.getString(6);
               Inhabitant inhab =  new Inhabitant(idInhab,idHouse,name,surname,age,pol);
               System.out.println( inhab.toString());
              }
                   } catch (SQLException ex) {
            Logger.getLogger(Obrabotchik.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
              else if(n==5){
             try {
              kontr = new ControllerSql(new My_conn("org.sqlite.JDBC", "jdbc:sqlite:Comunalka.sqlite").getCon());
              System.out.println("Якщо характеристика не цікавить введіть 0:");
              String query= "Select * from Inhabitant where ";
                System.out.println("Введіть  id жильця:");
                int idinhab1  = scan.nextInt();
                if(idinhab1!=0){
                    query+= "Idinhab = "+idinhab1;
                }
                System.out.println("Введіть id будинку:");
                int idhouse  = scan.nextInt();
                 if(idhouse!=0){
                    query+= " and Ihouse = "+idhouse;
                }
                System.out.println("Введіть імя:");
                String name  = scan.next();
                 if(!name.equals("0")){
                    query+= " and Name = "+name;
                }
                System.out.println("Введіть прізвище:");
                String surname  = scan.next();
                if(!surname.equals("0")){
                    query+= " and Surname = "+surname;
                }
                System.out.println("Введіть вік:");
                int age  = scan.nextInt();
                if(age!=0){
                    query+= "Age = "+age;
                }
                System.out.println("Введіть стать:");
                String pol  = scan.next();
                if(!pol.equals("0")){
                    query+= " and Pol = "+pol;
                }
                ResultSet  rs=kontr.serchInhabitant(query);
                 while(rs.next()){
               int idInhab = rs.getInt(1);
               int idHouse = rs.getInt(2);
                name = rs.getString(3);
                surname = rs.getString(4);
                age = rs.getInt(5);
                pol = rs.getString(6);
               Inhabitant inhab =  new Inhabitant(idInhab,idHouse,name,surname,age,pol);
               System.out.println( inhab.toString());
              }
              }
                    catch (SQLException ex) {
            Logger.getLogger(Obrabotchik.class.getName()).log(Level.SEVERE, null, ex);
        }
      
}
     
     }
        }
}
