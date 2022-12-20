package Weatherbit;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class WeatherbitAPI {

    public static final String BASE_URL_CURRENT_WEATHER = "https://api.weatherbit.io/v2.0/current?lat=40.730610%20&lon=-73.935242%20&key=b29e676ba6e242aa81714dd20e7fca8a";
    public static final String BASE_URL_THREE_HOURLY_FORECAST = "https://api.weatherbit.io/v2.0/forecast/hourly?postal_code=28556&hours=3&key=b29e676ba6e242aa81714dd20e7fca8a";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR + "/src/test/resources/Jsonfile";

    @Step ("Get current weather")
    public void getCurrentweather(){
        SerenityRest.given();}

    @Step ("Get three hourly forecast")
    public void getthreehourlyforecast () {
        SerenityRest.given();}
    }

