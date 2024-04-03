package k4;

import com.deliveryhero.chatsdk.domain.ChannelImpl;
import com.deliveryhero.chatsdk.domain.model.messages.Message;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class c implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChannelImpl f34490b;

    public /* synthetic */ c(ChannelImpl channelImpl) {
        this.f34490b = channelImpl;
    }

    public final boolean test(Object obj) {
        return ChannelImpl.m8097_init_$lambda1(this.f34490b, (Message) obj);
    }
}
