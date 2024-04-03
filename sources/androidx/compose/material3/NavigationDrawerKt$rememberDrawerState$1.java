package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationDrawerKt$rememberDrawerState$1 extends Lambda implements Function1<DrawerValue, Boolean> {
    public static final NavigationDrawerKt$rememberDrawerState$1 INSTANCE = new NavigationDrawerKt$rememberDrawerState$1();

    public NavigationDrawerKt$rememberDrawerState$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull DrawerValue drawerValue) {
        Intrinsics.checkNotNullParameter(drawerValue, "it");
        return Boolean.TRUE;
    }
}
