package com.talabat.gem.adapters.flutter.channel;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00042\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/talabat/gem/domain/entities/GemOffer;", "it", "", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "Lcom/talabat/gem/domain/entities/GemRestaurants;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.gem.adapters.flutter.channel.GemMethodChannel$handleOrganicListingData$branchIds$1", f = "GemMethodChannel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GemMethodChannel$handleOrganicListingData$branchIds$1 extends SuspendLambda implements Function2<GemOffer, Continuation<? super List<? extends GemRestaurant>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59881h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59882i;

    public GemMethodChannel$handleOrganicListingData$branchIds$1(Continuation<? super GemMethodChannel$handleOrganicListingData$branchIds$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GemMethodChannel$handleOrganicListingData$branchIds$1 gemMethodChannel$handleOrganicListingData$branchIds$1 = new GemMethodChannel$handleOrganicListingData$branchIds$1(continuation);
        gemMethodChannel$handleOrganicListingData$branchIds$1.f59882i = obj;
        return gemMethodChannel$handleOrganicListingData$branchIds$1;
    }

    @Nullable
    public final Object invoke(@NotNull GemOffer gemOffer, @Nullable Continuation<? super List<GemRestaurant>> continuation) {
        return ((GemMethodChannel$handleOrganicListingData$branchIds$1) create(gemOffer, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f59881h == 0) {
            ResultKt.throwOnFailure(obj);
            return ((GemOffer) this.f59882i).getRestaurants();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
