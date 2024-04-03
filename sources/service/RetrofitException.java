package service;

import java.io.IOException;
import java.lang.annotation.Annotation;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitException extends RuntimeException {
    private final Kind kind;
    private final Response response;
    private final Retrofit retrofit;
    private final String url;

    public enum Kind {
        NETWORK,
        HTTP,
        UNEXPECTED
    }

    public RetrofitException(String str, String str2, Response response2, Kind kind2, Throwable th2, Retrofit retrofit3) {
        super(str, th2);
        this.url = str2;
        this.response = response2;
        this.kind = kind2;
        this.retrofit = retrofit3;
    }

    public static RetrofitException httpError(String str, Response response2, Retrofit retrofit3) {
        return new RetrofitException(response2.code() + " " + response2.message(), str, response2, Kind.HTTP, (Throwable) null, retrofit3);
    }

    public static RetrofitException networkError(IOException iOException) {
        return new RetrofitException(iOException.getMessage(), (String) null, (Response) null, Kind.NETWORK, iOException, (Retrofit) null);
    }

    public static RetrofitException unexpectedError(Throwable th2) {
        return new RetrofitException(th2.getMessage(), (String) null, (Response) null, Kind.UNEXPECTED, th2, (Retrofit) null);
    }

    public <T> T getErrorBodyAs(Class<T> cls) throws IOException {
        Response response2 = this.response;
        if (response2 == null || response2.errorBody() == null) {
            return null;
        }
        return this.retrofit.responseBodyConverter(cls, new Annotation[0]).convert(this.response.errorBody());
    }

    public Kind getKind() {
        return this.kind;
    }

    public Response getResponse() {
        return this.response;
    }

    public Retrofit getRetrofit() {
        return this.retrofit;
    }

    public String getUrl() {
        return this.url;
    }
}
