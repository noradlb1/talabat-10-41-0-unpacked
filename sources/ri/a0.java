package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.BiFunction;
import kotlin.Pair;

public final /* synthetic */ class a0 implements BiFunction {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57283b;

    public /* synthetic */ a0(CartFragmentViewModel cartFragmentViewModel) {
        this.f57283b = cartFragmentViewModel;
    }

    public final Object apply(Object obj, Object obj2) {
        return CartFragmentViewModel.m9813initViewModel$lambda28(this.f57283b, (Pair) obj, (Vendor) obj2);
    }
}
