package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.DragScope;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.material.SliderDraggableState$drag$2", f = "Slider.kt", i = {}, l = {1156}, m = "invokeSuspend", n = {}, s = {})
public final class SliderDraggableState$drag$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f5072h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SliderDraggableState f5073i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutatePriority f5074j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<DragScope, Continuation<? super Unit>, Object> f5075k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderDraggableState$drag$2(SliderDraggableState sliderDraggableState, MutatePriority mutatePriority, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super SliderDraggableState$drag$2> continuation) {
        super(2, continuation);
        this.f5073i = sliderDraggableState;
        this.f5074j = mutatePriority;
        this.f5075k = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SliderDraggableState$drag$2(this.f5073i, this.f5074j, this.f5075k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SliderDraggableState$drag$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f5072h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f5073i.setDragging(true);
            MutatorMutex access$getScrollMutex$p = this.f5073i.scrollMutex;
            DragScope access$getDragScope$p = this.f5073i.dragScope;
            MutatePriority mutatePriority = this.f5074j;
            Function2<DragScope, Continuation<? super Unit>, Object> function2 = this.f5075k;
            this.f5072h = 1;
            if (access$getScrollMutex$p.mutateWith(access$getDragScope$p, mutatePriority, function2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f5073i.setDragging(false);
        return Unit.INSTANCE;
    }
}
