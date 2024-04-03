package org.apache.commons.compress.harmony.pack200;

import java.util.Arrays;

public class IntList {
    private int[] array;
    private int firstIndex;
    private int lastIndex;
    private int modCount;

    public IntList() {
        this(10);
    }

    private void growAtEnd(int i11) {
        int i12 = this.lastIndex;
        int i13 = this.firstIndex;
        int i14 = i12 - i13;
        int[] iArr = this.array;
        if (i13 >= i11 - (iArr.length - i12)) {
            int i15 = i12 - i13;
            if (i14 > 0) {
                System.arraycopy(iArr, i13, iArr, 0, i14);
            }
            this.firstIndex = 0;
            this.lastIndex = i15;
            return;
        }
        int i16 = i14 / 2;
        if (i11 <= i16) {
            i11 = i16;
        }
        if (i11 < 12) {
            i11 = 12;
        }
        int[] iArr2 = new int[(i11 + i14)];
        if (i14 > 0) {
            System.arraycopy(iArr, i13, iArr2, 0, i14);
            this.firstIndex = 0;
            this.lastIndex = i14;
        }
        this.array = iArr2;
    }

    private void growAtFront(int i11) {
        int i12 = this.lastIndex;
        int i13 = this.firstIndex;
        int i14 = i12 - i13;
        int[] iArr = this.array;
        if ((iArr.length - i12) + i13 >= i11) {
            int length = iArr.length - i14;
            if (i14 > 0) {
                System.arraycopy(iArr, i13, iArr, length, i14);
            }
            this.firstIndex = length;
            this.lastIndex = this.array.length;
            return;
        }
        int i15 = i14 / 2;
        if (i11 <= i15) {
            i11 = i15;
        }
        if (i11 < 12) {
            i11 = 12;
        }
        int i16 = i11 + i14;
        int[] iArr2 = new int[i16];
        if (i14 > 0) {
            System.arraycopy(iArr, i13, iArr2, i16 - i14, i14);
        }
        this.firstIndex = i16 - i14;
        this.lastIndex = i16;
        this.array = iArr2;
    }

    private void growForInsert(int i11, int i12) {
        int i13 = this.lastIndex;
        int i14 = this.firstIndex;
        int i15 = i13 - i14;
        int i16 = i15 / 2;
        if (i12 > i16) {
            i16 = i12;
        }
        if (i16 < 12) {
            i16 = 12;
        }
        int i17 = i15 + i16;
        int[] iArr = new int[i17];
        int i18 = i16 - i12;
        System.arraycopy(this.array, i14 + i11, iArr, i18 + i11 + i12, i15 - i11);
        System.arraycopy(this.array, this.firstIndex, iArr, i18, i11);
        this.firstIndex = i18;
        this.lastIndex = i17;
        this.array = iArr;
    }

    public boolean add(int i11) {
        if (this.lastIndex == this.array.length) {
            growAtEnd(1);
        }
        int[] iArr = this.array;
        int i12 = this.lastIndex;
        this.lastIndex = i12 + 1;
        iArr[i12] = i11;
        this.modCount++;
        return true;
    }

    public void addAll(IntList intList) {
        growAtEnd(intList.size());
        for (int i11 = 0; i11 < intList.size(); i11++) {
            add(intList.get(i11));
        }
    }

    public void clear() {
        int i11 = this.firstIndex;
        int i12 = this.lastIndex;
        if (i11 != i12) {
            Arrays.fill(this.array, i11, i12, -1);
            this.lastIndex = 0;
            this.firstIndex = 0;
            this.modCount++;
        }
    }

    public int get(int i11) {
        if (i11 >= 0) {
            int i12 = this.lastIndex;
            int i13 = this.firstIndex;
            if (i11 < i12 - i13) {
                return this.array[i13 + i11];
            }
        }
        throw new IndexOutOfBoundsException("" + i11);
    }

