package androidx.compose.material.ripple;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v.a;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u0000 42\u00020\u0001:\u00014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JQ\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0006\u0010 \u001a\u00020\rJ\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0016J0\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018H\u0014J\u0018\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0018H\u0014J\b\u0010-\u001a\u00020\rH\u0016J\u0006\u0010.\u001a\u00020\rJ\u0010\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\u0006H\u0002J3\u00101\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"Landroidx/compose/material/ripple/RippleHostView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bounded", "", "Ljava/lang/Boolean;", "lastRippleStateChangeTimeMillis", "", "Ljava/lang/Long;", "onInvalidateRipple", "Lkotlin/Function0;", "", "resetRippleRunnable", "Ljava/lang/Runnable;", "ripple", "Landroidx/compose/material/ripple/UnprojectedRipple;", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "size", "Landroidx/compose/ui/geometry/Size;", "radius", "", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "", "addRipple-KOepWvA", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;ZJIJFLkotlin/jvm/functions/Function0;)V", "createRipple", "disposeRipple", "invalidateDrawable", "who", "Landroid/graphics/drawable/Drawable;", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshDrawableState", "removeRipple", "setRippleState", "pressed", "updateRippleProperties", "updateRippleProperties-biQXAtU", "(JIJF)V", "Companion", "material-ripple_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RippleHostView extends View {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long MinimumRippleStateChangeTime = 5;
    @NotNull
    private static final int[] PressedState = {16842919, 16842910};
    private static final long ResetRippleDelayDuration = 50;
    @NotNull
    private static final int[] RestingState = new int[0];
    @Nullable
    private Boolean bounded;
    @Nullable
    private Long lastRippleStateChangeTimeMillis;
    @Nullable
    private Function0<Unit> onInvalidateRipple;
    @Nullable
    private Runnable resetRippleRunnable;
    @Nullable
    private UnprojectedRipple ripple;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/material/ripple/RippleHostView$Companion;", "", "()V", "MinimumRippleStateChangeTime", "", "PressedState", "", "ResetRippleDelayDuration", "RestingState", "material-ripple_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RippleHostView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void createRipple(boolean z11) {
        UnprojectedRipple unprojectedRipple = new UnprojectedRipple(z11);
        setBackground(unprojectedRipple);
        this.ripple = unprojectedRipple;
    }

    private final void setRippleState(boolean z11) {
        long j11;
        int[] iArr;
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Runnable runnable = this.resetRippleRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            runnable.run();
        }
        Long l11 = this.lastRippleStateChangeTimeMillis;
        if (l11 != null) {
            j11 = l11.longValue();
        } else {
            j11 = 0;
        }
        long j12 = currentAnimationTimeMillis - j11;
        if (z11 || j12 >= 5) {
            if (z11) {
                iArr = PressedState;
            } else {
                iArr = RestingState;
            }
            UnprojectedRipple unprojectedRipple = this.ripple;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(iArr);
            }
        } else {
            a aVar = new a(this);
            this.resetRippleRunnable = aVar;
            postDelayed(aVar, 50);
        }
        this.lastRippleStateChangeTimeMillis = Long.valueOf(currentAnimationTimeMillis);
    }

    /* access modifiers changed from: private */
    /* renamed from: setRippleState$lambda-2  reason: not valid java name */
    public static final void m1481setRippleState$lambda2(RippleHostView rippleHostView) {
        Intrinsics.checkNotNullParameter(rippleHostView, "this$0");
        UnprojectedRipple unprojectedRipple = rippleHostView.ripple;
        if (unprojectedRipple != null) {
            unprojectedRipple.setState(RestingState);
        }
        rippleHostView.resetRippleRunnable = null;
    }

    /* renamed from: addRipple-KOepWvA  reason: not valid java name */
    public final void m1482addRippleKOepWvA(@NotNull PressInteraction.Press press, boolean z11, long j11, int i11, long j12, float f11, @NotNull Function0<Unit> function0) {
        boolean z12 = z11;
        Function0<Unit> function02 = function0;
        PressInteraction.Press press2 = press;
        Intrinsics.checkNotNullParameter(press, "interaction");
        Intrinsics.checkNotNullParameter(function02, "onInvalidateRipple");
        if (this.ripple == null || !Intrinsics.areEqual((Object) Boolean.valueOf(z11), (Object) this.bounded)) {
            createRipple(z11);
            this.bounded = Boolean.valueOf(z11);
        }
        UnprojectedRipple unprojectedRipple = this.ripple;
        Intrinsics.checkNotNull(unprojectedRipple);
        this.onInvalidateRipple = function02;
        m1483updateRipplePropertiesbiQXAtU(j11, i11, j12, f11);
        if (z12) {
            unprojectedRipple.setHotspot(Offset.m2676getXimpl(press.m367getPressPositionF1C5BW0()), Offset.m2677getYimpl(press.m367getPressPositionF1C5BW0()));
        } else {
            unprojectedRipple.setHotspot((float) unprojectedRipple.getBounds().centerX(), (float) unprojectedRipple.getBounds().centerY());
        }
        setRippleState(true);
    }

    public final void disposeRipple() {
        this.onInvalidateRipple = null;
        Runnable runnable = this.resetRippleRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            Runnable runnable2 = this.resetRippleRunnable;
            Intrinsics.checkNotNull(runnable2);
            runnable2.run();
        } else {
            UnprojectedRipple unprojectedRipple = this.ripple;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(RestingState);
            }
        }
        UnprojectedRipple unprojectedRipple2 = this.ripple;
        if (unprojectedRipple2 != null) {
            unprojectedRipple2.setVisible(false, false);
            unscheduleDrawable(unprojectedRipple2);
        }
    }

    public void invalidateDrawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "who");
        Function0<Unit> function0 = this.onInvalidateRipple;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(0, 0);
    }

    public void refreshDrawableState() {
    }

    public final void removeRipple() {
        setRippleState(false);
    }

    /* renamed from: updateRippleProperties-biQXAtU  reason: not valid java name */
    public final void m1483updateRipplePropertiesbiQXAtU(long j11, int i11, long j12, float f11) {
        UnprojectedRipple unprojectedRipple = this.ripple;
        if (unprojectedRipple != null) {
            unprojectedRipple.trySetRadius(i11);
            unprojectedRipple.m1491setColorDxMtmZc(j12, f11);
            Rect androidRect = RectHelper_androidKt.toAndroidRect(SizeKt.m2766toRectuvyYCjk(j11));
            setLeft(androidRect.left);
            setTop(androidRect.top);
            setRight(androidRect.right);
            setBottom(androidRect.bottom);
            unprojectedRipple.setBounds(androidRect);
        }
    }
}
