package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.SocketEvent;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SocketEvent f34560b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OkHttpWebSocketService f34561c;

    public /* synthetic */ a(SocketEvent socketEvent, OkHttpWebSocketService okHttpWebSocketService) {
        this.f34560b = socketEvent;
        this.f34561c = okHttpWebSocketService;
    }

    public final Object call() {
        return OkHttpWebSocketService.m8110connect$lambda2$lambda1(this.f34560b, this.f34561c);
    }
}
