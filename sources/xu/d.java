package xu;

import androidx.lifecycle.Observer;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.PermissionStatus;
import com.talabat.splash.presentation.ui.LocationFetchFragment;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationFetchFragment f63045a;

    public /* synthetic */ d(LocationFetchFragment locationFetchFragment) {
        this.f63045a = locationFetchFragment;
    }

    public final void onChanged(Object obj) {
        LocationFetchFragment.m10913currentLocationObserve$lambda4(this.f63045a, (PermissionStatus) obj);
    }
}
