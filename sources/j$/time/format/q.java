package j$.time.format;

import j$.time.d;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.w;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

final class q extends k {

    /* renamed from: g  reason: collision with root package name */
    private char f28374g;

    /* renamed from: h  reason: collision with root package name */
    private int f28375h;

    q(char c11, int i11, int i12, int i13) {
        this(c11, i11, i12, i13, 0);
    }

    q(char c11, int i11, int i12, int i13, int i14) {
        super((j$.time.temporal.q) null, i12, i13, A.NOT_NEGATIVE, i14);
        this.f28374g = c11;
        this.f28375h = i11;
    }

    /* access modifiers changed from: package-private */
    public final k c() {
        return this.f28357e == -1 ? this : new q(this.f28374g, this.f28375h, this.f28354b, this.f28355c, -1);
    }

    /* access modifiers changed from: package-private */
    public final k d(int i11) {
        return new q(this.f28374g, this.f28375h, this.f28354b, this.f28355c, this.f28357e + i11);
    }

    public final boolean f(v vVar, StringBuilder sb2) {
        k kVar;
        j$.time.temporal.q qVar;
        Locale c11 = vVar.c();
        TemporalUnit temporalUnit = w.f28489h;
        Objects.requireNonNull(c11, "locale");
        Calendar instance = Calendar.getInstance(new Locale(c11.getLanguage(), c11.getCountry()));
        w f11 = w.f(d.SUNDAY.C((long) (instance.getFirstDayOfWeek() - 1)), instance.getMinimalDaysInFirstWeek());
        char c12 = this.f28374g;
        if (c12 == 'W') {
            qVar = f11.h();
        } else if (c12 == 'Y') {
            j$.time.temporal.q g11 = f11.g();
            int i11 = this.f28375h;
            if (i11 == 2) {
                kVar = new n(g11, n.f28366i, this.f28357e);
            } else {
                kVar = new k(g11, i11, 19, i11 < 4 ? A.NORMAL : A.EXCEEDS_PAD, this.f28357e);
            }
            return kVar.f(vVar, sb2);
        } else if (c12 == 'c' || c12 == 'e') {
            qVar = f11.c();
        } else if (c12 == 'w') {
            qVar = f11.i();
        } else {
            throw new IllegalStateException("unreachable");
        }
        kVar = new k(qVar, this.f28354b, this.f28355c, A.NOT_NEGATIVE, this.f28357e);
        return kVar.f(vVar, sb2);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append("Localized(");
        char c11 = this.f28374g;
        if (c11 == 'Y') {
            int i11 = this.f28375h;
            if (i11 == 1) {
                sb2.append("WeekBasedYear");
            } else if (i11 == 2) {
                sb2.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
            } else {
                sb2.append("WeekBasedYear,");
                sb2.append(this.f28375h);
                sb2.append(",19,");
                sb2.append(this.f28375h < 4 ? A.NORMAL : A.EXCEEDS_PAD);
            }
        } else {
            if (c11 == 'W') {
                sb2.append("WeekOfMonth");
            } else if (c11 == 'c' || c11 == 'e') {
                sb2.append("DayOfWeek");
            } else if (c11 == 'w') {
                sb2.append("WeekOfWeekBasedYear");
            }
            sb2.append(",");
            sb2.append(this.f28375h);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
