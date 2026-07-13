package com.cognizant.springlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnCountryApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnCountryApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext bootContext = SpringApplication.run(SpringLearnCountryApplication.class, args);

        LOGGER.info("Inside main");

        SpringLearnCountryApplication application = bootContext.getBean(SpringLearnCountryApplication.class);
        application.displayCountrySingleton();
        application.displayCountryPrototype();
        application.displayCountries();

        SpringApplication.exit(bootContext);
    }

    public void displayCountrySingleton() {
        LOGGER.info("START - displayCountrySingleton");

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country-singleton.xml")) {
            Country country = context.getBean("country", Country.class);
            Country anotherCountry = context.getBean("country", Country.class);

            LOGGER.debug("Country : {}", country);
            LOGGER.debug("Another Country : {}", anotherCountry);
            LOGGER.debug("Singleton same object: {}", country == anotherCountry);
        }

        LOGGER.info("END - displayCountrySingleton");
    }

    public void displayCountryPrototype() {
        LOGGER.info("START - displayCountryPrototype");

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country-prototype.xml")) {
            Country country = context.getBean("country", Country.class);
            Country anotherCountry = context.getBean("country", Country.class);

            LOGGER.debug("Country : {}", country);
            LOGGER.debug("Another Country : {}", anotherCountry);
            LOGGER.debug("Prototype same object: {}", country == anotherCountry);
        }

        LOGGER.info("END - displayCountryPrototype");
    }

    @SuppressWarnings("unchecked")
    public void displayCountries() {
        LOGGER.info("START - displayCountries");

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country-list.xml")) {
            List<Country> countries = context.getBean("countryList", List.class);

            LOGGER.debug("Country List : {}", countries);
        }

        LOGGER.info("END - displayCountries");
    }
}
