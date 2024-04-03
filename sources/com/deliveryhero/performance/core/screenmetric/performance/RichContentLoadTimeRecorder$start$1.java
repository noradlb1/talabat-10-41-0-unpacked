package com.deliveryhero.performance.core.screenmetric.performance;

import com.deliveryhero.performance.core.analytics.Metric;
import j$.util.concurrent.ConcurrentHashMap;
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
@DebugMetadata(c = "com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder$start$1", f = "RichContentLoadTimeRecorder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RichContentLoadTimeRecorder$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f30370h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RichContentLoadTimeRecorder f30371i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f30372j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RichContentLoadTimeRecorder$start$1(RichContentLoadTimeRecorder richContentLoadTimeRecorder, String str, Continuation<? super RichContentLoadTimeRecorder$start$1> continuation) {
        super(2, continuation);
        this.f30371i = richContentLoadTimeRecorder;
        this.f30372j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RichContentLoadTimeRecorder$start$1(this.f30371i, this.f30372j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RichContentLoadTimeRecorder$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f30370h == 0) {
            ResultKt.throwOnFailure(obj);
            String access$buildKey = this.f30371i.buildKey(this.f30372j, "N/A");
            ConcurrentHashMap access$getMetrics$p = this.f30371i.metrics;
            Metric metric = new Metric();
            metric.start();
            access$getMetrics$p.put(access$buildKey, metric);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
