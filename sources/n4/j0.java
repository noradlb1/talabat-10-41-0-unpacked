package n4;

import com.deliveryhero.chatsdk.network.websocket.model.MessageReceipt;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketTextMessage;
import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class j0 implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OutgoingWebSocketTextMessage f34578b;

    public /* synthetic */ j0(OutgoingWebSocketTextMessage outgoingWebSocketTextMessage) {
        this.f34578b = outgoingWebSocketTextMessage;
    }

    public final boolean test(Object obj) {
        return OkHttpWebSocketService.m8144sendTextMessage$lambda16(this.f34578b, (MessageReceipt) obj);
    }
}
