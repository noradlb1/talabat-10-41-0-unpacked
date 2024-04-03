package androidx.compose.foundation.text;

import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.text.TextController$update$2", f = "CoreText.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
public final class TextController$update$2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f3547h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextController f3548i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextController$update$2(TextController textController, Continuation<? super TextController$update$2> continuation) {
        super(2, continuation);
        this.f3548i = textController;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TextController$update$2 textController$update$2 = new TextController$update$2(this.f3548i, continuation);
        textController$update$2.L$0 = obj;
        return textController$update$2;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TextController$update$2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f3547h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            TextDragObserver longPressDragObserver = this.f3548i.getLongPressDragObserver();
            this.f3547h = 1;
            if (LongPressTextDragObserverKt.detectDragGesturesAfterLongPressWithObserver((PointerInputScope) this.L$0, longPressDragObserver, this) == coroutine_suspended) {
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
