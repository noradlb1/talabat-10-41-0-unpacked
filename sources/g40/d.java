package g40;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import tracking.deeplink.DeepLinkInteractor;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeepLinkInteractor f63135b;

    public /* synthetic */ d(DeepLinkInteractor deepLinkInteractor) {
        this.f63135b = deepLinkInteractor;
    }

    public final void accept(Object obj) {
        this.f63135b.handleRequiredDataZippedResult((Pair) obj);
    }
}
