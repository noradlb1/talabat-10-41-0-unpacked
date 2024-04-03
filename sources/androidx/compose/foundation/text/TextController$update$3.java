package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt;
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
@DebugMetadata(c = "androidx.compose.foundation.text.TextController$update$3", f = "CoreText.kt", i = {}, l = {282}, m = "invokeSuspend", n = {}, s = {})
public final class TextController$update$3 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f3549h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextController$update$mouseSelectionObserver$1 f3550i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextController$update$3(TextController$update$mouseSelectionObserver$1 textController$update$mouseSelectionObserver$1, Continuation<? super TextController$update$3> continuation) {
        super(2, continuation);
        this.f3550i = textController$update$mouseSelectionObserver$1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TextController$update$3 textController$update$3 = new TextController$update$3(this.f3550i, continuation);
        textController$update$3.L$0 = obj;
        return textController$update$3;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TextController$update$3) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f3549h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            TextController$update$mouseSelectionObserver$1 textController$update$mouseSelectionObserver$1 = this.f3550i;
            this.f3549h = 1;
            if (TextSelectionMouseDetectorKt.mouseSelectionDetector((PointerInputScope) this.L$0, textController$update$mouseSelectionObserver$1, this) == coroutine_suspended) {
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
