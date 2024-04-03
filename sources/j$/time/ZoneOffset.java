package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.security.CertificateUtil;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import j$.time.temporal.t;
import j$.time.temporal.u;
import j$.time.zone.f;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public final class ZoneOffset extends x implements m, n, Comparable<ZoneOffset> {
    public static final ZoneOffset UTC = L(0);

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentHashMap f28257d = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentHashMap f28258e = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: f  reason: collision with root package name */
    public static final ZoneOffset f28259f = L(-64800);

    /* renamed from: g  reason: collision with root package name */
    public static final ZoneOffset f28260g = L(64800);
    private static final long serialVersionUID = 2357656521762053153L;

    /* renamed from: b  reason: collision with root package name */
    private final int f28261b;

    /* renamed from: c  reason: collision with root package name */
    private final transient String f28262c;

    private ZoneOffset(int i11) {
        String str;
        this.f28261b = i11;
        if (i11 == 0) {
            str = "Z";
        } else {
            int abs = Math.abs(i11);
            StringBuilder sb2 = new StringBuilder();
            int i12 = abs / 3600;
            int i13 = (abs / 60) % 60;
            sb2.append(i11 < 0 ? SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE : "+");
            sb2.append(i12 < 10 ? "0" : "");
            sb2.append(i12);
            String str2 = ":0";
            sb2.append(i13 < 10 ? str2 : CertificateUtil.DELIMITER);
            sb2.append(i13);
            int i14 = abs % 60;
            if (i14 != 0) {
                sb2.append(i14 >= 10 ? CertificateUtil.DELIMITER : str2);
                sb2.append(i14);
            }
            str = sb2.toString();
        }
        this.f28262c = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static j$.time.ZoneOffset J(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            java.util.Objects.requireNonNull(r7, r0)
            j$.util.concurrent.ConcurrentHashMap r0 = f28258e
            java.lang.Object r0 = r0.get(r7)
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            if (r0 == 0) goto L_0x0010
            return r0
        L_0x0010:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x0063
            r1 = 3
            if (r0 == r1) goto L_0x007f
            r4 = 5
            if (r0 == r4) goto L_0x0059
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L_0x0050
            r5 = 7
            if (r0 == r5) goto L_0x0043
            r1 = 9
            if (r0 != r1) goto L_0x0037
            int r0 = M(r7, r2, r3)
            int r1 = M(r7, r6, r2)
            int r2 = M(r7, r5, r2)
            goto L_0x0085
        L_0x0037:
            j$.time.b r0 = new j$.time.b
            java.lang.String r1 = "Invalid ID for ZoneOffset, invalid format: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L_0x0043:
            int r0 = M(r7, r2, r3)
            int r1 = M(r7, r1, r3)
            int r2 = M(r7, r4, r3)
            goto L_0x0085
        L_0x0050:
            int r0 = M(r7, r2, r3)
            int r1 = M(r7, r6, r2)
            goto L_0x0061
        L_0x0059:
            int r0 = M(r7, r2, r3)
            int r1 = M(r7, r1, r3)
        L_0x0061:
            r2 = r3
            goto L_0x0085
        L_0x0063:
            char r0 = r7.charAt(r3)
            char r7 = r7.charAt(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0"
            r1.append(r0)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
        L_0x007f:
            int r0 = M(r7, r2, r3)
            r1 = r3
            r2 = r1
        L_0x0085:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto L_0x009e
            if (r3 != r5) goto L_0x0092
            goto L_0x009e
        L_0x0092:
            j$.time.b r0 = new j$.time.b
            java.lang.String r1 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L_0x009e:
            if (r3 != r5) goto L_0x00a8
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            j$.time.ZoneOffset r7 = K(r7, r0, r1)
            return r7
        L_0x00a8:
            j$.time.ZoneOffset r7 = K(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.ZoneOffset.J(java.lang.String):j$.time.ZoneOffset");
    }

    public static ZoneOffset K(int i11, int i12, int i13) {
        if (i11 < -18 || i11 > 18) {
            throw new b("Zone offset hours not in valid range: value " + i11 + " is not in the range -18 to 18");
        }
        if (i11 > 0) {
            if (i12 < 0 || i13 < 0) {
                throw new b("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i11 < 0) {
            if (i12 > 0 || i13 > 0) {
                throw new b("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i12 > 0 && i13 < 0) || (i12 < 0 && i13 > 0)) {
            throw new b("Zone offset minutes and seconds must have the same sign");
        }
        if (i12 < -59 || i12 > 59) {
            throw new b("Zone offset minutes not in valid range: value " + i12 + " is not in the range -59 to 59");
        } else if (i13 < -59 || i13 > 59) {
            throw new b("Zone offset seconds not in valid range: value " + i13 + " is not in the range -59 to 59");
        } else if (Math.abs(i11) != 18 || (i12 | i13) == 0) {
            return L((i12 * 60) + (i11 * 3600) + i13);
        } else {
            throw new b("Zone offset not in valid range: -18:00 to +18:00");
        }
    }

    public static ZoneOffset L(int i11) {
        if (i11 < -64800 || i11 > 64800) {
            throw new b("Zone offset not in valid range: -18:00 to +18:00");
        } else if (i11 % TypedValues.Custom.TYPE_INT != 0) {
            return new ZoneOffset(i11);
        } else {
            Integer valueOf = Integer.valueOf(i11);
            ConcurrentHashMap concurrentHashMap = f28257d;
            ZoneOffset zoneOffset = (ZoneOffset) concurrentHashMap.get(valueOf);
            if (zoneOffset != null) {
                return zoneOffset;
            }
            concurrentHashMap.putIfAbsent(valueOf, new ZoneOffset(i11));
            ZoneOffset zoneOffset2 = (ZoneOffset) concurrentHashMap.get(valueOf);
            f28258e.putIfAbsent(zoneOffset2.f28262c, zoneOffset2);
            return zoneOffset2;
        }
    }

    private static int M(CharSequence charSequence, int i11, boolean z11) {
        if (!z11 || charSequence.charAt(i11 - 1) == ':') {
            char charAt = charSequence.charAt(i11);
            char charAt2 = charSequence.charAt(i11 + 1);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9') {
                throw new b("Invalid ID for ZoneOffset, non numeric characters found: " + charSequence);
            }
            return (charAt2 - '0') + ((charAt - '0') * 10);
        }
        throw new b("Invalid ID for ZoneOffset, colon not found when expected: " + charSequence);
    }

    static ZoneOffset N(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? L(dataInput.readInt()) : L(readByte * 900);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 8, this);
    }

    public final f B() {
        return f.j(this);
    }

    /* access modifiers changed from: package-private */
    public final void G(DataOutput dataOutput) {
        dataOutput.writeByte(8);
        O(dataOutput);
    }

    public final int H(ZoneOffset zoneOffset) {
        return zoneOffset.f28261b - this.f28261b;
    }

    public final int I() {
        return this.f28261b;
    }

    /* access modifiers changed from: package-private */
    public final void O(DataOutput dataOutput) {
        int i11 = this.f28261b;
        int i12 = i11 % TypedValues.Custom.TYPE_INT == 0 ? i11 / TypedValues.Custom.TYPE_INT : 127;
        dataOutput.writeByte(i12);
        if (i12 == 127) {
            dataOutput.writeInt(i11);
        }
    }

    public final boolean c(q qVar) {
        return qVar instanceof a ? qVar == a.OFFSET_SECONDS : qVar != null && qVar.f(this);
    }

    public final int compareTo(Object obj) {
        return ((ZoneOffset) obj).f28261b - this.f28261b;
    }

    public final String e() {
        return this.f28262c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZoneOffset)) {
            return false;
        }
        return this.f28261b == ((ZoneOffset) obj).f28261b;
    }

    public final int f(q qVar) {
        if (qVar == a.OFFSET_SECONDS) {
            return this.f28261b;
        }
        if (!(qVar instanceof a)) {
            return p.d(this, qVar).a(s(qVar), qVar);
        }
        throw new t(c.a("Unsupported field: ", qVar));
    }

    public final u h(q qVar) {
        return p.d(this, qVar);
    }

    public final int hashCode() {
        return this.f28261b;
    }

    public final l k(l lVar) {
        return lVar.a((long) this.f28261b, a.OFFSET_SECONDS);
    }

    public final long s(q qVar) {
        if (qVar == a.OFFSET_SECONDS) {
            return (long) this.f28261b;
        }
        if (!(qVar instanceof a)) {
            return qVar.h(this);
        }
        throw new t(c.a("Unsupported field: ", qVar));
    }

    public final String toString() {
        return this.f28262c;
    }

    public final Object v(s sVar) {
        return (sVar == p.h() || sVar == p.j()) ? this : p.c(this, sVar);
    }
}
