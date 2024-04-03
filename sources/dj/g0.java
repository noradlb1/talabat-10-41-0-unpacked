package dj;

import com.talabat.darkstores.feature.home.VendorLandingFeedUseCaseImpl;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLanding;
import io.reactivex.functions.Function;

public final /* synthetic */ class g0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorLandingFeedUseCaseImpl f56741b;

    public /* synthetic */ g0(VendorLandingFeedUseCaseImpl vendorLandingFeedUseCaseImpl) {
        this.f56741b = vendorLandingFeedUseCaseImpl;
    }

    public final Object apply(Object obj) {
        return VendorLandingFeedUseCaseImpl.m9973getFeedsFromVendorLanding$lambda4(this.f56741b, (VendorLanding) obj);
    }
}
