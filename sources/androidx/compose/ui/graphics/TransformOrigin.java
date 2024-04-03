package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import l.a;
import org.jetbrains.annotations.NotNull;

@Immutable
@JvmInline
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\tH\n¢\u0006\u0004\b\u000f\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\tH\n¢\u0006\u0004\b\u0011\u0010\u000bJ*\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Landroidx/compose/ui/graphics/TransformOrigin;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "pivotFractionX", "", "getPivotFractionX-impl", "(J)F", "pivotFractionY", "getPivotFractionY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-zey9I6w", "(JFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TransformOrigin {
    /* access modifiers changed from: private */
    public static final long Center = TransformOriginKt.TransformOrigin(0.5f, 0.5f);
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/TransformOrigin$Companion;", "", "()V", "Center", "Landroidx/compose/ui/graphics/TransformOrigin;", "getCenter-SzJe1aQ", "()J", "J", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getCenter-SzJe1aQ  reason: not valid java name */
        public final long m3292getCenterSzJe1aQ() {
            return TransformOrigin.Center;
        }
    }

    private /* synthetic */ TransformOrigin(long j11) {
        this.packedValue = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TransformOrigin m3279boximpl(long j11) {
        return new TransformOrigin(j11);
    }

    @Stable
    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m3280component1impl(long j11) {
        return m3287getPivotFractionXimpl(j11);
    }

    @Stable
    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m3281component2impl(long j11) {
        return m3288getPivotFractionYimpl(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m3282constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: copy-zey9I6w  reason: not valid java name */
    public static final long m3283copyzey9I6w(long j11, float f11, float f12) {
        return TransformOriginKt.TransformOrigin(f11, f12);
    }

    /* renamed from: copy-zey9I6w$default  reason: not valid java name */
    public static /* synthetic */ long m3284copyzey9I6w$default(long j11, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = m3287getPivotFractionXimpl(j11);
        }
        if ((i11 & 2) != 0) {
            f12 = m3288getPivotFractionYimpl(j11);
        }
        return m3283copyzey9I6w(j11, f11, f12);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3285equalsimpl(long j11, Object obj) {
        return (obj instanceof TransformOrigin) && j11 == ((TransformOrigin) obj).m3291unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3286equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getPivotFractionX-impl  reason: not valid java name */
    public static final float m3287getPivotFractionXimpl(long j11) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j11 >> 32));
    }

    /* renamed from: getPivotFractionY-impl  reason: not valid java name */
    public static final float m3288getPivotFractionYimpl(long j11) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j11 & 4294967295L));
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3289hashCodeimpl(long j11) {
        return a.a(j11);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3290toStringimpl(long j11) {
        return "TransformOrigin(packedValue=" + j11 + ')';
    }

    public boolean equals(Object obj) {
        return m3285equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3289hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m3290toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m3291unboximpl() {
        return this.packedValue;
    }
}
