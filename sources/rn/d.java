package rn;

import androidx.lifecycle.Observer;
import com.talabat.feature.pickup.presentation.PickupActivity;
import java.util.List;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PickupActivity f62865a;

    public /* synthetic */ d(PickupActivity pickupActivity) {
        this.f62865a = pickupActivity;
    }

    public final void onChanged(Object obj) {
        PickupActivity.m10248observePagingData$lambda8(this.f62865a, (List) obj);
    }
}
