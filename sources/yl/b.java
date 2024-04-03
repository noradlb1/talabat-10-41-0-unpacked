package yl;

import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponseV2;
import com.talabat.feature.darkstores.vendorslanding.data.repository.VendorLandingRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorLandingRepositoryImpl f63056b;

    public /* synthetic */ b(VendorLandingRepositoryImpl vendorLandingRepositoryImpl) {
        this.f63056b = vendorLandingRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return VendorLandingRepositoryImpl.m10151getVendorLandingResponseV2$lambda1(this.f63056b, (VendorLandingResponseV2) obj);
    }
}
