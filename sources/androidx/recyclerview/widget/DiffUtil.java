package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new Comparator<Diagonal>() {
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f37407x - diagonal2.f37407x;
        }
    };

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i11, int i12);

        public abstract boolean areItemsTheSame(int i11, int i12);

        @Nullable
        public Object getChangePayload(int i11, int i12) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        public CenteredArray(int i11) {
            int[] iArr = new int[i11];
            this.mData = iArr;
            this.mMid = iArr.length / 2;
        }

        public int[] backingData() {
            return this.mData;
        }

        public void fill(int i11) {
            Arrays.fill(this.mData, i11);
        }

        public int get(int i11) {
            return this.mData[i11 + this.mMid];
        }

        public void set(int i11, int i12) {
            this.mData[i11 + this.mMid] = i12;
        }
    }

    public static class Diagonal {
        public final int size;

        /* renamed from: x  reason: collision with root package name */
        public final int f37407x;

        /* renamed from: y  reason: collision with root package name */
        public final int f37408y;

        public Diagonal(int i11, int i12, int i13) {
            this.f37407x = i11;
            this.f37408y = i12;
            this.size = i13;
        }

        public int endX() {
            return this.f37407x + this.size;
        }

        public int endY() {
            return this.f37408y + this.size;
        }
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final List<Diagonal> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        public DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z11) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z11;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            Diagonal diagonal;
            if (this.mDiagonals.isEmpty()) {
                diagonal = null;
            } else {
                diagonal = this.mDiagonals.get(0);
            }
            if (!(diagonal != null && diagonal.f37407x == 0 && diagonal.f37408y == 0)) {
                this.mDiagonals.add(0, new Diagonal(0, 0, 0));
            }
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i11) {
            int i12;
            int size = this.mDiagonals.size();
            int i13 = 0;
            for (int i14 = 0; i14 < size; i14++) {
                Diagonal diagonal = this.mDiagonals.get(i14);
                while (i13 < diagonal.f37408y) {
                    if (this.mNewItemStatuses[i13] != 0 || !this.mCallback.areItemsTheSame(i11, i13)) {
                        i13++;
                    } else {
                        if (this.mCallback.areContentsTheSame(i11, i13)) {
                            i12 = 8;
                        } else {
                            i12 = 4;
                        }
                        this.mOldItemStatuses[i11] = (i13 << 4) | i12;
                        this.mNewItemStatuses[i13] = (i11 << 4) | i12;
                        return;
                    }
                }
                i13 = diagonal.endY();
            }
        }

        private void findMatchingItems() {
            int i11;
            for (Diagonal next : this.mDiagonals) {
                for (int i12 = 0; i12 < next.size; i12++) {
                    int i13 = next.f37407x + i12;
                    int i14 = next.f37408y + i12;
                    if (this.mCallback.areContentsTheSame(i13, i14)) {
                        i11 = 1;
                    } else {
                        i11 = 2;
                    }
                    this.mOldItemStatuses[i13] = (i14 << 4) | i11;
                    this.mNewItemStatuses[i14] = (i13 << 4) | i11;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int i11 = 0;
            for (Diagonal next : this.mDiagonals) {
                while (i11 < next.f37407x) {
                    if (this.mOldItemStatuses[i11] == 0) {
                        findMatchingAddition(i11);
                    }
                    i11++;
                }
                i11 = next.endX();
            }
        }

        @Nullable
        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> collection, int i11, boolean z11) {
            PostponedUpdate postponedUpdate;
            Iterator<PostponedUpdate> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postponedUpdate = null;
                    break;
                }
                postponedUpdate = it.next();
                if (postponedUpdate.posInOwnerList == i11 && postponedUpdate.removal == z11) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate next = it.next();
                if (z11) {
                    next.currentPos--;
                } else {
                    next.currentPos++;
                }
            }
            return postponedUpdate;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i11) {
            if (i11 < 0 || i11 >= this.mNewListSize) {
                throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i11 + ", new list size = " + this.mNewListSize);
            }
            int i12 = this.mNewItemStatuses[i11];
            if ((i12 & 15) == 0) {
                return -1;
            }
            return i12 >> 4;
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i11) {
            if (i11 < 0 || i11 >= this.mOldListSize) {
                throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i11 + ", old list size = " + this.mOldListSize);
            }
            int i12 = this.mOldItemStatuses[i11];
            if ((i12 & 15) == 0) {
                return -1;
            }
            return i12 >> 4;
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo((ListUpdateCallback) new AdapterListUpdateCallback(adapter));
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            int i11;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            int i12 = this.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i13 = this.mOldListSize;
            int i14 = this.mNewListSize;
            for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.mDiagonals.get(size);
                int endX = diagonal.endX();
                int endY = diagonal.endY();
                while (true) {
                    if (i13 <= endX) {
                        break;
                    }
                    i13--;
                    int i15 = this.mOldItemStatuses[i13];
                    if ((i15 & 12) != 0) {
                        int i16 = i15 >> 4;
                        PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i16, false);
                        if (postponedUpdate != null) {
                            int i17 = (i12 - postponedUpdate.currentPos) - 1;
                            batchingListUpdateCallback.onMoved(i13, i17);
                            if ((i15 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i17, 1, this.mCallback.getChangePayload(i13, i16));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i13, (i12 - i13) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.onRemoved(i13, 1);
                        i12--;
                    }
                }
                while (i14 > endY) {
                    i14--;
                    int i18 = this.mNewItemStatuses[i14];
                    if ((i18 & 12) != 0) {
                        int i19 = i18 >> 4;
                        PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i19, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new PostponedUpdate(i14, i12 - i13, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i12 - postponedUpdate2.currentPos) - 1, i13);
                            if ((i18 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i13, 1, this.mCallback.getChangePayload(i19, i14));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i13, 1);
                        i12++;
                    }
                }
                int i21 = diagonal.f37407x;
                int i22 = diagonal.f37408y;
                for (i11 = 0; i11 < diagonal.size; i11++) {
                    if ((this.mOldItemStatuses[i21] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i21, 1, this.mCallback.getChangePayload(i21, i22));
                    }
                    i21++;
                    i22++;
                }
                i13 = diagonal.f37407x;
                i14 = diagonal.f37408y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t11, @NonNull T t12);

        public abstract boolean areItemsTheSame(@NonNull T t11, @NonNull T t12);

        @Nullable
        public Object getChangePayload(@NonNull T t11, @NonNull T t12) {
            return null;
        }
    }

    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i11, int i12, boolean z11) {
            this.posInOwnerList = i11;
            this.currentPos = i12;
            this.removal = z11;
        }
    }

    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public int newSize() {
            return this.newListEnd - this.newListStart;
        }

        public int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        public Range(int i11, int i12, int i13, int i14) {
            this.oldListStart = i11;
            this.oldListEnd = i12;
            this.newListStart = i13;
            this.newListEnd = i14;
        }
    }

    public static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        public int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        public boolean hasAdditionOrRemoval() {
            return this.endY - this.startY != this.endX - this.startX;
        }

        public boolean isAddition() {
            return this.endY - this.startY > this.endX - this.startX;
        }

        @NonNull
        public Diagonal toDiagonal() {
            if (!hasAdditionOrRemoval()) {
                int i11 = this.startX;
                return new Diagonal(i11, this.startY, this.endX - i11);
            } else if (this.reverse) {
                return new Diagonal(this.startX, this.startY, diagonalSize());
            } else {
                if (isAddition()) {
                    return new Diagonal(this.startX, this.startY + 1, diagonalSize());
                }
                return new Diagonal(this.startX + 1, this.startY, diagonalSize());
            }
        }
    }

    private DiffUtil() {
    }

    @Nullable
    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i11) {
        boolean z11;
        int i12;
        int i13;
        int i14;
        int i15;
        if ((range.oldSize() - range.newSize()) % 2 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        int oldSize = range.oldSize() - range.newSize();
        int i16 = -i11;
        int i17 = i16;
        while (i17 <= i11) {
            if (i17 == i16 || (i17 != i11 && centeredArray2.get(i17 + 1) < centeredArray2.get(i17 - 1))) {
                i13 = centeredArray2.get(i17 + 1);
                i12 = i13;
            } else {
                i13 = centeredArray2.get(i17 - 1);
                i12 = i13 - 1;
            }
            int i18 = range.newListEnd - ((range.oldListEnd - i12) - i17);
            if (i11 == 0 || i12 != i13) {
                i14 = i18;
            } else {
                i14 = i18 + 1;
            }
            while (i12 > range.oldListStart && i18 > range.newListStart && callback.areItemsTheSame(i12 - 1, i18 - 1)) {
                i12--;
                i18--;
            }
            centeredArray2.set(i17, i12);
            if (!z11 || (i15 = oldSize - i17) < i16 || i15 > i11 || centeredArray.get(i15) < i12) {
                i17 += 2;
            } else {
                Snake snake = new Snake();
                snake.startX = i12;
                snake.startY = i18;
                snake.endX = i13;
                snake.endY = i14;
                snake.reverse = true;
                return snake;
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    @Nullable
    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z11 = true;
        if (Math.abs(range.oldSize() - range.newSize()) % 2 != 1) {
            z11 = false;
        }
        int oldSize = range.oldSize() - range.newSize();
        int i16 = -i11;
        int i17 = i16;
        while (i17 <= i11) {
            if (i17 == i16 || (i17 != i11 && centeredArray.get(i17 + 1) > centeredArray.get(i17 - 1))) {
                i13 = centeredArray.get(i17 + 1);
                i12 = i13;
            } else {
                i13 = centeredArray.get(i17 - 1);
                i12 = i13 + 1;
            }
            int i18 = (range.newListStart + (i12 - range.oldListStart)) - i17;
            if (i11 == 0 || i12 != i13) {
                i14 = i18;
            } else {
                i14 = i18 - 1;
            }
            while (i12 < range.oldListEnd && i18 < range.newListEnd && callback.areItemsTheSame(i12, i18)) {
                i12++;
                i18++;
            }
            centeredArray.set(i17, i12);
            if (!z11 || (i15 = oldSize - i17) < i16 + 1 || i15 > i11 - 1 || centeredArray2.get(i15) > i12) {
                i17 += 2;
            } else {
                Snake snake = new Snake();
                snake.startX = i13;
                snake.startY = i14;
                snake.endX = i12;
                snake.endY = i18;
                snake.reverse = false;
                return snake;
            }
        }
        return null;
    }

    @Nullable
    private static Snake midPoint(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.oldSize() >= 1 && range.newSize() >= 1) {
            int oldSize = ((range.oldSize() + range.newSize()) + 1) / 2;
            centeredArray.set(1, range.oldListStart);
            centeredArray2.set(1, range.oldListEnd);
            for (int i11 = 0; i11 < oldSize; i11++) {
                Snake forward = forward(range, callback, centeredArray, centeredArray2, i11);
                if (forward != null) {
                    return forward;
                }
                Snake backward = backward(range, callback, centeredArray, centeredArray2, i11);
                if (backward != null) {
                    return backward;
                }
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z11) {
        Range range;
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i11 = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i11);
        CenteredArray centeredArray2 = new CenteredArray(i11);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range2 = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake midPoint = midPoint(range2, callback, centeredArray, centeredArray2);
            if (midPoint != null) {
                if (midPoint.diagonalSize() > 0) {
                    arrayList.add(midPoint.toDiagonal());
                }
                if (arrayList3.isEmpty()) {
                    range = new Range();
                } else {
                    range = (Range) arrayList3.remove(arrayList3.size() - 1);
                }
                range.oldListStart = range2.oldListStart;
                range.newListStart = range2.newListStart;
                range.oldListEnd = midPoint.startX;
                range.newListEnd = midPoint.startY;
                arrayList2.add(range);
                range2.oldListEnd = range2.oldListEnd;
                range2.newListEnd = range2.newListEnd;
                range2.oldListStart = midPoint.endX;
                range2.newListStart = midPoint.endY;
                arrayList2.add(range2);
            } else {
                arrayList3.add(range2);
            }
        }
        Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z11);
    }
}
