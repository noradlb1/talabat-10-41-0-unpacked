package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class InterruptibleKt$runInterruptible$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f25128h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<T> f25129i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InterruptibleKt$runInterruptible$2(Function0<? extends T> function0, Continuation<? super InterruptibleKt$runInterruptible$2> continuation) {
        super(2, continuation);
        this.f25129i = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(this.f25129i, continuation);
        interruptibleKt$runInterruptible$2.L$0 = obj;
        return interruptibleKt$runInterruptible$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super T> continuation) {
        return ((InterruptibleKt$runInterruptible$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f25128h == 0) {
            ResultKt.throwOnFailure(obj);
            return InterruptibleKt.runInterruptibleInExpectedContext(((CoroutineScope) this.L$0).getCoroutineContext(), this.f25129i);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
