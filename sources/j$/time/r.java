package j$.time;

import com.google.common.base.Ascii;
import j$.lang.a;
import j$.time.chrono.n;
import j$.time.chrono.u;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.m;
import j$.time.temporal.p;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

public final class r implements TemporalAmount, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final r f28432d = new r(0, 0, 0);
    private static final long serialVersionUID = -3587258372562876L;

    /* renamed from: a  reason: collision with root package name */
    private final int f28433a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28434b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28435c;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        a.c(new Object[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS});
    }

    private r(int i11, int i12, int i13) {
        this.f28433a = i11;
        this.f28434b = i12;
        this.f28435c = i13;
    }

    static r a(DataInput dataInput) {
        int readInt = dataInput.readInt();
        int readInt2 = dataInput.readInt();
        int readInt3 = dataInput.readInt();
        return ((readInt | readInt2) | readInt3) == 0 ? f28432d : new r(readInt, readInt2, readInt3);
    }

    private static void b(m mVar) {
        Objects.requireNonNull(mVar, "temporal");
        n nVar = (n) mVar.v(p.e());
        if (nVar != null && !u.f28321d.equals(nVar)) {
            String e11 = nVar.e();
            throw new b("Chronology mismatch, expected: ISO, actual: " + e11);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s(Ascii.SO, this);
    }

    /* access modifiers changed from: package-private */
    public final void c(DataOutput dataOutput) {
        dataOutput.writeInt(this.f28433a);
        dataOutput.writeInt(this.f28434b);
        dataOutput.writeInt(this.f28435c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f28433a == rVar.f28433a && this.f28434b == rVar.f28434b && this.f28435c == rVar.f28435c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.time.temporal.l f(j$.time.temporal.l r7) {
        /*
            r6 = this;
            b(r7)
            int r0 = r6.f28433a
            int r1 = r6.f28434b
            if (r1 != 0) goto L_0x000f
            if (r0 == 0) goto L_0x0021
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.YEARS
            goto L_0x001d
        L_0x000f:
            long r2 = (long) r0
            r4 = 12
            long r2 = r2 * r4
            long r0 = (long) r1
            long r0 = r0 + r2
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0021
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.MONTHS
        L_0x001d:
            j$.time.temporal.l r7 = r7.b(r0, r2)
        L_0x0021:
            int r0 = r6.f28435c
            if (r0 == 0) goto L_0x002c
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.DAYS
            j$.time.temporal.l r7 = r7.b(r0, r2)
        L_0x002c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.r.f(j$.time.temporal.l):j$.time.temporal.l");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.time.temporal.l g(j$.time.temporal.l r7) {
        /*
            r6 = this;
            b(r7)
            int r0 = r6.f28433a
            int r1 = r6.f28434b
            if (r1 != 0) goto L_0x000f
            if (r0 == 0) goto L_0x0021
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.YEARS
            goto L_0x001d
        L_0x000f:
            long r2 = (long) r0
            r4 = 12
            long r2 = r2 * r4
            long r0 = (long) r1
            long r0 = r0 + r2
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0021
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.MONTHS
        L_0x001d:
            j$.time.temporal.l r7 = r7.d(r0, r2)
        L_0x0021:
            int r0 = r6.f28435c
            if (r0 == 0) goto L_0x002c
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.DAYS
            j$.time.temporal.l r7 = r7.d(r0, r2)
        L_0x002c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.r.g(j$.time.temporal.l):j$.time.temporal.l");
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.f28435c, 16) + Integer.rotateLeft(this.f28434b, 8) + this.f28433a;
    }

    public final String toString() {
        if (this == f28432d) {
            return "P0D";
        }
        StringBuilder sb2 = new StringBuilder("P");
        int i11 = this.f28433a;
        if (i11 != 0) {
            sb2.append(i11);
            sb2.append('Y');
        }
        int i12 = this.f28434b;
        if (i12 != 0) {
            sb2.append(i12);
            sb2.append('M');
        }
        int i13 = this.f28435c;
        if (i13 != 0) {
            sb2.append(i13);
            sb2.append('D');
        }
        return sb2.toString();
    }
}
