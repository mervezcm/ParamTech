package api_test.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Customer {
    private  String firstname;
    private  String lastname;
    private int totalprice;
    private boolean depositpaid;
    private  BookingDates bookingdates;
    private String additionalneeds;
}
