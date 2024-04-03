package com.talabat.gem.domain.usecases;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "it", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt$calculateRemainingMillis$3", f = "GemCounterBusinessRules.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GemCounterBusinessRulesKt$calculateRemainingMillis$3 extends SuspendLambda implements Function2<Long, Continuation<? super Long>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60380h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ long f60381i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Long f60382j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCounterBusinessRulesKt$calculateRemainingMillis$3(Long l11, Continuation<? super GemCounterBusinessRulesKt$calculateRemainingMillis$3> continuation) {
        super(2, continuation);
        this.f60382j = l11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GemCounterBusinessRulesKt$calculateRemainingMillis$3 gemCounterBusinessRulesKt$calculateRemainingMillis$3 = new GemCounterBusinessRulesKt$calculateRemainingMillis$3(this.f60382j, continuation);
        gemCounterBusinessRulesKt$calculateRemainingMillis$3.f60381i = ((Number) obj).longValue();
        return gemCounterBusinessRulesKt$calculateRemainingMillis$3;
    }

    @Nullable
    public final Object invoke(long j11, @Nullable Continuation<? super Long> continuation) {
        return ((GemCounterBusinessRulesKt$calculateRemainingMillis$3) create(Long.valueOf(j11), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).longValue(), (Continuation<? super Long>) (Continuation) obj2);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        long j11;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60380h == 0) {
            ResultKt.throwOnFailure(obj);
            long j12 = this.f60381i + ((long) 100);
            Long l11 = this.f60382j;
            if (l11 != null) {
                j11 = l11.longValue();
            } else {
                j11 = System.currentTimeMillis();
            }
            return Boxing.boxLong(j12 - j11);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
