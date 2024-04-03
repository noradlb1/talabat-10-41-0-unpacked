package wq;

import com.talabat.gem.domain.usecases.GemOfferProcessingBusinessRulesKt;
import com.talabat.gem.ports.presentation.GemOfferProcessingViewPort;
import java.util.concurrent.Callable;

public final /* synthetic */ class k implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GemOfferProcessingViewPort f63006b;

    public /* synthetic */ k(GemOfferProcessingViewPort gemOfferProcessingViewPort) {
        this.f63006b = gemOfferProcessingViewPort;
    }

    public final Object call() {
        return GemOfferProcessingBusinessRulesKt.m10575restaurantsData$lambda7(this.f63006b);
    }
}
