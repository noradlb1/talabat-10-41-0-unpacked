package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScrollableKt$pointerScrollable$1 extends Lambda implements Function1<PointerInputChange, Boolean> {
    public static final ScrollableKt$pointerScrollable$1 INSTANCE = new ScrollableKt$pointerScrollable$1();

    public ScrollableKt$pointerScrollable$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "down");
        return Boolean.valueOf(!PointerType.m4365equalsimpl0(pointerInputChange.m4309getTypeT8wyACA(), PointerType.Companion.m4370getMouseT8wyACA()));
    }
}
