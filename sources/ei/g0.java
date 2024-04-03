package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import io.reactivex.functions.Function;

public final /* synthetic */ class g0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56785b;

    public /* synthetic */ g0(DiscoveryRepo discoveryRepo) {
        this.f56785b = discoveryRepo;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9686getAllProducts$lambda21(this.f56785b, (FeedEndpointRequest) obj);
    }
}
