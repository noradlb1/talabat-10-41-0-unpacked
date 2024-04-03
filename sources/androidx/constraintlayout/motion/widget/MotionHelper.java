package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

public class MotionHelper extends ConstraintHelper implements MotionHelperInterface {

    /* renamed from: j  reason: collision with root package name */
    public View[] f10915j;
    private float mProgress;
    private boolean mUseOnHide = false;
    private boolean mUseOnShow = false;

    public MotionHelper(Context context) {
        super(context);
    }

    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.MotionHelper_onShow) {
                    this.mUseOnShow = obtainStyledAttributes.getBoolean(index, this.mUseOnShow);
                } else if (index == R.styleable.MotionHelper_onHide) {
                    this.mUseOnHide = obtainStyledAttributes.getBoolean(index, this.mUseOnHide);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public float getProgress() {
        return this.mProgress;
    }

    public boolean isDecorator() {
        return false;
    }

    public boolean isUseOnHide() {
        return this.mUseOnHide;
    }

    public boolean isUsedOnShow() {
        return this.mUseOnShow;
    }

    public void onFinishedMotionScene(MotionLayout motionLayout) {
    }

    public void onPostDraw(Canvas canvas) {
    }

    public void onPreDraw(Canvas canvas) {
    }

    public void onPreSetup(MotionLayout motionLayout, HashMap<View, MotionController> hashMap) {
    }

    public void onTransitionChange(MotionLayout motionLayout, int i11, int i12, float f11) {
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i11) {
    }

    public void onTransitionStarted(MotionLayout motionLayout, int i11, int i12) {
    }

    public void onTransitionTrigger(MotionLayout motionLayout, int i11, boolean z11, float f11) {
    }

    public void setProgress(float f11) {
        this.mProgress = f11;
        int i11 = 0;
        if (this.f11095c > 0) {
            this.f10915j = d((ConstraintLayout) getParent());
            while (i11 < this.f11095c) {
                setProgress(this.f10915j[i11], f11);
                i11++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i11 < childCount) {
            View childAt = viewGroup.getChildAt(i11);
            if (!(childAt instanceof MotionHelper)) {
                setProgress(childAt, f11);
            }
            i11++;
        }
    }

    public void setProgress(View view, float f11) {
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        e(attributeSet);
    }
}
