package dto;

import com.github.javafaker.Faker;

public class FormFactory {

    public static FormData getForm(String gender, String stateAndCity) {
        Faker faker = new Faker();

        return FormData.builder()
                .firstName(faker.name().name())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .mobile(faker.number().digits(10))
                .subjects(faker.funnyName().name())
                .currentAddress(faker.address().fullAddress())
                .build();
    }

    public static FormData getTextBox() {
        Faker faker = new Faker();

        return FormData.builder()
                .email(faker.internet().emailAddress())
                .currentAddress(faker.address().fullAddress())
                .permanentAddress(faker.address().fullAddress())
                .build();
    }

    public static FormData getWebPages() {
        Faker faker = new Faker();

        return FormData.builder()
                .firstName(faker.name().name())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .age(faker.number().digits(3))
                .salary(faker.number().digits(5))
                .department(faker.company().name())
                .build();
    }
}
