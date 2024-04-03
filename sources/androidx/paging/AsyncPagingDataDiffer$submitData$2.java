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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$submitData$2", f = "AsyncPagingDataDiffer.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
public final class AsyncPagingDataDiffer$submitData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36475h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AsyncPagingDataDiffer f36476i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f36477j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PagingData f36478k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncPagingDataDiffer$submitData$2(AsyncPagingDataDiffer asyncPagingDataDiffer, int i11, PagingData pagingData, Continuation continuation) {
        super(2, continuation);
        this.f36476i = asyncPagingDataDiffer;
        this.f36477j = i11;
        this.f36478k = pagingData;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new AsyncPagingDataDiffer$submitData$2(this.f36476i, this.f36477j, this.f36478k, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AsyncPagingDataDiffer$submitData$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36475h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f36476i.submitDataId.get() == this.f36477j) {
                AsyncPagingDataDiffer$differBase$1 access$getDifferBase$p = this.f36476i.differBase;
                PagingData pagingData = this.f36478k;
                this.f36475h = 1;
                if (access$getDifferBase$p.collectFrom(pagingData, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
