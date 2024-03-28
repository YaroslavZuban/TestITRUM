package yaroslav.zuban.testitrum.exception;

public class WalletConcurrentModificationException extends Throwable {
    private final String error;

    public WalletConcurrentModificationException(String error) {
        this.error = error;
    }

    public WalletConcurrentModificationException(String message, String error) {
        super(message);
        this.error = error;
    }

    public WalletConcurrentModificationException(String message, Throwable cause, String error) {
        super(message, cause);
        this.error = error;
    }

    public WalletConcurrentModificationException(Throwable cause, String error) {
        super(cause);
        this.error = error;
    }

    public WalletConcurrentModificationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String error) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.error = error;
    }
}
