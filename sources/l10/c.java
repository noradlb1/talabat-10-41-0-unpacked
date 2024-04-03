package l10;

import JsonModels.Response.PlacesSuggestionRM;
import com.android.volley.Response;
import library.talabat.mvp.homemapsearch.GooglePlaceInteractor;

public final /* synthetic */ class c implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GooglePlaceInteractor f26458b;

    public /* synthetic */ c(GooglePlaceInteractor googlePlaceInteractor) {
        this.f26458b = googlePlaceInteractor;
    }

    public final void onResponse(Object obj) {
        GooglePlaceInteractor.m7898onSuggestionListReceived$lambda0(this.f26458b, (PlacesSuggestionRM) obj);
    }
}
