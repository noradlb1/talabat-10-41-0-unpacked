package com.afollestad.materialdialogs.bottomsheets;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/afollestad/materialdialogs/bottomsheets/UtilKt$animateValues$2$1"}, k = 3, mv = {1, 1, 15})
public final class UtilKt$animateValues$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f40376a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f40377b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function0 f40378c;

    public UtilKt$animateValues$$inlined$apply$lambda$1(long j11, Function1 function1, Function0 function0) {
        this.f40376a = j11;
        this.f40377b = function1;
        this.f40378c = function0;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Function1 function1 = this.f40377b;
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            function1.invoke((Integer) animatedValue);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
