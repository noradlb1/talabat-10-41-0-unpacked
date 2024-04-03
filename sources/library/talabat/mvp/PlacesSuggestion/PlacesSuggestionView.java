package library.talabat.mvp.PlacesSuggestion;

import JsonModels.Response.PlacesSuggestionResponse;
import JsonModels.Response.SuggestedPlaceDetails;
import com.talabat.helpers.Talabat;
import java.util.ArrayList;

public interface PlacesSuggestionView extends Talabat {
    void noDetailsFound();

    void noPlaceIdAvailable();

    void onLatLongRecieved(SuggestedPlaceDetails suggestedPlaceDetails);

    void onNoSuggestionsFound();

    void onSuggestionsLoaded(ArrayList<PlacesSuggestionResponse> arrayList);
}
