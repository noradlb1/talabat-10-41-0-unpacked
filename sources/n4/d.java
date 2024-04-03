package n4;

import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscription;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OkHttpWebSocketService f34566b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34567c;

    public /* synthetic */ d(OkHttpWebSocketService okHttpWebSocketService, String str) {
        this.f34566b = okHttpWebSocketService;
        this.f34567c = str;
    }

    public final void accept(Object obj) {
        OkHttpWebSocketService.m8128sendConfigRequest$lambda30(this.f34566b, this.f34567c, (Subscription) obj);
    }
}
