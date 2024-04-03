package g40;

import JsonModels.Response.AppInitRM;
import com.android.volley.Response;
import tracking.deeplink.DeepLinkInteractor;

public final /* synthetic */ class f implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeepLinkInteractor f63137b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f63138c;

    public /* synthetic */ f(DeepLinkInteractor deepLinkInteractor, boolean z11) {
        this.f63137b = deepLinkInteractor;
        this.f63138c = z11;
    }

    public final void onResponse(Object obj) {
        this.f63137b.lambda$onRequiredDataReceived$4(this.f63138c, (AppInitRM) obj);
    }
}
