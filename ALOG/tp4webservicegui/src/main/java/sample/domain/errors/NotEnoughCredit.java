package sample.domain.errors;

public class NotEnoughCredit extends Exception{
    public NotEnoughCredit() {
        super("There is not enough credit for this client");
    }
}
