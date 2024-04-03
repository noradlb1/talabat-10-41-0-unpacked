package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.talabatcommon.optional.Optional;
import io.reactivex.functions.Function;

public final /* synthetic */ class i0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57312b;

    public /* synthetic */ i0(CartFragmentViewModel cartFragmentViewModel) {
        this.f57312b = cartFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9823initViewModel$lambda4(this.f57312b, (Optional) obj);
    }
}
