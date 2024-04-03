package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class AdapterHelper implements OpReorderer.Callback {
    private static final boolean DEBUG = false;
    static final int POSITION_TYPE_INVISIBLE = 0;
    static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
    private static final String TAG = "AHT";
    final Callback mCallback;
    final boolean mDisableRecycler;
    private int mExistingUpdateTypes;
    Runnable mOnItemProcessedCallback;
    final OpReorderer mOpReorderer;
    final ArrayList<UpdateOp> mPendingUpdates;
    final ArrayList<UpdateOp> mPostponedList;
    private Pools.Pool<UpdateOp> mUpdateOpPool;

    public interface Callback {
        RecyclerView.ViewHolder findViewHolder(int i11);

        void markViewHoldersUpdated(int i11, int i12, Object obj);

        void offsetPositionsForAdd(int i11, int i12);

        void offsetPositionsForMove(int i11, int i12);

        void offsetPositionsForRemovingInvisible(int i11, int i12);

        void offsetPositionsForRemovingLaidOutOrNewView(int i11, int i12);

        void onDispatchFirstPass(UpdateOp updateOp);

        void onDispatchSecondPass(UpdateOp updateOp);
    }

    public static final class UpdateOp {
        static final int ADD = 1;
        static final int MOVE = 8;
        static final int POOL_SIZE = 30;
        static final int REMOVE = 2;
        static final int UPDATE = 4;
        int cmd;
        int itemCount;
        Object payload;
        int positionStart;

        public UpdateOp(int i11, int i12, int i13, Object obj) {
            this.cmd = i11;
            this.positionStart = i12;
            this.itemCount = i13;
            this.payload = obj;
        }

        public String cmdToString() {
            int i11 = this.cmd;
            return i11 != 1 ? i11 != 2 ? i11 != 4 ? i11 != 8 ? "??" : "mv" : "up" : "rm" : ProductAction.ACTION_ADD;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UpdateOp)) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int i11 = this.cmd;
            if (i11 != updateOp.cmd) {
                return false;
            }
            if (i11 == 8 && Math.abs(this.itemCount - this.positionStart) == 1 && this.itemCount == updateOp.positionStart && this.positionStart == updateOp.itemCount) {
                return true;
            }
            if (this.itemCount != updateOp.itemCount || this.positionStart != updateOp.positionStart) {
                return false;
            }
            Object obj2 = this.payload;
            if (obj2 != null) {
                if (!obj2.equals(updateOp.payload)) {
                    return false;
                }
            } else if (updateOp.payload != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
        }
    }

    public AdapterHelper(Callback callback) {
        this(callback, false);
    }

    private void applyAdd(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void applyMove(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void applyRemove(UpdateOp updateOp) {
        char c11;
        boolean z11;
        boolean z12;
        int i11 = updateOp.positionStart;
        int i12 = updateOp.itemCount + i11;
        char c12 = 65535;
        int i13 = i11;
        int i14 = 0;
        while (i13 < i12) {
            if (this.mCallback.findViewHolder(i13) != null || canFindInPreLayout(i13)) {
                if (c12 == 0) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(2, i11, i14, (Object) null));
                    z12 = true;
                } else {
                    z12 = false;
                }
                c11 = 1;
            } else {
                if (c12 == 1) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(2, i11, i14, (Object) null));
                    z11 = true;
                } else {
                    z11 = false;
                }
                c11 = 0;
            }
            if (z11) {
                i13 -= i14;
                i12 -= i14;
                i14 = 1;
            } else {
                i14++;
            }
            i13++;
            c12 = c11;
        }
        if (i14 != updateOp.itemCount) {
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(2, i11, i14, (Object) null);
        }
        if (c12 == 0) {
            dispatchAndUpdateViewHolders(updateOp);
        } else {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private void applyUpdate(UpdateOp updateOp) {
        int i11 = updateOp.positionStart;
        int i12 = updateOp.itemCount + i11;
        int i13 = 0;
        boolean z11 = true;
        int i14 = i11;
        while (i11 < i12) {
            if (this.mCallback.findViewHolder(i11) != null || canFindInPreLayout(i11)) {
                if (!z11) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(4, i14, i13, updateOp.payload));
                    i14 = i11;
                    i13 = 0;
                }
                z11 = true;
            } else {
                if (z11) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(4, i14, i13, updateOp.payload));
                    i14 = i11;
                    i13 = 0;
                }
                z11 = false;
            }
            i13++;
            i11++;
        }
        if (i13 != updateOp.itemCount) {
            Object obj = updateOp.payload;
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(4, i14, i13, obj);
        }
        if (!z11) {
            dispatchAndUpdateViewHolders(updateOp);
        } else {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private boolean canFindInPreLayout(int i11) {
        int size = this.mPostponedList.size();
        for (int i12 = 0; i12 < size; i12++) {
            UpdateOp updateOp = this.mPostponedList.get(i12);
            int i13 = updateOp.cmd;
            if (i13 == 8) {
                if (findPositionOffset(updateOp.itemCount, i12 + 1) == i11) {
                    return true;
                }
            } else if (i13 == 1) {
                int i14 = updateOp.positionStart;
                int i15 = updateOp.itemCount + i14;
                while (i14 < i15) {
                    if (findPositionOffset(i14, i12 + 1) == i11) {
                        return true;
                    }
                    i14++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void dispatchAndUpdateViewHolders(UpdateOp updateOp) {
        int i11;
        boolean z11;
        int i12 = updateOp.cmd;
        if (i12 == 1 || i12 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int updatePositionWithPostponed = updatePositionWithPostponed(updateOp.positionStart, i12);
        int i13 = updateOp.positionStart;
        int i14 = updateOp.cmd;
        if (i14 == 2) {
            i11 = 0;
        } else if (i14 == 4) {
            i11 = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + updateOp);
        }
        int i15 = 1;
        for (int i16 = 1; i16 < updateOp.itemCount; i16++) {
            int updatePositionWithPostponed2 = updatePositionWithPostponed(updateOp.positionStart + (i11 * i16), updateOp.cmd);
            int i17 = updateOp.cmd;
            if (i17 == 2 ? updatePositionWithPostponed2 != updatePositionWithPostponed : !(i17 == 4 && updatePositionWithPostponed2 == updatePositionWithPostponed + 1)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                i15++;
            } else {
                UpdateOp obtainUpdateOp = obtainUpdateOp(i17, updatePositionWithPostponed, i15, updateOp.payload);
                dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp, i13);
                recycleUpdateOp(obtainUpdateOp);
                if (updateOp.cmd == 4) {
                    i13 += i15;
                }
                i15 = 1;
                updatePositionWithPostponed = updatePositionWithPostponed2;
            }
        }
        Object obj = updateOp.payload;
        recycleUpdateOp(updateOp);
        if (i15 > 0) {
            UpdateOp obtainUpdateOp2 = obtainUpdateOp(updateOp.cmd, updatePositionWithPostponed, i15, obj);
            dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp2, i13);
            recycleUpdateOp(obtainUpdateOp2);
        }
    }

    private void postponeAndUpdateViewHolders(UpdateOp updateOp) {
        this.mPostponedList.add(updateOp);
        int i11 = updateOp.cmd;
        if (i11 == 1) {
            this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
        } else if (i11 == 2) {
            this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(updateOp.positionStart, updateOp.itemCount);
        } else if (i11 == 4) {
            this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
        } else if (i11 == 8) {
            this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    private int updatePositionWithPostponed(int i11, int i12) {
        int i13;
        int i14;
        for (int size = this.mPostponedList.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = this.mPostponedList.get(size);
            int i15 = updateOp.cmd;
            if (i15 == 8) {
                int i16 = updateOp.positionStart;
                int i17 = updateOp.itemCount;
                if (i16 < i17) {
                    i14 = i16;
                    i13 = i17;
                } else {
                    i13 = i16;
                    i14 = i17;
                }
                if (i11 < i14 || i11 > i13) {
                    if (i11 < i16) {
                        if (i12 == 1) {
                            updateOp.positionStart = i16 + 1;
                            updateOp.itemCount = i17 + 1;
                        } else if (i12 == 2) {
                            updateOp.positionStart = i16 - 1;
                            updateOp.itemCount = i17 - 1;
                        }
                    }
                } else if (i14 == i16) {
                    if (i12 == 1) {
                        updateOp.itemCount = i17 + 1;
                    } else if (i12 == 2) {
                        updateOp.itemCount = i17 - 1;
                    }
                    i11++;
                } else {
                    if (i12 == 1) {
                        updateOp.positionStart = i16 + 1;
                    } else if (i12 == 2) {
                        updateOp.positionStart = i16 - 1;
                    }
                    i11--;
                }
            } else {
                int i18 = updateOp.positionStart;
                if (i18 <= i11) {
                    if (i15 == 1) {
                        i11 -= updateOp.itemCount;
                    } else if (i15 == 2) {
                        i11 += updateOp.itemCount;
                    }
                } else if (i12 == 1) {
                    updateOp.positionStart = i18 + 1;
                } else if (i12 == 2) {
                    updateOp.positionStart = i18 - 1;
                }
            }
        }
        for (int size2 = this.mPostponedList.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.mPostponedList.get(size2);
            if (updateOp2.cmd == 8) {
                int i19 = updateOp2.itemCount;
                if (i19 == updateOp2.positionStart || i19 < 0) {
                    this.mPostponedList.remove(size2);
                    recycleUpdateOp(updateOp2);
                }
            } else if (updateOp2.itemCount <= 0) {
                this.mPostponedList.remove(size2);
                recycleUpdateOp(updateOp2);
            }
        }
        return i11;
    }

    public AdapterHelper addUpdateOp(UpdateOp... updateOpArr) {
        Collections.addAll(this.mPendingUpdates, updateOpArr);
        return this;
    }

    public int applyPendingUpdatesToPosition(int i11) {
        int size = this.mPendingUpdates.size();
        for (int i12 = 0; i12 < size; i12++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i12);
            int i13 = updateOp.cmd;
            if (i13 != 1) {
                if (i13 == 2) {
                    int i14 = updateOp.positionStart;
                    if (i14 <= i11) {
                        int i15 = updateOp.itemCount;
                        if (i14 + i15 > i11) {
                            return -1;
                        }
                        i11 -= i15;
                    } else {
                        continue;
                    }
                } else if (i13 == 8) {
                    int i16 = updateOp.positionStart;
                    if (i16 == i11) {
                        i11 = updateOp.itemCount;
                    } else {
                        if (i16 < i11) {
                            i11--;
                        }
                        if (updateOp.itemCount <= i11) {
                            i11++;
                        }
                    }
                }
            } else if (updateOp.positionStart <= i11) {
                i11 += updateOp.itemCount;
            }
        }
        return i11;
    }

    public void consumePostponedUpdates() {
        int size = this.mPostponedList.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mCallback.onDispatchSecondPass(this.mPostponedList.get(i11));
        }
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        int size = this.mPendingUpdates.size();
        for (int i11 = 0; i11 < size; i11++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i11);
            int i12 = updateOp.cmd;
            if (i12 == 1) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
            } else if (i12 == 2) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.offsetPositionsForRemovingInvisible(updateOp.positionStart, updateOp.itemCount);
            } else if (i12 == 4) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
            } else if (i12 == 8) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
            }
            Runnable runnable = this.mOnItemProcessedCallback;
            if (runnable != null) {
                runnable.run();
            }
        }
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        this.mExistingUpdateTypes = 0;
    }

    public void dispatchFirstPassAndUpdateViewHolders(UpdateOp updateOp, int i11) {
        this.mCallback.onDispatchFirstPass(updateOp);
        int i12 = updateOp.cmd;
        if (i12 == 2) {
            this.mCallback.offsetPositionsForRemovingInvisible(i11, updateOp.itemCount);
        } else if (i12 == 4) {
            this.mCallback.markViewHoldersUpdated(i11, updateOp.itemCount, updateOp.payload);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public int findPositionOffset(int i11) {
        return findPositionOffset(i11, 0);
    }

    public boolean hasAnyUpdateTypes(int i11) {
        return (i11 & this.mExistingUpdateTypes) != 0;
    }

    public boolean hasPendingUpdates() {
        return this.mPendingUpdates.size() > 0;
    }

    public boolean hasUpdates() {
        return !this.mPostponedList.isEmpty() && !this.mPendingUpdates.isEmpty();
    }

    public UpdateOp obtainUpdateOp(int i11, int i12, int i13, Object obj) {
        UpdateOp acquire = this.mUpdateOpPool.acquire();
        if (acquire == null) {
            return new UpdateOp(i11, i12, i13, obj);
        }
        acquire.cmd = i11;
        acquire.positionStart = i12;
        acquire.itemCount = i13;
        acquire.payload = obj;
        return acquire;
    }

    public boolean onItemRangeChanged(int i11, int i12, Object obj) {
        if (i12 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(4, i11, i12, obj));
        this.mExistingUpdateTypes |= 4;
        if (this.mPendingUpdates.size() == 1) {
            return true;
        }
        return false;
    }

    public boolean onItemRangeInserted(int i11, int i12) {
        if (i12 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(1, i11, i12, (Object) null));
        this.mExistingUpdateTypes |= 1;
        if (this.mPendingUpdates.size() == 1) {
            return true;
        }
        return false;
    }

    public boolean onItemRangeMoved(int i11, int i12, int i13) {
        if (i11 == i12) {
            return false;
        }
        if (i13 == 1) {
            this.mPendingUpdates.add(obtainUpdateOp(8, i11, i12, (Object) null));
            this.mExistingUpdateTypes |= 8;
            if (this.mPendingUpdates.size() == 1) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    public boolean onItemRangeRemoved(int i11, int i12) {
        if (i12 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(2, i11, i12, (Object) null));
        this.mExistingUpdateTypes |= 2;
        if (this.mPendingUpdates.size() == 1) {
            return true;
        }
        return false;
    }

    public void preProcess() {
        this.mOpReorderer.reorderOps(this.mPendingUpdates);
        int size = this.mPendingUpdates.size();
        for (int i11 = 0; i11 < size; i11++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i11);
            int i12 = updateOp.cmd;
            if (i12 == 1) {
                applyAdd(updateOp);
            } else if (i12 == 2) {
                applyRemove(updateOp);
            } else if (i12 == 4) {
                applyUpdate(updateOp);
            } else if (i12 == 8) {
                applyMove(updateOp);
            }
            Runnable runnable = this.mOnItemProcessedCallback;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.mPendingUpdates.clear();
    }

    public void recycleUpdateOp(UpdateOp updateOp) {
        if (!this.mDisableRecycler) {
            updateOp.payload = null;
            this.mUpdateOpPool.release(updateOp);
        }
    }

    public void recycleUpdateOpsAndClearList(List<UpdateOp> list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            recycleUpdateOp(list.get(i11));
        }
        list.clear();
    }

    public void reset() {
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public AdapterHelper(Callback callback, boolean z11) {
        this.mUpdateOpPool = new Pools.SimplePool(30);
        this.mPendingUpdates = new ArrayList<>();
        this.mPostponedList = new ArrayList<>();
        this.mExistingUpdateTypes = 0;
        this.mCallback = callback;
        this.mDisableRecycler = z11;
        this.mOpReorderer = new OpReorderer(this);
    }

    public int findPositionOffset(int i11, int i12) {
        int size = this.mPostponedList.size();
        while (i12 < size) {
            UpdateOp updateOp = this.mPostponedList.get(i12);
            int i13 = updateOp.cmd;
            if (i13 == 8) {
                int i14 = updateOp.positionStart;
                if (i14 == i11) {
                    i11 = updateOp.itemCount;
                } else {
                    if (i14 < i11) {
                        i11--;
                    }
                    if (updateOp.itemCount <= i11) {
                        i11++;
                    }
                }
            } else {
                int i15 = updateOp.positionStart;
                if (i15 > i11) {
                    continue;
                } else if (i13 == 2) {
                    int i16 = updateOp.itemCount;
                    if (i11 < i15 + i16) {
                        return -1;
                    }
                    i11 -= i16;
                } else if (i13 == 1) {
                    i11 += updateOp.itemCount;
                }
            }
            i12++;
        }
        return i11;
    }
}
