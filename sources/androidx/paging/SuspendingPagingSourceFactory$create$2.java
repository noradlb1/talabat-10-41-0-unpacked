package androidx.paging;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource;", "Key", "Value", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.SuspendingPagingSourceFactory$create$2", f = "SuspendingPagingSourceFactory.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SuspendingPagingSourceFactory$create$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PagingSource<Key, Value>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f37168h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SuspendingPagingSourceFactory f37169i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuspendingPagingSourceFactory$create$2(SuspendingPagingSourceFactory suspendingPagingSourceFactory, Continuation continuation) {
        super(2, continuation);
        this.f37169i = suspendingPagingSourceFactory;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SuspendingPagingSourceFactory$create$2(this.f37169i, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SuspendingPagingSourceFactory$create$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f37168h == 0) {
            ResultKt.throwOnFailure(obj);
            return this.f37169i.delegate.invoke();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
