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
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$3", f = "PageFetcherSnapshot.kt", i = {0, 0}, l = {595, 223}, m = "invokeSuspend", n = {"this_$iv", "$this$withLock$iv$iv"}, s = {"L$0", "L$1"})
public final class PageFetcherSnapshot$startConsumingHints$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f36829h;

    /* renamed from: i  reason: collision with root package name */
    public Object f36830i;

    /* renamed from: j  reason: collision with root package name */
    public Object f36831j;

    /* renamed from: k  reason: collision with root package name */
    public int f36832k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshot f36833l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$startConsumingHints$3(PageFetcherSnapshot pageFetcherSnapshot, Continuation continuation) {
        super(2, continuation);
        this.f36833l = pageFetcherSnapshot;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new PageFetcherSnapshot$startConsumingHints$3(this.f36833l, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PageFetcherSnapshot$startConsumingHints$3) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PageFetcherSnapshotState.Holder holder;
        Mutex mutex;
        PageFetcherSnapshot pageFetcherSnapshot;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36832k;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            pageFetcherSnapshot = this.f36833l;
            holder = pageFetcherSnapshot.stateHolder;
            Mutex access$getLock$p = holder.lock;
            this.f36829h = holder;
            this.f36830i = access$getLock$p;
            this.f36831j = pageFetcherSnapshot;
            this.f36832k = 1;
            if (access$getLock$p.lock((Object) null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = access$getLock$p;
        } else if (i11 == 1) {
            pageFetcherSnapshot = (PageFetcherSnapshot) this.f36831j;
            mutex = (Mutex) this.f36830i;
            holder = (PageFetcherSnapshotState.Holder) this.f36829h;
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            Flow<Integer> consumeAppendGenerationIdAsFlow = holder.state.consumeAppendGenerationIdAsFlow();
            mutex.unlock((Object) null);
            LoadType loadType = LoadType.APPEND;
            this.f36829h = null;
            this.f36830i = null;
            this.f36831j = null;
            this.f36832k = 2;
            if (pageFetcherSnapshot.a(consumeAppendGenerationIdAsFlow, loadType, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            mutex.unlock((Object) null);
            throw th2;
        }
    }
}
