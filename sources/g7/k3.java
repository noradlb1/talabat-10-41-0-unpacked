package g7;

import android.os.SystemClock;
import com.google.android.exoplayer2.SimpleBasePlayer;

public final /* synthetic */ class k3 {
    static {
        SimpleBasePlayer.PositionSupplier positionSupplier = SimpleBasePlayer.PositionSupplier.ZERO;
    }

    public static SimpleBasePlayer.PositionSupplier a(long j11) {
        return new j3(j11);
    }

    public static SimpleBasePlayer.PositionSupplier b(long j11, float f11) {
        return new i3(j11, SystemClock.elapsedRealtime(), f11);
    }

    public static /* synthetic */ long c(long j11) {
        return j11;
    }

    public static /* synthetic */ long d(long j11, long j12, float f11) {
        return j11 + ((long) (((float) (SystemClock.elapsedRealtime() - j12)) * f11));
    }
}
