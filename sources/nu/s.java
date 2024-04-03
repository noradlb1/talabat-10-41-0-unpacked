package nu;

import com.talabat.sdsquad.ui.vendorslist.VendorsListViewModel;
import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscription;

public final /* synthetic */ class s implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListViewModel f62391b;

    public /* synthetic */ s(VendorsListViewModel vendorsListViewModel) {
        this.f62391b = vendorsListViewModel;
    }

    public final void accept(Object obj) {
        VendorsListViewModel.m10872getVendors$lambda10(this.f62391b, (Subscription) obj);
    }
}
