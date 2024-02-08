package api_test.tests;

import api_test.pojo.BookingDates;
import api_test.pojo.Customer;
import api_test.utilities.BookingTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BookingPostDelete extends BookingTestBase {
    public int bookingID;

    @Test
    public void test1() {

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2018-01-01");
        bookingDates.setCheckout("2019-01-01");

        Customer requestBody = new Customer();
        requestBody.setFirstname("Jim");
        requestBody.setLastname("Brown");
        requestBody.setTotalprice(111);
        requestBody.setDepositpaid(true);
        requestBody.setBookingdates(bookingDates);
        requestBody.setAdditionalneeds("Breakfast");


        Response response = RestAssured.given().log().body().contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/booking")
                .then().assertThat().statusCode(200).body("", hasKey("bookingid")).extract().response();


        JsonPath jsonPath = response.jsonPath();

        bookingID = jsonPath.getInt("bookingid");

        String firstName = jsonPath.getString("booking.firstname");
        String lastName = jsonPath.getString("booking.lastname");
        int totalPrice = jsonPath.getInt("booking.totalprice");
        boolean depositPaid = jsonPath.getBoolean("booking.depositpaid");
        String checkinDate = jsonPath.getString("booking.bookingdates.checkin");
        String checkoutDate = jsonPath.getString("booking.bookingdates.checkout");
        String additionalNeeds = jsonPath.getString("booking.additionalneeds");


        Assertions.assertEquals("Jim", firstName);
        Assertions.assertEquals("Brown", lastName);
        Assertions.assertEquals(111, totalPrice);
        Assertions.assertTrue(depositPaid);
        Assertions.assertEquals("2018-01-01", checkinDate);
        Assertions.assertEquals("2019-01-01", checkoutDate);
        Assertions.assertEquals("Breakfast", additionalNeeds);

        System.out.println(bookingID);

    }


    @Test
    public void test2() {
        String requestBody = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        //auth endpointine username ve password kullanarak tokeni oluşturup String bir değişken olarak kaydedilir.
        Response response = given().contentType(ContentType.JSON)
                .body(requestBody)
                .when().post("/auth")
                .then().statusCode(200)
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        String token = jsonPath.getString("token");

        System.out.println("token = " + token);

        String headerToken = "token=" + token;

        System.out.println("headerToken = " + headerToken);

        given().contentType(ContentType.JSON).header("Cookie", headerToken)
                .pathParam("id", bookingID)
                .when().delete("/booking/{id}")
                .then().statusCode(201);


    }


}
