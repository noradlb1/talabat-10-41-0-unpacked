package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class w0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57365b;

    public /* synthetic */ w0(CartFragmentViewModel cartFragmentViewModel) {
        this.f57365b = cartFragmentViewModel;
    }

    public final void accept(Object obj) {
        CartFragmentViewModel.m9799initViewModel$lambda12$lambda10$lambda5(this.f57365b, (Disposable) obj);
    }
}
