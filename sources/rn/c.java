package rn;

import androidx.lifecycle.Observer;
import com.talabat.feature.pickup.presentation.PickupActivity;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PickupActivity f62864a;

    public /* synthetic */ c(PickupActivity pickupActivity) {
        this.f62864a = pickupActivity;
    }

    public final void onChanged(Object obj) {
        PickupActivity.m10247observePagingData$lambda5(this.f62864a, (Boolean) obj);
    }
}
