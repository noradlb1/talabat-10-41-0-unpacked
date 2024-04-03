package com.afollestad.materialdialogs.bottomsheets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/afollestad/materialdialogs/bottomsheets/UtilKt$animateValues$2$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "com.afollestad.material-dialogs.bottomsheets"}, k = 1, mv = {1, 1, 15})
public final class UtilKt$animateValues$$inlined$apply$lambda$2 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f40379a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f40380b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function0 f40381c;

    public UtilKt$animateValues$$inlined$apply$lambda$2(long j11, Function1 function1, Function0 function0) {
        this.f40379a = j11;
        this.f40380b = function1;
        this.f40381c = function0;
    }

    public void onAnimationEnd(@NotNull Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, Param.ANIMATION);
        this.f40381c.invoke();
    }
}
