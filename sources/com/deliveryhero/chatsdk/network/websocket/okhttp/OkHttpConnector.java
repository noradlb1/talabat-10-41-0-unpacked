package com.deliveryhero.chatsdk.network.websocket.okhttp;

import com.deliveryhero.chatsdk.network.websocket.okhttp.proxy.ProxyConnector;
import com.deliveryhero.chatsdk.network.websocket.okhttp.proxy.ProxySocketListener;
import com.deliveryhero.chatsdk.network.websocket.okhttp.proxy.ProxyWebSocket;
import com.deliveryhero.customerchat.eventTracking.constants.ContactDetailsKeys;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/okhttp/OkHttpConnector;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/proxy/ProxyConnector;", "client", "Lokhttp3/OkHttpClient;", "request", "Lokhttp3/Request;", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;)V", "connect", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/proxy/ProxyWebSocket;", "listener", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/proxy/ProxySocketListener;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OkHttpConnector implements ProxyConnector {
    @NotNull
    private final OkHttpClient client;
    @NotNull
    private final Request request;

    public OkHttpConnector(@NotNull OkHttpClient okHttpClient, @NotNull Request request2) {
        Intrinsics.checkNotNullParameter(okHttpClient, ContactDetailsKeys.SENT_FROM_VALUE);
        Intrinsics.checkNotNullParameter(request2, "request");
        this.client = okHttpClient;
        this.request = request2;
    }

    @NotNull
    public ProxyWebSocket connect(@NotNull ProxySocketListener proxySocketListener) {
        Intrinsics.checkNotNullParameter(proxySocketListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        AtomicReference atomicReference = new AtomicReference();
        WebSocket newWebSocket = this.client.newWebSocket(this.request, new OkHttpConnector$connect$actualSocket$1(proxySocketListener, atomicReference));
        Intrinsics.checkNotNullExpressionValue(newWebSocket, "actualSocket");
        OkHttpWebSocket okHttpWebSocket = new OkHttpWebSocket(newWebSocket);
        atomicReference.set(okHttpWebSocket);
        return okHttpWebSocket;
    }
}
