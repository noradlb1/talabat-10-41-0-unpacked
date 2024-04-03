package com.deliveryhero.performance.core.screenmetric.performance;

import com.deliveryhero.performance.core.analytics.Metric;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/deliveryhero/performance/core/screenmetric/performance/ImageMetric;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder$imageLoadingMetrics$2", f = "RichContentLoadTimeRecorder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RichContentLoadTimeRecorder$imageLoadingMetrics$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageMetric>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f30365h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RichContentLoadTimeRecorder f30366i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f30367j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RichContentLoadTimeRecorder$imageLoadingMetrics$2(RichContentLoadTimeRecorder richContentLoadTimeRecorder, String str, Continuation<? super RichContentLoadTimeRecorder$imageLoadingMetrics$2> continuation) {
        super(2, continuation);
        this.f30366i = richContentLoadTimeRecorder;
        this.f30367j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RichContentLoadTimeRecorder$imageLoadingMetrics$2(this.f30366i, this.f30367j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ImageMetric> continuation) {
        return ((RichContentLoadTimeRecorder$imageLoadingMetrics$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        long j11;
        Long l11;
        boolean z11;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f30365h == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f30366i.metrics.isEmpty()) {
                return null;
            }
            ConcurrentHashMap access$getMetrics$p = this.f30366i.metrics;
            RichContentLoadTimeRecorder richContentLoadTimeRecorder = this.f30366i;
            String str = this.f30367j;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : access$getMetrics$p.entrySet()) {
                Metric metric = (Metric) entry.getValue();
                if (!Intrinsics.areEqual((Object) richContentLoadTimeRecorder.toScreenName((String) entry.getKey()), (Object) str) || metric == null || metric.isRunning()) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry value : linkedHashMap.entrySet()) {
                Metric metric2 = (Metric) value.getValue();
                if (metric2 == null) {
                    l11 = null;
                } else {
                    l11 = metric2.duration();
                }
                if (l11 != null) {
                    arrayList.add(l11);
                }
            }
            List sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new RichContentLoadTimeRecorder$imageLoadingMetrics$2$invokeSuspend$$inlined$sortedBy$1());
            if (sortedWith.isEmpty()) {
                return null;
            }
            int size = sortedWith.size();
            long longValue = ((Number) this.f30366i.percentile(sortedWith, 50)).longValue();
            long longValue2 = ((Number) this.f30366i.percentile(sortedWith, 75)).longValue();
            long longValue3 = ((Number) this.f30366i.percentile(sortedWith, 95)).longValue();
            Long l12 = (Long) CollectionsKt.maxOrNull((Iterable) sortedWith);
            if (l12 == null) {
                j11 = 0;
            } else {
                j11 = l12.longValue();
            }
            ImageMetric imageMetric = new ImageMetric(size, longValue, longValue2, longValue3, j11);
            RichContentLoadTimeRecorder richContentLoadTimeRecorder2 = this.f30366i;
            for (Map.Entry key : linkedHashMap.entrySet()) {
                richContentLoadTimeRecorder2.metrics.remove(key.getKey());
            }
            this.f30366i.clearAttachListeners();
            return imageMetric;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
