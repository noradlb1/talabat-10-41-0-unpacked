package org.apache.commons.compress.harmony.pack200;

public class CPLong extends CPConstant {
    private final long theLong;

    public CPLong(long j11) {
        this.theLong = j11;
    }

    public int compareTo(Object obj) {
        long j11 = this.theLong;
        long j12 = ((CPLong) obj).theLong;
        if (j11 > j12) {
            return 1;
        }
        return j11 == j12 ? 0 : -1;
    }

    public long getLong() {
        return this.theLong;
    }

    public String toString() {
        return "" + this.theLong;
    }
}
