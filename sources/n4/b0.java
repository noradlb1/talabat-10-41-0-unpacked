package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.SocketEvent;
import io.reactivex.functions.Function;

public final /* synthetic */ class b0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OkHttpWebSocketService f34564b;

    public /* synthetic */ b0(OkHttpWebSocketService okHttpWebSocketService) {
        this.f34564b = okHttpWebSocketService;
    }

    public final Object apply(Object obj) {
        return OkHttpWebSocketService.m8111connect$lambda4(this.f34564b, (SocketEvent) obj);
    }
}
