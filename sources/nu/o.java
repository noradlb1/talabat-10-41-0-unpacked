package nu;

import com.talabat.sdsquad.ui.vendorslist.VendorsListViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class o implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListViewModel f62386b;

    public /* synthetic */ o(VendorsListViewModel vendorsListViewModel) {
        this.f62386b = vendorsListViewModel;
    }

    public final Object apply(Object obj) {
        return VendorsListViewModel.m10879getVendors$lambda5(this.f62386b, (List) obj);
    }
}
