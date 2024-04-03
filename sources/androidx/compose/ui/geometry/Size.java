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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 32\u00020\u0001:\u00013B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u0007H\n¢\u0006\u0004\b\u0017\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u0007H\n¢\u0006\u0004\b\u0019\u0010\u000bJ*\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0007H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\"H\u0007¢\u0006\u0004\b+\u0010,J!\u0010-\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0007H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010 J\u000f\u0010/\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/compose/ui/geometry/Size;", "", "packedValue", "", "constructor-impl", "(J)J", "height", "", "getHeight$annotations", "()V", "getHeight-impl", "(J)F", "maxDimension", "getMaxDimension$annotations", "getMaxDimension-impl", "minDimension", "getMinDimension$annotations", "getMinDimension-impl", "getPackedValue$annotations", "width", "getWidth$annotations", "getWidth-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-xjbvk4A", "(JFF)J", "div", "operand", "div-7Ah8Wj8", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "isEmpty", "isEmpty-impl", "(J)Z", "times", "times-7Ah8Wj8", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Size {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Unspecified = SizeKt.Size(Float.NaN, Float.NaN);
    /* access modifiers changed from: private */
    public static final long Zero = SizeKt.Size(0.0f, 0.0f);
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R'\u0010\t\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/geometry/Size$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/geometry/Size;", "getUnspecified-NH-jbRc$annotations", "getUnspecified-NH-jbRc", "()J", "J", "Zero", "getZero-NH-jbRc$annotations", "getZero-NH-jbRc", "ui-geometry_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getUnspecified-NH-jbRc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2751getUnspecifiedNHjbRc$annotations() {
        }

        @Stable
        /* renamed from: getZero-NH-jbRc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2752getZeroNHjbRc$annotations() {
        }

        /* renamed from: getUnspecified-NH-jbRc  reason: not valid java name */
        public final long m2753getUnspecifiedNHjbRc() {
            return Size.Unspecified;
        }

        /* renamed from: getZero-NH-jbRc  reason: not valid java name */
        public final long m2754getZeroNHjbRc() {
            return Size.Zero;
        }
    }

    private /* synthetic */ Size(long j11) {
        this.packedValue = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Size m2733boximpl(long j11) {
        return new Size(j11);
    }

    @Stable
    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m2734component1impl(long j11) {
        return m2745getWidthimpl(j11);
    }

    @Stable
    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m2735component2impl(long j11) {
        return m2742getHeightimpl(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m2736constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: copy-xjbvk4A  reason: not valid java name */
    public static final long m2737copyxjbvk4A(long j11, float f11, float f12) {
        return SizeKt.Size(f11, f12);
    }

    /* renamed from: copy-xjbvk4A$default  reason: not valid java name */
    public static /* synthetic */ long m2738copyxjbvk4A$default(long j11, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = m2745getWidthimpl(j11);
        }
        if ((i11 & 2) != 0) {
            f12 = m2742getHeightimpl(j11);
        }
        return m2737copyxjbvk4A(j11, f11, f12);
    }

    @Stable
    /* renamed from: div-7Ah8Wj8  reason: not valid java name */
    public static final long m2739div7Ah8Wj8(long j11, float f11) {
        return SizeKt.Size(m2745getWidthimpl(j11) / f11, m2742getHeightimpl(j11) / f11);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2740equalsimpl(long j11, Object obj) {
        return (obj instanceof Size) && j11 == ((Size) obj).m2750unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2741equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations() {
    }

    /* renamed from: getHeight-impl  reason: not valid java name */
    public static final float m2742getHeightimpl(long j11) {
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
        throw new IllegalStateException("Size is unspecified".toString());
    }

    @Stable
    public static /* synthetic */ void getMaxDimension$annotations() {
    }

    /* renamed from: getMaxDimension-impl  reason: not valid java name */
    public static final float m2743getMaxDimensionimpl(long j11) {
        return Math.max(Math.abs(m2745getWidthimpl(j11)), Math.abs(m2742getHeightimpl(j11)));
    }

    @Stable
    public static /* synthetic */ void getMinDimension$annotations() {
    }

    /* renamed from: getMinDimension-impl  reason: not valid java name */
    public static final float m2744getMinDimensionimpl(long j11) {
        return Math.min(Math.abs(m2745getWidthimpl(j11)), Math.abs(m2742getHeightimpl(j11)));
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* renamed from: getWidth-impl  reason: not valid java name */
    public static final float m2745getWidthimpl(long j11) {
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
        throw new IllegalStateException("Size is unspecified".toString());
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2746hashCodeimpl(long j11) {
        return a.a(j11);
    }

    @Stable
    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static final boolean m2747isEmptyimpl(long j11) {
        return m2745getWidthimpl(j11) <= 0.0f || m2742getHeightimpl(j11) <= 0.0f;
    }

    @Stable
    /* renamed from: times-7Ah8Wj8  reason: not valid java name */
    public static final long m2748times7Ah8Wj8(long j11, float f11) {
        return SizeKt.Size(m2745getWidthimpl(j11) * f11, m2742getHeightimpl(j11) * f11);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2749toStringimpl(long j11) {
        boolean z11;
        if (j11 != Companion.m2753getUnspecifiedNHjbRc()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return "Size.Unspecified";
        }
        return "Size(" + GeometryUtilsKt.toStringAsFixed(m2745getWidthimpl(j11), 1) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + GeometryUtilsKt.toStringAsFixed(m2742getHeightimpl(j11), 1) + ')';
    }

    public boolean equals(Object obj) {
        return m2740equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2746hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m2749toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m2750unboximpl() {
        return this.packedValue;
    }
}
