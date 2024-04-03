package library.talabat.mvp.homemapsearch;

import JsonModels.Response.PlacesSuggestionResponse;
import JsonModels.Response.SuggestedPlaceDetails;
import com.talabat.helpers.Talabat;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&¨\u0006\u0013"}, d2 = {"Llibrary/talabat/mvp/homemapsearch/GoogleSearchView;", "Lcom/talabat/helpers/Talabat;", "loadDeliveryAreas", "", "isFromCurrentLocationRequest", "", "loadGooglePlaceSearch", "noDetailsFound", "noPlaceIdAvailable", "onLatLongRecieved", "result", "LJsonModels/Response/SuggestedPlaceDetails;", "placeName", "", "onNoSuggestionsFound", "onSuggestionsLoaded", "placesSuggestionArrayList", "Ljava/util/ArrayList;", "LJsonModels/Response/PlacesSuggestionResponse;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GoogleSearchView extends Talabat {
    void loadDeliveryAreas(boolean z11);

    void loadGooglePlaceSearch();

    void noDetailsFound();

    void noPlaceIdAvailable();

    void onLatLongRecieved(@Nullable SuggestedPlaceDetails suggestedPlaceDetails, @NotNull String str);

    void onNoSuggestionsFound();

    void onSuggestionsLoaded(@NotNull ArrayList<PlacesSuggestionResponse> arrayList);
}
