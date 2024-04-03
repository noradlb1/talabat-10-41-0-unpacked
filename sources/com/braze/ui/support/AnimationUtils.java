package com.braze.ui.support;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a&\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"accelerateInterpolator", "Landroid/view/animation/Interpolator;", "decelerateInterpolator", "createHorizontalAnimation", "Landroid/view/animation/Animation;", "fromX", "", "toX", "duration", "", "accelerate", "", "createVerticalAnimation", "fromY", "toY", "setAnimationParams", "animation", "android-sdk-ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "AnimationUtils")
public final class AnimationUtils {
    @NotNull
    private static final Interpolator accelerateInterpolator = new AccelerateInterpolator();
    @NotNull
    private static final Interpolator decelerateInterpolator = new DecelerateInterpolator();

    @NotNull
    public static final Animation createHorizontalAnimation(float f11, float f12, long j11, boolean z11) {
        return setAnimationParams(new TranslateAnimation(1, f11, 1, f12, 2, 0.0f, 2, 0.0f), j11, z11);
    }

    @NotNull
    public static final Animation createVerticalAnimation(float f11, float f12, long j11, boolean z11) {
        return setAnimationParams(new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, f11, 1, f12), j11, z11);
    }

    @NotNull
    public static final Animation setAnimationParams(@NotNull Animation animation, long j11, boolean z11) {
        Intrinsics.checkNotNullParameter(animation, Param.ANIMATION);
        animation.setDuration(j11);
        if (z11) {
            animation.setInterpolator(accelerateInterpolator);
        } else {
            animation.setInterpolator(decelerateInterpolator);
        }
        return animation;
    }
}
