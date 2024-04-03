package com.deliveryhero.chatsdk.network.websocket.okhttp.proxy;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/okhttp/proxy/ProxyConnector;", "", "connect", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/proxy/ProxyWebSocket;", "listener", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/proxy/ProxySocketListener;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ProxyConnector {
    @NotNull
    ProxyWebSocket connect(@NotNull ProxySocketListener proxySocketListener);
}
