package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import io.reactivex.functions.Function;

public final /* synthetic */ class k0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56793b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56794c;

    public /* synthetic */ k0(DiscoveryRepo discoveryRepo, String str) {
        this.f56793b = discoveryRepo;
        this.f56794c = str;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9691getProductDetails$lambda24(this.f56793b, this.f56794c, (FeedEndpointRequest) obj);
    }
}
