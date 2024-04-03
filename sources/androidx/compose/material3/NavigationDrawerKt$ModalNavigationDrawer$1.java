package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationDrawerKt$ModalNavigationDrawer$1 extends Lambda implements Function2<DrawerValue, DrawerValue, ThresholdConfig> {
    public static final NavigationDrawerKt$ModalNavigationDrawer$1 INSTANCE = new NavigationDrawerKt$ModalNavigationDrawer$1();

    public NavigationDrawerKt$ModalNavigationDrawer$1() {
        super(2);
    }

    @NotNull
    public final ThresholdConfig invoke(@NotNull DrawerValue drawerValue, @NotNull DrawerValue drawerValue2) {
        Intrinsics.checkNotNullParameter(drawerValue, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(drawerValue2, "<anonymous parameter 1>");
        return new FractionalThreshold(0.5f);
    }
}
