package com.deliveryhero.performance.core.screenmetric.performance;

import android.view.View;
import com.deliveryhero.performance.core.analytics.Metric;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder$stop$1", f = "RichContentLoadTimeRecorder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RichContentLoadTimeRecorder$stop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f30373h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RichContentLoadTimeRecorder f30374i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f30375j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ View f30376k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RichContentLoadTimeRecorder$stop$1(RichContentLoadTimeRecorder richContentLoadTimeRecorder, String str, View view, Continuation<? super RichContentLoadTimeRecorder$stop$1> continuation) {
        super(2, continuation);
        this.f30374i = richContentLoadTimeRecorder;
        this.f30375j = str;
        this.f30376k = view;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RichContentLoadTimeRecorder$stop$1(this.f30374i, this.f30375j, this.f30376k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RichContentLoadTimeRecorder$stop$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f30373h == 0) {
            ResultKt.throwOnFailure(obj);
            RichContentLoadTimeRecorder richContentLoadTimeRecorder = this.f30374i;
            String access$findKey = richContentLoadTimeRecorder.findKey(richContentLoadTimeRecorder.metrics, this.f30375j);
            if (access$findKey == null) {
                return Unit.INSTANCE;
            }
            Metric metric = (Metric) this.f30374i.metrics.get(access$findKey);
            if (metric == null) {
                metric = null;
            } else {
                metric.stop();
            }
            String access$screenName = this.f30374i.screenName(this.f30375j, this.f30376k);
            if (!Intrinsics.areEqual((Object) access$screenName, (Object) "N/A")) {
                this.f30374i.replaceMetric(this.f30375j, access$screenName, metric, access$findKey);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
