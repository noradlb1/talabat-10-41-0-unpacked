package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class f1 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57304b;

    public /* synthetic */ f1(CartFragmentViewModel cartFragmentViewModel) {
        this.f57304b = cartFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9825showMultiBasketToast$lambda50(this.f57304b, (Vendor) obj);
    }
}
