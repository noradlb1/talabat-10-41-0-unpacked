package androidx.percentlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.percentlayout.R;

@Deprecated
public class PercentLayoutHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "PercentLayout";
    private static final boolean VERBOSE = false;
    private final ViewGroup mHost;

    @Deprecated
    public static class PercentLayoutInfo {

        /* renamed from: a  reason: collision with root package name */
        public final PercentMarginLayoutParams f37282a = new PercentMarginLayoutParams(0, 0);
        public float aspectRatio;
        public float bottomMarginPercent = -1.0f;
        public float endMarginPercent = -1.0f;
        public float heightPercent = -1.0f;
        public float leftMarginPercent = -1.0f;
        public float rightMarginPercent = -1.0f;
        public float startMarginPercent = -1.0f;
        public float topMarginPercent = -1.0f;
        public float widthPercent = -1.0f;

        public void fillLayoutParams(ViewGroup.LayoutParams layoutParams, int i11, int i12) {
            boolean z11;
            PercentMarginLayoutParams percentMarginLayoutParams = this.f37282a;
            int i13 = layoutParams.width;
            percentMarginLayoutParams.width = i13;
            int i14 = layoutParams.height;
            percentMarginLayoutParams.height = i14;
            boolean z12 = false;
            if ((percentMarginLayoutParams.f37284b || i13 == 0) && this.widthPercent < 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((percentMarginLayoutParams.f37283a || i14 == 0) && this.heightPercent < 0.0f) {
                z12 = true;
            }
            float f11 = this.widthPercent;
            if (f11 >= 0.0f) {
                layoutParams.width = Math.round(((float) i11) * f11);
            }
            float f12 = this.heightPercent;
            if (f12 >= 0.0f) {
                layoutParams.height = Math.round(((float) i12) * f12);
            }
            float f13 = this.aspectRatio;
            if (f13 >= 0.0f) {
                if (z11) {
                    layoutParams.width = Math.round(((float) layoutParams.height) * f13);
                    this.f37282a.f37284b = true;
                }
                if (z12) {
                    layoutParams.height = Math.round(((float) layoutParams.width) / this.aspectRatio);
                    this.f37282a.f37283a = true;
                }
            }
        }

        @Deprecated
        public void fillMarginLayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams, int i11, int i12) {
            fillMarginLayoutParams((View) null, marginLayoutParams, i11, i12);
        }

        public void restoreLayoutParams(ViewGroup.LayoutParams layoutParams) {
            PercentMarginLayoutParams percentMarginLayoutParams = this.f37282a;
            if (!percentMarginLayoutParams.f37284b) {
                layoutParams.width = percentMarginLayoutParams.width;
            }
            if (!percentMarginLayoutParams.f37283a) {
                layoutParams.height = percentMarginLayoutParams.height;
            }
            percentMarginLayoutParams.f37284b = false;
            percentMarginLayoutParams.f37283a = false;
        }

        public void restoreMarginLayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            restoreLayoutParams(marginLayoutParams);
            PercentMarginLayoutParams percentMarginLayoutParams = this.f37282a;
            marginLayoutParams.leftMargin = percentMarginLayoutParams.leftMargin;
            marginLayoutParams.topMargin = percentMarginLayoutParams.topMargin;
            marginLayoutParams.rightMargin = percentMarginLayoutParams.rightMargin;
            marginLayoutParams.bottomMargin = percentMarginLayoutParams.bottomMargin;
            MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, MarginLayoutParamsCompat.getMarginStart(percentMarginLayoutParams));
            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, MarginLayoutParamsCompat.getMarginEnd(this.f37282a));
        }

        public String toString() {
            return String.format("PercentLayoutInformation width: %f height %f, margins (%f, %f,  %f, %f, %f, %f)", new Object[]{Float.valueOf(this.widthPercent), Float.valueOf(this.heightPercent), Float.valueOf(this.leftMarginPercent), Float.valueOf(this.topMarginPercent), Float.valueOf(this.rightMarginPercent), Float.valueOf(this.bottomMarginPercent), Float.valueOf(this.startMarginPercent), Float.valueOf(this.endMarginPercent)});
        }

        public void fillMarginLayoutParams(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i11, int i12) {
            boolean z11;
            fillLayoutParams(marginLayoutParams, i11, i12);
            PercentMarginLayoutParams percentMarginLayoutParams = this.f37282a;
            percentMarginLayoutParams.leftMargin = marginLayoutParams.leftMargin;
            percentMarginLayoutParams.topMargin = marginLayoutParams.topMargin;
            percentMarginLayoutParams.rightMargin = marginLayoutParams.rightMargin;
            percentMarginLayoutParams.bottomMargin = marginLayoutParams.bottomMargin;
            MarginLayoutParamsCompat.setMarginStart(percentMarginLayoutParams, MarginLayoutParamsCompat.getMarginStart(marginLayoutParams));
            MarginLayoutParamsCompat.setMarginEnd(this.f37282a, MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams));
            float f11 = this.leftMarginPercent;
            if (f11 >= 0.0f) {
                marginLayoutParams.leftMargin = Math.round(((float) i11) * f11);
            }
            float f12 = this.topMarginPercent;
            if (f12 >= 0.0f) {
                marginLayoutParams.topMargin = Math.round(((float) i12) * f12);
            }
            float f13 = this.rightMarginPercent;
            if (f13 >= 0.0f) {
                marginLayoutParams.rightMargin = Math.round(((float) i11) * f13);
            }
            float f14 = this.bottomMarginPercent;
            if (f14 >= 0.0f) {
                marginLayoutParams.bottomMargin = Math.round(((float) i12) * f14);
            }
            float f15 = this.startMarginPercent;
            boolean z12 = true;
            if (f15 >= 0.0f) {
                MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, Math.round(((float) i11) * f15));
                z11 = true;
            } else {
                z11 = false;
            }
            float f16 = this.endMarginPercent;
            if (f16 >= 0.0f) {
                MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, Math.round(((float) i11) * f16));
            } else {
                z12 = z11;
            }
            if (z12 && view != null) {
                MarginLayoutParamsCompat.resolveLayoutDirection(marginLayoutParams, ViewCompat.getLayoutDirection(view));
            }
        }
    }

    @Deprecated
    public interface PercentLayoutParams {
        PercentLayoutInfo getPercentLayoutInfo();
    }

    public static class PercentMarginLayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f37283a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37284b;

        public PercentMarginLayoutParams(int i11, int i12) {
            super(i11, i12);
        }
    }

    public PercentLayoutHelper(@NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.mHost = viewGroup;
            return;
        }
        throw new IllegalArgumentException("host must be non-null");
    }

    public static void fetchWidthAndHeight(ViewGroup.LayoutParams layoutParams, TypedArray typedArray, int i11, int i12) {
        layoutParams.width = typedArray.getLayoutDimension(i11, 0);
        layoutParams.height = typedArray.getLayoutDimension(i12, 0);
    }

    public static PercentLayoutInfo getPercentLayoutInfo(Context context, AttributeSet attributeSet) {
        PercentLayoutInfo percentLayoutInfo;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PercentLayout_Layout);
        float fraction = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_widthPercent, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            percentLayoutInfo = new PercentLayoutInfo();
            percentLayoutInfo.widthPercent = fraction;
        } else {
            percentLayoutInfo = null;
        }
        float fraction2 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_heightPercent, 1, 1, -1.0f);
        if (fraction2 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.heightPercent = fraction2;
        }
        float fraction3 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_marginPercent, 1, 1, -1.0f);
        if (fraction3 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.leftMarginPercent = fraction3;
            percentLayoutInfo.topMarginPercent = fraction3;
            percentLayoutInfo.rightMarginPercent = fraction3;
            percentLayoutInfo.bottomMarginPercent = fraction3;
        }
        float fraction4 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_marginLeftPercent, 1, 1, -1.0f);
        if (fraction4 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.leftMarginPercent = fraction4;
        }
        float fraction5 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_marginTopPercent, 1, 1, -1.0f);
        if (fraction5 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.topMarginPercent = fraction5;
        }
        float fraction6 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_marginRightPercent, 1, 1, -1.0f);
        if (fraction6 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.rightMarginPercent = fraction6;
        }
        float fraction7 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_marginBottomPercent, 1, 1, -1.0f);
        if (fraction7 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.bottomMarginPercent = fraction7;
        }
        float fraction8 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_marginStartPercent, 1, 1, -1.0f);
        if (fraction8 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.startMarginPercent = fraction8;
        }
        float fraction9 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_marginEndPercent, 1, 1, -1.0f);
        if (fraction9 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.endMarginPercent = fraction9;
        }
        float fraction10 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_aspectRatio, 1, 1, -1.0f);
        if (fraction10 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.aspectRatio = fraction10;
        }
        obtainStyledAttributes.recycle();
        return percentLayoutInfo;
    }

    private static boolean shouldHandleMeasuredHeightTooSmall(View view, PercentLayoutInfo percentLayoutInfo) {
        if ((view.getMeasuredHeightAndState() & ViewCompat.MEASURED_STATE_MASK) == 16777216 && percentLayoutInfo.heightPercent >= 0.0f && percentLayoutInfo.f37282a.height == -2) {
            return true;
        }
        return false;
    }

    private static boolean shouldHandleMeasuredWidthTooSmall(View view, PercentLayoutInfo percentLayoutInfo) {
        if ((view.getMeasuredWidthAndState() & ViewCompat.MEASURED_STATE_MASK) == 16777216 && percentLayoutInfo.widthPercent >= 0.0f && percentLayoutInfo.f37282a.width == -2) {
            return true;
        }
        return false;
    }

    public void adjustChildren(int i11, int i12) {
        PercentLayoutInfo percentLayoutInfo;
        int size = (View.MeasureSpec.getSize(i11) - this.mHost.getPaddingLeft()) - this.mHost.getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i12) - this.mHost.getPaddingTop()) - this.mHost.getPaddingBottom();
        int childCount = this.mHost.getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = this.mHost.getChildAt(i13);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof PercentLayoutParams) && (percentLayoutInfo = ((PercentLayoutParams) layoutParams).getPercentLayoutInfo()) != null) {
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    percentLayoutInfo.fillMarginLayoutParams(childAt, (ViewGroup.MarginLayoutParams) layoutParams, size, size2);
                } else {
                    percentLayoutInfo.fillLayoutParams(layoutParams, size, size2);
                }
            }
        }
    }

    public boolean handleMeasuredStateTooSmall() {
        PercentLayoutInfo percentLayoutInfo;
        int childCount = this.mHost.getChildCount();
        boolean z11 = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = this.mHost.getChildAt(i11);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof PercentLayoutParams) && (percentLayoutInfo = ((PercentLayoutParams) layoutParams).getPercentLayoutInfo()) != null) {
                if (shouldHandleMeasuredWidthTooSmall(childAt, percentLayoutInfo)) {
                    layoutParams.width = -2;
                    z11 = true;
                }
                if (shouldHandleMeasuredHeightTooSmall(childAt, percentLayoutInfo)) {
                    layoutParams.height = -2;
                    z11 = true;
                }
            }
        }
        return z11;
    }

    public void restoreOriginalParams() {
        PercentLayoutInfo percentLayoutInfo;
        int childCount = this.mHost.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            ViewGroup.LayoutParams layoutParams = this.mHost.getChildAt(i11).getLayoutParams();
            if ((layoutParams instanceof PercentLayoutParams) && (percentLayoutInfo = ((PercentLayoutParams) layoutParams).getPercentLayoutInfo()) != null) {
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    percentLayoutInfo.restoreMarginLayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
                } else {
                    percentLayoutInfo.restoreLayoutParams(layoutParams);
                }
            }
        }
    }
}
