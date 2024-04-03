package wq;

import com.talabat.gem.domain.usecases.GemOfferProcessingBusinessRulesKt;
import com.talabat.gem.ports.presentation.GemOfferProcessingViewPort;
import io.reactivex.functions.BiConsumer;
import kotlin.Pair;

public final /* synthetic */ class l implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GemOfferProcessingViewPort f63007a;

    public /* synthetic */ l(GemOfferProcessingViewPort gemOfferProcessingViewPort) {
        this.f63007a = gemOfferProcessingViewPort;
    }

    public final void accept(Object obj, Object obj2) {
        GemOfferProcessingBusinessRulesKt.m10568processGemOffer$lambda0(this.f63007a, (Pair) obj, (Throwable) obj2);
    }
}
