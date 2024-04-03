package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import io.reactivex.functions.Action;

public final /* synthetic */ class g1 implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57307b;

    public /* synthetic */ g1(CartFragmentViewModel cartFragmentViewModel) {
        this.f57307b = cartFragmentViewModel;
    }

    public final void run() {
        CartFragmentViewModel.m9826showMultiBasketToast$lambda51(this.f57307b);
    }
}
