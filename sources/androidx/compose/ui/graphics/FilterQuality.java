package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Immutable
@JvmInline
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/FilterQuality;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FilterQuality {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int High = m2998constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Low = m2998constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Medium = m2998constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int None = m2998constructorimpl(0);
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/graphics/FilterQuality$Companion;", "", "()V", "High", "Landroidx/compose/ui/graphics/FilterQuality;", "getHigh-f-v9h1I", "()I", "I", "Low", "getLow-f-v9h1I", "Medium", "getMedium-f-v9h1I", "None", "getNone-f-v9h1I", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getHigh-f-v9h1I  reason: not valid java name */
        public final int m3004getHighfv9h1I() {
            return FilterQuality.High;
        }

        /* renamed from: getLow-f-v9h1I  reason: not valid java name */
        public final int m3005getLowfv9h1I() {
            return FilterQuality.Low;
        }

        /* renamed from: getMedium-f-v9h1I  reason: not valid java name */
        public final int m3006getMediumfv9h1I() {
            return FilterQuality.Medium;
        }

        /* renamed from: getNone-f-v9h1I  reason: not valid java name */
        public final int m3007getNonefv9h1I() {
            return FilterQuality.None;
        }
    }

    private /* synthetic */ FilterQuality(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FilterQuality m2997boximpl(int i11) {
        return new FilterQuality(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m2998constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2999equalsimpl(int i11, Object obj) {
        return (obj instanceof FilterQuality) && i11 == ((FilterQuality) obj).m3003unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3000equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3001hashCodeimpl(int i11) {
        return i11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3002toStringimpl(int i11) {
        if (m3000equalsimpl0(i11, None)) {
            return "None";
        }
        if (m3000equalsimpl0(i11, Low)) {
            return "Low";
        }
        if (m3000equalsimpl0(i11, Medium)) {
            return "Medium";
        }
        if (m3000equalsimpl0(i11, High)) {
            return "High";
        }
        return "Unknown";
    }

    public boolean equals(Object obj) {
        return m2999equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m3001hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3002toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m3003unboximpl() {
        return this.value;
    }
}
