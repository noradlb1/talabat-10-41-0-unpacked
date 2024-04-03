package androidx.compose.ui.text.style;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Immutable
@JvmInline
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/style/BaselineShift;", "", "multiplier", "", "constructor-impl", "(F)F", "getMultiplier", "()F", "equals", "", "other", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(F)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BaselineShift {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final float None = m5275constructorimpl(0.0f);
    /* access modifiers changed from: private */
    public static final float Subscript = m5275constructorimpl(-0.5f);
    /* access modifiers changed from: private */
    public static final float Superscript = m5275constructorimpl(0.5f);
    private final float multiplier;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R'\u0010\t\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R'\u0010\f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/BaselineShift$Companion;", "", "()V", "None", "Landroidx/compose/ui/text/style/BaselineShift;", "getNone-y9eOQZs$annotations", "getNone-y9eOQZs", "()F", "F", "Subscript", "getSubscript-y9eOQZs$annotations", "getSubscript-y9eOQZs", "Superscript", "getSuperscript-y9eOQZs$annotations", "getSuperscript-y9eOQZs", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getNone-y9eOQZs$annotations  reason: not valid java name */
        public static /* synthetic */ void m5281getNoney9eOQZs$annotations() {
        }

        @Stable
        /* renamed from: getSubscript-y9eOQZs$annotations  reason: not valid java name */
        public static /* synthetic */ void m5282getSubscripty9eOQZs$annotations() {
        }

        @Stable
        /* renamed from: getSuperscript-y9eOQZs$annotations  reason: not valid java name */
        public static /* synthetic */ void m5283getSuperscripty9eOQZs$annotations() {
        }

        /* renamed from: getNone-y9eOQZs  reason: not valid java name */
        public final float m5284getNoney9eOQZs() {
            return BaselineShift.None;
        }

        /* renamed from: getSubscript-y9eOQZs  reason: not valid java name */
        public final float m5285getSubscripty9eOQZs() {
            return BaselineShift.Subscript;
        }

        /* renamed from: getSuperscript-y9eOQZs  reason: not valid java name */
        public final float m5286getSuperscripty9eOQZs() {
            return BaselineShift.Superscript;
        }
    }

    private /* synthetic */ BaselineShift(float f11) {
        this.multiplier = f11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ BaselineShift m5274boximpl(float f11) {
        return new BaselineShift(f11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static float m5275constructorimpl(float f11) {
        return f11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5276equalsimpl(float f11, Object obj) {
        if (!(obj instanceof BaselineShift)) {
            return false;
        }
        return Intrinsics.areEqual((Object) Float.valueOf(f11), (Object) Float.valueOf(((BaselineShift) obj).m5280unboximpl()));
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5277equalsimpl0(float f11, float f12) {
        return Intrinsics.areEqual((Object) Float.valueOf(f11), (Object) Float.valueOf(f12));
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5278hashCodeimpl(float f11) {
        return Float.floatToIntBits(f11);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5279toStringimpl(float f11) {
        return "BaselineShift(multiplier=" + f11 + ')';
    }

    public boolean equals(Object obj) {
        return m5276equalsimpl(this.multiplier, obj);
    }

    public final float getMultiplier() {
        return this.multiplier;
    }

    public int hashCode() {
        return m5278hashCodeimpl(this.multiplier);
    }

    public String toString() {
        return m5279toStringimpl(this.multiplier);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ float m5280unboximpl() {
        return this.multiplier;
    }
}
