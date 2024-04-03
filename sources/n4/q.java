package n4;

import com.deliveryhero.chatsdk.network.websocket.model.MessageReceipt;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketFileMessage;
import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Function;

public final /* synthetic */ class q implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OutgoingWebSocketFileMessage f34585b;

    public /* synthetic */ q(OutgoingWebSocketFileMessage outgoingWebSocketFileMessage) {
        this.f34585b = outgoingWebSocketFileMessage;
    }

    public final Object apply(Object obj) {
        return OkHttpWebSocketService.m8135sendFileMessage$lambda27(this.f34585b, (MessageReceipt) obj);
    }
}
