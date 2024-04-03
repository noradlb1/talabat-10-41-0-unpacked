package nu;

import com.talabat.sdsquad.ui.vendorslist.VendorsListViewModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class a0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListViewModel f62368b;

    public /* synthetic */ a0(VendorsListViewModel vendorsListViewModel) {
        this.f62368b = vendorsListViewModel;
    }

    public final void accept(Object obj) {
        VendorsListViewModel.m10874getVendors$lambda12(this.f62368b, (List) obj);
    }
}
