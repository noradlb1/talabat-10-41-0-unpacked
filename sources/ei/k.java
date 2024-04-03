package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import io.reactivex.functions.Function;

public final /* synthetic */ class k implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f56792b;

    public /* synthetic */ k(String str) {
        this.f56792b = str;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9698getProductsForCategory$lambda18(this.f56792b, (FeedEndpointRequest) obj);
    }
}
