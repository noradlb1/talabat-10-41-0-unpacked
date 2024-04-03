package com.deliveryhero.performance.core.screenmetric.performance;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeTracer$reportImageLoadingTimeTrace$1", f = "RichContentLoadTimeTracer.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
public final class RichContentLoadTimeTracer$reportImageLoadingTimeTrace$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f30377h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RichContentLoadTimeTracer f30378i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f30379j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RichContentLoadTimeTracer$reportImageLoadingTimeTrace$1(RichContentLoadTimeTracer richContentLoadTimeTracer, String str, Continuation<? super RichContentLoadTimeTracer$reportImageLoadingTimeTrace$1> continuation) {
        super(2, continuation);
        this.f30378i = richContentLoadTimeTracer;
        this.f30379j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RichContentLoadTimeTracer$reportImageLoadingTimeTrace$1(this.f30378i, this.f30379j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RichContentLoadTimeTracer$reportImageLoadingTimeTrace$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f30377h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            RichContentLoadTimeRecorder access$getRichContentLoadTimeRecorder$p = this.f30378i.richContentLoadTimeRecorder;
            String str = this.f30379j;
            this.f30377h = 1;
            obj = access$getRichContentLoadTimeRecorder$p.imageLoadingMetrics(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ImageMetric imageMetric = (ImageMetric) obj;
        if (imageMetric == null) {
            return Unit.INSTANCE;
        }
        String access$toRcltTraceName = this.f30378i.toRcltTraceName(this.f30379j);
        this.f30378i.performanceTrackingManager.startTrace(access$toRcltTraceName);
        this.f30378i.performanceTrackingManager.addTraceAttribute(access$toRcltTraceName, RichContentLoadTimeTracer.SCREEN_DENSITY_ATTR, String.valueOf(this.f30378i.displayMetrics.densityDpi));
        this.f30378i.performanceTrackingManager.putTraceMetric(access$toRcltTraceName, "count", (long) imageMetric.getCount());
        this.f30378i.performanceTrackingManager.putTraceMetric(access$toRcltTraceName, RichContentLoadTimeTracer.P50, imageMetric.getP50());
        this.f30378i.performanceTrackingManager.putTraceMetric(access$toRcltTraceName, RichContentLoadTimeTracer.P75, imageMetric.getP75());
        this.f30378i.performanceTrackingManager.putTraceMetric(access$toRcltTraceName, RichContentLoadTimeTracer.P95, imageMetric.getP95());
        this.f30378i.performanceTrackingManager.putTraceMetric(access$toRcltTraceName, RichContentLoadTimeTracer.MAX, imageMetric.getMax());
        this.f30378i.performanceTrackingManager.stopTrace(access$toRcltTraceName);
        return Unit.INSTANCE;
    }
}
