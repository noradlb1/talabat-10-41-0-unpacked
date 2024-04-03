package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import io.reactivex.functions.Function;
import kotlin.Pair;

public final /* synthetic */ class l0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57320b;

    public /* synthetic */ l0(CartFragmentViewModel cartFragmentViewModel) {
        this.f57320b = cartFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9804initViewModel$lambda16(this.f57320b, (Pair) obj);
    }
}
