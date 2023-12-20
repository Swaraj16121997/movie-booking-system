package models;

public class Payment extends BaseModel{
    private String referenceId;
    private double paymentAmount;
    private PaymentStatus paymentStatus;
    private PaymentProvider paymentMode;
}
