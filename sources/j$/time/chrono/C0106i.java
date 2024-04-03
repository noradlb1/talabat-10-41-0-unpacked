package j$.time.chrono;

import j$.lang.a;
import j$.time.b;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.m;
import j$.time.temporal.p;
import j$.time.temporal.u;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* renamed from: j$.time.chrono.i  reason: case insensitive filesystem */
final class C0106i implements TemporalAmount, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ int f28292e = 0;
    private static final long serialVersionUID = 57387258289L;

    /* renamed from: a  reason: collision with root package name */
    private final n f28293a;

    /* renamed from: b  reason: collision with root package name */
    final int f28294b;

    /* renamed from: c  reason: collision with root package name */
    final int f28295c;

    /* renamed from: d  reason: collision with root package name */
    final int f28296d;

    static {
        a.c(new Object[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS});
    }

    C0106i(n nVar, int i11, int i12, int i13) {
        this.f28293a = nVar;
        this.f28294b = i11;
        this.f28295c = i12;
        this.f28296d = i13;
    }

    private long a() {
        u n11 = this.f28293a.n(j$.time.temporal.a.MONTH_OF_YEAR);
        if (!n11.g() || !n11.h()) {
            return -1;
        }
        return (n11.d() - n11.e()) + 1;
    }

    private void b(m mVar) {
        Objects.requireNonNull(mVar, "temporal");
        n nVar = (n) mVar.v(p.e());
        if (nVar != null) {
            n nVar2 = this.f28293a;
            if (!((C0098a) nVar2).equals(nVar)) {
                String e11 = nVar2.e();
                String e12 = nVar.e();
                throw new b("Chronology mismatch, expected: " + e11 + ", actual: " + e12);
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* access modifiers changed from: package-private */
    public final void c(DataOutput dataOutput) {
        dataOutput.writeUTF(this.f28293a.e());
        dataOutput.writeInt(this.f28294b);
        dataOutput.writeInt(this.f28295c);
        dataOutput.writeInt(this.f28296d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0106i)) {
            return false;
        }
        C0106i iVar = (C0106i) obj;
        if (this.f28294b == iVar.f28294b && this.f28295c == iVar.f28295c && this.f28296d == iVar.f28296d) {
            if (((C0098a) this.f28293a).equals(iVar.f28293a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.time.temporal.l f(j$.time.temporal.l r7) {
        /*
            r6 = this;
            r6.b(r7)
            int r0 = r6.f28294b
            int r1 = r6.f28295c
            if (r1 != 0) goto L_0x000f
            if (r0 == 0) goto L_0x0034
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.YEARS
            goto L_0x0030
        L_0x000f:
            long r2 = r6.a()
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0024
            long r4 = (long) r0
            long r4 = r4 * r2
            long r0 = (long) r1
            long r4 = r4 + r0
            j$.time.temporal.ChronoUnit r0 = j$.time.temporal.ChronoUnit.MONTHS
            j$.time.temporal.l r7 = r7.b(r4, r0)
            goto L_0x0034
        L_0x0024:
            if (r0 == 0) goto L_0x002d
            long r2 = (long) r0
            j$.time.temporal.ChronoUnit r0 = j$.time.temporal.ChronoUnit.YEARS
            j$.time.temporal.l r7 = r7.b(r2, r0)
        L_0x002d:
            long r0 = (long) r1
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.MONTHS
        L_0x0030:
            j$.time.temporal.l r7 = r7.b(r0, r2)
        L_0x0034:
            int r0 = r6.f28296d
            if (r0 == 0) goto L_0x003f
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.DAYS
            j$.time.temporal.l r7 = r7.b(r0, r2)
        L_0x003f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.C0106i.f(j$.time.temporal.l):j$.time.temporal.l");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.time.temporal.l g(j$.time.temporal.l r7) {
        /*
            r6 = this;
            r6.b(r7)
            int r0 = r6.f28294b
            int r1 = r6.f28295c
            if (r1 != 0) goto L_0x000f
            if (r0 == 0) goto L_0x0034
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.YEARS
            goto L_0x0030
        L_0x000f:
            long r2 = r6.a()
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0024
            long r4 = (long) r0
            long r4 = r4 * r2
            long r0 = (long) r1
            long r4 = r4 + r0
            j$.time.temporal.ChronoUnit r0 = j$.time.temporal.ChronoUnit.MONTHS
            j$.time.temporal.l r7 = r7.d(r4, r0)
            goto L_0x0034
        L_0x0024:
            if (r0 == 0) goto L_0x002d
            long r2 = (long) r0
            j$.time.temporal.ChronoUnit r0 = j$.time.temporal.ChronoUnit.YEARS
            j$.time.temporal.l r7 = r7.d(r2, r0)
        L_0x002d:
            long r0 = (long) r1
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.MONTHS
        L_0x0030:
            j$.time.temporal.l r7 = r7.d(r0, r2)
        L_0x0034:
            int r0 = r6.f28296d
            if (r0 == 0) goto L_0x003f
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.DAYS
            j$.time.temporal.l r7 = r7.d(r0, r2)
        L_0x003f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.C0106i.g(j$.time.temporal.l):j$.time.temporal.l");
    }

    public final int hashCode() {
        return ((C0098a) this.f28293a).hashCode() ^ (Integer.rotateLeft(this.f28296d, 16) + (Integer.rotateLeft(this.f28295c, 8) + this.f28294b));
    }

    public final String toString() {
        int i11 = this.f28296d;
        int i12 = this.f28295c;
        int i13 = this.f28294b;
        boolean z11 = i13 == 0 && i12 == 0 && i11 == 0;
        n nVar = this.f28293a;
        if (z11) {
            String e11 = ((C0098a) nVar).e();
            return e11 + " P0D";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((C0098a) nVar).e());
        sb2.append(" P");
        if (i13 != 0) {
            sb2.append(i13);
            sb2.append('Y');
        }
        if (i12 != 0) {
            sb2.append(i12);
            sb2.append('M');
        }
        if (i11 != 0) {
            sb2.append(i11);
            sb2.append('D');
        }
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() {
        return new G((byte) 9, this);
    }
}
