package mt;

import com.talabat.restaurants.v2.data.vendors.VendorsPagingDataSource;
import io.reactivex.functions.Function;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsPagingDataSource f62343b;

    public /* synthetic */ b(VendorsPagingDataSource vendorsPagingDataSource) {
        this.f62343b = vendorsPagingDataSource;
    }

    public final Object apply(Object obj) {
        return VendorsPagingDataSource.m10736loadSingle$lambda1(this.f62343b, (RestaurantListResponsePaginated) obj);
    }
}
