package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.talabatcommon.optional.Optional;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class o0 implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57336b;

    public /* synthetic */ o0(CartFragmentViewModel cartFragmentViewModel) {
        this.f57336b = cartFragmentViewModel;
    }

    public final boolean test(Object obj) {
        return CartFragmentViewModel.m9790ignoreIfCartOwnedByAnotherVendor$lambda64$lambda62(this.f57336b, (Optional) obj);
    }
}
