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
@DebugMetadata(c = "com.talabat.gem.samples.SampleDataSourcesAdapter$saveGemOffer$1", f = "SampleDataSources.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SampleDataSourcesAdapter$saveGemOffer$1 extends SuspendLambda implements Function1<Continuation<? super GemOffer>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60489h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SampleDataSourcesAdapter f60490i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GemOffer f60491j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SampleDataSourcesAdapter$saveGemOffer$1(SampleDataSourcesAdapter sampleDataSourcesAdapter, GemOffer gemOffer, Continuation<? super SampleDataSourcesAdapter$saveGemOffer$1> continuation) {
        super(1, continuation);
        this.f60490i = sampleDataSourcesAdapter;
        this.f60491j = gemOffer;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new SampleDataSourcesAdapter$saveGemOffer$1(this.f60490i, this.f60491j, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super GemOffer> continuation) {
        return ((SampleDataSourcesAdapter$saveGemOffer$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60489h == 0) {
            ResultKt.throwOnFailure(obj);
            RxKt.plusAssign(this.f60490i.gemOffer, this.f60491j);
            return this.f60491j;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
