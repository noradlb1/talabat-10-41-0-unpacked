package j$.time.format;

final class e implements g {

    /* renamed from: a  reason: collision with root package name */
    private final char f28346a;

    e(char c11) {
        this.f28346a = c11;
    }

    public final boolean f(v vVar, StringBuilder sb2) {
        sb2.append(this.f28346a);
        return true;
    }

    public final String toString() {
        char c11 = this.f28346a;
        if (c11 == '\'') {
            return "''";
        }
        return "'" + c11 + "'";
    }
}
