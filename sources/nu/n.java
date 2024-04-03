package nu;

import com.talabat.sdsquad.ui.vendorslist.VendorsListViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class n implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListViewModel f62385b;

    public /* synthetic */ n(VendorsListViewModel vendorsListViewModel) {
        this.f62385b = vendorsListViewModel;
    }

    public final Object apply(Object obj) {
        return VendorsListViewModel.m10878getVendors$lambda4(this.f62385b, (List) obj);
    }
}
