package com.talabat.core.network.network;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.talabat.core.observabilityNew.domain.RequestResponseObservability;
import com.talabat.registration.RegistrationInteractor;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0006*\u00020\nH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/core/network/network/TalabatAuthenticator;", "Lokhttp3/Authenticator;", "requestResponseObservability", "Lcom/talabat/core/observabilityNew/domain/RequestResponseObservability;", "(Lcom/talabat/core/observabilityNew/domain/RequestResponseObservability;)V", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "Lokhttp3/Response;", "sendResponseLog", "", "apiPath", "", "message", "responseCode", "", "refreshToken", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatAuthenticator implements Authenticator {
    @Nullable
    private final RequestResponseObservability requestResponseObservability;

    public TalabatAuthenticator(@Nullable RequestResponseObservability requestResponseObservability2) {
        this.requestResponseObservability = requestResponseObservability2;
    }

    private final Request refreshToken(Response response) {
        boolean z11;
        Request request;
        if (response.request().headers().get("Authorization") == null || !Intrinsics.areEqual((Object) response.request().headers().get("AuthTokenType"), (Object) "jwt") || response.priorResponse() != null) {
            return null;
        }
        try {
            String invoke = TalabatNetworkModuleJWTTokenIntegrator.INSTANCE.getRefreshAndObtainAccessToken().invoke(response.request().url().toString());
            if (invoke.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return null;
            }
            sendResponseLog(response.request().url().toString(), response.message(), response.code());
            Request.Builder header = response.request().newBuilder().header("Authorization", invoke);
            if (!(header instanceof Request.Builder)) {
                request = header.build();
            } else {
                request = OkHttp3Instrumentation.build(header);
            }
            return request;
        } catch (Throwable unused) {
            return null;
        }
    }

    private final void sendResponseLog(String str, String str2, int i11) {
        RequestResponseObservability requestResponseObservability2 = this.requestResponseObservability;
        if (requestResponseObservability2 != null) {
            requestResponseObservability2.track(RegistrationInteractor.AUTH_EVENT, "api_call", MapsKt__MapsKt.mapOf(TuplesKt.to("apiPath", str), TuplesKt.to("apiStatus", "failure"), TuplesKt.to("tokenType", "jwt"), TuplesKt.to("stateType", "android"), TuplesKt.to("message", str2), TuplesKt.to("apiResponseCode", String.valueOf(i11))));
        }
    }

    @Nullable
    public Request authenticate(@Nullable Route route, @NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.code() == 401) {
            return refreshToken(response);
        }
        return null;
    }
}
