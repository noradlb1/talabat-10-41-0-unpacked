package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
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

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "it", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "Lcom/talabat/gem/domain/entities/GemOffer;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.gem.domain.usecases.GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$6", f = "GemViewBusinessRules.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$6 extends SuspendLambda implements Function2<Throwable, Continuation<? super Function1<? super Continuation<? super Result<? extends GemOffer>>, ? extends Object>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60457h;

    public GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$6(Continuation<? super GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$6> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$6(continuation);
    }

    @Nullable
    public final Object invoke(@NotNull Throwable th2, @Nullable Continuation<? super Function1<? super Continuation<? super Result<GemOffer>>, ? extends Object>> continuation) {
        return ((GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$6) create(th2, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60457h == 0) {
            ResultKt.throwOnFailure(obj);
            return IntegrationKt.getDataSources().saveGemOffer(BusinessRulesKt.getNullGemOffer());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
