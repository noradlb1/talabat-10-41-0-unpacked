package com.deliveryhero.chatsdk.network.websocket.okhttp.proxy;

import kotlin.Metadata;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\tH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/okhttp/proxy/ProxySocketListener;", "", "onClosed", "", "socket", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/proxy/ProxyWebSocket;", "code", "", "reason", "", "onClosing", "onFailure", "throwable", "", "onMessage", "text", "bytes", "Lokio/ByteString;", "onOpen", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ProxySocketListener {
    void onClosed(@NotNull ProxyWebSocket proxyWebSocket, int i11, @NotNull String str);

    void onClosing(@NotNull ProxyWebSocket proxyWebSocket, int i11, @NotNull String str);

    void onFailure(@NotNull Throwable th2);

    void onMessage(@NotNull ProxyWebSocket proxyWebSocket, @NotNull String str);

    void onMessage(@NotNull ProxyWebSocket proxyWebSocket, @NotNull ByteString byteString);

    void onOpen(@NotNull ProxyWebSocket proxyWebSocket);
}
