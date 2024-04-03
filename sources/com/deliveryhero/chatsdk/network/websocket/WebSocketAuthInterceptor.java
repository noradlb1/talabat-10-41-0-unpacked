package com.deliveryhero.chatsdk.network.websocket;

import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.model.Events;
import com.deliveryhero.contract.model.UserInfo;
import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/WebSocketAuthInterceptor;", "Lokhttp3/Interceptor;", "chatConfigProvider", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "chatLogger", "Lcom/deliveryhero/contract/ChatLogger;", "(Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;Lcom/deliveryhero/contract/ChatLogger;)V", "authToken", "", "getAuthToken", "()Ljava/lang/String;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WebSocketAuthInterceptor implements Interceptor {
    @NotNull
    private final ChatConfigProvider chatConfigProvider;
    @Nullable
    private final ChatLogger chatLogger;

    public WebSocketAuthInterceptor(@NotNull ChatConfigProvider chatConfigProvider2, @Nullable ChatLogger chatLogger2) {
        Intrinsics.checkNotNullParameter(chatConfigProvider2, "chatConfigProvider");
        this.chatConfigProvider = chatConfigProvider2;
        this.chatLogger = chatLogger2;
    }

    @NotNull
    public final String getAuthToken() {
        String str;
        boolean z11;
        ChatLogger chatLogger2;
        UserInfo userInfo;
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (chatConfiguration == null || (userInfo = chatConfiguration.getUserInfo()) == null) {
            str = null;
        } else {
            str = userInfo.getDhAuthToken();
        }
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && (chatLogger2 = this.chatLogger) != null) {
            chatLogger2.log(Events.GCC_INVALID_AUTH_TOKEN, MapsKt__MapsKt.emptyMap());
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request request;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder header = chain.request().newBuilder().header("Auth", getAuthToken());
        if (!(header instanceof Request.Builder)) {
            request = header.build();
        } else {
            request = OkHttp3Instrumentation.build(header);
        }
        Response proceed = chain.proceed(request);
        Intrinsics.checkNotNullExpressionValue(proceed, "chain.proceed(request)");
        return proceed;
    }
}
