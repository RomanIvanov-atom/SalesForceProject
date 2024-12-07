package dto;

import com.github.javafaker.Faker;

public class AccountFactory {

    public static Account getFullfilledAccount(String rating) {
        Faker faker = new Faker();
        return Account.builder()
                .name(faker.name().fullName())
                .rating(rating)
                .accountNumber(faker.number().digits(10))
                .phoneNumber(faker.phoneNumber().phoneNumber())
                .fax(faker.phoneNumber().phoneNumber())
                .webSite(faker.internet().domainName())
                .accountSite(faker.internet().url())
                .tickerSymbol(faker.stock().nsdqSymbol())
                .type(faker.options().option("Prospect", "Customer - Direct", "Customer - Channel"))
                .ownership(faker.options().option("Public", "Private", "Subsidiary"))
                .industry(faker.company().profession())
                .employees(faker.number().numberBetween(1, 10000))
                .annualRevenue(faker.number().numberBetween(100000, 100000000))
                .sicCode(faker.number().digits(4))
                .billingStreet(faker.address().streetAddress())
                .shippingStreet(faker.address().streetAddress())
                .customerPriority(faker.options().option("High", "Medium", "Low"))
                .sla(faker.options().option("Gold", "Silver", "Bronze"))
                .sLASerialNumber(faker.number().digits(8))
                .numberOfLocations(faker.number().numberBetween(1, 50))
                .upsellOpportunity(faker.options().option("Yes", "No"))
                .isActive(faker.options().option("Yes", "No"))
                .description(faker.lorem().sentence())
                .build();
    }
}

