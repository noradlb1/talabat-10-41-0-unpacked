package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.widget.VirtualLayout;

public class MotionPlaceholder extends VirtualLayout {
    private static final String TAG = "MotionPlaceholder";

    /* renamed from: j  reason: collision with root package name */
    public Placeholder f10854j;

    public MotionPlaceholder(Context context) {
        super(context);
    }

    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        this.f11097e = new Placeholder();
        validateParams();
    }

    @SuppressLint({"WrongCall"})
    public void onMeasure(int i11, int i12) {
        onMeasure(this.f10854j, i11, i12);
    }

    public void updatePreLayout(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray<ConstraintWidget> sparseArray) {
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(androidx.constraintlayout.core.widgets.VirtualLayout virtualLayout, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        if (virtualLayout != null) {
            virtualLayout.measure(mode, size, mode2, size2);
            setMeasuredDimension(virtualLayout.getMeasuredWidth(), virtualLayout.getMeasuredHeight());
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
    }
}
