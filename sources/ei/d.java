package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import io.reactivex.functions.Function;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56779b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedEndpointRequest.PageType f56780c;

    public /* synthetic */ d(DiscoveryRepo discoveryRepo, FeedEndpointRequest.PageType pageType) {
        this.f56779b = discoveryRepo;
        this.f56780c = pageType;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9710getTopLevelCategories$lambda1(this.f56779b, this.f56780c, (FeedEndpointRequest) obj);
    }
}
