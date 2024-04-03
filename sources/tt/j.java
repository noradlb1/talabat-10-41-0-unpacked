package tt;

import com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class j implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragmentViewModel f62931b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f62932c;

    public /* synthetic */ j(VendorsListFragmentViewModel vendorsListFragmentViewModel, List list) {
        this.f62931b = vendorsListFragmentViewModel;
        this.f62932c = list;
    }

    public final Object apply(Object obj) {
        return VendorsListFragmentViewModel.m10770updateWithVendorsSwimlanes$lambda14(this.f62931b, this.f62932c, (List) obj);
    }
}
