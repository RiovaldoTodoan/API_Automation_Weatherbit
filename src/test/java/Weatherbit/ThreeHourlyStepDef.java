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

public class ThreeHourlyStepDef {
    @Steps
    WeatherbitAPI weatherbitAPI;

    @Given("Get three hourly forecast with postal code")
    public void getThreeHourlyForecastWithPostalCode() {
        weatherbitAPI.getthreehourlyforecast();}

    @When("Send request get three hourly forecast")
    public void sendRequestGetThreeHourlyForecast() {
        when().get(WeatherbitAPI.BASE_URL_THREE_HOURLY_FORECAST);}

    @And("View three hourly forecast json schema validation")
    public void viewThreeHourlyForecastJsonSchemaValidation() {
        File jsonFile = new File(WeatherbitAPI
                .JSON_FILE+"/JsonSchemaValidationWeatherbit" +
                "/ThreeHourlyForecastJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Response body should contain {}")
    public void responseBodyShouldContain(String timestamp_utc) {
        SerenityRest
                .then()
                .body(Response.TIMESTAMP_UTC, hasItem(timestamp_utc));}
}
