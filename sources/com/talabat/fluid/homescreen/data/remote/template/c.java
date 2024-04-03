package com.talabat.fluid.homescreen.data.remote.template;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.fluid.homescreen.data.remote.template.FluidHomeTemplateRemoteDataSource;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IObservabilityManager f59711b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HomeScreenPerformanceObservability f59712c;

    public /* synthetic */ c(IObservabilityManager iObservabilityManager, HomeScreenPerformanceObservability homeScreenPerformanceObservability) {
        this.f59711b = iObservabilityManager;
        this.f59712c = homeScreenPerformanceObservability;
    }

    public final void accept(Object obj) {
        FluidHomeTemplateRemoteDataSource.AnonymousClass2.m10446invoke$lambda2(this.f59711b, this.f59712c, (Throwable) obj);
    }
}
