package tt;

import com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class p implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragmentViewModel f62938b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f62939c;

    public /* synthetic */ p(VendorsListFragmentViewModel vendorsListFragmentViewModel, int i11) {
        this.f62938b = vendorsListFragmentViewModel;
        this.f62939c = i11;
    }

    public final void accept(Object obj) {
        VendorsListFragmentViewModel.m10765loadVendorList$lambda2(this.f62938b, this.f62939c, (List) obj);
    }
}
