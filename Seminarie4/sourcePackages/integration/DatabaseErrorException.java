package integration;

public class DatabaseErrorException extends RuntimeException{
    
    /**
     * Creates a new instance of the exception with a descriptive message.
     */
    public DatabaseErrorException(){
        super("Database error. (Shown only to developers)");
    }
}