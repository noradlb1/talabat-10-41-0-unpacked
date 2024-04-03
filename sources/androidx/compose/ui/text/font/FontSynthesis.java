package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/font/FontSynthesis;", "", "value", "", "constructor-impl", "(I)I", "isStyleOn", "", "isStyleOn-impl$ui_text_release", "(I)Z", "isWeightOn", "isWeightOn-impl$ui_text_release", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class FontSynthesis {
    /* access modifiers changed from: private */
    public static final int All = m5131constructorimpl(1);
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int None = m5131constructorimpl(0);
    /* access modifiers changed from: private */
    public static final int Style = m5131constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Weight = m5131constructorimpl(2);
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/font/FontSynthesis$Companion;", "", "()V", "All", "Landroidx/compose/ui/text/font/FontSynthesis;", "getAll-GVVA2EU", "()I", "I", "None", "getNone-GVVA2EU", "Style", "getStyle-GVVA2EU", "Weight", "getWeight-GVVA2EU", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAll-GVVA2EU  reason: not valid java name */
        public final int m5139getAllGVVA2EU() {
            return FontSynthesis.All;
        }

        /* renamed from: getNone-GVVA2EU  reason: not valid java name */
        public final int m5140getNoneGVVA2EU() {
            return FontSynthesis.None;
        }

        /* renamed from: getStyle-GVVA2EU  reason: not valid java name */
        public final int m5141getStyleGVVA2EU() {
            return FontSynthesis.Style;
        }

        /* renamed from: getWeight-GVVA2EU  reason: not valid java name */
        public final int m5142getWeightGVVA2EU() {
            return FontSynthesis.Weight;
        }
    }

    private /* synthetic */ FontSynthesis(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FontSynthesis m5130boximpl(int i11) {
        return new FontSynthesis(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m5131constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5132equalsimpl(int i11, Object obj) {
        return (obj instanceof FontSynthesis) && i11 == ((FontSynthesis) obj).m5138unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5133equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5134hashCodeimpl(int i11) {
        return i11;
    }

    /* renamed from: isStyleOn-impl$ui_text_release  reason: not valid java name */
    public static final boolean m5135isStyleOnimpl$ui_text_release(int i11) {
        return m5133equalsimpl0(i11, All) || m5133equalsimpl0(i11, Style);
    }

    /* renamed from: isWeightOn-impl$ui_text_release  reason: not valid java name */
    public static final boolean m5136isWeightOnimpl$ui_text_release(int i11) {
        return m5133equalsimpl0(i11, All) || m5133equalsimpl0(i11, Weight);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5137toStringimpl(int i11) {
        if (m5133equalsimpl0(i11, None)) {
            return "None";
        }
        if (m5133equalsimpl0(i11, All)) {
            return "All";
        }
        if (m5133equalsimpl0(i11, Weight)) {
            return "Weight";
        }
        if (m5133equalsimpl0(i11, Style)) {
            return "Style";
        }
        return "Invalid";
    }

    public boolean equals(Object obj) {
        return m5132equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5134hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m5137toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5138unboximpl() {
        return this.value;
    }
}
