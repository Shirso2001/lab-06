package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City>{
        private String city;
        private String province;

    /**
     * Construct a city.
     * @param city city name
     * @param province province name
     */
        City(String city, String province){
            this.city = city;
            this.province = province;
        }

        /** @return the city name */
        String getCityName(){
            return this.city;
        }

        /** @return the province name */
        String getProvinceName(){
            return this.province;
        }

    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName()); // this.city refers to the city name
    }

    /**
     * @param o the object to compare with this city
     * @return {@code true} if the given object is also a {@code City} with the same name and province; {@code false} otherwise
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City other = (City) o;
        return this.getCityName().equals(other.getCityName())
                && this.getProvinceName().equals(other.getProvinceName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCityName(), getProvinceName());
    }

}