package api_test.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class Customer {
    private  String firstName;
    private  String lastName;
    private int totalPrice;
    private boolean depositPaid;
    private  BookingDates dates;

    private String additionalNeeds;
}
