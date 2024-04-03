package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOffer;
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

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a \b\u0001\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/talabat/gem/domain/entities/GemOffer;", "it", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.gem.domain.usecases.BusinessRulesKt$calculateGemRemainingSeconds$1", f = "BusinessRules.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BusinessRulesKt$calculateGemRemainingSeconds$1 extends SuspendLambda implements Function2<GemOffer, Continuation<? super Function1<? super Continuation<? super Result<? extends Long>>, ? extends Object>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60333h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f60334i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Long f60335j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BusinessRulesKt$calculateGemRemainingSeconds$1(Long l11, Continuation<? super BusinessRulesKt$calculateGemRemainingSeconds$1> continuation) {
        super(2, continuation);
        this.f60335j = l11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BusinessRulesKt$calculateGemRemainingSeconds$1 businessRulesKt$calculateGemRemainingSeconds$1 = new BusinessRulesKt$calculateGemRemainingSeconds$1(this.f60335j, continuation);
        businessRulesKt$calculateGemRemainingSeconds$1.f60334i = obj;
        return businessRulesKt$calculateGemRemainingSeconds$1;
    }

    @Nullable
    public final Object invoke(@NotNull GemOffer gemOffer, @Nullable Continuation<? super Function1<? super Continuation<? super Result<Long>>, ? extends Object>> continuation) {
        return ((BusinessRulesKt$calculateGemRemainingSeconds$1) create(gemOffer, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60333h == 0) {
            ResultKt.throwOnFailure(obj);
            return GemCounterBusinessRulesKt.calculateRemainingMillis((GemOffer) this.f60334i, this.f60335j);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
