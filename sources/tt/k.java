package tt;

import com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class k implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragmentViewModel f62933b;

    public /* synthetic */ k(VendorsListFragmentViewModel vendorsListFragmentViewModel) {
        this.f62933b = vendorsListFragmentViewModel;
    }

    public final void accept(Object obj) {
        VendorsListFragmentViewModel.m10771updateWithVendorsSwimlanes$lambda17(this.f62933b, (List) obj);
    }
}
