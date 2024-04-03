package com.talabat.feature.tpro.presentation.benefits.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.helpers.TalabatUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J(\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0014J\b\u0010\u001c\u001a\u00020\u0012H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/view/ClippedConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerRadius", "", "path", "Landroid/graphics/Path;", "rectF", "Landroid/graphics/RectF;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "draw", "init", "onSizeChanged", "w", "h", "oldw", "oldh", "resetPath", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ClippedConstraintLayout extends ConstraintLayout {
    private float cornerRadius;
    @NotNull
    private final Path path = new Path();
    @NotNull
    private RectF rectF = new RectF();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClippedConstraintLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ClippedConstraintLayout);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr….ClippedConstraintLayout)");
        this.cornerRadius = obtainStyledAttributes.getFloat(R.styleable.ClippedConstraintLayout_clipRadius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private final void resetPath() {
        this.path.reset();
        Path path2 = this.path;
        RectF rectF2 = this.rectF;
        float f11 = this.cornerRadius;
        path2.addRoundRect(rectF2, f11, f11, Path.Direction.CW);
        this.path.close();
    }

    public void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int save = canvas.save();
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int save = canvas.save();
        canvas.clipPath(this.path);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        RectF rectF2;
        super.onSizeChanged(i11, i12, i13, i14);
        if (TalabatUtils.isRTL()) {
            rectF2 = new RectF((float) getLeft(), ((float) getTop()) - this.cornerRadius, ((float) getRight()) + this.cornerRadius, (float) getBottom());
        } else {
            rectF2 = new RectF(((float) getLeft()) - this.cornerRadius, ((float) getTop()) - this.cornerRadius, (float) getRight(), (float) getBottom());
        }
        this.rectF = rectF2;
        resetPath();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClippedConstraintLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClippedConstraintLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        init(attributeSet);
    }
}
