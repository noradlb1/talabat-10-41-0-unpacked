package j$.time.format;

import j$.time.b;

final class m implements g {

    /* renamed from: a  reason: collision with root package name */
    private final g f28363a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28364b;

    /* renamed from: c  reason: collision with root package name */
    private final char f28365c;

    m(g gVar, int i11, char c11) {
        this.f28363a = gVar;
        this.f28364b = i11;
        this.f28365c = c11;
    }

    public final boolean f(v vVar, StringBuilder sb2) {
        int length = sb2.length();
        if (!this.f28363a.f(vVar, sb2)) {
            return false;
        }
        int length2 = sb2.length() - length;
        int i11 = this.f28364b;
        if (length2 <= i11) {
            for (int i12 = 0; i12 < i11 - length2; i12++) {
                sb2.insert(length, this.f28365c);
            }
            return true;
        }
        throw new b("Cannot print as output of " + length2 + " characters exceeds pad width of " + i11);
    }

    public final String toString() {
        String str;
        char c11 = this.f28365c;
        if (c11 == ' ') {
            str = ")";
        } else {
            str = ",'" + c11 + "')";
        }
        return "Pad(" + this.f28363a + "," + this.f28364b + str;
    }
}
