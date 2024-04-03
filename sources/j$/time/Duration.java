package j$.time;

import com.google.android.exoplayer2.C;
import com.huawei.hms.push.constant.RemoteMessageConst;
import j$.lang.a;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.l;
import j$.time.temporal.t;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public final class Duration implements TemporalAmount, Comparable<Duration>, Serializable {
    public static final Duration ZERO = new Duration(0, 0);

    /* renamed from: c  reason: collision with root package name */
    private static final BigInteger f28245c = BigInteger.valueOf(C.NANOS_PER_SECOND);
    private static final long serialVersionUID = 3078945930695997490L;

    /* renamed from: a  reason: collision with root package name */
    private final long f28246a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28247b;

    private Duration(long j11, int i11) {
        this.f28246a = j11;
        this.f28247b = i11;
    }

    private static Duration h(long j11, int i11) {
        return (((long) i11) | j11) == 0 ? ZERO : new Duration(j11, i11);
    }

    public static Duration k(long j11) {
        long j12 = j11 / C.NANOS_PER_SECOND;
        int i11 = (int) (j11 % C.NANOS_PER_SECOND);
        if (i11 < 0) {
            i11 = (int) (((long) i11) + C.NANOS_PER_SECOND);
            j12--;
        }
        return h(j12, i11);
    }

    public static Duration of(long j11, TemporalUnit temporalUnit) {
        Duration duration = ZERO;
        duration.getClass();
        Objects.requireNonNull(temporalUnit, "unit");
        if (temporalUnit == ChronoUnit.DAYS) {
            return duration.v(a.d(j11, (long) RemoteMessageConst.DEFAULT_TTL), 0);
        }
        if (!temporalUnit.isDurationEstimated()) {
            int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i11 == 0) {
                return duration;
            }
            if (temporalUnit instanceof ChronoUnit) {
                int i12 = e.f28332a[((ChronoUnit) temporalUnit).ordinal()];
                if (i12 == 1) {
                    return duration.v(0, j11);
                }
                if (i12 == 2) {
                    return duration.B((j11 / C.NANOS_PER_SECOND) * 1000).v(0, (j11 % C.NANOS_PER_SECOND) * 1000);
                }
                if (i12 == 3) {
                    return duration.v(j11 / 1000, (j11 % 1000) * 1000000);
                }
                if (i12 != 4) {
                    j11 = a.d(temporalUnit.getDuration().f28246a, j11);
                }
                return duration.B(j11);
            }
            Duration duration2 = temporalUnit.getDuration();
            duration2.getClass();
            if (i11 == 0) {
                duration2 = duration;
            } else if (j11 != 1) {
                BigInteger bigIntegerExact = BigDecimal.valueOf(duration2.f28246a).add(BigDecimal.valueOf((long) duration2.f28247b, 9)).multiply(BigDecimal.valueOf(j11)).movePointRight(9).toBigIntegerExact();
                BigInteger[] divideAndRemainder = bigIntegerExact.divideAndRemainder(f28245c);
                if (divideAndRemainder[0].bitLength() <= 63) {
                    duration2 = ofSeconds(divideAndRemainder[0].longValue(), (long) divideAndRemainder[1].intValue());
                } else {
                    throw new ArithmeticException("Exceeds capacity of Duration: " + bigIntegerExact);
                }
            }
            return duration.B(duration2.getSeconds()).v(0, (long) duration2.getNano());
        }
        throw new t("Unit must not have an estimated duration");
    }

    public static Duration ofMinutes(long j11) {
        return h(a.d(j11, (long) 60), 0);
    }

    public static Duration ofSeconds(long j11, long j12) {
        return h(a.e(j11, a.b(j12, C.NANOS_PER_SECOND)), (int) a.f(j12, C.NANOS_PER_SECOND));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static Duration s(long j11) {
        return h(j11, 0);
    }

    private Duration v(long j11, long j12) {
        if ((j11 | j12) == 0) {
            return this;
        }
        return ofSeconds(a.e(a.e(this.f28246a, j11), j12 / C.NANOS_PER_SECOND), ((long) this.f28247b) + (j12 % C.NANOS_PER_SECOND));
    }

    private Object writeReplace() {
        return new s((byte) 1, this);
    }

    public final Duration B(long j11) {
        return v(j11, 0);
    }

    /* access modifiers changed from: package-private */
    public final void C(DataOutput dataOutput) {
        dataOutput.writeLong(this.f28246a);
        dataOutput.writeInt(this.f28247b);
    }

    public int compareTo(Duration duration) {
        int a11 = a.a(this.f28246a, duration.f28246a);
        return a11 != 0 ? a11 : this.f28247b - duration.f28247b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        return this.f28246a == duration.f28246a && this.f28247b == duration.f28247b;
    }

    public final l f(l lVar) {
        long j11 = this.f28246a;
        if (j11 != 0) {
            lVar = lVar.b(j11, ChronoUnit.SECONDS);
        }
        int i11 = this.f28247b;
        return i11 != 0 ? lVar.b((long) i11, ChronoUnit.NANOS) : lVar;
    }

    public final l g(l lVar) {
        long j11 = this.f28246a;
        if (j11 != 0) {
            lVar = lVar.d(j11, ChronoUnit.SECONDS);
        }
        int i11 = this.f28247b;
        return i11 != 0 ? lVar.d((long) i11, ChronoUnit.NANOS) : lVar;
    }

    public int getNano() {
        return this.f28247b;
    }

    public long getSeconds() {
        return this.f28246a;
    }

    public final int hashCode() {
        long j11 = this.f28246a;
        return (this.f28247b * 51) + ((int) (j11 ^ (j11 >>> 32)));
    }

    public boolean isZero() {
        return (((long) this.f28247b) | this.f28246a) == 0;
    }

    public long toMillis() {
        long j11 = (long) this.f28247b;
        long j12 = this.f28246a;
        if (j12 < 0) {
            j12++;
            j11 -= C.NANOS_PER_SECOND;
        }
        return a.e(a.d(j12, (long) 1000), j11 / 1000000);
    }

    public final String toString() {
        if (this == ZERO) {
            return "PT0S";
        }
        long j11 = this.f28246a;
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        int i12 = this.f28247b;
        long j12 = (i11 >= 0 || i12 <= 0) ? j11 : 1 + j11;
        long j13 = j12 / 3600;
        int i13 = (int) ((j12 % 3600) / 60);
        int i14 = (int) (j12 % 60);
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append("PT");
        if (j13 != 0) {
            sb2.append(j13);
            sb2.append('H');
        }
        if (i13 != 0) {
            sb2.append(i13);
            sb2.append('M');
        }
        if (i14 == 0 && i12 == 0 && sb2.length() > 2) {
            return sb2.toString();
        }
        if (j11 >= 0 || i12 <= 0 || i14 != 0) {
            sb2.append(i14);
        } else {
            sb2.append("-0");
        }
        if (i12 > 0) {
            int length = sb2.length();
            sb2.append(j11 < 0 ? 2000000000 - ((long) i12) : ((long) i12) + C.NANOS_PER_SECOND);
            while (sb2.charAt(sb2.length() - 1) == '0') {
                sb2.setLength(sb2.length() - 1);
            }
            sb2.setCharAt(length, '.');
        }
        sb2.append('S');
        return sb2.toString();
    }
}
