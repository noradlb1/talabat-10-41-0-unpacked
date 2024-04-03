package tt;

import com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class o implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragmentViewModel f62936b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f62937c;

    public /* synthetic */ o(VendorsListFragmentViewModel vendorsListFragmentViewModel, int i11) {
        this.f62936b = vendorsListFragmentViewModel;
        this.f62937c = i11;
    }

    public final Object apply(Object obj) {
        return VendorsListFragmentViewModel.m10764loadVendorList$lambda1(this.f62936b, this.f62937c, (List) obj);
    }
}
