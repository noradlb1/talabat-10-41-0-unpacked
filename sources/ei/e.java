package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import io.reactivex.functions.Function;

public final /* synthetic */ class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56782b;

    public /* synthetic */ e(DiscoveryRepo discoveryRepo) {
        this.f56782b = discoveryRepo;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9711getTopLevelCategories$lambda2(this.f56782b, (FeedEndpointRequest) obj);
    }
}
