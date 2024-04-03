package ui;

import com.talabat.darkstores.feature.cart.multibasket.Cart;
import com.talabat.darkstores.feature.cart.multibasket.InitCartUseCase;
import io.reactivex.functions.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InitCartUseCase f57886b;

    public /* synthetic */ c(InitCartUseCase initCartUseCase) {
        this.f57886b = initCartUseCase;
    }

    public final Object apply(Object obj) {
        return this.f57886b.handleCartResponse((Cart) obj);
    }
}
