package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import io.reactivex.functions.Function;

public final /* synthetic */ class z implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57369b;

    public /* synthetic */ z(CartFragmentViewModel cartFragmentViewModel) {
        this.f57369b = cartFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9812initViewModel$lambda27(this.f57369b, (CartFragmentViewModel.CartListContent) obj);
    }
}
