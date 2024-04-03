package j$.time.chrono;

import j$.time.temporal.a;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.u;

public enum t implements o {
    ;

    private t() {
    }

    public final int getValue() {
        return 1;
    }

    public final u h(q qVar) {
        return qVar == a.ERA ? u.j(1, 1) : p.d(this, qVar);
    }
}
