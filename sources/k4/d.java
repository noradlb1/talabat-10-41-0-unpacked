package k4;

import com.deliveryhero.chatsdk.domain.ChannelImpl;
import com.deliveryhero.chatsdk.domain.model.messages.Message;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChannelImpl f34491b;

    public /* synthetic */ d(ChannelImpl channelImpl) {
        this.f34491b = channelImpl;
    }

    public final void accept(Object obj) {
        ChannelImpl.m8098_init_$lambda2(this.f34491b, (Message) obj);
    }
}
