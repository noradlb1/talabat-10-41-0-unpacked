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
@DebugMetadata(c = "com.talabat.gem.domain.usecases.BusinessRulesKt$calculateGemRemainingSeconds$2", f = "BusinessRules.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BusinessRulesKt$calculateGemRemainingSeconds$2 extends SuspendLambda implements Function2<Long, Continuation<? super Long>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60336h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ long f60337i;

    public BusinessRulesKt$calculateGemRemainingSeconds$2(Continuation<? super BusinessRulesKt$calculateGemRemainingSeconds$2> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BusinessRulesKt$calculateGemRemainingSeconds$2 businessRulesKt$calculateGemRemainingSeconds$2 = new BusinessRulesKt$calculateGemRemainingSeconds$2(continuation);
        businessRulesKt$calculateGemRemainingSeconds$2.f60337i = ((Number) obj).longValue();
        return businessRulesKt$calculateGemRemainingSeconds$2;
    }

    @Nullable
    public final Object invoke(long j11, @Nullable Continuation<? super Long> continuation) {
        return ((BusinessRulesKt$calculateGemRemainingSeconds$2) create(Long.valueOf(j11), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).longValue(), (Continuation<? super Long>) (Continuation) obj2);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60336h == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxLong(this.f60337i / 1000);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
