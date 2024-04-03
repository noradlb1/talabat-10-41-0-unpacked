package ri;

import com.talabat.darkstores.feature.cart.CartController;
import io.reactivex.functions.Action;

public final /* synthetic */ class g implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartController f57305b;

    public /* synthetic */ g(CartController cartController) {
        this.f57305b = cartController;
    }

    public final void run() {
        CartController.m9774clearCart$lambda0(this.f57305b);
    }
}
