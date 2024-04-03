package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.MessageEvent;
import io.reactivex.functions.Function;

public final /* synthetic */ class g0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OkHttpWebSocketService f34572b;

    public /* synthetic */ g0(OkHttpWebSocketService okHttpWebSocketService) {
        this.f34572b = okHttpWebSocketService;
    }

    public final Object apply(Object obj) {
        return OkHttpWebSocketService.m8141sendTextMessage$lambda13(this.f34572b, (MessageEvent) obj);
    }
}
