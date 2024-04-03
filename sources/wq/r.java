package wq;

import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.gem.domain.usecases.GemOfferProcessingBusinessRulesKt;
import com.talabat.gem.ports.presentation.GemOfferProcessingViewPort;
import io.reactivex.functions.BiConsumer;

public final /* synthetic */ class r implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GemOfferProcessingViewPort f63009a;

    public /* synthetic */ r(GemOfferProcessingViewPort gemOfferProcessingViewPort) {
        this.f63009a = gemOfferProcessingViewPort;
    }

    public final void accept(Object obj, Object obj2) {
        GemOfferProcessingBusinessRulesKt.m10574processGemOffer$lambda6(this.f63009a, (GemOfferAcceptance) obj, (Throwable) obj2);
    }
}
