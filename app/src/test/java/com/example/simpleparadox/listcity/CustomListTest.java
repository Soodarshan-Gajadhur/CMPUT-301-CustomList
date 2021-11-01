package com.example.simpleparadox.listcity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    @BeforeEach
    public void createList(){
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest(){
        int listSize = list.getCount();
        list.addCity(new City("Halifax", "NS"));
        assertEquals(list.getCount(), listSize+1);
    }

    @Test
    void testHasCity() {
        City newCity = new City("Calgary","Alberta");
        list.addCity(newCity);
        assertEquals(true, list.hasCity(newCity));
        City city = new City("Regina", "Saskatchewan");
        assertEquals(false, list.hasCity(city));
    }

    @Test
    void testDelete(){
        City newCity = new City("Calgary","Alberta");
        list.addCity(newCity);
        list.delete(newCity);
        assertEquals(false, list.hasCity(newCity));
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        list.delete(city);
        assertEquals(false, list.hasCity(city));

    }

    @Test
    void testDeleteException() {
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        list.delete(city);
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(city);
        });
    }

    @Test
    void testCountCities() {
        assertEquals(0, list.countCities());
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertEquals(1, list.countCities());

        list.addCity(new City("Edmonton", "Alberta"));
        assertEquals(2, list.countCities());
    }
}
