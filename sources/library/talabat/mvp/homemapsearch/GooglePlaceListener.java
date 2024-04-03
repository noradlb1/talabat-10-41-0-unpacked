package library.talabat.mvp.homemapsearch;

import JsonModels.Response.PlacesSuggestionResponse;
import JsonModels.Response.SuggestedPlaceDetails;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u001a\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001b\u0010\n\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Llibrary/talabat/mvp/homemapsearch/GooglePlaceListener;", "Llibrary/talabat/mvp/IGlobalListener;", "noDetailsFound", "", "onNoSuggestionsRecieved", "onSuggestionDetailsRecieved", "result", "LJsonModels/Response/SuggestedPlaceDetails;", "placeName", "", "onSuggestionRecieved", "", "LJsonModels/Response/PlacesSuggestionResponse;", "([LJsonModels/Response/PlacesSuggestionResponse;)V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GooglePlaceListener extends IGlobalListener {
    void noDetailsFound();

    void onNoSuggestionsRecieved();

    void onSuggestionDetailsRecieved(@Nullable SuggestedPlaceDetails suggestedPlaceDetails, @NotNull String str);

    void onSuggestionRecieved(@NotNull PlacesSuggestionResponse[] placesSuggestionResponseArr);
}
