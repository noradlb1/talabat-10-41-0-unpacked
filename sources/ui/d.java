package ui;

import com.talabat.darkstores.feature.cart.multibasket.InitCartUseCase;
import io.reactivex.functions.Function;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InitCartUseCase f57887b;

    public /* synthetic */ d(InitCartUseCase initCartUseCase) {
        this.f57887b = initCartUseCase;
    }

    public final Object apply(Object obj) {
        return InitCartUseCase.m9842getCart$lambda3(this.f57887b, (Throwable) obj);
    }
}
