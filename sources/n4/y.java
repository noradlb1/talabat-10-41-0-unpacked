package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.MessageEvent;
import io.reactivex.functions.Function;

public final /* synthetic */ class y implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OkHttpWebSocketService f34593b;

    public /* synthetic */ y(OkHttpWebSocketService okHttpWebSocketService) {
        this.f34593b = okHttpWebSocketService;
    }

    public final Object apply(Object obj) {
        return OkHttpWebSocketService.m8123observeIncomingMessages$lambda11(this.f34593b, (MessageEvent) obj);
    }
}
