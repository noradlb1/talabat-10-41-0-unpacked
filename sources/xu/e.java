package xu;

import androidx.lifecycle.Observer;
import com.talabat.splash.domain.model.location.CurrentLocationWrapper;
import com.talabat.splash.presentation.ui.LocationFetchFragment;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationFetchFragment f63046a;

    public /* synthetic */ e(LocationFetchFragment locationFetchFragment) {
        this.f63046a = locationFetchFragment;
    }

    public final void onChanged(Object obj) {
        LocationFetchFragment.m10916invokeCurrentLocationFetch$lambda5(this.f63046a, (CurrentLocationWrapper) obj);
    }
}
