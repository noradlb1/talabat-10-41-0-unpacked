package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import l.a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerId;", "", "value", "", "constructor-impl", "(J)J", "getValue", "()J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class PointerId {
    private final long value;

    private /* synthetic */ PointerId(long j11) {
        this.value = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ PointerId m4288boximpl(long j11) {
        return new PointerId(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m4289constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4290equalsimpl(long j11, Object obj) {
        return (obj instanceof PointerId) && j11 == ((PointerId) obj).m4294unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4291equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4292hashCodeimpl(long j11) {
        return a.a(j11);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4293toStringimpl(long j11) {
        return "PointerId(value=" + j11 + ')';
    }

    public boolean equals(Object obj) {
        return m4290equalsimpl(this.value, obj);
    }

    public final long getValue() {
        return this.value;
    }

    public int hashCode() {
        return m4292hashCodeimpl(this.value);
    }

    public String toString() {
        return m4293toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m4294unboximpl() {
        return this.value;
    }
}
