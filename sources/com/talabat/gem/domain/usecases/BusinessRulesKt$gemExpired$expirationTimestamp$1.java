package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/talabat/gem/domain/entities/GemOffer;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.gem.domain.usecases.BusinessRulesKt$gemExpired$expirationTimestamp$1", f = "BusinessRules.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BusinessRulesKt$gemExpired$expirationTimestamp$1 extends SuspendLambda implements Function2<GemOffer, Continuation<? super Long>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60338h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f60339i;

    public BusinessRulesKt$gemExpired$expirationTimestamp$1(Continuation<? super BusinessRulesKt$gemExpired$expirationTimestamp$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BusinessRulesKt$gemExpired$expirationTimestamp$1 businessRulesKt$gemExpired$expirationTimestamp$1 = new BusinessRulesKt$gemExpired$expirationTimestamp$1(continuation);
        businessRulesKt$gemExpired$expirationTimestamp$1.f60339i = obj;
        return businessRulesKt$gemExpired$expirationTimestamp$1;
    }

    @Nullable
    public final Object invoke(@NotNull GemOffer gemOffer, @Nullable Continuation<? super Long> continuation) {
        return ((BusinessRulesKt$gemExpired$expirationTimestamp$1) create(gemOffer, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60338h == 0) {
            ResultKt.throwOnFailure(obj);
            return ((GemOffer) this.f60339i).getExpirationTimestamp();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
