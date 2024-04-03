package com.talabat.core.network.network;

import com.google.common.net.HttpHeaders;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.talabat.core.observabilityNew.domain.RequestResponseObservability;
import com.talabat.registration.RegistrationInteractor;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J \u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J0\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/network/network/TalabatHttpInterceptor;", "Lokhttp3/Interceptor;", "requestResponseObservability", "Lcom/talabat/core/observabilityNew/domain/RequestResponseObservability;", "(Lcom/talabat/core/observabilityNew/domain/RequestResponseObservability;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "logResponse", "", "apiPath", "", "response", "tokenType", "message", "sendRequestLog", "sendResponseLog", "apiStatus", "responseCode", "", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatHttpInterceptor implements Interceptor {
    @Nullable
    private final RequestResponseObservability requestResponseObservability;

    public TalabatHttpInterceptor(@Nullable RequestResponseObservability requestResponseObservability2) {
        this.requestResponseObservability = requestResponseObservability2;
    }

    private final void logResponse(String str, Response response, String str2, String str3) {
        String str4;
        if (response.isSuccessful()) {
            str4 = "success";
        } else {
            str3 = response.message();
            str4 = "failure";
        }
        String str5 = str;
        sendResponseLog(str5, str4, str2, str3, response.code());
    }

    private final void sendRequestLog(String str, String str2, String str3) {
        RequestResponseObservability requestResponseObservability2 = this.requestResponseObservability;
        if (requestResponseObservability2 != null) {
            requestResponseObservability2.track(RegistrationInteractor.AUTH_EVENT, "api_call", MapsKt__MapsKt.mapOf(TuplesKt.to("apiPath", str), TuplesKt.to("apiStatus", "loading"), TuplesKt.to("tokenType", str2), TuplesKt.to("stateType", "android"), TuplesKt.to("message", str3)));
        }
    }

    private final void sendResponseLog(String str, String str2, String str3, String str4, int i11) {
        RequestResponseObservability requestResponseObservability2 = this.requestResponseObservability;
        if (requestResponseObservability2 != null) {
            requestResponseObservability2.track(RegistrationInteractor.AUTH_EVENT, "api_call", MapsKt__MapsKt.mapOf(TuplesKt.to("apiPath", str), TuplesKt.to("apiStatus", str2), TuplesKt.to("tokenType", str3), TuplesKt.to("stateType", "android"), TuplesKt.to("message", str4), TuplesKt.to("apiResponseCode", String.valueOf(i11))));
        }
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        boolean z11;
        String str;
        String str2;
        Request request;
        boolean z12;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder newBuilder = chain.request().newBuilder();
        TalabatNetworkModuleIntegrator talabatNetworkModuleIntegrator = TalabatNetworkModuleIntegrator.INSTANCE;
        Request.Builder addHeader = newBuilder.addHeader(HttpHeaders.ACCEPT_LANGUAGE, String.valueOf(talabatNetworkModuleIntegrator.getGetSelectedLanguage().invoke())).addHeader("X-Device-Source", "6").addHeader("BrandType", "1").addHeader("AppBrand", "1").addHeader("X-PerseusSessionId", String.valueOf(talabatNetworkModuleIntegrator.getGetMySessionId().invoke())).addHeader("X-PerseusClientId", String.valueOf(talabatNetworkModuleIntegrator.getGetMyClientId().invoke())).addHeader("X-Device-Version", talabatNetworkModuleIntegrator.getGetVersion().invoke()).addHeader("X-Device-ID", talabatNetworkModuleIntegrator.getDeviceId().invoke());
        String httpUrl = chain.request().url().toString();
        TalabatNetworkModuleJWTTokenIntegrator talabatNetworkModuleJWTTokenIntegrator = TalabatNetworkModuleJWTTokenIntegrator.INSTANCE;
        talabatNetworkModuleJWTTokenIntegrator.getJWTFeatureEnable().invoke(httpUrl);
        String invoke = talabatNetworkModuleJWTTokenIntegrator.getObtainAccessToken().invoke(httpUrl);
        boolean z13 = true;
        if (invoke.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        String str3 = null;
        if (z11 && !Intrinsics.areEqual((Object) invoke, (Object) "null")) {
            int i11 = 0;
            for (int i12 = 0; i12 < invoke.length(); i12++) {
                if (invoke.charAt(i12) == '.') {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    i11++;
                }
            }
            Integer valueOf = Integer.valueOf(i11);
            if (valueOf.intValue() <= 0) {
                z13 = false;
            }
            if (!z13) {
                valueOf = null;
            }
            if (valueOf != null) {
                valueOf.intValue();
                str2 = "jwt";
            } else {
                str2 = "owin";
            }
            str = str2 + " is valid";
            addHeader.addHeader("Authorization", TalabatNetworkModuleJWTTokenIntegrator.INSTANCE.getGetTokenType().invoke() + " " + invoke);
        } else if (talabatNetworkModuleIntegrator.getTokenAvailable().invoke().booleanValue()) {
            addHeader.addHeader("Authorization", talabatNetworkModuleIntegrator.getGetTokenType().invoke() + " " + talabatNetworkModuleIntegrator.getGetAccessToken().invoke());
            str = "jwt is nil";
            str2 = "owin";
        } else {
            str2 = "guest";
            str = "NA";
        }
        addHeader.addHeader("AuthTokenType", str2);
        Request build = OkHttp3Instrumentation.build(addHeader);
        String httpUrl2 = build.url().toString();
        sendRequestLog(httpUrl2, str2, str);
        Response proceed = chain.proceed(build);
        if (proceed.code() >= 500 && Intrinsics.areEqual((Object) str2, (Object) "jwt")) {
            TalabatNetworkModuleIntegrator talabatNetworkModuleIntegrator2 = TalabatNetworkModuleIntegrator.INSTANCE;
            String invoke2 = talabatNetworkModuleIntegrator2.getGetAccessToken().invoke();
            if (invoke2 != null) {
                if (!talabatNetworkModuleIntegrator2.getShouldStopUseOwinToken().invoke().booleanValue()) {
                    str3 = invoke2;
                }
                if (str3 != null) {
                    Request.Builder addHeader2 = addHeader.removeHeader("Authorization").removeHeader("AuthTokenType").addHeader("Authorization", talabatNetworkModuleIntegrator2.getGetTokenType().invoke() + " " + str3).addHeader("AuthTokenType", "owin");
                    if (!(addHeader2 instanceof Request.Builder)) {
                        request = addHeader2.build();
                    } else {
                        request = OkHttp3Instrumentation.build(addHeader2);
                    }
                    ResponseBody body = proceed.body();
                    if (body != null) {
                        body.close();
                    }
                    Response proceed2 = chain.proceed(request);
                    logResponse(httpUrl2, proceed2, "owin", str);
                    return proceed2;
                }
            }
        }
        logResponse(httpUrl2, proceed, str2, str);
        return proceed;
    }
}
