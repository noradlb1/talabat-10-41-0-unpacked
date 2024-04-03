package cs;

import androidx.lifecycle.Observer;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.home.HomeScreenActivity;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f61802a;

    public /* synthetic */ d(HomeScreenActivity homeScreenActivity) {
        this.f61802a = homeScreenActivity;
    }

    public final void onChanged(Object obj) {
        HomeScreenActivity.m10643setCurrentLocationFromBeginning$lambda28(this.f61802a, (LatLng) obj);
    }
}
