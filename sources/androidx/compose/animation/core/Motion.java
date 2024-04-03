package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.FloatCompanionObject;
import l.a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\u0001\u0002ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/animation/core/Motion;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "value", "", "getValue-impl", "(J)F", "velocity", "getVelocity-impl", "copy", "copy-XB9eQnU", "(JFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
public final class Motion {
    private final long packedValue;

    private /* synthetic */ Motion(long j11) {
        this.packedValue = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Motion m114boximpl(long j11) {
        return new Motion(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m115constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: copy-XB9eQnU  reason: not valid java name */
    public static final long m116copyXB9eQnU(long j11, float f11, float f12) {
        return SpringSimulationKt.Motion(f11, f12);
    }

    /* renamed from: copy-XB9eQnU$default  reason: not valid java name */
    public static /* synthetic */ long m117copyXB9eQnU$default(long j11, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = m120getValueimpl(j11);
        }
        if ((i11 & 2) != 0) {
            f12 = m121getVelocityimpl(j11);
        }
        return m116copyXB9eQnU(j11, f11, f12);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m118equalsimpl(long j11, Object obj) {
        return (obj instanceof Motion) && j11 == ((Motion) obj).m124unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m119equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    /* renamed from: getValue-impl  reason: not valid java name */
    public static final float m120getValueimpl(long j11) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j11 >> 32));
    }

    /* renamed from: getVelocity-impl  reason: not valid java name */
    public static final float m121getVelocityimpl(long j11) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j11 & 4294967295L));
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m122hashCodeimpl(long j11) {
        return a.a(j11);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m123toStringimpl(long j11) {
        return "Motion(packedValue=" + j11 + ')';
    }

    public boolean equals(Object obj) {
        return m118equalsimpl(this.packedValue, obj);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return m122hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m123toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m124unboximpl() {
        return this.packedValue;
    }
}
