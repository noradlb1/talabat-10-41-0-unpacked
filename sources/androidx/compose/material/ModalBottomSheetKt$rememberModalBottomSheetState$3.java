package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ModalBottomSheetKt$rememberModalBottomSheetState$3 extends Lambda implements Function1<ModalBottomSheetValue, Boolean> {
    public static final ModalBottomSheetKt$rememberModalBottomSheetState$3 INSTANCE = new ModalBottomSheetKt$rememberModalBottomSheetState$3();

    public ModalBottomSheetKt$rememberModalBottomSheetState$3() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull ModalBottomSheetValue modalBottomSheetValue) {
        Intrinsics.checkNotNullParameter(modalBottomSheetValue, "it");
        return Boolean.TRUE;
    }
}
