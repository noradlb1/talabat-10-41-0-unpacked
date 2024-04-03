package tt;

import com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragmentViewModel f62926b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f62927c;

    public /* synthetic */ d(VendorsListFragmentViewModel vendorsListFragmentViewModel, List list) {
        this.f62926b = vendorsListFragmentViewModel;
        this.f62927c = list;
    }

    public final Object apply(Object obj) {
        return VendorsListFragmentViewModel.m10767updateWithFeatureProducts$lambda27(this.f62926b, this.f62927c, (List) obj);
    }
}
