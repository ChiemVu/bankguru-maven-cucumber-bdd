package dataObjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerInfo {

    private String customerName;
    private String gender;
    private String dateOfBirth;
    private String address;
    private String city;
    private String state;
    private String pin;
    private String mobileNumber;
    private String email;
    private String password;

    public static CustomerInfo getCustomer() {
        return new CustomerInfo();
    }
}
