package j$.time.chrono;

import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.u;

public enum v implements o {
    BCE,
    CE;

    public final int getValue() {
        return ordinal();
    }

    public final u h(q qVar) {
        return p.d(this, qVar);
    }
}
