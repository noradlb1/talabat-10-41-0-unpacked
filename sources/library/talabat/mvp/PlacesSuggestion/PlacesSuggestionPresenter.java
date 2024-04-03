package library.talabat.mvp.PlacesSuggestion;

import JsonModels.Response.PlacesSuggestionResponse;
import JsonModels.Response.SuggestedPlaceDetails;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.TalabatUtils;
import java.util.ArrayList;

public class PlacesSuggestionPresenter implements IPlacesSuggestionPresenter, PlacesSuggestionListener {
    private IPlacesSuggestionInteractor iPlacesSuggestionInteractor;
    private ArrayList<PlacesSuggestionResponse> placesSuggestionArrayList;
    private PlacesSuggestionResponse placesSuggestionObject;
    private PlacesSuggestionView placesSuggestionView;

    public PlacesSuggestionPresenter(AppVersionProvider appVersionProvider, PlacesSuggestionView placesSuggestionView2) {
        this.placesSuggestionView = placesSuggestionView2;
        this.iPlacesSuggestionInteractor = new PlacesSuggestionInteractor(appVersionProvider, this);
    }

    public void getLatitudeAndLongitude(String str) {
        if (TalabatUtils.isNullOrEmpty(str)) {
            this.placesSuggestionView.noPlaceIdAvailable();
            return;
        }
        this.placesSuggestionView.startLodingPopup();
        this.iPlacesSuggestionInteractor.getLatLong(str);
    }

    public void loadSuggestions(String str) {
        this.iPlacesSuggestionInteractor.loadPlacesifAvailable(str);
    }

    public void noDetailsFound() {
        this.placesSuggestionView.noDetailsFound();
    }

    public void onDataError() {
    }

    public void onDestroy() {
        this.placesSuggestionView = null;
        IPlacesSuggestionInteractor iPlacesSuggestionInteractor2 = this.iPlacesSuggestionInteractor;
        if (iPlacesSuggestionInteractor2 != null) {
            iPlacesSuggestionInteractor2.unregister();
        }
        this.iPlacesSuggestionInteractor = null;
    }

    public void onNetworkError() {
    }

    public void onNoSuggestionsRecieved() {
        this.placesSuggestionView.onNoSuggestionsFound();
    }

    public void onServerError(VolleyError volleyError) {
    }

    public void onSuggestionDetailsRecieved(SuggestedPlaceDetails suggestedPlaceDetails) {
        this.placesSuggestionView.stopLodingPopup();
        this.placesSuggestionView.onLatLongRecieved(suggestedPlaceDetails);
    }

    public void onSuggestionRecieved(PlacesSuggestionResponse[] placesSuggestionResponseArr) {
        this.placesSuggestionArrayList = new ArrayList<>();
        for (PlacesSuggestionResponse placesSuggestionResponse : placesSuggestionResponseArr) {
            PlacesSuggestionResponse placesSuggestionResponse2 = new PlacesSuggestionResponse();
            this.placesSuggestionObject = placesSuggestionResponse2;
            placesSuggestionResponse2.desc = placesSuggestionResponse.desc;
            placesSuggestionResponse2.f477name = placesSuggestionResponse.f477name;
            placesSuggestionResponse2.placeId = placesSuggestionResponse.placeId;
            this.placesSuggestionArrayList.add(placesSuggestionResponse2);
        }
        this.placesSuggestionView.onSuggestionsLoaded(this.placesSuggestionArrayList);
    }
}
