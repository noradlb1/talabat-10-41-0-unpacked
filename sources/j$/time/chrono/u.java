package j$.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZonedDateTime;
import j$.time.b;
import j$.time.h;
import j$.time.temporal.a;
import j$.time.temporal.m;
import j$.time.x;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class u extends C0098a implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final u f28321d = new u();
    private static final long serialVersionUID = -1440403870442975015L;

    private u() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean A(long j11) {
        return (3 & j11) == 0 && (j11 % 100 != 0 || j11 % 400 == 0);
    }

    public final String e() {
        return ExifInterface.TAG_RW2_ISO;
    }

    public final String j() {
        return "iso8601";
    }

    public final C0100c l(int i11) {
        return h.M(i11, 1, 1);
    }

    public final j$.time.temporal.u n(a aVar) {
        return aVar.range();
    }

    public final o o(int i11) {
        if (i11 == 0) {
            return v.BCE;
        }
        if (i11 == 1) {
            return v.CE;
        }
        throw new b("Invalid era: " + i11);
    }

    public final C0100c q(m mVar) {
        return h.D(mVar);
    }

    public final C0103f r(LocalDateTime localDateTime) {
        return LocalDateTime.C(localDateTime);
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new G((byte) 1, this);
    }

    public final C0108k x(Instant instant, x xVar) {
        return ZonedDateTime.C(instant, xVar);
    }
}
