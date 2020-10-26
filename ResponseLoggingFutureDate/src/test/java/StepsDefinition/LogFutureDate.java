package StepsDefinition;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LogFutureDate {

	Response response;
	@Test
	@Given("API for foreign Exchange")
	public void api_for_foreign_Exchange() {
		RestAssured.baseURI="https://api.ratesapi.io";
	}

	@Test
	@When("posted with future date information")
	public void posted_with_future_date_information() {
		
		response=RestAssured.given().get("/api/2021-15-12");
	}

	@Test
	@Then("validate positive response code received")
	public void validate_positive_response_code_received() {
		
		RestAssured.given().headers("Content-Type","application/json").log().all().get("/api/2021-15-12").
		then().
		assertThat().statusCode(400).log().all().extract().response();
	}

}
