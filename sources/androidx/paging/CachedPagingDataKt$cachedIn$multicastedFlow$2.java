package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Landroidx/paging/MulticastedPagingData;", "T", "", "prev", "next", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.CachedPagingDataKt$cachedIn$multicastedFlow$2", f = "CachedPagingData.kt", i = {0}, l = {93}, m = "invokeSuspend", n = {"next"}, s = {"L$0"})
public final class CachedPagingDataKt$cachedIn$multicastedFlow$2 extends SuspendLambda implements Function3<MulticastedPagingData<T>, MulticastedPagingData<T>, Continuation<? super MulticastedPagingData<T>>, Object> {
    private /* synthetic */ Object L$0;
    private /* synthetic */ Object L$1;

    /* renamed from: h  reason: collision with root package name */
    public int f36518h;

    public CachedPagingDataKt$cachedIn$multicastedFlow$2(Continuation continuation) {
        super(3, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull MulticastedPagingData<T> multicastedPagingData, @NotNull MulticastedPagingData<T> multicastedPagingData2, @NotNull Continuation<? super MulticastedPagingData<T>> continuation) {
        Intrinsics.checkNotNullParameter(multicastedPagingData, "prev");
        Intrinsics.checkNotNullParameter(multicastedPagingData2, "next");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        CachedPagingDataKt$cachedIn$multicastedFlow$2 cachedPagingDataKt$cachedIn$multicastedFlow$2 = new CachedPagingDataKt$cachedIn$multicastedFlow$2(continuation);
        cachedPagingDataKt$cachedIn$multicastedFlow$2.L$0 = multicastedPagingData;
        cachedPagingDataKt$cachedIn$multicastedFlow$2.L$1 = multicastedPagingData2;
        return cachedPagingDataKt$cachedIn$multicastedFlow$2;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((CachedPagingDataKt$cachedIn$multicastedFlow$2) create((MulticastedPagingData) obj, (MulticastedPagingData) obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36518h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MulticastedPagingData multicastedPagingData = (MulticastedPagingData) this.L$1;
            this.L$0 = multicastedPagingData;
            this.f36518h = 1;
            if (((MulticastedPagingData) this.L$0).close(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return multicastedPagingData;
        } else if (i11 == 1) {
            MulticastedPagingData multicastedPagingData2 = (MulticastedPagingData) this.L$0;
            ResultKt.throwOnFailure(obj);
            return multicastedPagingData2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
