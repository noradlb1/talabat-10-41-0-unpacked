package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import io.reactivex.functions.Function;

public final /* synthetic */ class a0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56770b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56771c;

    public /* synthetic */ a0(DiscoveryRepo discoveryRepo, String str) {
        this.f56770b = discoveryRepo;
        this.f56771c = str;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9713search$lambda11(this.f56770b, this.f56771c, (FeedEndpointRequest) obj);
    }
}
