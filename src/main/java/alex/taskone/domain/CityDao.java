/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alex.taskone.domain;


/**
 *
 * @author hovercat
 */
public interface CityDao {
    
    void addCity(String name, Integer location) throws Exception;   
    void removeCity(Integer id);
    City getCity (Integer id);
    City getCityByLocation(Integer location);
    
}
