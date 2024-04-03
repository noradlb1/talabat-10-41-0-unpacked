package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class t implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56810b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56811c;

    public /* synthetic */ t(DiscoveryRepo discoveryRepo, String str) {
        this.f56810b = discoveryRepo;
        this.f56811c = str;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9687getPastOrders$lambda30(this.f56810b, this.f56811c, (Vendor) obj);
    }
}
