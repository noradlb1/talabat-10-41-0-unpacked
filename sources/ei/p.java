package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class p implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56805b;

    public /* synthetic */ p(DiscoveryRepo discoveryRepo) {
        this.f56805b = discoveryRepo;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9685baseFeedRequestObservable$lambda0(this.f56805b, (Vendor) obj);
    }
}
