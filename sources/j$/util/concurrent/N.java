package j$.util.concurrent;

class N {

    /* renamed from: a  reason: collision with root package name */
    E[] f28654a;

    /* renamed from: b  reason: collision with root package name */
    E f28655b = null;

    /* renamed from: c  reason: collision with root package name */
    M f28656c;

    /* renamed from: d  reason: collision with root package name */
    M f28657d;

    /* renamed from: e  reason: collision with root package name */
    int f28658e;

    /* renamed from: f  reason: collision with root package name */
    int f28659f;

    /* renamed from: g  reason: collision with root package name */
    int f28660g;

    /* renamed from: h  reason: collision with root package name */
    final int f28661h;

    N(E[] eArr, int i11, int i12, int i13) {
        this.f28654a = eArr;
        this.f28661h = i11;
        this.f28658e = i12;
        this.f28659f = i12;
        this.f28660g = i13;
    }

    /* access modifiers changed from: package-private */
    public final E f() {
        E e11;
        E[] eArr;
        int length;
        int i11;
        M m11;
        E e12 = this.f28655b;
        if (e12 != null) {
            e12 = e12.f28634d;
        }
        while (e11 == null) {
            if (this.f28659f >= this.f28660g || (eArr = this.f28654a) == null || (length = eArr.length) <= (i11 = this.f28658e) || i11 < 0) {
                this.f28655b = null;
                return null;
            }
            E tabAt = ConcurrentHashMap.tabAt(eArr, i11);
            if (tabAt == null || tabAt.f28631a >= 0) {
                e11 = tabAt;
            } else if (tabAt instanceof C0125k) {
                this.f28654a = ((C0125k) tabAt).f28716e;
                M m12 = this.f28657d;
                if (m12 != null) {
                    this.f28657d = m12.f28653d;
                } else {
                    m12 = new M();
                }
                m12.f28652c = eArr;
                m12.f28650a = length;
                m12.f28651b = i11;
                m12.f28653d = this.f28656c;
                this.f28656c = m12;
                e11 = null;
            } else {
                e11 = tabAt instanceof O ? ((O) tabAt).f28665f : null;
            }
            if (this.f28656c != null) {
                while (true) {
                    m11 = this.f28656c;
                    if (m11 == null) {
                        break;
                    }
                    int i12 = this.f28658e;
                    int i13 = m11.f28650a;
                    int i14 = i12 + i13;
                    this.f28658e = i14;
                    if (i14 < length) {
                        break;
                    }
                    this.f28658e = m11.f28651b;
                    this.f28654a = m11.f28652c;
                    m11.f28652c = null;
                    M m13 = m11.f28653d;
                    m11.f28653d = this.f28657d;
                    this.f28656c = m13;
                    this.f28657d = m11;
                    length = i13;
                }
                if (m11 == null) {
                    int i15 = this.f28658e + this.f28661h;
                    this.f28658e = i15;
                    if (i15 >= length) {
                        int i16 = this.f28659f + 1;
                        this.f28659f = i16;
                        this.f28658e = i16;
                    }
                }
            } else {
                int i17 = i11 + this.f28661h;
                this.f28658e = i17;
                if (i17 >= length) {
                    int i18 = this.f28659f + 1;
                    this.f28659f = i18;
                    this.f28658e = i18;
                }
            }
        }
        this.f28655b = e11;
        return e11;
    }
}
