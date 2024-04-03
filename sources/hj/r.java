package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.darkstores.feature.main.viewmodel.DeliveryTierBottomSheetViewState;

public final /* synthetic */ class r implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56892a;

    public /* synthetic */ r(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56892a = darkstoresMainActivity;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m9990observeDeliveryTierBottomSheetViewState$lambda5(this.f56892a, (DeliveryTierBottomSheetViewState) obj);
    }
}
