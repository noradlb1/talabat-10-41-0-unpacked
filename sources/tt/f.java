package tt;

import com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragmentViewModel f62928b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f62929c;

    public /* synthetic */ f(VendorsListFragmentViewModel vendorsListFragmentViewModel, List list) {
        this.f62928b = vendorsListFragmentViewModel;
        this.f62929c = list;
    }

    public final void accept(Object obj) {
        VendorsListFragmentViewModel.m10761loadInlineAds$lambda5(this.f62928b, this.f62929c, (List) obj);
    }
}
