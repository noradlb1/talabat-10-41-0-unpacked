package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import l.a;

@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "", "packedValue", "", "constructor-impl", "(J)J", "currentLineSpan", "", "getCurrentLineSpan$annotations", "()V", "getCurrentLineSpan-impl", "(J)I", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class GridItemSpan {
    private final long packedValue;

    private /* synthetic */ GridItemSpan(long j11) {
        this.packedValue = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ GridItemSpan m656boximpl(long j11) {
        return new GridItemSpan(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m657constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m658equalsimpl(long j11, Object obj) {
        return (obj instanceof GridItemSpan) && j11 == ((GridItemSpan) obj).m663unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m659equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    @ExperimentalFoundationApi
    public static /* synthetic */ void getCurrentLineSpan$annotations() {
    }

    /* renamed from: getCurrentLineSpan-impl  reason: not valid java name */
    public static final int m660getCurrentLineSpanimpl(long j11) {
        return (int) j11;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m661hashCodeimpl(long j11) {
        return a.a(j11);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m662toStringimpl(long j11) {
        return "GridItemSpan(packedValue=" + j11 + ')';
    }

    public boolean equals(Object obj) {
        return m658equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m661hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m662toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m663unboximpl() {
        return this.packedValue;
    }
}
