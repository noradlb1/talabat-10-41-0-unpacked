package androidx.paging;

import androidx.paging.PageFetcherSnapshotState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$2", f = "PageFetcherSnapshot.kt", i = {0, 0}, l = {595, 218}, m = "invokeSuspend", n = {"this_$iv", "$this$withLock$iv$iv"}, s = {"L$0", "L$1"})
public final class PageFetcherSnapshot$startConsumingHints$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f36824h;

    /* renamed from: i  reason: collision with root package name */
    public Object f36825i;

    /* renamed from: j  reason: collision with root package name */
    public Object f36826j;

    /* renamed from: k  reason: collision with root package name */
    public int f36827k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshot f36828l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$startConsumingHints$2(PageFetcherSnapshot pageFetcherSnapshot, Continuation continuation) {
        super(2, continuation);
        this.f36828l = pageFetcherSnapshot;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new PageFetcherSnapshot$startConsumingHints$2(this.f36828l, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PageFetcherSnapshot$startConsumingHints$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PageFetcherSnapshotState.Holder holder;
        Mutex mutex;
        PageFetcherSnapshot pageFetcherSnapshot;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36827k;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            pageFetcherSnapshot = this.f36828l;
            holder = pageFetcherSnapshot.stateHolder;
            Mutex access$getLock$p = holder.lock;
            this.f36824h = holder;
            this.f36825i = access$getLock$p;
            this.f36826j = pageFetcherSnapshot;
            this.f36827k = 1;
            if (access$getLock$p.lock((Object) null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = access$getLock$p;
        } else if (i11 == 1) {
            pageFetcherSnapshot = (PageFetcherSnapshot) this.f36826j;
            mutex = (Mutex) this.f36825i;
            holder = (PageFetcherSnapshotState.Holder) this.f36824h;
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            Flow<Integer> consumePrependGenerationIdAsFlow = holder.state.consumePrependGenerationIdAsFlow();
            mutex.unlock((Object) null);
            LoadType loadType = LoadType.PREPEND;
            this.f36824h = null;
            this.f36825i = null;
            this.f36826j = null;
            this.f36827k = 2;
            if (pageFetcherSnapshot.a(consumePrependGenerationIdAsFlow, loadType, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            mutex.unlock((Object) null);
            throw th2;
        }
    }
}
