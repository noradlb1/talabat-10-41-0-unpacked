package dj;

import com.talabat.darkstores.data.discovery.model.FeedMultiListData;
import com.talabat.darkstores.feature.home.VendorLandingFeedUseCaseImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class d0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorLandingFeedUseCaseImpl f56734b;

    public /* synthetic */ d0(VendorLandingFeedUseCaseImpl vendorLandingFeedUseCaseImpl) {
        this.f56734b = vendorLandingFeedUseCaseImpl;
    }

    public final Object apply(Object obj) {
        return VendorLandingFeedUseCaseImpl.m9971getFeedMultiListData$lambda2(this.f56734b, (FeedMultiListData) obj);
    }
}
