package l4;

import com.deliveryhero.chatsdk.domain.mapper.ChatDetailsMapper;
import com.deliveryhero.chatsdk.network.http.model.ChannelUnreadCountResponse;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChatDetailsMapper f34535b;

    public /* synthetic */ a(ChatDetailsMapper chatDetailsMapper) {
        this.f34535b = chatDetailsMapper;
    }

    public final Object apply(Object obj) {
        return this.f34535b.mapResponseToChatDetails((ChannelUnreadCountResponse) obj);
    }
}
