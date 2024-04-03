package com.talabat.gem.domain.usecases;

import com.talabat.gem.ports.presentation.GemPerRestaurantViewPort;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class p implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GemPerRestaurantViewPort f60466b;

    public /* synthetic */ p(GemPerRestaurantViewPort gemPerRestaurantViewPort) {
        this.f60466b = gemPerRestaurantViewPort;
    }

    public final void accept(Object obj) {
        GemPerRestaurantBusinessRulesKt$bindVisibilityPerRestaurant$1.m10579invoke$lambda1(this.f60466b, (Throwable) obj);
    }
}
