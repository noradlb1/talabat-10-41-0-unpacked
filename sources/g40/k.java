package g40;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import tracking.deeplink.DeepLinkInteractor;

public final /* synthetic */ class k implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeepLinkInteractor f63143b;

    public /* synthetic */ k(DeepLinkInteractor deepLinkInteractor) {
        this.f63143b = deepLinkInteractor;
    }

    public final void accept(Object obj) {
        this.f63143b.handleZippedResultForCountrySpecificData((Pair) obj);
    }
}
