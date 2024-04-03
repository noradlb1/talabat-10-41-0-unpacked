package lt;

import com.talabat.restaurants.v2.data.vendorinfo.VendorInfoRepositoryImpl;
import io.reactivex.functions.Consumer;
import library.talabat.com.talabatlib.RestuarntListResponse;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorInfoRepositoryImpl f62278b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62279c;

    public /* synthetic */ a(VendorInfoRepositoryImpl vendorInfoRepositoryImpl, String str) {
        this.f62278b = vendorInfoRepositoryImpl;
        this.f62279c = str;
    }

    public final void accept(Object obj) {
        VendorInfoRepositoryImpl.m10734getVendorsInfo$lambda0(this.f62278b, this.f62279c, (RestuarntListResponse) obj);
    }
}
