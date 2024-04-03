package c10;

import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import com.android.volley.Response;
import library.talabat.mvp.checkoutdotcom.CheckoutDotComInteractor;

public final /* synthetic */ class a implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckoutDotComInteractor f24310b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f24311c;

    public /* synthetic */ a(CheckoutDotComInteractor checkoutDotComInteractor, String str) {
        this.f24310b = checkoutDotComInteractor;
        this.f24311c = str;
    }

    public final void onResponse(Object obj) {
        this.f24310b.lambda$onMenuReceived$0(this.f24311c, (SplitMenuRM) obj);
    }
}
