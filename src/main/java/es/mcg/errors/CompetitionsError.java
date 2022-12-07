package es.mcg.errors;

public class CompetitionsError extends Exception {
    public CompetitionsError()
    {
        super();
    }

    public CompetitionsError(String message)
    {
        super(message);
    }

    public CompetitionsError(String message, Throwable exception)
    {
        super(message, exception);
    }
}
