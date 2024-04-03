package com.designsystem.extensions;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresPermission;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\tH\u0000¨\u0006\n"}, d2 = {"performFeedback", "", "Landroid/view/View;", "feedback", "Lcom/designsystem/extensions/HapticFeedBackType;", "performSelectionFeedback", "removeFromParent", "setBackgroundTint", "color", "", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ViewExtensionsKt {
    @RequiresPermission("android.permission.VIBRATE")
    public static final void performFeedback(@NotNull View view, @NotNull HapticFeedBackType hapticFeedBackType) {
        Vibrator vibrator;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(hapticFeedBackType, "feedback");
        Object systemService = view.getContext().getSystemService("vibrator");
        if (systemService instanceof Vibrator) {
            vibrator = (Vibrator) systemService;
        } else {
            vibrator = null;
        }
        boolean z11 = false;
        if (vibrator != null && !vibrator.hasVibrator()) {
            z11 = true;
        }
        if (!z11) {
            if (Build.VERSION.SDK_INT < 26) {
                if (vibrator != null) {
                    vibrator.vibrate((long) hapticFeedBackType.getDuration());
                }
            } else if (vibrator != null) {
                vibrator.vibrate(VibrationEffect.createOneShot((long) hapticFeedBackType.getDuration(), -1));
            }
        }
    }

    @RequiresPermission("android.permission.VIBRATE")
    public static final void performSelectionFeedback(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        performFeedback(view, HapticFeedBackType.SELECTION);
    }

    public static final void removeFromParent(@NotNull View view) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
    }

    public static final void setBackgroundTint(@NotNull View view, @ColorInt int i11) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setBackgroundTintList(ColorStateList.valueOf(i11));
    }
}
