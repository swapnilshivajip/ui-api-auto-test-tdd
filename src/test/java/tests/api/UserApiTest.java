package tests.api;

import base.BaseAPITest;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;

public class UserApiTest extends BaseAPITest {

    UserApi userApi = new UserApi();

    @Test
    public void testCreateUser() {
        User newUser = new User("John Doe", "john.doe@example.com", "password123");

        Response response = userApi.createUser(newUser);

        // Status Code Assertion
        Assert.assertEquals(response.getStatusCode(), 201, "Status Code mismatch!");

        // Response Body Assertion
        User createdUser = ApiUtils.convertJsonToObject(response.asString(), User.class);
        Assert.assertEquals(createdUser.getName(), newUser.getName(), "Name mismatch!");
        Assert.assertEquals(createdUser.getEmail(), newUser.getEmail(), "Email mismatch!");
    }

    @Test
    public void testGetUserById() {
        String userId = "12345";
        Response response = userApi.getUserById(userId);

        // Status Code Assertion
        Assert.assertEquals(response.getStatusCode(), 200, "Status Code mismatch!");

        // Additional Validations
        User user = ApiUtils.convertJsonToObject(response.asString(), User.class);
        Assert.assertNotNull(user, "User object is null");
    }
}

