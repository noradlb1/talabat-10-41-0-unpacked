package nu;

import com.talabat.sdsquad.ui.vendorslist.VendorsListViewModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class t implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListViewModel f62392b;

    public /* synthetic */ t(VendorsListViewModel vendorsListViewModel) {
        this.f62392b = vendorsListViewModel;
    }

    public final void accept(Object obj) {
        VendorsListViewModel.m10873getVendors$lambda11(this.f62392b, (List) obj);
    }
}
