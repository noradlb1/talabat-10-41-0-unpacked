package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.b;
import j$.time.h;
import j$.time.temporal.a;
import j$.time.temporal.m;
import j$.time.temporal.u;
import j$.time.x;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;

public final class I extends C0098a implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final I f28281d = new I();
    private static final long serialVersionUID = 2775954514031616474L;

    static {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap.put("en", new String[]{"BB", "BE"});
        hashMap.put("th", new String[]{"BB", "BE"});
        hashMap2.put("en", new String[]{"B.B.", "B.E."});
        hashMap2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        hashMap3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        hashMap3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    private I() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean A(long j11) {
        return u.f28321d.A(j11 - 543);
    }

    public final String e() {
        return "ThaiBuddhist";
    }

    public final String j() {
        return "buddhist";
    }

    public final C0100c l(int i11) {
        return new K(h.M(i11 - 543, 1, 1));
    }

    public final u n(a aVar) {
        int i11 = H.f28280a[aVar.ordinal()];
        if (i11 == 1) {
            u range = a.PROLEPTIC_MONTH.range();
            return u.j(range.e() + 6516, range.d() + 6516);
        } else if (i11 == 2) {
            u range2 = a.YEAR.range();
            return u.l((-(range2.e() + 543)) + 1, range2.d() + 543);
        } else if (i11 != 3) {
            return aVar.range();
        } else {
            u range3 = a.YEAR.range();
            return u.j(range3.e() + 543, range3.d() + 543);
        }
    }

    public final o o(int i11) {
        if (i11 == 0) {
            return L.BEFORE_BE;
        }
        if (i11 == 1) {
            return L.BE;
        }
        throw new b("Invalid era: " + i11);
    }

    public final C0100c q(m mVar) {
        return mVar instanceof K ? (K) mVar : new K(h.D(mVar));
    }

    public final C0103f r(LocalDateTime localDateTime) {
        return super.r(localDateTime);
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new G((byte) 1, this);
    }

    public final C0108k x(Instant instant, x xVar) {
        return m.E(this, instant, xVar);
    }
}
