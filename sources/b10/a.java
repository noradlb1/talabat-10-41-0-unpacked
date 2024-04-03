package b10;

import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import com.android.volley.Response;
import library.talabat.mvp.checkout.CheckoutInteractor;

public final /* synthetic */ class a implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckoutInteractor f24292b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f24293c;

    public /* synthetic */ a(CheckoutInteractor checkoutInteractor, String str) {
        this.f24292b = checkoutInteractor;
        this.f24293c = str;
    }

    public final void onResponse(Object obj) {
        this.f24292b.lambda$onMenuReceived$5(this.f24293c, (SplitMenuRM) obj);
    }
}
