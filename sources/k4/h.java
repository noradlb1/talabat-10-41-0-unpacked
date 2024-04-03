package k4;

import com.deliveryhero.chatsdk.domain.RealChatSdk;
import io.reactivex.functions.Action;

public final /* synthetic */ class h implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RealChatSdk f34496b;

    public /* synthetic */ h(RealChatSdk realChatSdk) {
        this.f34496b = realChatSdk;
    }

    public final void run() {
        RealChatSdk.m8104disconnect$lambda2(this.f34496b);
    }
}
