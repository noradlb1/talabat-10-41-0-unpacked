package ot;

import com.talabat.restaurants.v2.domain.swimlane.GetVendorsSwimlanes;
import io.reactivex.functions.Function;
import library.talabat.com.talabatlib.SwimlaneResponse;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f62773b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GetVendorsSwimlanes f62774c;

    public /* synthetic */ d(int i11, GetVendorsSwimlanes getVendorsSwimlanes) {
        this.f62773b = i11;
        this.f62774c = getVendorsSwimlanes;
    }

    public final Object apply(Object obj) {
        return GetVendorsSwimlanes.m10743invoke$lambda3(this.f62773b, this.f62774c, (SwimlaneResponse) obj);
    }
}
