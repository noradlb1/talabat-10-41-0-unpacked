package l10;

import JsonModels.Response.PlacesSuggestionDetailsRM;
import com.android.volley.Response;
import library.talabat.mvp.homemapsearch.GooglePlaceInteractor;

public final /* synthetic */ class b implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GooglePlaceInteractor f26457b;

    public /* synthetic */ b(GooglePlaceInteractor googlePlaceInteractor) {
        this.f26457b = googlePlaceInteractor;
    }

    public final void onResponse(Object obj) {
        GooglePlaceInteractor.m7896onPlaceDetailsRecieved$lambda1(this.f26457b, (PlacesSuggestionDetailsRM) obj);
    }
}
