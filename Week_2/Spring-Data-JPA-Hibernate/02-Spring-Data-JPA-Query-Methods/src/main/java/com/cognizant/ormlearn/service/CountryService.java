package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountriesByText(String searchText) {
        return countryRepository.findByNameContainingIgnoreCase(searchText);
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountriesByTextSorted(String searchText) {
        return countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(searchText);
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountriesStartingWith(String prefix) {
        return countryRepository.findByNameStartingWithIgnoreCase(prefix);
    }
}
