package n4;

import com.deliveryhero.chatsdk.network.websocket.model.MessageReceipt;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketFileMessage;
import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class p implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OutgoingWebSocketFileMessage f34584b;

    public /* synthetic */ p(OutgoingWebSocketFileMessage outgoingWebSocketFileMessage) {
        this.f34584b = outgoingWebSocketFileMessage;
    }

    public final boolean test(Object obj) {
        return OkHttpWebSocketService.m8134sendFileMessage$lambda26(this.f34584b, (MessageReceipt) obj);
    }
}
