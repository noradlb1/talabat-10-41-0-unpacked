package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class FlexLine {
    boolean mAnyItemsHaveFlexGrow;
    boolean mAnyItemsHaveFlexShrink;
    int mBottom = Integer.MIN_VALUE;
    int mCrossSize;
    int mDividerLengthInMainSize;
    int mFirstIndex;
    int mGoneItemCount;
    List<Integer> mIndicesAlignSelfStretch = new ArrayList();
    int mItemCount;
    int mLastIndex;
    int mLeft = Integer.MAX_VALUE;
    int mMainSize;
    int mMaxBaseline;
    int mRight = Integer.MIN_VALUE;
    int mSumCrossSizeBefore;
    int mTop = Integer.MAX_VALUE;
    float mTotalFlexGrow;
    float mTotalFlexShrink;

    public int getCrossSize() {
        return this.mCrossSize;
    }

    public int getFirstIndex() {
        return this.mFirstIndex;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int getItemCountNotGone() {
        return this.mItemCount - this.mGoneItemCount;
    }

    public int getMainSize() {
        return this.mMainSize;
    }

    public float getTotalFlexGrow() {
        return this.mTotalFlexGrow;
    }

    public float getTotalFlexShrink() {
        return this.mTotalFlexShrink;
    }

    public void updatePositionFromView(View view, int i11, int i12, int i13, int i14) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.mLeft = Math.min(this.mLeft, (view.getLeft() - flexItem.getMarginLeft()) - i11);
        this.mTop = Math.min(this.mTop, (view.getTop() - flexItem.getMarginTop()) - i12);
        this.mRight = Math.max(this.mRight, view.getRight() + flexItem.getMarginRight() + i13);
        this.mBottom = Math.max(this.mBottom, view.getBottom() + flexItem.getMarginBottom() + i14);
    }
}
