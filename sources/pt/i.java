package pt;

import com.talabat.restaurants.v2.data.vendors.FilterParams;
import com.talabat.restaurants.v2.domain.vendors.PagedUsedCaseImpl;
import io.reactivex.functions.Consumer;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FilterParams f62820b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Integer f62821c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PagedUsedCaseImpl f62822d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f62823e;

    public /* synthetic */ i(FilterParams filterParams, Integer num, PagedUsedCaseImpl pagedUsedCaseImpl, String str) {
        this.f62820b = filterParams;
        this.f62821c = num;
        this.f62822d = pagedUsedCaseImpl;
        this.f62823e = str;
    }

    public final void accept(Object obj) {
        PagedUsedCaseImpl.m10752getAllVendorsPaginated$lambda0(this.f62820b, this.f62821c, this.f62822d, this.f62823e, (RestaurantListResponsePaginated) obj);
    }
}
