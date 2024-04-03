package rn;

import com.talabat.feature.pickup.domain.entity.PickupVendor;
import com.talabat.feature.pickup.presentation.PickupPagingSource;
import io.reactivex.functions.Function;

public final /* synthetic */ class h implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PickupPagingSource f62871b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f62872c;

    public /* synthetic */ h(PickupPagingSource pickupPagingSource, int i11) {
        this.f62871b = pickupPagingSource;
        this.f62872c = i11;
    }

    public final Object apply(Object obj) {
        return PickupPagingSource.m10251loadSingle$lambda2(this.f62871b, this.f62872c, (PickupVendor) obj);
    }
}
