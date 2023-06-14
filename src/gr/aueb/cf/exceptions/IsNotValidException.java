package gr.aueb.cf.exceptions;

public class IsNotValidException extends Exception {
    private static final long serialVersionId = 1L;

    public IsNotValidException(String ssn) {
        super("Ssn " + ssn + " is not valid");
    }
}
