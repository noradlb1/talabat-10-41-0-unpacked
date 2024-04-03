package j$.time.zone;

import com.huawei.hms.push.constant.RemoteMessageConst;
import j$.lang.a;
import j$.time.Clock;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.chrono.C0099b;
import j$.time.h;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

public final class f implements Serializable {

    /* renamed from: i  reason: collision with root package name */
    private static final long[] f28524i = new long[0];

    /* renamed from: j  reason: collision with root package name */
    private static final e[] f28525j = new e[0];

    /* renamed from: k  reason: collision with root package name */
    private static final LocalDateTime[] f28526k = new LocalDateTime[0];

    /* renamed from: l  reason: collision with root package name */
    private static final b[] f28527l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;

    /* renamed from: a  reason: collision with root package name */
    private final long[] f28528a;

    /* renamed from: b  reason: collision with root package name */
    private final ZoneOffset[] f28529b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f28530c;

    /* renamed from: d  reason: collision with root package name */
    private final LocalDateTime[] f28531d;

    /* renamed from: e  reason: collision with root package name */
    private final ZoneOffset[] f28532e;

    /* renamed from: f  reason: collision with root package name */
    private final e[] f28533f;

    /* renamed from: g  reason: collision with root package name */
    private final TimeZone f28534g;

    /* renamed from: h  reason: collision with root package name */
    private final transient ConcurrentHashMap f28535h = new ConcurrentHashMap();

    private f(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[1];
        this.f28529b = zoneOffsetArr;
        zoneOffsetArr[0] = zoneOffset;
        long[] jArr = f28524i;
        this.f28528a = jArr;
        this.f28530c = jArr;
        this.f28531d = f28526k;
        this.f28532e = zoneOffsetArr;
        this.f28533f = f28525j;
        this.f28534g = null;
    }

    f(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[1];
        this.f28529b = zoneOffsetArr;
        zoneOffsetArr[0] = k(timeZone.getRawOffset());
        long[] jArr = f28524i;
        this.f28528a = jArr;
        this.f28530c = jArr;
        this.f28531d = f28526k;
        this.f28532e = zoneOffsetArr;
        this.f28533f = f28525j;
        this.f28534g = timeZone;
    }

    private f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        LocalDateTime localDateTime;
        this.f28528a = jArr;
        this.f28529b = zoneOffsetArr;
        this.f28530c = jArr2;
        this.f28532e = zoneOffsetArr2;
        this.f28533f = eVarArr;
        if (jArr2.length == 0) {
            this.f28531d = f28526k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            while (i11 < jArr2.length) {
                int i12 = i11 + 1;
                b bVar = new b(jArr2[i11], zoneOffsetArr2[i11], zoneOffsetArr2[i12]);
                if (bVar.B()) {
                    arrayList.add(bVar.g());
                    localDateTime = bVar.f();
                } else {
                    arrayList.add(bVar.f());
                    localDateTime = bVar.g();
                }
                arrayList.add(localDateTime);
                i11 = i12;
            }
            this.f28531d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.f28534g = null;
    }

    private static Object a(LocalDateTime localDateTime, b bVar) {
        LocalDateTime g11 = bVar.g();
        boolean B = bVar.B();
        boolean H = localDateTime.H(g11);
        return B ? H ? bVar.s() : localDateTime.H(bVar.f()) ? bVar : bVar.k() : !H ? bVar.k() : localDateTime.H(bVar.f()) ? bVar.s() : bVar;
    }

