package k4;

import com.deliveryhero.chatsdk.domain.ChannelImpl;
import com.deliveryhero.chatsdk.network.websocket.model.MessageReceipt;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class e implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChannelImpl f34492b;

    public /* synthetic */ e(ChannelImpl channelImpl) {
        this.f34492b = channelImpl;
    }

    public final boolean test(Object obj) {
        return ChannelImpl.m8099_init_$lambda3(this.f34492b, (MessageReceipt) obj);
    }
}
