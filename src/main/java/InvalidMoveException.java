package src.main.java;

public class InvalidMoveException extends Exception {
    public InvalidMoveException() {
        super("Attempted move is not a legal move");
    }
}