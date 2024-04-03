package com.deliveryhero.chatsdk.network.websocket.okhttp;

import com.deliveryhero.chatsdk.network.websocket.okhttp.model.MessageEvent;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.SocketEvent;
import com.deliveryhero.chatsdk.network.websocket.okhttp.proxy.ProxySocketListener;
import com.deliveryhero.chatsdk.network.websocket.okhttp.proxy.ProxyWebSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0013"}, d2 = {"com/deliveryhero/chatsdk/network/websocket/okhttp/OkHttpWebSocketService$connectInternal$1", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/proxy/ProxySocketListener;", "onClosed", "", "socket", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/proxy/ProxyWebSocket;", "code", "", "reason", "", "onClosing", "onFailure", "throwable", "", "onMessage", "text", "bytes", "Lokio/ByteString;", "onOpen", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OkHttpWebSocketService$connectInternal$1 implements ProxySocketListener {
    final /* synthetic */ OkHttpWebSocketService this$0;

    public OkHttpWebSocketService$connectInternal$1(OkHttpWebSocketService okHttpWebSocketService) {
        this.this$0 = okHttpWebSocketService;
    }

    public void onClosed(@NotNull ProxyWebSocket proxyWebSocket, int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(proxyWebSocket, "socket");
        Intrinsics.checkNotNullParameter(str, "reason");
        this.this$0.statePublisher.onNext(new SocketEvent.Closed(i11, str));
    }

    public void onClosing(@NotNull ProxyWebSocket proxyWebSocket, int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(proxyWebSocket, "socket");
        Intrinsics.checkNotNullParameter(str, "reason");
        this.this$0.statePublisher.onNext(new SocketEvent.Closing(i11, str));
    }

    public void onFailure(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        this.this$0.statePublisher.onNext(new SocketEvent.Failed(th2));
    }

    public void onMessage(@NotNull ProxyWebSocket proxyWebSocket, @NotNull String str) {
        Intrinsics.checkNotNullParameter(proxyWebSocket, "socket");
        Intrinsics.checkNotNullParameter(str, "text");
        this.this$0.messagePublisher.onNext(new MessageEvent.TextReceived(str));
    }

    public void onOpen(@NotNull ProxyWebSocket proxyWebSocket) {
        Intrinsics.checkNotNullParameter(proxyWebSocket, "socket");
        this.this$0.statePublisher.onNext(SocketEvent.Open.INSTANCE);
    }

    public void onMessage(@NotNull ProxyWebSocket proxyWebSocket, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(proxyWebSocket, "socket");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        this.this$0.messagePublisher.onNext(new MessageEvent.ByteReceived(byteString));
    }
}
