package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DrawerKt$rememberDrawerState$1 extends Lambda implements Function1<DrawerValue, Boolean> {
    public static final DrawerKt$rememberDrawerState$1 INSTANCE = new DrawerKt$rememberDrawerState$1();

    public DrawerKt$rememberDrawerState$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull DrawerValue drawerValue) {
        Intrinsics.checkNotNullParameter(drawerValue, "it");
        return Boolean.TRUE;
    }
}
