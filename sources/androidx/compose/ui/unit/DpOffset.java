package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Dp;
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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 %2\u00020\u0001:\u0001%B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\"H\u0017¢\u0006\u0004\b#\u0010$R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R#\u0010\b\u001a\u00020\t8FX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR#\u0010\r\u001a\u00020\t8FX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/ui/unit/DpOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "Landroidx/compose/ui/unit/Dp;", "getX-D9Ej5fM$annotations", "getX-D9Ej5fM", "(J)F", "y", "getY-D9Ej5fM$annotations", "getY-D9Ej5fM", "copy", "copy-tPigGR8", "(JFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-CB-Mgk4", "(JJ)J", "plus", "plus-CB-Mgk4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DpOffset {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Unspecified;
    /* access modifiers changed from: private */
    public static final long Zero;
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/unit/DpOffset$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/unit/DpOffset;", "getUnspecified-RKDOV3M", "()J", "J", "Zero", "getZero-RKDOV3M", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-RKDOV3M  reason: not valid java name */
        public final long m5548getUnspecifiedRKDOV3M() {
            return DpOffset.Unspecified;
        }

        /* renamed from: getZero-RKDOV3M  reason: not valid java name */
        public final long m5549getZeroRKDOV3M() {
            return DpOffset.Zero;
        }
    }

    static {
        float f11 = (float) 0;
        Zero = DpKt.m5499DpOffsetYgX7TsA(Dp.m5478constructorimpl(f11), Dp.m5478constructorimpl(f11));
        Dp.Companion companion = Dp.Companion;
        Unspecified = DpKt.m5499DpOffsetYgX7TsA(companion.m5498getUnspecifiedD9Ej5fM(), companion.m5498getUnspecifiedD9Ej5fM());
    }

    private /* synthetic */ DpOffset(long j11) {
        this.packedValue = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DpOffset m5533boximpl(long j11) {
        return new DpOffset(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m5534constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: copy-tPigGR8  reason: not valid java name */
    public static final long m5535copytPigGR8(long j11, float f11, float f12) {
        return DpKt.m5499DpOffsetYgX7TsA(f11, f12);
    }

    /* renamed from: copy-tPigGR8$default  reason: not valid java name */
    public static /* synthetic */ long m5536copytPigGR8$default(long j11, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = m5539getXD9Ej5fM(j11);
        }
        if ((i11 & 2) != 0) {
            f12 = m5541getYD9Ej5fM(j11);
        }
        return m5535copytPigGR8(j11, f11, f12);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5537equalsimpl(long j11, Object obj) {
        return (obj instanceof DpOffset) && j11 == ((DpOffset) obj).m5547unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5538equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getX-D9Ej5fM  reason: not valid java name */
    public static final float m5539getXD9Ej5fM(long j11) {
        boolean z11;
        if (j11 != Unspecified) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Dp.m5478constructorimpl(Float.intBitsToFloat((int) (j11 >> 32)));
        }
        throw new IllegalStateException("DpOffset is unspecified".toString());
    }

    @Stable
    /* renamed from: getX-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m5540getXD9Ej5fM$annotations() {
    }

    /* renamed from: getY-D9Ej5fM  reason: not valid java name */
    public static final float m5541getYD9Ej5fM(long j11) {
        boolean z11;
        if (j11 != Unspecified) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Dp.m5478constructorimpl(Float.intBitsToFloat((int) (j11 & 4294967295L)));
        }
        throw new IllegalStateException("DpOffset is unspecified".toString());
    }

    @Stable
    /* renamed from: getY-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m5542getYD9Ej5fM$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5543hashCodeimpl(long j11) {
        return a.a(j11);
    }

    @Stable
    /* renamed from: minus-CB-Mgk4  reason: not valid java name */
    public static final long m5544minusCBMgk4(long j11, long j12) {
        return DpKt.m5499DpOffsetYgX7TsA(Dp.m5478constructorimpl(m5539getXD9Ej5fM(j11) - m5539getXD9Ej5fM(j12)), Dp.m5478constructorimpl(m5541getYD9Ej5fM(j11) - m5541getYD9Ej5fM(j12)));
    }

    @Stable
    /* renamed from: plus-CB-Mgk4  reason: not valid java name */
    public static final long m5545plusCBMgk4(long j11, long j12) {
        return DpKt.m5499DpOffsetYgX7TsA(Dp.m5478constructorimpl(m5539getXD9Ej5fM(j11) + m5539getXD9Ej5fM(j12)), Dp.m5478constructorimpl(m5541getYD9Ej5fM(j11) + m5541getYD9Ej5fM(j12)));
    }

    @NotNull
    @Stable
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5546toStringimpl(long j11) {
        boolean z11;
        if (j11 != Companion.m5548getUnspecifiedRKDOV3M()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return "DpOffset.Unspecified";
        }
        return '(' + Dp.m5489toStringimpl(m5539getXD9Ej5fM(j11)) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Dp.m5489toStringimpl(m5541getYD9Ej5fM(j11)) + ')';
    }

    public boolean equals(Object obj) {
        return m5537equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5543hashCodeimpl(this.packedValue);
    }

    @NotNull
    @Stable
    public String toString() {
        return m5546toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m5547unboximpl() {
        return this.packedValue;
    }
}
