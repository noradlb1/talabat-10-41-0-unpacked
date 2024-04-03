package com.talabat.gem.domain.usecases;

import com.talabat.gem.ports.presentation.GemCounterViewPort;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GemCounterViewPort f60463b;

    public /* synthetic */ g(GemCounterViewPort gemCounterViewPort) {
        this.f60463b = gemCounterViewPort;
    }

    public final void accept(Object obj) {
        GemCounterBusinessRulesKt$bindCounterAndVisibility$1.m10559invoke$lambda1(this.f60463b, (Throwable) obj);
    }
}
