package dj;

import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import com.talabat.darkstores.feature.home.VendorLandingFeedUseCaseImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class f0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorLandingFeedUseCaseImpl f56738b;

    public /* synthetic */ f0(VendorLandingFeedUseCaseImpl vendorLandingFeedUseCaseImpl) {
        this.f56738b = vendorLandingFeedUseCaseImpl;
    }

    public final Object apply(Object obj) {
        return VendorLandingFeedUseCaseImpl.m9972getFeedsFromVendorLanding$lambda3(this.f56738b, (FeedEndpointRequest) obj);
    }
}
