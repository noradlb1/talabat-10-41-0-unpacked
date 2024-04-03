package tt;

import com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorListFragmentViewModelPaged f62925b;

    public /* synthetic */ c(VendorListFragmentViewModelPaged vendorListFragmentViewModelPaged) {
        this.f62925b = vendorListFragmentViewModelPaged;
    }

    public final void accept(Object obj) {
        VendorListFragmentViewModelPaged.m10760loadVendorList$lambda1(this.f62925b, (Pair) obj);
    }
}
