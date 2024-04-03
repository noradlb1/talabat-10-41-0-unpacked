package com.talabat.gem.samples;

import com.talabat.gem.domain.entities.GemOffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/talabat/gem/domain/entities/GemOffer;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.gem.samples.SampleDataSourcesAdapter$requestGemOffer$1", f = "SampleDataSources.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SampleDataSourcesAdapter$requestGemOffer$1 extends SuspendLambda implements Function1<Continuation<? super GemOffer>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60486h;

    public SampleDataSourcesAdapter$requestGemOffer$1(Continuation<? super SampleDataSourcesAdapter$requestGemOffer$1> continuation) {
        super(1, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new SampleDataSourcesAdapter$requestGemOffer$1(continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super GemOffer> continuation) {
        return ((SampleDataSourcesAdapter$requestGemOffer$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60486h == 0) {
            ResultKt.throwOnFailure(obj);
            long access$expirationTimestamp = SampleDataSourcesKt.expirationTimestamp();
            IntRange intRange = new IntRange(1, SampleDataSourcesKt.tiersCount());
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10));
            Iterator it = intRange.iterator();
            while (it.hasNext()) {
                arrayList.add(SampleDataSourcesKt.Tier(((IntIterator) it).nextInt()));
            }
            return new GemOffer("1", Boxing.boxDouble(30.0d), CollectionsKt___CollectionsKt.toList(arrayList), SampleDataSourcesKt.Restaurants(), Boxing.boxLong(access$expirationTimestamp), (String) null, (String) null, (String) null, 224, (DefaultConstructorMarker) null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
