package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.SocketEvent;
import java.util.concurrent.Callable;

public final /* synthetic */ class d0 implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SocketEvent f34568b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OkHttpWebSocketService f34569c;

    public /* synthetic */ d0(SocketEvent socketEvent, OkHttpWebSocketService okHttpWebSocketService) {
        this.f34568b = socketEvent;
        this.f34569c = okHttpWebSocketService;
    }

    public final Object call() {
        return OkHttpWebSocketService.m8115disconnect$lambda8$lambda7(this.f34568b, this.f34569c);
    }
}
