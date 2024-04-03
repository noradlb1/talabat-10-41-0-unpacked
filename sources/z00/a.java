package z00;

import JsonModels.Request.InforMapRequest;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.branding.BrandingInteractor;

public final /* synthetic */ class a implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BrandingInteractor f28235b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InforMapRequest f28236c;

    public /* synthetic */ a(BrandingInteractor brandingInteractor, InforMapRequest inforMapRequest) {
        this.f28235b = brandingInteractor;
        this.f28236c = inforMapRequest;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f28235b.lambda$onGetGrlBranchIdRequestError$1(this.f28236c, volleyError);
    }
}
