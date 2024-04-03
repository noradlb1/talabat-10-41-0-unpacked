package coil.memory;

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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "coil.memory.ViewTargetRequestManager$clearCurrentRequest$1", f = "ViewTargetRequestManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ViewTargetRequestManager$clearCurrentRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f39784h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ViewTargetRequestManager f39785i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewTargetRequestManager$clearCurrentRequest$1(ViewTargetRequestManager viewTargetRequestManager, Continuation<? super ViewTargetRequestManager$clearCurrentRequest$1> continuation) {
        super(2, continuation);
        this.f39785i = viewTargetRequestManager;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ViewTargetRequestManager$clearCurrentRequest$1(this.f39785i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ViewTargetRequestManager$clearCurrentRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f39784h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f39785i.setCurrentRequest((ViewTargetRequestDelegate) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
