package j$.time;

import com.facebook.internal.security.CertificateUtil;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import com.huawei.hms.push.constant.RemoteMessageConst;
import j$.time.chrono.C0099b;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import j$.time.temporal.t;
import j$.time.temporal.u;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import org.threeten.bp.Year;

public final class k implements l, n, Comparable, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final k f28415e;

    /* renamed from: f  reason: collision with root package name */
    public static final k f28416f = new k(23, 59, 59, Year.MAX_VALUE);

    /* renamed from: g  reason: collision with root package name */
    public static final k f28417g;

    /* renamed from: h  reason: collision with root package name */
    private static final k[] f28418h = new k[24];
    private static final long serialVersionUID = 6414437269572265201L;

    /* renamed from: a  reason: collision with root package name */
    private final byte f28419a;

    /* renamed from: b  reason: collision with root package name */
    private final byte f28420b;

    /* renamed from: c  reason: collision with root package name */
    private final byte f28421c;

    /* renamed from: d  reason: collision with root package name */
    private final int f28422d;

    static {
        int i11 = 0;
        while (true) {
            k[] kVarArr = f28418h;
            if (i11 < kVarArr.length) {
                kVarArr[i11] = new k(i11, 0, 0, 0);
                i11++;
            } else {
                k kVar = kVarArr[0];
                f28417g = kVar;
                k kVar2 = kVarArr[12];
                f28415e = kVar;
                return;
            }
        }
    }

    private k(int i11, int i12, int i13, int i14) {
        this.f28419a = (byte) i11;
        this.f28420b = (byte) i12;
        this.f28421c = (byte) i13;
        this.f28422d = i14;
    }

    private static k C(int i11, int i12, int i13, int i14) {
        return ((i12 | i13) | i14) == 0 ? f28418h[i11] : new k(i11, i12, i13, i14);
    }

    public static k D(m mVar) {
        Objects.requireNonNull(mVar, "temporal");
        k kVar = (k) mVar.v(p.g());
        if (kVar != null) {
            return kVar;
        }
        String name2 = mVar.getClass().getName();
        throw new b("Unable to obtain LocalTime from TemporalAccessor: " + mVar + " of type " + name2);
    }

    private int E(q qVar) {
        int i11 = j.f28413a[((a) qVar).ordinal()];
        byte b11 = this.f28420b;
        int i12 = this.f28422d;
        byte b12 = this.f28419a;
        switch (i11) {
            case 1:
                return i12;
            case 2:
                throw new t("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return i12 / 1000;
            case 4:
                throw new t("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return i12 / 1000000;
            case 6:
                return (int) (R() / 1000000);
            case 7:
                return this.f28421c;
            case 8:
                return S();
            case 9:
                return b11;
            case 10:
                return (b12 * 60) + b11;
            case 11:
                return b12 % 12;
            case 12:
                int i13 = b12 % 12;
                if (i13 % 12 == 0) {
                    return 12;
                }
                return i13;
            case 13:
                return b12;
            case 14:
                if (b12 == 0) {
                    return 24;
                }
                return b12;
            case 15:
                return b12 / 12;
            default:
                throw new t(c.a("Unsupported field: ", qVar));
        }
    }

    public static k I(int i11) {
        a.HOUR_OF_DAY.v((long) i11);
        return f28418h[i11];
    }

    public static k J(long j11) {
        a.NANO_OF_DAY.v(j11);
        int i11 = (int) (j11 / 3600000000000L);
        long j12 = j11 - (((long) i11) * 3600000000000L);
        int i12 = (int) (j12 / 60000000000L);
        long j13 = j12 - (((long) i12) * 60000000000L);
        int i13 = (int) (j13 / C.NANOS_PER_SECOND);
        return C(i11, i12, i13, (int) (j13 - (((long) i13) * C.NANOS_PER_SECOND)));
    }

    public static k K(long j11) {
        a.SECOND_OF_DAY.v(j11);
        int i11 = (int) (j11 / 3600);
        long j12 = j11 - ((long) (i11 * 3600));
        int i12 = (int) (j12 / 60);
        return C(i11, i12, (int) (j12 - ((long) (i12 * 60))), 0);
    }

    static k Q(DataInput dataInput) {
        int i11;
        int i12;
        int readByte = dataInput.readByte();
        int i13 = 0;
        if (readByte < 0) {
            readByte = ~readByte;
            i11 = 0;
            i12 = 0;
        } else {
            byte readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                int i14 = ~readByte2;
                i12 = 0;
                i13 = i14;
                i11 = 0;
            } else {
                byte readByte3 = dataInput.readByte();
                if (readByte3 < 0) {
                    i11 = ~readByte3;
                } else {
                    i13 = dataInput.readInt();
                    i11 = readByte3;
                }
                byte b11 = readByte2;
                i12 = i13;
                i13 = b11;
            }
        }
        a.HOUR_OF_DAY.v((long) readByte);
        a.MINUTE_OF_HOUR.v((long) i13);
        a.SECOND_OF_MINUTE.v((long) i11);
        a.NANO_OF_SECOND.v((long) i12);
        return C(readByte, i13, i11, i12);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 4, this);
    }

    /* renamed from: B */
    public final int compareTo(k kVar) {
        byte b11 = kVar.f28419a;
        int i11 = 0;
        byte b12 = this.f28419a;
        int i12 = b12 < b11 ? -1 : b12 == b11 ? 0 : 1;
        if (i12 != 0) {
            return i12;
        }
        byte b13 = this.f28420b;
        byte b14 = kVar.f28420b;
        int i13 = b13 < b14 ? -1 : b13 == b14 ? 0 : 1;
        if (i13 != 0) {
            return i13;
        }
        byte b15 = this.f28421c;
        byte b16 = kVar.f28421c;
        int i14 = b15 < b16 ? -1 : b15 == b16 ? 0 : 1;
        if (i14 != 0) {
            return i14;
        }
        int i15 = this.f28422d;
        int i16 = kVar.f28422d;
        if (i15 < i16) {
            i11 = -1;
        } else if (i15 != i16) {
            i11 = 1;
        }
        return i11;
    }

    public final int F() {
        return this.f28419a;
    }

    public final int G() {
        return this.f28422d;
    }

    public final int H() {
        return this.f28421c;
    }

    /* renamed from: L */
    public final k b(long j11, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (k) temporalUnit.f(this, j11);
        }
        switch (j.f28414b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return O(j11);
            case 2:
                return O((j11 % 86400000000L) * 1000);
            case 3:
                return O((j11 % 86400000) * 1000000);
            case 4:
                return P(j11);
            case 5:
                return N(j11);
            case 6:
                return M(j11);
            case 7:
                return M((j11 % 2) * 12);
            default:
                throw new t("Unsupported unit: " + temporalUnit);
        }
    }

    public final k M(long j11) {
        if (j11 == 0) {
            return this;
        }
        return C(((((int) (j11 % 24)) + this.f28419a) + 24) % 24, this.f28420b, this.f28421c, this.f28422d);
    }

    public final k N(long j11) {
        if (j11 == 0) {
            return this;
        }
        int i11 = (this.f28419a * 60) + this.f28420b;
        int i12 = ((((int) (j11 % 1440)) + i11) + 1440) % 1440;
        return i11 == i12 ? this : C(i12 / 60, i12 % 60, this.f28421c, this.f28422d);
    }

    public final k O(long j11) {
        if (j11 == 0) {
            return this;
        }
        long R = R();
        long j12 = (((j11 % 86400000000000L) + R) + 86400000000000L) % 86400000000000L;
        return R == j12 ? this : C((int) (j12 / 3600000000000L), (int) ((j12 / 60000000000L) % 60), (int) ((j12 / C.NANOS_PER_SECOND) % 60), (int) (j12 % C.NANOS_PER_SECOND));
    }

    public final k P(long j11) {
        if (j11 == 0) {
            return this;
        }
        int i11 = (this.f28420b * 60) + (this.f28419a * Ascii.DLE) + this.f28421c;
        int i12 = ((((int) (j11 % 86400)) + i11) + RemoteMessageConst.DEFAULT_TTL) % RemoteMessageConst.DEFAULT_TTL;
        return i11 == i12 ? this : C(i12 / 3600, (i12 / 60) % 60, i12 % 60, this.f28422d);
    }

    public final long R() {
        return (((long) this.f28421c) * C.NANOS_PER_SECOND) + (((long) this.f28420b) * 60000000000L) + (((long) this.f28419a) * 3600000000000L) + ((long) this.f28422d);
    }

    public final int S() {
        return (this.f28420b * 60) + (this.f28419a * Ascii.DLE) + this.f28421c;
    }

    /* renamed from: T */
    public final k a(long j11, q qVar) {
        if (!(qVar instanceof a)) {
            return (k) qVar.k(this, j11);
        }
        a aVar = (a) qVar;
        aVar.v(j11);
        int i11 = j.f28413a[aVar.ordinal()];
        byte b11 = this.f28420b;
        byte b12 = this.f28421c;
        int i12 = this.f28422d;
        byte b13 = this.f28419a;
        switch (i11) {
            case 1:
                return U((int) j11);
            case 2:
                return J(j11);
            case 3:
                return U(((int) j11) * 1000);
            case 4:
                return J(j11 * 1000);
            case 5:
                return U(((int) j11) * 1000000);
            case 6:
                return J(j11 * 1000000);
            case 7:
                int i13 = (int) j11;
                if (b12 == i13) {
                    return this;
                }
                a.SECOND_OF_MINUTE.v((long) i13);
                return C(b13, b11, i13, i12);
            case 8:
                return P(j11 - ((long) S()));
            case 9:
                int i14 = (int) j11;
                if (b11 == i14) {
                    return this;
                }
                a.MINUTE_OF_HOUR.v((long) i14);
                return C(b13, i14, b12, i12);
            case 10:
                return N(j11 - ((long) ((b13 * 60) + b11)));
            case 11:
                return M(j11 - ((long) (b13 % 12)));
            case 12:
                if (j11 == 12) {
                    j11 = 0;
                }
                return M(j11 - ((long) (b13 % 12)));
            case 13:
                int i15 = (int) j11;
                if (b13 == i15) {
                    return this;
                }
                a.HOUR_OF_DAY.v((long) i15);
                return C(i15, b11, b12, i12);
            case 14:
                if (j11 == 24) {
                    j11 = 0;
                }
                int i16 = (int) j11;
                if (b13 == i16) {
                    return this;
                }
                a.HOUR_OF_DAY.v((long) i16);
                return C(i16, b11, b12, i12);
            case 15:
                return M((j11 - ((long) (b13 / 12))) * 12);
            default:
                throw new t(c.a("Unsupported field: ", qVar));
        }
    }

    public final k U(int i11) {
        if (this.f28422d == i11) {
            return this;
        }
        a.NANO_OF_SECOND.v((long) i11);
        return C(this.f28419a, this.f28420b, this.f28421c, i11);
    }

    /* access modifiers changed from: package-private */
    public final void V(DataOutput dataOutput) {
        int i11;
        byte b11 = this.f28421c;
        byte b12 = this.f28420b;
        byte b13 = this.f28419a;
        int i12 = this.f28422d;
        if (i12 == 0) {
            if (b11 != 0) {
                dataOutput.writeByte(b13);
                dataOutput.writeByte(b12);
                i11 = ~b11;
            } else if (b12 == 0) {
                i11 = ~b13;
            } else {
                dataOutput.writeByte(b13);
                i11 = ~b12;
            }
            dataOutput.writeByte(i11);
            return;
        }
        dataOutput.writeByte(b13);
        dataOutput.writeByte(b12);
        dataOutput.writeByte(b11);
        dataOutput.writeInt(i12);
    }

    public final boolean c(q qVar) {
        return qVar instanceof a ? qVar.isTimeBased() : qVar != null && qVar.f(this);
    }

    public final l d(long j11, ChronoUnit chronoUnit) {
        return j11 == Long.MIN_VALUE ? b(Long.MAX_VALUE, chronoUnit).b(1, chronoUnit) : b(-j11, chronoUnit);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f28419a == kVar.f28419a && this.f28420b == kVar.f28420b && this.f28421c == kVar.f28421c && this.f28422d == kVar.f28422d;
    }

    public final int f(q qVar) {
        return qVar instanceof a ? E(qVar) : p.a(this, qVar);
    }

    public final l g(h hVar) {
        boolean z11 = hVar instanceof k;
        m mVar = hVar;
        if (!z11) {
            mVar = C0099b.a(hVar, this);
        }
        return (k) mVar;
    }

    public final u h(q qVar) {
        return p.d(this, qVar);
    }

    public final int hashCode() {
        long R = R();
        return (int) (R ^ (R >>> 32));
    }

    public final l k(l lVar) {
        return lVar.a(R(), a.NANO_OF_DAY);
    }

    public final long s(q qVar) {
        return qVar instanceof a ? qVar == a.NANO_OF_DAY ? R() : qVar == a.MICRO_OF_DAY ? R() / 1000 : (long) E(qVar) : qVar.h(this);
    }

    public final String toString() {
        int i11;
        StringBuilder sb2 = new StringBuilder(18);
        byte b11 = this.f28419a;
        sb2.append(b11 < 10 ? "0" : "");
        sb2.append(b11);
        String str = ":0";
        byte b12 = this.f28420b;
        sb2.append(b12 < 10 ? str : CertificateUtil.DELIMITER);
        sb2.append(b12);
        byte b13 = this.f28421c;
        int i12 = this.f28422d;
        if (b13 > 0 || i12 > 0) {
            if (b13 >= 10) {
                str = CertificateUtil.DELIMITER;
            }
            sb2.append(str);
            sb2.append(b13);
            if (i12 > 0) {
                sb2.append('.');
                int i13 = 1000000;
                if (i12 % 1000000 == 0) {
                    i11 = (i12 / 1000000) + 1000;
                } else {
                    if (i12 % 1000 == 0) {
                        i12 /= 1000;
                    } else {
                        i13 = 1000000000;
                    }
                    i11 = i12 + i13;
                }
                sb2.append(Integer.toString(i11).substring(1));
            }
        }
        return sb2.toString();
    }

    public final Object v(s sVar) {
        if (sVar == p.e() || sVar == p.k() || sVar == p.j() || sVar == p.h()) {
            return null;
        }
        if (sVar == p.g()) {
            return this;
        }
        if (sVar == p.f()) {
            return null;
        }
        return sVar == p.i() ? ChronoUnit.NANOS : sVar.a(this);
    }
}
