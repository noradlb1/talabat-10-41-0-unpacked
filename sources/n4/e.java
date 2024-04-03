package n4;

import com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketConfigRequest;
import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class e implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OutgoingWebSocketConfigRequest f34570b;

    public /* synthetic */ e(OutgoingWebSocketConfigRequest outgoingWebSocketConfigRequest) {
        this.f34570b = outgoingWebSocketConfigRequest;
    }

    public final boolean test(Object obj) {
        return OkHttpWebSocketService.m8129sendConfigRequest$lambda31(this.f34570b, (IncomingWebSocketMessage.IncomingWebSocketConfigMessage) obj);
    }
}
