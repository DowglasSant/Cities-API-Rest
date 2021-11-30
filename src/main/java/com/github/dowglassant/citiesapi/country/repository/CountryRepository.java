package com.github.dowglassant.citiesapi.country.repository;

import com.github.dowglassant.citiesapi.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findAllById(Long id);
}
