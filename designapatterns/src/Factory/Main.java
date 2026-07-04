package Factory;
public class Main {

    public static void main(String[] args) {

        PaymentFactory factory = new PaymentFactory();

        Payment payment = factory.getPayment("UPI");
        payment.pay(500);

        payment = factory.getPayment("CARD");
        payment.pay(1200);

        payment = factory.getPayment("CASH");
        payment.pay(300);
    }
}