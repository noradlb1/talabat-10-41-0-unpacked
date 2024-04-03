package j$.time.format;

import com.google.android.exoplayer2.C;
import j$.time.b;
import j$.time.temporal.q;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import okhttp3.internal.connection.RealConnection;

class k implements g {

    /* renamed from: f  reason: collision with root package name */
    static final long[] f28352f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, C.NANOS_PER_SECOND, RealConnection.IDLE_CONNECTION_HEALTHY_NS};

    /* renamed from: a  reason: collision with root package name */
    final q f28353a;

    /* renamed from: b  reason: collision with root package name */
    final int f28354b;

    /* renamed from: c  reason: collision with root package name */
    final int f28355c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final A f28356d;

    /* renamed from: e  reason: collision with root package name */
    final int f28357e;

    k(q qVar, int i11, int i12, A a11) {
        this.f28353a = qVar;
        this.f28354b = i11;
        this.f28355c = i12;
        this.f28356d = a11;
        this.f28357e = 0;
    }

    protected k(q qVar, int i11, int i12, A a11, int i13) {
        this.f28353a = qVar;
        this.f28354b = i11;
        this.f28355c = i12;
        this.f28356d = a11;
        this.f28357e = i13;
    }

    /* access modifiers changed from: package-private */
    public long b(v vVar, long j11) {
        return j11;
    }

    /* access modifiers changed from: package-private */
    public k c() {
        return this.f28357e == -1 ? this : new k(this.f28353a, this.f28354b, this.f28355c, this.f28356d, -1);
    }

    /* access modifiers changed from: package-private */
    public k d(int i11) {
        return new k(this.f28353a, this.f28354b, this.f28355c, this.f28356d, this.f28357e + i11);
    }

    public boolean f(v vVar, StringBuilder sb2) {
        q qVar = this.f28353a;
        Long e11 = vVar.e(qVar);
        if (e11 == null) {
            return false;
        }
        long b11 = b(vVar, e11.longValue());
        y b12 = vVar.b();
        String l11 = b11 == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(b11));
        int length = l11.length();
        int i11 = this.f28355c;
        if (length <= i11) {
            b12.getClass();
            int i12 = (b11 > 0 ? 1 : (b11 == 0 ? 0 : -1));
            int i13 = this.f28354b;
            A a11 = this.f28356d;
            if (i12 >= 0) {
                if ((r12 = d.f28345a[a11.ordinal()]) != 1) {
                }
                sb2.append(SignatureVisitor.EXTENDS);
            } else {
                int i14 = d.f28345a[a11.ordinal()];
                if (i14 == 1 || i14 == 2 || i14 == 3) {
                    sb2.append(SignatureVisitor.SUPER);
                } else if (i14 == 4) {
                    throw new b("Field " + qVar + " cannot be printed as the value " + b11 + " cannot be negative according to the SignStyle");
                }
            }
            for (int i15 = 0; i15 < i13 - l11.length(); i15++) {
                sb2.append('0');
            }
            sb2.append(l11);
            return true;
        }
        throw new b("Field " + qVar + " cannot be printed as the value " + b11 + " exceeds the maximum print width of " + i11);
    }

    public String toString() {
        int i11 = this.f28355c;
        A a11 = this.f28356d;
        q qVar = this.f28353a;
        int i12 = this.f28354b;
        if (i12 == 1 && i11 == 19 && a11 == A.NORMAL) {
            return "Value(" + qVar + ")";
        } else if (i12 == i11 && a11 == A.NOT_NEGATIVE) {
            return "Value(" + qVar + "," + i12 + ")";
        } else {
            return "Value(" + qVar + "," + i12 + "," + i11 + "," + a11 + ")";
        }
    }
}
