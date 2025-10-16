package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
    // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
    // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
    // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
    // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = new CityList();
        CityList emptyCityList = mockCityList();
        City edmonton1 = new City("Edmonton", "Alberta");
        City edmonton2 = new City("Edmonton", "Alberta");
        City calgary = new City("Calgary", "Alberta");

        cityList.add(edmonton1);

        assertTrue(emptyCityList.hasCity(edmonton1), "Should detect city already added");
        assertTrue(cityList.hasCity(edmonton2), "Should detect equivalent city due to equals()");
        assertFalse(cityList.hasCity(calgary), "Should return false for city not in list");
    }

    @Test
    void testDeleteRemovesCity() {
        CityList cityList = new CityList();
        City edmonton = new City("Edmonton", "Alberta");
        City regina   = new City("Regina", "Saskatchewan");
        cityList.add(edmonton);
        cityList.add(regina);
        CityList emptyCityList = mockCityList();

        assertTrue(cityList.hasCity(edmonton));
        assertEquals(2, cityList.getCities().size());

        cityList.delete(edmonton);
        emptyCityList.delete(edmonton);
        assertFalse(emptyCityList.hasCity(edmonton));
        assertFalse(cityList.hasCity(edmonton));
        assertTrue(cityList.hasCity(regina));
        assertEquals(1, cityList.getCities().size());
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities(), "Empty list should have count 0");

        City edmonton = new City("Edmonton", "Alberta");
        City regina = new City("Regina", "Saskatchewan");

        cityList.add(edmonton);
        assertEquals(1, cityList.countCities(), "List should have 1 city after adding Edmonton");

        cityList.add(regina);
        assertEquals(2, cityList.countCities(), "List should have 2 cities after adding Regina");

        cityList.delete(edmonton);
        assertEquals(1, cityList.countCities(), "List should have 1 city after deleting Edmonton");
    }


}


