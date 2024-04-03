package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Immutable
@JvmInline
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\b@\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001&B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000fJ!\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000fJ\u001e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u000fJ!\u0010\u001e\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u000fJ!\u0010\u001e\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0011J\u000f\u0010 \u001a\u00020!H\u0017¢\u0006\u0004\b\"\u0010#J\u0019\u0010$\u001a\u00020\u0000H\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Landroidx/compose/ui/unit/Dp;", "", "value", "", "constructor-impl", "(F)F", "getValue", "()F", "compareTo", "", "other", "compareTo-0680j_4", "(FF)I", "div", "div-0680j_4", "(FF)F", "div-u2uoSUM", "(FI)F", "equals", "", "", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(F)I", "minus", "minus-5rwHm24", "plus", "plus-5rwHm24", "times", "times-u2uoSUM", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "unaryMinus", "unaryMinus-D9Ej5fM", "Companion", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Dp implements Comparable<Dp> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final float Hairline = m5478constructorimpl(0.0f);
    /* access modifiers changed from: private */
    public static final float Infinity = m5478constructorimpl(Float.POSITIVE_INFINITY);
    /* access modifiers changed from: private */
    public static final float Unspecified = m5478constructorimpl(Float.NaN);
    private final float value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R'\u0010\t\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R'\u0010\f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/unit/Dp$Companion;", "", "()V", "Hairline", "Landroidx/compose/ui/unit/Dp;", "getHairline-D9Ej5fM$annotations", "getHairline-D9Ej5fM", "()F", "F", "Infinity", "getInfinity-D9Ej5fM$annotations", "getInfinity-D9Ej5fM", "Unspecified", "getUnspecified-D9Ej5fM$annotations", "getUnspecified-D9Ej5fM", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getHairline-D9Ej5fM$annotations  reason: not valid java name */
        public static /* synthetic */ void m5493getHairlineD9Ej5fM$annotations() {
        }

        @Stable
        /* renamed from: getInfinity-D9Ej5fM$annotations  reason: not valid java name */
        public static /* synthetic */ void m5494getInfinityD9Ej5fM$annotations() {
        }

        @Stable
        /* renamed from: getUnspecified-D9Ej5fM$annotations  reason: not valid java name */
        public static /* synthetic */ void m5495getUnspecifiedD9Ej5fM$annotations() {
        }

        /* renamed from: getHairline-D9Ej5fM  reason: not valid java name */
        public final float m5496getHairlineD9Ej5fM() {
            return Dp.Hairline;
        }

        /* renamed from: getInfinity-D9Ej5fM  reason: not valid java name */
        public final float m5497getInfinityD9Ej5fM() {
            return Dp.Infinity;
        }

        /* renamed from: getUnspecified-D9Ej5fM  reason: not valid java name */
        public final float m5498getUnspecifiedD9Ej5fM() {
            return Dp.Unspecified;
        }
    }

    private /* synthetic */ Dp(float f11) {
        this.value = f11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Dp m5476boximpl(float f11) {
        return new Dp(f11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static float m5478constructorimpl(float f11) {
        return f11;
    }

    @Stable
    /* renamed from: div-0680j_4  reason: not valid java name */
    public static final float m5479div0680j_4(float f11, float f12) {
        return f11 / f12;
    }

    @Stable
    /* renamed from: div-u2uoSUM  reason: not valid java name */
    public static final float m5480divu2uoSUM(float f11, float f12) {
        return m5478constructorimpl(f11 / f12);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5482equalsimpl(float f11, Object obj) {
        if (!(obj instanceof Dp)) {
            return false;
        }
        return Intrinsics.areEqual((Object) Float.valueOf(f11), (Object) Float.valueOf(((Dp) obj).m5492unboximpl()));
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5483equalsimpl0(float f11, float f12) {
        return Intrinsics.areEqual((Object) Float.valueOf(f11), (Object) Float.valueOf(f12));
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5484hashCodeimpl(float f11) {
        return Float.floatToIntBits(f11);
    }

    @Stable
    /* renamed from: minus-5rwHm24  reason: not valid java name */
    public static final float m5485minus5rwHm24(float f11, float f12) {
        return m5478constructorimpl(f11 - f12);
    }

    @Stable
    /* renamed from: plus-5rwHm24  reason: not valid java name */
    public static final float m5486plus5rwHm24(float f11, float f12) {
        return m5478constructorimpl(f11 + f12);
    }

    @Stable
    /* renamed from: times-u2uoSUM  reason: not valid java name */
    public static final float m5487timesu2uoSUM(float f11, float f12) {
        return m5478constructorimpl(f11 * f12);
    }

    @NotNull
    @Stable
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5489toStringimpl(float f11) {
        if (Float.isNaN(f11)) {
            return "Dp.Unspecified";
        }
        return f11 + ".dp";
    }

    @Stable
    /* renamed from: unaryMinus-D9Ej5fM  reason: not valid java name */
    public static final float m5490unaryMinusD9Ej5fM(float f11) {
        return m5478constructorimpl(-f11);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m5491compareTo0680j_4(((Dp) obj).m5492unboximpl());
    }

    @Stable
    /* renamed from: compareTo-0680j_4  reason: not valid java name */
    public int m5491compareTo0680j_4(float f11) {
        return m5477compareTo0680j_4(this.value, f11);
    }

    public boolean equals(Object obj) {
        return m5482equalsimpl(this.value, obj);
    }

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        return m5484hashCodeimpl(this.value);
    }

    @NotNull
    @Stable
    public String toString() {
        return m5489toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ float m5492unboximpl() {
        return this.value;
    }

    @Stable
    /* renamed from: compareTo-0680j_4  reason: not valid java name */
    public static int m5477compareTo0680j_4(float f11, float f12) {
        return Float.compare(f11, f12);
    }

    @Stable
    /* renamed from: div-u2uoSUM  reason: not valid java name */
    public static final float m5481divu2uoSUM(float f11, int i11) {
        return m5478constructorimpl(f11 / ((float) i11));
    }

    @Stable
    /* renamed from: times-u2uoSUM  reason: not valid java name */
    public static final float m5488timesu2uoSUM(float f11, int i11) {
        return m5478constructorimpl(f11 * ((float) i11));
    }
}
