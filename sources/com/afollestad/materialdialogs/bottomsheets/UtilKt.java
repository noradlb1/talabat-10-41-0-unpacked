package com.afollestad.materialdialogs.bottomsheets;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.CheckResult;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0001\u001aB\u0010\u000f\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0000\u001a4\u0010\u0015\u001a\u00020\f\"\b\b\u0000\u0010\u0016*\u00020\u0012*\u0002H\u00162\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\b\u0018H\u0000¢\u0006\u0002\u0010\u0019\u001aA\u0010\u001a\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\u00102!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\f0\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0000¨\u0006\u001e"}, d2 = {"animateValues", "Landroid/animation/Animator;", "from", "", "to", "duration", "", "onUpdate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "currentValue", "", "onEnd", "Lkotlin/Function0;", "animatePeekHeight", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "view", "Landroid/view/View;", "start", "dest", "onDetach", "T", "onAttached", "Lkotlin/ExtensionFunctionType;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "setCallbacks", "onSlide", "currentHeight", "onHide", "com.afollestad.material-dialogs.bottomsheets"}, k = 2, mv = {1, 1, 15})
public final class UtilKt {
    public static final void animatePeekHeight(@NotNull BottomSheetBehavior<?> bottomSheetBehavior, @NotNull View view, int i11, int i12, long j11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(bottomSheetBehavior, "$this$animatePeekHeight");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(function0, "onEnd");
        if (i12 != i11) {
            if (j11 <= 0) {
                bottomSheetBehavior.setPeekHeight(i12);
                return;
            }
            Animator animateValues = animateValues(i11, i12, j11, new UtilKt$animatePeekHeight$animator$1(bottomSheetBehavior), function0);
            onDetach(view, new UtilKt$animatePeekHeight$2(animateValues));
            animateValues.start();
        }
    }

    public static /* synthetic */ void animatePeekHeight$default(BottomSheetBehavior bottomSheetBehavior, View view, int i11, int i12, long j11, Function0 function0, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = bottomSheetBehavior.getPeekHeight();
        }
        int i14 = i11;
        if ((i13 & 16) != 0) {
            function0 = UtilKt$animatePeekHeight$1.INSTANCE;
        }
        animatePeekHeight(bottomSheetBehavior, view, i14, i12, j11, function0);
    }

    @CheckResult
    @NotNull
    public static final Animator animateValues(int i11, int i12, long j11, @NotNull Function1<? super Integer, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function1, "onUpdate");
        Intrinsics.checkParameterIsNotNull(function0, "onEnd");
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        Intrinsics.checkExpressionValueIsNotNull(ofInt, "this");
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(j11);
        ofInt.addUpdateListener(new UtilKt$animateValues$$inlined$apply$lambda$1(j11, function1, function0));
        ofInt.addListener(new UtilKt$animateValues$$inlined$apply$lambda$2(j11, function1, function0));
        Intrinsics.checkExpressionValueIsNotNull(ofInt, "ValueAnimator.ofInt(from…nEnd()\n        })\n      }");
        return ofInt;
    }

    public static /* synthetic */ Animator animateValues$default(int i11, int i12, long j11, Function1 function1, Function0 function0, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            function0 = UtilKt$animateValues$1.INSTANCE;
        }
        return animateValues(i11, i12, j11, function1, function0);
    }

    public static final <T extends View> void onDetach(@NotNull T t11, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t11, "$this$onDetach");
        Intrinsics.checkParameterIsNotNull(function1, "onAttached");
        t11.addOnAttachStateChangeListener(new UtilKt$onDetach$1(t11, function1));
    }

    public static final void setCallbacks(@NotNull BottomSheetBehavior<?> bottomSheetBehavior, @NotNull Function1<? super Integer, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(bottomSheetBehavior, "$this$setCallbacks");
        Intrinsics.checkParameterIsNotNull(function1, "onSlide");
        Intrinsics.checkParameterIsNotNull(function0, "onHide");
        bottomSheetBehavior.setBottomSheetCallback(new UtilKt$setCallbacks$1(bottomSheetBehavior, function1, function0));
    }
}
