package com.talabat.gem.adapters.data;

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
@DebugMetadata(c = "com.talabat.gem.adapters.data.GemOfferDataSources$saveGemOffer$1", f = "GemDataSources.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GemOfferDataSources$saveGemOffer$1 extends SuspendLambda implements Function1<Continuation<? super GemOffer>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59870h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GemOffer f59871i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemOfferDataSources$saveGemOffer$1(GemOffer gemOffer, Continuation<? super GemOfferDataSources$saveGemOffer$1> continuation) {
        super(1, continuation);
        this.f59871i = gemOffer;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new GemOfferDataSources$saveGemOffer$1(this.f59871i, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super GemOffer> continuation) {
        return ((GemOfferDataSources$saveGemOffer$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f59870h == 0) {
            ResultKt.throwOnFailure(obj);
            CacheKt.getCachedOffer().onNext(new com.talabat.talabatcommon.extentions.Nullable(this.f59871i));
            return this.f59871i;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
