package com.skydoves.landscapist;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\f\u0010\u0012\u001a\u00020\u0003*\u00020\u0011H\u0014R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R+\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00188B@BX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010*\u001a\u00020'8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b(\u0010)\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Lcom/skydoves/landscapist/DrawablePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "", "onRemembered", "onAbandoned", "onForgotten", "", "alpha", "", "a", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "b", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "c", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "d", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "", "<set-?>", "invalidateTick$delegate", "Landroidx/compose/runtime/MutableState;", "getInvalidateTick", "()I", "setInvalidateTick", "(I)V", "invalidateTick", "Landroid/graphics/drawable/Drawable$Callback;", "callback$delegate", "Lkotlin/Lazy;", "getCallback", "()Landroid/graphics/drawable/Drawable$Callback;", "callback", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "intrinsicSize", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "landscapist_release"}, k = 1, mv = {1, 5, 1})
public final class DrawablePainter extends Painter implements RememberObserver {
    @NotNull
    private final Lazy callback$delegate = LazyKt__LazyJVMKt.lazy(new DrawablePainter$callback$2(this));
    @NotNull
    private final Drawable drawable;
    @NotNull
    private final MutableState invalidateTick$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DrawablePainter(@NotNull Drawable drawable2) {
        Intrinsics.checkNotNullParameter(drawable2, "drawable");
        this.drawable = drawable2;
        if (drawable2.getIntrinsicWidth() >= 0 && drawable2.getIntrinsicHeight() >= 0) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
    }

    private final Drawable.Callback getCallback() {
        return (Drawable.Callback) this.callback$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final int getInvalidateTick() {
        return ((Number) this.invalidateTick$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public final void setInvalidateTick(int i11) {
        this.invalidateTick$delegate.setValue(Integer.valueOf(i11));
    }

    public boolean a(float f11) {
        this.drawable.setAlpha(RangesKt___RangesKt.coerceIn(MathKt__MathJVMKt.roundToInt(f11 * ((float) 255)), 0, 255));
        return true;
    }

    public boolean b(@Nullable ColorFilter colorFilter) {
        this.drawable.setColorFilter(colorFilter == null ? null : AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter));
        return true;
    }

    public boolean c(@NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Drawable drawable2 = this.drawable;
        int i11 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        int i12 = 1;
        if (i11 == 1) {
            i12 = 0;
        } else if (i11 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return drawable2.setLayoutDirection(i12);
    }

    public void d(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        getInvalidateTick();
        getDrawable().setBounds(0, 0, MathKt__MathJVMKt.roundToInt(Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc())), MathKt__MathJVMKt.roundToInt(Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc())));
        try {
            canvas.save();
            getDrawable().draw(AndroidCanvas_androidKt.getNativeCanvas(canvas));
        } finally {
            canvas.restore();
        }
    }

    @NotNull
    public final Drawable getDrawable() {
        return this.drawable;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m9393getIntrinsicSizeNHjbRc() {
        if (this.drawable.getIntrinsicWidth() < 0 || this.drawable.getIntrinsicHeight() < 0) {
            return Size.Companion.m2753getUnspecifiedNHjbRc();
        }
        return SizeKt.Size((float) this.drawable.getIntrinsicWidth(), (float) this.drawable.getIntrinsicHeight());
    }

    public void onAbandoned() {
        onForgotten();
    }

    public void onForgotten() {
        Drawable drawable2 = this.drawable;
        if (drawable2 instanceof Animatable) {
            ((Animatable) drawable2).stop();
        }
        this.drawable.setVisible(false, false);
        this.drawable.setCallback((Drawable.Callback) null);
    }

    public void onRemembered() {
        this.drawable.setCallback(getCallback());
        this.drawable.setVisible(true, true);
        Drawable drawable2 = this.drawable;
        if (drawable2 instanceof Animatable) {
            ((Animatable) drawable2).start();
        }
    }
}
