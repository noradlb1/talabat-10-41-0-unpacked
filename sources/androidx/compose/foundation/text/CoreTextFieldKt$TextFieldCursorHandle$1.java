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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1", f = "CoreTextField.kt", i = {}, l = {1012}, m = "invokeSuspend", n = {}, s = {})
public final class CoreTextFieldKt$TextFieldCursorHandle$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f3493h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextDragObserver f3494i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$TextFieldCursorHandle$1(TextDragObserver textDragObserver, Continuation<? super CoreTextFieldKt$TextFieldCursorHandle$1> continuation) {
        super(2, continuation);
        this.f3494i = textDragObserver;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CoreTextFieldKt$TextFieldCursorHandle$1 coreTextFieldKt$TextFieldCursorHandle$1 = new CoreTextFieldKt$TextFieldCursorHandle$1(this.f3494i, continuation);
        coreTextFieldKt$TextFieldCursorHandle$1.L$0 = obj;
        return coreTextFieldKt$TextFieldCursorHandle$1;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CoreTextFieldKt$TextFieldCursorHandle$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f3493h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            TextDragObserver textDragObserver = this.f3494i;
            this.f3493h = 1;
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
