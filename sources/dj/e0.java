package dj;

import com.talabat.darkstores.feature.home.VendorLandingFeedUseCaseImpl;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class e0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorLandingFeedUseCaseImpl f56736b;

    public /* synthetic */ e0(VendorLandingFeedUseCaseImpl vendorLandingFeedUseCaseImpl) {
        this.f56736b = vendorLandingFeedUseCaseImpl;
    }

    public final Object apply(Object obj) {
        return VendorLandingFeedUseCaseImpl.m9969feedRequestObservable$lambda0(this.f56736b, (Vendor) obj);
    }
}
