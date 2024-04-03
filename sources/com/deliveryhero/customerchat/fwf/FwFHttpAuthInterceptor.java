package com.deliveryhero.customerchat.fwf;

import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.model.ClientConfig;
import com.deliveryhero.contract.model.DhEnvironment;
import com.deliveryhero.customerchat.BuildConfig;
import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/deliveryhero/customerchat/fwf/FwFHttpAuthInterceptor;", "Lokhttp3/Interceptor;", "chatConfigProvider", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "(Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FwFHttpAuthInterceptor implements Interceptor {
    @NotNull
    private final ChatConfigProvider chatConfigProvider;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DhEnvironment.values().length];
            iArr[DhEnvironment.STAGING.ordinal()] = 1;
            iArr[DhEnvironment.TESTING.ordinal()] = 2;
            iArr[DhEnvironment.PRODUCTION.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FwFHttpAuthInterceptor(@NotNull ChatConfigProvider chatConfigProvider2) {
        Intrinsics.checkNotNullParameter(chatConfigProvider2, "chatConfigProvider");
        this.chatConfigProvider = chatConfigProvider2;
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        DhEnvironment dhEnvironment;
        int i11;
        String str;
        Request request;
        ClientConfig clientConfigOrNull;
        Intrinsics.checkNotNullParameter(chain, "chain");
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (chatConfiguration == null || (clientConfigOrNull = chatConfiguration.getClientConfigOrNull()) == null) {
            dhEnvironment = null;
        } else {
            dhEnvironment = clientConfigOrNull.getDhEnvironment();
        }
        if (dhEnvironment == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[dhEnvironment.ordinal()];
        }
        if (i11 == 1 || i11 == 2) {
            str = BuildConfig.FUN_WITH_FLAGS_STAGING_TOKEN;
        } else if (i11 != 3) {
            str = "";
        } else {
            str = BuildConfig.FUN_WITH_FLAGS_TOKEN;
        }
        Request.Builder addHeader = chain.request().newBuilder().addHeader("Authorization", str);
        if (!(addHeader instanceof Request.Builder)) {
            request = addHeader.build();
        } else {
            request = OkHttp3Instrumentation.build(addHeader);
        }
        Response proceed = chain.proceed(request);
        Intrinsics.checkNotNullExpressionValue(proceed, "chain.proceed(request)");
        return proceed;
    }
}
