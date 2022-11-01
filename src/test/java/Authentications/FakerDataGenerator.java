package Authentications;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDataGenerator {

    @Test
    void testGenerateDummyData()
    {
                              // Random fake data of any type is created
        Faker faker=new Faker();

        String fullname= faker.name().fullName();
        String firstname=faker.name().firstName();
        String lastname=faker.name().lastName();
        String username=faker.name().username();
        String password=faker.internet().password();  // also able to set range of password
        String phoneno=faker.phoneNumber().cellPhone();
        String email=faker.internet().safeEmailAddress();

        String middlename = faker.name().nameWithMiddle();

        System.out.println("Full Name:"+fullname);
        System.out.println("First Name:"+firstname);
        System.out.println("Last Name:"+lastname);
        System.out.println("User Name:"+username);
        System.out.println("Password:"+password);
        System.out.println("Phone:"+phoneno);
        System.out.println("Email:"+email);
        System.out.println("Middle Name:"+middlename);
    }
}
