package j$.time.chrono;

import j$.time.ZoneOffset;
import j$.time.k;
import j$.time.temporal.l;
import j$.time.x;

/* renamed from: j$.time.chrono.k  reason: case insensitive filesystem */
public interface C0108k extends l, Comparable {
    n getChronology();

    ZoneOffset getOffset();

    x getZone();

    C0108k p(x xVar);

    long toEpochSecond();

    C0100c toLocalDate();

    C0103f toLocalDateTime();

    k toLocalTime();
}
