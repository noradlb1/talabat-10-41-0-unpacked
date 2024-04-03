package com.talabat.gem.ports.data;

import com.talabat.gem.domain.entities.GemOffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/talabat/gem/domain/entities/GemOffer;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.gem.ports.data.GemOfferDataSourcesPort$requestGemOfferFromFlutterHome$1", f = "DataSourcesPort.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GemOfferDataSourcesPort$requestGemOfferFromFlutterHome$1 extends SuspendLambda implements Function1<Continuation<? super GemOffer>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60477h;

    public GemOfferDataSourcesPort$requestGemOfferFromFlutterHome$1(Continuation<? super GemOfferDataSourcesPort$requestGemOfferFromFlutterHome$1> continuation) {
        super(1, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new GemOfferDataSourcesPort$requestGemOfferFromFlutterHome$1(continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super GemOffer> continuation) {
        return ((GemOfferDataSourcesPort$requestGemOfferFromFlutterHome$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60477h == 0) {
            ResultKt.throwOnFailure(obj);
            return new GemOffer((String) null, (Double) null, (List) null, (List) null, (Long) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
