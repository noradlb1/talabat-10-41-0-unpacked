package n4;

import com.deliveryhero.chatsdk.network.websocket.model.MessageReceipt;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketTextMessage;
import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Function;

public final /* synthetic */ class k0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OutgoingWebSocketTextMessage f34579b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34580c;

    public /* synthetic */ k0(OutgoingWebSocketTextMessage outgoingWebSocketTextMessage, String str) {
        this.f34579b = outgoingWebSocketTextMessage;
        this.f34580c = str;
    }

    public final Object apply(Object obj) {
        return OkHttpWebSocketService.m8145sendTextMessage$lambda17(this.f34579b, this.f34580c, (MessageReceipt) obj);
    }
}
