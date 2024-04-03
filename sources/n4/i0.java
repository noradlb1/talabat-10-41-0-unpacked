package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscription;

public final /* synthetic */ class i0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OkHttpWebSocketService f34576b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34577c;

    public /* synthetic */ i0(OkHttpWebSocketService okHttpWebSocketService, String str) {
        this.f34576b = okHttpWebSocketService;
        this.f34577c = str;
    }

    public final void accept(Object obj) {
        OkHttpWebSocketService.m8143sendTextMessage$lambda15(this.f34576b, this.f34577c, (Subscription) obj);
    }
}
