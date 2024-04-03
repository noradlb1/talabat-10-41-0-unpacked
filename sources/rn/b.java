package rn;

import androidx.lifecycle.Observer;
import com.talabat.feature.pickup.presentation.PickupActivity;
import com.talabat.feature.pickup.presentation.adapters.ValuePropBannerState;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PickupActivity f62863a;

    public /* synthetic */ b(PickupActivity pickupActivity) {
        this.f62863a = pickupActivity;
    }

    public final void onChanged(Object obj) {
        PickupActivity.m10246observePagingData$lambda4(this.f62863a, (ValuePropBannerState) obj);
    }
}
