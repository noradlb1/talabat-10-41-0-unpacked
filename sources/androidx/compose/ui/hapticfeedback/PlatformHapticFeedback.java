package androidx.compose.ui.hapticfeedback;

import android.view.View;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/hapticfeedback/PlatformHapticFeedback;", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "performHapticFeedback", "", "hapticFeedbackType", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "performHapticFeedback-CdsT49E", "(I)V", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PlatformHapticFeedback implements HapticFeedback {
    @NotNull
    private final View view;

    public PlatformHapticFeedback(@NotNull View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.view = view2;
    }

    /* renamed from: performHapticFeedback-CdsT49E  reason: not valid java name */
    public void m3568performHapticFeedbackCdsT49E(int i11) {
        HapticFeedbackType.Companion companion = HapticFeedbackType.Companion;
        if (HapticFeedbackType.m3562equalsimpl0(i11, companion.m3566getLongPress5zf0vsI())) {
            this.view.performHapticFeedback(0);
        } else if (HapticFeedbackType.m3562equalsimpl0(i11, companion.m3567getTextHandleMove5zf0vsI())) {
            this.view.performHapticFeedback(9);
        }
    }
}
