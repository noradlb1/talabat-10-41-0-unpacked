package n4;

import com.deliveryhero.chatsdk.network.websocket.model.MessageReceipt;
import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class t implements Predicate {
    public final boolean test(Object obj) {
        return OkHttpWebSocketService.m8137sendLocationMessage$lambda19((MessageReceipt) obj);
    }
}
