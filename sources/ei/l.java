package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import io.reactivex.functions.Function;

public final /* synthetic */ class l implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56795b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56796c;

    public /* synthetic */ l(DiscoveryRepo discoveryRepo, String str) {
        this.f56795b = discoveryRepo;
        this.f56796c = str;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9694getProductDetailsBySku$lambda27(this.f56795b, this.f56796c, (FeedEndpointRequest) obj);
    }
}
