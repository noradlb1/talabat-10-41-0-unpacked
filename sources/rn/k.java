package rn;

import com.talabat.feature.pickup.presentation.PickupViewModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class k implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PickupViewModel f62874b;

    public /* synthetic */ k(PickupViewModel pickupViewModel) {
        this.f62874b = pickupViewModel;
    }

    public final void accept(Object obj) {
        PickupViewModel.m10254screenOpened$lambda3(this.f62874b, (List) obj);
    }
}
