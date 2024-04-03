package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import io.reactivex.functions.Function;

public final /* synthetic */ class j0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56789b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f56790c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f56791d;

    public /* synthetic */ j0(DiscoveryRepo discoveryRepo, int i11, int i12) {
        this.f56789b = discoveryRepo;
        this.f56790c = i11;
        this.f56791d = i12;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9702getProductsForTag$lambda17(this.f56789b, this.f56790c, this.f56791d, (FeedEndpointRequest) obj);
    }
}
