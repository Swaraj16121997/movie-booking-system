package models;

public class ShowSeatType extends BaseModel{
    private Show show;
    private SeatType seatType;
    private double price;       // price of the show depends upon the show's attributes and the seat type
}
