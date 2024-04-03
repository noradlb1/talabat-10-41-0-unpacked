package tt;

import com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragmentViewModel f62930b;

    public /* synthetic */ h(VendorsListFragmentViewModel vendorsListFragmentViewModel) {
        this.f62930b = vendorsListFragmentViewModel;
    }

    public final void accept(Object obj) {
        VendorsListFragmentViewModel.m10768updateWithFeatureProducts$lambda30(this.f62930b, (List) obj);
    }
}
