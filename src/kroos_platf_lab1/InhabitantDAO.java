/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kroos_platf_lab1;

import java.sql.ResultSet;

/**
 *
 * @author Димас
 */
public interface InhabitantDAO {
    void createInhabitant( Inhabitant inhab);
    ResultSet readInhabitant();
    ResultSet readInhabitant(int id);
    void updateInhabitant( Inhabitant inhab, int id);
    void deleteInhabitant( int id);
    ResultSet serchInhabitant( String query);
}
