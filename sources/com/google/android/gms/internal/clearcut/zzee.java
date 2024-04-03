package com.google.android.gms.internal.clearcut;

final class zzee {
    private final String info;
    private int position = 0;

    public zzee(String str) {
        this.info = str;
    }

    public final boolean hasNext() {
        return this.position < this.info.length();
    }

    public final int next() {
        String str = this.info;
        int i11 = this.position;
        this.position = i11 + 1;
        char charAt = str.charAt(i11);
        if (charAt < 55296) {
            return charAt;
        }
        char c11 = charAt & 8191;
        int i12 = 13;
        while (true) {
            String str2 = this.info;
            int i13 = this.position;
            this.position = i13 + 1;
            char charAt2 = str2.charAt(i13);
            if (charAt2 < 55296) {
                return c11 | (charAt2 << i12);
            }
            c11 |= (charAt2 & 8191) << i12;
            i12 += 13;
        }
    }
}
