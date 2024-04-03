package n4;

import com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketConfigRequest;
import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class c implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OutgoingWebSocketConfigRequest f34565b;

    public /* synthetic */ c(OutgoingWebSocketConfigRequest outgoingWebSocketConfigRequest) {
        this.f34565b = outgoingWebSocketConfigRequest;
    }

    public final boolean test(Object obj) {
        return OkHttpWebSocketService.m8127sendConfigRequest$lambda29(this.f34565b, (IncomingWebSocketMessage.IncomingWebSocketConfigMessage) obj);
    }
}
