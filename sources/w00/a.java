package w00;

import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import com.android.volley.Response;
import library.talabat.mvp.AdyenMVP.AdyenInteractor;

public final /* synthetic */ class a implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdyenInteractor f28215b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f28216c;

    public /* synthetic */ a(AdyenInteractor adyenInteractor, String str) {
        this.f28215b = adyenInteractor;
        this.f28216c = str;
    }

    public final void onResponse(Object obj) {
        this.f28215b.lambda$onMenuReceived$0(this.f28216c, (SplitMenuRM) obj);
    }
}
