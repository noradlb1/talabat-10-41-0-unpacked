package com.braze.ui.support;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;
import com.braze.enums.inappmessage.Orientation;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005\u001a\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\u001a\u000e\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\u001a\u000e\u0010\r\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\u001a\u000e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\u001a\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017\u001a\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0001\u001a\n\u0010\u001b\u001a\u00020\u0010*\u00020\u001c\u001a\f\u0010\u001d\u001a\u00020\u0019*\u0004\u0018\u00010\u0017\u001a\u0012\u0010\u001e\u001a\u00020\u0019*\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0001\u001a\n\u0010 \u001a\u00020\u0019*\u00020\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"TABLET_SMALLEST_WIDTH_DP", "", "TAG", "", "convertDpToPixels", "", "context", "Landroid/content/Context;", "valueInDp", "getMaxSafeBottomInset", "windowInsets", "Landroidx/core/view/WindowInsetsCompat;", "getMaxSafeLeftInset", "getMaxSafeRightInset", "getMaxSafeTopInset", "isCurrentOrientationValid", "", "currentScreenOrientation", "preferredOrientation", "Lcom/braze/enums/inappmessage/Orientation;", "isDeviceInNightMode", "isDeviceNotInTouchMode", "view", "Landroid/view/View;", "setHeightOnViewLayoutParams", "", "height", "isRunningOnTablet", "Landroid/app/Activity;", "removeViewFromParent", "setActivityRequestedOrientation", "requestedOrientation", "setFocusableInTouchModeAndRequestFocus", "android-sdk-ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "ViewUtils")
public final class ViewUtils {
    private static final int TABLET_SMALLEST_WIDTH_DP = 600;
    @NotNull
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("ViewUtils");

    public static final double convertDpToPixels(@NotNull Context context, double d11) {
        Intrinsics.checkNotNullParameter(context, "context");
        return d11 * ((double) context.getResources().getDisplayMetrics().density);
    }

    public static final int getMaxSafeBottomInset(@NotNull WindowInsetsCompat windowInsetsCompat) {
        int i11;
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        DisplayCutoutCompat displayCutout = windowInsetsCompat.getDisplayCutout();
        if (displayCutout == null) {
            i11 = 0;
        } else {
            i11 = displayCutout.getSafeInsetBottom();
        }
        return Math.max(i11, windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
    }

    public static final int getMaxSafeLeftInset(@NotNull WindowInsetsCompat windowInsetsCompat) {
        int i11;
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        DisplayCutoutCompat displayCutout = windowInsetsCompat.getDisplayCutout();
        if (displayCutout == null) {
            i11 = 0;
        } else {
            i11 = displayCutout.getSafeInsetLeft();
        }
        return Math.max(i11, windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).left);
    }

    public static final int getMaxSafeRightInset(@NotNull WindowInsetsCompat windowInsetsCompat) {
        int i11;
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        DisplayCutoutCompat displayCutout = windowInsetsCompat.getDisplayCutout();
        if (displayCutout == null) {
            i11 = 0;
        } else {
            i11 = displayCutout.getSafeInsetRight();
        }
        return Math.max(i11, windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).right);
    }

    public static final int getMaxSafeTopInset(@NotNull WindowInsetsCompat windowInsetsCompat) {
        int i11;
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        DisplayCutoutCompat displayCutout = windowInsetsCompat.getDisplayCutout();
        if (displayCutout == null) {
            i11 = 0;
        } else {
            i11 = displayCutout.getSafeInsetTop();
        }
        return Math.max(i11, windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).top);
    }

    public static final boolean isCurrentOrientationValid(int i11, @NotNull Orientation orientation) {
        int i12 = i11;
        Orientation orientation2 = orientation;
        Intrinsics.checkNotNullParameter(orientation2, "preferredOrientation");
        if (i12 == 2 && orientation2 == Orientation.LANDSCAPE) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) null, false, (Function0) ViewUtils$isCurrentOrientationValid$1.INSTANCE, 12, (Object) null);
            return true;
        } else if (i12 == 1 && orientation2 == Orientation.PORTRAIT) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) null, false, (Function0) ViewUtils$isCurrentOrientationValid$2.INSTANCE, 12, (Object) null);
            return true;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) null, false, (Function0) new ViewUtils$isCurrentOrientationValid$3(i12, orientation2), 12, (Object) null);
            return false;
        }
    }

    public static final boolean isDeviceInNightMode(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    public static final boolean isDeviceNotInTouchMode(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return !view.isInTouchMode();
    }

    public static final boolean isRunningOnTablet(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        if (activity.getResources().getConfiguration().smallestScreenWidthDp >= 600) {
            return true;
        }
        return false;
    }

    public static final void removeViewFromParent(@Nullable View view) {
        ViewParent viewParent;
        if (view == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) null, false, (Function0) ViewUtils$removeViewFromParent$1.INSTANCE, 12, (Object) null);
        }
        if (view == null) {
            viewParent = null;
        } else {
            viewParent = view.getParent();
        }
        if (viewParent instanceof ViewGroup) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeView(view);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) null, false, (Function0) new ViewUtils$removeViewFromParent$2(view, viewGroup), 12, (Object) null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public static final void setActivityRequestedOrientation(@NotNull Activity activity, int i11) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        try {
            activity.setRequestedOrientation(i11);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new ViewUtils$setActivityRequestedOrientation$1(i11, activity), 8, (Object) null);
        }
    }

    public static final void setFocusableInTouchModeAndRequestFocus(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        try {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) ViewUtils$setFocusableInTouchModeAndRequestFocus$1.INSTANCE, 8, (Object) null);
        }
    }

    public static final void setHeightOnViewLayoutParams(@NotNull View view, int i11) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i11;
        view.setLayoutParams(layoutParams);
    }
}
