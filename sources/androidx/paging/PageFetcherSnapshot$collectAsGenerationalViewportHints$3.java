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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroidx/paging/GenerationalViewportHint;", "Key", "", "Value", "previous", "next", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$3", f = "PageFetcherSnapshot.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PageFetcherSnapshot$collectAsGenerationalViewportHints$3 extends SuspendLambda implements Function3<GenerationalViewportHint, GenerationalViewportHint, Continuation<? super GenerationalViewportHint>, Object> {
    private /* synthetic */ Object L$0;
    private /* synthetic */ Object L$1;

    /* renamed from: h  reason: collision with root package name */
    public int f36771h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LoadType f36772i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$collectAsGenerationalViewportHints$3(LoadType loadType, Continuation continuation) {
        super(3, continuation);
        this.f36772i = loadType;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull GenerationalViewportHint generationalViewportHint, @NotNull GenerationalViewportHint generationalViewportHint2, @NotNull Continuation<? super GenerationalViewportHint> continuation) {
        Intrinsics.checkNotNullParameter(generationalViewportHint, "previous");
        Intrinsics.checkNotNullParameter(generationalViewportHint2, "next");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        PageFetcherSnapshot$collectAsGenerationalViewportHints$3 pageFetcherSnapshot$collectAsGenerationalViewportHints$3 = new PageFetcherSnapshot$collectAsGenerationalViewportHints$3(this.f36772i, continuation);
        pageFetcherSnapshot$collectAsGenerationalViewportHints$3.L$0 = generationalViewportHint;
        pageFetcherSnapshot$collectAsGenerationalViewportHints$3.L$1 = generationalViewportHint2;
        return pageFetcherSnapshot$collectAsGenerationalViewportHints$3;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((PageFetcherSnapshot$collectAsGenerationalViewportHints$3) create((GenerationalViewportHint) obj, (GenerationalViewportHint) obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f36771h == 0) {
            ResultKt.throwOnFailure(obj);
            GenerationalViewportHint generationalViewportHint = (GenerationalViewportHint) this.L$0;
            GenerationalViewportHint generationalViewportHint2 = (GenerationalViewportHint) this.L$1;
            if (PageFetcherSnapshotKt.shouldPrioritizeOver(generationalViewportHint2, generationalViewportHint, this.f36772i)) {
                return generationalViewportHint2;
            }
            return generationalViewportHint;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
