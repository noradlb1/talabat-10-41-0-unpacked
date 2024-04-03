package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import io.reactivex.functions.Function;

public final /* synthetic */ class n0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57328b;

    public /* synthetic */ n0(CartFragmentViewModel cartFragmentViewModel) {
        this.f57328b = cartFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9806initViewModel$lambda20(this.f57328b, (CartResponse) obj);
    }
}
