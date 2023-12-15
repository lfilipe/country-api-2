package pt.org.multicert.countries.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import pt.org.multicert.countries.models.Country;

import java.util.List;

@Service
public class CountryService {

    private final RestClient restClient;

    private final String FIELDS = "name,languages,population,currencies,capital,cca2,cca3,capital,latlng";

    public CountryService() {
        restClient = RestClient.builder()
                .baseUrl("https://countryinfoapi.com/api")
                .build();
    }

    public Country findByCca2(String cca2) {
        List<Country> countries = this.findAll();
        return countries.stream()
                .filter(c -> cca2.equalsIgnoreCase(c.getCca2()))
                .findFirst()
                .get();
        //trigger NoSuchElementException no caso de nao encontrar
    }

    public List<Country> findAll() {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/countries")
                        .queryParam("fields", FIELDS)
                        .build())
                .retrieve()
                .body(new ParameterizedTypeReference<List<Country>>() {});
    }

    public Country findByName(String country) {

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/countries/name/{country}")
                        .queryParam("fields", FIELDS)
                        .build(country))
                .retrieve()
                .body(Country.class);
    }



}
