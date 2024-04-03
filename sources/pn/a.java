package pn;

import com.talabat.feature.pickup.data.PickupRepositoryImpl;
import com.talabat.feature.pickup.data.entity.PickupVendorDto;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PickupRepositoryImpl f62792b;

    public /* synthetic */ a(PickupRepositoryImpl pickupRepositoryImpl) {
        this.f62792b = pickupRepositoryImpl;
    }

    public final void accept(Object obj) {
        PickupRepositoryImpl.m10242getPickupVendors$lambda0(this.f62792b, (PickupVendorDto) obj);
    }
}
