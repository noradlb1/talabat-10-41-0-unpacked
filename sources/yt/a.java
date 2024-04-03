package yt;

import com.talabat.sdsquad.data.vendorslist.VendorRepositoryImp;
import com.talabat.sdsquad.data.vendorslist.response.VendorsListResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorRepositoryImp f63088b;

    public /* synthetic */ a(VendorRepositoryImp vendorRepositoryImp) {
        this.f63088b = vendorRepositoryImp;
    }

    public final void accept(Object obj) {
        VendorRepositoryImp.m10779loadVendors$lambda2(this.f63088b, (VendorsListResponse) obj);
    }
}
