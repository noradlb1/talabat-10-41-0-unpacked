package wq;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.usecases.GemExpiredBusinessRulesKt;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class j implements Predicate {
    public final boolean test(Object obj) {
        return GemExpiredBusinessRulesKt.m10563expiredOfferAndRestaurants$lambda1((GemOffer) obj);
    }
}
