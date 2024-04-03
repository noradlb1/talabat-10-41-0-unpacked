package com.talabat.gem.domain.usecases;

import com.talabat.gem.ports.presentation.GemCounterViewPort;
import io.reactivex.functions.Action;

public final /* synthetic */ class h implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GemCounterViewPort f60464b;

    public /* synthetic */ h(GemCounterViewPort gemCounterViewPort) {
        this.f60464b = gemCounterViewPort;
    }

    public final void run() {
        GemCounterBusinessRulesKt$bindCounterAndVisibility$1.m10560invoke$lambda2(this.f60464b);
    }
}
