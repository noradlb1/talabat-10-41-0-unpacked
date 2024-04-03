package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/talabat/gem/domain/entities/GemOffer;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.gem.domain.usecases.GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$5", f = "GemViewBusinessRules.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$5 extends SuspendLambda implements Function2<GemOffer, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60456h;

    public GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$5(Continuation<? super GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$5> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$5(continuation);
    }

    @Nullable
    public final Object invoke(@NotNull GemOffer gemOffer, @Nullable Continuation<? super Unit> continuation) {
        return ((GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$5) create(gemOffer, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60456h == 0) {
            ResultKt.throwOnFailure(obj);
            IntegrationKt.getDataSources().resetTriggerExpirationAlertFlag();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
