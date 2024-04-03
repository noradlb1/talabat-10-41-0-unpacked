package k4;

import com.deliveryhero.chatsdk.domain.ChannelImpl;
import com.deliveryhero.chatsdk.domain.model.messages.Message;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class b implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChannelImpl f34489b;

    public /* synthetic */ b(ChannelImpl channelImpl) {
        this.f34489b = channelImpl;
    }

    public final boolean test(Object obj) {
        return ChannelImpl.m8096_init_$lambda0(this.f34489b, (Message) obj);
    }
}
