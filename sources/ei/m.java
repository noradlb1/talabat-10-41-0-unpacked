package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import io.reactivex.functions.Function;

public final /* synthetic */ class m implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56799b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f56800c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f56801d;

    public /* synthetic */ m(DiscoveryRepo discoveryRepo, int i11, int i12) {
        this.f56799b = discoveryRepo;
        this.f56800c = i11;
        this.f56801d = i12;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9699getProductsForCategory$lambda20(this.f56799b, this.f56800c, this.f56801d, (FeedEndpointRequest) obj);
    }
}
