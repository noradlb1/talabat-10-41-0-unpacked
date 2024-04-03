package androidx.compose.ui.platform;

import android.view.ViewConfiguration;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m0.z1;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/platform/AndroidViewConfiguration;", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "Landroid/view/ViewConfiguration;", "(Landroid/view/ViewConfiguration;)V", "doubleTapMinTimeMillis", "", "getDoubleTapMinTimeMillis", "()J", "doubleTapTimeoutMillis", "getDoubleTapTimeoutMillis", "longPressTimeoutMillis", "getLongPressTimeoutMillis", "touchSlop", "", "getTouchSlop", "()F", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidViewConfiguration implements ViewConfiguration {
    public static final int $stable = 8;
    @NotNull
    private final ViewConfiguration viewConfiguration;

    public AndroidViewConfiguration(@NotNull ViewConfiguration viewConfiguration2) {
        Intrinsics.checkNotNullParameter(viewConfiguration2, "viewConfiguration");
        this.viewConfiguration = viewConfiguration2;
    }

    public long getDoubleTapMinTimeMillis() {
        return 40;
    }

    public long getDoubleTapTimeoutMillis() {
        return (long) ViewConfiguration.getDoubleTapTimeout();
    }

    public long getLongPressTimeoutMillis() {
        return (long) ViewConfiguration.getLongPressTimeout();
    }

    /* renamed from: getMinimumTouchTargetSize-MYxV2XQ  reason: not valid java name */
    public /* synthetic */ long m4821getMinimumTouchTargetSizeMYxV2XQ() {
        return z1.a(this);
    }

    public float getTouchSlop() {
        return (float) this.viewConfiguration.getScaledTouchSlop();
    }
}
