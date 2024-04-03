package androidx.paging.rxjava2;

import io.reactivex.SingleSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.rx2.RxAwaitKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.rxjava2.PagingRx__RxPagingDataKt$filterAsync$1", f = "RxPagingData.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
public final class PagingRx__RxPagingDataKt$filterAsync$1 extends SuspendLambda implements Function2<T, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f37252h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1 f37253i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagingRx__RxPagingDataKt$filterAsync$1(Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f37253i = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        PagingRx__RxPagingDataKt$filterAsync$1 pagingRx__RxPagingDataKt$filterAsync$1 = new PagingRx__RxPagingDataKt$filterAsync$1(this.f37253i, continuation);
        pagingRx__RxPagingDataKt$filterAsync$1.L$0 = obj;
        return pagingRx__RxPagingDataKt$filterAsync$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PagingRx__RxPagingDataKt$filterAsync$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f37252h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            this.f37252h = 1;
            obj = RxAwaitKt.await((SingleSource) this.f37253i.invoke(obj2), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Intrinsics.checkNotNullExpressionValue(obj, "predicate(it).await()");
        return obj;
    }
}
