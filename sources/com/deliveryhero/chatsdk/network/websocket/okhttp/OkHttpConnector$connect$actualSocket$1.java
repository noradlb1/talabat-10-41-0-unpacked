package com.deliveryhero.chatsdk.network.websocket.okhttp;

import com.deliveryhero.chatsdk.network.websocket.okhttp.proxy.ProxySocketListener;
import com.deliveryhero.chatsdk.network.websocket.okhttp.proxy.ProxyWebSocket;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0015"}, d2 = {"com/deliveryhero/chatsdk/network/websocket/okhttp/OkHttpConnector$connect$actualSocket$1", "Lokhttp3/WebSocketListener;", "onClosed", "", "webSocket", "Lokhttp3/WebSocket;", "code", "", "reason", "", "onClosing", "onFailure", "throwable", "", "response", "Lokhttp3/Response;", "onMessage", "text", "bytes", "Lokio/ByteString;", "onOpen", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OkHttpConnector$connect$actualSocket$1 extends WebSocketListener {
    final /* synthetic */ ProxySocketListener $listener;
    final /* synthetic */ AtomicReference<ProxyWebSocket> $webSocketRef;

    public OkHttpConnector$connect$actualSocket$1(ProxySocketListener proxySocketListener, AtomicReference<ProxyWebSocket> atomicReference) {
        this.$listener = proxySocketListener;
        this.$webSocketRef = atomicReference;
    }

    public void onClosed(@NotNull WebSocket webSocket, int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "reason");
        ProxySocketListener proxySocketListener = this.$listener;
        ProxyWebSocket proxyWebSocket = this.$webSocketRef.get();
        Intrinsics.checkNotNullExpressionValue(proxyWebSocket, "webSocketRef.get()");
        proxySocketListener.onClosed(proxyWebSocket, i11, str);
    }

    public void onClosing(@NotNull WebSocket webSocket, int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "reason");
        ProxySocketListener proxySocketListener = this.$listener;
        ProxyWebSocket proxyWebSocket = this.$webSocketRef.get();
        Intrinsics.checkNotNullExpressionValue(proxyWebSocket, "webSocketRef.get()");
        proxySocketListener.onClosing(proxyWebSocket, i11, str);
    }

    public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable th2, @Nullable Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(th2, "throwable");
        this.$listener.onFailure(th2);
    }

    public void onMessage(@NotNull WebSocket webSocket, @NotNull String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "text");
        ProxySocketListener proxySocketListener = this.$listener;
        ProxyWebSocket proxyWebSocket = this.$webSocketRef.get();
        Intrinsics.checkNotNullExpressionValue(proxyWebSocket, "webSocketRef.get()");
        proxySocketListener.onMessage(proxyWebSocket, str);
    }

    public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(response, "response");
        ProxySocketListener proxySocketListener = this.$listener;
        ProxyWebSocket proxyWebSocket = this.$webSocketRef.get();
        Intrinsics.checkNotNullExpressionValue(proxyWebSocket, "webSocketRef.get()");
        proxySocketListener.onOpen(proxyWebSocket);
    }

    public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        ProxySocketListener proxySocketListener = this.$listener;
        ProxyWebSocket proxyWebSocket = this.$webSocketRef.get();
        Intrinsics.checkNotNullExpressionValue(proxyWebSocket, "webSocketRef.get()");
        proxySocketListener.onMessage(proxyWebSocket, byteString);
    }
}
