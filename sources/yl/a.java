package yl;

import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponse;
import com.talabat.feature.darkstores.vendorslanding.data.repository.VendorLandingRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorLandingRepositoryImpl f63055b;

    public /* synthetic */ a(VendorLandingRepositoryImpl vendorLandingRepositoryImpl) {
        this.f63055b = vendorLandingRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return VendorLandingRepositoryImpl.m10150getVendorLandingResponse$lambda0(this.f63055b, (VendorLandingResponse) obj);
    }
}
