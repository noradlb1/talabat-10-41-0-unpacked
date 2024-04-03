package androidx.percentlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.percentlayout.widget.PercentLayoutHelper;

@Deprecated
public class PercentRelativeLayout extends RelativeLayout {
    private final PercentLayoutHelper mHelper = new PercentLayoutHelper(this);

    public PercentRelativeLayout(Context context) {
        super(context);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.mHelper.restoreOriginalParams();
    }

    public void onMeasure(int i11, int i12) {
        this.mHelper.adjustChildren(i11, i12);
        super.onMeasure(i11, i12);
        if (this.mHelper.handleMeasuredStateTooSmall()) {
            super.onMeasure(i11, i12);
        }
    }

    @Deprecated
    public static class LayoutParams extends RelativeLayout.LayoutParams implements PercentLayoutHelper.PercentLayoutParams {
        private PercentLayoutHelper.PercentLayoutInfo mPercentLayoutInfo;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mPercentLayoutInfo = PercentLayoutHelper.getPercentLayoutInfo(context, attributeSet);
        }

        public PercentLayoutHelper.PercentLayoutInfo getPercentLayoutInfo() {
            if (this.mPercentLayoutInfo == null) {
                this.mPercentLayoutInfo = new PercentLayoutHelper.PercentLayoutInfo();
            }
            return this.mPercentLayoutInfo;
        }

        public void setBaseAttributes(TypedArray typedArray, int i11, int i12) {
            PercentLayoutHelper.fetchWidthAndHeight(this, typedArray, i11, i12);
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public PercentRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public PercentRelativeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
