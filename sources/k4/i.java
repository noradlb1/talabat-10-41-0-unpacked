package k4;

import com.deliveryhero.chatsdk.domain.RealChatSdk;
import com.deliveryhero.chatsdk.domain.model.ConnectionState;
import io.reactivex.functions.Function;

public final /* synthetic */ class i implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RealChatSdk f34497b;

    public /* synthetic */ i(RealChatSdk realChatSdk) {
        this.f34497b = realChatSdk;
    }

    public final Object apply(Object obj) {
        return RealChatSdk.m8103connect$lambda1(this.f34497b, (ConnectionState) obj);
    }
}
