package com.designsystem.animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.annotation.AnimRes;
import com.designsystem.extensions.AnimationExtensionsKt;
import com.designsystem.extensions.IntExtensionsKt;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJD\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0011\u001a\u00020\t2\b\b\u0001\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u0013"}, d2 = {"Lcom/designsystem/animation/CountAnimation;", "", "()V", "setAnimatedCount", "", "labelAnimOut", "Landroid/widget/TextView;", "labelAnimIn", "previousCount", "", "newCount", "context", "Landroid/content/Context;", "startSlideAnimation", "previousCountString", "", "newCountString", "animInRes", "animOutRes", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CountAnimation {
    @NotNull
    public static final CountAnimation INSTANCE = new CountAnimation();

    private CountAnimation() {
    }

    private final void startSlideAnimation(TextView textView, TextView textView2, String str, String str2, @AnimRes int i11, @AnimRes int i12, Context context) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, i11);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, i12);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "animationIn");
        AnimationExtensionsKt.onAnimation$default(loadAnimation, new CountAnimation$startSlideAnimation$1(textView, str, textView2, str2), new CountAnimation$startSlideAnimation$2(textView), (Function0) null, 4, (Object) null);
        textView2.startAnimation(loadAnimation);
        textView.startAnimation(loadAnimation2);
    }

    public final void setAnimatedCount(@NotNull TextView textView, @NotNull TextView textView2, int i11, int i12, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(textView, "labelAnimOut");
        Intrinsics.checkNotNullParameter(textView2, "labelAnimIn");
        Intrinsics.checkNotNullParameter(context, "context");
        String countString$default = IntExtensionsKt.toCountString$default(i11, 0, 1, (Object) null);
        String countString$default2 = IntExtensionsKt.toCountString$default(i12, 0, 1, (Object) null);
        if (Intrinsics.areEqual((Object) countString$default, (Object) countString$default2)) {
            textView2.setText(countString$default2);
        } else if (i11 < i12) {
            startSlideAnimation(textView, textView2, countString$default, countString$default2, R.anim.slide_in_from_bottom, R.anim.slide_out_to_top, context);
        } else {
            startSlideAnimation(textView, textView2, countString$default, countString$default2, R.anim.slide_in_from_top, R.anim.slide_out_to_bottom, context);
        }
    }
}
