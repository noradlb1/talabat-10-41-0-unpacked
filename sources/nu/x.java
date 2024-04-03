package nu;

import com.talabat.sdsquad.ui.vendorslist.VendorsListViewModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class x implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListViewModel f62393b;

    public /* synthetic */ x(VendorsListViewModel vendorsListViewModel) {
        this.f62393b = vendorsListViewModel;
    }

    public final void accept(Object obj) {
        VendorsListViewModel.m10885insertInlineAd$lambda18(this.f62393b, (List) obj);
    }
}
