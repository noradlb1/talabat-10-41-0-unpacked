package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/TextDirection;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class TextDirection {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Content = m5373constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int ContentOrLtr = m5373constructorimpl(4);
    /* access modifiers changed from: private */
    public static final int ContentOrRtl = m5373constructorimpl(5);
    /* access modifiers changed from: private */
    public static final int Ltr = m5373constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Rtl = m5373constructorimpl(2);
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/style/TextDirection$Companion;", "", "()V", "Content", "Landroidx/compose/ui/text/style/TextDirection;", "getContent-s_7X-co", "()I", "I", "ContentOrLtr", "getContentOrLtr-s_7X-co", "ContentOrRtl", "getContentOrRtl-s_7X-co", "Ltr", "getLtr-s_7X-co", "Rtl", "getRtl-s_7X-co", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getContent-s_7X-co  reason: not valid java name */
        public final int m5379getContents_7Xco() {
            return TextDirection.Content;
        }

        /* renamed from: getContentOrLtr-s_7X-co  reason: not valid java name */
        public final int m5380getContentOrLtrs_7Xco() {
            return TextDirection.ContentOrLtr;
        }

        /* renamed from: getContentOrRtl-s_7X-co  reason: not valid java name */
        public final int m5381getContentOrRtls_7Xco() {
            return TextDirection.ContentOrRtl;
        }

        /* renamed from: getLtr-s_7X-co  reason: not valid java name */
        public final int m5382getLtrs_7Xco() {
            return TextDirection.Ltr;
        }

        /* renamed from: getRtl-s_7X-co  reason: not valid java name */
        public final int m5383getRtls_7Xco() {
            return TextDirection.Rtl;
        }
    }

    private /* synthetic */ TextDirection(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TextDirection m5372boximpl(int i11) {
        return new TextDirection(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m5373constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5374equalsimpl(int i11, Object obj) {
        return (obj instanceof TextDirection) && i11 == ((TextDirection) obj).m5378unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5375equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5376hashCodeimpl(int i11) {
        return i11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5377toStringimpl(int i11) {
        if (m5375equalsimpl0(i11, Ltr)) {
            return "Ltr";
        }
        if (m5375equalsimpl0(i11, Rtl)) {
            return "Rtl";
        }
        if (m5375equalsimpl0(i11, Content)) {
            return "Content";
        }
        if (m5375equalsimpl0(i11, ContentOrLtr)) {
            return "ContentOrLtr";
        }
        if (m5375equalsimpl0(i11, ContentOrRtl)) {
            return "ContentOrRtl";
        }
        return "Invalid";
    }

    public boolean equals(Object obj) {
        return m5374equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5376hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m5377toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5378unboximpl() {
        return this.value;
    }
}
