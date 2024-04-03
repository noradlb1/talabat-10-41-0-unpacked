package n4;

import com.deliveryhero.chatsdk.network.websocket.model.MessageReceipt;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketLocationMessage;
import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Function;

public final /* synthetic */ class x implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OutgoingWebSocketLocationMessage f34592b;

    public /* synthetic */ x(OutgoingWebSocketLocationMessage outgoingWebSocketLocationMessage) {
        this.f34592b = outgoingWebSocketLocationMessage;
    }

    public final Object apply(Object obj) {
        return OkHttpWebSocketService.m8140sendLocationMessage$lambda22(this.f34592b, (MessageReceipt) obj);
    }
}
