package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.LongPressTextDragObserverKt;
import androidx.compose.foundation.text.TextDragObserver;
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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$1", f = "TextFieldSelectionManager.kt", i = {}, l = {823}, m = "invokeSuspend", n = {}, s = {})
public final class TextFieldSelectionManagerKt$TextFieldSelectionHandle$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f3752h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextDragObserver f3753i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionManagerKt$TextFieldSelectionHandle$1(TextDragObserver textDragObserver, Continuation<? super TextFieldSelectionManagerKt$TextFieldSelectionHandle$1> continuation) {
        super(2, continuation);
        this.f3753i = textDragObserver;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TextFieldSelectionManagerKt$TextFieldSelectionHandle$1 textFieldSelectionManagerKt$TextFieldSelectionHandle$1 = new TextFieldSelectionManagerKt$TextFieldSelectionHandle$1(this.f3753i, continuation);
        textFieldSelectionManagerKt$TextFieldSelectionHandle$1.L$0 = obj;
        return textFieldSelectionManagerKt$TextFieldSelectionHandle$1;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TextFieldSelectionManagerKt$TextFieldSelectionHandle$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f3752h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            TextDragObserver textDragObserver = this.f3753i;
            this.f3752h = 1;
            if (LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver((PointerInputScope) this.L$0, textDragObserver, this) == coroutine_suspended) {
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
