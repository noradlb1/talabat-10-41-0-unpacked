package androidx.paging;

import androidx.paging.PagingSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "K", "", "V", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.LegacyPageFetcher$scheduleLoad$1", f = "LegacyPageFetcher.kt", i = {0}, l = {53}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class LegacyPageFetcher$scheduleLoad$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f36615h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LegacyPageFetcher f36616i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PagingSource.LoadParams f36617j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LoadType f36618k;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "K", "", "V", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "androidx.paging.LegacyPageFetcher$scheduleLoad$1$1", f = "LegacyPageFetcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.LegacyPageFetcher$scheduleLoad$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f36619h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ LegacyPageFetcher$scheduleLoad$1 f36620i;

        {
            this.f36620i = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(this.f36620i, loadResult, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f36619h == 0) {
                ResultKt.throwOnFailure(obj);
                PagingSource.LoadResult loadResult = loadResult;
                if (loadResult instanceof PagingSource.LoadResult.Page) {
                    LegacyPageFetcher$scheduleLoad$1 legacyPageFetcher$scheduleLoad$1 = this.f36620i;
                    legacyPageFetcher$scheduleLoad$1.f36616i.onLoadSuccess(legacyPageFetcher$scheduleLoad$1.f36618k, (PagingSource.LoadResult.Page) loadResult);
                } else if (loadResult instanceof PagingSource.LoadResult.Error) {
                    LegacyPageFetcher$scheduleLoad$1 legacyPageFetcher$scheduleLoad$12 = this.f36620i;
                    legacyPageFetcher$scheduleLoad$12.f36616i.onLoadError(legacyPageFetcher$scheduleLoad$12.f36618k, ((PagingSource.LoadResult.Error) loadResult).getThrowable());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LegacyPageFetcher$scheduleLoad$1(LegacyPageFetcher legacyPageFetcher, PagingSource.LoadParams loadParams, LoadType loadType, Continuation continuation) {
        super(2, continuation);
        this.f36616i = legacyPageFetcher;
        this.f36617j = loadParams;
        this.f36618k = loadType;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        LegacyPageFetcher$scheduleLoad$1 legacyPageFetcher$scheduleLoad$1 = new LegacyPageFetcher$scheduleLoad$1(this.f36616i, this.f36617j, this.f36618k, continuation);
        legacyPageFetcher$scheduleLoad$1.L$0 = obj;
        return legacyPageFetcher$scheduleLoad$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((LegacyPageFetcher$scheduleLoad$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36615h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            PagingSource source = this.f36616i.getSource();
            PagingSource.LoadParams loadParams = this.f36617j;
            this.L$0 = coroutineScope2;
            this.f36615h = 1;
            Object load = source.load(loadParams, this);
            if (load == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
            obj = load;
        } else if (i11 == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final PagingSource.LoadResult loadResult = (PagingSource.LoadResult) obj;
        if (this.f36616i.getSource().getInvalid()) {
            this.f36616i.detach();
            return Unit.INSTANCE;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, this.f36616i.notifyDispatcher, (CoroutineStart) null, new AnonymousClass1(this, (Continuation) null), 2, (Object) null);
        return Unit.INSTANCE;
    }
}
