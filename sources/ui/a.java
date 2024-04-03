package ui;

import com.talabat.darkstores.feature.cart.multibasket.InitCartUseCase;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InitCartUseCase f57884b;

    public /* synthetic */ a(InitCartUseCase initCartUseCase) {
        this.f57884b = initCartUseCase;
    }

    public final Object call() {
        return InitCartUseCase.m9843getCart$lambda3$lambda2(this.f57884b);
    }
}
