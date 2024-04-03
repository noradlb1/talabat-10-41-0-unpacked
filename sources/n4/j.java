package n4;

import com.deliveryhero.chatsdk.network.websocket.model.MessagesHistoryResponse;
import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Function;

public final /* synthetic */ class j implements Function {
    public final Object apply(Object obj) {
        return OkHttpWebSocketService.m8120getMessages$lambda37((MessagesHistoryResponse) obj);
    }
}
