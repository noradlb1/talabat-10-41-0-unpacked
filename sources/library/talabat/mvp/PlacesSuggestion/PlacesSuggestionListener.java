package library.talabat.mvp.PlacesSuggestion;

import JsonModels.Response.PlacesSuggestionResponse;
import JsonModels.Response.SuggestedPlaceDetails;
import library.talabat.mvp.IGlobalListener;

public interface PlacesSuggestionListener extends IGlobalListener {
    void noDetailsFound();

    void onNoSuggestionsRecieved();

    void onSuggestionDetailsRecieved(SuggestedPlaceDetails suggestedPlaceDetails);

    void onSuggestionRecieved(PlacesSuggestionResponse[] placesSuggestionResponseArr);
}
