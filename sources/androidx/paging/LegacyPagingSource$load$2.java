package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PagingSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource$LoadResult$Page;", "Key", "Value", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.LegacyPagingSource$load$2", f = "LegacyPagingSource.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
public final class LegacyPagingSource$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PagingSource.LoadResult.Page<Key, Value>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36625h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LegacyPagingSource f36626i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f36627j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PagingSource.LoadParams f36628k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LegacyPagingSource$load$2(LegacyPagingSource legacyPagingSource, Ref.ObjectRef objectRef, PagingSource.LoadParams loadParams, Continuation continuation) {
        super(2, continuation);
        this.f36626i = legacyPagingSource;
        this.f36627j = objectRef;
        this.f36628k = loadParams;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new LegacyPagingSource$load$2(this.f36626i, this.f36627j, this.f36628k, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((LegacyPagingSource$load$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36625h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f36625h = 1;
            obj = this.f36626i.getDataSource$paging_common().load$paging_common((DataSource.Params) this.f36627j.element, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DataSource.BaseResult baseResult = (DataSource.BaseResult) obj;
        List<Value> list = baseResult.data;
        if (!list.isEmpty() || !(this.f36628k instanceof PagingSource.LoadParams.Prepend)) {
            obj2 = baseResult.getPrevKey();
        } else {
            obj2 = null;
        }
        if (!baseResult.data.isEmpty() || !(this.f36628k instanceof PagingSource.LoadParams.Append)) {
            obj3 = baseResult.getNextKey();
        } else {
            obj3 = null;
        }
        return new PagingSource.LoadResult.Page(list, obj2, obj3, baseResult.getItemsBefore(), baseResult.getItemsAfter());
    }
}
