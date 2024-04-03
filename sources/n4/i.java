package n4;

import com.deliveryhero.chatsdk.network.websocket.model.MessagesHistoryRequest;
import com.deliveryhero.chatsdk.network.websocket.model.MessagesHistoryResponse;
import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class i implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MessagesHistoryRequest f34575b;

    public /* synthetic */ i(MessagesHistoryRequest messagesHistoryRequest) {
        this.f34575b = messagesHistoryRequest;
    }

    public final boolean test(Object obj) {
        return OkHttpWebSocketService.m8119getMessages$lambda36(this.f34575b, (MessagesHistoryResponse) obj);
    }
}
