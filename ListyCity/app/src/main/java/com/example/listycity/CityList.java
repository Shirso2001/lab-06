package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Removes a city from the list if it exists; otherwise throws an exception.
     *
     * @param city the city to remove
     * @throws IllegalArgumentException if the city does not exist in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found: " + city);
        }
        cities.remove(city);
    }

    /**
     * Returns the number of cities currently stored in the list.
     *
     * @return the total number of cities
     */
    public int countCities() {
        return cities.size();
    }


    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether a given city is present in the list.
     * @param city The city to check for.
     * @return true if the city exists in the list, false otherwise.
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

}