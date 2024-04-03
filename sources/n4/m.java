package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.MessageEvent;
import io.reactivex.functions.Function;

public final /* synthetic */ class m implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OkHttpWebSocketService f34581b;

    public /* synthetic */ m(OkHttpWebSocketService okHttpWebSocketService) {
        this.f34581b = okHttpWebSocketService;
    }

    public final Object apply(Object obj) {
        return OkHttpWebSocketService.m8131sendFileMessage$lambda23(this.f34581b, (MessageEvent) obj);
    }
}
