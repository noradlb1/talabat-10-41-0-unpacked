package androidx.compose.ui.util;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\b\u001a\u0019\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0006H\b\u001a\u0011\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\b\u001a\u0011\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\b\u001a\u0011\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0001H\b\u001a\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0001H\b¨\u0006\f"}, d2 = {"packFloats", "", "val1", "", "val2", "packInts", "", "unpackFloat1", "value", "unpackFloat2", "unpackInt1", "unpackInt2", "ui-util_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class InlineClassHelperKt {
    public static final long packFloats(float f11, float f12) {
        long floatToIntBits = (long) Float.floatToIntBits(f11);
        return (((long) Float.floatToIntBits(f12)) & 4294967295L) | (floatToIntBits << 32);
    }

    public static final long packInts(int i11, int i12) {
        return (((long) i12) & 4294967295L) | (((long) i11) << 32);
    }

    public static final float unpackFloat1(long j11) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j11 >> 32));
    }

    public static final float unpackFloat2(long j11) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j11 & 4294967295L));
    }

    public static final int unpackInt1(long j11) {
        return (int) (j11 >> 32);
    }

    public static final int unpackInt2(long j11) {
        return (int) (j11 & 4294967295L);
    }
}
