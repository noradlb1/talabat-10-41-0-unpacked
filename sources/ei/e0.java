package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.MultiListFeedEndpointResponse;
import io.reactivex.functions.Function;

public final /* synthetic */ class e0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56783b;

    public /* synthetic */ e0(DiscoveryRepo discoveryRepo) {
        this.f56783b = discoveryRepo;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9706getSubcategorySwimlanes$lambda6(this.f56783b, (MultiListFeedEndpointResponse) obj);
    }
}
