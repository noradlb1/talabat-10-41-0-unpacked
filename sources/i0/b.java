package i0;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final /* synthetic */ class b {
    public static long a(AwaitPointerEventScope awaitPointerEventScope) {
        return Size.Companion.m2754getZeroNHjbRc();
    }

    @Nullable
    public static Object b(AwaitPointerEventScope awaitPointerEventScope, long j11, @NotNull Function2 function2, @NotNull Continuation continuation) {
        return function2.invoke(awaitPointerEventScope, continuation);
    }

    @Nullable
    public static Object c(AwaitPointerEventScope awaitPointerEventScope, long j11, @NotNull Function2 function2, @NotNull Continuation continuation) {
        return function2.invoke(awaitPointerEventScope, continuation);
    }

    public static /* synthetic */ Object t(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                pointerEventPass = PointerEventPass.Main;
            }
            return awaitPointerEventScope.awaitPointerEvent(pointerEventPass, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitPointerEvent");
    }
}
