package androidx.compose.ui.layout;

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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 *2\u00020\u0001:\u0001*B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\tH\n¢\u0006\u0004\b\u0011\u0010\fJ\u0010\u0010\u0012\u001a\u00020\tH\n¢\u0006\u0004\b\u0013\u0010\fJ*\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J!\u0010$\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010\u001aJ\u000f\u0010&\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/ui/layout/ScaleFactor;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "scaleX", "", "getScaleX$annotations", "getScaleX-impl", "(J)F", "scaleY", "getScaleY$annotations", "getScaleY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-8GGzs04", "(JFF)J", "div", "operand", "div-44nBxM0", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "times", "times-44nBxM0", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ScaleFactor {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Unspecified = ScaleFactorKt.ScaleFactor(Float.NaN, Float.NaN);
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\t"}, d2 = {"Landroidx/compose/ui/layout/ScaleFactor$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/layout/ScaleFactor;", "getUnspecified-_hLwfpc$annotations", "getUnspecified-_hLwfpc", "()J", "J", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getUnspecified-_hLwfpc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4555getUnspecified_hLwfpc$annotations() {
        }

        /* renamed from: getUnspecified-_hLwfpc  reason: not valid java name */
        public final long m4556getUnspecified_hLwfpc() {
            return ScaleFactor.Unspecified;
        }
    }

    private /* synthetic */ ScaleFactor(long j11) {
        this.packedValue = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ScaleFactor m4540boximpl(long j11) {
        return new ScaleFactor(j11);
    }

    @Stable
    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m4541component1impl(long j11) {
        return m4549getScaleXimpl(j11);
    }

    @Stable
    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m4542component2impl(long j11) {
        return m4550getScaleYimpl(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m4543constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: copy-8GGzs04  reason: not valid java name */
    public static final long m4544copy8GGzs04(long j11, float f11, float f12) {
        return ScaleFactorKt.ScaleFactor(f11, f12);
    }

    /* renamed from: copy-8GGzs04$default  reason: not valid java name */
    public static /* synthetic */ long m4545copy8GGzs04$default(long j11, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = m4549getScaleXimpl(j11);
        }
        if ((i11 & 2) != 0) {
            f12 = m4550getScaleYimpl(j11);
        }
        return m4544copy8GGzs04(j11, f11, f12);
    }

    @Stable
    /* renamed from: div-44nBxM0  reason: not valid java name */
    public static final long m4546div44nBxM0(long j11, float f11) {
        return ScaleFactorKt.ScaleFactor(m4549getScaleXimpl(j11) / f11, m4550getScaleYimpl(j11) / f11);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4547equalsimpl(long j11, Object obj) {
        return (obj instanceof ScaleFactor) && j11 == ((ScaleFactor) obj).m4554unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4548equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getScaleX$annotations() {
    }

    /* renamed from: getScaleX-impl  reason: not valid java name */
    public static final float m4549getScaleXimpl(long j11) {
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
        throw new IllegalStateException("ScaleFactor is unspecified".toString());
    }

    @Stable
    public static /* synthetic */ void getScaleY$annotations() {
    }

    /* renamed from: getScaleY-impl  reason: not valid java name */
    public static final float m4550getScaleYimpl(long j11) {
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
        throw new IllegalStateException("ScaleFactor is unspecified".toString());
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4551hashCodeimpl(long j11) {
        return a.a(j11);
    }

    @Stable
    /* renamed from: times-44nBxM0  reason: not valid java name */
    public static final long m4552times44nBxM0(long j11, float f11) {
        return ScaleFactorKt.ScaleFactor(m4549getScaleXimpl(j11) * f11, m4550getScaleYimpl(j11) * f11);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4553toStringimpl(long j11) {
        return "ScaleFactor(" + ScaleFactorKt.roundToTenths(m4549getScaleXimpl(j11)) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + ScaleFactorKt.roundToTenths(m4550getScaleYimpl(j11)) + ')';
    }

    public boolean equals(Object obj) {
        return m4547equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m4551hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m4553toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m4554unboximpl() {
        return this.packedValue;
    }
}
