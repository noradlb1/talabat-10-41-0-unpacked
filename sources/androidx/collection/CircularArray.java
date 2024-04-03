package androidx.collection;

public final class CircularArray<E> {
    private int mCapacityBitmask;
    private E[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray() {
        this(8);
    }

    private void doubleCapacity() {
        E[] eArr = this.mElements;
        int length = eArr.length;
        int i11 = this.mHead;
        int i12 = length - i11;
        int i13 = length << 1;
        if (i13 >= 0) {
            E[] eArr2 = new Object[i13];
            System.arraycopy(eArr, i11, eArr2, 0, i12);
            System.arraycopy(this.mElements, 0, eArr2, i12, this.mHead);
            this.mElements = eArr2;
            this.mHead = 0;
            this.mTail = length;
            this.mCapacityBitmask = i13 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(E e11) {
        int i11 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = i11;
        this.mElements[i11] = e11;
        if (i11 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(E e11) {
        E[] eArr = this.mElements;
        int i11 = this.mTail;
        eArr[i11] = e11;
        int i12 = this.mCapacityBitmask & (i11 + 1);
        this.mTail = i12;
        if (i12 == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        removeFromStart(size());
    }

    public E get(int i11) {
        if (i11 < 0 || i11 >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[this.mCapacityBitmask & (this.mHead + i11)];
    }

    public E getFirst() {
        int i11 = this.mHead;
        if (i11 != this.mTail) {
            return this.mElements[i11];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
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

    public E popFirst() {
        int i11 = this.mHead;
        if (i11 != this.mTail) {
            E[] eArr = this.mElements;
            E e11 = eArr[i11];
            eArr[i11] = null;
            this.mHead = (i11 + 1) & this.mCapacityBitmask;
            return e11;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E popLast() {
        int i11 = this.mHead;
        int i12 = this.mTail;
        if (i11 != i12) {
            int i13 = this.mCapacityBitmask & (i12 - 1);
            E[] eArr = this.mElements;
            E e11 = eArr[i13];
            eArr[i13] = null;
            this.mTail = i13;
            return e11;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i11) {
        int i12;
        int i13;
        if (i11 > 0) {
            if (i11 <= size()) {
                int i14 = this.mTail;
                if (i11 < i14) {
                    i12 = i14 - i11;
                } else {
                    i12 = 0;
                }
                int i15 = i12;
                while (true) {
                    i13 = this.mTail;
                    if (i15 >= i13) {
                        break;
                    }
                    this.mElements[i15] = null;
                    i15++;
                }
                int i16 = i13 - i12;
                int i17 = i11 - i16;
                this.mTail = i13 - i16;
                if (i17 > 0) {
                    int length = this.mElements.length;
                    this.mTail = length;
                    int i18 = length - i17;
                    for (int i19 = i18; i19 < this.mTail; i19++) {
                        this.mElements[i19] = null;
                    }
                    this.mTail = i18;
                    return;
                }
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void removeFromStart(int i11) {
        if (i11 > 0) {
            if (i11 <= size()) {
                int length = this.mElements.length;
                int i12 = this.mHead;
                if (i11 < length - i12) {
                    length = i12 + i11;
                }
                while (i12 < length) {
                    this.mElements[i12] = null;
                    i12++;
                }
                int i13 = this.mHead;
                int i14 = length - i13;
                int i15 = i11 - i14;
                this.mHead = this.mCapacityBitmask & (i13 + i14);
                if (i15 > 0) {
                    for (int i16 = 0; i16 < i15; i16++) {
                        this.mElements[i16] = null;
                    }
                    this.mHead = i15;
                    return;
                }
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public CircularArray(int i11) {
        if (i11 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        } else if (i11 <= 1073741824) {
            i11 = Integer.bitCount(i11) != 1 ? Integer.highestOneBit(i11 - 1) << 1 : i11;
            this.mCapacityBitmask = i11 - 1;
            this.mElements = new Object[i11];
        } else {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
    }
}
