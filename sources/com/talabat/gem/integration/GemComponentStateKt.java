package com.talabat.gem.integration;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.talabatcommon.extentions.KotlinResultKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0002\u001a\b\u0010\u0006\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0007\u001a\u00020\u0001H\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002¨\u0006\t"}, d2 = {"cachedSelectedRestaurantId", "", "expiredGemOfferId", "gemOffer", "Lcom/talabat/gem/domain/entities/GemOffer;", "kotlin.jvm.PlatformType", "gemOfferAcceptance", "gemRestaurantId", "isExpirationAlertDisplayed", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemComponentStateKt {
    /* access modifiers changed from: private */
    public static final String cachedSelectedRestaurantId() {
        GemRestaurant blockingGet = IntegrationKt.getDataSources().observeOnSelectedGemRestaurant().firstElement().blockingGet();
        return String.valueOf(blockingGet != null ? blockingGet.getId() : null);
    }

    /* access modifiers changed from: private */
    public static final String expiredGemOfferId() {
        GemOffer loadExpiredOffer = IntegrationKt.getDataSources().loadExpiredOffer();
        return String.valueOf(loadExpiredOffer != null ? loadExpiredOffer.getId() : null);
    }

    /* access modifiers changed from: private */
    public static final GemOffer gemOffer() {
        return (GemOffer) KotlinResultKt.toMaybe$default(IntegrationKt.getDataSources().loadGemOffer(), (Function1) null, 1, (Object) null).blockingGet();
    }

    /* access modifiers changed from: private */
    public static final String gemOfferAcceptance() {
        return String.valueOf(IntegrationKt.getDataSources().loadGemOfferAcceptance());
    }

    /* access modifiers changed from: private */
    public static final String gemRestaurantId() {
        GemRestaurant loadSelectedGemRestaurant = IntegrationKt.getDataSources().loadSelectedGemRestaurant();
        return String.valueOf(loadSelectedGemRestaurant != null ? loadSelectedGemRestaurant.getId() : null);
    }

    /* access modifiers changed from: private */
    public static final String isExpirationAlertDisplayed() {
        return String.valueOf(IntegrationKt.getDataSources().loadTriggerExpirationAlertFlag().copy().getValue());
    }
}
