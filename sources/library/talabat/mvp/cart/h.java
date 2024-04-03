package library.talabat.mvp.cart;

import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import com.android.volley.Response;

public final /* synthetic */ class h implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartInteractor f26641b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f26642c;

    public /* synthetic */ h(CartInteractor cartInteractor, String str) {
        this.f26641b = cartInteractor;
        this.f26642c = str;
    }

    public final void onResponse(Object obj) {
        this.f26641b.lambda$onMenuReceived$9(this.f26642c, (SplitMenuRM) obj);
    }
}
