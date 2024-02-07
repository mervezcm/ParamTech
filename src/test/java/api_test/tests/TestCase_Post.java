package api_test.tests;

import api_test.pojo.BookingDates;
import api_test.pojo.Customer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class TestCase_Post {
    @Test
            public void test1(){
        Customer requestBody= new Customer();
        BookingDates requestBody2= new BookingDates();

        requestBody.setFirstName("Jim");
        requestBody.setLastName("Brown");
        requestBody.setTotalPrice(111);
        requestBody.setDepositPaid(true);
        requestBody.setAdditionalNeeds("Breakfast");

        requestBody.setDates(requestBody2);
        requestBody2.setCheckinDate("2018-01-01");
        requestBody2.setCheckoutDate("2019-01-01");


        RestAssured.given().accept(ContentType.JSON)
                .body(requestBody)
                .when().post("/booking")
                .then().statusCode(200);

    }





}
