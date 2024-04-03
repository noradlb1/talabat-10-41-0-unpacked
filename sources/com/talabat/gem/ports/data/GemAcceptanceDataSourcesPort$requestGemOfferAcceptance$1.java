package com.talabat.gem.ports.data;

import com.talabat.gem.domain.entities.GemOfferAcceptance;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Accepted;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.gem.ports.data.GemAcceptanceDataSourcesPort$requestGemOfferAcceptance$1", f = "DataSourcesPort.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GemAcceptanceDataSourcesPort$requestGemOfferAcceptance$1 extends SuspendLambda implements Function1<Continuation<? super GemOfferAcceptance.Accepted>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60473h;

    public GemAcceptanceDataSourcesPort$requestGemOfferAcceptance$1(Continuation<? super GemAcceptanceDataSourcesPort$requestGemOfferAcceptance$1> continuation) {
        super(1, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new GemAcceptanceDataSourcesPort$requestGemOfferAcceptance$1(continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super GemOfferAcceptance.Accepted> continuation) {
        return ((GemAcceptanceDataSourcesPort$requestGemOfferAcceptance$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60473h == 0) {
            ResultKt.throwOnFailure(obj);
            return GemOfferAcceptance.Accepted.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
