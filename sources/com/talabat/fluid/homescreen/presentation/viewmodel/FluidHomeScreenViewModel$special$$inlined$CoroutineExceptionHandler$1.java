package com.talabat.fluid.homescreen.presentation.viewmodel;

import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenViewModel$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenViewModel f59727b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FluidHomeScreenViewModel$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key, FluidHomeScreenViewModel fluidHomeScreenViewModel) {
        super(key);
        this.f59727b = fluidHomeScreenViewModel;
    }

    public void handleException(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th2) {
        this.f59727b.track(th2);
        LogManager.logException(th2);
        HomeScreenPerformanceObservability access$getHomeScreenPerformanceObservability$p = this.f59727b.homeScreenPerformanceObservability;
        HomeScreenPerformanceObservability.Level level = HomeScreenPerformanceObservability.Level.ERROR;
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        access$getHomeScreenPerformanceObservability$p.traceEvent(level, "fluidHomeScreenViewModel.exceptionHandler", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("error", message)));
    }
}
