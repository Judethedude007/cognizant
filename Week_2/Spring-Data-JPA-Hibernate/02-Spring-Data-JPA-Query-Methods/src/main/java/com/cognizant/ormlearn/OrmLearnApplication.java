package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private final CountryService countryService;

    public OrmLearnApplication(CountryService countryService) {
        this.countryService = countryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");
    }

    @Override
    public void run(ApplicationArguments args) {
        testSearchCountriesByText();
        testSearchCountriesByTextSorted();
        testSearchCountriesStartingWith();
    }

    private void testSearchCountriesByText() {
        LOGGER.info("Start - search countries containing text");
        List<Country> countries = countryService.searchCountriesByText("ou");
        LOGGER.debug("Countries containing 'ou': {}", countries);
        LOGGER.info("End - search countries containing text");
    }

    private void testSearchCountriesByTextSorted() {
        LOGGER.info("Start - search countries containing text sorted");
        List<Country> countries = countryService.searchCountriesByTextSorted("ou");
        LOGGER.debug("Countries containing 'ou' sorted by name: {}", countries);
        LOGGER.info("End - search countries containing text sorted");
    }

    private void testSearchCountriesStartingWith() {
        LOGGER.info("Start - search countries starting with alphabet");
        List<Country> countries = countryService.searchCountriesStartingWith("Z");
        LOGGER.debug("Countries starting with 'Z': {}", countries);
        LOGGER.info("End - search countries starting with alphabet");
    }
}
