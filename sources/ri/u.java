package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class u implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57357b;

    public /* synthetic */ u(CartFragmentViewModel cartFragmentViewModel) {
        this.f57357b = cartFragmentViewModel;
    }

    public final void accept(Object obj) {
        CartFragmentViewModel.m9795initCart$lambda0(this.f57357b, (Disposable) obj);
    }
}