    private b[] b(int i11) {
        long j11;
        int i12 = i11;
        Integer valueOf = Integer.valueOf(i11);
        ConcurrentHashMap concurrentHashMap = this.f28535h;
        b[] bVarArr = (b[]) concurrentHashMap.get(valueOf);
        if (bVarArr != null) {
            return bVarArr;
        }
        TimeZone timeZone = this.f28534g;
        if (timeZone != null) {
            b[] bVarArr2 = f28527l;
            if (i12 < 1800) {
                return bVarArr2;
            }
            long p11 = C0099b.p(LocalDateTime.I(i12 - 1), this.f28529b[0]);
            int offset = timeZone.getOffset(p11 * 1000);
            long j12 = 31968000 + p11;
            while (p11 < j12) {
                long j13 = 7776000 + p11;
                long j14 = p11;
                if (offset != timeZone.getOffset(j13 * 1000)) {
                    p11 = j14;
                    while (j13 - p11 > 1) {
                        long j15 = j12;
                        long b11 = a.b(j13 + p11, 2);
                        int i13 = offset;
                        if (timeZone.getOffset(b11 * 1000) == i13) {
                            p11 = b11;
                        } else {
                            j13 = b11;
                        }
                        offset = i13;
                        j12 = j15;
                    }
                    j11 = j12;
                    int i14 = offset;
                    if (timeZone.getOffset(p11 * 1000) == i14) {
                        p11 = j13;
                    }
                    ZoneOffset k11 = k(i14);
                    offset = timeZone.getOffset(p11 * 1000);
                    ZoneOffset k12 = k(offset);
                    if (c(p11, k12) == i12) {
                        bVarArr2 = (b[]) Arrays.copyOf(bVarArr2, bVarArr2.length + 1);
                        bVarArr2[bVarArr2.length - 1] = new b(p11, k11, k12);
                    }
                } else {
                    j11 = j12;
                    int i15 = offset;
                    p11 = j13;
                }
                j12 = j11;
            }
            if (1916 <= i12 && i12 < 2100) {
                concurrentHashMap.putIfAbsent(valueOf, bVarArr2);
            }
            return bVarArr2;
        }
        e[] eVarArr = this.f28533f;
        b[] bVarArr3 = new b[eVarArr.length];
        for (int i16 = 0; i16 < eVarArr.length; i16++) {
            bVarArr3[i16] = eVarArr[i16].a(i12);
        }
        if (i12 < 2100) {
            concurrentHashMap.putIfAbsent(valueOf, bVarArr3);
        }
        return bVarArr3;
    }

    private static int c(long j11, ZoneOffset zoneOffset) {
        return h.O(a.b(j11 + ((long) zoneOffset.I()), (long) RemoteMessageConst.DEFAULT_TTL)).I();
    }

