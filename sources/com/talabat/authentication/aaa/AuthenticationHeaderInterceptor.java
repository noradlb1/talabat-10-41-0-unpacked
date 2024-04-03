package com.talabat.authentication.aaa;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.talabat.core.network.network.TalabatNetworkModuleIntegrator;
import com.talabat.core.network.network.TalabatNetworkModuleJWTTokenIntegrator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/talabat/authentication/aaa/AuthenticationHeaderInterceptor;", "Lokhttp3/Interceptor;", "()V", "getAvailableToken", "", "chain", "Lokhttp3/Interceptor$Chain;", "getJWTAccessTokenHeaderValue", "getOWINAccessTokenHeaderValue", "intercept", "Lokhttp3/Response;", "isDifferentThanExchangeApi", "", "isJWTTokenAvailable", "isOwinTokenAvailable", "Companion", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AuthenticationHeaderInterceptor implements Interceptor {
    @NotNull
    @Deprecated
    public static final String API_KEY = "android";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/authentication/aaa/AuthenticationHeaderInterceptor$Companion;", "", "()V", "API_KEY", "", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String getAvailableToken(Interceptor.Chain chain) {
        if (isJWTTokenAvailable() && isDifferentThanExchangeApi(chain)) {
            return getJWTAccessTokenHeaderValue();
        }
        if (isOwinTokenAvailable()) {
            return getOWINAccessTokenHeaderValue();
        }
        return null;
    }

    private final String getJWTAccessTokenHeaderValue() {
        TalabatNetworkModuleJWTTokenIntegrator talabatNetworkModuleJWTTokenIntegrator = TalabatNetworkModuleJWTTokenIntegrator.INSTANCE;
        String invoke = talabatNetworkModuleJWTTokenIntegrator.getGetTokenType().invoke();
        String invoke2 = talabatNetworkModuleJWTTokenIntegrator.getGetAccessToken().invoke();
        return invoke + " " + invoke2;
    }

    private final String getOWINAccessTokenHeaderValue() {
        boolean z11;
        String str;
        TalabatNetworkModuleIntegrator talabatNetworkModuleIntegrator = TalabatNetworkModuleIntegrator.INSTANCE;
        String invoke = talabatNetworkModuleIntegrator.getGetTokenType().invoke();
        if (invoke != null) {
            if (invoke.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                StringBuilder sb2 = new StringBuilder();
                char charAt = invoke.charAt(0);
                if (Character.isLowerCase(charAt)) {
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                    str = CharsKt__CharJVMKt.titlecase(charAt, locale);
                } else {
                    str = String.valueOf(charAt);
                }
                sb2.append(str);
                String substring = invoke.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                sb2.append(substring);
                invoke = sb2.toString();
            }
        } else {
            invoke = null;
        }
        return invoke + " " + talabatNetworkModuleIntegrator.getGetAccessToken().invoke();
    }

    private final boolean isDifferentThanExchangeApi(Interceptor.Chain chain) {
        if (chain.request().url().encodedPath() != null) {
            if (!new Regex("/v5/oauth2/migration/exchange").containsMatchIn(chain.request().url().encodedPath())) {
                return true;
            }
        }
        return false;
    }

    private final boolean isJWTTokenAvailable() {
        return TalabatNetworkModuleJWTTokenIntegrator.INSTANCE.isTokenAvailable().invoke().booleanValue();
    }

    private final boolean isOwinTokenAvailable() {
        return TalabatNetworkModuleIntegrator.INSTANCE.getTokenAvailable().invoke().booleanValue();
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request request;
        boolean z11;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder addHeader = chain.request().newBuilder().addHeader("X-Fp-Api-Key", "android");
        String str = chain.request().headers().get("X-Global-Entity-ID");
        boolean z12 = false;
        if (str != null) {
            if (str.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                z12 = true;
            }
        }
        if (z12) {
            addHeader.addHeader("X-Global-Entity-ID", TalabatNetworkModuleJWTTokenIntegrator.INSTANCE.getGlobalEntityId().invoke());
        }
        String availableToken = getAvailableToken(chain);
        if (availableToken != null) {
            addHeader.addHeader("Authorization", availableToken);
        }
        if (isJWTTokenAvailable()) {
            TalabatNetworkModuleJWTTokenIntegrator talabatNetworkModuleJWTTokenIntegrator = TalabatNetworkModuleJWTTokenIntegrator.INSTANCE;
            String invoke = talabatNetworkModuleJWTTokenIntegrator.getGetDeviceToken().invoke();
            addHeader.addHeader("X-Device", talabatNetworkModuleJWTTokenIntegrator.getGetDeviceToken().invoke());
        }
        if (!(addHeader instanceof Request.Builder)) {
            request = addHeader.build();
        } else {
            request = OkHttp3Instrumentation.build(addHeader);
        }
        return chain.proceed(request);
    }
}
