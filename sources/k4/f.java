package k4;

import com.deliveryhero.chatsdk.domain.ChannelImpl;
import com.deliveryhero.chatsdk.domain.model.messages.UploadFile;
import io.reactivex.functions.Function;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChannelImpl f34493b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34494c;

    public /* synthetic */ f(ChannelImpl channelImpl, String str) {
        this.f34493b = channelImpl;
        this.f34494c = str;
    }

    public final Object apply(Object obj) {
        return ChannelImpl.m8101sendFileMessage$lambda4(this.f34493b, this.f34494c, (UploadFile) obj);
    }
}
