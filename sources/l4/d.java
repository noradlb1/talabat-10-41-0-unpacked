package l4;

import com.deliveryhero.chatsdk.network.SocketRepositoryImpl;
import com.deliveryhero.chatsdk.network.websocket.model.MessageReceipt;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class d implements Predicate {
    public final boolean test(Object obj) {
        return SocketRepositoryImpl.m8107observeReadReceipts$lambda0((MessageReceipt) obj);
    }
}
