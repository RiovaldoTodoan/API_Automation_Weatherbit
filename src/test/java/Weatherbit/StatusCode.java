package Weatherbit;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

public class StatusCode {
    @Then("Api should return response {int} OK")
    public void apiShouldReturnResponseOK(int ok) {
        SerenityRest
                .then()
                .statusCode(ok);}

}
