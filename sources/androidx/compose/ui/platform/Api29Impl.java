package androidx.compose.ui.platform;

import android.view.accessibility.AccessibilityManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(29)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/Api29Impl;", "", "()V", "getRecommendedTimeoutMillis", "", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "originalTimeout", "uiContentFlags", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Api29Impl {
    @NotNull
    public static final Api29Impl INSTANCE = new Api29Impl();

    private Api29Impl() {
    }

    @DoNotInline
    public final int getRecommendedTimeoutMillis(@NotNull AccessibilityManager accessibilityManager, int i11, int i12) {
        Intrinsics.checkNotNullParameter(accessibilityManager, "accessibilityManager");
        return accessibilityManager.getRecommendedTimeoutMillis(i11, i12);
    }
}
