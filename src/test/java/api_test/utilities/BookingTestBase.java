package api_test.utilities;

import io.restassured.RestAssured;

import org.junit.jupiter.api.BeforeAll;



public class BookingTestBase {

    @BeforeAll
    public static void init() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

    }

}

