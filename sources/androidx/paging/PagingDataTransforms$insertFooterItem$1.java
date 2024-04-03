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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0001H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "T", "", "<anonymous parameter 0>", "after", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PagingDataTransforms$insertFooterItem$1", f = "PagingDataTransforms.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PagingDataTransforms$insertFooterItem$1 extends SuspendLambda implements Function3<T, T, Continuation<? super T>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f37036h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f37037i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagingDataTransforms$insertFooterItem$1(Object obj, Continuation continuation) {
        super(3, continuation);
        this.f37037i = obj;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable T t11, @Nullable T t12, @NotNull Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        PagingDataTransforms$insertFooterItem$1 pagingDataTransforms$insertFooterItem$1 = new PagingDataTransforms$insertFooterItem$1(this.f37037i, continuation);
        pagingDataTransforms$insertFooterItem$1.L$0 = t12;
        return pagingDataTransforms$insertFooterItem$1;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((PagingDataTransforms$insertFooterItem$1) create(obj, obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f37036h == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.L$0 == null) {
                return this.f37037i;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
