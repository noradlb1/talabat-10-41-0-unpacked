package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.darkstores.feature.main.viewmodel.DeliveryTierBottomSheetViewState;

public final /* synthetic */ class h implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56881a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeliveryTierBottomSheetViewState f56882b;

    public /* synthetic */ h(DarkstoresMainActivity darkstoresMainActivity, DeliveryTierBottomSheetViewState deliveryTierBottomSheetViewState) {
        this.f56881a = darkstoresMainActivity;
        this.f56882b = deliveryTierBottomSheetViewState;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m10000showGroceryDeliveryTiers$lambda23(this.f56881a, this.f56882b, (Result) obj);
    }
}
