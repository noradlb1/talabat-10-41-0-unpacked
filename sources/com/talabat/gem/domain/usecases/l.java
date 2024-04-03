package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOffer;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class l implements Predicate {
    public final boolean test(Object obj) {
        return GemExpiredBusinessRulesKt$bindExpiredOffer$1.m10565invoke$lambda0((GemOffer) obj);
    }
}
