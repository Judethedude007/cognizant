package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    public Country getCountry(String code) {
        LOGGER.info("Start");

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            List<Country> countryList = context.getBean("countryList", List.class);

            Country country = countryList.stream()
                    .filter(item -> item.getCode().equalsIgnoreCase(code))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Country not found: " + code));

            LOGGER.debug("Country: {}", country);
            LOGGER.info("End");
            return country;
        }
    }
}
