package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.MessageEvent;
import io.reactivex.functions.Function;

public final /* synthetic */ class r implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OkHttpWebSocketService f34586b;

    public /* synthetic */ r(OkHttpWebSocketService okHttpWebSocketService) {
        this.f34586b = okHttpWebSocketService;
    }

    public final Object apply(Object obj) {
        return OkHttpWebSocketService.m8125observeReadReceipt$lambda40(this.f34586b, (MessageEvent) obj);
    }
}
