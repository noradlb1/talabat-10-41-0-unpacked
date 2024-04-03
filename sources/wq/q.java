package wq;

import com.talabat.gem.domain.usecases.GemOfferProcessingBusinessRulesKt;
import com.talabat.gem.ports.presentation.GemOfferProcessingViewPort;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class q implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GemOfferProcessingViewPort f63008b;

    public /* synthetic */ q(GemOfferProcessingViewPort gemOfferProcessingViewPort) {
        this.f63008b = gemOfferProcessingViewPort;
    }

    public final void accept(Object obj) {
        GemOfferProcessingBusinessRulesKt.m10573processGemOffer$lambda5(this.f63008b, (Throwable) obj);
    }
}
