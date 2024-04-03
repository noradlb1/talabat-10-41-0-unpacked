package com.talabat.darkstores.feature.product.views;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lj.l;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/QuantityPopAnimator;", "", "()V", "ANIMATION_DURATION", "", "ANIMATION_END_SCALE", "", "ANIMATION_START_SCALE", "animate", "", "counter", "Landroid/view/View;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QuantityPopAnimator {
    private static final long ANIMATION_DURATION = 150;
    private static final float ANIMATION_END_SCALE = 1.3f;
    private static final float ANIMATION_START_SCALE = 1.0f;
    @NotNull
    public static final QuantityPopAnimator INSTANCE = new QuantityPopAnimator();

    private QuantityPopAnimator() {
    }

    /* access modifiers changed from: private */
    /* renamed from: animate$lambda-2$lambda-1  reason: not valid java name */
    public static final void m10057animate$lambda2$lambda1(View view, ValueAnimator valueAnimator) {
        Float f11;
        Intrinsics.checkNotNullParameter(view, "$counter");
        Intrinsics.checkNotNullParameter(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Float) {
            f11 = (Float) animatedValue;
        } else {
            f11 = null;
        }
        if (f11 != null) {
            float floatValue = f11.floatValue();
            view.setScaleX(floatValue);
            view.setScaleY(floatValue);
        }
    }

    public final void animate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "counter");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, ANIMATION_END_SCALE});
        ofFloat.addUpdateListener(new l(view));
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(1);
        ofFloat.setDuration(150);
        ofFloat.start();
    }
}
