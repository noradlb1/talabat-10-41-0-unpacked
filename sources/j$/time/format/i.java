package j$.time.format;

import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.temporal.a;
import j$.time.temporal.m;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

final class i implements g {
    i() {
    }

    public final boolean f(v vVar, StringBuilder sb2) {
        StringBuilder sb3 = sb2;
        Long e11 = vVar.e(a.INSTANT_SECONDS);
        m d11 = vVar.d();
        a aVar = a.NANO_OF_SECOND;
        Long valueOf = d11.c(aVar) ? Long.valueOf(vVar.d().s(aVar)) : null;
        int i11 = 0;
        if (e11 == null) {
            return false;
        }
        long longValue = e11.longValue();
        int s11 = aVar.s(valueOf != null ? valueOf.longValue() : 0);
        if (longValue >= -62167219200L) {
            long j11 = (longValue - 315569520000L) + 62167219200L;
            long b11 = j$.lang.a.b(j11, 315569520000L) + 1;
            LocalDateTime K = LocalDateTime.K(j$.lang.a.f(j11, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
            if (b11 > 0) {
                sb3.append(SignatureVisitor.EXTENDS);
                sb3.append(b11);
            }
            sb3.append(K);
            if (K.E() == 0) {
                sb3.append(":00");
            }
        } else {
            long j12 = longValue + 62167219200L;
            long j13 = j12 / 315569520000L;
            long j14 = j12 % 315569520000L;
            LocalDateTime K2 = LocalDateTime.K(j14 - 62167219200L, 0, ZoneOffset.UTC);
            int length = sb2.length();
            sb3.append(K2);
            if (K2.E() == 0) {
                sb3.append(":00");
            }
            if (j13 < 0) {
                if (K2.F() == -10000) {
                    sb3.replace(length, length + 2, Long.toString(j13 - 1));
                } else if (j14 == 0) {
                    sb3.insert(length, j13);
                } else {
                    sb3.insert(length + 1, Math.abs(j13));
                }
            }
        }
        if (s11 > 0) {
            sb3.append('.');
            int i12 = 100000000;
            while (true) {
                if (s11 <= 0 && i11 % 3 == 0 && i11 >= -2) {
                    break;
                }
                int i13 = s11 / i12;
                sb3.append((char) (i13 + 48));
                s11 -= i13 * i12;
                i12 /= 10;
                i11++;
            }
        }
        sb3.append('Z');
        return true;
    }

    public final String toString() {
        return "Instant()";
    }
}
