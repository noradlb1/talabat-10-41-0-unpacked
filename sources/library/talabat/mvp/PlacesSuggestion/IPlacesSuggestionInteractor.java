package library.talabat.mvp.PlacesSuggestion;

import library.talabat.mvp.IGlobalInteractor;

public interface IPlacesSuggestionInteractor extends IGlobalInteractor {
    void getLatLong(String str);

    void loadPlacesifAvailable(String str);
}
