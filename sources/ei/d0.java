package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import io.reactivex.functions.Function;

public final /* synthetic */ class d0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56781b;

    public /* synthetic */ d0(DiscoveryRepo discoveryRepo) {
        this.f56781b = discoveryRepo;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9705getSubcategorySwimlanes$lambda5(this.f56781b, (FeedEndpointRequest) obj);
    }
}
