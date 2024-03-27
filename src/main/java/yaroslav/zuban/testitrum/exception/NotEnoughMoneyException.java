package yaroslav.zuban.testitrum.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NotEnoughMoneyException extends RuntimeException{
    private final String error;

    public NotEnoughMoneyException(String error) {
        this.error = error;
    }

    public NotEnoughMoneyException(String message, String error) {
        super(message);
        this.error = error;
    }

    public NotEnoughMoneyException(String message, Throwable cause, String error) {
        super(message, cause);
        this.error = error;
    }

    public NotEnoughMoneyException(Throwable cause, String error) {
        super(cause);
        this.error = error;
    }

    public NotEnoughMoneyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String error) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.error = error;
    }
}