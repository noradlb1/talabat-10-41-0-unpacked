package tt;

import com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class m implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f62934b;

    public /* synthetic */ m(Function1 function1) {
        this.f62934b = function1;
    }

    public final Object apply(Object obj) {
        return VendorsListFragmentViewModel.m10763loadVendorList$lambda0(this.f62934b, (List) obj);
    }
}
