package library.talabat.mvp.PlacesSuggestion;

import library.talabat.mvp.IGlobalPresenter;

public interface IPlacesSuggestionPresenter extends IGlobalPresenter {
    void getLatitudeAndLongitude(String str);

    void loadSuggestions(String str);
}
