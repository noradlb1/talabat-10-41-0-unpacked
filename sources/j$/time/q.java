package j$.time;

import j$.time.chrono.C0099b;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.s;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Objects;

public final class q implements l, n, Comparable, Serializable {
    private static final long serialVersionUID = 7264499704384272492L;

    /* renamed from: a  reason: collision with root package name */
    private final k f28430a;

    /* renamed from: b  reason: collision with root package name */
    private final ZoneOffset f28431b;

    static {
        k kVar = k.f28415e;
        ZoneOffset zoneOffset = ZoneOffset.f28260g;
        kVar.getClass();
        B(kVar, zoneOffset);
        k kVar2 = k.f28416f;
        ZoneOffset zoneOffset2 = ZoneOffset.f28259f;
        kVar2.getClass();
        B(kVar2, zoneOffset2);
    }

    private q(k kVar, ZoneOffset zoneOffset) {
        Objects.requireNonNull(kVar, "time");
        this.f28430a = kVar;
        Objects.requireNonNull(zoneOffset, "offset");
        this.f28431b = zoneOffset;
    }

    public static q B(k kVar, ZoneOffset zoneOffset) {
        return new q(kVar, zoneOffset);
    }

    static q D(ObjectInput objectInput) {
        return new q(k.Q(objectInput), ZoneOffset.N(objectInput));
    }

    private q E(k kVar, ZoneOffset zoneOffset) {
        return (this.f28430a != kVar || !this.f28431b.equals(zoneOffset)) ? new q(kVar, zoneOffset) : this;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 9, this);
    }

    /* renamed from: C */
    public final q b(long j11, TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? E(this.f28430a.b(j11, temporalUnit), this.f28431b) : (q) temporalUnit.f(this, j11);
    }

    public final l a(long j11, j$.time.temporal.q qVar) {
        if (!(qVar instanceof a)) {
            return (q) qVar.k(this, j11);
        }
        a aVar = a.OFFSET_SECONDS;
        k kVar = this.f28430a;
        return qVar == aVar ? E(kVar, ZoneOffset.L(((a) qVar).s(j11))) : E(kVar.a(j11, qVar), this.f28431b);
    }

    public final boolean c(j$.time.temporal.q qVar) {
        return qVar instanceof a ? qVar.isTimeBased() || qVar == a.OFFSET_SECONDS : qVar != null && qVar.f(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r11 = j$.lang.a.a(r2.R() - (((long) r1.I()) * com.google.android.exoplayer2.C.NANOS_PER_SECOND), r3.R() - (((long) r11.f28431b.I()) * com.google.android.exoplayer2.C.NANOS_PER_SECOND));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int compareTo(java.lang.Object r11) {
        /*
            r10 = this;
            j$.time.q r11 = (j$.time.q) r11
            j$.time.ZoneOffset r0 = r11.f28431b
            j$.time.ZoneOffset r1 = r10.f28431b
            boolean r0 = r1.equals(r0)
            j$.time.k r2 = r10.f28430a
            j$.time.k r3 = r11.f28430a
            if (r0 == 0) goto L_0x0011
            goto L_0x0032
        L_0x0011:
            long r4 = r2.R()
            int r0 = r1.I()
            long r0 = (long) r0
            r6 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            long r0 = r0 * r6
            long r4 = r4 - r0
            long r0 = r3.R()
            j$.time.ZoneOffset r11 = r11.f28431b
            int r11 = r11.I()
            long r8 = (long) r11
            long r8 = r8 * r6
            long r0 = r0 - r8
            int r11 = j$.lang.a.a(r4, r0)
            if (r11 != 0) goto L_0x0036
        L_0x0032:
            int r11 = r2.compareTo(r3)
        L_0x0036:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.q.compareTo(java.lang.Object):int");
    }

    public final l d(long j11, ChronoUnit chronoUnit) {
        return j11 == Long.MIN_VALUE ? b(Long.MAX_VALUE, chronoUnit).b(1, chronoUnit) : b(-j11, chronoUnit);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f28430a.equals(qVar.f28430a) && this.f28431b.equals(qVar.f28431b);
    }

    public final int f(j$.time.temporal.q qVar) {
        return p.a(this, qVar);
    }

    public final l g(h hVar) {
        if (hVar instanceof k) {
            return E((k) hVar, this.f28431b);
        }
        if (hVar instanceof ZoneOffset) {
            return E(this.f28430a, (ZoneOffset) hVar);
        }
        boolean z11 = hVar instanceof q;
        m mVar = hVar;
        if (!z11) {
            mVar = C0099b.a(hVar, this);
        }
        return (q) mVar;
    }

    public final u h(j$.time.temporal.q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        if (qVar == a.OFFSET_SECONDS) {
            return qVar.range();
        }
        k kVar = this.f28430a;
        kVar.getClass();
        return p.d(kVar, qVar);
    }

    public final int hashCode() {
        return this.f28430a.hashCode() ^ this.f28431b.hashCode();
    }

    public final l k(l lVar) {
        return lVar.a(this.f28430a.R(), a.NANO_OF_DAY).a((long) this.f28431b.I(), a.OFFSET_SECONDS);
    }

    public final long s(j$.time.temporal.q qVar) {
        return qVar instanceof a ? qVar == a.OFFSET_SECONDS ? (long) this.f28431b.I() : this.f28430a.s(qVar) : qVar.h(this);
    }

    public final String toString() {
        String kVar = this.f28430a.toString();
        String zoneOffset = this.f28431b.toString();
        return kVar + zoneOffset;
    }

    public final Object v(s sVar) {
        if (sVar == p.h() || sVar == p.j()) {
            return this.f28431b;
        }
        boolean z11 = true;
        boolean z12 = sVar == p.k();
        if (sVar != p.e()) {
            z11 = false;
        }
        if ((z12 || z11) || sVar == p.f()) {
            return null;
        }
        return sVar == p.g() ? this.f28430a : sVar == p.i() ? ChronoUnit.NANOS : sVar.a(this);
    }

    /* access modifiers changed from: package-private */
    public final void writeExternal(ObjectOutput objectOutput) {
        this.f28430a.V(objectOutput);
        this.f28431b.O(objectOutput);
    }
}
