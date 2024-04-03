package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.talabatcommon.optional.Optional;
import io.reactivex.functions.Function;

public final /* synthetic */ class z0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f57370b;

    public /* synthetic */ z0(Object obj) {
        this.f57370b = obj;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9791ignoreIfCartOwnedByAnotherVendor$lambda64$lambda63(this.f57370b, (Optional) obj);
    }
}
