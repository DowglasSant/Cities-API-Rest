package com.github.dowglassant.citiesapi.country;


import com.github.dowglassant.citiesapi.country.Country;
import com.github.dowglassant.citiesapi.country.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/countries")

public class CountriesResource {

    public CountriesResource(CountryRepository repository) {
        this.repository = repository;
    }

    private CountryRepository repository;

    @GetMapping
    public Page<Country> countries(Pageable page){

        return  repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){

        Optional<Country> optional = repository.findAllById(id);
        if (optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
