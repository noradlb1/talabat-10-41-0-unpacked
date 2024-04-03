package androidx.compose.ui.platform;

import android.content.Context;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "Landroidx/compose/ui/platform/AccessibilityManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "calculateRecommendedTimeoutMillis", "", "originalTimeoutMillis", "containsIcons", "", "containsText", "containsControls", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidAccessibilityManager implements AccessibilityManager {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int FlagContentControls = 4;
    @Deprecated
    public static final int FlagContentIcons = 1;
    @Deprecated
    public static final int FlagContentText = 2;
    @NotNull
    private final AccessibilityManager accessibilityManager;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/AndroidAccessibilityManager$Companion;", "", "()V", "FlagContentControls", "", "FlagContentIcons", "FlagContentText", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AndroidAccessibilityManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = (AccessibilityManager) systemService;
    }

    public long calculateRecommendedTimeoutMillis(long j11, boolean z11, boolean z12, boolean z13) {
        if (j11 >= 2147483647L) {
            return j11;
        }
        if (z12) {
            z11 |= true;
        }
        if (z13) {
            z11 |= true;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            int recommendedTimeoutMillis = Api29Impl.INSTANCE.getRecommendedTimeoutMillis(this.accessibilityManager, (int) j11, z11 ? 1 : 0);
            if (recommendedTimeoutMillis != Integer.MAX_VALUE) {
                return (long) recommendedTimeoutMillis;
            }
        } else if (!z13 || !this.accessibilityManager.isTouchExplorationEnabled()) {
            return j11;
        }
        return Long.MAX_VALUE;
    }
}
