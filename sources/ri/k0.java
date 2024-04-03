package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import io.reactivex.functions.Function;

public final /* synthetic */ class k0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57317b;

    public /* synthetic */ k0(CartFragmentViewModel cartFragmentViewModel) {
        this.f57317b = cartFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9803initViewModel$lambda13(this.f57317b, (CartResponse) obj);
    }
}
