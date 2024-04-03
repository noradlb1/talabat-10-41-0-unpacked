package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public static class AnchorInfo {
        int mCoordinate;
        boolean mLayoutFromEnd;
        OrientationHelper mOrientationHelper;
        int mPosition;
        boolean mValid;

        public AnchorInfo() {
            reset();
        }

        public void assignCoordinateFromPadding() {
            int i11;
            if (this.mLayoutFromEnd) {
                i11 = this.mOrientationHelper.getEndAfterPadding();
            } else {
                i11 = this.mOrientationHelper.getStartAfterPadding();
            }
            this.mCoordinate = i11;
        }

        public void assignFromView(View view, int i11) {
            if (this.mLayoutFromEnd) {
                this.mCoordinate = this.mOrientationHelper.getDecoratedEnd(view) + this.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = i11;
        }

        public void assignFromViewAndKeepVisibleRect(View view, int i11) {
            int totalSpaceChange = this.mOrientationHelper.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                assignFromView(view, i11);
                return;
            }
            this.mPosition = i11;
            if (this.mLayoutFromEnd) {
                int endAfterPadding = (this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - this.mOrientationHelper.getDecoratedEnd(view);
                this.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    int decoratedMeasurement = this.mCoordinate - this.mOrientationHelper.getDecoratedMeasurement(view);
                    int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                    int min = decoratedMeasurement - (startAfterPadding + Math.min(this.mOrientationHelper.getDecoratedStart(view) - startAfterPadding, 0));
                    if (min < 0) {
                        this.mCoordinate += Math.min(endAfterPadding, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(view);
            int startAfterPadding2 = decoratedStart - this.mOrientationHelper.getStartAfterPadding();
            this.mCoordinate = decoratedStart;
            if (startAfterPadding2 > 0) {
                int endAfterPadding2 = (this.mOrientationHelper.getEndAfterPadding() - Math.min(0, (this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - this.mOrientationHelper.getDecoratedEnd(view))) - (decoratedStart + this.mOrientationHelper.getDecoratedMeasurement(view));
                if (endAfterPadding2 < 0) {
                    this.mCoordinate -= Math.min(startAfterPadding2, -endAfterPadding2);
                }
            }
        }

        public boolean isViewValidAsAnchor(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (layoutParams.isItemRemoved() || layoutParams.getViewLayoutPosition() < 0 || layoutParams.getViewLayoutPosition() >= state.getItemCount()) {
                return false;
            }
            return true;
        }

        public void reset() {
            this.mPosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mValid = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        public void resetInternal() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    public static class LayoutState {
        static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        static final int ITEM_DIRECTION_HEAD = -1;
        static final int ITEM_DIRECTION_TAIL = 1;
        static final int LAYOUT_END = 1;
        static final int LAYOUT_START = -1;
        static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
        static final String TAG = "LLM#LayoutState";
        int mAvailable;
        int mCurrentPosition;
        int mExtraFillSpace = 0;
        boolean mInfinite;
        boolean mIsPreLayout = false;
        int mItemDirection;
        int mLastScrollDelta;
        int mLayoutDirection;
        int mNoRecycleSpace = 0;
        int mOffset;
        boolean mRecycle = true;
        List<RecyclerView.ViewHolder> mScrapList = null;
        int mScrollingOffset;

        private View nextViewFromScrapList() {
            int size = this.mScrapList.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = this.mScrapList.get(i11).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.isItemRemoved() && this.mCurrentPosition == layoutParams.getViewLayoutPosition()) {
                    assignPositionFromScrapList(view);
                    return view;
                }
            }
            return null;
        }

        public void assignPositionFromScrapList() {
            assignPositionFromScrapList((View) null);
        }

        public boolean hasMore(RecyclerView.State state) {
            int i11 = this.mCurrentPosition;
            return i11 >= 0 && i11 < state.getItemCount();
        }

        public void log() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("avail:");
            sb2.append(this.mAvailable);
            sb2.append(", ind:");
            sb2.append(this.mCurrentPosition);
            sb2.append(", dir:");
            sb2.append(this.mItemDirection);
            sb2.append(", offset:");
            sb2.append(this.mOffset);
            sb2.append(", layoutDir:");
            sb2.append(this.mLayoutDirection);
        }

        public View next(RecyclerView.Recycler recycler) {
            if (this.mScrapList != null) {
                return nextViewFromScrapList();
            }
            View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return viewForPosition;
        }

        public View nextViewInLimitedList(View view) {
            int viewLayoutPosition;
            int size = this.mScrapList.size();
            View view2 = null;
            int i11 = Integer.MAX_VALUE;
            for (int i12 = 0; i12 < size; i12++) {
                View view3 = this.mScrapList.get(i12).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.isItemRemoved() && (viewLayoutPosition = (layoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection) >= 0 && viewLayoutPosition < i11) {
                    view2 = view3;
                    if (viewLayoutPosition == 0) {
                        break;
                    }
                    i11 = viewLayoutPosition;
                }
            }
            return view2;
        }

        public void assignPositionFromScrapList(View view) {
            View nextViewInLimitedList = nextViewInLimitedList(view);
            if (nextViewInLimitedList == null) {
                this.mCurrentPosition = -1;
            } else {
                this.mCurrentPosition = ((RecyclerView.LayoutParams) nextViewInLimitedList.getLayoutParams()).getViewLayoutPosition();
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        };
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public boolean hasValidAnchor() {
            return this.mAnchorPosition >= 0;
        }

        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            this.mAnchorLayoutFromEnd = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return ScrollbarHelper.computeScrollExtent(state, orientationHelper, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return ScrollbarHelper.computeScrollOffset(state, orientationHelper, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return ScrollbarHelper.computeScrollRange(state, orientationHelper, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild();
        }
        return findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild();
        }
        return findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private int fixLayoutEndGap(int i11, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z11) {
        int endAfterPadding;
        int endAfterPadding2 = this.mOrientationHelper.getEndAfterPadding() - i11;
        if (endAfterPadding2 <= 0) {
            return 0;
        }
        int i12 = -scrollBy(-endAfterPadding2, recycler, state);
        int i13 = i11 + i12;
        if (!z11 || (endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - i13) <= 0) {
            return i12;
        }
        this.mOrientationHelper.offsetChildren(endAfterPadding);
        return endAfterPadding + i12;
    }

    private int fixLayoutStartGap(int i11, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z11) {
        int startAfterPadding;
        int startAfterPadding2 = i11 - this.mOrientationHelper.getStartAfterPadding();
        if (startAfterPadding2 <= 0) {
            return 0;
        }
        int i12 = -scrollBy(startAfterPadding2, recycler, state);
        int i13 = i11 + i12;
        if (!z11 || (startAfterPadding = i13 - this.mOrientationHelper.getStartAfterPadding()) <= 0) {
            return i12;
        }
        this.mOrientationHelper.offsetChildren(-startAfterPadding);
        return i12 - startAfterPadding;
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler recycler, RecyclerView.State state, int i11, int i12) {
        boolean z11;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        if (state.willRunPredictiveAnimations() && getChildCount() != 0 && !state.isPreLayout() && supportsPredictiveItemAnimations()) {
            List<RecyclerView.ViewHolder> scrapList = recycler.getScrapList();
            int size = scrapList.size();
            int position = getPosition(getChildAt(0));
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < size; i15++) {
                RecyclerView.ViewHolder viewHolder = scrapList.get(i15);
                if (!viewHolder.isRemoved()) {
                    boolean z12 = true;
                    if (viewHolder.getLayoutPosition() < position) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11 != this.mShouldReverseLayout) {
                        z12 = true;
                    }
                    if (z12) {
                        i13 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                    } else {
                        i14 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                    }
                }
            }
            this.mLayoutState.mScrapList = scrapList;
            if (i13 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i11);
                LayoutState layoutState = this.mLayoutState;
                layoutState.mExtraFillSpace = i13;
                layoutState.mAvailable = 0;
                layoutState.assignPositionFromScrapList();
                fill(recycler2, this.mLayoutState, state2, false);
            }
            if (i14 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i12);
                LayoutState layoutState2 = this.mLayoutState;
                layoutState2.mExtraFillSpace = i14;
                layoutState2.mAvailable = 0;
                layoutState2.assignPositionFromScrapList();
                fill(recycler2, this.mLayoutState, state2, false);
            }
            this.mLayoutState.mScrapList = null;
        }
    }

    private void logChildren() {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("item ");
            sb2.append(getPosition(childAt));
            sb2.append(", coord:");
            sb2.append(this.mOrientationHelper.getDecoratedStart(childAt));
        }
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.mRecycle && !layoutState.mInfinite) {
            int i11 = layoutState.mScrollingOffset;
            int i12 = layoutState.mNoRecycleSpace;
            if (layoutState.mLayoutDirection == -1) {
                recycleViewsFromEnd(recycler, i11, i12);
            } else {
                recycleViewsFromStart(recycler, i11, i12);
            }
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i11, int i12) {
        if (i11 != i12) {
            if (i12 > i11) {
                for (int i13 = i12 - 1; i13 >= i11; i13--) {
                    removeAndRecycleViewAt(i13, recycler);
                }
                return;
            }
            while (i11 > i12) {
                removeAndRecycleViewAt(i11, recycler);
                i11--;
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler recycler, int i11, int i12) {
        int childCount = getChildCount();
        if (i11 >= 0) {
            int end = (this.mOrientationHelper.getEnd() - i11) + i12;
            if (this.mShouldReverseLayout) {
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt = getChildAt(i13);
                    if (this.mOrientationHelper.getDecoratedStart(childAt) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt) < end) {
                        recycleChildren(recycler, 0, i13);
                        return;
                    }
                }
                return;
            }
            int i14 = childCount - 1;
            for (int i15 = i14; i15 >= 0; i15--) {
                View childAt2 = getChildAt(i15);
                if (this.mOrientationHelper.getDecoratedStart(childAt2) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt2) < end) {
                    recycleChildren(recycler, i14, i15);
                    return;
                }
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.Recycler recycler, int i11, int i12) {
        if (i11 >= 0) {
            int i13 = i11 - i12;
            int childCount = getChildCount();
            if (this.mShouldReverseLayout) {
                int i14 = childCount - 1;
                for (int i15 = i14; i15 >= 0; i15--) {
                    View childAt = getChildAt(i15);
                    if (this.mOrientationHelper.getDecoratedEnd(childAt) > i13 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt) > i13) {
                        recycleChildren(recycler, i14, i15);
                        return;
                    }
                }
                return;
            }
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt2 = getChildAt(i16);
                if (this.mOrientationHelper.getDecoratedEnd(childAt2) > i13 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt2) > i13) {
                    recycleChildren(recycler, 0, i16);
                    return;
                }
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        View findReferenceChild;
        boolean z11;
        boolean z12 = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild == null || !anchorInfo.isViewValidAsAnchor(focusedChild, state)) {
            boolean z13 = this.mLastStackFromEnd;
            boolean z14 = this.mStackFromEnd;
            if (z13 != z14 || (findReferenceChild = findReferenceChild(recycler, state, anchorInfo.mLayoutFromEnd, z14)) == null) {
                return false;
            }
            anchorInfo.assignFromView(findReferenceChild, getPosition(findReferenceChild));
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                int decoratedStart = this.mOrientationHelper.getDecoratedStart(findReferenceChild);
                int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(findReferenceChild);
                int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
                if (decoratedEnd > startAfterPadding || decoratedStart >= startAfterPadding) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (decoratedStart >= endAfterPadding && decoratedEnd > endAfterPadding) {
                    z12 = true;
                }
                if (z11 || z12) {
                    if (anchorInfo.mLayoutFromEnd) {
                        startAfterPadding = endAfterPadding;
                    }
                    anchorInfo.mCoordinate = startAfterPadding;
                }
            }
            return true;
        }
        anchorInfo.assignFromViewAndKeepVisibleRect(focusedChild, getPosition(focusedChild));
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i11;
        boolean z11;
        int i12;
        boolean z12 = false;
        if (!state.isPreLayout() && (i11 = this.mPendingScrollPosition) != -1) {
            if (i11 < 0 || i11 >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                anchorInfo.mPosition = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.hasValidAnchor()) {
                    boolean z13 = this.mPendingSavedState.mAnchorLayoutFromEnd;
                    anchorInfo.mLayoutFromEnd = z13;
                    if (z13) {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
                    } else {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
                    }
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition == null) {
                        if (getChildCount() > 0) {
                            if (this.mPendingScrollPosition < getPosition(getChildAt(0))) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z11 == this.mShouldReverseLayout) {
                                z12 = true;
                            }
                            anchorInfo.mLayoutFromEnd = z12;
                        }
                        anchorInfo.assignCoordinateFromPadding();
                    } else if (this.mOrientationHelper.getDecoratedMeasurement(findViewByPosition) > this.mOrientationHelper.getTotalSpace()) {
                        anchorInfo.assignCoordinateFromPadding();
                        return true;
                    } else if (this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                        anchorInfo.mLayoutFromEnd = false;
                        return true;
                    } else if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition) < 0) {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                        anchorInfo.mLayoutFromEnd = true;
                        return true;
                    } else {
                        if (anchorInfo.mLayoutFromEnd) {
                            i12 = this.mOrientationHelper.getDecoratedEnd(findViewByPosition) + this.mOrientationHelper.getTotalSpaceChange();
                        } else {
                            i12 = this.mOrientationHelper.getDecoratedStart(findViewByPosition);
                        }
                        anchorInfo.mCoordinate = i12;
                    }
                    return true;
                } else {
                    boolean z14 = this.mShouldReverseLayout;
                    anchorInfo.mLayoutFromEnd = z14;
                    if (z14) {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
                    } else {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        int i11;
        if (!updateAnchorFromPendingData(state, anchorInfo) && !updateAnchorFromChildren(recycler, state, anchorInfo)) {
            anchorInfo.assignCoordinateFromPadding();
            if (this.mStackFromEnd) {
                i11 = state.getItemCount() - 1;
            } else {
                i11 = 0;
            }
            anchorInfo.mPosition = i11;
        }
    }

    private void updateLayoutState(int i11, int i12, boolean z11, RecyclerView.State state) {
        int i13;
        int i14;
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mLayoutDirection = i11;
        int[] iArr = this.mReusableIntPair;
        boolean z12 = false;
        iArr[0] = 0;
        int i15 = 1;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        if (i11 == 1) {
            z12 = true;
        }
        LayoutState layoutState = this.mLayoutState;
        if (z12) {
            i13 = max2;
        } else {
            i13 = max;
        }
        layoutState.mExtraFillSpace = i13;
        if (!z12) {
            max = max2;
        }
        layoutState.mNoRecycleSpace = max;
        if (z12) {
            layoutState.mExtraFillSpace = i13 + this.mOrientationHelper.getEndPadding();
            View childClosestToEnd = getChildClosestToEnd();
            LayoutState layoutState2 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i15 = -1;
            }
            layoutState2.mItemDirection = i15;
            int position = getPosition(childClosestToEnd);
            LayoutState layoutState3 = this.mLayoutState;
            layoutState2.mCurrentPosition = position + layoutState3.mItemDirection;
            layoutState3.mOffset = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
            i14 = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd) - this.mOrientationHelper.getEndAfterPadding();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.mExtraFillSpace += this.mOrientationHelper.getStartAfterPadding();
            LayoutState layoutState4 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i15 = -1;
            }
            layoutState4.mItemDirection = i15;
            int position2 = getPosition(childClosestToStart);
            LayoutState layoutState5 = this.mLayoutState;
            layoutState4.mCurrentPosition = position2 + layoutState5.mItemDirection;
            layoutState5.mOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart);
            i14 = (-this.mOrientationHelper.getDecoratedStart(childClosestToStart)) + this.mOrientationHelper.getStartAfterPadding();
        }
        LayoutState layoutState6 = this.mLayoutState;
        layoutState6.mAvailable = i12;
        if (z11) {
            layoutState6.mAvailable = i12 - i14;
        }
        layoutState6.mScrollingOffset = i14;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo) {
        updateLayoutStateToFillEnd(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo) {
        updateLayoutStateToFillStart(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
        int i11;
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.mLayoutState.mLayoutDirection == -1) {
            i11 = 0;
        } else {
            i11 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i11;
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public void collectAdjacentPrefetchPositions(int i11, int i12, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i13;
        if (this.mOrientation != 0) {
            i11 = i12;
        }
        if (getChildCount() != 0 && i11 != 0) {
            ensureLayoutState();
            if (i11 > 0) {
                i13 = 1;
            } else {
                i13 = -1;
            }
            updateLayoutState(i13, Math.abs(i11), true, state);
            collectPrefetchPositionsForLayoutState(state, this.mLayoutState, layoutPrefetchRegistry);
        }
    }

    public void collectInitialPrefetchPositions(int i11, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z11;
        int i12;
        SavedState savedState = this.mPendingSavedState;
        int i13 = -1;
        if (savedState == null || !savedState.hasValidAnchor()) {
            resolveShouldLayoutReverse();
            z11 = this.mShouldReverseLayout;
            i12 = this.mPendingScrollPosition;
            if (i12 == -1) {
                if (z11) {
                    i12 = i11 - 1;
                } else {
                    i12 = 0;
                }
            }
        } else {
            SavedState savedState2 = this.mPendingSavedState;
            z11 = savedState2.mAnchorLayoutFromEnd;
            i12 = savedState2.mAnchorPosition;
        }
        if (!z11) {
            i13 = 1;
        }
        for (int i14 = 0; i14 < this.mInitialPrefetchItemCount && i12 >= 0 && i12 < i11; i14++) {
            layoutPrefetchRegistry.addPosition(i12, 0);
            i12 += i13;
        }
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i11 = layoutState.mCurrentPosition;
        if (i11 >= 0 && i11 < state.getItemCount()) {
            layoutPrefetchRegistry.addPosition(i11, Math.max(0, layoutState.mScrollingOffset));
        }
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public PointF computeScrollVectorForPosition(int i11) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z11 = false;
        int i12 = 1;
        if (i11 < getPosition(getChildAt(0))) {
            z11 = true;
        }
        if (z11 != this.mShouldReverseLayout) {
            i12 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i12, 0.0f);
        }
        return new PointF(0.0f, (float) i12);
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public int convertFocusDirectionToLayoutDirection(int i11) {
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 17) {
                    if (i11 != 33) {
                        if (i11 != 66) {
                            if (i11 != 130) {
                                return Integer.MIN_VALUE;
                            }
                            if (this.mOrientation == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        } else if (this.mOrientation == 0) {
                            return 1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else if (this.mOrientation == 1) {
                        return -1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.mOrientation == 0) {
                    return -1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.mOrientation != 1 && isLayoutRTL()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.mOrientation != 1 && isLayoutRTL()) {
            return 1;
        } else {
            return -1;
        }
    }

    public LayoutState createLayoutState() {
        return new LayoutState();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z11) {
        int i11 = layoutState.mAvailable;
        int i12 = layoutState.mScrollingOffset;
        if (i12 != Integer.MIN_VALUE) {
            if (i11 < 0) {
                layoutState.mScrollingOffset = i12 + i11;
            }
            recycleByLayoutState(recycler, layoutState);
        }
        int i13 = layoutState.mAvailable + layoutState.mExtraFillSpace;
        LayoutChunkResult layoutChunkResult = this.mLayoutChunkResult;
        while (true) {
            if ((!layoutState.mInfinite && i13 <= 0) || !layoutState.hasMore(state)) {
                break;
            }
            layoutChunkResult.resetInternal();
            layoutChunk(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                layoutState.mOffset += layoutChunkResult.mConsumed * layoutState.mLayoutDirection;
                if (!layoutChunkResult.mIgnoreConsumed || layoutState.mScrapList != null || !state.isPreLayout()) {
                    int i14 = layoutState.mAvailable;
                    int i15 = layoutChunkResult.mConsumed;
                    layoutState.mAvailable = i14 - i15;
                    i13 -= i15;
                }
                int i16 = layoutState.mScrollingOffset;
                if (i16 != Integer.MIN_VALUE) {
                    int i17 = i16 + layoutChunkResult.mConsumed;
                    layoutState.mScrollingOffset = i17;
                    int i18 = layoutState.mAvailable;
                    if (i18 < 0) {
                        layoutState.mScrollingOffset = i17 + i18;
                    }
                    recycleByLayoutState(recycler, layoutState);
                }
                if (z11 && layoutChunkResult.mFocusable) {
                    break;
                }
            } else {
                break;
            }
        }
        return i11 - layoutState.mAvailable;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z11, boolean z12) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z11, z12);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z11, z12);
    }

    public View findFirstVisibleChildClosestToStart(boolean z11, boolean z12) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z11, z12);
        }
        return findOneVisibleChild(0, getChildCount(), z11, z12);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i11, int i12) {
        char c11;
        int i13;
        int i14;
        ensureLayoutState();
        if (i12 > i11) {
            c11 = 1;
        } else if (i12 < i11) {
            c11 = 65535;
        } else {
            c11 = 0;
        }
        if (c11 == 0) {
            return getChildAt(i11);
        }
        if (this.mOrientationHelper.getDecoratedStart(getChildAt(i11)) < this.mOrientationHelper.getStartAfterPadding()) {
            i14 = 16644;
            i13 = 16388;
        } else {
            i14 = 4161;
            i13 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(i11, i12, i14, i13);
        }
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(i11, i12, i14, i13);
    }

    public View findOneVisibleChild(int i11, int i12, boolean z11, boolean z12) {
        int i13;
        ensureLayoutState();
        int i14 = 320;
        if (z11) {
            i13 = 24579;
        } else {
            i13 = 320;
        }
        if (!z12) {
            i14 = 0;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(i11, i12, i13, i14);
        }
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(i11, i12, i13, i14);
    }

    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z11, boolean z12) {
        int i11;
        int i12;
        int i13;
        boolean z13;
        boolean z14;
        ensureLayoutState();
        int childCount = getChildCount();
        if (z12) {
            i13 = getChildCount() - 1;
            i12 = -1;
            i11 = -1;
        } else {
            i12 = childCount;
            i13 = 0;
            i11 = 1;
        }
        int itemCount = state.getItemCount();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i13 != i12) {
            View childAt = getChildAt(i13);
            int position = getPosition(childAt);
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(childAt);
            int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(childAt);
            if (position >= 0 && position < itemCount) {
                if (!((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (decoratedEnd > startAfterPadding || decoratedStart >= startAfterPadding) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    if (decoratedStart < endAfterPadding || decoratedEnd <= endAfterPadding) {
                        z14 = false;
                    } else {
                        z14 = true;
                    }
                    if (!z13 && !z14) {
                        return childAt;
                    }
                    if (z11) {
                        if (!z14) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                    } else if (!z13) {
                        if (view != null) {
                        }
                        view = childAt;
                    }
                    view2 = childAt;
                } else if (view3 == null) {
                    view3 = childAt;
                }
            }
            i13 += i11;
        }
        if (view != null) {
            return view;
        }
        if (view2 != null) {
            return view2;
        }
        return view3;
    }

    public View findViewByPosition(int i11) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i11 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i11) {
                return childAt;
            }
        }
        return super.findViewByPosition(i11);
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.State state) {
        if (state.hasTargetScrollPosition()) {
            return this.mOrientationHelper.getTotalSpace();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z11;
        boolean z12;
        View next = layoutState.next(recycler);
        if (next == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) next.getLayoutParams();
        if (layoutState.mScrapList == null) {
            boolean z13 = this.mShouldReverseLayout;
            if (layoutState.mLayoutDirection == -1) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z13 == z12) {
                addView(next);
            } else {
                addView(next, 0);
            }
        } else {
            boolean z14 = this.mShouldReverseLayout;
            if (layoutState.mLayoutDirection == -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z14 == z11) {
                addDisappearingView(next);
            } else {
                addDisappearingView(next, 0);
            }
        }
        measureChildWithMargins(next, 0, 0);
        layoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(next);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                i15 = getWidth() - getPaddingRight();
                i14 = i15 - this.mOrientationHelper.getDecoratedMeasurementInOther(next);
            } else {
                i14 = getPaddingLeft();
                i15 = this.mOrientationHelper.getDecoratedMeasurementInOther(next) + i14;
            }
            if (layoutState.mLayoutDirection == -1) {
                int i16 = layoutState.mOffset;
                i11 = i16;
                i12 = i15;
                i13 = i16 - layoutChunkResult.mConsumed;
            } else {
                int i17 = layoutState.mOffset;
                i13 = i17;
                i12 = i15;
                i11 = layoutChunkResult.mConsumed + i17;
            }
        } else {
            int paddingTop = getPaddingTop();
            int decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(next) + paddingTop;
            if (layoutState.mLayoutDirection == -1) {
                int i18 = layoutState.mOffset;
                i12 = i18;
                i13 = paddingTop;
                i11 = decoratedMeasurementInOther;
                i14 = i18 - layoutChunkResult.mConsumed;
            } else {
                int i19 = layoutState.mOffset;
                i13 = paddingTop;
                i12 = layoutChunkResult.mConsumed + i19;
                i11 = decoratedMeasurementInOther;
                i14 = i19;
            }
        }
        layoutDecoratedWithMargins(next, i14, i13, i12, i11);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = next.hasFocusable();
    }

    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int i11) {
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    public View onFocusSearchFailed(View view, int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirection;
        View view2;
        View view3;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i11)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (((float) this.mOrientationHelper.getTotalSpace()) * MAX_SCROLL_FACTOR), false, state);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mScrollingOffset = Integer.MIN_VALUE;
        layoutState.mRecycle = false;
        fill(recycler, layoutState, state, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            view3 = getChildClosestToStart();
        } else {
            view3 = getChildClosestToEnd();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        View findViewByPosition;
        int i18;
        int i19;
        int i21 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        ensureLayoutState();
        this.mLayoutState.mRecycle = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (!anchorInfo.mValid || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            anchorInfo.reset();
            AnchorInfo anchorInfo2 = this.mAnchorInfo;
            anchorInfo2.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(recycler, state, anchorInfo2);
            this.mAnchorInfo.mValid = true;
        } else if (focusedChild != null && (this.mOrientationHelper.getDecoratedStart(focusedChild) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(focusedChild) <= this.mOrientationHelper.getStartAfterPadding())) {
            this.mAnchorInfo.assignFromViewAndKeepVisibleRect(focusedChild, getPosition(focusedChild));
        }
        LayoutState layoutState = this.mLayoutState;
        if (layoutState.mLastScrollDelta >= 0) {
            i11 = 1;
        } else {
            i11 = -1;
        }
        layoutState.mLayoutDirection = i11;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.getStartAfterPadding();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.getEndPadding();
        if (!(!state.isPreLayout() || (i17 = this.mPendingScrollPosition) == -1 || this.mPendingScrollPositionOffset == Integer.MIN_VALUE || (findViewByPosition = findViewByPosition(i17)) == null)) {
            if (this.mShouldReverseLayout) {
                i18 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition);
                i19 = this.mPendingScrollPositionOffset;
            } else {
                i19 = this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding();
                i18 = this.mPendingScrollPositionOffset;
            }
            int i22 = i18 - i19;
            if (i22 > 0) {
                max += i22;
            } else {
                max2 -= i22;
            }
        }
        AnchorInfo anchorInfo3 = this.mAnchorInfo;
        if (!anchorInfo3.mLayoutFromEnd ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i21 = 1;
        }
        onAnchorReady(recycler, state, anchorInfo3, i21);
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mIsPreLayout = state.isPreLayout();
        this.mLayoutState.mNoRecycleSpace = 0;
        AnchorInfo anchorInfo4 = this.mAnchorInfo;
        if (anchorInfo4.mLayoutFromEnd) {
            updateLayoutStateToFillStart(anchorInfo4);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mExtraFillSpace = max;
            fill(recycler, layoutState2, state, false);
            LayoutState layoutState3 = this.mLayoutState;
            i13 = layoutState3.mOffset;
            int i23 = layoutState3.mCurrentPosition;
            int i24 = layoutState3.mAvailable;
            if (i24 > 0) {
                max2 += i24;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            LayoutState layoutState4 = this.mLayoutState;
            layoutState4.mExtraFillSpace = max2;
            layoutState4.mCurrentPosition += layoutState4.mItemDirection;
            fill(recycler, layoutState4, state, false);
            LayoutState layoutState5 = this.mLayoutState;
            i12 = layoutState5.mOffset;
            int i25 = layoutState5.mAvailable;
            if (i25 > 0) {
                updateLayoutStateToFillStart(i23, i13);
                LayoutState layoutState6 = this.mLayoutState;
                layoutState6.mExtraFillSpace = i25;
                fill(recycler, layoutState6, state, false);
                i13 = this.mLayoutState.mOffset;
            }
        } else {
            updateLayoutStateToFillEnd(anchorInfo4);
            LayoutState layoutState7 = this.mLayoutState;
            layoutState7.mExtraFillSpace = max2;
            fill(recycler, layoutState7, state, false);
            LayoutState layoutState8 = this.mLayoutState;
            i12 = layoutState8.mOffset;
            int i26 = layoutState8.mCurrentPosition;
            int i27 = layoutState8.mAvailable;
            if (i27 > 0) {
                max += i27;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            LayoutState layoutState9 = this.mLayoutState;
            layoutState9.mExtraFillSpace = max;
            layoutState9.mCurrentPosition += layoutState9.mItemDirection;
            fill(recycler, layoutState9, state, false);
            LayoutState layoutState10 = this.mLayoutState;
            i13 = layoutState10.mOffset;
            int i28 = layoutState10.mAvailable;
            if (i28 > 0) {
                updateLayoutStateToFillEnd(i26, i12);
                LayoutState layoutState11 = this.mLayoutState;
                layoutState11.mExtraFillSpace = i28;
                fill(recycler, layoutState11, state, false);
                i12 = this.mLayoutState.mOffset;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap = fixLayoutEndGap(i12, recycler, state, true);
                i15 = i13 + fixLayoutEndGap;
                i14 = i12 + fixLayoutEndGap;
                i16 = fixLayoutStartGap(i15, recycler, state, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i13, recycler, state, true);
                i15 = i13 + fixLayoutStartGap;
                i14 = i12 + fixLayoutStartGap;
                i16 = fixLayoutEndGap(i14, recycler, state, false);
            }
            i13 = i15 + i16;
            i12 = i14 + i16;
        }
        layoutForPredictiveAnimations(recycler, state, i13, i12);
        if (!state.isPreLayout()) {
            this.mOrientationHelper.onLayoutComplete();
        } else {
            this.mAnchorInfo.reset();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.reset();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.invalidateAnchor();
            }
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z11 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.mAnchorLayoutFromEnd = z11;
            if (z11) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
                savedState.mAnchorPosition = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState.mAnchorPosition = getPosition(childClosestToStart);
                savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
            }
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    public void prepareForDrop(@NonNull View view, @NonNull View view2, int i11, int i12) {
        boolean z11;
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        if (position < position2) {
            z11 = true;
        } else {
            z11 = true;
        }
        if (this.mShouldReverseLayout) {
            if (z11) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(view2) + this.mOrientationHelper.getDecoratedMeasurement(view)));
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view2));
            }
        } else if (z11) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedEnd(view2) - this.mOrientationHelper.getDecoratedMeasurement(view));
        }
    }

    public boolean resolveIsInfinite() {
        if (this.mOrientationHelper.getMode() == 0 && this.mOrientationHelper.getEnd() == 0) {
            return true;
        }
        return false;
    }

    public int scrollBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i12;
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.mRecycle = true;
        if (i11 > 0) {
            i12 = 1;
        } else {
            i12 = -1;
        }
        int abs = Math.abs(i11);
        updateLayoutState(i12, abs, true, state);
        LayoutState layoutState = this.mLayoutState;
        int fill = layoutState.mScrollingOffset + fill(recycler, layoutState, state, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i11 = i12 * fill;
        }
        this.mOrientationHelper.offsetChildren(-i11);
        this.mLayoutState.mLastScrollDelta = i11;
        return i11;
    }

    public int scrollHorizontallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i11, recycler, state);
    }

    public void scrollToPosition(int i11) {
        this.mPendingScrollPosition = i11;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i11, int i12) {
        this.mPendingScrollPosition = i11;
        this.mPendingScrollPositionOffset = i12;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    public int scrollVerticallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i11, recycler, state);
    }

    public void setInitialPrefetchItemCount(int i11) {
        this.mInitialPrefetchItemCount = i11;
    }

    public void setOrientation(int i11) {
        if (i11 == 0 || i11 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i11 != this.mOrientation || this.mOrientationHelper == null) {
                OrientationHelper createOrientationHelper = OrientationHelper.createOrientationHelper(this, i11);
                this.mOrientationHelper = createOrientationHelper;
                this.mAnchorInfo.mOrientationHelper = createOrientationHelper;
                this.mOrientation = i11;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i11);
    }

    public void setRecycleChildrenOnDetach(boolean z11) {
        this.mRecycleChildrenOnDetach = z11;
    }

    public void setReverseLayout(boolean z11) {
        assertNotInLayoutOrScroll((String) null);
        if (z11 != this.mReverseLayout) {
            this.mReverseLayout = z11;
            requestLayout();
        }
    }

    public void setSmoothScrollbarEnabled(boolean z11) {
        this.mSmoothScrollbarEnabled = z11;
    }

    public void setStackFromEnd(boolean z11) {
        assertNotInLayoutOrScroll((String) null);
        if (this.mStackFromEnd != z11) {
            this.mStackFromEnd = z11;
            requestLayout();
        }
    }

    public boolean shouldMeasureTwice() {
        if (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) {
            return false;
        }
        return true;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i11) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i11);
        startSmoothScroll(linearSmoothScroller);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void validateChildOrder() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("validating child count ");
        sb2.append(getChildCount());
        boolean z11 = true;
        if (getChildCount() >= 1) {
            int position = getPosition(getChildAt(0));
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
            if (this.mShouldReverseLayout) {
                int i11 = 1;
                while (i11 < getChildCount()) {
                    View childAt = getChildAt(i11);
                    int position2 = getPosition(childAt);
                    int decoratedStart2 = this.mOrientationHelper.getDecoratedStart(childAt);
                    if (position2 < position) {
                        logChildren();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("detected invalid position. loc invalid? ");
                        if (decoratedStart2 >= decoratedStart) {
                            z11 = false;
                        }
                        sb3.append(z11);
                        throw new RuntimeException(sb3.toString());
                    } else if (decoratedStart2 <= decoratedStart) {
                        i11++;
                    } else {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    }
                }
                return;
            }
            int i12 = 1;
            while (i12 < getChildCount()) {
                View childAt2 = getChildAt(i12);
                int position3 = getPosition(childAt2);
                int decoratedStart3 = this.mOrientationHelper.getDecoratedStart(childAt2);
                if (position3 < position) {
                    logChildren();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("detected invalid position. loc invalid? ");
                    if (decoratedStart3 >= decoratedStart) {
                        z11 = false;
                    }
                    sb4.append(z11);
                    throw new RuntimeException(sb4.toString());
                } else if (decoratedStart3 >= decoratedStart) {
                    i12++;
                } else {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }

    public LinearLayoutManager(Context context, int i11, boolean z11) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i11);
        setReverseLayout(z11);
    }

    private void updateLayoutStateToFillEnd(int i11, int i12) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - i12;
        LayoutState layoutState = this.mLayoutState;
        layoutState.mItemDirection = this.mShouldReverseLayout ? -1 : 1;
        layoutState.mCurrentPosition = i11;
        layoutState.mLayoutDirection = 1;
        layoutState.mOffset = i12;
        layoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i11, int i12) {
        this.mLayoutState.mAvailable = i12 - this.mOrientationHelper.getStartAfterPadding();
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = i11;
        layoutState.mItemDirection = this.mShouldReverseLayout ? 1 : -1;
        layoutState.mLayoutDirection = -1;
        layoutState.mOffset = i12;
        layoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i11, i12);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
    }
}
