package j$.time.chrono;

import j$.time.ZoneOffset;
import j$.time.k;
import j$.time.temporal.l;
import j$.time.temporal.n;

/* renamed from: j$.time.chrono.f  reason: case insensitive filesystem */
public interface C0103f extends l, n, Comparable {
    n getChronology();

    C0108k i(ZoneOffset zoneOffset);

    C0100c toLocalDate();

    k toLocalTime();

    int w(C0103f fVar);
}
