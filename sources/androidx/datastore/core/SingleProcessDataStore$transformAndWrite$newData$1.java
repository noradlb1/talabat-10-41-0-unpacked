package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1", f = "SingleProcessDataStore.kt", i = {}, l = {402}, m = "invokeSuspend", n = {}, s = {})
public final class SingleProcessDataStore$transformAndWrite$newData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f35696h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<T, Continuation<? super T>, Object> f35697i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ T f35698j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$transformAndWrite$newData$1(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, T t11, Continuation<? super SingleProcessDataStore$transformAndWrite$newData$1> continuation) {
        super(2, continuation);
        this.f35697i = function2;
        this.f35698j = t11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SingleProcessDataStore$transformAndWrite$newData$1(this.f35697i, this.f35698j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super T> continuation) {
        return ((SingleProcessDataStore$transformAndWrite$newData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f35696h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<T, Continuation<? super T>, Object> function2 = this.f35697i;
            T t11 = this.f35698j;
            this.f35696h = 1;
            obj = function2.invoke(t11, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
