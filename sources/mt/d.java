package mt;

import com.talabat.restaurants.v2.data.vendors.VendorsRepositoryImpl;
import io.reactivex.functions.Consumer;
import library.talabat.com.talabatlib.RestuarntListResponse;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsRepositoryImpl f62344b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62345c;

    public /* synthetic */ d(VendorsRepositoryImpl vendorsRepositoryImpl, String str) {
        this.f62344b = vendorsRepositoryImpl;
        this.f62345c = str;
    }

    public final void accept(Object obj) {
        VendorsRepositoryImpl.m10739getVendorsByPolygons$lambda0(this.f62344b, this.f62345c, (RestuarntListResponse) obj);
    }
}
