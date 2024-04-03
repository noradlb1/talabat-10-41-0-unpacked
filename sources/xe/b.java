package xe;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.talabat.adapters.PlacesAutoCompleteAdapter;

public final /* synthetic */ class b implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlacesAutoCompleteAdapter f57981a;

    public /* synthetic */ b(PlacesAutoCompleteAdapter placesAutoCompleteAdapter) {
        this.f57981a = placesAutoCompleteAdapter;
    }

    public final void onSuccess(Object obj) {
        PlacesAutoCompleteAdapter.PredictionHolder.m9494onClick$lambda0(this.f57981a, (FetchPlaceResponse) obj);
    }
}
