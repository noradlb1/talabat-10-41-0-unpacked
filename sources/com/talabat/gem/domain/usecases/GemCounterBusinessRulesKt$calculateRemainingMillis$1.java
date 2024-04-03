package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/talabat/gem/domain/entities/GemOffer;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt$calculateRemainingMillis$1", f = "GemCounterBusinessRules.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GemCounterBusinessRulesKt$calculateRemainingMillis$1 extends SuspendLambda implements Function1<Continuation<? super GemOffer>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60376h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GemOffer f60377i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCounterBusinessRulesKt$calculateRemainingMillis$1(GemOffer gemOffer, Continuation<? super GemCounterBusinessRulesKt$calculateRemainingMillis$1> continuation) {
        super(1, continuation);
        this.f60377i = gemOffer;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new GemCounterBusinessRulesKt$calculateRemainingMillis$1(this.f60377i, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super GemOffer> continuation) {
        return ((GemCounterBusinessRulesKt$calculateRemainingMillis$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60376h == 0) {
            ResultKt.throwOnFailure(obj);
            return this.f60377i;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
