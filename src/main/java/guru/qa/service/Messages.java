package guru.qa.service;

public enum Messages {
    WelcomeMessage("Enter 2 digit: \n"),
    RequestForOperator("Enter operator (+, *, -, /, ^): \n"),
    ResultTemplate("Result: %s");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
