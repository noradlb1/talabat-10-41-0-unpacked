package j$.util.concurrent;

import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.concurrent.b  reason: case insensitive filesystem */
abstract class C0116b extends CountedCompleter {

    /* renamed from: a  reason: collision with root package name */
    E[] f28696a;

    /* renamed from: b  reason: collision with root package name */
    E f28697b;

    /* renamed from: c  reason: collision with root package name */
    M f28698c;

    /* renamed from: d  reason: collision with root package name */
    M f28699d;

    /* renamed from: e  reason: collision with root package name */
    int f28700e;

    /* renamed from: f  reason: collision with root package name */
    int f28701f;

    /* renamed from: g  reason: collision with root package name */
    int f28702g;

    /* renamed from: h  reason: collision with root package name */
    final int f28703h;

    /* renamed from: i  reason: collision with root package name */
    int f28704i;

    C0116b(C0116b bVar, int i11, int i12, int i13, E[] eArr) {
        super(bVar);
        int i14;
        this.f28704i = i11;
        this.f28701f = i12;
        this.f28700e = i12;
        this.f28696a = eArr;
        if (eArr == null) {
            i14 = 0;
        } else if (bVar == null) {
            i14 = eArr.length;
        } else {
            this.f28702g = i13;
            i14 = bVar.f28703h;
            this.f28703h = i14;
        }
        this.f28702g = i14;
        this.f28703h = i14;
    }

    /* access modifiers changed from: package-private */
    public final E a() {
        E e11;
        E[] eArr;
        int length;
        int i11;
        M m11;
        E e12 = this.f28697b;
        if (e12 != null) {
            e12 = e12.f28634d;
        }
        while (e11 == null) {
            if (this.f28701f >= this.f28702g || (eArr = this.f28696a) == null || (length = eArr.length) <= (i11 = this.f28700e) || i11 < 0) {
                this.f28697b = null;
                return null;
            }
            E tabAt = ConcurrentHashMap.tabAt(eArr, i11);
            if (tabAt == null || tabAt.f28631a >= 0) {
                e11 = tabAt;
            } else if (tabAt instanceof C0125k) {
                this.f28696a = ((C0125k) tabAt).f28716e;
                M m12 = this.f28699d;
                if (m12 != null) {
                    this.f28699d = m12.f28653d;
                } else {
                    m12 = new M();
                }
                m12.f28652c = eArr;
                m12.f28650a = length;
                m12.f28651b = i11;
                m12.f28653d = this.f28698c;
                this.f28698c = m12;
                e11 = null;
            } else {
                e11 = tabAt instanceof O ? ((O) tabAt).f28665f : null;
            }
            if (this.f28698c != null) {
                while (true) {
                    m11 = this.f28698c;
                    if (m11 == null) {
                        break;
                    }
                    int i12 = this.f28700e;
                    int i13 = m11.f28650a;
                    int i14 = i12 + i13;
                    this.f28700e = i14;
                    if (i14 < length) {
                        break;
                    }
                    this.f28700e = m11.f28651b;
                    this.f28696a = m11.f28652c;
                    m11.f28652c = null;
                    M m13 = m11.f28653d;
                    m11.f28653d = this.f28699d;
                    this.f28698c = m13;
                    this.f28699d = m11;
                    length = i13;
                }
                if (m11 == null) {
                    int i15 = this.f28700e + this.f28703h;
                    this.f28700e = i15;
                    if (i15 >= length) {
                        int i16 = this.f28701f + 1;
                        this.f28701f = i16;
                        this.f28700e = i16;
                    }
                }
            } else {
                int i17 = i11 + this.f28703h;
                this.f28700e = i17;
                if (i17 >= length) {
                    int i18 = this.f28701f + 1;
                    this.f28701f = i18;
                    this.f28700e = i18;
                }
            }
        }
        this.f28697b = e11;
        return e11;
    }
}
