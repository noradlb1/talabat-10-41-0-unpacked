package fwfd.com.fwfsdk.model.dao;

import android.os.Build;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import fwfd.com.fwfsdk.FunWithFlags;
import fwfd.com.fwfsdk.constant.FWFConstants;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FWFAPIClient {
    private static final String HEADER_DEBUG_MODE = "Isdebug";
    private static final String HEADER_FROM_METHOD = "fromMethod";
    private static final String HEADER_SDK_INFO = "Sdkinfo";
    protected Retrofit retrofit;

    public FWFAPIClient(final String str, List<Interceptor> list) {
        final boolean isDebugMode = FunWithFlags.getInstance().isDebugMode();
        AnonymousClass1 r12 = new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request.Builder newBuilder = chain.request().newBuilder();
                newBuilder.addHeader(FWFAPIClient.HEADER_SDK_INFO, FWFAPIClient.getSDKInfo());
                newBuilder.addHeader(FWFAPIClient.HEADER_FROM_METHOD, str);
                newBuilder.addHeader(FWFAPIClient.HEADER_DEBUG_MODE, Boolean.toString(isDebugMode));
                return chain.proceed(OkHttp3Instrumentation.build(newBuilder));
            }
        };
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        if (isDebugMode) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        long millis = TimeUnit.SECONDS.toMillis((long) FunWithFlags.getInstance().getConnectionTimeout());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.readTimeout(millis, timeUnit).connectTimeout(millis, timeUnit).addInterceptor(r12).addInterceptor(httpLoggingInterceptor);
        for (Interceptor addInterceptor : list) {
            builder.addInterceptor(addInterceptor);
        }
        this.retrofit = new Retrofit.Builder().baseUrl(endpoint()).addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build();
    }

    private static String endpoint() {
        if (!localUrl().isEmpty()) {
            return localUrl() + "/" + FunWithFlags.getInstance().getApiVersion() + "/";
        }
        return FunWithFlags.getInstance().getBaseUrl() + "/" + FunWithFlags.getInstance().getApiVersion() + "/";
    }

    /* access modifiers changed from: private */
    public static String getSDKInfo() {
        int i11 = Build.VERSION.SDK_INT;
        return "Sdkinfo: Android API " + i11 + " FWF " + FWFConstants.SDK_VERSION;
    }

    private static String localUrl() {
        return FunWithFlags.getInstance().getLocalUrl();
    }
}
