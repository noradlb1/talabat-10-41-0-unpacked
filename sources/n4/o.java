package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscription;

public final /* synthetic */ class o implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OkHttpWebSocketService f34582b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34583c;

    public /* synthetic */ o(OkHttpWebSocketService okHttpWebSocketService, String str) {
        this.f34582b = okHttpWebSocketService;
        this.f34583c = str;
    }

    public final void accept(Object obj) {
        OkHttpWebSocketService.m8133sendFileMessage$lambda25(this.f34582b, this.f34583c, (Subscription) obj);
    }
}
