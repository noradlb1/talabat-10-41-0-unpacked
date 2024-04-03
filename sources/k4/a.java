package k4;

import com.deliveryhero.chatsdk.domain.ChannelImpl;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChannelImpl f34488b;

    public /* synthetic */ a(ChannelImpl channelImpl) {
        this.f34488b = channelImpl;
    }

    public final void accept(Object obj) {
        ChannelImpl.m8100getMessages$lambda5(this.f34488b, (List) obj);
    }
}
