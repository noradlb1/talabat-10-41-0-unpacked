package j$.time.temporal;

import j$.time.chrono.C0099b;
import j$.time.chrono.C0100c;

final class v implements q {

    /* renamed from: f  reason: collision with root package name */
    private static final u f28479f = u.j(1, 7);

    /* renamed from: g  reason: collision with root package name */
    private static final u f28480g = u.k(0, 4, 6);

    /* renamed from: h  reason: collision with root package name */
    private static final u f28481h = u.k(0, 52, 54);

    /* renamed from: i  reason: collision with root package name */
    private static final u f28482i = u.l(52, 53);

    /* renamed from: a  reason: collision with root package name */
    private final String f28483a;

    /* renamed from: b  reason: collision with root package name */
    private final w f28484b;

    /* renamed from: c  reason: collision with root package name */
    private final TemporalUnit f28485c;

    /* renamed from: d  reason: collision with root package name */
    private final TemporalUnit f28486d;

    /* renamed from: e  reason: collision with root package name */
    private final u f28487e;

    private v(String str, w wVar, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, u uVar) {
        this.f28483a = str;
        this.f28484b = wVar;
        this.f28485c = temporalUnit;
        this.f28486d = temporalUnit2;
        this.f28487e = uVar;
    }

    private static int a(int i11, int i12) {
        return ((i12 - 1) + (i11 + 7)) / 7;
    }

    private int b(m mVar) {
        int i11;
        int f11 = mVar.f(a.DAY_OF_WEEK) - this.f28484b.d().getValue();
        int i12 = f11 % 7;
        if (i12 == 0) {
            i11 = 0;
        } else {
            if ((((f11 ^ 7) >> 31) | 1) <= 0) {
                i12 += 7;
            }
            i11 = i12;
        }
        return i11 + 1;
    }

    private int c(m mVar) {
        int b11 = b(mVar);
        a aVar = a.DAY_OF_YEAR;
        int f11 = mVar.f(aVar);
        int n11 = n(f11, b11);
        int a11 = a(n11, f11);
        if (a11 == 0) {
            return c(C0099b.r(mVar).q(mVar).d((long) f11, ChronoUnit.DAYS));
        }
        if (a11 <= 50) {
            return a11;
        }
        int a12 = a(n11, this.f28484b.e() + ((int) mVar.h(aVar).d()));
        return a11 >= a12 ? (a11 - a12) + 1 : a11;
    }

    static v d(w wVar) {
        return new v("DayOfWeek", wVar, ChronoUnit.DAYS, ChronoUnit.WEEKS, f28479f);
    }

    static v e(w wVar) {
        return new v("WeekBasedYear", wVar, i.f28457d, ChronoUnit.FOREVER, a.YEAR.range());
    }

    static v i(w wVar) {
        return new v("WeekOfMonth", wVar, ChronoUnit.WEEKS, ChronoUnit.MONTHS, f28480g);
    }

    static v j(w wVar) {
        return new v("WeekOfWeekBasedYear", wVar, ChronoUnit.WEEKS, i.f28457d, f28482i);
    }

    private u l(m mVar, a aVar) {
        int n11 = n(mVar.f(aVar), b(mVar));
        u h11 = mVar.h(aVar);
        return u.j((long) a(n11, (int) h11.e()), (long) a(n11, (int) h11.d()));
    }

    private u m(m mVar) {
        a aVar = a.DAY_OF_YEAR;
        if (!mVar.c(aVar)) {
            return f28481h;
        }
        int b11 = b(mVar);
        int f11 = mVar.f(aVar);
        int n11 = n(f11, b11);
        int a11 = a(n11, f11);
        if (a11 == 0) {
            return m(C0099b.r(mVar).q(mVar).d((long) (f11 + 7), ChronoUnit.DAYS));
        }
        int d11 = (int) mVar.h(aVar).d();
        int a12 = a(n11, this.f28484b.e() + d11);
        return a11 >= a12 ? m(C0099b.r(mVar).q(mVar).b((long) ((d11 - f11) + 1 + 7), ChronoUnit.DAYS)) : u.j(1, (long) (a12 - 1));
    }

