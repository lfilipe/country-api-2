package pt.org.multicert.countries.controllers;


import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.org.multicert.countries.exceptions.CountryNotFoundException;
import pt.org.multicert.countries.models.ExceptionResponse;
import pt.org.multicert.countries.services.CountryService;
import pt.org.multicert.countries.models.Country;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/countries")
@Tag(name = "Countries", description = "Countries api")
public class CountryController {

    public CountryService countryService;


    @Operation(
            summary = "Fetch country",
            description = "Search country by code [cca2] by ISO 3166-1 alpha2 country code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Country.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Country with code cca2 was not found.", content = { @Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json") })
    })
    @GetMapping("/code/{cca2}")
    public ResponseEntity<Country> findByCca2(@Parameter(description = "Country code ISO 3166-1 alpha2", required = true) @PathVariable String cca2) {
        Country bean = null;
        try {
            bean = countryService.findByCca2(cca2);
            return new ResponseEntity<>(bean,
                    HttpStatus.OK);
        } catch (NoSuchElementException k) {
            throw new CountryNotFoundException("Country with code "+cca2+ " was not found");
        }
    }

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @Hidden
    @GetMapping("/all")
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @Hidden
    @GetMapping("/{country}")
    public Country findByName(@PathVariable String country) {
        return countryService.findByName(country);
    }



}
