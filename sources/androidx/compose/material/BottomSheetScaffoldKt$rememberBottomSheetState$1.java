package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BottomSheetScaffoldKt$rememberBottomSheetState$1 extends Lambda implements Function1<BottomSheetValue, Boolean> {
    public static final BottomSheetScaffoldKt$rememberBottomSheetState$1 INSTANCE = new BottomSheetScaffoldKt$rememberBottomSheetState$1();

    public BottomSheetScaffoldKt$rememberBottomSheetState$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull BottomSheetValue bottomSheetValue) {
        Intrinsics.checkNotNullParameter(bottomSheetValue, "it");
        return Boolean.TRUE;
    }
}
