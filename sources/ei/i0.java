package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import io.reactivex.functions.Function;

public final /* synthetic */ class i0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f56788b;

    public /* synthetic */ i0(String str) {
        this.f56788b = str;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9701getProductsForTag$lambda15(this.f56788b, (FeedEndpointRequest) obj);
    }
}
