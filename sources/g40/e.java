package g40;

import io.reactivex.functions.Consumer;
import tracking.deeplink.DeepLinkInteractor;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeepLinkInteractor f63136b;

    public /* synthetic */ e(DeepLinkInteractor deepLinkInteractor) {
        this.f63136b = deepLinkInteractor;
    }

    public final void accept(Object obj) {
        this.f63136b.lambda$zipAppInfoAndAddressesForRequiredData$1((Throwable) obj);
    }
}
