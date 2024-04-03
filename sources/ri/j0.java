package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import io.reactivex.functions.Function;
import kotlin.Unit;

public final /* synthetic */ class j0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57314b;

    public /* synthetic */ j0(CartFragmentViewModel cartFragmentViewModel) {
        this.f57314b = cartFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9797initViewModel$lambda12(this.f57314b, (Unit) obj);
    }
}
