package nu;

import com.talabat.sdsquad.ui.vendorslist.VendorsListViewModel;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListViewModel f62369b;

    public /* synthetic */ b0(VendorsListViewModel vendorsListViewModel) {
        this.f62369b = vendorsListViewModel;
    }

    public final void accept(Object obj) {
        VendorsListViewModel.m10875getVendors$lambda13(this.f62369b, (Throwable) obj);
    }
}
