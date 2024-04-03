package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import io.reactivex.functions.Action;

public final /* synthetic */ class v implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57359b;

    public /* synthetic */ v(CartFragmentViewModel cartFragmentViewModel) {
        this.f57359b = cartFragmentViewModel;
    }

    public final void run() {
        CartFragmentViewModel.m9785clearCart$lambda42(this.f57359b);
    }
}
