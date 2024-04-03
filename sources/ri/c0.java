package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public final /* synthetic */ class c0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57293b;

    public /* synthetic */ c0(CartFragmentViewModel cartFragmentViewModel) {
        this.f57293b = cartFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9815initViewModel$lambda31(this.f57293b, (Observable) obj);
    }
}
