package g40;

import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import com.android.volley.Response;
import tracking.deeplink.DeepLinkInteractor;

public final /* synthetic */ class i implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeepLinkInteractor f63142b;

    public /* synthetic */ i(DeepLinkInteractor deepLinkInteractor) {
        this.f63142b = deepLinkInteractor;
    }

    public final void onResponse(Object obj) {
        this.f63142b.lambda$onMenuReceived$0((SplitMenuRM) obj);
    }
}
