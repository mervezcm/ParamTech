package api_test.utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public class BookingTestBase {

    @BeforeAll
    public static void init() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

    }



}