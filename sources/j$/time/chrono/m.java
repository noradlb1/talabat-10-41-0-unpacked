package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.h;
import j$.time.k;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import j$.time.temporal.u;
import j$.time.x;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Objects;

final class m implements C0108k, Serializable {
    private static final long serialVersionUID = -5261813987200935591L;

    /* renamed from: a  reason: collision with root package name */
    private final transient C0105h f28299a;

    /* renamed from: b  reason: collision with root package name */
    private final transient ZoneOffset f28300b;

    /* renamed from: c  reason: collision with root package name */
    private final transient x f28301c;

    private m(x xVar, ZoneOffset zoneOffset, C0105h hVar) {
        Objects.requireNonNull(hVar, "dateTime");
        this.f28299a = hVar;
        Objects.requireNonNull(zoneOffset, "offset");
        this.f28300b = zoneOffset;
        Objects.requireNonNull(xVar, "zone");
        this.f28301c = xVar;
    }

    static m B(n nVar, l lVar) {
        m mVar = (m) lVar;
        C0098a aVar = (C0098a) nVar;
        if (aVar.equals(mVar.getChronology())) {
            return mVar;
        }
        String e11 = aVar.e();
        String e12 = mVar.getChronology().e();
        throw new ClassCastException("Chronology mismatch, required: " + e11 + ", actual: " + e12);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        if (r2.contains(r7) != false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static j$.time.chrono.C0108k D(j$.time.x r6, j$.time.ZoneOffset r7, j$.time.chrono.C0105h r8) {
        /*
            java.lang.String r0 = "localDateTime"
            java.util.Objects.requireNonNull(r8, r0)
            java.lang.String r0 = "zone"
            java.util.Objects.requireNonNull(r6, r0)
            boolean r0 = r6 instanceof j$.time.ZoneOffset
            if (r0 == 0) goto L_0x0017
            j$.time.chrono.m r7 = new j$.time.chrono.m
            r0 = r6
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            r7.<init>(r6, r0, r8)
            return r7
        L_0x0017:
            j$.time.zone.f r0 = r6.B()
            j$.time.LocalDateTime r1 = j$.time.LocalDateTime.C(r8)
            java.util.List r2 = r0.g(r1)
            int r3 = r2.size()
            r4 = 1
            r5 = 0
            if (r3 != r4) goto L_0x0032
        L_0x002b:
            java.lang.Object r7 = r2.get(r5)
            j$.time.ZoneOffset r7 = (j$.time.ZoneOffset) r7
            goto L_0x0055
        L_0x0032:
            int r3 = r2.size()
            if (r3 != 0) goto L_0x004d
            j$.time.zone.b r7 = r0.f(r1)
            j$.time.Duration r0 = r7.h()
            long r0 = r0.getSeconds()
            j$.time.chrono.h r8 = r8.F(r0)
            j$.time.ZoneOffset r7 = r7.k()
            goto L_0x0055
        L_0x004d:
            if (r7 == 0) goto L_0x002b
            boolean r0 = r2.contains(r7)
            if (r0 == 0) goto L_0x002b
        L_0x0055:
            java.lang.String r0 = "offset"
            java.util.Objects.requireNonNull(r7, r0)
            j$.time.chrono.m r0 = new j$.time.chrono.m
            r0.<init>(r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.m.D(j$.time.x, j$.time.ZoneOffset, j$.time.chrono.h):j$.time.chrono.k");
    }

    static m E(n nVar, Instant instant, x xVar) {
        ZoneOffset d11 = xVar.B().d(instant);
        Objects.requireNonNull(d11, "offset");
        return new m(xVar, d11, (C0105h) nVar.r(LocalDateTime.K(instant.getEpochSecond(), instant.D(), d11)));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new G((byte) 3, this);
    }

    /* renamed from: C */
    public final C0108k d(long j11, TemporalUnit temporalUnit) {
        return B(getChronology(), p.b(this, j11, (ChronoUnit) temporalUnit));
    }

    /* renamed from: F */
    public final C0108k b(long j11, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return B(getChronology(), temporalUnit.f(this, j11));
        }
        return B(getChronology(), this.f28299a.b(j11, temporalUnit).k(this));
    }

    public final l a(long j11, q qVar) {
        if (!(qVar instanceof a)) {
            return B(getChronology(), qVar.k(this, j11));
        }
        a aVar = (a) qVar;
        int i11 = C0109l.f28298a[aVar.ordinal()];
        if (i11 == 1) {
            return b(j11 - C0099b.q(this), ChronoUnit.SECONDS);
        }
        x xVar = this.f28301c;
        C0105h hVar = this.f28299a;
        if (i11 != 2) {
            return D(xVar, this.f28300b, hVar.a(j11, qVar));
        }
        return E(getChronology(), Instant.E(hVar.H(ZoneOffset.L(aVar.s(j11))), (long) hVar.toLocalTime().G()), xVar);
    }

    public final boolean c(q qVar) {
        return (qVar instanceof a) || (qVar != null && qVar.f(this));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0108k) {
            return C0099b.f(this, (C0108k) obj) == 0;
        }
        return false;
    }

    public final /* synthetic */ int f(q qVar) {
        return C0099b.g(this, qVar);
    }

    public final l g(h hVar) {
        return B(getChronology(), hVar.k(this));
    }

    public final n getChronology() {
        return toLocalDate().getChronology();
    }

    public final ZoneOffset getOffset() {
        return this.f28300b;
    }

    public final x getZone() {
        return this.f28301c;
    }

    public final u h(q qVar) {
        return qVar instanceof a ? (qVar == a.INSTANT_SECONDS || qVar == a.OFFSET_SECONDS) ? qVar.range() : ((C0105h) toLocalDateTime()).h(qVar) : qVar.g(this);
    }

    public final int hashCode() {
        return (this.f28299a.hashCode() ^ this.f28300b.hashCode()) ^ Integer.rotateLeft(this.f28301c.hashCode(), 3);
    }

    /* renamed from: k */
    public final /* synthetic */ int compareTo(C0108k kVar) {
        return C0099b.f(this, kVar);
    }

    public final C0108k p(x xVar) {
        return D(xVar, this.f28300b, this.f28299a);
    }

    public final long s(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.h(this);
        }
        int i11 = C0107j.f28297a[((a) qVar).ordinal()];
        return i11 != 1 ? i11 != 2 ? ((C0105h) toLocalDateTime()).s(qVar) : (long) getOffset().I() : toEpochSecond();
    }

    public final /* synthetic */ long toEpochSecond() {
        return C0099b.q(this);
    }

    public final C0100c toLocalDate() {
        return ((C0105h) toLocalDateTime()).toLocalDate();
    }

    public final C0103f toLocalDateTime() {
        return this.f28299a;
    }

    public final k toLocalTime() {
        return ((C0105h) toLocalDateTime()).toLocalTime();
    }

    public final String toString() {
        String hVar = this.f28299a.toString();
        ZoneOffset zoneOffset = this.f28300b;
        String str = hVar + zoneOffset.toString();
        x xVar = this.f28301c;
        if (zoneOffset == xVar) {
            return str;
        }
        return str + "[" + xVar.toString() + "]";
    }

    public final /* synthetic */ Object v(s sVar) {
        return C0099b.n(this, sVar);
    }

    /* access modifiers changed from: package-private */
    public final void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeObject(this.f28299a);
        objectOutput.writeObject(this.f28300b);
        objectOutput.writeObject(this.f28301c);
    }
}
