package com.designsystem.ds_bottom_sheet_v2;

import a6.c;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.designsystem.extensions.ContextExtensionsKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0013\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J(\u0010$\u001a\n &*\u0004\u0018\u00010%0%2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006*"}, d2 = {"Lcom/designsystem/ds_bottom_sheet_v2/BottomSheetSharedTransition;", "Landroid/transition/Transition;", "()V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentMaxHeight", "", "getContentMaxHeight", "()I", "setContentMaxHeight", "(I)V", "captureEndValues", "", "transitionValues", "Landroid/transition/TransitionValues;", "captureStartValues", "createAnimator", "Landroid/animation/Animator;", "sceneRoot", "Landroid/view/ViewGroup;", "startValues", "endValues", "getDisplaySize", "Landroid/graphics/Point;", "view", "Landroid/view/View;", "getScreenWidth", "getTransitionProperties", "", "", "()[Ljava/lang/String;", "getViewHeight", "prepareFadeInAnimator", "prepareHeightAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "startHeight", "endHeight", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BottomSheetSharedTransition extends Transition {
    private static final long ANIMATION_DURATION = 500;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String PROP_HEIGHT = "heightTransition:height";
    @NotNull
    private static final String PROP_VIEW_TYPE = "heightTransition:viewType";
    @NotNull
    private static final String[] TransitionProperties = {PROP_HEIGHT, PROP_VIEW_TYPE};
    private int contentMaxHeight;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/designsystem/ds_bottom_sheet_v2/BottomSheetSharedTransition$Companion;", "", "()V", "ANIMATION_DURATION", "", "PROP_HEIGHT", "", "PROP_VIEW_TYPE", "TransitionProperties", "", "[Ljava/lang/String;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BottomSheetSharedTransition() {
    }

    private final Point getDisplaySize(View view) {
        Point point = new Point();
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Display currentDisplay = ContextExtensionsKt.getCurrentDisplay(context);
        if (currentDisplay != null) {
            currentDisplay.getSize(point);
        }
        return point;
    }

    private final int getScreenWidth(View view) {
        return getDisplaySize(view).x;
    }

    private final int getViewHeight(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(getScreenWidth(view), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return RangesKt___RangesKt.coerceAtMost(view.getMeasuredHeight(), this.contentMaxHeight);
    }

    private final Animator prepareFadeInAnimator(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f, 1.0f});
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(view, View.ALPHA, 0f, 1f)");
        return ofFloat;
    }

    private final ValueAnimator prepareHeightAnimator(int i11, int i12, View view) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        ViewParent parent = view.getParent();
        if (parent != null) {
            View view2 = (View) parent;
            ofInt.addUpdateListener(new c(view2));
            addListener(new BottomSheetSharedTransition$prepareHeightAnimator$lambda9$$inlined$doOnEnd$1(view2, i12));
            return ofInt;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    /* access modifiers changed from: private */
    /* renamed from: prepareHeightAnimator$lambda-9$lambda-6  reason: not valid java name */
    public static final void m8264prepareHeightAnimator$lambda9$lambda6(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$container");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                layoutParams.height = ((Integer) animatedValue).intValue();
                view.setLayoutParams(layoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public void captureEndValues(@NotNull TransitionValues transitionValues) {
        Intrinsics.checkNotNullParameter(transitionValues, "transitionValues");
        Map map = transitionValues.values;
        Intrinsics.checkNotNullExpressionValue(map, "transitionValues.values");
        ViewParent parent = transitionValues.view.getParent();
        if (parent != null) {
            map.put(PROP_HEIGHT, Integer.valueOf(getViewHeight((View) parent)));
            Map map2 = transitionValues.values;
            Intrinsics.checkNotNullExpressionValue(map2, "transitionValues.values");
            map2.put(PROP_VIEW_TYPE, TtmlNode.END);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    public void captureStartValues(@NotNull TransitionValues transitionValues) {
        View view;
        Intrinsics.checkNotNullParameter(transitionValues, "transitionValues");
        int coerceAtMost = RangesKt___RangesKt.coerceAtMost(transitionValues.view.getHeight(), this.contentMaxHeight);
        Map map = transitionValues.values;
        Intrinsics.checkNotNullExpressionValue(map, "transitionValues.values");
        map.put(PROP_HEIGHT, Integer.valueOf(coerceAtMost));
        Map map2 = transitionValues.values;
        Intrinsics.checkNotNullExpressionValue(map2, "transitionValues.values");
        map2.put(PROP_VIEW_TYPE, "start");
        ViewParent parent = transitionValues.view.getParent();
        if (parent instanceof View) {
            view = (View) parent;
        } else {
            view = null;
        }
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = coerceAtMost;
                view.setLayoutParams(layoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    @Nullable
    public Animator createAnimator(@Nullable ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Animator[] animatorArr = new Animator[2];
        Object obj = transitionValues.values.get(PROP_HEIGHT);
        if (obj != null) {
            int intValue = ((Integer) obj).intValue();
            Object obj2 = transitionValues2.values.get(PROP_HEIGHT);
            if (obj2 != null) {
                int intValue2 = ((Integer) obj2).intValue();
                View view = transitionValues2.view;
                Intrinsics.checkNotNullExpressionValue(view, "endValues.view");
                ValueAnimator prepareHeightAnimator = prepareHeightAnimator(intValue, intValue2, view);
                Intrinsics.checkNotNullExpressionValue(prepareHeightAnimator, "prepareHeightAnimator(\n …Values.view\n            )");
                animatorArr[0] = prepareHeightAnimator;
                View view2 = transitionValues2.view;
                Intrinsics.checkNotNullExpressionValue(view2, "endValues.view");
                animatorArr[1] = prepareFadeInAnimator(view2);
                List listOf = CollectionsKt__CollectionsKt.listOf(animatorArr);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setInterpolator(new FastOutSlowInInterpolator());
                animatorSet.setDuration(500);
                animatorSet.playTogether(listOf);
                return animatorSet;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final int getContentMaxHeight() {
        return this.contentMaxHeight;
    }

    @NotNull
    public String[] getTransitionProperties() {
        return TransitionProperties;
    }

    public final void setContentMaxHeight(int i11) {
        this.contentMaxHeight = i11;
    }

    public BottomSheetSharedTransition(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
