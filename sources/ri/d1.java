package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

public final /* synthetic */ class d1 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57298b;

    public /* synthetic */ d1(CartFragmentViewModel cartFragmentViewModel) {
        this.f57298b = cartFragmentViewModel;
    }

    public final void accept(Object obj) {
        CartFragmentViewModel.m9794increaseProductCount$lambda40(this.f57298b, (Pair) obj);
    }
}
