package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "StaggeredGridLManager";
    public static final int VERTICAL = 1;
    private final AnchorInfo mAnchorInfo = new AnchorInfo();
    private final Runnable mCheckForGapsRunnable = new Runnable() {
        public void run() {
            StaggeredGridLayoutManager.this.checkForGaps();
        }
    };
    private int mFullSizeSpec;
    private int mGapStrategy = 2;
    private boolean mLaidOutInvalidFullSpan = false;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;
    @NonNull
    private final LayoutState mLayoutState;
    LazySpanLookup mLazySpanLookup = new LazySpanLookup();
    private int mOrientation;
    private SavedState mPendingSavedState;
    int mPendingScrollPosition = -1;
    int mPendingScrollPositionOffset = Integer.MIN_VALUE;
    private int[] mPrefetchDistances;
    @NonNull
    OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;
    boolean mReverseLayout = false;
    @NonNull
    OrientationHelper mSecondaryOrientation;
    boolean mShouldReverseLayout = false;
    private int mSizePerSpan;
    private boolean mSmoothScrollbarEnabled = true;
    private int mSpanCount = -1;
    Span[] mSpans;
    private final Rect mTmpRect = new Rect();

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        boolean mFullSpan;
        Span mSpan;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int getSpanIndex() {
            Span span = this.mSpan;
            if (span == null) {
                return -1;
            }
            return span.mIndex;
        }

        public boolean isFullSpan() {
            return this.mFullSpan;
        }

        public void setFullSpan(boolean z11) {
            this.mFullSpan = z11;
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
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
        int mAnchorPosition;
        List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        public void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
            parcel.writeList(this.mFullSpanItems);
        }

        public SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            int readInt = parcel.readInt();
            this.mSpanOffsetsSize = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.mSpanOffsets = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.mSpanLookupSize = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.mSpanLookup = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z11 = false;
            this.mReverseLayout = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
            this.mLastLayoutRTL = parcel.readInt() == 1 ? true : z11;
            this.mFullSpanItems = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i11, i12);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void appendViewToAllSpans(View view) {
        for (int i11 = this.mSpanCount - 1; i11 >= 0; i11--) {
            this.mSpans[i11].appendToSpan(view);
        }
    }

    private void applyPendingSavedState(AnchorInfo anchorInfo) {
        int i11;
        SavedState savedState = this.mPendingSavedState;
        int i12 = savedState.mSpanOffsetsSize;
        if (i12 > 0) {
            if (i12 == this.mSpanCount) {
                for (int i13 = 0; i13 < this.mSpanCount; i13++) {
                    this.mSpans[i13].clear();
                    SavedState savedState2 = this.mPendingSavedState;
                    int i14 = savedState2.mSpanOffsets[i13];
                    if (i14 != Integer.MIN_VALUE) {
                        if (savedState2.mAnchorLayoutFromEnd) {
                            i11 = this.mPrimaryOrientation.getEndAfterPadding();
                        } else {
                            i11 = this.mPrimaryOrientation.getStartAfterPadding();
                        }
                        i14 += i11;
                    }
                    this.mSpans[i13].setLine(i14);
                }
            } else {
                savedState.invalidateSpanInfo();
                SavedState savedState3 = this.mPendingSavedState;
                savedState3.mAnchorPosition = savedState3.mVisibleAnchorPosition;
            }
        }
        SavedState savedState4 = this.mPendingSavedState;
        this.mLastLayoutRTL = savedState4.mLastLayoutRTL;
        setReverseLayout(savedState4.mReverseLayout);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.mPendingSavedState;
        int i15 = savedState5.mAnchorPosition;
        if (i15 != -1) {
            this.mPendingScrollPosition = i15;
            anchorInfo.mLayoutFromEnd = savedState5.mAnchorLayoutFromEnd;
        } else {
            anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
        }
        if (savedState5.mSpanLookupSize > 1) {
            LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
            lazySpanLookup.mData = savedState5.mSpanLookup;
            lazySpanLookup.mFullSpanItems = savedState5.mFullSpanItems;
        }
    }

    private void attachViewToSpans(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.mLayoutDirection == 1) {
            if (layoutParams.mFullSpan) {
                appendViewToAllSpans(view);
            } else {
                layoutParams.mSpan.appendToSpan(view);
            }
        } else if (layoutParams.mFullSpan) {
            prependViewToAllSpans(view);
        } else {
            layoutParams.mSpan.prependToSpan(view);
        }
    }

    private int calculateScrollDirectionForPosition(int i11) {
        boolean z11;
        if (getChildCount() != 0) {
            if (i11 < getFirstChildPosition()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 != this.mShouldReverseLayout) {
                return -1;
            }
            return 1;
        } else if (this.mShouldReverseLayout) {
            return 1;
        } else {
            return -1;
        }
    }

    private boolean checkSpanForGap(Span span) {
        if (this.mShouldReverseLayout) {
            if (span.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding()) {
                ArrayList<View> arrayList = span.mViews;
                return !span.getLayoutParams(arrayList.get(arrayList.size() - 1)).mFullSpan;
            }
        } else if (span.getStartLine() > this.mPrimaryOrientation.getStartAfterPadding()) {
            return !span.getLayoutParams(span.mViews.get(0)).mFullSpan;
        }
        return false;
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.computeScrollExtent(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.computeScrollOffset(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.computeScrollRange(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int convertFocusDirectionToLayoutDirection(int i11) {
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

    private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int i11) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i12 = 0; i12 < this.mSpanCount; i12++) {
            fullSpanItem.mGapPerSpan[i12] = i11 - this.mSpans[i12].getEndLine(i11);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int i11) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i12 = 0; i12 < this.mSpanCount; i12++) {
            fullSpanItem.mGapPerSpan[i12] = this.mSpans[i12].getStartLine(i11) - i11;
        }
        return fullSpanItem;
    }

    private void createOrientationHelpers() {
        this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r9v5 */
    private int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        int i11;
        int i12;
        int i13;
        boolean z11;
        Span span;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z12;
        int i18;
        int i19;
        boolean z13;
        int i21;
        int i22;
        RecyclerView.Recycler recycler2 = recycler;
        LayoutState layoutState2 = layoutState;
        ? r92 = 0;
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        if (this.mLayoutState.mInfinite) {
            if (layoutState2.mLayoutDirection == 1) {
                i11 = Integer.MAX_VALUE;
            } else {
                i11 = Integer.MIN_VALUE;
            }
        } else if (layoutState2.mLayoutDirection == 1) {
            i11 = layoutState2.mEndLine + layoutState2.mAvailable;
        } else {
            i11 = layoutState2.mStartLine - layoutState2.mAvailable;
        }
        int i23 = i11;
        updateAllRemainingSpans(layoutState2.mLayoutDirection, i23);
        if (this.mShouldReverseLayout) {
            i12 = this.mPrimaryOrientation.getEndAfterPadding();
        } else {
            i12 = this.mPrimaryOrientation.getStartAfterPadding();
        }
        int i24 = i12;
        boolean z14 = false;
        while (layoutState.hasMore(state) && (this.mLayoutState.mInfinite || !this.mRemainingSpans.isEmpty())) {
            View next = layoutState2.next(recycler2);
            LayoutParams layoutParams = (LayoutParams) next.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int span2 = this.mLazySpanLookup.getSpan(viewLayoutPosition);
            if (span2 == -1) {
                z11 = true;
            } else {
                z11 = r92;
            }
            if (z11) {
                if (layoutParams.mFullSpan) {
                    span = this.mSpans[r92];
                } else {
                    span = getNextSpan(layoutState2);
                }
                this.mLazySpanLookup.setSpan(viewLayoutPosition, span);
            } else {
                span = this.mSpans[span2];
            }
            Span span3 = span;
            layoutParams.mSpan = span3;
            if (layoutState2.mLayoutDirection == 1) {
                addView(next);
            } else {
                addView(next, r92);
            }
            measureChildWithDecorationsAndMargin(next, layoutParams, r92);
            if (layoutState2.mLayoutDirection == 1) {
                if (layoutParams.mFullSpan) {
                    i22 = getMaxEnd(i24);
                } else {
                    i22 = span3.getEndLine(i24);
                }
                int decoratedMeasurement = this.mPrimaryOrientation.getDecoratedMeasurement(next) + i22;
                if (z11 && layoutParams.mFullSpan) {
                    LazySpanLookup.FullSpanItem createFullSpanItemFromEnd = createFullSpanItemFromEnd(i22);
                    createFullSpanItemFromEnd.mGapDir = -1;
                    createFullSpanItemFromEnd.mPosition = viewLayoutPosition;
                    this.mLazySpanLookup.addFullSpanItem(createFullSpanItemFromEnd);
                }
                i14 = decoratedMeasurement;
                i15 = i22;
            } else {
                if (layoutParams.mFullSpan) {
                    i21 = getMinStart(i24);
                } else {
                    i21 = span3.getStartLine(i24);
                }
                i15 = i21 - this.mPrimaryOrientation.getDecoratedMeasurement(next);
                if (z11 && layoutParams.mFullSpan) {
                    LazySpanLookup.FullSpanItem createFullSpanItemFromStart = createFullSpanItemFromStart(i21);
                    createFullSpanItemFromStart.mGapDir = 1;
                    createFullSpanItemFromStart.mPosition = viewLayoutPosition;
                    this.mLazySpanLookup.addFullSpanItem(createFullSpanItemFromStart);
                }
                i14 = i21;
            }
            if (layoutParams.mFullSpan && layoutState2.mItemDirection == -1) {
                if (z11) {
                    this.mLaidOutInvalidFullSpan = true;
                } else {
                    if (layoutState2.mLayoutDirection == 1) {
                        z13 = areAllEndsEqual();
                    } else {
                        z13 = areAllStartsEqual();
                    }
                    if (!z13) {
                        LazySpanLookup.FullSpanItem fullSpanItem = this.mLazySpanLookup.getFullSpanItem(viewLayoutPosition);
                        if (fullSpanItem != null) {
                            fullSpanItem.mHasUnwantedGapAfter = true;
                        }
                        this.mLaidOutInvalidFullSpan = true;
                    }
                }
            }
            attachViewToSpans(next, layoutParams, layoutState2);
            if (!isLayoutRTL() || this.mOrientation != 1) {
                if (layoutParams.mFullSpan) {
                    i18 = this.mSecondaryOrientation.getStartAfterPadding();
                } else {
                    i18 = (span3.mIndex * this.mSizePerSpan) + this.mSecondaryOrientation.getStartAfterPadding();
                }
                i17 = i18;
                i16 = this.mSecondaryOrientation.getDecoratedMeasurement(next) + i18;
            } else {
                if (layoutParams.mFullSpan) {
                    i19 = this.mSecondaryOrientation.getEndAfterPadding();
                } else {
                    i19 = this.mSecondaryOrientation.getEndAfterPadding() - (((this.mSpanCount - 1) - span3.mIndex) * this.mSizePerSpan);
                }
                i16 = i19;
                i17 = i19 - this.mSecondaryOrientation.getDecoratedMeasurement(next);
            }
            if (this.mOrientation == 1) {
                layoutDecoratedWithMargins(next, i17, i15, i16, i14);
            } else {
                layoutDecoratedWithMargins(next, i15, i17, i14, i16);
            }
            if (layoutParams.mFullSpan) {
                updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, i23);
            } else {
                updateRemainingSpans(span3, this.mLayoutState.mLayoutDirection, i23);
            }
            recycle(recycler2, this.mLayoutState);
            if (this.mLayoutState.mStopInFocusable && next.hasFocusable()) {
                if (layoutParams.mFullSpan) {
                    this.mRemainingSpans.clear();
                } else {
                    z12 = false;
                    this.mRemainingSpans.set(span3.mIndex, false);
                    r92 = z12;
                    z14 = true;
                }
            }
            z12 = false;
            r92 = z12;
            z14 = true;
        }
        int i25 = r92;
        if (!z14) {
            recycle(recycler2, this.mLayoutState);
        }
        if (this.mLayoutState.mLayoutDirection == -1) {
            i13 = this.mPrimaryOrientation.getStartAfterPadding() - getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
        } else {
            i13 = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
        }
        if (i13 > 0) {
            return Math.min(layoutState2.mAvailable, i13);
        }
        return i25;
    }

    private int findFirstReferenceChildPosition(int i11) {
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            int position = getPosition(getChildAt(i12));
            if (position >= 0 && position < i11) {
                return position;
            }
        }
        return 0;
    }

    private int findLastReferenceChildPosition(int i11) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i11) {
                return position;
            }
        }
        return 0;
    }

    private void fixEndGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z11) {
        int endAfterPadding;
        int maxEnd = getMaxEnd(Integer.MIN_VALUE);
        if (maxEnd != Integer.MIN_VALUE && (endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - maxEnd) > 0) {
            int i11 = endAfterPadding - (-scrollBy(-endAfterPadding, recycler, state));
            if (z11 && i11 > 0) {
                this.mPrimaryOrientation.offsetChildren(i11);
            }
        }
    }

    private void fixStartGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z11) {
        int startAfterPadding;
        int minStart = getMinStart(Integer.MAX_VALUE);
        if (minStart != Integer.MAX_VALUE && (startAfterPadding = minStart - this.mPrimaryOrientation.getStartAfterPadding()) > 0) {
            int scrollBy = startAfterPadding - scrollBy(startAfterPadding, recycler, state);
            if (z11 && scrollBy > 0) {
                this.mPrimaryOrientation.offsetChildren(-scrollBy);
            }
        }
    }

    private int getMaxEnd(int i11) {
        int endLine = this.mSpans[0].getEndLine(i11);
        for (int i12 = 1; i12 < this.mSpanCount; i12++) {
            int endLine2 = this.mSpans[i12].getEndLine(i11);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMaxStart(int i11) {
        int startLine = this.mSpans[0].getStartLine(i11);
        for (int i12 = 1; i12 < this.mSpanCount; i12++) {
            int startLine2 = this.mSpans[i12].getStartLine(i11);
            if (startLine2 > startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private int getMinEnd(int i11) {
        int endLine = this.mSpans[0].getEndLine(i11);
        for (int i12 = 1; i12 < this.mSpanCount; i12++) {
            int endLine2 = this.mSpans[i12].getEndLine(i11);
            if (endLine2 < endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMinStart(int i11) {
        int startLine = this.mSpans[0].getStartLine(i11);
        for (int i12 = 1; i12 < this.mSpanCount; i12++) {
            int startLine2 = this.mSpans[i12].getStartLine(i11);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private Span getNextSpan(LayoutState layoutState) {
        int i11;
        int i12;
        int i13;
        if (preferLastSpan(layoutState.mLayoutDirection)) {
            i13 = this.mSpanCount - 1;
            i12 = -1;
            i11 = -1;
        } else {
            i12 = this.mSpanCount;
            i13 = 0;
            i11 = 1;
        }
        Span span = null;
        if (layoutState.mLayoutDirection == 1) {
            int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
            int i14 = Integer.MAX_VALUE;
            while (i13 != i12) {
                Span span2 = this.mSpans[i13];
                int endLine = span2.getEndLine(startAfterPadding);
                if (endLine < i14) {
                    span = span2;
                    i14 = endLine;
                }
                i13 += i11;
            }
            return span;
        }
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int i15 = Integer.MIN_VALUE;
        while (i13 != i12) {
            Span span3 = this.mSpans[i13];
            int startLine = span3.getStartLine(endAfterPadding);
            if (startLine > i15) {
                span = span3;
                i15 = startLine;
            }
            i13 += i11;
        }
        return span;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleUpdate(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.mShouldReverseLayout
            if (r0 == 0) goto L_0x0009
            int r0 = r6.getLastChildPosition()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.getFirstChildPosition()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001a
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001d
        L_0x001a:
            int r2 = r7 + r8
        L_0x001c:
            r3 = r7
        L_0x001d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.mLazySpanLookup
            r4.invalidateAfter(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003c
            r5 = 2
            if (r9 == r5) goto L_0x0036
            if (r9 == r1) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.mLazySpanLookup
            r9.offsetForRemoval(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.mLazySpanLookup
            r7.offsetForAddition(r8, r4)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.mLazySpanLookup
            r9.offsetForRemoval(r7, r8)
            goto L_0x0041
        L_0x003c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.mLazySpanLookup
            r9.offsetForAddition(r7, r8)
        L_0x0041:
            if (r2 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r7 = r6.mShouldReverseLayout
            if (r7 == 0) goto L_0x004d
            int r7 = r6.getFirstChildPosition()
            goto L_0x0051
        L_0x004d:
            int r7 = r6.getLastChildPosition()
        L_0x0051:
            if (r3 > r7) goto L_0x0056
            r6.requestLayout()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.handleUpdate(int, int, int):void");
    }

    private void measureChildWithDecorationsAndMargin(View view, LayoutParams layoutParams, boolean z11) {
        if (layoutParams.mFullSpan) {
            if (this.mOrientation == 1) {
                measureChildWithDecorationsAndMargin(view, this.mFullSizeSpec, RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), z11);
            } else {
                measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), this.mFullSizeSpec, z11);
            }
        } else if (this.mOrientation == 1) {
            measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, layoutParams.width, false), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), z11);
        } else {
            measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, layoutParams.height, false), z11);
        }
    }

    private boolean preferLastSpan(int i11) {
        boolean z11;
        boolean z12;
        boolean z13;
        if (this.mOrientation == 0) {
            if (i11 == -1) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13 != this.mShouldReverseLayout) {
                return true;
            }
            return false;
        }
        if (i11 == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 == this.mShouldReverseLayout) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12 == isLayoutRTL()) {
            return true;
        }
        return false;
    }

    private void prependViewToAllSpans(View view) {
        for (int i11 = this.mSpanCount - 1; i11 >= 0; i11--) {
            this.mSpans[i11].prependToSpan(view);
        }
    }

    private void recycle(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int i11;
        int i12;
        if (layoutState.mRecycle && !layoutState.mInfinite) {
            if (layoutState.mAvailable == 0) {
                if (layoutState.mLayoutDirection == -1) {
                    recycleFromEnd(recycler, layoutState.mEndLine);
                } else {
                    recycleFromStart(recycler, layoutState.mStartLine);
                }
            } else if (layoutState.mLayoutDirection == -1) {
                int i13 = layoutState.mStartLine;
                int maxStart = i13 - getMaxStart(i13);
                if (maxStart < 0) {
                    i12 = layoutState.mEndLine;
                } else {
                    i12 = layoutState.mEndLine - Math.min(maxStart, layoutState.mAvailable);
                }
                recycleFromEnd(recycler, i12);
            } else {
                int minEnd = getMinEnd(layoutState.mEndLine) - layoutState.mEndLine;
                if (minEnd < 0) {
                    i11 = layoutState.mStartLine;
                } else {
                    i11 = Math.min(minEnd, layoutState.mAvailable) + layoutState.mStartLine;
                }
                recycleFromStart(recycler, i11);
            }
        }
    }

    private void recycleFromEnd(RecyclerView.Recycler recycler, int i11) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.mPrimaryOrientation.getDecoratedStart(childAt) >= i11 && this.mPrimaryOrientation.getTransformedStartWithDecoration(childAt) >= i11) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    int i12 = 0;
                    while (i12 < this.mSpanCount) {
                        if (this.mSpans[i12].mViews.size() != 1) {
                            i12++;
                        } else {
                            return;
                        }
                    }
                    for (int i13 = 0; i13 < this.mSpanCount; i13++) {
                        this.mSpans[i13].popEnd();
                    }
                } else if (layoutParams.mSpan.mViews.size() != 1) {
                    layoutParams.mSpan.popEnd();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
                childCount--;
            } else {
                return;
            }
        }
    }

    private void recycleFromStart(RecyclerView.Recycler recycler, int i11) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) <= i11 && this.mPrimaryOrientation.getTransformedEndWithDecoration(childAt) <= i11) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    int i12 = 0;
                    while (i12 < this.mSpanCount) {
                        if (this.mSpans[i12].mViews.size() != 1) {
                            i12++;
                        } else {
                            return;
                        }
                    }
                    for (int i13 = 0; i13 < this.mSpanCount; i13++) {
                        this.mSpans[i13].popStart();
                    }
                } else if (layoutParams.mSpan.mViews.size() != 1) {
                    layoutParams.mSpan.popStart();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    private void repositionToWrapContentIfNecessary() {
        if (this.mSecondaryOrientation.getMode() != 1073741824) {
            int childCount = getChildCount();
            float f11 = 0.0f;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                float decoratedMeasurement = (float) this.mSecondaryOrientation.getDecoratedMeasurement(childAt);
                if (decoratedMeasurement >= f11) {
                    if (((LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                        decoratedMeasurement = (decoratedMeasurement * 1.0f) / ((float) this.mSpanCount);
                    }
                    f11 = Math.max(f11, decoratedMeasurement);
                }
            }
            int i12 = this.mSizePerSpan;
            int round = Math.round(f11 * ((float) this.mSpanCount));
            if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
                round = Math.min(round, this.mSecondaryOrientation.getTotalSpace());
            }
            updateMeasureSpecs(round);
            if (this.mSizePerSpan != i12) {
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt2 = getChildAt(i13);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (!layoutParams.mFullSpan) {
                        if (!isLayoutRTL() || this.mOrientation != 1) {
                            int i14 = layoutParams.mSpan.mIndex;
                            int i15 = this.mSizePerSpan * i14;
                            int i16 = i14 * i12;
                            if (this.mOrientation == 1) {
                                childAt2.offsetLeftAndRight(i15 - i16);
                            } else {
                                childAt2.offsetTopAndBottom(i15 - i16);
                            }
                        } else {
                            int i17 = this.mSpanCount;
                            int i18 = layoutParams.mSpan.mIndex;
                            childAt2.offsetLeftAndRight(((-((i17 - 1) - i18)) * this.mSizePerSpan) - ((-((i17 - 1) - i18)) * i12));
                        }
                    }
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

    private void setLayoutStateDirection(int i11) {
        boolean z11;
        LayoutState layoutState = this.mLayoutState;
        layoutState.mLayoutDirection = i11;
        boolean z12 = this.mShouldReverseLayout;
        int i12 = 1;
        if (i11 == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z12 != z11) {
            i12 = -1;
        }
        layoutState.mItemDirection = i12;
    }

    private void updateAllRemainingSpans(int i11, int i12) {
        for (int i13 = 0; i13 < this.mSpanCount; i13++) {
            if (!this.mSpans[i13].mViews.isEmpty()) {
                updateRemainingSpans(this.mSpans[i13], i11, i12);
            }
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i11;
        if (this.mLastLayoutFromEnd) {
            i11 = findLastReferenceChildPosition(state.getItemCount());
        } else {
            i11 = findFirstReferenceChildPosition(state.getItemCount());
        }
        anchorInfo.mPosition = i11;
        anchorInfo.mOffset = Integer.MIN_VALUE;
        return true;
    }

    private void updateLayoutState(int i11, RecyclerView.State state) {
        int i12;
        int i13;
        int targetScrollPosition;
        boolean z11;
        LayoutState layoutState = this.mLayoutState;
        boolean z12 = false;
        layoutState.mAvailable = 0;
        layoutState.mCurrentPosition = i11;
        if (!isSmoothScrolling() || (targetScrollPosition = state.getTargetScrollPosition()) == -1) {
            i13 = 0;
            i12 = 0;
        } else {
            boolean z13 = this.mShouldReverseLayout;
            if (targetScrollPosition < i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z13 == z11) {
                i13 = this.mPrimaryOrientation.getTotalSpace();
                i12 = 0;
            } else {
                i12 = this.mPrimaryOrientation.getTotalSpace();
                i13 = 0;
            }
        }
        if (getClipToPadding()) {
            this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - i12;
            this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + i13;
        } else {
            this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEnd() + i13;
            this.mLayoutState.mStartLine = -i12;
        }
        LayoutState layoutState2 = this.mLayoutState;
        layoutState2.mStopInFocusable = false;
        layoutState2.mRecycle = true;
        if (this.mPrimaryOrientation.getMode() == 0 && this.mPrimaryOrientation.getEnd() == 0) {
            z12 = true;
        }
        layoutState2.mInfinite = z12;
    }

    private void updateRemainingSpans(Span span, int i11, int i12) {
        int deletedSize = span.getDeletedSize();
        if (i11 == -1) {
            if (span.getStartLine() + deletedSize <= i12) {
                this.mRemainingSpans.set(span.mIndex, false);
            }
        } else if (span.getEndLine() - deletedSize >= i12) {
            this.mRemainingSpans.set(span.mIndex, false);
        }
    }

    private int updateSpecWithExtra(int i11, int i12, int i13) {
        if (i12 == 0 && i13 == 0) {
            return i11;
        }
        int mode = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i11) - i12) - i13), mode);
        }
        return i11;
    }

    public boolean areAllEndsEqual() {
        int endLine = this.mSpans[0].getEndLine(Integer.MIN_VALUE);
        for (int i11 = 1; i11 < this.mSpanCount; i11++) {
            if (this.mSpans[i11].getEndLine(Integer.MIN_VALUE) != endLine) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllStartsEqual() {
        int startLine = this.mSpans[0].getStartLine(Integer.MIN_VALUE);
        for (int i11 = 1; i11 < this.mSpanCount; i11++) {
            if (this.mSpans[i11].getStartLine(Integer.MIN_VALUE) != startLine) {
                return false;
            }
        }
        return true;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public boolean checkForGaps() {
        int i11;
        int i12;
        int i13;
        if (getChildCount() == 0 || this.mGapStrategy == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.mShouldReverseLayout) {
            i12 = getLastChildPosition();
            i11 = getFirstChildPosition();
        } else {
            i12 = getFirstChildPosition();
            i11 = getLastChildPosition();
        }
        if (i12 == 0 && hasGapsToFix() != null) {
            this.mLazySpanLookup.clear();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.mLaidOutInvalidFullSpan) {
            return false;
        } else {
            if (this.mShouldReverseLayout) {
                i13 = -1;
            } else {
                i13 = 1;
            }
            int i14 = i11 + 1;
            LazySpanLookup.FullSpanItem firstFullSpanItemInRange = this.mLazySpanLookup.getFirstFullSpanItemInRange(i12, i14, i13, true);
            if (firstFullSpanItemInRange == null) {
                this.mLaidOutInvalidFullSpan = false;
                this.mLazySpanLookup.forceInvalidateAfter(i14);
                return false;
            }
            LazySpanLookup.FullSpanItem firstFullSpanItemInRange2 = this.mLazySpanLookup.getFirstFullSpanItemInRange(i12, firstFullSpanItemInRange.mPosition, i13 * -1, true);
            if (firstFullSpanItemInRange2 == null) {
                this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange.mPosition);
            } else {
                this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange2.mPosition + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void collectAdjacentPrefetchPositions(int i11, int i12, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i13;
        int i14;
        if (this.mOrientation != 0) {
            i11 = i12;
        }
        if (getChildCount() != 0 && i11 != 0) {
            prepareLayoutStateForDelta(i11, state);
            int[] iArr = this.mPrefetchDistances;
            if (iArr == null || iArr.length < this.mSpanCount) {
                this.mPrefetchDistances = new int[this.mSpanCount];
            }
            int i15 = 0;
            for (int i16 = 0; i16 < this.mSpanCount; i16++) {
                LayoutState layoutState = this.mLayoutState;
                if (layoutState.mItemDirection == -1) {
                    i14 = layoutState.mStartLine;
                    i13 = this.mSpans[i16].getStartLine(i14);
                } else {
                    i14 = this.mSpans[i16].getEndLine(layoutState.mEndLine);
                    i13 = this.mLayoutState.mEndLine;
                }
                int i17 = i14 - i13;
                if (i17 >= 0) {
                    this.mPrefetchDistances[i15] = i17;
                    i15++;
                }
            }
            Arrays.sort(this.mPrefetchDistances, 0, i15);
            for (int i18 = 0; i18 < i15 && this.mLayoutState.hasMore(state); i18++) {
                layoutPrefetchRegistry.addPosition(this.mLayoutState.mCurrentPosition, this.mPrefetchDistances[i18]);
                LayoutState layoutState2 = this.mLayoutState;
                layoutState2.mCurrentPosition += layoutState2.mItemDirection;
            }
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
        int calculateScrollDirectionForPosition = calculateScrollDirectionForPosition(i11);
        PointF pointF = new PointF();
        if (calculateScrollDirectionForPosition == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = (float) calculateScrollDirectionForPosition;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) calculateScrollDirectionForPosition;
        }
        return pointF;
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

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            iArr[i11] = this.mSpans[i11].findFirstCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public View findFirstVisibleItemClosestToEnd(boolean z11) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z11) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public View findFirstVisibleItemClosestToStart(boolean z11) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z11) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public int findFirstVisibleItemPositionInt() {
        View view;
        if (this.mShouldReverseLayout) {
            view = findFirstVisibleItemClosestToEnd(true);
        } else {
            view = findFirstVisibleItemClosestToStart(true);
        }
        if (view == null) {
            return -1;
        }
        return getPosition(view);
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            iArr[i11] = this.mSpans[i11].findFirstVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            iArr[i11] = this.mSpans[i11].findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            iArr[i11] = this.mSpans[i11].findLastVisibleItemPosition();
        }
        return iArr;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int getFirstChildPosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    public int getLastChildPosition() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View hasGapsToFix() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.mSpanCount
            r2.<init>(r3)
            int r3 = r12.mSpanCount
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.mOrientation
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.isLayoutRTL()
            if (r3 == 0) goto L_0x0020
            r3 = r1
            goto L_0x0021
        L_0x0020:
            r3 = r5
        L_0x0021:
            boolean r6 = r12.mShouldReverseLayout
            if (r6 == 0) goto L_0x0027
            r6 = r5
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = r4
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = r1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.mSpan
            int r9 = r9.mIndex
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.mSpan
            boolean r9 = r12.checkSpanForGap(r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.mSpan
            int r9 = r9.mIndex
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.mFullSpan
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.mShouldReverseLayout
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.OrientationHelper r10 = r12.mPrimaryOrientation
            int r10 = r10.getDecoratedEnd(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.mPrimaryOrientation
            int r11 = r11.getDecoratedEnd(r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.OrientationHelper r10 = r12.mPrimaryOrientation
            int r10 = r10.getDecoratedStart(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.mPrimaryOrientation
            int r11 = r11.getDecoratedStart(r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = r1
            goto L_0x008b
        L_0x008a:
            r10 = r4
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r8 = r8.mSpan
            int r8 = r8.mIndex
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r9.mSpan
            int r9 = r9.mIndex
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = r1
            goto L_0x00a1
        L_0x00a0:
            r8 = r4
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = r1
            goto L_0x00a6
        L_0x00a5:
            r9 = r4
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.hasGapsToFix():android.view.View");
    }

    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    public boolean isAutoMeasureEnabled() {
        return this.mGapStrategy != 0;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public void offsetChildrenHorizontal(int i11) {
        super.offsetChildrenHorizontal(i11);
        for (int i12 = 0; i12 < this.mSpanCount; i12++) {
            this.mSpans[i12].onOffset(i11);
        }
    }

    public void offsetChildrenVertical(int i11) {
        super.offsetChildrenVertical(i11);
        for (int i12 = 0; i12 < this.mSpanCount; i12++) {
            this.mSpans[i12].onOffset(i11);
        }
    }

    public void onAdapterChanged(@Nullable RecyclerView.Adapter adapter, @Nullable RecyclerView.Adapter adapter2) {
        this.mLazySpanLookup.clear();
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            this.mSpans[i11].clear();
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.mCheckForGapsRunnable);
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            this.mSpans[i11].clear();
        }
        recyclerView.requestLayout();
    }

    @Nullable
    public View onFocusSearchFailed(View view, int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View findContainingItemView;
        int i12;
        boolean z11;
        boolean z12;
        int i13;
        int i14;
        int i15;
        View focusableViewAfter;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i11);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        boolean z13 = layoutParams.mFullSpan;
        Span span = layoutParams.mSpan;
        if (convertFocusDirectionToLayoutDirection == 1) {
            i12 = getLastChildPosition();
        } else {
            i12 = getFirstChildPosition();
        }
        updateLayoutState(i12, state);
        setLayoutStateDirection(convertFocusDirectionToLayoutDirection);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = layoutState.mItemDirection + i12;
        layoutState.mAvailable = (int) (((float) this.mPrimaryOrientation.getTotalSpace()) * MAX_SCROLL_FACTOR);
        LayoutState layoutState2 = this.mLayoutState;
        layoutState2.mStopInFocusable = true;
        layoutState2.mRecycle = false;
        fill(recycler, layoutState2, state);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        if (!z13 && (focusableViewAfter = span.getFocusableViewAfter(i12, convertFocusDirectionToLayoutDirection)) != null && focusableViewAfter != findContainingItemView) {
            return focusableViewAfter;
        }
        if (preferLastSpan(convertFocusDirectionToLayoutDirection)) {
            for (int i16 = this.mSpanCount - 1; i16 >= 0; i16--) {
                View focusableViewAfter2 = this.mSpans[i16].getFocusableViewAfter(i12, convertFocusDirectionToLayoutDirection);
                if (focusableViewAfter2 != null && focusableViewAfter2 != findContainingItemView) {
                    return focusableViewAfter2;
                }
            }
        } else {
            for (int i17 = 0; i17 < this.mSpanCount; i17++) {
                View focusableViewAfter3 = this.mSpans[i17].getFocusableViewAfter(i12, convertFocusDirectionToLayoutDirection);
                if (focusableViewAfter3 != null && focusableViewAfter3 != findContainingItemView) {
                    return focusableViewAfter3;
                }
            }
        }
        boolean z14 = !this.mReverseLayout;
        if (convertFocusDirectionToLayoutDirection == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z14 == z11) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z13) {
            if (z12) {
                i15 = span.findFirstPartiallyVisibleItemPosition();
            } else {
                i15 = span.findLastPartiallyVisibleItemPosition();
            }
            View findViewByPosition = findViewByPosition(i15);
            if (!(findViewByPosition == null || findViewByPosition == findContainingItemView)) {
                return findViewByPosition;
            }
        }
        if (preferLastSpan(convertFocusDirectionToLayoutDirection)) {
            for (int i18 = this.mSpanCount - 1; i18 >= 0; i18--) {
                if (i18 != span.mIndex) {
                    if (z12) {
                        i14 = this.mSpans[i18].findFirstPartiallyVisibleItemPosition();
                    } else {
                        i14 = this.mSpans[i18].findLastPartiallyVisibleItemPosition();
                    }
                    View findViewByPosition2 = findViewByPosition(i14);
                    if (!(findViewByPosition2 == null || findViewByPosition2 == findContainingItemView)) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i19 = 0; i19 < this.mSpanCount; i19++) {
                if (z12) {
                    i13 = this.mSpans[i19].findFirstPartiallyVisibleItemPosition();
                } else {
                    i13 = this.mSpans[i19].findLastPartiallyVisibleItemPosition();
                }
                View findViewByPosition3 = findViewByPosition(i13);
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(false);
            View findFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(false);
            if (findFirstVisibleItemClosestToStart != null && findFirstVisibleItemClosestToEnd != null) {
                int position = getPosition(findFirstVisibleItemClosestToStart);
                int position2 = getPosition(findFirstVisibleItemClosestToEnd);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i11, int i12) {
        handleUpdate(i11, i12, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i11, int i12, int i13) {
        handleUpdate(i11, i12, 8);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i11, int i12) {
        handleUpdate(i11, i12, 2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i11, int i12, Object obj) {
        handleUpdate(i11, i12, 4);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        onLayoutChildren(recycler, state, true);
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.invalidateAnchorPositionInfo();
                this.mPendingSavedState.invalidateSpanInfo();
            }
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        int i11;
        int i12;
        int i13;
        int[] iArr;
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        savedState.mReverseLayout = this.mReverseLayout;
        savedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        savedState.mLastLayoutRTL = this.mLastLayoutRTL;
        LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.mData) == null) {
            savedState.mSpanLookupSize = 0;
        } else {
            savedState.mSpanLookup = iArr;
            savedState.mSpanLookupSize = iArr.length;
            savedState.mFullSpanItems = lazySpanLookup.mFullSpanItems;
        }
        if (getChildCount() > 0) {
            if (this.mLastLayoutFromEnd) {
                i11 = getLastChildPosition();
            } else {
                i11 = getFirstChildPosition();
            }
            savedState.mAnchorPosition = i11;
            savedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
            int i14 = this.mSpanCount;
            savedState.mSpanOffsetsSize = i14;
            savedState.mSpanOffsets = new int[i14];
            for (int i15 = 0; i15 < this.mSpanCount; i15++) {
                if (this.mLastLayoutFromEnd) {
                    i12 = this.mSpans[i15].getEndLine(Integer.MIN_VALUE);
                    if (i12 != Integer.MIN_VALUE) {
                        i13 = this.mPrimaryOrientation.getEndAfterPadding();
                    } else {
                        savedState.mSpanOffsets[i15] = i12;
                    }
                } else {
                    i12 = this.mSpans[i15].getStartLine(Integer.MIN_VALUE);
                    if (i12 != Integer.MIN_VALUE) {
                        i13 = this.mPrimaryOrientation.getStartAfterPadding();
                    } else {
                        savedState.mSpanOffsets[i15] = i12;
                    }
                }
                i12 -= i13;
                savedState.mSpanOffsets[i15] = i12;
            }
        } else {
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
            savedState.mSpanOffsetsSize = 0;
        }
        return savedState;
    }

    public void onScrollStateChanged(int i11) {
        if (i11 == 0) {
            checkForGaps();
        }
    }

    public void prepareLayoutStateForDelta(int i11, RecyclerView.State state) {
        int i12;
        int i13;
        if (i11 > 0) {
            i13 = getLastChildPosition();
            i12 = 1;
        } else {
            i13 = getFirstChildPosition();
            i12 = -1;
        }
        this.mLayoutState.mRecycle = true;
        updateLayoutState(i13, state);
        setLayoutStateDirection(i12);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = i13 + layoutState.mItemDirection;
        layoutState.mAvailable = Math.abs(i11);
    }

    public int scrollBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        prepareLayoutStateForDelta(i11, state);
        int fill = fill(recycler, this.mLayoutState, state);
        if (this.mLayoutState.mAvailable >= fill) {
            if (i11 < 0) {
                i11 = -fill;
            } else {
                i11 = fill;
            }
        }
        this.mPrimaryOrientation.offsetChildren(-i11);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        LayoutState layoutState = this.mLayoutState;
        layoutState.mAvailable = 0;
        recycle(recycler, layoutState);
        return i11;
    }

    public int scrollHorizontallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i11, recycler, state);
    }

    public void scrollToPosition(int i11) {
        SavedState savedState = this.mPendingSavedState;
        if (!(savedState == null || savedState.mAnchorPosition == i11)) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i11;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i11, int i12) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i11;
        this.mPendingScrollPositionOffset = i12;
        requestLayout();
    }

    public int scrollVerticallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i11, recycler, state);
    }

    public void setGapStrategy(int i11) {
        assertNotInLayoutOrScroll((String) null);
        if (i11 != this.mGapStrategy) {
            if (i11 == 0 || i11 == 2) {
                this.mGapStrategy = i11;
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
    }

    public void setMeasuredDimension(Rect rect, int i11, int i12) {
        int i13;
        int i14;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            i14 = RecyclerView.LayoutManager.chooseSize(i12, rect.height() + paddingTop, getMinimumHeight());
            i13 = RecyclerView.LayoutManager.chooseSize(i11, (this.mSizePerSpan * this.mSpanCount) + paddingLeft, getMinimumWidth());
        } else {
            i13 = RecyclerView.LayoutManager.chooseSize(i11, rect.width() + paddingLeft, getMinimumWidth());
            i14 = RecyclerView.LayoutManager.chooseSize(i12, (this.mSizePerSpan * this.mSpanCount) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i13, i14);
    }

    public void setOrientation(int i11) {
        if (i11 == 0 || i11 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i11 != this.mOrientation) {
                this.mOrientation = i11;
                OrientationHelper orientationHelper = this.mPrimaryOrientation;
                this.mPrimaryOrientation = this.mSecondaryOrientation;
                this.mSecondaryOrientation = orientationHelper;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean z11) {
        assertNotInLayoutOrScroll((String) null);
        SavedState savedState = this.mPendingSavedState;
        if (!(savedState == null || savedState.mReverseLayout == z11)) {
            savedState.mReverseLayout = z11;
        }
        this.mReverseLayout = z11;
        requestLayout();
    }

    public void setSpanCount(int i11) {
        assertNotInLayoutOrScroll((String) null);
        if (i11 != this.mSpanCount) {
            invalidateSpanAssignments();
            this.mSpanCount = i11;
            this.mRemainingSpans = new BitSet(this.mSpanCount);
            this.mSpans = new Span[this.mSpanCount];
            for (int i12 = 0; i12 < this.mSpanCount; i12++) {
                this.mSpans[i12] = new Span(i12);
            }
            requestLayout();
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i11) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i11);
        startSmoothScroll(linearSmoothScroller);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null;
    }

    public boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i11;
        int i12;
        int i13;
        boolean z11 = false;
        if (!state.isPreLayout() && (i11 = this.mPendingScrollPosition) != -1) {
            if (i11 < 0 || i11 >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                SavedState savedState = this.mPendingSavedState;
                if (savedState == null || savedState.mAnchorPosition == -1 || savedState.mSpanOffsetsSize < 1) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition != null) {
                        if (this.mShouldReverseLayout) {
                            i12 = getLastChildPosition();
                        } else {
                            i12 = getFirstChildPosition();
                        }
                        anchorInfo.mPosition = i12;
                        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                            if (anchorInfo.mLayoutFromEnd) {
                                anchorInfo.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                            } else {
                                anchorInfo.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(findViewByPosition);
                            }
                            return true;
                        } else if (this.mPrimaryOrientation.getDecoratedMeasurement(findViewByPosition) > this.mPrimaryOrientation.getTotalSpace()) {
                            if (anchorInfo.mLayoutFromEnd) {
                                i13 = this.mPrimaryOrientation.getEndAfterPadding();
                            } else {
                                i13 = this.mPrimaryOrientation.getStartAfterPadding();
                            }
                            anchorInfo.mOffset = i13;
                            return true;
                        } else {
                            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(findViewByPosition) - this.mPrimaryOrientation.getStartAfterPadding();
                            if (decoratedStart < 0) {
                                anchorInfo.mOffset = -decoratedStart;
                                return true;
                            }
                            int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                            if (endAfterPadding < 0) {
                                anchorInfo.mOffset = endAfterPadding;
                                return true;
                            }
                            anchorInfo.mOffset = Integer.MIN_VALUE;
                        }
                    } else {
                        int i14 = this.mPendingScrollPosition;
                        anchorInfo.mPosition = i14;
                        int i15 = this.mPendingScrollPositionOffset;
                        if (i15 == Integer.MIN_VALUE) {
                            if (calculateScrollDirectionForPosition(i14) == 1) {
                                z11 = true;
                            }
                            anchorInfo.mLayoutFromEnd = z11;
                            anchorInfo.assignCoordinateFromPadding();
                        } else {
                            anchorInfo.assignCoordinateFromPadding(i15);
                        }
                        anchorInfo.mInvalidateOffsets = true;
                    }
                } else {
                    anchorInfo.mOffset = Integer.MIN_VALUE;
                    anchorInfo.mPosition = this.mPendingScrollPosition;
                }
                return true;
            }
        }
        return false;
    }

    public void updateAnchorInfoForLayout(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (!updateAnchorFromPendingData(state, anchorInfo) && !updateAnchorFromChildren(state, anchorInfo)) {
            anchorInfo.assignCoordinateFromPadding();
            anchorInfo.mPosition = 0;
        }
    }

    public void updateMeasureSpecs(int i11) {
        this.mSizePerSpan = i11 / this.mSpanCount;
        this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(i11, this.mSecondaryOrientation.getMode());
    }

    public class AnchorInfo {
        boolean mInvalidateOffsets;
        boolean mLayoutFromEnd;
        int mOffset;
        int mPosition;
        int[] mSpanReferenceLines;
        boolean mValid;

        public AnchorInfo() {
            reset();
        }

        public void assignCoordinateFromPadding() {
            int i11;
            if (this.mLayoutFromEnd) {
                i11 = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            } else {
                i11 = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            }
            this.mOffset = i11;
        }

        public void reset() {
            this.mPosition = -1;
            this.mOffset = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mInvalidateOffsets = false;
            this.mValid = false;
            int[] iArr = this.mSpanReferenceLines;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void saveSpanReferenceLines(Span[] spanArr) {
            int length = spanArr.length;
            int[] iArr = this.mSpanReferenceLines;
            if (iArr == null || iArr.length < length) {
                this.mSpanReferenceLines = new int[StaggeredGridLayoutManager.this.mSpans.length];
            }
            for (int i11 = 0; i11 < length; i11++) {
                this.mSpanReferenceLines[i11] = spanArr[i11].getStartLine(Integer.MIN_VALUE);
            }
        }

        public void assignCoordinateFromPadding(int i11) {
            if (this.mLayoutFromEnd) {
                this.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() - i11;
            } else {
                this.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding() + i11;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0157, code lost:
        if (checkForGaps() != false) goto L_0x015b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r0 = r8.mAnchorInfo
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.mPendingSavedState
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.mPendingScrollPosition
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.getItemCount()
            if (r1 != 0) goto L_0x0018
            r8.removeAndRecycleAllViews(r9)
            r0.reset()
            return
        L_0x0018:
            boolean r1 = r0.mValid
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.mPendingScrollPosition
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.mPendingSavedState
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = r3
            goto L_0x002a
        L_0x0029:
            r1 = r4
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.reset()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.mPendingSavedState
            if (r5 == 0) goto L_0x0037
            r8.applyPendingSavedState(r0)
            goto L_0x003e
        L_0x0037:
            r8.resolveShouldLayoutReverse()
            boolean r5 = r8.mShouldReverseLayout
            r0.mLayoutFromEnd = r5
        L_0x003e:
            r8.updateAnchorInfoForLayout(r10, r0)
            r0.mValid = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.mPendingSavedState
            if (r5 != 0) goto L_0x0060
            int r5 = r8.mPendingScrollPosition
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.mLayoutFromEnd
            boolean r6 = r8.mLastLayoutFromEnd
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.isLayoutRTL()
            boolean r6 = r8.mLastLayoutRTL
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r5 = r8.mLazySpanLookup
            r5.clear()
            r0.mInvalidateOffsets = r4
        L_0x0060:
            int r5 = r8.getChildCount()
            if (r5 <= 0) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.mPendingSavedState
            if (r5 == 0) goto L_0x006e
            int r5 = r5.mSpanOffsetsSize
            if (r5 >= r4) goto L_0x00c9
        L_0x006e:
            boolean r5 = r0.mInvalidateOffsets
            if (r5 == 0) goto L_0x008e
            r1 = r3
        L_0x0073:
            int r5 = r8.mSpanCount
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.mSpans
            r5 = r5[r1]
            r5.clear()
            int r5 = r0.mOffset
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r6 = r8.mSpans
            r6 = r6[r1]
            r6.setLine(r5)
        L_0x008b:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x008e:
            if (r1 != 0) goto L_0x00af
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r1 = r8.mAnchorInfo
            int[] r1 = r1.mSpanReferenceLines
            if (r1 != 0) goto L_0x0097
            goto L_0x00af
        L_0x0097:
            r1 = r3
        L_0x0098:
            int r5 = r8.mSpanCount
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.mSpans
            r5 = r5[r1]
            r5.clear()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r6 = r8.mAnchorInfo
            int[] r6 = r6.mSpanReferenceLines
            r6 = r6[r1]
            r5.setLine(r6)
            int r1 = r1 + 1
            goto L_0x0098
        L_0x00af:
            r1 = r3
        L_0x00b0:
            int r5 = r8.mSpanCount
            if (r1 >= r5) goto L_0x00c2
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.mSpans
            r5 = r5[r1]
            boolean r6 = r8.mShouldReverseLayout
            int r7 = r0.mOffset
            r5.cacheReferenceLineAndClear(r6, r7)
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00c2:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r1 = r8.mAnchorInfo
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.mSpans
            r1.saveSpanReferenceLines(r5)
        L_0x00c9:
            r8.detachAndScrapAttachedViews(r9)
            androidx.recyclerview.widget.LayoutState r1 = r8.mLayoutState
            r1.mRecycle = r3
            r8.mLaidOutInvalidFullSpan = r3
            androidx.recyclerview.widget.OrientationHelper r1 = r8.mSecondaryOrientation
            int r1 = r1.getTotalSpace()
            r8.updateMeasureSpecs(r1)
            int r1 = r0.mPosition
            r8.updateLayoutState(r1, r10)
            boolean r1 = r0.mLayoutFromEnd
            if (r1 == 0) goto L_0x00fc
            r8.setLayoutStateDirection(r2)
            androidx.recyclerview.widget.LayoutState r1 = r8.mLayoutState
            r8.fill(r9, r1, r10)
            r8.setLayoutStateDirection(r4)
            androidx.recyclerview.widget.LayoutState r1 = r8.mLayoutState
            int r2 = r0.mPosition
            int r5 = r1.mItemDirection
            int r2 = r2 + r5
            r1.mCurrentPosition = r2
            r8.fill(r9, r1, r10)
            goto L_0x0113
        L_0x00fc:
            r8.setLayoutStateDirection(r4)
            androidx.recyclerview.widget.LayoutState r1 = r8.mLayoutState
            r8.fill(r9, r1, r10)
            r8.setLayoutStateDirection(r2)
            androidx.recyclerview.widget.LayoutState r1 = r8.mLayoutState
            int r2 = r0.mPosition
            int r5 = r1.mItemDirection
            int r2 = r2 + r5
            r1.mCurrentPosition = r2
            r8.fill(r9, r1, r10)
        L_0x0113:
            r8.repositionToWrapContentIfNecessary()
            int r1 = r8.getChildCount()
            if (r1 <= 0) goto L_0x012d
            boolean r1 = r8.mShouldReverseLayout
            if (r1 == 0) goto L_0x0127
            r8.fixEndGap(r9, r10, r4)
            r8.fixStartGap(r9, r10, r3)
            goto L_0x012d
        L_0x0127:
            r8.fixStartGap(r9, r10, r4)
            r8.fixEndGap(r9, r10, r3)
        L_0x012d:
            if (r11 == 0) goto L_0x015a
            boolean r11 = r10.isPreLayout()
            if (r11 != 0) goto L_0x015a
            int r11 = r8.mGapStrategy
            if (r11 == 0) goto L_0x014b
            int r11 = r8.getChildCount()
            if (r11 <= 0) goto L_0x014b
            boolean r11 = r8.mLaidOutInvalidFullSpan
            if (r11 != 0) goto L_0x0149
            android.view.View r11 = r8.hasGapsToFix()
            if (r11 == 0) goto L_0x014b
        L_0x0149:
            r11 = r4
            goto L_0x014c
        L_0x014b:
            r11 = r3
        L_0x014c:
            if (r11 == 0) goto L_0x015a
            java.lang.Runnable r11 = r8.mCheckForGapsRunnable
            r8.removeCallbacks(r11)
            boolean r11 = r8.checkForGaps()
            if (r11 == 0) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r4 = r3
        L_0x015b:
            boolean r11 = r10.isPreLayout()
            if (r11 == 0) goto L_0x0166
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r11 = r8.mAnchorInfo
            r11.reset()
        L_0x0166:
            boolean r11 = r0.mLayoutFromEnd
            r8.mLastLayoutFromEnd = r11
            boolean r11 = r8.isLayoutRTL()
            r8.mLastLayoutRTL = r11
            if (r4 == 0) goto L_0x017a
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r11 = r8.mAnchorInfo
            r11.reset()
            r8.onLayoutChildren(r9, r10, r3)
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public class Span {
        static final int INVALID_LINE = Integer.MIN_VALUE;
        int mCachedEnd = Integer.MIN_VALUE;
        int mCachedStart = Integer.MIN_VALUE;
        int mDeletedSize = 0;
        final int mIndex;
        ArrayList<View> mViews = new ArrayList<>();

        public Span(int i11) {
            this.mIndex = i11;
        }

        public void appendToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(view);
            this.mCachedEnd = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }

        public void cacheReferenceLineAndClear(boolean z11, int i11) {
            int i12;
            if (z11) {
                i12 = getEndLine(Integer.MIN_VALUE);
            } else {
                i12 = getStartLine(Integer.MIN_VALUE);
            }
            clear();
            if (i12 != Integer.MIN_VALUE) {
                if (z11 && i12 < StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding()) {
                    return;
                }
                if (z11 || i12 <= StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding()) {
                    if (i11 != Integer.MIN_VALUE) {
                        i12 += i11;
                    }
                    this.mCachedEnd = i12;
                    this.mCachedStart = i12;
                }
            }
        }

        public void calculateCachedEnd() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            ArrayList<View> arrayList = this.mViews;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
            if (layoutParams.mFullSpan && (fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == 1) {
                this.mCachedEnd += fullSpanItem.getGapForSpan(this.mIndex);
            }
        }

        public void calculateCachedStart() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            View view = this.mViews.get(0);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
            if (layoutParams.mFullSpan && (fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == -1) {
                this.mCachedStart -= fullSpanItem.getGapForSpan(this.mIndex);
            }
        }

        public void clear() {
            this.mViews.clear();
            invalidateCache();
            this.mDeletedSize = 0;
        }

        public int findFirstCompletelyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(this.mViews.size() - 1, -1, true);
            }
            return findOneVisibleChild(0, this.mViews.size(), true);
        }

        public int findFirstPartiallyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
            }
            return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
        }

        public int findFirstVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(this.mViews.size() - 1, -1, false);
            }
            return findOneVisibleChild(0, this.mViews.size(), false);
        }

        public int findLastCompletelyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(0, this.mViews.size(), true);
            }
            return findOneVisibleChild(this.mViews.size() - 1, -1, true);
        }

        public int findLastPartiallyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
            }
            return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
        }

        public int findLastVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(0, this.mViews.size(), false);
            }
            return findOneVisibleChild(this.mViews.size() - 1, -1, false);
        }

        public int findOnePartiallyOrCompletelyVisibleChild(int i11, int i12, boolean z11, boolean z12, boolean z13) {
            int i13;
            boolean z14;
            int startAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            if (i12 > i11) {
                i13 = 1;
            } else {
                i13 = -1;
            }
            while (i11 != i12) {
                View view = this.mViews.get(i11);
                int decoratedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
                boolean z15 = false;
                if (!z13 ? decoratedStart >= endAfterPadding : decoratedStart > endAfterPadding) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                if (!z13 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                    z15 = true;
                }
                if (z14 && z15) {
                    if (!z11 || !z12) {
                        if (z12) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i11 += i13;
            }
            return -1;
        }

        public int findOnePartiallyVisibleChild(int i11, int i12, boolean z11) {
            return findOnePartiallyOrCompletelyVisibleChild(i11, i12, false, false, z11);
        }

        public int findOneVisibleChild(int i11, int i12, boolean z11) {
            return findOnePartiallyOrCompletelyVisibleChild(i11, i12, z11, true, false);
        }

        public int getDeletedSize() {
            return this.mDeletedSize;
        }

        public int getEndLine(int i11) {
            int i12 = this.mCachedEnd;
            if (i12 != Integer.MIN_VALUE) {
                return i12;
            }
            if (this.mViews.size() == 0) {
                return i11;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        public View getFocusableViewAfter(int i11, int i12) {
            View view = null;
            if (i12 != -1) {
                int size = this.mViews.size() - 1;
                while (size >= 0) {
                    View view2 = this.mViews.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view2) >= i11) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.mReverseLayout && staggeredGridLayoutManager2.getPosition(view2) <= i11) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.mViews.size();
                int i13 = 0;
                while (i13 < size2) {
                    View view3 = this.mViews.get(i13);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.mReverseLayout && staggeredGridLayoutManager3.getPosition(view3) <= i11) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.mReverseLayout && staggeredGridLayoutManager4.getPosition(view3) >= i11) || !view3.hasFocusable()) {
                        break;
                    }
                    i13++;
                    view = view3;
                }
            }
            return view;
        }

        public LayoutParams getLayoutParams(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        public int getStartLine(int i11) {
            int i12 = this.mCachedStart;
            if (i12 != Integer.MIN_VALUE) {
                return i12;
            }
            if (this.mViews.size() == 0) {
                return i11;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }

        public void invalidateCache() {
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        public void onOffset(int i11) {
            int i12 = this.mCachedStart;
            if (i12 != Integer.MIN_VALUE) {
                this.mCachedStart = i12 + i11;
            }
            int i13 = this.mCachedEnd;
            if (i13 != Integer.MIN_VALUE) {
                this.mCachedEnd = i13 + i11;
            }
        }

        public void popEnd() {
            int size = this.mViews.size();
            View remove = this.mViews.remove(size - 1);
            LayoutParams layoutParams = getLayoutParams(remove);
            layoutParams.mSpan = null;
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(remove);
            }
            if (size == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        public void popStart() {
            View remove = this.mViews.remove(0);
            LayoutParams layoutParams = getLayoutParams(remove);
            layoutParams.mSpan = null;
            if (this.mViews.size() == 0) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(remove);
            }
            this.mCachedStart = Integer.MIN_VALUE;
        }

        public void prependToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(0, view);
            this.mCachedStart = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }

        public void setLine(int i11) {
            this.mCachedStart = i11;
            this.mCachedEnd = i11;
        }

        public int getEndLine() {
            int i11 = this.mCachedEnd;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        public int getStartLine() {
            int i11 = this.mCachedStart;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }
    }

    public static class LazySpanLookup {
        private static final int MIN_SIZE = 10;
        int[] mData;
        List<FullSpanItem> mFullSpanItems;

        private int invalidateFullSpansAfter(int i11) {
            if (this.mFullSpanItems == null) {
                return -1;
            }
            FullSpanItem fullSpanItem = getFullSpanItem(i11);
            if (fullSpanItem != null) {
                this.mFullSpanItems.remove(fullSpanItem);
            }
            int size = this.mFullSpanItems.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size) {
                    i12 = -1;
                    break;
                } else if (this.mFullSpanItems.get(i12).mPosition >= i11) {
                    break;
                } else {
                    i12++;
                }
            }
            if (i12 == -1) {
                return -1;
            }
            this.mFullSpanItems.remove(i12);
            return this.mFullSpanItems.get(i12).mPosition;
        }

        private void offsetFullSpansForAddition(int i11, int i12) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                    int i13 = fullSpanItem.mPosition;
                    if (i13 >= i11) {
                        fullSpanItem.mPosition = i13 + i12;
                    }
                }
            }
        }

        private void offsetFullSpansForRemoval(int i11, int i12) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list != null) {
                int i13 = i11 + i12;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                    int i14 = fullSpanItem.mPosition;
                    if (i14 >= i11) {
                        if (i14 < i13) {
                            this.mFullSpanItems.remove(size);
                        } else {
                            fullSpanItem.mPosition = i14 - i12;
                        }
                    }
                }
            }
        }

        public void addFullSpanItem(FullSpanItem fullSpanItem) {
            if (this.mFullSpanItems == null) {
                this.mFullSpanItems = new ArrayList();
            }
            int size = this.mFullSpanItems.size();
            for (int i11 = 0; i11 < size; i11++) {
                FullSpanItem fullSpanItem2 = this.mFullSpanItems.get(i11);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.mFullSpanItems.remove(i11);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.mFullSpanItems.add(i11, fullSpanItem);
                    return;
                }
            }
            this.mFullSpanItems.add(fullSpanItem);
        }

        public void clear() {
            int[] iArr = this.mData;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.mFullSpanItems = null;
        }

        public void ensureSize(int i11) {
            int[] iArr = this.mData;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i11, 10) + 1)];
                this.mData = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i11 >= iArr.length) {
                int[] iArr3 = new int[sizeForPosition(i11)];
                this.mData = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.mData;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int forceInvalidateAfter(int i11) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.mFullSpanItems.get(size).mPosition >= i11) {
                        this.mFullSpanItems.remove(size);
                    }
                }
            }
            return invalidateAfter(i11);
        }

        public FullSpanItem getFirstFullSpanItemInRange(int i11, int i12, int i13, boolean z11) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i14 = 0; i14 < size; i14++) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(i14);
                int i15 = fullSpanItem.mPosition;
                if (i15 >= i12) {
                    return null;
                }
                if (i15 >= i11 && (i13 == 0 || fullSpanItem.mGapDir == i13 || (z11 && fullSpanItem.mHasUnwantedGapAfter))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem getFullSpanItem(int i11) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                if (fullSpanItem.mPosition == i11) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public int getSpan(int i11) {
            int[] iArr = this.mData;
            if (iArr == null || i11 >= iArr.length) {
                return -1;
            }
            return iArr[i11];
        }

        public int invalidateAfter(int i11) {
            int[] iArr = this.mData;
            if (iArr == null || i11 >= iArr.length) {
                return -1;
            }
            int invalidateFullSpansAfter = invalidateFullSpansAfter(i11);
            if (invalidateFullSpansAfter == -1) {
                int[] iArr2 = this.mData;
                Arrays.fill(iArr2, i11, iArr2.length, -1);
                return this.mData.length;
            }
            int min = Math.min(invalidateFullSpansAfter + 1, this.mData.length);
            Arrays.fill(this.mData, i11, min, -1);
            return min;
        }

        public void offsetForAddition(int i11, int i12) {
            int[] iArr = this.mData;
            if (iArr != null && i11 < iArr.length) {
                int i13 = i11 + i12;
                ensureSize(i13);
                int[] iArr2 = this.mData;
                System.arraycopy(iArr2, i11, iArr2, i13, (iArr2.length - i11) - i12);
                Arrays.fill(this.mData, i11, i13, -1);
                offsetFullSpansForAddition(i11, i12);
            }
        }

        public void offsetForRemoval(int i11, int i12) {
            int[] iArr = this.mData;
            if (iArr != null && i11 < iArr.length) {
                int i13 = i11 + i12;
                ensureSize(i13);
                int[] iArr2 = this.mData;
                System.arraycopy(iArr2, i13, iArr2, i11, (iArr2.length - i11) - i12);
                int[] iArr3 = this.mData;
                Arrays.fill(iArr3, iArr3.length - i12, iArr3.length, -1);
                offsetFullSpansForRemoval(i11, i12);
            }
        }

        public void setSpan(int i11, Span span) {
            ensureSize(i11);
            this.mData[i11] = span.mIndex;
        }

        public int sizeForPosition(int i11) {
            int length = this.mData.length;
            while (length <= i11) {
                length *= 2;
            }
            return length;
        }

        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                public FullSpanItem[] newArray(int i11) {
                    return new FullSpanItem[i11];
                }
            };
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            public FullSpanItem(Parcel parcel) {
                this.mPosition = parcel.readInt();
                this.mGapDir = parcel.readInt();
                this.mHasUnwantedGapAfter = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.mGapPerSpan = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int describeContents() {
                return 0;
            }

            public int getGapForSpan(int i11) {
                int[] iArr = this.mGapPerSpan;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i11];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + AbstractJsonLexerKt.END_OBJ;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.mGapDir);
                parcel.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] iArr = this.mGapPerSpan;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.mGapPerSpan);
            }

            public FullSpanItem() {
            }
        }
    }

    public StaggeredGridLayoutManager(int i11, int i12) {
        this.mOrientation = i12;
        setSpanCount(i11);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void measureChildWithDecorationsAndMargin(View view, int i11, int i12, boolean z11) {
        boolean z12;
        calculateItemDecorationsForChild(view, this.mTmpRect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i13 = layoutParams.leftMargin;
        Rect rect = this.mTmpRect;
        int updateSpecWithExtra = updateSpecWithExtra(i11, i13 + rect.left, layoutParams.rightMargin + rect.right);
        int i14 = layoutParams.topMargin;
        Rect rect2 = this.mTmpRect;
        int updateSpecWithExtra2 = updateSpecWithExtra(i12, i14 + rect2.top, layoutParams.bottomMargin + rect2.bottom);
        if (z11) {
            z12 = shouldReMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        } else {
            z12 = shouldMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        }
        if (z12) {
            view.measure(updateSpecWithExtra, updateSpecWithExtra2);
        }
    }
}
