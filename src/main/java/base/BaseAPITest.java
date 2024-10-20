package base;

import config.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPITest {

    @BeforeSuite
    public void setUp() {
        RestAssured.baseURI = ConfigLoader.getProperty("api.endpoint" + ConfigLoader.getProperty("env"));
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", ConfigLoader.getProperty("api.authtoken"))
                .setAccept(ContentType.JSON)
                .build();
    }

    @AfterSuite
    public void tearDown() {
        // Any cleanup operations if needed
    }
}

