Feature: API Testing for Movie Rental System

Scenario: Register a new user
Given I set the base URI
When I set the request body for user registration
And I send a POST request to "/users/register"
Then the response status code should be 201

Scenario: Login a user
When I set the request body for user login
Then the response status code should be 200


Scenario: Add a new movie
When I set the request body for adding a new movie
And I send a POST request to "/movies"
Then the response status code should be 201

Scenario: Retrieve movie details
When I send a GET request to "/movies/1"
Then the response status code should be 200

Scenario: Place a new rental
When I set the request body for placing a new rental
And I send a POST request to "/rentals"
Then the response status code should be 201

Scenario: Retrieve rental details
When I send a GET request to "/rentals/1"
Then the response status code should be 200

Scenario: Update user profile
When I set the request body for updating user profile
And I send a PUT request to "/users/1"
Then the response status code should be 200

Scenario: Delete user account
When I send a DELETE request to "/users/2"
Then the response status code should be 404

Scenario: Search movies by title
When I send a GET request to "/movies/search?title=Movie1"
Then the response status code should be 200

Scenario: Filter movies by genre
When I send a GET request to "/movies/filter?genre=Genre1"
Then the response status code should be 200
