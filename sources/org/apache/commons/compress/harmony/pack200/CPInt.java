package org.apache.commons.compress.harmony.pack200;

public class CPInt extends CPConstant {
    private final int theInt;

    public CPInt(int i11) {
        this.theInt = i11;
    }

    public int compareTo(Object obj) {
        int i11 = this.theInt;
        int i12 = ((CPInt) obj).theInt;
        if (i11 > i12) {
            return 1;
        }
        return i11 == i12 ? 0 : -1;
    }

    public int getInt() {
        return this.theInt;
    }
}
