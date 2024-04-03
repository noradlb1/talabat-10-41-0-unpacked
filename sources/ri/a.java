package ri;

import com.talabat.darkstores.feature.cart.BasketLifeTimeTooltipUseCase;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BasketLifeTimeTooltipUseCase f57282b;

    public /* synthetic */ a(BasketLifeTimeTooltipUseCase basketLifeTimeTooltipUseCase) {
        this.f57282b = basketLifeTimeTooltipUseCase;
    }

    public final Object call() {
        return BasketLifeTimeTooltipUseCase.m9769isBasketLifetimeTooltipEnabled$lambda0(this.f57282b);
    }
}
