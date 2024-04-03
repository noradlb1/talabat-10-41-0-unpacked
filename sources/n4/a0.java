package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.SocketEvent;
import io.reactivex.functions.Function;

public final /* synthetic */ class a0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OkHttpWebSocketService f34562b;

    public /* synthetic */ a0(OkHttpWebSocketService okHttpWebSocketService) {
        this.f34562b = okHttpWebSocketService;
    }

    public final Object apply(Object obj) {
        return OkHttpWebSocketService.m8109connect$lambda2(this.f34562b, (SocketEvent) obj);
    }
}
