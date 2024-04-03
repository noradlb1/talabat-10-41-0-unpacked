package nu;

import com.talabat.sdsquad.ui.vendorslist.VendorsListViewModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class l implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListViewModel f62383b;

    public /* synthetic */ l(VendorsListViewModel vendorsListViewModel) {
        this.f62383b = vendorsListViewModel;
    }

    public final void accept(Object obj) {
        VendorsListViewModel.m10887loadInlineAd$lambda14(this.f62383b, (List) obj);
    }
}
