package xu;

import androidx.lifecycle.Observer;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.GpsStatus;
import com.talabat.splash.presentation.ui.LocationFetchFragment;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationFetchFragment f63044a;

    public /* synthetic */ c(LocationFetchFragment locationFetchFragment) {
        this.f63044a = locationFetchFragment;
    }

    public final void onChanged(Object obj) {
        LocationFetchFragment.m10912allowLocation$lambda3(this.f63044a, (GpsStatus) obj);
    }
}
