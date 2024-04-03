package library.talabat.mvp.homemapsearch;

import JsonModels.Response.PlacesSuggestionResponse;
import JsonModels.Response.SuggestedPlaceDetails;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.TalabatUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\u0012\u0010\"\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u0019H\u0016J\u001b\u0010)\u001a\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140+H\u0016¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0019H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Llibrary/talabat/mvp/homemapsearch/GooglePlacePresenter;", "Llibrary/talabat/mvp/homemapsearch/IGoogleSearchPresenter;", "Llibrary/talabat/mvp/homemapsearch/GooglePlaceListener;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "googleSearchView", "Llibrary/talabat/mvp/homemapsearch/GoogleSearchView;", "(Lcom/talabat/configuration/discovery/AppVersionProvider;Llibrary/talabat/mvp/homemapsearch/GoogleSearchView;)V", "googlePlaceInteractor", "Llibrary/talabat/mvp/homemapsearch/IGooglePlaceInteractor;", "getGooglePlaceInteractor", "()Llibrary/talabat/mvp/homemapsearch/IGooglePlaceInteractor;", "setGooglePlaceInteractor", "(Llibrary/talabat/mvp/homemapsearch/IGooglePlaceInteractor;)V", "getGoogleSearchView", "()Llibrary/talabat/mvp/homemapsearch/GoogleSearchView;", "setGoogleSearchView", "(Llibrary/talabat/mvp/homemapsearch/GoogleSearchView;)V", "placesSuggestionArrayList", "Ljava/util/ArrayList;", "LJsonModels/Response/PlacesSuggestionResponse;", "placesSuggestionObject", "getLatitudeAndLongitude", "", "placeId", "", "name", "loadSuggestions", "keyword", "noDetailsFound", "onDataError", "onDestroy", "onNetworkError", "onNoSuggestionsRecieved", "onServerError", "volleyError", "Lcom/android/volley/VolleyError;", "onSuggestionDetailsRecieved", "result", "LJsonModels/Response/SuggestedPlaceDetails;", "placeName", "onSuggestionRecieved", "placesSuggestionResponses", "", "([LJsonModels/Response/PlacesSuggestionResponse;)V", "searchViewTypeHandler", "searchQuery", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GooglePlacePresenter implements IGoogleSearchPresenter, GooglePlaceListener {
    @Nullable
    private IGooglePlaceInteractor googlePlaceInteractor;
    @Nullable
    private GoogleSearchView googleSearchView;
    @Nullable
    private ArrayList<PlacesSuggestionResponse> placesSuggestionArrayList;
    @Nullable
    private PlacesSuggestionResponse placesSuggestionObject;

    public GooglePlacePresenter(@NotNull AppVersionProvider appVersionProvider, @NotNull GoogleSearchView googleSearchView2) {
        Intrinsics.checkNotNullParameter(appVersionProvider, "appVersionProvider");
        Intrinsics.checkNotNullParameter(googleSearchView2, "googleSearchView");
        this.googlePlaceInteractor = new GooglePlaceInteractor(appVersionProvider, this);
        this.googleSearchView = googleSearchView2;
    }

    @Nullable
    public final IGooglePlaceInteractor getGooglePlaceInteractor() {
        return this.googlePlaceInteractor;
    }

    @Nullable
    public final GoogleSearchView getGoogleSearchView() {
        return this.googleSearchView;
    }

    public void getLatitudeAndLongitude(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "name");
        if (TalabatUtils.isNullOrEmpty(str)) {
            GoogleSearchView googleSearchView2 = this.googleSearchView;
            if (googleSearchView2 != null) {
                googleSearchView2.noPlaceIdAvailable();
                return;
            }
            return;
        }
        GoogleSearchView googleSearchView3 = this.googleSearchView;
        if (googleSearchView3 != null) {
            googleSearchView3.startLodingPopup();
        }
        IGooglePlaceInteractor iGooglePlaceInteractor = this.googlePlaceInteractor;
        if (iGooglePlaceInteractor != null) {
            iGooglePlaceInteractor.getLatLong(str, str2);
        }
    }

    public void loadSuggestions(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "keyword");
        IGooglePlaceInteractor iGooglePlaceInteractor = this.googlePlaceInteractor;
        if (iGooglePlaceInteractor != null) {
            iGooglePlaceInteractor.loadPlacesifAvailable(str);
        }
    }

    public void noDetailsFound() {
        GoogleSearchView googleSearchView2 = this.googleSearchView;
        if (googleSearchView2 != null) {
            googleSearchView2.noDetailsFound();
        }
    }

    public void onDataError() {
        GoogleSearchView googleSearchView2 = this.googleSearchView;
        if (googleSearchView2 != null) {
            googleSearchView2.onDataError();
        }
    }

    public void onDestroy() {
        this.googlePlaceInteractor = null;
        this.googleSearchView = null;
    }

    public void onNetworkError() {
        GoogleSearchView googleSearchView2 = this.googleSearchView;
        if (googleSearchView2 != null) {
            googleSearchView2.onNetworkError();
        }
    }

    public void onNoSuggestionsRecieved() {
        GoogleSearchView googleSearchView2 = this.googleSearchView;
        if (googleSearchView2 != null) {
            googleSearchView2.onNoSuggestionsFound();
        }
    }

    public void onServerError(@Nullable VolleyError volleyError) {
        GoogleSearchView googleSearchView2 = this.googleSearchView;
        if (googleSearchView2 != null) {
            googleSearchView2.onServerError(volleyError);
        }
    }

    public void onSuggestionDetailsRecieved(@Nullable SuggestedPlaceDetails suggestedPlaceDetails, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "placeName");
        GoogleSearchView googleSearchView2 = this.googleSearchView;
        if (googleSearchView2 != null) {
            googleSearchView2.stopLodingPopup();
        }
        GoogleSearchView googleSearchView3 = this.googleSearchView;
        if (googleSearchView3 != null) {
            googleSearchView3.onLatLongRecieved(suggestedPlaceDetails, str);
        }
    }

    public void onSuggestionRecieved(@NotNull PlacesSuggestionResponse[] placesSuggestionResponseArr) {
        Intrinsics.checkNotNullParameter(placesSuggestionResponseArr, "placesSuggestionResponses");
        this.placesSuggestionArrayList = new ArrayList<>();
        for (PlacesSuggestionResponse placesSuggestionResponse : placesSuggestionResponseArr) {
            PlacesSuggestionResponse placesSuggestionResponse2 = new PlacesSuggestionResponse();
            this.placesSuggestionObject = placesSuggestionResponse2;
            placesSuggestionResponse2.desc = placesSuggestionResponse.desc;
            placesSuggestionResponse2.f477name = placesSuggestionResponse.f477name;
            placesSuggestionResponse2.placeId = placesSuggestionResponse.placeId;
            ArrayList<PlacesSuggestionResponse> arrayList = this.placesSuggestionArrayList;
            if (arrayList != null) {
                Intrinsics.checkNotNull(placesSuggestionResponse2);
                arrayList.add(placesSuggestionResponse2);
            }
        }
        GoogleSearchView googleSearchView2 = this.googleSearchView;
        if (googleSearchView2 != null) {
            ArrayList<PlacesSuggestionResponse> arrayList2 = this.placesSuggestionArrayList;
            Intrinsics.checkNotNull(arrayList2);
            googleSearchView2.onSuggestionsLoaded(arrayList2);
        }
    }

    public void searchViewTypeHandler(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "searchQuery");
        if (TalabatUtils.isNullOrEmpty(str)) {
            GoogleSearchView googleSearchView2 = this.googleSearchView;
            if (googleSearchView2 != null) {
                googleSearchView2.loadDeliveryAreas(false);
                return;
            }
            return;
        }
        GoogleSearchView googleSearchView3 = this.googleSearchView;
        if (googleSearchView3 != null) {
            googleSearchView3.loadGooglePlaceSearch();
        }
    }

    public final void setGooglePlaceInteractor(@Nullable IGooglePlaceInteractor iGooglePlaceInteractor) {
        this.googlePlaceInteractor = iGooglePlaceInteractor;
    }

    public final void setGoogleSearchView(@Nullable GoogleSearchView googleSearchView2) {
        this.googleSearchView = googleSearchView2;
    }
}
