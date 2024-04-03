package retrofit2.adapter.rxjava2;

import javax.annotation.Nullable;
import retrofit2.Response;

public final class Result<T> {
    @Nullable
    private final Throwable error;
    @Nullable
    private final Response<T> response;

    private Result(@Nullable Response<T> response2, @Nullable Throwable th2) {
        this.response = response2;
        this.error = th2;
    }

    public static <T> Result<T> error(Throwable th2) {
        if (th2 != null) {
            return new Result<>((Response) null, th2);
        }
        throw new NullPointerException("error == null");
    }

    public static <T> Result<T> response(Response<T> response2) {
        if (response2 != null) {
            return new Result<>(response2, (Throwable) null);
        }
        throw new NullPointerException("response == null");
    }

    public boolean isError() {
        return this.error != null;
    }

    @Nullable
    public Throwable error() {
        return this.error;
    }

    @Nullable
    public Response<T> response() {
        return this.response;
    }
}
