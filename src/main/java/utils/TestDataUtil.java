package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestDataUtil {

    private static final Logger logger =
            LogManager.getLogger(TestDataUtil.class);

    private static final Random random = new Random();

    private static final String EMAIL_DOMAIN = "@testmail.com";

    private static final String[] FIRST_NAMES = {
            "John", "David", "Michael", "Chris", "Daniel"
    };

    private static final String[] LAST_NAMES = {
            "Smith", "Brown", "Johnson", "Williams", "Taylor"
    };

    /* ------------------ EMAIL ------------------ */

    public static String getRandomEmail() {

        String timestamp =
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        String email =
                "testuser_" + timestamp + "_" + random.nextInt(1000)
                        + EMAIL_DOMAIN;

        logger.info("Generated Email: " + email);
        return email;
    }

    /* ------------------ FIRST NAME ------------------ */

    public static String getRandomFirstName() {

        String firstName =
                FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];

        logger.info("Generated First Name: " + firstName);
        return firstName;
    }

    /* ------------------ LAST NAME ------------------ */

    public static String getRandomLastName() {

        String lastName =
                LAST_NAMES[random.nextInt(LAST_NAMES.length)];

        logger.info("Generated Last Name: " + lastName);
        return lastName;
    }

    /* ------------------ PHONE NUMBER ------------------ */

    public static String getRandomPhoneNumber() {

        // US-style 10-digit phone number
        String phone = String.valueOf(1000000000L + random.nextInt(900000000));

        logger.info("Generated Phone Number: " + phone);
        return phone;
    }

    /* ------------------ STRONG PASSWORD ------------------ */

    public static String getStrongPassword() {

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "@#$%&*";

        String allChars = upper + lower + digits + special;

        StringBuilder password = new StringBuilder();

        // Ensure password strength
        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(special.charAt(random.nextInt(special.length())));

        // Remaining characters
        for (int i = 0; i < 4; i++) {
            password.append(
                    allChars.charAt(random.nextInt(allChars.length()))
            );
        }

        logger.info("Generated Strong Password");
        return password.toString();
    }
}
