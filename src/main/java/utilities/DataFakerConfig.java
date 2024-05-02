package utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataFakerConfig {
    private Locale local = new Locale("en");
    private Faker fake = new Faker(local);
    private static DataFakerConfig dataFakerInstance;

    private DataFakerConfig(){

    }
    public static synchronized DataFakerConfig getDataFakerConfig() {
        if (dataFakerInstance == null) {
            dataFakerInstance = new DataFakerConfig(); //mỗi class truy cập luôn create new
        }
        return dataFakerInstance;
    }
    // private String customerName, gender, dateOfBirth, address, city, state, pin, mobileNumber, email, password;
    public String getCustomerName() {
        return fake.name().lastName();
    }
    public String getGender() {
        //return fake.dog().gender().split("")[0];
        return fake.dog().gender();
    }
//    public String getDateOfBirth() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//        String dateOfBirth = dateFormat.format(fake.date().birthday());
//        return dateOfBirth;
//    }
    public String getAddress() {
        return fake.address().streetAddress();
    }
    public String getCity() {
        return fake.address().city();
    }
    public String getState() {
        return fake.address().state();
    }
    public String getPIN() {
        return fake.number().digits(6);
    }
    public String getEmail() {
        return fake.internet().emailAddress();
    }

    public String getPassword() {
        return fake.internet().password(6, 8, true, true);
    }
}
