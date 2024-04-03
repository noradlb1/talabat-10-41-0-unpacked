package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import io.reactivex.functions.Function;
import kotlin.Pair;

public final /* synthetic */ class j1 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57315b;

    public /* synthetic */ j1(CartFragmentViewModel cartFragmentViewModel) {
        this.f57315b = cartFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9798initViewModel$lambda12$lambda10(this.f57315b, (Pair) obj);
    }
}
