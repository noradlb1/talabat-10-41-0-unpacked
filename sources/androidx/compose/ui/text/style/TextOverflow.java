package androidx.compose.ui.text.style;

import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/TextOverflow;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class TextOverflow {
    /* access modifiers changed from: private */
    public static final int Clip = m5393constructorimpl(1);
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Ellipsis = m5393constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int Visible = m5393constructorimpl(3);
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R'\u0010\t\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R'\u0010\f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/TextOverflow$Companion;", "", "()V", "Clip", "Landroidx/compose/ui/text/style/TextOverflow;", "getClip-gIe3tQ8$annotations", "getClip-gIe3tQ8", "()I", "I", "Ellipsis", "getEllipsis-gIe3tQ8$annotations", "getEllipsis-gIe3tQ8", "Visible", "getVisible-gIe3tQ8$annotations", "getVisible-gIe3tQ8", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getClip-gIe3tQ8$annotations  reason: not valid java name */
        public static /* synthetic */ void m5399getClipgIe3tQ8$annotations() {
        }

        @Stable
        /* renamed from: getEllipsis-gIe3tQ8$annotations  reason: not valid java name */
        public static /* synthetic */ void m5400getEllipsisgIe3tQ8$annotations() {
        }

        @Stable
        /* renamed from: getVisible-gIe3tQ8$annotations  reason: not valid java name */
        public static /* synthetic */ void m5401getVisiblegIe3tQ8$annotations() {
        }

        /* renamed from: getClip-gIe3tQ8  reason: not valid java name */
        public final int m5402getClipgIe3tQ8() {
            return TextOverflow.Clip;
        }

        /* renamed from: getEllipsis-gIe3tQ8  reason: not valid java name */
        public final int m5403getEllipsisgIe3tQ8() {
            return TextOverflow.Ellipsis;
        }

        /* renamed from: getVisible-gIe3tQ8  reason: not valid java name */
        public final int m5404getVisiblegIe3tQ8() {
            return TextOverflow.Visible;
        }
    }

    private /* synthetic */ TextOverflow(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TextOverflow m5392boximpl(int i11) {
        return new TextOverflow(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m5393constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5394equalsimpl(int i11, Object obj) {
        return (obj instanceof TextOverflow) && i11 == ((TextOverflow) obj).m5398unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5395equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5396hashCodeimpl(int i11) {
        return i11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5397toStringimpl(int i11) {
        if (m5395equalsimpl0(i11, Clip)) {
            return "Clip";
        }
        if (m5395equalsimpl0(i11, Ellipsis)) {
            return "Ellipsis";
        }
        if (m5395equalsimpl0(i11, Visible)) {
            return "Visible";
        }
        return "Invalid";
    }

    public boolean equals(Object obj) {
        return m5394equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5396hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m5397toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5398unboximpl() {
        return this.value;
    }
}
