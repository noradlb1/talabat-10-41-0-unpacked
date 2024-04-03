package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import io.reactivex.functions.Function;

public final /* synthetic */ class u0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57358b;

    public /* synthetic */ u0(CartFragmentViewModel cartFragmentViewModel) {
        this.f57358b = cartFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9788ignoreIfCartOwnedByAnotherVendor$lambda64(this.f57358b, obj);
    }
}
