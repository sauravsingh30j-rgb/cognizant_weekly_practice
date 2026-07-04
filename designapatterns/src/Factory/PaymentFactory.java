package Factory;

public class PaymentFactory {

    public Payment getPayment(String type) {

        if (type.equalsIgnoreCase("UPI"))
            return new UpiPayment();

        if (type.equalsIgnoreCase("CARD"))
            return new CardPayment();

        if (type.equalsIgnoreCase("CASH"))
            return new CashPayment();

        return null;
    }
}