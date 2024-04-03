package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;

public class Flow extends VirtualLayout {
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    private static final String TAG = "Flow";
    public static final int VERTICAL = 1;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private androidx.constraintlayout.core.widgets.Flow mFlow;

    public Flow(Context context) {
        super(context);
    }

    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        this.mFlow = new androidx.constraintlayout.core.widgets.Flow();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.ConstraintLayout_Layout_android_orientation) {
                    this.mFlow.setOrientation(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_padding) {
                    this.mFlow.setPadding(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingStart) {
                    this.mFlow.setPaddingStart(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    this.mFlow.setPaddingEnd(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.mFlow.setPaddingLeft(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.mFlow.setPaddingTop(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.mFlow.setPaddingRight(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.mFlow.setPaddingBottom(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.mFlow.setWrapMode(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.mFlow.setHorizontalStyle(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.mFlow.setVerticalStyle(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.mFlow.setFirstHorizontalStyle(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.mFlow.setLastHorizontalStyle(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.mFlow.setFirstVerticalStyle(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.mFlow.setLastVerticalStyle(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.mFlow.setHorizontalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.mFlow.setFirstHorizontalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.mFlow.setLastHorizontalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.mFlow.setFirstVerticalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.mFlow.setLastVerticalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.mFlow.setVerticalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.mFlow.setHorizontalAlign(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.mFlow.setVerticalAlign(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.mFlow.setHorizontalGap(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.mFlow.setVerticalGap(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.mFlow.setMaxElementsWrap(obtainStyledAttributes.getInt(index, -1));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f11097e = this.mFlow;
        validateParams();
    }

    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.loadParameters(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.core.widgets.Flow) {
            androidx.constraintlayout.core.widgets.Flow flow = (androidx.constraintlayout.core.widgets.Flow) helperWidget;
            int i11 = layoutParams.orientation;
            if (i11 != -1) {
                flow.setOrientation(i11);
            }
        }
    }

    @SuppressLint({"WrongCall"})
    public void onMeasure(int i11, int i12) {
        onMeasure(this.mFlow, i11, i12);
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean z11) {
        this.mFlow.applyRtl(z11);
    }

    public void setFirstHorizontalBias(float f11) {
        this.mFlow.setFirstHorizontalBias(f11);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i11) {
        this.mFlow.setFirstHorizontalStyle(i11);
        requestLayout();
    }

    public void setFirstVerticalBias(float f11) {
        this.mFlow.setFirstVerticalBias(f11);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i11) {
        this.mFlow.setFirstVerticalStyle(i11);
        requestLayout();
    }

    public void setHorizontalAlign(int i11) {
        this.mFlow.setHorizontalAlign(i11);
        requestLayout();
    }

    public void setHorizontalBias(float f11) {
        this.mFlow.setHorizontalBias(f11);
        requestLayout();
    }

    public void setHorizontalGap(int i11) {
        this.mFlow.setHorizontalGap(i11);
        requestLayout();
    }

    public void setHorizontalStyle(int i11) {
        this.mFlow.setHorizontalStyle(i11);
        requestLayout();
    }

    public void setLastHorizontalBias(float f11) {
        this.mFlow.setLastHorizontalBias(f11);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i11) {
        this.mFlow.setLastHorizontalStyle(i11);
        requestLayout();
    }

    public void setLastVerticalBias(float f11) {
        this.mFlow.setLastVerticalBias(f11);
        requestLayout();
    }

    public void setLastVerticalStyle(int i11) {
        this.mFlow.setLastVerticalStyle(i11);
        requestLayout();
    }

    public void setMaxElementsWrap(int i11) {
        this.mFlow.setMaxElementsWrap(i11);
        requestLayout();
    }

    public void setOrientation(int i11) {
        this.mFlow.setOrientation(i11);
        requestLayout();
    }

    public void setPadding(int i11) {
        this.mFlow.setPadding(i11);
        requestLayout();
    }

    public void setPaddingBottom(int i11) {
        this.mFlow.setPaddingBottom(i11);
        requestLayout();
    }

    public void setPaddingLeft(int i11) {
        this.mFlow.setPaddingLeft(i11);
        requestLayout();
    }

    public void setPaddingRight(int i11) {
        this.mFlow.setPaddingRight(i11);
        requestLayout();
    }

    public void setPaddingTop(int i11) {
        this.mFlow.setPaddingTop(i11);
        requestLayout();
    }

    public void setVerticalAlign(int i11) {
        this.mFlow.setVerticalAlign(i11);
        requestLayout();
    }

    public void setVerticalBias(float f11) {
        this.mFlow.setVerticalBias(f11);
        requestLayout();
    }

    public void setVerticalGap(int i11) {
        this.mFlow.setVerticalGap(i11);
        requestLayout();
    }

    public void setVerticalStyle(int i11) {
        this.mFlow.setVerticalStyle(i11);
        requestLayout();
    }

    public void setWrapMode(int i11) {
        this.mFlow.setWrapMode(i11);
        requestLayout();
    }

    public Flow(Context context, AttributeSet attributeSet) {
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

    public Flow(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
