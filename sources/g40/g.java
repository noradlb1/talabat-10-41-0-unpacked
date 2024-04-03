package g40;

import JsonModels.Response.AppInitRM;
import com.android.volley.Response;
import tracking.deeplink.DeepLinkInteractor;

public final /* synthetic */ class g implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeepLinkInteractor f63139b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f63140c;

    public /* synthetic */ g(DeepLinkInteractor deepLinkInteractor, boolean z11) {
        this.f63139b = deepLinkInteractor;
        this.f63140c = z11;
    }

    public final void onResponse(Object obj) {
        this.f63139b.lambda$onAppinitCountrySpecifiedDataReceived$6(this.f63140c, (AppInitRM) obj);
    }
}
