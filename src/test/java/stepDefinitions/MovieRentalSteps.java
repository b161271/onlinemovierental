package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MovieRentalSteps {

    private Response response;

    @Given("I set the base URI")
    public void i_set_the_base_URI() {
        RestAssured.baseURI = "http://localhost:7007"; // Change if your server is running on a different port or host
    }

    @When("I set the request body for user registration")
    public void i_set_the_request_body_for_user_registration() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"username\": \"newuser\", \"password\": \"password123\", \"email\": \"newuser@example.com\" }")
                .when()
                .post("/users/register");
    }

    @When("I set the request body for user login")
    public void i_set_the_request_body_for_user_login() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"username\": \"newuser\", \"password\": \"password123\" }")
                .when()
                .post("/users/login");
    }

    @When("I set the request body for adding a new movie")
    public void i_set_the_request_body_for_adding_a_new_movie() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"title\": \"New Movie\", \"director\": \"Director Name\", \"genre\": \"Action\", \"releaseDate\": \"2024-01-01\" }")
                .when()
                .post("/movies");
    }

    @When("I set the request body for placing a new rental")
    public void i_set_the_request_body_for_placing_a_new_rental() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"userId\": 1, \"movieId\": 1, \"rentalDate\": \"2024-01-01\" }")
                .when()
                .post("/rentals");
    }

    @When("I set the request body for updating user profile")
    public void i_set_the_request_body_for_updating_user_profile() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"username\": \"updateduser\", \"email\": \"updateduser@example.com\" }")
                .when()
                .put("/users/1");
    }

    @When("I send a POST request to {string}")
    public void i_send_a_POST_request_to(String endpoint) {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .post(endpoint);
    }

    @When("I send a PUT request to {string}")
    public void i_send_a_PUT_request_to(String endpoint) {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .put(endpoint);
    }

    @When("I send a DELETE request to {string}")
    public void i_send_a_DELETE_request_to(String endpoint) {
        response = RestAssured.given()
        		.contentType(ContentType.JSON)
                .when()
                .delete(endpoint);
    }

    @When("I send a GET request to {string}")
    public void i_send_a_GET_request_to(String endpoint) {
        response = RestAssured.given()
        		.contentType(ContentType.JSON)
                .when()
                .get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
    }

    @Then("the response body should contain {string}")
    public void the_response_body_should_contain(String expectedResponseBody) {
        assertThat(response.getBody().asString(), equalTo(expectedResponseBody));
    }
}
