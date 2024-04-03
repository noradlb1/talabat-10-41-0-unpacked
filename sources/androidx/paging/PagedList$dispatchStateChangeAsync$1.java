package androidx.paging;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PagedList$dispatchStateChangeAsync$1", f = "PagedList.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PagedList$dispatchStateChangeAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36857h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PagedList f36858i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LoadType f36859j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LoadState f36860k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagedList$dispatchStateChangeAsync$1(PagedList pagedList, LoadType loadType, LoadState loadState, Continuation continuation) {
        super(2, continuation);
        this.f36858i = pagedList;
        this.f36859j = loadType;
        this.f36860k = loadState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new PagedList$dispatchStateChangeAsync$1(this.f36858i, this.f36859j, this.f36860k, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PagedList$dispatchStateChangeAsync$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f36857h == 0) {
            ResultKt.throwOnFailure(obj);
            boolean unused2 = CollectionsKt__MutableCollectionsKt.removeAll(this.f36858i.loadStateListeners, AnonymousClass1.INSTANCE);
            for (WeakReference weakReference : this.f36858i.loadStateListeners) {
                Function2 function2 = (Function2) weakReference.get();
                if (function2 != null) {
                    Unit unit = (Unit) function2.invoke(this.f36859j, this.f36860k);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
