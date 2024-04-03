package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.FloatCompanionObject;
import l.a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0001\u0002ø\u0001\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/node/DistanceAndInLayer;", "", "packedValue", "", "constructor-impl", "(J)J", "distance", "", "getDistance-impl", "(J)F", "isInLayer", "", "isInLayer-impl", "(J)Z", "getPackedValue", "()J", "compareTo", "", "other", "compareTo-S_HNhKs", "(JJ)I", "equals", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
final class DistanceAndInLayer {
    private final long packedValue;

    private /* synthetic */ DistanceAndInLayer(long j11) {
        this.packedValue = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DistanceAndInLayer m4595boximpl(long j11) {
        return new DistanceAndInLayer(j11);
    }

    /* renamed from: compareTo-S_HNhKs  reason: not valid java name */
    public static final int m4596compareToS_HNhKs(long j11, long j12) {
        boolean r02 = m4602isInLayerimpl(j11);
        if (r02 == m4602isInLayerimpl(j12)) {
            return (int) Math.signum(m4600getDistanceimpl(j11) - m4600getDistanceimpl(j12));
        }
        if (r02) {
            return -1;
        }
        return 1;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m4597constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4598equalsimpl(long j11, Object obj) {
        return (obj instanceof DistanceAndInLayer) && j11 == ((DistanceAndInLayer) obj).m4604unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4599equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    /* renamed from: getDistance-impl  reason: not valid java name */
    public static final float m4600getDistanceimpl(long j11) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j11 >> 32));
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4601hashCodeimpl(long j11) {
        return a.a(j11);
    }

    /* renamed from: isInLayer-impl  reason: not valid java name */
    public static final boolean m4602isInLayerimpl(long j11) {
        return ((int) (j11 & 4294967295L)) != 0;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4603toStringimpl(long j11) {
        return "DistanceAndInLayer(packedValue=" + j11 + ')';
    }

    public boolean equals(Object obj) {
        return m4598equalsimpl(this.packedValue, obj);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return m4601hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m4603toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m4604unboximpl() {
        return this.packedValue;
    }
}
