package ni;

import com.talabat.darkstores.data.tracking.BaseTracker;
import com.talabat.darkstores.data.tracking.LocationTrackingProvider;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseTracker f57063b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LocationTrackingProvider f57064c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StoreInfoTrackingProvider f57065d;

    public /* synthetic */ a(BaseTracker baseTracker, LocationTrackingProvider locationTrackingProvider, StoreInfoTrackingProvider storeInfoTrackingProvider) {
        this.f57063b = baseTracker;
        this.f57064c = locationTrackingProvider;
        this.f57065d = storeInfoTrackingProvider;
    }

    public final void accept(Object obj) {
        BaseTracker.m9743_init_$lambda1(this.f57063b, this.f57064c, this.f57065d, (Pair) obj);
    }
}
