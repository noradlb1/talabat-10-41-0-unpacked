package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

class Folder {

    /* renamed from: j  reason: collision with root package name */
    public static final Folder[] f27616j = new Folder[0];

    /* renamed from: a  reason: collision with root package name */
    public Coder[] f27617a;

    /* renamed from: b  reason: collision with root package name */
    public long f27618b;

    /* renamed from: c  reason: collision with root package name */
    public long f27619c;

    /* renamed from: d  reason: collision with root package name */
    public BindPair[] f27620d;

    /* renamed from: e  reason: collision with root package name */
    public long[] f27621e;

    /* renamed from: f  reason: collision with root package name */
    public long[] f27622f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27623g;

    /* renamed from: h  reason: collision with root package name */
    public long f27624h;

    /* renamed from: i  reason: collision with root package name */
    public int f27625i;

    public int a(int i11) {
        if (this.f27620d == null) {
            return -1;
        }
        int i12 = 0;
        while (true) {
            BindPair[] bindPairArr = this.f27620d;
            if (i12 >= bindPairArr.length) {
                return -1;
            }
            if (bindPairArr[i12].f27606a == ((long) i11)) {
                return i12;
            }
            i12++;
        }
    }

    public int b(int i11) {
        if (this.f27620d == null) {
            return -1;
        }
        int i12 = 0;
        while (true) {
            BindPair[] bindPairArr = this.f27620d;
            if (i12 >= bindPairArr.length) {
                return -1;
            }
            if (bindPairArr[i12].f27607b == ((long) i11)) {
                return i12;
            }
            i12++;
        }
    }

    public Iterable<Coder> c() throws IOException {
        Coder[] coderArr;
        long[] jArr = this.f27621e;
        if (jArr == null || (coderArr = this.f27617a) == null || jArr.length == 0 || coderArr.length == 0) {
            return Collections.emptyList();
        }
        LinkedList linkedList = new LinkedList();
        int i11 = (int) this.f27621e[0];
        while (i11 >= 0) {
            Coder[] coderArr2 = this.f27617a;
            if (i11 >= coderArr2.length) {
                break;
            } else if (!linkedList.contains(coderArr2[i11])) {
                linkedList.addLast(this.f27617a[i11]);
                int b11 = b(i11);
                if (b11 != -1) {
                    i11 = (int) this.f27620d[b11].f27606a;
                } else {
                    i11 = -1;
                }
            } else {
                throw new IOException("folder uses the same coder more than once in coder chain");
            }
        }
        return linkedList;
    }

    public long d() {
        long j11 = this.f27619c;
        if (j11 == 0) {
            return 0;
        }
        for (int i11 = ((int) j11) - 1; i11 >= 0; i11--) {
            if (b(i11) < 0) {
                return this.f27622f[i11];
            }
        }
        return 0;
    }

    public long e(Coder coder) {
        if (this.f27617a == null) {
            return 0;
        }
        int i11 = 0;
        while (true) {
            Coder[] coderArr = this.f27617a;
            if (i11 >= coderArr.length) {
                return 0;
            }
            if (coderArr[i11] == coder) {
                return this.f27622f[i11];
            }
            i11++;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Folder with ");
        sb2.append(this.f27617a.length);
        sb2.append(" coders, ");
        sb2.append(this.f27618b);
        sb2.append(" input streams, ");
        sb2.append(this.f27619c);
        sb2.append(" output streams, ");
        sb2.append(this.f27620d.length);
        sb2.append(" bind pairs, ");
        sb2.append(this.f27621e.length);
        sb2.append(" packed streams, ");
        sb2.append(this.f27622f.length);
        sb2.append(" unpack sizes, ");
        if (this.f27623g) {
            str = "with CRC " + this.f27624h;
        } else {
            str = "without CRC";
        }
        sb2.append(str);
        sb2.append(" and ");
        sb2.append(this.f27625i);
        sb2.append(" unpack streams");
        return sb2.toString();
    }
}
