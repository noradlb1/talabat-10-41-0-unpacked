package j$.time.chrono;

import j$.time.k;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.l;
import j$.time.temporal.n;
import j$.time.temporal.q;

/* renamed from: j$.time.chrono.c  reason: case insensitive filesystem */
public interface C0100c extends l, n, Comparable {
    C0100c a(long j11, q qVar);

    C0100c b(long j11, TemporalUnit temporalUnit);

    boolean c(q qVar);

    C0100c d(long j11, ChronoUnit chronoUnit);

    n getChronology();

    int hashCode();

    boolean m();

    long t();

    String toString();

    C0103f u(k kVar);

    int y();

    int z(C0100c cVar);
}
