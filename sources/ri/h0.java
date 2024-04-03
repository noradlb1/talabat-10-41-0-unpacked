package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class h0 implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f57309b;

    public /* synthetic */ h0(boolean z11) {
        this.f57309b = z11;
    }

    public final boolean test(Object obj) {
        return CartFragmentViewModel.m9822initViewModel$lambda37(this.f57309b, (CartResponse) obj);
    }
}
