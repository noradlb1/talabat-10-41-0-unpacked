package n4;

import com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage;
import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Function;

public final /* synthetic */ class z implements Function {
    public final Object apply(Object obj) {
        return OkHttpWebSocketService.m8124observeIncomingMessages$lambda12((IncomingWebSocketMessage) obj);
    }
}
