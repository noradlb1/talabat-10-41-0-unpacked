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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0001H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "T", "", "before", "<anonymous parameter 1>", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PagingDataTransforms$insertHeaderItem$1", f = "PagingDataTransforms.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PagingDataTransforms$insertHeaderItem$1 extends SuspendLambda implements Function3<T, T, Continuation<? super T>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f37038h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f37039i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagingDataTransforms$insertHeaderItem$1(Object obj, Continuation continuation) {
        super(3, continuation);
        this.f37039i = obj;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable T t11, @Nullable T t12, @NotNull Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        PagingDataTransforms$insertHeaderItem$1 pagingDataTransforms$insertHeaderItem$1 = new PagingDataTransforms$insertHeaderItem$1(this.f37039i, continuation);
        pagingDataTransforms$insertHeaderItem$1.L$0 = t11;
        return pagingDataTransforms$insertHeaderItem$1;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((PagingDataTransforms$insertHeaderItem$1) create(obj, obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f37038h == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.L$0 == null) {
                return this.f37039i;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
