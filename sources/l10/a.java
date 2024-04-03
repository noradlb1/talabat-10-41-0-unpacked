package l10;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.homemapsearch.GooglePlaceInteractor;

public final /* synthetic */ class a implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GooglePlaceInteractor f26456b;

    public /* synthetic */ a(GooglePlaceInteractor googlePlaceInteractor) {
        this.f26456b = googlePlaceInteractor;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        GooglePlaceInteractor.m7897onRequestError$lambda2(this.f26456b, volleyError);
    }
}
