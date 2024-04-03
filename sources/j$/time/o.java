package j$.time;

import com.google.common.base.Ascii;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import j$.time.chrono.C0098a;
import j$.time.chrono.C0099b;
import j$.time.format.t;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import j$.time.temporal.u;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class o implements m, n, Comparable, Serializable {
    private static final long serialVersionUID = -939150713474957432L;

    /* renamed from: a  reason: collision with root package name */
    private final int f28427a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28428b;

    static {
        t tVar = new t();
        tVar.f("--");
        tVar.m(a.MONTH_OF_YEAR, 2);
        tVar.e(SignatureVisitor.SUPER);
        tVar.m(a.DAY_OF_MONTH, 2);
        tVar.v(Locale.getDefault());
    }

    private o(int i11, int i12) {
        this.f28427a = i11;
        this.f28428b = i12;
    }

    static o B(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        byte readByte2 = dataInput.readByte();
        m E = m.E(readByte);
        Objects.requireNonNull(E, "month");
        a.DAY_OF_MONTH.v((long) readByte2);
        if (readByte2 <= E.D()) {
            return new o(E.getValue(), readByte2);
        }
        String name2 = E.name();
        throw new b("Illegal value for DayOfMonth field, value " + readByte2 + " is not valid for month " + name2);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s(Ascii.CR, this);
    }

    /* access modifiers changed from: package-private */
    public final void C(DataOutput dataOutput) {
        dataOutput.writeByte(this.f28427a);
        dataOutput.writeByte(this.f28428b);
    }

    public final boolean c(q qVar) {
        return qVar instanceof a ? qVar == a.MONTH_OF_YEAR || qVar == a.DAY_OF_MONTH : qVar != null && qVar.f(this);
    }

    public final int compareTo(Object obj) {
        o oVar = (o) obj;
        int i11 = this.f28427a - oVar.f28427a;
        return i11 == 0 ? this.f28428b - oVar.f28428b : i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f28427a == oVar.f28427a && this.f28428b == oVar.f28428b;
    }

    public final int f(q qVar) {
        return h(qVar).a(s(qVar), qVar);
    }

    public final u h(q qVar) {
        if (qVar == a.MONTH_OF_YEAR) {
            return qVar.range();
        }
        if (qVar != a.DAY_OF_MONTH) {
            return p.d(this, qVar);
        }
        int i11 = this.f28427a;
        m E = m.E(i11);
        E.getClass();
        int i12 = l.f28423a[E.ordinal()];
        return u.l((long) (i12 != 1 ? (i12 == 2 || i12 == 3 || i12 == 4 || i12 == 5) ? 30 : 31 : 28), (long) m.E(i11).D());
    }

    public final int hashCode() {
        return (this.f28427a << 6) + this.f28428b;
    }

    public final l k(l lVar) {
        if (((C0098a) C0099b.r(lVar)).equals(j$.time.chrono.u.f28321d)) {
            l a11 = lVar.a((long) this.f28427a, a.MONTH_OF_YEAR);
            a aVar = a.DAY_OF_MONTH;
            return a11.a(Math.min(a11.h(aVar).d(), (long) this.f28428b), aVar);
        }
        throw new b("Adjustment only supported on ISO date-time");
    }

    public final long s(q qVar) {
        int i11;
        if (!(qVar instanceof a)) {
            return qVar.h(this);
        }
        int i12 = n.f28426a[((a) qVar).ordinal()];
        if (i12 == 1) {
            i11 = this.f28428b;
        } else if (i12 == 2) {
            i11 = this.f28427a;
        } else {
            throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
        return (long) i11;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(10);
        sb2.append("--");
        int i11 = this.f28427a;
        sb2.append(i11 < 10 ? "0" : "");
        sb2.append(i11);
        int i12 = this.f28428b;
        sb2.append(i12 < 10 ? "-0" : SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
        sb2.append(i12);
        return sb2.toString();
    }

    public final Object v(s sVar) {
        return sVar == p.e() ? j$.time.chrono.u.f28321d : p.c(this, sVar);
    }
}
