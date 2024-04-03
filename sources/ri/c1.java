package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class c1 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57294b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function0 f57295c;

    public /* synthetic */ c1(CartFragmentViewModel cartFragmentViewModel, Function0 function0) {
        this.f57294b = cartFragmentViewModel;
        this.f57295c = function0;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9793increaseProductCount$lambda39(this.f57294b, this.f57295c, (Pair) obj);
    }
}
