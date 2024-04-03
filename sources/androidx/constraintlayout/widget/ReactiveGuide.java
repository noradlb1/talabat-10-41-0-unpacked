package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.SharedValues;

public class ReactiveGuide extends View implements SharedValues.SharedValuesListener {
    private boolean mAnimateChange = false;
    private boolean mApplyToAllConstraintSets = true;
    private int mApplyToConstraintSetId = 0;
    private int mAttributeId = -1;

    public ReactiveGuide(Context context) {
        super(context);
        super.setVisibility(8);
        init((AttributeSet) null);
    }

    private void changeValue(int i11, int i12, MotionLayout motionLayout, int i13) {
        ConstraintSet constraintSet = motionLayout.getConstraintSet(i13);
        constraintSet.setGuidelineEnd(i12, i11);
        motionLayout.updateState(i13, constraintSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.mAttributeId = obtainStyledAttributes.getResourceId(index, this.mAttributeId);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.mAnimateChange = obtainStyledAttributes.getBoolean(index, this.mAnimateChange);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
                    this.mApplyToConstraintSetId = obtainStyledAttributes.getResourceId(index, this.mApplyToConstraintSetId);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
                    this.mApplyToAllConstraintSets = obtainStyledAttributes.getBoolean(index, this.mApplyToAllConstraintSets);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.mAttributeId != -1) {
            ConstraintLayout.getSharedValues().addListener(this.mAttributeId, this);
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.mApplyToConstraintSetId;
    }

    public int getAttributeId() {
        return this.mAttributeId;
    }

    public boolean isAnimatingChange() {
        return this.mAnimateChange;
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(0, 0);
    }

    public void onNewValue(int i11, int i12, int i13) {
        setGuidelineBegin(i12);
        int id2 = getId();
        if (id2 > 0 && (getParent() instanceof MotionLayout)) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            int currentState = motionLayout.getCurrentState();
            int i14 = this.mApplyToConstraintSetId;
            if (i14 != 0) {
                currentState = i14;
            }
            int i15 = 0;
            if (this.mAnimateChange) {
                if (this.mApplyToAllConstraintSets) {
                    int[] constraintSetIds = motionLayout.getConstraintSetIds();
                    while (i15 < constraintSetIds.length) {
                        int i16 = constraintSetIds[i15];
                        if (i16 != currentState) {
                            changeValue(i12, id2, motionLayout, i16);
                        }
                        i15++;
                    }
                }
                ConstraintSet cloneConstraintSet = motionLayout.cloneConstraintSet(currentState);
                cloneConstraintSet.setGuidelineEnd(id2, i12);
                motionLayout.updateStateAnimate(currentState, cloneConstraintSet, 1000);
            } else if (this.mApplyToAllConstraintSets) {
                int[] constraintSetIds2 = motionLayout.getConstraintSetIds();
                while (i15 < constraintSetIds2.length) {
                    changeValue(i12, id2, motionLayout, constraintSetIds2[i15]);
                    i15++;
                }
            } else {
                changeValue(i12, id2, motionLayout, currentState);
            }
        }
    }

    public void setAnimateChange(boolean z11) {
        this.mAnimateChange = z11;
    }

    public void setApplyToConstraintSetId(int i11) {
        this.mApplyToConstraintSetId = i11;
    }

    public void setAttributeId(int i11) {
        SharedValues sharedValues = ConstraintLayout.getSharedValues();
        int i12 = this.mAttributeId;
        if (i12 != -1) {
            sharedValues.removeListener(i12, this);
        }
        this.mAttributeId = i11;
        if (i11 != -1) {
            sharedValues.addListener(i11, this);
        }
    }

    public void setGuidelineBegin(int i11) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guideBegin = i11;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i11) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guideEnd = i11;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f11) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guidePercent = f11;
        setLayoutParams(layoutParams);
    }

    public void setVisibility(int i11) {
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
        init(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        super.setVisibility(8);
        init(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        super.setVisibility(8);
        init(attributeSet);
    }
}
