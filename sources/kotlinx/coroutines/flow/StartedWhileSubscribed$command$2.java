package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/SharingCommand;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", f = "SharingStarted.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class StartedWhileSubscribed$command$2 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f26057h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f26058i;

    public StartedWhileSubscribed$command$2(Continuation<? super StartedWhileSubscribed$command$2> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        StartedWhileSubscribed$command$2 startedWhileSubscribed$command$2 = new StartedWhileSubscribed$command$2(continuation);
        startedWhileSubscribed$command$2.f26058i = obj;
        return startedWhileSubscribed$command$2;
    }

    @Nullable
    public final Object invoke(@NotNull SharingCommand sharingCommand, @Nullable Continuation<? super Boolean> continuation) {
        return ((StartedWhileSubscribed$command$2) create(sharingCommand, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z11;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f26057h == 0) {
            ResultKt.throwOnFailure(obj);
            if (((SharingCommand) this.f26058i) != SharingCommand.START) {
                z11 = true;
            } else {
                z11 = false;
            }
            return Boxing.boxBoolean(z11);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
