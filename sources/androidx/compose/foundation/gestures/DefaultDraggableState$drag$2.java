package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultDraggableState$drag$2", f = "Draggable.kt", i = {}, l = {419}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultDraggableState$drag$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f1829h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DefaultDraggableState f1830i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutatePriority f1831j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<DragScope, Continuation<? super Unit>, Object> f1832k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultDraggableState$drag$2(DefaultDraggableState defaultDraggableState, MutatePriority mutatePriority, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super DefaultDraggableState$drag$2> continuation) {
        super(2, continuation);
        this.f1830i = defaultDraggableState;
        this.f1831j = mutatePriority;
        this.f1832k = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultDraggableState$drag$2(this.f1830i, this.f1831j, this.f1832k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultDraggableState$drag$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1829h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutatorMutex access$getScrollMutex$p = this.f1830i.scrollMutex;
            DragScope access$getDragScope$p = this.f1830i.dragScope;
            MutatePriority mutatePriority = this.f1831j;
            Function2<DragScope, Continuation<? super Unit>, Object> function2 = this.f1832k;
            this.f1829h = 1;
            if (access$getScrollMutex$p.mutateWith(access$getDragScope$p, mutatePriority, function2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
