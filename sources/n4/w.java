package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.SocketEvent;
import io.reactivex.functions.Function;

public final /* synthetic */ class w implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OkHttpWebSocketService f34591b;

    public /* synthetic */ w(OkHttpWebSocketService okHttpWebSocketService) {
        this.f34591b = okHttpWebSocketService;
    }

    public final Object apply(Object obj) {
        return OkHttpWebSocketService.m8114disconnect$lambda8(this.f34591b, (SocketEvent) obj);
    }
}
