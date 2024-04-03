package com.talabat.gem.domain.usecases;

import com.talabat.gem.ports.presentation.GemExpiredViewPort;
import io.reactivex.functions.Predicate;
import kotlin.Triple;

public final /* synthetic */ class m implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GemExpiredViewPort f60465b;

    public /* synthetic */ m(GemExpiredViewPort gemExpiredViewPort) {
        this.f60465b = gemExpiredViewPort;
    }

    public final boolean test(Object obj) {
        return GemExpiredBusinessRulesKt$bindTriggerExpirationAlert$1.m10566invoke$lambda0(this.f60465b, (Triple) obj);
    }
}
