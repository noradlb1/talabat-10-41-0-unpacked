package n4;

import com.deliveryhero.chatsdk.network.websocket.model.MessageReceipt;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketLocationMessage;
import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class v implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OutgoingWebSocketLocationMessage f34590b;

    public /* synthetic */ v(OutgoingWebSocketLocationMessage outgoingWebSocketLocationMessage) {
        this.f34590b = outgoingWebSocketLocationMessage;
    }

    public final boolean test(Object obj) {
        return OkHttpWebSocketService.m8139sendLocationMessage$lambda21(this.f34590b, (MessageReceipt) obj);
    }
}
