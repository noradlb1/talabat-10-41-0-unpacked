package z00;

import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import com.android.volley.Response;
import library.talabat.mvp.branding.BrandingInteractor;

public final /* synthetic */ class b implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BrandingInteractor f28237b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f28238c;

    public /* synthetic */ b(BrandingInteractor brandingInteractor, String str) {
        this.f28237b = brandingInteractor;
        this.f28238c = str;
    }

    public final void onResponse(Object obj) {
        this.f28237b.lambda$onMenuReceived$0(this.f28238c, (SplitMenuRM) obj);
    }
}
