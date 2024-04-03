package j$.time.temporal;

import j$.time.b;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class u implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* renamed from: a  reason: collision with root package name */
    private final long f28475a;

    /* renamed from: b  reason: collision with root package name */
    private final long f28476b;

    /* renamed from: c  reason: collision with root package name */
    private final long f28477c;

    /* renamed from: d  reason: collision with root package name */
    private final long f28478d;

    private u(long j11, long j12, long j13, long j14) {
        this.f28475a = j11;
        this.f28476b = j12;
        this.f28477c = j13;
        this.f28478d = j14;
    }

    private String c(long j11, q qVar) {
        if (qVar != null) {
            return "Invalid value for " + qVar + " (valid values " + this + "): " + j11;
        }
        return "Invalid value (valid values " + this + "): " + j11;
    }

    public static u j(long j11, long j12) {
        if (j11 <= j12) {
            return new u(j11, j11, j12, j12);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static u k(long j11, long j12, long j13) {
        if (j11 > 1) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        } else if (j12 > j13) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        } else if (1 <= j13) {
            return new u(j11, 1, j12, j13);
        } else {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
    }

    public static u l(long j11, long j12) {
        return k(1, j11, j12);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        long j11 = this.f28475a;
        long j12 = this.f28476b;
        if (j11 <= j12) {
            long j13 = this.f28477c;
            long j14 = this.f28478d;
            if (j13 > j14) {
                throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
            } else if (j12 > j14) {
                throw new InvalidObjectException("Minimum value must be less than maximum value");
            }
        } else {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
    }

    public final int a(long j11, q qVar) {
        if (h() && i(j11)) {
            return (int) j11;
        }
        throw new b(c(j11, qVar));
    }

    public final void b(long j11, q qVar) {
        if (!i(j11)) {
            throw new b(c(j11, qVar));
        }
    }

    public final long d() {
        return this.f28478d;
    }

    public final long e() {
        return this.f28475a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f28475a == uVar.f28475a && this.f28476b == uVar.f28476b && this.f28477c == uVar.f28477c && this.f28478d == uVar.f28478d;
    }

    public final long f() {
        return this.f28477c;
    }

    public final boolean g() {
        return this.f28475a == this.f28476b && this.f28477c == this.f28478d;
    }

    public final boolean h() {
        return this.f28475a >= -2147483648L && this.f28478d <= 2147483647L;
    }

    public final int hashCode() {
        long j11 = this.f28476b;
        long j12 = this.f28475a + (j11 << 16) + (j11 >> 48);
        long j13 = this.f28477c;
        long j14 = j12 + (j13 << 32) + (j13 >> 32);
        long j15 = this.f28478d;
        long j16 = j14 + (j15 << 48) + (j15 >> 16);
        return (int) ((j16 >>> 32) ^ j16);
    }

    public final boolean i(long j11) {
        return j11 >= this.f28475a && j11 <= this.f28478d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        long j11 = this.f28475a;
        sb2.append(j11);
        long j12 = this.f28476b;
        if (j11 != j12) {
            sb2.append('/');
            sb2.append(j12);
        }
        sb2.append(" - ");
        long j13 = this.f28477c;
        sb2.append(j13);
        long j14 = this.f28478d;
        if (j13 != j14) {
            sb2.append('/');
            sb2.append(j14);
        }
        return sb2.toString();
    }
}