    public void increment(int i11) {
        if (i11 >= 0) {
            int i12 = this.lastIndex;
            int i13 = this.firstIndex;
            if (i11 < i12 - i13) {
                int[] iArr = this.array;
                int i14 = i13 + i11;
                iArr[i14] = iArr[i14] + 1;
                return;
            }
        }
        throw new IndexOutOfBoundsException("" + i11);
    }

    public boolean isEmpty() {
        return this.lastIndex == this.firstIndex;
    }

    public int remove(int i11) {
        int i12;
        int i13 = this.lastIndex;
        int i14 = this.firstIndex;
        int i15 = i13 - i14;
        if (i11 < 0 || i11 >= i15) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 == i15 - 1) {
            int[] iArr = this.array;
            int i16 = i13 - 1;
            this.lastIndex = i16;
            i12 = iArr[i16];
            iArr[i16] = 0;
        } else if (i11 == 0) {
            int[] iArr2 = this.array;
            int i17 = iArr2[i14];
            this.firstIndex = i14 + 1;
            iArr2[i14] = 0;
            i12 = i17;
        } else {
            int i18 = i14 + i11;
            int[] iArr3 = this.array;
            int i19 = iArr3[i18];
            if (i11 < i15 / 2) {
                System.arraycopy(iArr3, i14, iArr3, i14 + 1, i11);
                int[] iArr4 = this.array;
                int i21 = this.firstIndex;
                this.firstIndex = i21 + 1;
                iArr4[i21] = 0;
            } else {
                System.arraycopy(iArr3, i18 + 1, iArr3, i18, (i15 - i11) - 1);
                int[] iArr5 = this.array;
                int i22 = this.lastIndex - 1;
                this.lastIndex = i22;
                iArr5[i22] = 0;
            }
            i12 = i19;
        }
        if (this.firstIndex == this.lastIndex) {
            this.lastIndex = 0;
            this.firstIndex = 0;
        }
        this.modCount++;
        return i12;
    }

    public int size() {
        return this.lastIndex - this.firstIndex;
    }

    public int[] toArray() {
        int i11 = this.lastIndex;
        int i12 = this.firstIndex;
        int i13 = i11 - i12;
        int[] iArr = new int[i13];
        System.arraycopy(this.array, i12, iArr, 0, i13);
        return iArr;
    }

    public IntList(int i11) {
        if (i11 >= 0) {
            this.lastIndex = 0;
            this.firstIndex = 0;
            this.array = new int[i11];
            return;
        }
        throw new IllegalArgumentException();
    }

    public void add(int i11, int i12) {
        int i13 = this.lastIndex;
        int i14 = this.firstIndex;
        int i15 = i13 - i14;
        if (i11 > 0 && i11 < i15) {
            if (i14 == 0 && i13 == this.array.length) {
                growForInsert(i11, 1);
            } else {
                if (i11 >= i15 / 2 || i14 <= 0) {
                    int[] iArr = this.array;
                    if (i13 != iArr.length) {
                        int i16 = i14 + i11;
                        System.arraycopy(iArr, i16, iArr, i16 + 1, i15 - i11);
                        this.lastIndex++;
                    }
                }
                int[] iArr2 = this.array;
                int i17 = i14 - 1;
                this.firstIndex = i17;
                System.arraycopy(iArr2, i14, iArr2, i17, i11);
            }
            this.array[i11 + this.firstIndex] = i12;
        } else if (i11 == 0) {
            if (i14 == 0) {
                growAtFront(1);
            }
            int[] iArr3 = this.array;
            int i18 = this.firstIndex - 1;
            this.firstIndex = i18;
            iArr3[i18] = i12;
        } else if (i11 == i15) {
            if (i13 == this.array.length) {
                growAtEnd(1);
            }
            int[] iArr4 = this.array;
            int i19 = this.lastIndex;
            this.lastIndex = i19 + 1;
            iArr4[i19] = i12;
        } else {
            throw new IndexOutOfBoundsException();
        }
        this.modCount++;
    }
}
