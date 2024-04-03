package androidx.compose.ui.geometry;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Immutable
@JvmInline
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\b@\u0018\u0000 12\u00020\u0001:\u00011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\tH\n¢\u0006\u0004\b\u0011\u0010\fJ\u0010\u0010\u0012\u001a\u00020\tH\n¢\u0006\u0004\b\u0013\u0010\fJ*\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001e\u0010$\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0002ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u001e\u0010'\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0002ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010&J!\u0010)\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010\u001aJ\u000f\u0010+\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u0019\u0010/\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"Landroidx/compose/ui/geometry/CornerRadius;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "", "getX$annotations", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-OHQCggk", "(JFF)J", "div", "operand", "div-Bz7bX_o", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-vF7b-mM", "(JJ)J", "plus", "plus-vF7b-mM", "times", "times-Bz7bX_o", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-kKHJgLs", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CornerRadius {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Zero = CornerRadiusKt.CornerRadius$default(0.0f, 0.0f, 2, (Object) null);
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\t"}, d2 = {"Landroidx/compose/ui/geometry/CornerRadius$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/geometry/CornerRadius;", "getZero-kKHJgLs$annotations", "getZero-kKHJgLs", "()J", "J", "ui-geometry_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getZero-kKHJgLs$annotations  reason: not valid java name */
        public static /* synthetic */ void m2660getZerokKHJgLs$annotations() {
        }

        /* renamed from: getZero-kKHJgLs  reason: not valid java name */
        public final long m2661getZerokKHJgLs() {
            return CornerRadius.Zero;
        }
    }

    private /* synthetic */ CornerRadius(long j11) {
        this.packedValue = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ CornerRadius m2642boximpl(long j11) {
        return new CornerRadius(j11);
    }

    @Stable
    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m2643component1impl(long j11) {
        return m2651getXimpl(j11);
    }

    @Stable
    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m2644component2impl(long j11) {
        return m2652getYimpl(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m2645constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: copy-OHQCggk  reason: not valid java name */
    public static final long m2646copyOHQCggk(long j11, float f11, float f12) {
        return CornerRadiusKt.CornerRadius(f11, f12);
    }

    /* renamed from: copy-OHQCggk$default  reason: not valid java name */
    public static /* synthetic */ long m2647copyOHQCggk$default(long j11, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = m2651getXimpl(j11);
        }
        if ((i11 & 2) != 0) {
            f12 = m2652getYimpl(j11);
        }
        return m2646copyOHQCggk(j11, f11, f12);
    }

    @Stable
    /* renamed from: div-Bz7bX_o  reason: not valid java name */
    public static final long m2648divBz7bX_o(long j11, float f11) {
        return CornerRadiusKt.CornerRadius(m2651getXimpl(j11) / f11, m2652getYimpl(j11) / f11);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2649equalsimpl(long j11, Object obj) {
        return (obj instanceof CornerRadius) && j11 == ((CornerRadius) obj).m2659unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2650equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl  reason: not valid java name */
    public static final float m2651getXimpl(long j11) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j11 >> 32));
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: getY-impl  reason: not valid java name */
    public static final float m2652getYimpl(long j11) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j11 & 4294967295L));
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2653hashCodeimpl(long j11) {
        return a.a(j11);
    }

    @Stable
    /* renamed from: minus-vF7b-mM  reason: not valid java name */
    public static final long m2654minusvF7bmM(long j11, long j12) {
        return CornerRadiusKt.CornerRadius(m2651getXimpl(j11) - m2651getXimpl(j12), m2652getYimpl(j11) - m2652getYimpl(j12));
    }

    @Stable
    /* renamed from: plus-vF7b-mM  reason: not valid java name */
    public static final long m2655plusvF7bmM(long j11, long j12) {
        return CornerRadiusKt.CornerRadius(m2651getXimpl(j11) + m2651getXimpl(j12), m2652getYimpl(j11) + m2652getYimpl(j12));
    }

    @Stable
    /* renamed from: times-Bz7bX_o  reason: not valid java name */
    public static final long m2656timesBz7bX_o(long j11, float f11) {
        return CornerRadiusKt.CornerRadius(m2651getXimpl(j11) * f11, m2652getYimpl(j11) * f11);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2657toStringimpl(long j11) {
        boolean z11;
        if (m2651getXimpl(j11) == m2652getYimpl(j11)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return "CornerRadius.circular(" + GeometryUtilsKt.toStringAsFixed(m2651getXimpl(j11), 1) + ')';
        }
        return "CornerRadius.elliptical(" + GeometryUtilsKt.toStringAsFixed(m2651getXimpl(j11), 1) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + GeometryUtilsKt.toStringAsFixed(m2652getYimpl(j11), 1) + ')';
    }

    @Stable
    /* renamed from: unaryMinus-kKHJgLs  reason: not valid java name */
    public static final long m2658unaryMinuskKHJgLs(long j11) {
        return CornerRadiusKt.CornerRadius(-m2651getXimpl(j11), -m2652getYimpl(j11));
    }

    public boolean equals(Object obj) {
        return m2649equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2653hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m2657toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m2659unboximpl() {
        return this.packedValue;
    }
}
