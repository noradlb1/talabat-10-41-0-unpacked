package com.talabat.core.safety.data.interceptors;

import android.os.Build;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.talabat.configuration.discovery.AppVersionProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/core/safety/data/interceptors/UserAgentInterceptor;", "Lokhttp3/Interceptor;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "(Lcom/talabat/configuration/discovery/AppVersionProvider;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserAgentInterceptor implements Interceptor {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DEFAULT_USER_AGENT = "okhttp/4.9.2";
    @NotNull
    private final AppVersionProvider appVersionProvider;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/core/safety/data/interceptors/UserAgentInterceptor$Companion;", "", "()V", "DEFAULT_USER_AGENT", "", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public UserAgentInterceptor(@NotNull AppVersionProvider appVersionProvider2) {
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        this.appVersionProvider = appVersionProvider2;
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request request;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder newBuilder = chain.request().newBuilder();
        String appVersion = this.appVersionProvider.appVersion();
        String str = Build.VERSION.RELEASE;
        Request.Builder header = newBuilder.header("User-Agent", "Talabat/" + appVersion + " okhttp/4.9.2 (Linux; Android " + str + ")");
        if (!(header instanceof Request.Builder)) {
            request = header.build();
        } else {
            request = OkHttp3Instrumentation.build(header);
        }
        return chain.proceed(request);
    }
}
