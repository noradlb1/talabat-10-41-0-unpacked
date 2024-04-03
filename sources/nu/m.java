package nu;

import com.talabat.sdsquad.ui.vendorslist.VendorsListViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class m implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListViewModel f62384b;

    public /* synthetic */ m(VendorsListViewModel vendorsListViewModel) {
        this.f62384b = vendorsListViewModel;
    }

    public final Object apply(Object obj) {
        return VendorsListViewModel.m10877getVendors$lambda3(this.f62384b, (List) obj);
    }
}
