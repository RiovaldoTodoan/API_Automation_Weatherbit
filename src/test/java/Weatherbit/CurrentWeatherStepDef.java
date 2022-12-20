package Weatherbit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static net.serenitybdd.rest.SerenityRest.when;
import static org.hamcrest.Matchers.hasItem;

public class CurrentWeatherStepDef {

    @Steps
    WeatherbitAPI weatherbitAPI;

    @Given("Get detail current weather with valid latitude and longitude")
    public void GetDetailCurrentWeatherWithAnd(){
        weatherbitAPI.getCurrentweather();}

    @When("Send request get current weather data")
    public void sendRequestGetCurrentWeatherData() {
        when().get(WeatherbitAPI.BASE_URL_CURRENT_WEATHER);}

    @And("View current weather data json schema validation")
    public void viewCurrentWeatherDataJsonSchemaValidation() {
        File jsonFile = new File(WeatherbitAPI
                .JSON_FILE+"/JsonSchemaValidationWeatherbit" +
                "/CurrentWeatherJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Response body contain state code {}")
    public void responseBodyContainState_code(String state_code) {
        SerenityRest
                .then()
                .body(Response.STATE_CODE, hasItem(state_code));}

}
