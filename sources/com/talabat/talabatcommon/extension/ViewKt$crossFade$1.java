package com.talabat.talabatcommon.extension;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/talabatcommon/extension/ViewKt$crossFade$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewKt$crossFade$1 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f46875a;

    public ViewKt$crossFade$1(View view) {
        this.f46875a = view;
    }

    public void onAnimationEnd(@NotNull Animator animator, boolean z11) {
        Intrinsics.checkNotNullParameter(animator, Param.ANIMATION);
        super.onAnimationEnd(animator, z11);
        this.f46875a.setVisibility(8);
    }
}
