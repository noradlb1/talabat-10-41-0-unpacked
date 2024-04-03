package wq;

import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.gem.domain.usecases.GemOfferProcessingBusinessRulesKt;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class o implements Consumer {
    public final void accept(Object obj) {
        GemOfferProcessingBusinessRulesKt.m10571processGemOffer$lambda3((GemOfferAcceptance) obj);
    }
}
