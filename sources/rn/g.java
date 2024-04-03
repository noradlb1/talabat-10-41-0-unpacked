package rn;

import com.talabat.feature.pickup.domain.entity.PickupVendor;
import com.talabat.feature.pickup.presentation.PickupPagingSource;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PickupPagingSource f62868b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f62869c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f62870d;

    public /* synthetic */ g(PickupPagingSource pickupPagingSource, int i11, List list) {
        this.f62868b = pickupPagingSource;
        this.f62869c = i11;
        this.f62870d = list;
    }

    public final void accept(Object obj) {
        PickupPagingSource.m10250loadSingle$lambda1(this.f62868b, this.f62869c, this.f62870d, (PickupVendor) obj);
    }
}
