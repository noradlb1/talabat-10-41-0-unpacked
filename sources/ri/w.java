package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.talabatcommon.optional.Optional;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class w implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57364b;

    public /* synthetic */ w(CartFragmentViewModel cartFragmentViewModel) {
        this.f57364b = cartFragmentViewModel;
    }

    public final boolean test(Object obj) {
        return CartFragmentViewModel.m9796initViewModel$lambda1(this.f57364b, (Optional) obj);
    }
}
