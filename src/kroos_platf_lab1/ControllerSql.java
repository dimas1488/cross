/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kroos_platf_lab1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Димас
 */
public class ControllerSql implements HouseDAO,InhabitantDAO{
      private Connection con=null;
    private Statement stmt=null;
public  ControllerSql(Connection con) throws SQLException {
        this.con = con;
        this.stmt=this.con.createStatement();
    }

public ResultSet  searchInhab(String query) throws SQLException{
    return stmt.executeQuery(query);
}

    @Override
    public void createHouse(House house) {
          try {
              String query="INSERT INTO Houses  (\"Idhouse\",\"Nhouse\",\"Street\",\"City\") VALUES (\""+house.idHouse+"\",\""
                      +house.numberHouse+"\",\""+house.streetHouse+"\",\""+house.cityHouse+"\")";
              System.out.println(query);
              int result=this.stmt.executeUpdate(query);
              System.out.println(result);
          } catch (SQLException ex) {
              Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public ResultSet readHouse() {
          try {
              String query="Select * from Houses ";
              System.out.println(query);
             ResultSet rs = this.stmt.executeQuery(query);
             return rs;
          } catch (SQLException ex) {
              Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }

    @Override
    public void updateHouse(House house,int id) {

          try {
              String query="UPDATE Houses Set Idhouse = \""+house.idHouse+"\", Nhouse = \""+house.numberHouse+"\",Street =  \""+house.streetHouse+"\",City =  \""+house.cityHouse+"\" where Idhouse = "+id;
              System.out.println(query);
              this.stmt.executeUpdate(query);
              
          } catch (SQLException ex) {
              Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public void deleteHouse(int id) {
          try {
              String query="delete from Houses where Idhouse= "+String.valueOf(id);
              System.out.println(query);
              int result=this.stmt.executeUpdate(query);
          } catch (SQLException ex) {
              Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public void createInhabitant(Inhabitant inhab) {
                 try {
              String query="INSERT INTO Inhabitant  (\"Idinhab\",\"Idhouse\",\"Name\",\"Surname\",\"Age\",\"Pol\") VALUES (\""+inhab.idInhabitant+"\",\""
                      +inhab.idHouse+"\",\""+inhab.name+"\",\""+inhab.surname+"\",\""+inhab.age+"\",\""+inhab.pol+"\")";
              System.out.println(query);
              int result=this.stmt.executeUpdate(query);
              System.out.println(result);
          } catch (SQLException ex) {
              Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public ResultSet readInhabitant() {
                  try {
              String query="Select * from Inhabitant";
              System.out.println(query);
              ResultSet rs =  this.stmt.executeQuery(query);
              return rs;
          } catch (SQLException ex) {
              Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
          }
                  return null;
    }

    @Override
    public void updateInhabitant(Inhabitant inhab,int id) {
          try {
              String query="UPDATE Inhabitant Set Idinhab = \""+inhab.idInhabitant+"\",Idhouse = \""+inhab.idHouse+"\",  Name = \""+inhab.name+"\",Surname =  \""+inhab.surname+"\",Age =  \""+inhab.age+"\",Pol =  \""+inhab.pol+"\" where Idinhab = "+id;
              System.out.println(query);
              this.stmt.executeUpdate(query);
          } catch (SQLException ex) {
              Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public void deleteInhabitant(int id) {
                try {
              String query="delete from Inhabitant where Idinhab = "+String.valueOf(id);
              System.out.println(query);
              int result=this.stmt.executeUpdate(query);
          } catch (SQLException ex) {
              Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public ResultSet serchInhabitant(String query) {
          try {
              ResultSet rs =  this.stmt.executeQuery(query);
              return rs;
          } catch (SQLException ex) {
              Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
          }
          return  null;
    }

    @Override
    public ResultSet readHouse(int id) {
         try {
              String query="Select * from Houses where Idhouse  = "+ id;
              System.out.println(query);
              ResultSet rs =  this.stmt.executeQuery(query);
              return rs;
          } catch (SQLException ex) {
              Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
          }
                  return null;
    }

    @Override
    public ResultSet readInhabitant(int id) {
         try {
              String query="Select * from Inhabitant where Idinhab  = "+ id;
              System.out.println(query);
              ResultSet rs =  this.stmt.executeQuery(query);
              return rs;
          } catch (SQLException ex) {
              Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
          }
                  return null;
    }

    
}
