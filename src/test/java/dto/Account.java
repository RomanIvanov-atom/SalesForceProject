package dto;

import lombok.*;

@Data
@RequiredArgsConstructor
@Builder
public class Account {
    private final String name;
    private final String rating;
    private final String accountNumber;
    private final String phoneNumber;
    private final String fax;
    private final String webSite;
    private final String accountSite;
    private final String tickerSymbol;
    private final String type;
    private final String ownership;
    private final String industry;
    private final int employees;
    private final int annualRevenue;
    private final String sicCode;
    private final String billingStreet;
    private final String shippingStreet;
    private final String customerPriority;
    private final String sla;
    private final String sLASerialNumber;
    private final int numberOfLocations;
    private final String upsellOpportunity;
    private final String isActive;
    private final String description;
}
