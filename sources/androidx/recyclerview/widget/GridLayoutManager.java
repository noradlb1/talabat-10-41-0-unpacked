package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets = new Rect();
    boolean mPendingSpanCountChange = false;
    final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
    final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
    View[] mSet;
    int mSpanCount = -1;
    SpanSizeLookup mSpanSizeLookup = new DefaultSpanSizeLookup();
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public int getSpanIndex(int i11, int i12) {
            return i11 % i12;
        }

        public int getSpanSize(int i11) {
            return 1;
        }
    }

    public static abstract class SpanSizeLookup {
        private boolean mCacheSpanGroupIndices = false;
        private boolean mCacheSpanIndices = false;
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        final SparseIntArray mSpanIndexCache = new SparseIntArray();

        public static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i11) {
            int size = sparseIntArray.size() - 1;
            int i12 = 0;
            while (i12 <= size) {
                int i13 = (i12 + size) >>> 1;
                if (sparseIntArray.keyAt(i13) < i11) {
                    i12 = i13 + 1;
                } else {
                    size = i13 - 1;
                }
            }
            int i14 = i12 - 1;
            if (i14 < 0 || i14 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i14);
        }

        public int getCachedSpanGroupIndex(int i11, int i12) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i11, i12);
            }
            int i13 = this.mSpanGroupIndexCache.get(i11, -1);
            if (i13 != -1) {
                return i13;
            }
            int spanGroupIndex = getSpanGroupIndex(i11, i12);
            this.mSpanGroupIndexCache.put(i11, spanGroupIndex);
            return spanGroupIndex;
        }

        public int getCachedSpanIndex(int i11, int i12) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i11, i12);
            }
            int i13 = this.mSpanIndexCache.get(i11, -1);
            if (i13 != -1) {
                return i13;
            }
            int spanIndex = getSpanIndex(i11, i12);
            this.mSpanIndexCache.put(i11, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i11, int i12) {
            int i13;
            int i14;
            int i15;
            int findFirstKeyLessThan;
            if (!this.mCacheSpanGroupIndices || (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i11)) == -1) {
                i15 = 0;
                i14 = 0;
                i13 = 0;
            } else {
                i15 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
                i14 = findFirstKeyLessThan + 1;
                i13 = getCachedSpanIndex(findFirstKeyLessThan, i12) + getSpanSize(findFirstKeyLessThan);
                if (i13 == i12) {
                    i15++;
                    i13 = 0;
                }
            }
            int spanSize = getSpanSize(i11);
            while (i14 < i11) {
                int spanSize2 = getSpanSize(i14);
                int i16 = i13 + spanSize2;
                if (i16 == i12) {
                    i15++;
                    i16 = 0;
                } else if (i16 > i12) {
                    i15++;
                    i16 = spanSize2;
                }
                i14++;
            }
            if (i13 + spanSize > i12) {
                return i15 + 1;
            }
            return i15;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getSpanIndex(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.getSpanSize(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.mCacheSpanIndices
                if (r2 == 0) goto L_0x0020
                android.util.SparseIntArray r2 = r5.mSpanIndexCache
                int r2 = findFirstKeyLessThan(r2, r6)
                if (r2 < 0) goto L_0x0020
                android.util.SparseIntArray r3 = r5.mSpanIndexCache
                int r3 = r3.get(r2)
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                goto L_0x0030
            L_0x0020:
                r2 = r1
                r3 = r2
            L_0x0022:
                if (r2 >= r6) goto L_0x0033
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x002d
                r3 = r1
                goto L_0x0030
            L_0x002d:
                if (r3 <= r7) goto L_0x0030
                r3 = r4
            L_0x0030:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0033:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x0037
                return r3
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i11);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z11) {
            if (!z11) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z11;
        }

        public void setSpanIndexCacheEnabled(boolean z11) {
            if (!z11) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z11;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        setSpanCount(RecyclerView.LayoutManager.getProperties(context, attributeSet, i11, i12).spanCount);
    }

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int i11, boolean z11) {
        int i12;
        int i13;
        int i14;
        int i15 = 0;
        if (z11) {
            i14 = 1;
            i12 = i11;
            i13 = 0;
        } else {
            i13 = i11 - 1;
            i12 = -1;
            i14 = -1;
        }
        while (i13 != i12) {
            View view = this.mSet[i13];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int spanSize = getSpanSize(recycler, state, getPosition(view));
            layoutParams.mSpanSize = spanSize;
            layoutParams.mSpanIndex = i15;
            i15 += spanSize;
            i13 += i14;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i11).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, layoutParams.getSpanIndex());
        }
    }

    private void calculateItemBorders(int i11) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i11);
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.State state) {
        int i11;
        if (!(getChildCount() == 0 || state.getItemCount() == 0)) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount);
                int min = Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int max = Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int cachedSpanGroupIndex3 = this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                if (this.mShouldReverseLayout) {
                    i11 = Math.max(0, (cachedSpanGroupIndex3 - max) - 1);
                } else {
                    i11 = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return i11;
                }
                return Math.round((((float) i11) * (((float) Math.abs(this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart))) / ((float) ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount)) + 1)))) + ((float) (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart))));
            }
        }
        return 0;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.State state) {
        if (!(getChildCount() == 0 || state.getItemCount() == 0)) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                }
                int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart);
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                return (int) ((((float) decoratedEnd) / ((float) ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - cachedSpanGroupIndex) + 1))) * ((float) (this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1)));
            }
        }
        return 0;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i11) {
        boolean z11;
        if (i11 == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        int spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
        if (z11) {
            while (spanIndex > 0) {
                int i12 = anchorInfo.mPosition;
                if (i12 > 0) {
                    int i13 = i12 - 1;
                    anchorInfo.mPosition = i13;
                    spanIndex = getSpanIndex(recycler, state, i13);
                } else {
                    return;
                }
            }
            return;
        }
        int itemCount = state.getItemCount() - 1;
        int i14 = anchorInfo.mPosition;
        while (i14 < itemCount) {
            int i15 = i14 + 1;
            int spanIndex2 = getSpanIndex(recycler, state, i15);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i14 = i15;
            spanIndex = spanIndex2;
        }
        anchorInfo.mPosition = i14;
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    private int getSpanGroupIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i11) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i11, this.mSpanCount);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i11);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. " + i11);
        return 0;
    }

    private int getSpanIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i11) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i11, this.mSpanCount);
        }
        int i12 = this.mPreLayoutSpanIndexCache.get(i11, -1);
        if (i12 != -1) {
            return i12;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i11);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i11);
        return 0;
    }

    private int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int i11) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(i11);
        }
        int i12 = this.mPreLayoutSpanSizeCache.get(i11, -1);
        if (i12 != -1) {
            return i12;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i11);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getSpanSize(convertPreLayoutPositionToPostLayout);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i11);
        return 1;
    }

    private void guessMeasurement(float f11, int i11) {
        calculateItemBorders(Math.max(Math.round(f11 * ((float) this.mSpanCount)), i11));
    }

    private void measureChild(View view, int i11, boolean z11) {
        int i12;
        int i13;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i14 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i15 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
        if (this.mOrientation == 1) {
            i12 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i11, i15, layoutParams.width, false);
            i13 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i14, layoutParams.height, true);
        } else {
            int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i11, i14, layoutParams.height, false);
            int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i15, layoutParams.width, true);
            i13 = childMeasureSpec;
            i12 = childMeasureSpec2;
        }
        measureChildWithDecorationsAndMargin(view, i12, i13, z11);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i11, int i12, boolean z11) {
        boolean z12;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z11) {
            z12 = shouldReMeasureChild(view, i11, i12, layoutParams);
        } else {
            z12 = shouldMeasureChild(view, i11, i12, layoutParams);
        }
        if (z12) {
            view.measure(i11, i12);
        }
    }

    private void updateMeasurements() {
        int i11;
        int i12;
        if (getOrientation() == 1) {
            i12 = getWidth() - getPaddingRight();
            i11 = getPaddingLeft();
        } else {
            i12 = getHeight() - getPaddingBottom();
            i11 = getPaddingTop();
        }
        calculateItemBorders(i12 - i11);
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i11 = this.mSpanCount;
        for (int i12 = 0; i12 < this.mSpanCount && layoutState.hasMore(state) && i11 > 0; i12++) {
            int i13 = layoutState.mCurrentPosition;
            layoutPrefetchRegistry.addPosition(i13, Math.max(0, layoutState.mScrollingOffset));
            i11 -= this.mSpanSizeLookup.getSpanSize(i13);
            layoutState.mCurrentPosition += layoutState.mItemDirection;
        }
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(state);
        }
        return super.computeHorizontalScrollOffset(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(state);
        }
        return super.computeHorizontalScrollRange(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(state);
        }
        return super.computeVerticalScrollOffset(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(state);
        }
        return super.computeVerticalScrollRange(state);
    }

    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z11, boolean z12) {
        int i11;
        int i12;
        int childCount = getChildCount();
        int i13 = 1;
        if (z12) {
            i12 = getChildCount() - 1;
            i11 = -1;
            i13 = -1;
        } else {
            i11 = childCount;
            i12 = 0;
        }
        int itemCount = state.getItemCount();
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        while (i12 != i11) {
            View childAt = getChildAt(i12);
            int position = getPosition(childAt);
            if (position >= 0 && position < itemCount && getSpanIndex(recycler, state, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i12 += i13;
        }
        if (view != null) {
            return view;
        }
        return view2;
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

    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    public int getSpaceForSpanRange(int i11, int i12) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i12 + i11] - iArr[i11];
        }
        int[] iArr2 = this.mCachedBorders;
        int i13 = this.mSpanCount;
        return iArr2[i13 - i11] - iArr2[(i13 - i11) - i12];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        boolean z11;
        int i11;
        boolean z12;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        View next;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        LinearLayoutManager.LayoutState layoutState2 = layoutState;
        LinearLayoutManager.LayoutChunkResult layoutChunkResult2 = layoutChunkResult;
        int modeInOther = this.mOrientationHelper.getModeInOther();
        if (modeInOther != 1073741824) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getChildCount() > 0) {
            i11 = this.mCachedBorders[this.mSpanCount];
        } else {
            i11 = 0;
        }
        if (z11) {
            updateMeasurements();
        }
        if (layoutState2.mItemDirection == 1) {
            z12 = true;
        } else {
            z12 = false;
        }
        int i26 = this.mSpanCount;
        if (!z12) {
            i26 = getSpanIndex(recycler2, state2, layoutState2.mCurrentPosition) + getSpanSize(recycler2, state2, layoutState2.mCurrentPosition);
        }
        int i27 = 0;
        while (i27 < this.mSpanCount && layoutState2.hasMore(state2) && i26 > 0) {
            int i28 = layoutState2.mCurrentPosition;
            int spanSize = getSpanSize(recycler2, state2, i28);
            if (spanSize <= this.mSpanCount) {
                i26 -= spanSize;
                if (i26 < 0 || (next = layoutState2.next(recycler2)) == null) {
                    break;
                }
                this.mSet[i27] = next;
                i27++;
            } else {
                throw new IllegalArgumentException("Item at position " + i28 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
        }
        if (i27 == 0) {
            layoutChunkResult2.mFinished = true;
            return;
        }
        assignSpans(recycler2, state2, i27, z12);
        float f11 = 0.0f;
        int i29 = 0;
        for (int i31 = 0; i31 < i27; i31++) {
            View view = this.mSet[i31];
            if (layoutState2.mScrapList == null) {
                if (z12) {
                    addView(view);
                } else {
                    addView(view, 0);
                }
            } else if (z12) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, 0);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            measureChild(view, modeInOther, false);
            int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view);
            if (decoratedMeasurement > i29) {
                i29 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther = (((float) this.mOrientationHelper.getDecoratedMeasurementInOther(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).mSpanSize);
            if (decoratedMeasurementInOther > f11) {
                f11 = decoratedMeasurementInOther;
            }
        }
        if (z11) {
            guessMeasurement(f11, i11);
            i29 = 0;
            for (int i32 = 0; i32 < i27; i32++) {
                View view2 = this.mSet[i32];
                measureChild(view2, 1073741824, true);
                int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(view2);
                if (decoratedMeasurement2 > i29) {
                    i29 = decoratedMeasurement2;
                }
            }
        }
        for (int i33 = 0; i33 < i27; i33++) {
            View view3 = this.mSet[i33];
            if (this.mOrientationHelper.getDecoratedMeasurement(view3) != i29) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.mDecorInsets;
                int i34 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i35 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
                if (this.mOrientation == 1) {
                    i25 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i35, layoutParams.width, false);
                    i24 = View.MeasureSpec.makeMeasureSpec(i29 - i34, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i29 - i35, 1073741824);
                    i24 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i34, layoutParams.height, false);
                    i25 = makeMeasureSpec;
                }
                measureChildWithDecorationsAndMargin(view3, i25, i24, true);
            }
        }
        layoutChunkResult2.mConsumed = i29;
        if (this.mOrientation == 1) {
            if (layoutState2.mLayoutDirection == -1) {
                i15 = layoutState2.mOffset;
                i23 = i15 - i29;
            } else {
                i23 = layoutState2.mOffset;
                i15 = i23 + i29;
            }
            i12 = i23;
            i14 = 0;
            i13 = 0;
        } else {
            if (layoutState2.mLayoutDirection == -1) {
                i22 = layoutState2.mOffset;
                i21 = i22 - i29;
            } else {
                i21 = layoutState2.mOffset;
                i22 = i21 + i29;
            }
            i13 = i21;
            i12 = 0;
            i14 = i22;
            i15 = 0;
        }
        int i36 = 0;
        while (i36 < i27) {
            View view4 = this.mSet[i36];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - layoutParams2.mSpanIndex];
                    i19 = i15;
                    i18 = paddingLeft;
                    i17 = paddingLeft - this.mOrientationHelper.getDecoratedMeasurementInOther(view4);
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.mCachedBorders[layoutParams2.mSpanIndex];
                    i19 = i15;
                    i17 = paddingLeft2;
                    i18 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingLeft2;
                }
                i16 = i12;
            } else {
                int paddingTop = getPaddingTop() + this.mCachedBorders[layoutParams2.mSpanIndex];
                i16 = paddingTop;
                i18 = i14;
                i17 = i13;
                i19 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingTop;
            }
            layoutDecoratedWithMargins(view4, i17, i16, i18, i19);
            if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                layoutChunkResult2.mIgnoreConsumed = true;
            }
            layoutChunkResult2.mFocusable |= view4.hasFocusable();
            i36++;
            i15 = i19;
            i14 = i18;
            i13 = i17;
            i12 = i16;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i11) {
        super.onAnchorReady(recycler, state, anchorInfo, i11);
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            ensureAnchorIsInCorrectSpan(recycler, state, anchorInfo, i11);
        }
        ensureViewSet();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d6, code lost:
        if (r13 == r7) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f6, code lost:
        if (r13 == r11) goto L_0x00b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.Recycler r26, androidx.recyclerview.widget.RecyclerView.State r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.findContainingItemView(r24)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r5 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r5
            int r6 = r5.mSpanIndex
            int r5 = r5.mSpanSize
            int r5 = r5 + r6
            android.view.View r7 = super.onFocusSearchFailed(r24, r25, r26, r27)
            if (r7 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r7 = r25
            int r7 = r0.convertFocusDirectionToLayoutDirection(r7)
            r9 = 1
            if (r7 != r9) goto L_0x002b
            r7 = r9
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            boolean r10 = r0.mShouldReverseLayout
            if (r7 == r10) goto L_0x0032
            r7 = r9
            goto L_0x0033
        L_0x0032:
            r7 = 0
        L_0x0033:
            r10 = -1
            if (r7 == 0) goto L_0x003e
            int r7 = r23.getChildCount()
            int r7 = r7 - r9
            r11 = r10
            r12 = r11
            goto L_0x0045
        L_0x003e:
            int r7 = r23.getChildCount()
            r11 = r7
            r12 = r9
            r7 = 0
        L_0x0045:
            int r13 = r0.mOrientation
            if (r13 != r9) goto L_0x0051
            boolean r13 = r23.isLayoutRTL()
            if (r13 == 0) goto L_0x0051
            r13 = r9
            goto L_0x0052
        L_0x0051:
            r13 = 0
        L_0x0052:
            int r14 = r0.getSpanGroupIndex(r1, r2, r7)
            r15 = r10
            r16 = r15
            r8 = 0
            r17 = 0
            r10 = r7
            r7 = r4
        L_0x005e:
            if (r10 == r11) goto L_0x0149
            int r9 = r0.getSpanGroupIndex(r1, r2, r10)
            android.view.View r1 = r0.getChildAt(r10)
            if (r1 != r3) goto L_0x006c
            goto L_0x0149
        L_0x006c:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0086
            if (r9 == r14) goto L_0x0086
            if (r4 == 0) goto L_0x0078
            goto L_0x0149
        L_0x0078:
            r18 = r3
            r21 = r7
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
            goto L_0x0135
        L_0x0086:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r9
            int r2 = r9.mSpanIndex
            r18 = r3
            int r3 = r9.mSpanSize
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x009e
            if (r2 != r6) goto L_0x009e
            if (r3 != r5) goto L_0x009e
            return r1
        L_0x009e:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00a6
            if (r4 == 0) goto L_0x00ae
        L_0x00a6:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00ba
            if (r7 != 0) goto L_0x00ba
        L_0x00ae:
            r21 = r7
        L_0x00b0:
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
        L_0x00b8:
            r11 = 1
            goto L_0x0105
        L_0x00ba:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r7
            int r7 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00d9
            if (r7 <= r8) goto L_0x00cf
        L_0x00ce:
            goto L_0x00b0
        L_0x00cf:
            if (r7 != r8) goto L_0x00fc
            if (r2 <= r15) goto L_0x00d5
            r7 = 1
            goto L_0x00d6
        L_0x00d5:
            r7 = 0
        L_0x00d6:
            if (r13 != r7) goto L_0x00fc
            goto L_0x00ce
        L_0x00d9:
            if (r4 != 0) goto L_0x00fc
            r19 = r8
            r20 = r11
            r8 = 0
            r11 = 1
            boolean r22 = r0.isViewPartiallyVisible(r1, r8, r11)
            if (r22 == 0) goto L_0x0100
            r8 = r17
            if (r7 <= r8) goto L_0x00ee
            r7 = r16
            goto L_0x0105
        L_0x00ee:
            if (r7 != r8) goto L_0x00f9
            r7 = r16
            if (r2 <= r7) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r11 = 0
        L_0x00f6:
            if (r13 != r11) goto L_0x0104
            goto L_0x00b8
        L_0x00f9:
            r7 = r16
            goto L_0x0104
        L_0x00fc:
            r19 = r8
            r20 = r11
        L_0x0100:
            r7 = r16
            r8 = r17
        L_0x0104:
            r11 = 0
        L_0x0105:
            if (r11 == 0) goto L_0x0135
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x0123
            int r4 = r9.mSpanIndex
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r2 = r3 - r2
            r15 = r4
            r16 = r7
            r17 = r8
            r7 = r21
            r4 = r1
            r8 = r2
            goto L_0x013d
        L_0x0123:
            int r7 = r9.mSpanIndex
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r17 = r3 - r2
            r16 = r7
            r8 = r19
            r7 = r1
            goto L_0x013d
        L_0x0135:
            r16 = r7
            r17 = r8
            r8 = r19
            r7 = r21
        L_0x013d:
            int r10 = r10 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r11 = r20
            r9 = 1
            goto L_0x005e
        L_0x0149:
            r21 = r7
            if (r4 == 0) goto L_0x014e
            goto L_0x0150
        L_0x014e:
            r4 = r21
        L_0x0150:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), spanGroupIndex, 1, false, false));
            return;
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanGroupIndex, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), false, false));
    }

    public void onItemsAdded(RecyclerView recyclerView, int i11, int i12) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i11, int i12, int i13) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i11, int i12) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i11, int i12, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        clearPreLayoutSpanMappingCache();
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSpanCountChange = false;
    }

    public int scrollHorizontallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i11, recycler, state);
    }

    public int scrollVerticallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i11, recycler, state);
    }

    public void setMeasuredDimension(Rect rect, int i11, int i12) {
        int i13;
        int i14;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i11, i12);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            i14 = RecyclerView.LayoutManager.chooseSize(i12, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            i13 = RecyclerView.LayoutManager.chooseSize(i11, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            i13 = RecyclerView.LayoutManager.chooseSize(i11, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            i14 = RecyclerView.LayoutManager.chooseSize(i12, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i13, i14);
    }

    public void setSpanCount(int i11) {
        if (i11 != this.mSpanCount) {
            this.mPendingSpanCountChange = true;
            if (i11 >= 1) {
                this.mSpanCount = i11;
                this.mSpanSizeLookup.invalidateSpanIndexCache();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i11);
        }
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    public void setStackFromEnd(boolean z11) {
        if (!z11) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z11) {
        this.mUsingSpansToEstimateScrollBarDimensions = z11;
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }

    public static int[] calculateItemBorders(int[] iArr, int i11, int i12) {
        int i13;
        if (!(iArr != null && iArr.length == i11 + 1 && iArr[iArr.length - 1] == i12)) {
            iArr = new int[(i11 + 1)];
        }
        int i14 = 0;
        iArr[0] = 0;
        int i15 = i12 / i11;
        int i16 = i12 % i11;
        int i17 = 0;
        for (int i18 = 1; i18 <= i11; i18++) {
            i14 += i16;
            if (i14 <= 0 || i11 - i14 >= i16) {
                i13 = i15;
            } else {
                i13 = i15 + 1;
                i14 -= i11;
            }
            i17 += i13;
            iArr[i18] = i17;
        }
        return iArr;
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex = -1;
        int mSpanSize = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
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

    public GridLayoutManager(Context context, int i11) {
        super(context);
        setSpanCount(i11);
    }

    public GridLayoutManager(Context context, int i11, int i12, boolean z11) {
        super(context, i12, z11);
        setSpanCount(i11);
    }
}
