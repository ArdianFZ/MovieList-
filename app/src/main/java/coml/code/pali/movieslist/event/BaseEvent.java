package coml.code.pali.movieslist.event;

public class BaseEvent {
    private String message;

    BaseEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}