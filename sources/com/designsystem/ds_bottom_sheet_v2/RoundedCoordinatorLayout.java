package com.designsystem.ds_bottom_sheet_v2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0014J\b\u0010\"\u001a\u00020\u0016H\u0002R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/designsystem/ds_bottom_sheet_v2/RoundedCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundRectangle", "Landroid/graphics/RectF;", "cornerRadius", "", "drawRoundedCorners", "", "getDrawRoundedCorners", "()Z", "setDrawRoundedCorners", "(Z)V", "path", "Landroid/graphics/Path;", "clipCanvas", "", "canvas", "Landroid/graphics/Canvas;", "drawMethod", "Lkotlin/Function1;", "dispatchDraw", "draw", "onSizeChanged", "w", "h", "oldw", "oldh", "resetPath", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RoundedCoordinatorLayout extends CoordinatorLayout {
    private RectF backgroundRectangle;
    private final float cornerRadius;
    private boolean drawRoundedCorners;
    @NotNull
    private final Path path;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundedCoordinatorLayout(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundedCoordinatorLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RoundedCoordinatorLayout(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void clipCanvas(Canvas canvas, Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.clipPath(this.path);
        function1.invoke(canvas);
        canvas.restoreToCount(save);
    }

    private final void resetPath() {
        float f11;
        if (this.drawRoundedCorners) {
            f11 = this.cornerRadius;
        } else {
            f11 = 0.0f;
        }
        float[] fArr = {f11, f11, f11, f11, 0.0f, 0.0f, 0.0f, 0.0f};
        this.path.reset();
        Path path2 = this.path;
        RectF rectF = this.backgroundRectangle;
        if (rectF == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundRectangle");
            rectF = null;
        }
        path2.addRoundRect(rectF, fArr, Path.Direction.CW);
        this.path.close();
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        clipCanvas(canvas, new RoundedCoordinatorLayout$dispatchDraw$1(this, canvas));
    }

    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        clipCanvas(canvas, new RoundedCoordinatorLayout$draw$1(this, canvas));
    }

    public final boolean getDrawRoundedCorners() {
        return this.drawRoundedCorners;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.backgroundRectangle = new RectF(0.0f, 0.0f, (float) i11, (float) i12);
        resetPath();
    }

    public final void setDrawRoundedCorners(boolean z11) {
        this.drawRoundedCorners = z11;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundedCoordinatorLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.path = new Path();
        this.cornerRadius = (float) context.getResources().getDimensionPixelSize(R.dimen.ds_s);
        this.drawRoundedCorners = true;
    }
}
