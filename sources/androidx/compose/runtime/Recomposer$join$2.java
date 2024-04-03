package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$join$2", f = "Recomposer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class Recomposer$join$2 extends SuspendLambda implements Function2<Recomposer.State, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f9161h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f9162i;

    public Recomposer$join$2(Continuation<? super Recomposer$join$2> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Recomposer$join$2 recomposer$join$2 = new Recomposer$join$2(continuation);
        recomposer$join$2.f9162i = obj;
        return recomposer$join$2;
    }

    @Nullable
    public final Object invoke(@NotNull Recomposer.State state, @Nullable Continuation<? super Boolean> continuation) {
        return ((Recomposer$join$2) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z11;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f9161h == 0) {
            ResultKt.throwOnFailure(obj);
            if (((Recomposer.State) this.f9162i) == Recomposer.State.ShutDown) {
                z11 = true;
            } else {
                z11 = false;
            }
            return Boxing.boxBoolean(z11);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
