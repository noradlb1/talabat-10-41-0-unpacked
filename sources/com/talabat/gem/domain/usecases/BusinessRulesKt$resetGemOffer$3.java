package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.talabatcommon.extentions.KotlinResultKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/talabat/gem/domain/entities/GemOffer;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.gem.domain.usecases.BusinessRulesKt$resetGemOffer$3", f = "BusinessRules.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
public final class BusinessRulesKt$resetGemOffer$3 extends SuspendLambda implements Function2<GemOffer, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60347h;

    public BusinessRulesKt$resetGemOffer$3(Continuation<? super BusinessRulesKt$resetGemOffer$3> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BusinessRulesKt$resetGemOffer$3(continuation);
    }

    @Nullable
    public final Object invoke(@NotNull GemOffer gemOffer, @Nullable Continuation<? super Unit> continuation) {
        return ((BusinessRulesKt$resetGemOffer$3) create(gemOffer, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60347h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super Result<GemOffer>>, Object> saveGemOffer = IntegrationKt.getDataSources().saveGemOffer(BusinessRulesKt.getNullGemOffer());
            this.f60347h = 1;
            if (KotlinResultKt.getOrThrow(saveGemOffer, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
