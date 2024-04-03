package androidx.compose.ui.graphics;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\u0005\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\b"}, d2 = {"max", "Landroidx/compose/ui/graphics/Float16;", "x", "y", "max-AoSsdG0", "(SS)S", "min", "min-AoSsdG0", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class Float16Kt {
    /* renamed from: max-AoSsdG0  reason: not valid java name */
    public static final short m3051maxAoSsdG0(short s11, short s12) {
        if (Float16.m3024isNaNimpl(s11) || Float16.m3024isNaNimpl(s12)) {
            return Float16.Companion.m3046getNaNslo4al4();
        }
        if (Float16.m3011compareTo41bOqos(s11, s12) >= 0) {
            return s11;
        }
        return s12;
    }

    /* renamed from: min-AoSsdG0  reason: not valid java name */
    public static final short m3052minAoSsdG0(short s11, short s12) {
        if (Float16.m3024isNaNimpl(s11) || Float16.m3024isNaNimpl(s12)) {
            return Float16.Companion.m3046getNaNslo4al4();
        }
        if (Float16.m3011compareTo41bOqos(s11, s12) <= 0) {
            return s11;
        }
        return s12;
    }
}
