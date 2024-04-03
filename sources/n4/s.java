package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.MessageEvent;
import io.reactivex.functions.Function;

public final /* synthetic */ class s implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OkHttpWebSocketService f34587b;

    public /* synthetic */ s(OkHttpWebSocketService okHttpWebSocketService) {
        this.f34587b = okHttpWebSocketService;
    }

    public final Object apply(Object obj) {
        return OkHttpWebSocketService.m8136sendLocationMessage$lambda18(this.f34587b, (MessageEvent) obj);
    }
}
