package pt.org.multicert.countries.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.Map;

@JsonPropertyOrder({"cca2", "name", "capital", "languages", "latlng", "population"})
@Schema(description = "Country model")
public class Country {
    @Schema(description = "Country name", example = "Portugal")
    private String name;

    @Schema(description = "Country capital(s)", example = "Lisbon")
    private List<String> capital;

    @Schema(description = "ISO 3166-1 alpha2 country code", example = "pt")
    private String cca2;

    @Schema(description = "List of languages format code:language", example = "{\n" +
            "        \"eng\": \"English\",\n" +
            "        \"mlt\": \"Maltese\"\n" +
            "    }")
    private Map<String, String> languages;

    @Schema(description = "GPS coordinates - lat, lgt", example = "35.9375, 14.3754")
    private List<Double> latlng;

    @Schema(description = "Population number", example = "10000000")
    private Integer population;


    public List<String> getCapital() {
        return capital;
    }

    @JsonProperty("capital")
    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public String getCca2() {
        return cca2;
    }


    @JsonProperty("cca2")
    public void setCca2(String cca2) {
        this.cca2 = cca2;
    }


    public Map<String, String> getLanguages() {
        return this.languages;
    }

    @JsonProperty("languages")
    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }


    public List<Double> getLatlng() {
        return latlng;
    }


    @JsonProperty("latlng")
    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }


    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    @JsonProperty("population")
    public void setPopulation(Integer population) {
        this.population = population;
    }
}
