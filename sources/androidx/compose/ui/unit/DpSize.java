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

@Immutable
@JvmInline
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 02\u00020\u0001:\u00010B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0010\u001a\u00020\u0007H\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000bJ\u0019\u0010\u0012\u001a\u00020\u0007H\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u001cH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b#\u0010$J\u001e\u0010%\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001e\u0010(\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010'J!\u0010*\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001bJ!\u0010*\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u001cH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001dJ\u000f\u0010,\u001a\u00020-H\u0017¢\u0006\u0004\b.\u0010/R#\u0010\u0006\u001a\u00020\u00078FX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\tR#\u0010\r\u001a\u00020\u00078FX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00061"}, d2 = {"Landroidx/compose/ui/unit/DpSize;", "", "packedValue", "", "constructor-impl", "(J)J", "height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM$annotations", "()V", "getHeight-D9Ej5fM", "(J)F", "getPackedValue$annotations", "width", "getWidth-D9Ej5fM$annotations", "getWidth-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "copy", "copy-DwJknco", "(JFF)J", "div", "other", "", "div-Gh9hcWk", "(JF)J", "", "(JI)J", "equals", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(J)I", "minus", "minus-e_xh8Ic", "(JJ)J", "plus", "plus-e_xh8Ic", "times", "times-Gh9hcWk", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DpSize {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Unspecified;
    /* access modifiers changed from: private */
    public static final long Zero;
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/unit/DpSize$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/unit/DpSize;", "getUnspecified-MYxV2XQ", "()J", "J", "Zero", "getZero-MYxV2XQ", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-MYxV2XQ  reason: not valid java name */
        public final long m5585getUnspecifiedMYxV2XQ() {
            return DpSize.Unspecified;
        }

        /* renamed from: getZero-MYxV2XQ  reason: not valid java name */
        public final long m5586getZeroMYxV2XQ() {
            return DpSize.Zero;
        }
    }

    static {
        float f11 = (float) 0;
        Zero = DpKt.m5500DpSizeYgX7TsA(Dp.m5478constructorimpl(f11), Dp.m5478constructorimpl(f11));
        Dp.Companion companion = Dp.Companion;
        Unspecified = DpKt.m5500DpSizeYgX7TsA(companion.m5498getUnspecifiedD9Ej5fM(), companion.m5498getUnspecifiedD9Ej5fM());
    }

    private /* synthetic */ DpSize(long j11) {
        this.packedValue = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DpSize m5564boximpl(long j11) {
        return new DpSize(j11);
    }

    @Stable
    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    public static final float m5565component1D9Ej5fM(long j11) {
        return m5576getWidthD9Ej5fM(j11);
    }

    @Stable
    /* renamed from: component2-D9Ej5fM  reason: not valid java name */
    public static final float m5566component2D9Ej5fM(long j11) {
        return m5574getHeightD9Ej5fM(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m5567constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: copy-DwJknco  reason: not valid java name */
    public static final long m5568copyDwJknco(long j11, float f11, float f12) {
        return DpKt.m5500DpSizeYgX7TsA(f11, f12);
    }

    /* renamed from: copy-DwJknco$default  reason: not valid java name */
    public static /* synthetic */ long m5569copyDwJknco$default(long j11, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = m5576getWidthD9Ej5fM(j11);
        }
        if ((i11 & 2) != 0) {
            f12 = m5574getHeightD9Ej5fM(j11);
        }
        return m5568copyDwJknco(j11, f11, f12);
    }

    @Stable
    /* renamed from: div-Gh9hcWk  reason: not valid java name */
    public static final long m5571divGh9hcWk(long j11, int i11) {
        float f11 = (float) i11;
        return DpKt.m5500DpSizeYgX7TsA(Dp.m5478constructorimpl(m5576getWidthD9Ej5fM(j11) / f11), Dp.m5478constructorimpl(m5574getHeightD9Ej5fM(j11) / f11));
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5572equalsimpl(long j11, Object obj) {
        return (obj instanceof DpSize) && j11 == ((DpSize) obj).m5584unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5573equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public static final float m5574getHeightD9Ej5fM(long j11) {
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
        throw new IllegalStateException("DpSize is unspecified".toString());
    }

    @Stable
    /* renamed from: getHeight-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m5575getHeightD9Ej5fM$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public static final float m5576getWidthD9Ej5fM(long j11) {
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
        throw new IllegalStateException("DpSize is unspecified".toString());
    }

    @Stable
    /* renamed from: getWidth-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m5577getWidthD9Ej5fM$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5578hashCodeimpl(long j11) {
        return a.a(j11);
    }

    @Stable
    /* renamed from: minus-e_xh8Ic  reason: not valid java name */
    public static final long m5579minuse_xh8Ic(long j11, long j12) {
        return DpKt.m5500DpSizeYgX7TsA(Dp.m5478constructorimpl(m5576getWidthD9Ej5fM(j11) - m5576getWidthD9Ej5fM(j12)), Dp.m5478constructorimpl(m5574getHeightD9Ej5fM(j11) - m5574getHeightD9Ej5fM(j12)));
    }

    @Stable
    /* renamed from: plus-e_xh8Ic  reason: not valid java name */
    public static final long m5580pluse_xh8Ic(long j11, long j12) {
        return DpKt.m5500DpSizeYgX7TsA(Dp.m5478constructorimpl(m5576getWidthD9Ej5fM(j11) + m5576getWidthD9Ej5fM(j12)), Dp.m5478constructorimpl(m5574getHeightD9Ej5fM(j11) + m5574getHeightD9Ej5fM(j12)));
    }

    @Stable
    /* renamed from: times-Gh9hcWk  reason: not valid java name */
    public static final long m5582timesGh9hcWk(long j11, int i11) {
        float f11 = (float) i11;
        return DpKt.m5500DpSizeYgX7TsA(Dp.m5478constructorimpl(m5576getWidthD9Ej5fM(j11) * f11), Dp.m5478constructorimpl(m5574getHeightD9Ej5fM(j11) * f11));
    }

    @NotNull
    @Stable
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5583toStringimpl(long j11) {
        boolean z11;
        if (j11 != Companion.m5585getUnspecifiedMYxV2XQ()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return "DpSize.Unspecified";
        }
        return Dp.m5489toStringimpl(m5576getWidthD9Ej5fM(j11)) + " x " + Dp.m5489toStringimpl(m5574getHeightD9Ej5fM(j11));
    }

    public boolean equals(Object obj) {
        return m5572equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5578hashCodeimpl(this.packedValue);
    }

    @NotNull
    @Stable
    public String toString() {
        return m5583toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m5584unboximpl() {
        return this.packedValue;
    }

    @Stable
    /* renamed from: div-Gh9hcWk  reason: not valid java name */
    public static final long m5570divGh9hcWk(long j11, float f11) {
        return DpKt.m5500DpSizeYgX7TsA(Dp.m5478constructorimpl(m5576getWidthD9Ej5fM(j11) / f11), Dp.m5478constructorimpl(m5574getHeightD9Ej5fM(j11) / f11));
    }

    @Stable
    /* renamed from: times-Gh9hcWk  reason: not valid java name */
    public static final long m5581timesGh9hcWk(long j11, float f11) {
        return DpKt.m5500DpSizeYgX7TsA(Dp.m5478constructorimpl(m5576getWidthD9Ej5fM(j11) * f11), Dp.m5478constructorimpl(m5574getHeightD9Ej5fM(j11) * f11));
    }
}
