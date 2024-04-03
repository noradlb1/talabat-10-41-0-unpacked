package ri;

import com.talabat.darkstores.feature.cart.PostCartUseCase;
import java.util.concurrent.Callable;

public final /* synthetic */ class p1 implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PostCartUseCase f57340b;

    public /* synthetic */ p1(PostCartUseCase postCartUseCase) {
        this.f57340b = postCartUseCase;
    }

    public final Object call() {
        return PostCartUseCase.m9833invoke$lambda0(this.f57340b);
    }
}