    private Object e(LocalDateTime localDateTime) {
        Object obj = null;
        ZoneOffset[] zoneOffsetArr = this.f28529b;
        int i11 = 0;
        TimeZone timeZone = this.f28534g;
        if (timeZone != null) {
            b[] b11 = b(localDateTime.F());
            if (b11.length == 0) {
                return k(timeZone.getOffset(C0099b.p(localDateTime, zoneOffsetArr[0]) * 1000));
            }
            int length = b11.length;
            while (i11 < length) {
                b bVar = b11[i11];
                Object a11 = a(localDateTime, bVar);
                if ((a11 instanceof b) || a11.equals(bVar.s())) {
                    return a11;
                }
                i11++;
                obj = a11;
            }
            return obj;
        } else if (this.f28530c.length == 0) {
            return zoneOffsetArr[0];
        } else {
            int length2 = this.f28533f.length;
            LocalDateTime[] localDateTimeArr = this.f28531d;
            if (length2 <= 0 || !localDateTime.G(localDateTimeArr[localDateTimeArr.length - 1])) {
                int binarySearch = Arrays.binarySearch(localDateTimeArr, localDateTime);
                ZoneOffset[] zoneOffsetArr2 = this.f28532e;
                if (binarySearch == -1) {
                    return zoneOffsetArr2[0];
                }
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 2;
                } else if (binarySearch < localDateTimeArr.length - 1) {
                    int i12 = binarySearch + 1;
                    if (localDateTimeArr[binarySearch].equals(localDateTimeArr[i12])) {
                        binarySearch = i12;
                    }
                }
                if ((binarySearch & 1) != 0) {
                    return zoneOffsetArr2[(binarySearch / 2) + 1];
                }
                LocalDateTime localDateTime2 = localDateTimeArr[binarySearch];
                LocalDateTime localDateTime3 = localDateTimeArr[binarySearch + 1];
                int i13 = binarySearch / 2;
                ZoneOffset zoneOffset = zoneOffsetArr2[i13];
                ZoneOffset zoneOffset2 = zoneOffsetArr2[i13 + 1];
                return zoneOffset2.I() > zoneOffset.I() ? new b(localDateTime2, zoneOffset, zoneOffset2) : new b(localDateTime3, zoneOffset, zoneOffset2);
            }
            b[] b12 = b(localDateTime.F());
            int length3 = b12.length;
            while (i11 < length3) {
                b bVar2 = b12[i11];
                Object a12 = a(localDateTime, bVar2);
                if ((a12 instanceof b) || a12.equals(bVar2.s())) {
                    return a12;
                }
                i11++;
                obj = a12;
            }
            return obj;
        }
    }

    public static f j(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        return new f(zoneOffset);
    }

    private static ZoneOffset k(int i11) {
        return ZoneOffset.L(i11 / 1000);
    }

    static f l(DataInput dataInput) {
        int readInt = dataInput.readInt();
        long[] jArr = f28524i;
        long[] jArr2 = readInt == 0 ? jArr : new long[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            jArr2[i11] = a.a(dataInput);
        }
        int i12 = readInt + 1;
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            zoneOffsetArr[i13] = a.b(dataInput);
        }
        int readInt2 = dataInput.readInt();
        if (readInt2 != 0) {
            jArr = new long[readInt2];
        }
        long[] jArr3 = jArr;
        for (int i14 = 0; i14 < readInt2; i14++) {
            jArr3[i14] = a.a(dataInput);
        }
        int i15 = readInt2 + 1;
        ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i15];
        for (int i16 = 0; i16 < i15; i16++) {
            zoneOffsetArr2[i16] = a.b(dataInput);
        }
        int readByte = dataInput.readByte();
        e[] eVarArr = readByte == 0 ? f28525j : new e[readByte];
        for (int i17 = 0; i17 < readByte; i17++) {
            eVarArr[i17] = e.b(dataInput);
        }
        return new f(jArr2, zoneOffsetArr, jArr3, zoneOffsetArr2, eVarArr);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.f28534g != null ? (byte) 100 : 1, this);
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.f28534g;
        if (timeZone != null) {
            return k(timeZone.getOffset(instant.toEpochMilli()));
        }
        long[] jArr = this.f28530c;
        if (jArr.length == 0) {
            return this.f28529b[0];
        }
        long epochSecond = instant.getEpochSecond();
        int length = this.f28533f.length;
        ZoneOffset[] zoneOffsetArr = this.f28532e;
        if (length <= 0 || epochSecond <= jArr[jArr.length - 1]) {
            int binarySearch = Arrays.binarySearch(jArr, epochSecond);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            return zoneOffsetArr[binarySearch + 1];
        }
        b[] b11 = b(c(epochSecond, zoneOffsetArr[zoneOffsetArr.length - 1]));
        b bVar = null;
        for (int i11 = 0; i11 < b11.length; i11++) {
            bVar = b11[i11];
            if (epochSecond < bVar.toEpochSecond()) {
                return bVar.s();
            }
        }
        return bVar.k();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Objects.equals(this.f28534g, fVar.f28534g) && Arrays.equals(this.f28528a, fVar.f28528a) && Arrays.equals(this.f28529b, fVar.f28529b) && Arrays.equals(this.f28530c, fVar.f28530c) && Arrays.equals(this.f28532e, fVar.f28532e) && Arrays.equals(this.f28533f, fVar.f28533f);
    }

    public final b f(LocalDateTime localDateTime) {
        Object e11 = e(localDateTime);
        if (e11 instanceof b) {
            return (b) e11;
        }
        return null;
    }

    public final List g(LocalDateTime localDateTime) {
        Object e11 = e(localDateTime);
        return e11 instanceof b ? ((b) e11).v() : Collections.singletonList((ZoneOffset) e11);
    }

    public final boolean h(Instant instant) {
        ZoneOffset zoneOffset;
        TimeZone timeZone = this.f28534g;
        if (timeZone != null) {
            zoneOffset = k(timeZone.getRawOffset());
        } else {
            int length = this.f28530c.length;
            ZoneOffset[] zoneOffsetArr = this.f28529b;
            if (length == 0) {
                zoneOffset = zoneOffsetArr[0];
            } else {
                int binarySearch = Arrays.binarySearch(this.f28528a, instant.getEpochSecond());
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 2;
                }
                zoneOffset = zoneOffsetArr[binarySearch + 1];
            }
        }
        return !zoneOffset.equals(d(instant));
    }

    public final int hashCode() {
        return ((((Objects.hashCode(this.f28534g) ^ Arrays.hashCode(this.f28528a)) ^ Arrays.hashCode(this.f28529b)) ^ Arrays.hashCode(this.f28530c)) ^ Arrays.hashCode(this.f28532e)) ^ Arrays.hashCode(this.f28533f);
    }

    public final boolean i() {
        b bVar;
        TimeZone timeZone = this.f28534g;
        if (timeZone == null) {
            return this.f28530c.length == 0;
        }
        if (timeZone.useDaylightTime() || timeZone.getDSTSavings() != 0) {
            return false;
        }
        Instant instant = Instant.f28248c;
        Instant instant2 = Clock.systemUTC().instant();
        long epochSecond = instant2.getEpochSecond();
        if (instant2.D() > 0 && epochSecond < Long.MAX_VALUE) {
            epochSecond++;
        }
        int c11 = c(epochSecond, d(instant2));
        b[] b11 = b(c11);
        int length = b11.length - 1;
        while (true) {
            if (length < 0) {
                if (c11 > 1800) {
                    b[] b12 = b(c11 - 1);
                    int length2 = b12.length - 1;
                    while (true) {
                        if (length2 < 0) {
                            long min = Math.min(epochSecond - 31104000, (Clock.systemUTC().a() / 1000) + 31968000);
                            int offset = timeZone.getOffset((epochSecond - 1) * 1000);
                            long t11 = h.M(1800, 1, 1).t() * 86400;
                            while (true) {
                                if (t11 > min) {
                                    break;
                                }
                                int offset2 = timeZone.getOffset(min * 1000);
                                if (offset != offset2) {
                                    int c12 = c(min, k(offset2));
                                    b[] b13 = b(c12 + 1);
                                    int length3 = b13.length - 1;
                                    while (true) {
                                        if (length3 < 0) {
                                            b[] b14 = b(c12);
                                            bVar = b14[b14.length - 1];
                                            break;
                                        } else if (epochSecond > b13[length3].toEpochSecond()) {
                                            bVar = b13[length3];
                                            break;
                                        } else {
                                            length3--;
                                        }
                                    }
                                } else {
                                    min -= 7776000;
                                }
                            }
                        } else if (epochSecond > b12[length2].toEpochSecond()) {
                            bVar = b12[length2];
                            break;
                        } else {
                            length2--;
                        }
                    }
                }
                bVar = null;
            } else if (epochSecond > b11[length].toEpochSecond()) {
                bVar = b11[length];
                break;
            } else {
                length--;
            }
        }
        return bVar == null;
    }

    /* access modifiers changed from: package-private */
    public final void m(DataOutput dataOutput) {
        long[] jArr = this.f28528a;
        dataOutput.writeInt(jArr.length);
        for (long c11 : jArr) {
            a.c(c11, dataOutput);
        }
        for (ZoneOffset d11 : this.f28529b) {
            a.d(d11, dataOutput);
        }
        long[] jArr2 = this.f28530c;
        dataOutput.writeInt(jArr2.length);
        for (long c12 : jArr2) {
            a.c(c12, dataOutput);
        }
        for (ZoneOffset d12 : this.f28532e) {
            a.d(d12, dataOutput);
        }
        e[] eVarArr = this.f28533f;
        dataOutput.writeByte(eVarArr.length);
        for (e c13 : eVarArr) {
            c13.c(dataOutput);
        }
    }

    /* access modifiers changed from: package-private */
    public final void n(DataOutput dataOutput) {
        dataOutput.writeUTF(this.f28534g.getID());
    }

    public final String toString() {
        StringBuilder sb2;
        TimeZone timeZone = this.f28534g;
        if (timeZone != null) {
            String id2 = timeZone.getID();
            sb2 = new StringBuilder("ZoneRules[timeZone=");
            sb2.append(id2);
        } else {
            ZoneOffset[] zoneOffsetArr = this.f28529b;
            ZoneOffset zoneOffset = zoneOffsetArr[zoneOffsetArr.length - 1];
            sb2 = new StringBuilder("ZoneRules[currentStandardOffset=");
            sb2.append(zoneOffset);
        }
        sb2.append("]");
        return sb2.toString();
    }
}
