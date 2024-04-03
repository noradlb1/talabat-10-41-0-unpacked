package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource;", "Key", "Value", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.Pager$flow$2", f = "Pager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class Pager$flow$2 extends SuspendLambda implements Function1<Continuation<? super PagingSource<Key, Value>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36868h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0 f36869i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Pager$flow$2(Function0 function0, Continuation continuation) {
        super(1, continuation);
        this.f36869i = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new Pager$flow$2(this.f36869i, continuation);
    }

    public final Object invoke(Object obj) {
        return ((Pager$flow$2) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f36868h == 0) {
            ResultKt.throwOnFailure(obj);
            return this.f36869i.invoke();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
