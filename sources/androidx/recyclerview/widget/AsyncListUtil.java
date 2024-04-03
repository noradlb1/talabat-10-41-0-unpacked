package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

public class AsyncListUtil<T> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    int mDisplayedGeneration = 0;
    int mItemCount = 0;
    private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    final SparseIntArray mMissingPositions = new SparseIntArray();
    final int[] mPrevRange = new int[2];
    int mRequestedGeneration = 0;
    private int mScrollHint = 0;
    final Class<T> mTClass;
    final TileList<T> mTileList;
    final int mTileSize;
    final int[] mTmpRange = new int[2];
    final int[] mTmpRangeExtended = new int[2];
    final ViewCallback mViewCallback;

    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(@NonNull T[] tArr, int i11, int i12);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] tArr, int i11) {
        }

        @WorkerThread
        public abstract int refreshData();
    }

    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i11) {
            int i12;
            int i13 = iArr[1];
            int i14 = iArr[0];
            int i15 = (i13 - i14) + 1;
            int i16 = i15 / 2;
            if (i11 == 1) {
                i12 = i15;
            } else {
                i12 = i16;
            }
            iArr2[0] = i14 - i12;
            if (i11 != 2) {
                i15 = i16;
            }
            iArr2[1] = i13 + i15;
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i11);
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i11, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        AnonymousClass1 r02 = new ThreadUtil.MainThreadCallback<T>() {
            private boolean isRequestedGeneration(int i11) {
                return i11 == AsyncListUtil.this.mRequestedGeneration;
            }

            private void recycleAllTiles() {
                for (int i11 = 0; i11 < AsyncListUtil.this.mTileList.size(); i11++) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.mBackgroundProxy.recycleTile(asyncListUtil.mTileList.getAtIndex(i11));
                }
                AsyncListUtil.this.mTileList.clear();
            }

            public void addTile(int i11, TileList.Tile<T> tile) {
                if (!isRequestedGeneration(i11)) {
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(tile);
                    return;
                }
                TileList.Tile<T> addOrReplace = AsyncListUtil.this.mTileList.addOrReplace(tile);
                if (addOrReplace != null) {
                    Log.e(AsyncListUtil.TAG, "duplicate tile @" + addOrReplace.mStartPosition);
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(addOrReplace);
                }
                int i12 = tile.mStartPosition + tile.mItemCount;
                int i13 = 0;
                while (i13 < AsyncListUtil.this.mMissingPositions.size()) {
                    int keyAt = AsyncListUtil.this.mMissingPositions.keyAt(i13);
                    if (tile.mStartPosition > keyAt || keyAt >= i12) {
                        i13++;
                    } else {
                        AsyncListUtil.this.mMissingPositions.removeAt(i13);
                        AsyncListUtil.this.mViewCallback.onItemLoaded(keyAt);
                    }
                }
            }

            public void removeTile(int i11, int i12) {
                if (isRequestedGeneration(i11)) {
                    TileList.Tile<T> removeAtPos = AsyncListUtil.this.mTileList.removeAtPos(i12);
                    if (removeAtPos == null) {
                        Log.e(AsyncListUtil.TAG, "tile not found @" + i12);
                        return;
                    }
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(removeAtPos);
                }
            }

            public void updateItemCount(int i11, int i12) {
                if (isRequestedGeneration(i11)) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.mItemCount = i12;
                    asyncListUtil.mViewCallback.onDataRefresh();
                    AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                    asyncListUtil2.mDisplayedGeneration = asyncListUtil2.mRequestedGeneration;
                    recycleAllTiles();
                    AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                    asyncListUtil3.mAllowScrollHints = false;
                    asyncListUtil3.updateRange();
                }
            }
        };
        this.mMainThreadCallback = r02;
        AnonymousClass2 r12 = new ThreadUtil.BackgroundCallback<T>() {
            private int mFirstRequiredTileStart;
            private int mGeneration;
            private int mItemCount;
            private int mLastRequiredTileStart;
            final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
            private TileList.Tile<T> mRecycledRoot;

            private TileList.Tile<T> acquireTile() {
                TileList.Tile<T> tile = this.mRecycledRoot;
                if (tile != null) {
                    this.mRecycledRoot = tile.mNext;
                    return tile;
                }
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                return new TileList.Tile<>(asyncListUtil.mTClass, asyncListUtil.mTileSize);
            }

            private void addTile(TileList.Tile<T> tile) {
                this.mLoadedTiles.put(tile.mStartPosition, true);
                AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, tile);
            }

            private void flushTileCache(int i11) {
                int maxCachedTiles = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
                while (this.mLoadedTiles.size() >= maxCachedTiles) {
                    int keyAt = this.mLoadedTiles.keyAt(0);
                    SparseBooleanArray sparseBooleanArray = this.mLoadedTiles;
                    int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                    int i12 = this.mFirstRequiredTileStart - keyAt;
                    int i13 = keyAt2 - this.mLastRequiredTileStart;
                    if (i12 > 0 && (i12 >= i13 || i11 == 2)) {
                        removeTile(keyAt);
                    } else if (i13 <= 0) {
                        return;
                    } else {
                        if (i12 < i13 || i11 == 1) {
                            removeTile(keyAt2);
                        } else {
                            return;
                        }
                    }
                }
            }

            private int getTileStart(int i11) {
                return i11 - (i11 % AsyncListUtil.this.mTileSize);
            }

            private boolean isTileLoaded(int i11) {
                return this.mLoadedTiles.get(i11);
            }

            private void log(String str, Object... objArr) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[BKGR] ");
                sb2.append(String.format(str, objArr));
            }

            private void removeTile(int i11) {
                this.mLoadedTiles.delete(i11);
                AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, i11);
            }

            private void requestTiles(int i11, int i12, int i13, boolean z11) {
                int i14;
                int i15 = i11;
                while (i15 <= i12) {
                    if (z11) {
                        i14 = (i12 + i11) - i15;
                    } else {
                        i14 = i15;
                    }
                    AsyncListUtil.this.mBackgroundProxy.loadTile(i14, i13);
                    i15 += AsyncListUtil.this.mTileSize;
                }
            }

            public void loadTile(int i11, int i12) {
                if (!isTileLoaded(i11)) {
                    TileList.Tile acquireTile = acquireTile();
                    acquireTile.mStartPosition = i11;
                    int min = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - i11);
                    acquireTile.mItemCount = min;
                    AsyncListUtil.this.mDataCallback.fillData(acquireTile.mItems, acquireTile.mStartPosition, min);
                    flushTileCache(i12);
                    addTile(acquireTile);
                }
            }

            public void recycleTile(TileList.Tile<T> tile) {
                AsyncListUtil.this.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
                tile.mNext = this.mRecycledRoot;
                this.mRecycledRoot = tile;
            }

            public void refresh(int i11) {
                this.mGeneration = i11;
                this.mLoadedTiles.clear();
                int refreshData = AsyncListUtil.this.mDataCallback.refreshData();
                this.mItemCount = refreshData;
                AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, refreshData);
            }

            public void updateRange(int i11, int i12, int i13, int i14, int i15) {
                if (i11 <= i12) {
                    int tileStart = getTileStart(i11);
                    int tileStart2 = getTileStart(i12);
                    this.mFirstRequiredTileStart = getTileStart(i13);
                    int tileStart3 = getTileStart(i14);
                    this.mLastRequiredTileStart = tileStart3;
                    if (i15 == 1) {
                        requestTiles(this.mFirstRequiredTileStart, tileStart2, i15, true);
                        requestTiles(tileStart2 + AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, i15, false);
                        return;
                    }
                    requestTiles(tileStart, tileStart3, i15, false);
                    requestTiles(this.mFirstRequiredTileStart, tileStart - AsyncListUtil.this.mTileSize, i15, true);
                }
            }
        };
        this.mBackgroundCallback = r12;
        this.mTClass = cls;
        this.mTileSize = i11;
        this.mDataCallback = dataCallback;
        this.mViewCallback = viewCallback;
        this.mTileList = new TileList<>(i11);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.mMainThreadProxy = messageThreadUtil.getMainThreadProxy(r02);
        this.mBackgroundProxy = messageThreadUtil.getBackgroundProxy(r12);
        refresh();
    }

    private boolean isRefreshPending() {
        return this.mRequestedGeneration != this.mDisplayedGeneration;
    }

    @Nullable
    public T getItem(int i11) {
        if (i11 < 0 || i11 >= this.mItemCount) {
            throw new IndexOutOfBoundsException(i11 + " is not within 0 and " + this.mItemCount);
        }
        T itemAt = this.mTileList.getItemAt(i11);
        if (itemAt == null && !isRefreshPending()) {
            this.mMissingPositions.put(i11, 0);
        }
        return itemAt;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public void log(String str, Object... objArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[MAIN] ");
        sb2.append(String.format(str, objArr));
    }

    public void onRangeChanged() {
        if (!isRefreshPending()) {
            updateRange();
            this.mAllowScrollHints = true;
        }
    }

    public void refresh() {
        this.mMissingPositions.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int i11 = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = i11;
        backgroundCallback.refresh(i11);
    }

    public void updateRange() {
        int i11;
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] iArr = this.mTmpRange;
        int i12 = iArr[0];
        int i13 = iArr[1];
        if (i12 <= i13 && i12 >= 0 && i13 < this.mItemCount) {
            if (!this.mAllowScrollHints) {
                this.mScrollHint = 0;
            } else {
                int[] iArr2 = this.mPrevRange;
                if (i12 > iArr2[1] || (i11 = iArr2[0]) > i13) {
                    this.mScrollHint = 0;
                } else if (i12 < i11) {
                    this.mScrollHint = 1;
                } else if (i12 > i11) {
                    this.mScrollHint = 2;
                }
            }
            int[] iArr3 = this.mPrevRange;
            iArr3[0] = i12;
            iArr3[1] = i13;
            this.mViewCallback.extendRangeInto(iArr, this.mTmpRangeExtended, this.mScrollHint);
            int[] iArr4 = this.mTmpRangeExtended;
            iArr4[0] = Math.min(this.mTmpRange[0], Math.max(iArr4[0], 0));
            int[] iArr5 = this.mTmpRangeExtended;
            iArr5[1] = Math.max(this.mTmpRange[1], Math.min(iArr5[1], this.mItemCount - 1));
            ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
            int[] iArr6 = this.mTmpRange;
            int i14 = iArr6[0];
            int i15 = iArr6[1];
            int[] iArr7 = this.mTmpRangeExtended;
            backgroundCallback.updateRange(i14, i15, iArr7[0], iArr7[1], this.mScrollHint);
        }
    }
}
