package iq;

import com.talabat.flutter.groceryhome.domain.model.UserLocation;
import com.talabat.flutter.groceryhome.domain.usecase.GetMigratedVendorInfoUseCaseImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetMigratedVendorInfoUseCaseImpl f62167b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62168c;

    public /* synthetic */ d(GetMigratedVendorInfoUseCaseImpl getMigratedVendorInfoUseCaseImpl, String str) {
        this.f62167b = getMigratedVendorInfoUseCaseImpl;
        this.f62168c = str;
    }

    public final Object apply(Object obj) {
        return GetMigratedVendorInfoUseCaseImpl.m10473invoke$lambda1(this.f62167b, this.f62168c, (UserLocation) obj);
    }
}
