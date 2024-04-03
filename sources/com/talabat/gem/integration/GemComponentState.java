package com.talabat.gem.integration;

import com.talabat.gem.domain.entities.GemOffer;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/talabat/gem/integration/GemComponentState;", "Ljava/util/concurrent/Callable;", "", "", "()V", "call", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemComponentState implements Callable<Map<String, ? extends String>> {
    @NotNull
    public Map<String, String> call() {
        GemOffer access$gemOffer = GemComponentStateKt.gemOffer();
        Pair[] pairArr = new Pair[8];
        Long l11 = null;
        pairArr[0] = TuplesKt.to("gemOfferId", String.valueOf(access$gemOffer != null ? access$gemOffer.getId() : null));
        pairArr[1] = TuplesKt.to("gemComponentStateTimestamp", String.valueOf(System.currentTimeMillis()));
        if (access$gemOffer != null) {
            l11 = access$gemOffer.getExpirationTimestamp();
        }
        pairArr[2] = TuplesKt.to("gemExpirationTimestamp", String.valueOf(l11));
        pairArr[3] = TuplesKt.to("gemRestaurantId", GemComponentStateKt.gemRestaurantId());
        pairArr[4] = TuplesKt.to("gemExpiredOfferId", GemComponentStateKt.expiredGemOfferId());
        pairArr[5] = TuplesKt.to("gemExpirationAlertDisplayed", GemComponentStateKt.isExpirationAlertDisplayed());
        pairArr[6] = TuplesKt.to("gemCachedSelectedRestaurantId", GemComponentStateKt.cachedSelectedRestaurantId());
        pairArr[7] = TuplesKt.to("gemOfferAcceptance", GemComponentStateKt.gemOfferAcceptance());
        return MapsKt__MapsKt.mapOf(pairArr);
    }
}
