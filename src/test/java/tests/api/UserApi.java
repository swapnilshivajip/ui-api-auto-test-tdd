package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import utils.ApiUtils;

public class UserApi {

    public Response createUser(User user) {
        return RestAssured.given()
                .body(ApiUtils.convertObjectToJson(user))
                .when()
                .post("/users")
                .then()
                .log().all()
                .extract().response();
    }

    public Response getUserById(String userId) {
        return RestAssured.given()
                .pathParam("userId", userId)
                .when()
                .get("/users/{userId}")
                .then()
                .log().all()
                .extract().response();
    }

    // Other API methods
}

