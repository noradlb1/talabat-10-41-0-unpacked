package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Immutable
@JvmInline
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b@\u0018\u0000 32\u00020\u0001:\u00013B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u0010\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\fJ*\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\"\u0010\fJ\u001e\u0010#\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\nø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u001e\u0010&\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\nø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010%J!\u0010(\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J!\u0010+\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010\u001bJ\u000f\u0010-\u001a\u00020.H\u0017¢\u0006\u0004\b/\u00100J\u0019\u00101\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/compose/ui/unit/IntOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "", "getX$annotations", "getX-impl", "(J)I", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-iSbpLlY", "(JII)J", "div", "operand", "", "div-Bjo55l4", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "minus", "minus-qkQi6aY", "(JJ)J", "plus", "plus-qkQi6aY", "rem", "rem-Bjo55l4", "(JI)J", "times", "times-Bjo55l4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-nOcc-ac", "Companion", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IntOffset {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Zero = IntOffsetKt.IntOffset(0, 0);
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/ui/unit/IntOffset$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/IntOffset;", "getZero-nOcc-ac", "()J", "J", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-nOcc-ac  reason: not valid java name */
        public final long m5606getZeronOccac() {
            return IntOffset.Zero;
        }
    }

    private /* synthetic */ IntOffset(long j11) {
        this.packedValue = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ IntOffset m5587boximpl(long j11) {
        return new IntOffset(j11);
    }

    @Stable
    /* renamed from: component1-impl  reason: not valid java name */
    public static final int m5588component1impl(long j11) {
        return m5596getXimpl(j11);
    }

    @Stable
    /* renamed from: component2-impl  reason: not valid java name */
    public static final int m5589component2impl(long j11) {
        return m5597getYimpl(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m5590constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: copy-iSbpLlY  reason: not valid java name */
    public static final long m5591copyiSbpLlY(long j11, int i11, int i12) {
        return IntOffsetKt.IntOffset(i11, i12);
    }

    /* renamed from: copy-iSbpLlY$default  reason: not valid java name */
    public static /* synthetic */ long m5592copyiSbpLlY$default(long j11, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = m5596getXimpl(j11);
        }
        if ((i13 & 2) != 0) {
            i12 = m5597getYimpl(j11);
        }
        return m5591copyiSbpLlY(j11, i11, i12);
    }

    @Stable
    /* renamed from: div-Bjo55l4  reason: not valid java name */
    public static final long m5593divBjo55l4(long j11, float f11) {
        return IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt(((float) m5596getXimpl(j11)) / f11), MathKt__MathJVMKt.roundToInt(((float) m5597getYimpl(j11)) / f11));
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5594equalsimpl(long j11, Object obj) {
        return (obj instanceof IntOffset) && j11 == ((IntOffset) obj).m5605unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5595equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl  reason: not valid java name */
    public static final int m5596getXimpl(long j11) {
        return (int) (j11 >> 32);
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: getY-impl  reason: not valid java name */
    public static final int m5597getYimpl(long j11) {
        return (int) (j11 & 4294967295L);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5598hashCodeimpl(long j11) {
        return a.a(j11);
    }

    @Stable
    /* renamed from: minus-qkQi6aY  reason: not valid java name */
    public static final long m5599minusqkQi6aY(long j11, long j12) {
        return IntOffsetKt.IntOffset(m5596getXimpl(j11) - m5596getXimpl(j12), m5597getYimpl(j11) - m5597getYimpl(j12));
    }

    @Stable
    /* renamed from: plus-qkQi6aY  reason: not valid java name */
    public static final long m5600plusqkQi6aY(long j11, long j12) {
        return IntOffsetKt.IntOffset(m5596getXimpl(j11) + m5596getXimpl(j12), m5597getYimpl(j11) + m5597getYimpl(j12));
    }

    @Stable
    /* renamed from: rem-Bjo55l4  reason: not valid java name */
    public static final long m5601remBjo55l4(long j11, int i11) {
        return IntOffsetKt.IntOffset(m5596getXimpl(j11) % i11, m5597getYimpl(j11) % i11);
    }

    @Stable
    /* renamed from: times-Bjo55l4  reason: not valid java name */
    public static final long m5602timesBjo55l4(long j11, float f11) {
        return IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt(((float) m5596getXimpl(j11)) * f11), MathKt__MathJVMKt.roundToInt(((float) m5597getYimpl(j11)) * f11));
    }

    @NotNull
    @Stable
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5603toStringimpl(long j11) {
        return '(' + m5596getXimpl(j11) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + m5597getYimpl(j11) + ')';
    }

    @Stable
    /* renamed from: unaryMinus-nOcc-ac  reason: not valid java name */
    public static final long m5604unaryMinusnOccac(long j11) {
        return IntOffsetKt.IntOffset(-m5596getXimpl(j11), -m5597getYimpl(j11));
    }

    public boolean equals(Object obj) {
        return m5594equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5598hashCodeimpl(this.packedValue);
    }

    @NotNull
    @Stable
    public String toString() {
        return m5603toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m5605unboximpl() {
        return this.packedValue;
    }
}
