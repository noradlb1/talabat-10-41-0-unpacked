package androidx.compose.ui.geometry;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Immutable
@JvmInline
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\b@\u0018\u0000 92\u00020\u0001:\u00019B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u000bJ*\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b \u0010\u000bJ\u000f\u0010!\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\"\u0010\u000bJ\u0010\u0010#\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u001bH\u0007¢\u0006\u0004\b(\u0010)J\u001e\u0010*\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0002ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001e\u0010-\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0002ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010,J!\u0010/\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0019J!\u00101\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0019J\u000f\u00103\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u0019\u00107\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b8\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"Landroidx/compose/ui/geometry/Offset;", "", "packedValue", "", "constructor-impl", "(J)J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-dBAh8RU", "(JFF)J", "div", "operand", "div-tuRUvjQ", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "getDistance", "getDistance-impl", "getDistanceSquared", "getDistanceSquared-impl", "hashCode", "", "hashCode-impl", "(J)I", "isValid", "isValid-impl", "(J)Z", "minus", "minus-MK-Hz9U", "(JJ)J", "plus", "plus-MK-Hz9U", "rem", "rem-tuRUvjQ", "times", "times-tuRUvjQ", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-F1C5BW0", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Offset {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Infinite = OffsetKt.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    /* access modifiers changed from: private */
    public static final long Unspecified = OffsetKt.Offset(Float.NaN, Float.NaN);
    /* access modifiers changed from: private */
    public static final long Zero = OffsetKt.Offset(0.0f, 0.0f);
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R'\u0010\t\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R'\u0010\f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/geometry/Offset$Companion;", "", "()V", "Infinite", "Landroidx/compose/ui/geometry/Offset;", "getInfinite-F1C5BW0$annotations", "getInfinite-F1C5BW0", "()J", "J", "Unspecified", "getUnspecified-F1C5BW0$annotations", "getUnspecified-F1C5BW0", "Zero", "getZero-F1C5BW0$annotations", "getZero-F1C5BW0", "ui-geometry_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getInfinite-F1C5BW0$annotations  reason: not valid java name */
        public static /* synthetic */ void m2687getInfiniteF1C5BW0$annotations() {
        }

        @Stable
        /* renamed from: getUnspecified-F1C5BW0$annotations  reason: not valid java name */
        public static /* synthetic */ void m2688getUnspecifiedF1C5BW0$annotations() {
        }

        @Stable
        /* renamed from: getZero-F1C5BW0$annotations  reason: not valid java name */
        public static /* synthetic */ void m2689getZeroF1C5BW0$annotations() {
        }

        /* renamed from: getInfinite-F1C5BW0  reason: not valid java name */
        public final long m2690getInfiniteF1C5BW0() {
            return Offset.Infinite;
        }

        /* renamed from: getUnspecified-F1C5BW0  reason: not valid java name */
        public final long m2691getUnspecifiedF1C5BW0() {
            return Offset.Unspecified;
        }

        /* renamed from: getZero-F1C5BW0  reason: not valid java name */
        public final long m2692getZeroF1C5BW0() {
            return Offset.Zero;
        }
    }

    private /* synthetic */ Offset(long j11) {
        this.packedValue = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Offset m2665boximpl(long j11) {
        return new Offset(j11);
    }

    @Stable
    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m2666component1impl(long j11) {
        return m2676getXimpl(j11);
    }

    @Stable
    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m2667component2impl(long j11) {
        return m2677getYimpl(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m2668constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: copy-dBAh8RU  reason: not valid java name */
    public static final long m2669copydBAh8RU(long j11, float f11, float f12) {
        return OffsetKt.Offset(f11, f12);
    }

    /* renamed from: copy-dBAh8RU$default  reason: not valid java name */
    public static /* synthetic */ long m2670copydBAh8RU$default(long j11, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = m2676getXimpl(j11);
        }
        if ((i11 & 2) != 0) {
            f12 = m2677getYimpl(j11);
        }
        return m2669copydBAh8RU(j11, f11, f12);
    }

    @Stable
    /* renamed from: div-tuRUvjQ  reason: not valid java name */
    public static final long m2671divtuRUvjQ(long j11, float f11) {
        return OffsetKt.Offset(m2676getXimpl(j11) / f11, m2677getYimpl(j11) / f11);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2672equalsimpl(long j11, Object obj) {
        return (obj instanceof Offset) && j11 == ((Offset) obj).m2686unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2673equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    @Stable
    /* renamed from: getDistance-impl  reason: not valid java name */
    public static final float m2674getDistanceimpl(long j11) {
        return (float) Math.sqrt((double) ((m2676getXimpl(j11) * m2676getXimpl(j11)) + (m2677getYimpl(j11) * m2677getYimpl(j11))));
    }

    @Stable
    /* renamed from: getDistanceSquared-impl  reason: not valid java name */
    public static final float m2675getDistanceSquaredimpl(long j11) {
        return (m2676getXimpl(j11) * m2676getXimpl(j11)) + (m2677getYimpl(j11) * m2677getYimpl(j11));
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl  reason: not valid java name */
    public static final float m2676getXimpl(long j11) {
        boolean z11;
        if (j11 != Unspecified) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j11 >> 32));
        }
        throw new IllegalStateException("Offset is unspecified".toString());
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: getY-impl  reason: not valid java name */
    public static final float m2677getYimpl(long j11) {
        boolean z11;
        if (j11 != Unspecified) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j11 & 4294967295L));
        }
        throw new IllegalStateException("Offset is unspecified".toString());
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2678hashCodeimpl(long j11) {
        return a.a(j11);
    }

    @Stable
    /* renamed from: isValid-impl  reason: not valid java name */
    public static final boolean m2679isValidimpl(long j11) {
        if (!Float.isNaN(m2676getXimpl(j11)) && !Float.isNaN(m2677getYimpl(j11))) {
            return true;
        }
        throw new IllegalStateException("Offset argument contained a NaN value.".toString());
    }

    @Stable
    /* renamed from: minus-MK-Hz9U  reason: not valid java name */
    public static final long m2680minusMKHz9U(long j11, long j12) {
        return OffsetKt.Offset(m2676getXimpl(j11) - m2676getXimpl(j12), m2677getYimpl(j11) - m2677getYimpl(j12));
    }

    @Stable
    /* renamed from: plus-MK-Hz9U  reason: not valid java name */
    public static final long m2681plusMKHz9U(long j11, long j12) {
        return OffsetKt.Offset(m2676getXimpl(j11) + m2676getXimpl(j12), m2677getYimpl(j11) + m2677getYimpl(j12));
    }

    @Stable
    /* renamed from: rem-tuRUvjQ  reason: not valid java name */
    public static final long m2682remtuRUvjQ(long j11, float f11) {
        return OffsetKt.Offset(m2676getXimpl(j11) % f11, m2677getYimpl(j11) % f11);
    }

    @Stable
    /* renamed from: times-tuRUvjQ  reason: not valid java name */
    public static final long m2683timestuRUvjQ(long j11, float f11) {
        return OffsetKt.Offset(m2676getXimpl(j11) * f11, m2677getYimpl(j11) * f11);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2684toStringimpl(long j11) {
        if (!OffsetKt.m2695isSpecifiedk4lQ0M(j11)) {
            return "Offset.Unspecified";
        }
        return "Offset(" + GeometryUtilsKt.toStringAsFixed(m2676getXimpl(j11), 1) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + GeometryUtilsKt.toStringAsFixed(m2677getYimpl(j11), 1) + ')';
    }

    @Stable
    /* renamed from: unaryMinus-F1C5BW0  reason: not valid java name */
    public static final long m2685unaryMinusF1C5BW0(long j11) {
        return OffsetKt.Offset(-m2676getXimpl(j11), -m2677getYimpl(j11));
    }

    public boolean equals(Object obj) {
        return m2672equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2678hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m2684toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m2686unboximpl() {
        return this.packedValue;
    }
}
