package g40;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import tracking.deeplink.DeepLinkInteractor;

public final /* synthetic */ class a implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeepLinkInteractor f63133a;

    public /* synthetic */ a(DeepLinkInteractor deepLinkInteractor) {
        this.f63133a = deepLinkInteractor;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        this.f63133a.lambda$getAppInfoSingle$3(singleEmitter);
    }
}
