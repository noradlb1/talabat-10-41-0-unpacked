package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.SocketEvent;
import io.reactivex.functions.Function;

public final /* synthetic */ class l implements Function {
    public final Object apply(Object obj) {
        return OkHttpWebSocketService.m8122observeConnectionState$lambda10((SocketEvent) obj);
    }
}
