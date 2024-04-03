package pt;

import com.talabat.restaurants.v2.domain.vendors.GetVendorsUseCase;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class h implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetVendorsUseCase.Params f62818b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GetVendorsUseCase f62819c;

    public /* synthetic */ h(GetVendorsUseCase.Params params, GetVendorsUseCase getVendorsUseCase) {
        this.f62818b = params;
        this.f62819c = getVendorsUseCase;
    }

    public final Object apply(Object obj) {
        return GetVendorsUseCase.m10751invoke$lambda1(this.f62818b, this.f62819c, (List) obj);
    }
}
