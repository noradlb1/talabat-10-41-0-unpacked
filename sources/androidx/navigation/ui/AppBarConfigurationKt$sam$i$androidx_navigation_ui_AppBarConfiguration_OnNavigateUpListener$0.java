package androidx.navigation.ui;

import androidx.navigation.ui.AppBarConfiguration;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
public final class AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0 implements AppBarConfiguration.OnNavigateUpListener, FunctionAdapter {
    private final /* synthetic */ Function0 function;

    public AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(Function0 function0) {
        this.function = function0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof AppBarConfiguration.OnNavigateUpListener) || !(obj instanceof FunctionAdapter)) {
            return false;
        }
        return Intrinsics.areEqual((Object) getFunctionDelegate(), (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    @NotNull
    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final /* synthetic */ boolean onNavigateUp() {
        return ((Boolean) this.function.invoke()).booleanValue();
    }
}
