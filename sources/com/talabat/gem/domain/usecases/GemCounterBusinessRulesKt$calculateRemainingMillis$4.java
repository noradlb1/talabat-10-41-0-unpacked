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

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt$calculateRemainingMillis$4", f = "GemCounterBusinessRules.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GemCounterBusinessRulesKt$calculateRemainingMillis$4 extends SuspendLambda implements Function2<Long, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60383h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ long f60384i;

    public GemCounterBusinessRulesKt$calculateRemainingMillis$4(Continuation<? super GemCounterBusinessRulesKt$calculateRemainingMillis$4> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GemCounterBusinessRulesKt$calculateRemainingMillis$4 gemCounterBusinessRulesKt$calculateRemainingMillis$4 = new GemCounterBusinessRulesKt$calculateRemainingMillis$4(continuation);
        gemCounterBusinessRulesKt$calculateRemainingMillis$4.f60384i = ((Number) obj).longValue();
        return gemCounterBusinessRulesKt$calculateRemainingMillis$4;
    }

    @Nullable
    public final Object invoke(long j11, @Nullable Continuation<? super Boolean> continuation) {
        return ((GemCounterBusinessRulesKt$calculateRemainingMillis$4) create(Long.valueOf(j11), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).longValue(), (Continuation<? super Boolean>) (Continuation) obj2);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z11;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60383h == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f60384i > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            return Boxing.boxBoolean(z11);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
