package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import java.util.concurrent.Callable;

public final /* synthetic */ class h1 implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57310b;

    public /* synthetic */ h1(CartFragmentViewModel cartFragmentViewModel) {
        this.f57310b = cartFragmentViewModel;
    }

    public final Object call() {
        return CartFragmentViewModel.m9786computeCartProductViewType$lambda59(this.f57310b);
    }
}
