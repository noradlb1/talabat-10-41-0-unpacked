package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

public class Layer extends ConstraintHelper {
    private static final String TAG = "Layer";

    /* renamed from: j  reason: collision with root package name */
    public ConstraintLayout f10845j;

    /* renamed from: k  reason: collision with root package name */
    public float f10846k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    public float f10847l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    public float f10848m = Float.NaN;
    private boolean mApplyElevationOnAttach;
    private boolean mApplyVisibilityOnAttach;
    private float mGroupRotateAngle = Float.NaN;
    private float mRotationCenterX = Float.NaN;
    private float mRotationCenterY = Float.NaN;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private float mShiftX = 0.0f;
    private float mShiftY = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    public float f10849n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    public float f10850o = Float.NaN;

    /* renamed from: p  reason: collision with root package name */
    public float f10851p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    public boolean f10852q = true;

    /* renamed from: r  reason: collision with root package name */
    public View[] f10853r = null;

    public Layer(Context context) {
        super(context);
    }

    private void reCacheViews() {
        int i11;
        if (this.f10845j != null && (i11 = this.f11095c) != 0) {
            View[] viewArr = this.f10853r;
            if (viewArr == null || viewArr.length != i11) {
                this.f10853r = new View[i11];
            }
            for (int i12 = 0; i12 < this.f11095c; i12++) {
                this.f10853r[i12] = this.f10845j.getViewById(this.f11094b[i12]);
            }
        }
    }

    private void transform() {
        double d11;
        if (this.f10845j != null) {
            if (this.f10853r == null) {
                reCacheViews();
            }
            f();
            if (Float.isNaN(this.mGroupRotateAngle)) {
                d11 = 0.0d;
            } else {
                d11 = Math.toRadians((double) this.mGroupRotateAngle);
            }
            float sin = (float) Math.sin(d11);
            float cos = (float) Math.cos(d11);
            float f11 = this.mScaleX;
            float f12 = f11 * cos;
            float f13 = this.mScaleY;
            float f14 = (-f13) * sin;
            float f15 = f11 * sin;
            float f16 = f13 * cos;
            for (int i11 = 0; i11 < this.f11095c; i11++) {
                View view = this.f10853r[i11];
                float left = ((float) ((view.getLeft() + view.getRight()) / 2)) - this.f10846k;
                float top = ((float) ((view.getTop() + view.getBottom()) / 2)) - this.f10847l;
                view.setTranslationX((((f12 * left) + (f14 * top)) - left) + this.mShiftX);
                view.setTranslationY((((left * f15) + (f16 * top)) - top) + this.mShiftY);
                view.setScaleY(this.mScaleY);
                view.setScaleX(this.mScaleX);
                if (!Float.isNaN(this.mGroupRotateAngle)) {
                    view.setRotation(this.mGroupRotateAngle);
                }
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        b(constraintLayout);
    }

    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        this.f11098f = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.mApplyVisibilityOnAttach = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.mApplyElevationOnAttach = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void f() {
        if (this.f10845j != null) {
            if (!this.f10852q && !Float.isNaN(this.f10846k) && !Float.isNaN(this.f10847l)) {
                return;
            }
            if (Float.isNaN(this.mRotationCenterX) || Float.isNaN(this.mRotationCenterY)) {
                View[] d11 = d(this.f10845j);
                int left = d11[0].getLeft();
                int top = d11[0].getTop();
                int right = d11[0].getRight();
                int bottom = d11[0].getBottom();
                for (int i11 = 0; i11 < this.f11095c; i11++) {
                    View view = d11[i11];
                    left = Math.min(left, view.getLeft());
                    top = Math.min(top, view.getTop());
                    right = Math.max(right, view.getRight());
                    bottom = Math.max(bottom, view.getBottom());
                }
                this.f10848m = (float) right;
                this.f10849n = (float) bottom;
                this.f10850o = (float) left;
                this.f10851p = (float) top;
                if (Float.isNaN(this.mRotationCenterX)) {
                    this.f10846k = (float) ((left + right) / 2);
                } else {
                    this.f10846k = this.mRotationCenterX;
                }
                if (Float.isNaN(this.mRotationCenterY)) {
                    this.f10847l = (float) ((top + bottom) / 2);
                } else {
                    this.f10847l = this.mRotationCenterY;
                }
            } else {
                this.f10847l = this.mRotationCenterY;
                this.f10846k = this.mRotationCenterX;
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f10845j = (ConstraintLayout) getParent();
        if (this.mApplyVisibilityOnAttach || this.mApplyElevationOnAttach) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i11 = 0; i11 < this.f11095c; i11++) {
                View viewById = this.f10845j.getViewById(this.f11094b[i11]);
                if (viewById != null) {
                    if (this.mApplyVisibilityOnAttach) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.mApplyElevationOnAttach && elevation > 0.0f) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public void setElevation(float f11) {
        super.setElevation(f11);
        a();
    }

    public void setPivotX(float f11) {
        this.mRotationCenterX = f11;
        transform();
    }

    public void setPivotY(float f11) {
        this.mRotationCenterY = f11;
        transform();
    }

    public void setRotation(float f11) {
        this.mGroupRotateAngle = f11;
        transform();
    }

    public void setScaleX(float f11) {
        this.mScaleX = f11;
        transform();
    }

    public void setScaleY(float f11) {
        this.mScaleY = f11;
        transform();
    }

    public void setTranslationX(float f11) {
        this.mShiftX = f11;
        transform();
    }

    public void setTranslationY(float f11) {
        this.mShiftY = f11;
        transform();
    }

    public void setVisibility(int i11) {
        super.setVisibility(i11);
        a();
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
        reCacheViews();
        this.f10846k = Float.NaN;
        this.f10847l = Float.NaN;
        ConstraintWidget constraintWidget = ((ConstraintLayout.LayoutParams) getLayoutParams()).getConstraintWidget();
        constraintWidget.setWidth(0);
        constraintWidget.setHeight(0);
        f();
        layout(((int) this.f10850o) - getPaddingLeft(), ((int) this.f10851p) - getPaddingTop(), ((int) this.f10848m) + getPaddingRight(), ((int) this.f10849n) + getPaddingBottom());
        transform();
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
        this.f10845j = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.mGroupRotateAngle = rotation;
        } else if (!Float.isNaN(this.mGroupRotateAngle)) {
            this.mGroupRotateAngle = rotation;
        }
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Layer(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
