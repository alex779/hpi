
import alex.taskone.domain.CityDaoImpl;
import alex.taskone.domain.RoadDaoImpl;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hovercat
 */
public class App {

    public static void main(String[] args) throws Exception {

        CityDaoImpl cityDao = new CityDaoImpl();
        RoadDaoImpl roadDao = new RoadDaoImpl();
        
        cityDao.addCity("City1", 1); //Создание города
        cityDao.addCity("City1", 2); //Создание города с одинаковым именем, но разными координатами
        cityDao.addCity("City2", 1); //Проверка на создание города с существующими координатами
        cityDao.addCity("City3", 3);
        
        roadDao.addRoad("Road1", 1, 2); //создание дорог
        roadDao.addRoad("Road1", 2, 3);
        
        System.out.println(cityDao.getRoadList(2)); //получение списка дорог, ведущих из города по его ID
        
        cityDao.removeCity(1); //Удаление города по ID
        roadDao.removeRoad(1); //Удаление дороги по ID

    }
}
