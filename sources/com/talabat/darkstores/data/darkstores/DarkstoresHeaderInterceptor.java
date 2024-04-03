package com.talabat.darkstores.data.darkstores;

import com.google.common.net.HttpHeaders;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/darkstores/data/darkstores/DarkstoresHeaderInterceptor;", "Lokhttp3/Interceptor;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "perseusHandler", "Lcom/talabat/darkstores/data/darkstores/DarkstoresHeaderInterceptor$PerseusHandler;", "(Lcom/talabat/configuration/discovery/AppVersionProvider;Lcom/talabat/darkstores/data/darkstores/DarkstoresHeaderInterceptor$PerseusHandler;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "PerseusHandler", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresHeaderInterceptor implements Interceptor {
    @NotNull
    private final AppVersionProvider appVersionProvider;
    @NotNull
    private final PerseusHandler perseusHandler;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/data/darkstores/DarkstoresHeaderInterceptor$PerseusHandler;", "", "getClientId", "", "getSessionId", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface PerseusHandler {
        @Nullable
        String getClientId();

        @Nullable
        String getSessionId();
    }

    public DarkstoresHeaderInterceptor(@NotNull AppVersionProvider appVersionProvider2, @NotNull PerseusHandler perseusHandler2) {
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        Intrinsics.checkNotNullParameter(perseusHandler2, "perseusHandler");
        this.appVersionProvider = appVersionProvider2;
        this.perseusHandler = perseusHandler2;
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request request;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder newBuilder = chain.request().newBuilder();
        String str = GlobalDataModel.SelectedLanguage;
        Intrinsics.checkNotNullExpressionValue(str, "SelectedLanguage");
        Request.Builder header = newBuilder.header(HttpHeaders.ACCEPT_LANGUAGE, str).header("x-device-source", "6");
        String appVersion = this.appVersionProvider.appVersion();
        String str2 = "";
        if (appVersion == null) {
            appVersion = str2;
        }
        Request.Builder header2 = header.header("x-device-version", appVersion);
        String sessionId = this.perseusHandler.getSessionId();
        if (sessionId == null) {
            sessionId = str2;
        }
        Request.Builder header3 = header2.header("x-perseussessionid", sessionId);
        String clientId = this.perseusHandler.getClientId();
        if (clientId != null) {
            str2 = clientId;
        }
        Request.Builder header4 = header3.header("x-perseusclientid", str2);
        if (!(header4 instanceof Request.Builder)) {
            request = header4.build();
        } else {
            request = OkHttp3Instrumentation.build(header4);
        }
        return chain.proceed(request);
    }
}
