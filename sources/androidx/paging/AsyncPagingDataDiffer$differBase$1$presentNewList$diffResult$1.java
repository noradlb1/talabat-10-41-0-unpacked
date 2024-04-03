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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/paging/NullPaddedDiffResult;", "T", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1", f = "AsyncPagingDataDiffer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super NullPaddedDiffResult>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36470h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AsyncPagingDataDiffer$differBase$1 f36471i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ NullPaddedList f36472j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ NullPaddedList f36473k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1(AsyncPagingDataDiffer$differBase$1 asyncPagingDataDiffer$differBase$1, NullPaddedList nullPaddedList, NullPaddedList nullPaddedList2, Continuation continuation) {
        super(2, continuation);
        this.f36471i = asyncPagingDataDiffer$differBase$1;
        this.f36472j = nullPaddedList;
        this.f36473k = nullPaddedList2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1(this.f36471i, this.f36472j, this.f36473k, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f36470h == 0) {
            ResultKt.throwOnFailure(obj);
            return NullPaddedListDiffHelperKt.computeDiff(this.f36472j, this.f36473k, this.f36471i.f36461a.diffCallback);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
