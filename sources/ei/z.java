package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import io.reactivex.functions.Function;

public final /* synthetic */ class z implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f56820b;

    public /* synthetic */ z(String str) {
        this.f56820b = str;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9718search$lambda7(this.f56820b, (FeedEndpointRequest) obj);
    }
}
