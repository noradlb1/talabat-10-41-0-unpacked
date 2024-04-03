package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscription;

public final /* synthetic */ class u implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OkHttpWebSocketService f34588b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34589c;

    public /* synthetic */ u(OkHttpWebSocketService okHttpWebSocketService, String str) {
        this.f34588b = okHttpWebSocketService;
        this.f34589c = str;
    }

    public final void accept(Object obj) {
        OkHttpWebSocketService.m8138sendLocationMessage$lambda20(this.f34588b, this.f34589c, (Subscription) obj);
    }
}
