package tt;

import com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class n implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragmentViewModel f62935b;

    public /* synthetic */ n(VendorsListFragmentViewModel vendorsListFragmentViewModel) {
        this.f62935b = vendorsListFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return this.f62935b.generateVendorsDisplayModels((List) obj);
    }
}
