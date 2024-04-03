package j$.time.chrono;

import com.google.android.exoplayer2.C;
import j$.lang.a;
import j$.time.ZoneOffset;
import j$.time.h;
import j$.time.k;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.l;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Objects;

/* renamed from: j$.time.chrono.h  reason: case insensitive filesystem */
final class C0105h implements C0103f, l, n, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;

    /* renamed from: a  reason: collision with root package name */
    private final transient C0100c f28290a;

    /* renamed from: b  reason: collision with root package name */
    private final transient k f28291b;

    private C0105h(C0100c cVar, k kVar) {
        Objects.requireNonNull(cVar, "date");
        Objects.requireNonNull(kVar, "time");
        this.f28290a = cVar;
        this.f28291b = kVar;
    }

    static C0105h B(n nVar, l lVar) {
        C0105h hVar = (C0105h) lVar;
        C0098a aVar = (C0098a) nVar;
        if (aVar.equals(hVar.getChronology())) {
            return hVar;
        }
        String e11 = aVar.e();
        String e12 = hVar.getChronology().e();
        throw new ClassCastException("Chronology mismatch, required: " + e11 + ", actual: " + e12);
    }

    static C0105h D(C0100c cVar, k kVar) {
        return new C0105h(cVar, kVar);
    }

    private C0105h G(C0100c cVar, long j11, long j12, long j13, long j14) {
        C0100c cVar2 = cVar;
        int i11 = ((j11 | j12 | j13 | j14) > 0 ? 1 : ((j11 | j12 | j13 | j14) == 0 ? 0 : -1));
        k kVar = this.f28291b;
        if (i11 == 0) {
            return J(cVar2, kVar);
        }
        long j15 = j12 / 1440;
        long j16 = j11 / 24;
        long j17 = (j12 % 1440) * 60000000000L;
        long j18 = ((j11 % 24) * 3600000000000L) + j17 + ((j13 % 86400) * C.NANOS_PER_SECOND) + (j14 % 86400000000000L);
        long R = kVar.R();
        long j19 = j18 + R;
        long b11 = a.b(j19, 86400000000000L) + j16 + j15 + (j13 / 86400) + (j14 / 86400000000000L);
        long f11 = a.f(j19, 86400000000000L);
        if (f11 != R) {
            kVar = k.J(f11);
        }
        return J(cVar2.b(b11, ChronoUnit.DAYS), kVar);
    }

    private C0105h J(l lVar, k kVar) {
        C0100c cVar = this.f28290a;
        return (cVar == lVar && this.f28291b == kVar) ? this : new C0105h(C0102e.B(cVar.getChronology(), lVar), kVar);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new G((byte) 2, this);
    }

    /* renamed from: C */
    public final C0103f d(long j11, TemporalUnit temporalUnit) {
        return B(getChronology(), p.b(this, j11, (ChronoUnit) temporalUnit));
    }

    /* renamed from: E */
    public final C0105h b(long j11, TemporalUnit temporalUnit) {
        long j12 = j11;
        TemporalUnit temporalUnit2 = temporalUnit;
        boolean z11 = temporalUnit2 instanceof ChronoUnit;
        C0100c cVar = this.f28290a;
        if (!z11) {
            return B(cVar.getChronology(), temporalUnit2.f(this, j12));
        }
        int i11 = C0104g.f28289a[((ChronoUnit) temporalUnit2).ordinal()];
        k kVar = this.f28291b;
        switch (i11) {
            case 1:
                return G(this.f28290a, 0, 0, 0, j11);
            case 2:
                C0105h J = J(cVar.b(j12 / 86400000000L, ChronoUnit.DAYS), kVar);
                return J.G(J.f28290a, 0, 0, 0, (j12 % 86400000000L) * 1000);
            case 3:
                C0105h J2 = J(cVar.b(j12 / 86400000, ChronoUnit.DAYS), kVar);
                return J2.G(J2.f28290a, 0, 0, 0, (j12 % 86400000) * 1000000);
            case 4:
                return F(j11);
            case 5:
                return G(this.f28290a, 0, j11, 0, 0);
            case 6:
                return G(this.f28290a, j11, 0, 0, 0);
            case 7:
                C0105h J3 = J(cVar.b(j12 / 256, ChronoUnit.DAYS), kVar);
                return J3.G(J3.f28290a, (j12 % 256) * 12, 0, 0, 0);
            default:
                return J(cVar.b(j12, temporalUnit2), kVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final C0105h F(long j11) {
        return G(this.f28290a, 0, 0, j11, 0);
    }

    public final /* synthetic */ long H(ZoneOffset zoneOffset) {
        return C0099b.p(this, zoneOffset);
    }

    /* renamed from: I */
    public final C0105h a(long j11, q qVar) {
        boolean z11 = qVar instanceof j$.time.temporal.a;
        C0100c cVar = this.f28290a;
        if (!z11) {
            return B(cVar.getChronology(), qVar.k(this, j11));
        }
        boolean isTimeBased = ((j$.time.temporal.a) qVar).isTimeBased();
        k kVar = this.f28291b;
        return isTimeBased ? J(cVar, kVar.a(j11, qVar)) : J(cVar.a(j11, qVar), kVar);
    }

    public final boolean c(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar != null && qVar.f(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        return aVar.isDateBased() || aVar.isTimeBased();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0103f) {
            return C0099b.e(this, (C0103f) obj) == 0;
        }
        return false;
    }

    public final int f(q qVar) {
        return qVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) qVar).isTimeBased() ? this.f28291b.f(qVar) : this.f28290a.f(qVar) : h(qVar).a(s(qVar), qVar);
    }

    public final l g(h hVar) {
        return J(hVar, this.f28291b);
    }

    public final n getChronology() {
        return toLocalDate().getChronology();
    }

    public final u h(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        if (!((j$.time.temporal.a) qVar).isTimeBased()) {
            return this.f28290a.h(qVar);
        }
        k kVar = this.f28291b;
        kVar.getClass();
        return p.d(kVar, qVar);
    }

    public final int hashCode() {
        return this.f28290a.hashCode() ^ this.f28291b.hashCode();
    }

    public final C0108k i(ZoneOffset zoneOffset) {
        return m.D(zoneOffset, (ZoneOffset) null, this);
    }

    public final /* synthetic */ l k(l lVar) {
        return C0099b.b(this, lVar);
    }

    public final long s(q qVar) {
        return qVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) qVar).isTimeBased() ? this.f28291b.s(qVar) : this.f28290a.s(qVar) : qVar.h(this);
    }

    public final C0100c toLocalDate() {
        return this.f28290a;
    }

    public final k toLocalTime() {
        return this.f28291b;
    }

    public final String toString() {
        String cVar = this.f28290a.toString();
        String kVar = this.f28291b.toString();
        return cVar + "T" + kVar;
    }

    public final /* synthetic */ Object v(s sVar) {
        return C0099b.m(this, sVar);
    }

    /* renamed from: w */
    public final /* synthetic */ int compareTo(C0103f fVar) {
        return C0099b.e(this, fVar);
    }

    /* access modifiers changed from: package-private */
    public final void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeObject(this.f28290a);
        objectOutput.writeObject(this.f28291b);
    }
}
