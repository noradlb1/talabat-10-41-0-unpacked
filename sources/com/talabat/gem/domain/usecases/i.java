package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOffer;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class i implements Predicate {
    public final boolean test(Object obj) {
        return GemCounterBusinessRulesKt$bindCounterExpired$1.m10561invoke$lambda0((GemOffer) obj);
    }
}
