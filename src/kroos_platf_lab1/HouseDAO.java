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
public interface HouseDAO {
    void createHouse(House house);
    ResultSet readHouse();
    ResultSet readHouse(int id);
    void updateHouse(House house, int id);
    void deleteHouse(int id);
}
