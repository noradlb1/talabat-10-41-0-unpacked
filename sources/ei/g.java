package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class g implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56784b;

    public /* synthetic */ g(DiscoveryRepo discoveryRepo) {
        this.f56784b = discoveryRepo;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9707getSwimlane$lambda34(this.f56784b, (Vendor) obj);
    }
}
