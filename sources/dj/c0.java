package dj;

import com.talabat.darkstores.feature.home.VendorLandingFeedUseCaseImpl;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLanding;
import io.reactivex.functions.Function;

public final /* synthetic */ class c0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorLandingFeedUseCaseImpl f56732b;

    public /* synthetic */ c0(VendorLandingFeedUseCaseImpl vendorLandingFeedUseCaseImpl) {
        this.f56732b = vendorLandingFeedUseCaseImpl;
    }

    public final Object apply(Object obj) {
        return VendorLandingFeedUseCaseImpl.m9970getFeedMultiListData$lambda1(this.f56732b, (VendorLanding) obj);
    }
}
