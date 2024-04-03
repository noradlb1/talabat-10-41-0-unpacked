package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.SocketEvent;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class e0 implements Predicate {
    public final boolean test(Object obj) {
        return OkHttpWebSocketService.m8116disconnect$lambda9((SocketEvent) obj);
    }
}
