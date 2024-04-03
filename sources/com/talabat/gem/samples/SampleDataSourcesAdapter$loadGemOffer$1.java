package com.talabat.gem.samples;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.talabatcommon.extentions.RxKt;
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
@DebugMetadata(c = "com.talabat.gem.samples.SampleDataSourcesAdapter$loadGemOffer$1", f = "SampleDataSources.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SampleDataSourcesAdapter$loadGemOffer$1 extends SuspendLambda implements Function1<Continuation<? super GemOffer>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60484h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SampleDataSourcesAdapter f60485i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SampleDataSourcesAdapter$loadGemOffer$1(SampleDataSourcesAdapter sampleDataSourcesAdapter, Continuation<? super SampleDataSourcesAdapter$loadGemOffer$1> continuation) {
        super(1, continuation);
        this.f60485i = sampleDataSourcesAdapter;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new SampleDataSourcesAdapter$loadGemOffer$1(this.f60485i, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super GemOffer> continuation) {
        return ((SampleDataSourcesAdapter$loadGemOffer$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60484h == 0) {
            ResultKt.throwOnFailure(obj);
            Object invoke = RxKt.invoke(this.f60485i.gemOffer);
            if (invoke != null) {
                return (GemOffer) invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.gem.domain.entities.GemOffer");
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
