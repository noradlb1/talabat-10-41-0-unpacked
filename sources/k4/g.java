package k4;

import com.deliveryhero.chatsdk.domain.RealChatSdk;
import com.deliveryhero.chatsdk.domain.model.ConnectionState;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RealChatSdk f34495b;

    public /* synthetic */ g(RealChatSdk realChatSdk) {
        this.f34495b = realChatSdk;
    }

    public final void accept(Object obj) {
        RealChatSdk.m8102_init_$lambda0(this.f34495b, (ConnectionState) obj);
    }
}
