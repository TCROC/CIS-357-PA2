package sample;

public class IllegalItemException {

    String message = "";

    public IllegalItemException() {
        this("");
    }

    public IllegalItemException(String message) {
        this.message = message;
    }

    public String toString() {
        return "This item is illegal. Extra info: " + message;
    }
}
