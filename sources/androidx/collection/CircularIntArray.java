package androidx.collection;

public final class CircularIntArray {
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;

    public CircularIntArray() {
        this(8);
    }

    private void doubleCapacity() {
        int[] iArr = this.mElements;
        int length = iArr.length;
        int i11 = this.mHead;
        int i12 = length - i11;
        int i13 = length << 1;
        if (i13 >= 0) {
            int[] iArr2 = new int[i13];
            System.arraycopy(iArr, i11, iArr2, 0, i12);
            System.arraycopy(this.mElements, 0, iArr2, i12, this.mHead);
            this.mElements = iArr2;
            this.mHead = 0;
            this.mTail = length;
            this.mCapacityBitmask = i13 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(int i11) {
        int i12 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = i12;
        this.mElements[i12] = i11;
        if (i12 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(int i11) {
        int[] iArr = this.mElements;
        int i12 = this.mTail;
        iArr[i12] = i11;
        int i13 = this.mCapacityBitmask & (i12 + 1);
        this.mTail = i13;
        if (i13 == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        this.mTail = this.mHead;
    }

    public int get(int i11) {
        if (i11 < 0 || i11 >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[this.mCapacityBitmask & (this.mHead + i11)];
    }

    public int getFirst() {
        int i11 = this.mHead;
        if (i11 != this.mTail) {
            return this.mElements[i11];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
        int i11 = this.mHead;
        int i12 = this.mTail;
        if (i11 != i12) {
            return this.mElements[(i12 - 1) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.mHead == this.mTail;
    }

    public int popFirst() {
        int i11 = this.mHead;
        if (i11 != this.mTail) {
            int i12 = this.mElements[i11];
            this.mHead = (i11 + 1) & this.mCapacityBitmask;
            return i12;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int popLast() {
        int i11 = this.mHead;
        int i12 = this.mTail;
        if (i11 != i12) {
            int i13 = this.mCapacityBitmask & (i12 - 1);
            int i14 = this.mElements[i13];
            this.mTail = i13;
            return i14;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i11) {
        if (i11 > 0) {
            if (i11 <= size()) {
                this.mTail = this.mCapacityBitmask & (this.mTail - i11);
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void removeFromStart(int i11) {
        if (i11 > 0) {
            if (i11 <= size()) {
                this.mHead = this.mCapacityBitmask & (this.mHead + i11);
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public CircularIntArray(int i11) {
        if (i11 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        } else if (i11 <= 1073741824) {
            i11 = Integer.bitCount(i11) != 1 ? Integer.highestOneBit(i11 - 1) << 1 : i11;
            this.mCapacityBitmask = i11 - 1;
            this.mElements = new int[i11];
        } else {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
    }
}
