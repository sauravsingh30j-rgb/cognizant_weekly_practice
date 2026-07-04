package Factory;

class UpiPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

class CardPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Card");
    }
}

class CashPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Cash");
    }
}
