package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¨\u0006\u0007"}, d2 = {"lowestBitOf", "", "bits", "", "binarySearch", "", "value", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SnapshotIdSetKt {
    public static final int binarySearch(@NotNull int[] iArr, int i11) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length - 1;
        int i12 = 0;
        while (i12 <= length) {
            int i13 = (i12 + length) >>> 1;
            int i14 = iArr[i13];
            if (i11 > i14) {
                i12 = i13 + 1;
            } else if (i11 >= i14) {
                return i13;
            } else {
                length = i13 - 1;
            }
        }
        return -(i12 + 1);
    }

    /* access modifiers changed from: private */
    public static final int lowestBitOf(long j11) {
        int i11;
        if ((4294967295L & j11) == 0) {
            i11 = 32;
            j11 >>= 32;
        } else {
            i11 = 0;
        }
        if ((WebSocketProtocol.PAYLOAD_SHORT_MAX & j11) == 0) {
            i11 += 16;
            j11 >>= 16;
        }
        if ((255 & j11) == 0) {
            i11 += 8;
            j11 >>= 8;
        }
        if ((15 & j11) == 0) {
            i11 += 4;
            j11 >>= 4;
        }
        if ((1 & j11) != 0) {
            return i11;
        }
        if ((2 & j11) != 0) {
            return i11 + 1;
        }
        if ((4 & j11) != 0) {
            return i11 + 2;
        }
        if ((j11 & 8) != 0) {
            return i11 + 3;
        }
        return -1;
    }
}
