package androidx.compose.material3;

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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.material3.SliderDraggableState$drag$2", f = "Slider.kt", i = {}, l = {1404}, m = "invokeSuspend", n = {}, s = {})
public final class SliderDraggableState$drag$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f7936h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SliderDraggableState f7937i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutatePriority f7938j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<DragScope, Continuation<? super Unit>, Object> f7939k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderDraggableState$drag$2(SliderDraggableState sliderDraggableState, MutatePriority mutatePriority, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super SliderDraggableState$drag$2> continuation) {
        super(2, continuation);
        this.f7937i = sliderDraggableState;
        this.f7938j = mutatePriority;
        this.f7939k = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SliderDraggableState$drag$2(this.f7937i, this.f7938j, this.f7939k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SliderDraggableState$drag$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f7936h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f7937i.setDragging(true);
            MutatorMutex access$getScrollMutex$p = this.f7937i.scrollMutex;
            DragScope access$getDragScope$p = this.f7937i.dragScope;
            MutatePriority mutatePriority = this.f7938j;
            Function2<DragScope, Continuation<? super Unit>, Object> function2 = this.f7939k;
            this.f7936h = 1;
            if (access$getScrollMutex$p.mutateWith(access$getDragScope$p, mutatePriority, function2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f7937i.setDragging(false);
        return Unit.INSTANCE;
    }
}