    private int n(int i11, int i12) {
        int i13;
        int i14 = i11 - i12;
        int i15 = i14 % 7;
        if (i15 == 0) {
            i13 = 0;
        } else {
            if ((((i14 ^ 7) >> 31) | 1) <= 0) {
                i15 += 7;
            }
            i13 = i15;
        }
        return i13 + 1 > this.f28484b.e() ? 7 - i13 : -i13;
    }

    public final boolean f(m mVar) {
        a aVar;
        if (!mVar.c(a.DAY_OF_WEEK)) {
            return false;
        }
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        TemporalUnit temporalUnit = this.f28486d;
        if (temporalUnit == chronoUnit) {
            return true;
        }
        if (temporalUnit == ChronoUnit.MONTHS) {
            aVar = a.DAY_OF_MONTH;
        } else if (temporalUnit == ChronoUnit.YEARS || temporalUnit == w.f28489h) {
            aVar = a.DAY_OF_YEAR;
        } else if (temporalUnit != ChronoUnit.FOREVER) {
            return false;
        } else {
            aVar = a.YEAR;
        }
        return mVar.c(aVar);
    }

    public final u g(m mVar) {
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        TemporalUnit temporalUnit = this.f28486d;
        if (temporalUnit == chronoUnit) {
            return this.f28487e;
        }
        if (temporalUnit == ChronoUnit.MONTHS) {
            return l(mVar, a.DAY_OF_MONTH);
        }
        if (temporalUnit == ChronoUnit.YEARS) {
            return l(mVar, a.DAY_OF_YEAR);
        }
        if (temporalUnit == w.f28489h) {
            return m(mVar);
        }
        if (temporalUnit == ChronoUnit.FOREVER) {
            return a.YEAR.range();
        }
        throw new IllegalStateException("unreachable, rangeUnit: " + temporalUnit + ", this: " + this);
    }

    public final long h(m mVar) {
        int i11;
        int a11;
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        TemporalUnit temporalUnit = this.f28486d;
        if (temporalUnit == chronoUnit) {
            i11 = b(mVar);
        } else {
            if (temporalUnit == ChronoUnit.MONTHS) {
                int b11 = b(mVar);
                int f11 = mVar.f(a.DAY_OF_MONTH);
                a11 = a(n(f11, b11), f11);
            } else if (temporalUnit == ChronoUnit.YEARS) {
                int b12 = b(mVar);
                int f12 = mVar.f(a.DAY_OF_YEAR);
                a11 = a(n(f12, b12), f12);
            } else if (temporalUnit == w.f28489h) {
                i11 = c(mVar);
            } else if (temporalUnit == ChronoUnit.FOREVER) {
                int b13 = b(mVar);
                int f13 = mVar.f(a.YEAR);
                a aVar = a.DAY_OF_YEAR;
                int f14 = mVar.f(aVar);
                int n11 = n(f14, b13);
                int a12 = a(n11, f14);
                if (a12 == 0) {
                    f13--;
                } else {
                    if (a12 >= a(n11, this.f28484b.e() + ((int) mVar.h(aVar).d()))) {
                        f13++;
                    }
                }
                return (long) f13;
            } else {
                throw new IllegalStateException("unreachable, rangeUnit: " + temporalUnit + ", this: " + this);
            }
            return (long) a11;
        }
        return (long) i11;
    }

    public final boolean isDateBased() {
        return true;
    }

    public final boolean isTimeBased() {
        return false;
    }

    public final l k(l lVar, long j11) {
        int a11 = this.f28487e.a(j11, this);
        int f11 = lVar.f(this);
        if (a11 == f11) {
            return lVar;
        }
        if (this.f28486d != ChronoUnit.FOREVER) {
            return lVar.b((long) (a11 - f11), this.f28485c);
        }
        w wVar = this.f28484b;
        int f12 = lVar.f(wVar.f28492c);
        int f13 = lVar.f(wVar.f28494e);
        C0100c l11 = C0099b.r(lVar).l((int) j11);
        int n11 = n(1, b(l11));
        int i11 = f12 - 1;
        return l11.b((long) (((Math.min(f13, a(n11, wVar.e() + l11.y()) - 1) - 1) * 7) + i11 + (-n11)), ChronoUnit.DAYS);
    }

    public final u range() {
        return this.f28487e;
    }

    public final String toString() {
        String wVar = this.f28484b.toString();
        return this.f28483a + "[" + wVar + "]";
    }
}
