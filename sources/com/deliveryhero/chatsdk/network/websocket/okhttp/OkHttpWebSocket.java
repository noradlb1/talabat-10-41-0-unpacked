package com.deliveryhero.chatsdk.network.websocket.okhttp;

import com.deliveryhero.chatsdk.network.websocket.okhttp.proxy.ProxyWebSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.WebSocket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/okhttp/OkHttpWebSocket;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/proxy/ProxyWebSocket;", "webSocket", "Lokhttp3/WebSocket;", "(Lokhttp3/WebSocket;)V", "close", "", "code", "", "reason", "", "send", "item", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OkHttpWebSocket implements ProxyWebSocket {
    @NotNull
    private final WebSocket webSocket;

    public OkHttpWebSocket(@NotNull WebSocket webSocket2) {
        Intrinsics.checkNotNullParameter(webSocket2, "webSocket");
        this.webSocket = webSocket2;
    }

    public boolean close(int i11, @Nullable String str) {
        return this.webSocket.close(i11, str);
    }

    public boolean send(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "item");
        return this.webSocket.send(str);
    }
}
