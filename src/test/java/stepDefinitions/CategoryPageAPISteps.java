package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

public class CategoryPageAPISteps {

    Response response;

    @Given("I perform a GET request to {string}")
    public void i_perform_a_get_request_to(String url) {
        response = given()
                .when()
                .get(url);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer expectedStatusCode) {
        assertEquals(expectedStatusCode.intValue(), response.getStatusCode());
    }
}
