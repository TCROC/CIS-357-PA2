/**
 * This meets the requirement of creating a custom exception.
 *
 * Properties:
 * default message: The message to include in the exception.
 *
 * Methods:
 * toString(): The message to output.
 */

package sample;

public class IllegalItemException extends Throwable {

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
