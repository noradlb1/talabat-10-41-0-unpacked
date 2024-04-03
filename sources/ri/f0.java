package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.feature.darkstorescart.data.model.Product;
import io.reactivex.functions.Function;

public final /* synthetic */ class f0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57303b;

    public /* synthetic */ f0(CartFragmentViewModel cartFragmentViewModel) {
        this.f57303b = cartFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9819initViewModel$lambda35(this.f57303b, (Product) obj);
    }
}
