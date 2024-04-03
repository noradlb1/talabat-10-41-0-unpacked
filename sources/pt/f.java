package pt;

import com.talabat.restaurants.v2.domain.vendors.GetVendorsFilteredByCuisine;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetVendorsFilteredByCuisine.Params f62817b;

    public /* synthetic */ f(GetVendorsFilteredByCuisine.Params params) {
        this.f62817b = params;
    }

    public final Object apply(Object obj) {
        return GetVendorsFilteredByCuisine.m10749invoke$lambda2(this.f62817b, (List) obj);
    }
}
