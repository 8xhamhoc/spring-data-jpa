package com.smd.learning;

import com.smd.learning.entity.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
//        Set<Country> countries = new HashSet<>();
//        Country country = new Country("DE", "Germany");
//        countries.add(country);
//        country.setIsocode("FR");
//        log.info("Boolean: " + countries.contains(country));

        Country de = new Country("DE", "Germany");
        Country fr = new Country("DE", "France");

        log.info("Compare: " + (de.equals(fr)));
    }

}
