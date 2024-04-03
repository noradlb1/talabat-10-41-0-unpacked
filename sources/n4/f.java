package n4;

import com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage;
import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Function;

public final /* synthetic */ class f implements Function {
    public final Object apply(Object obj) {
        return OkHttpWebSocketService.m8130sendConfigRequest$lambda33((IncomingWebSocketMessage.IncomingWebSocketConfigMessage) obj);
    }
}
