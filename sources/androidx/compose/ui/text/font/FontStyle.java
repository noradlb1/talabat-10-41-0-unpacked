package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/font/FontStyle;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class FontStyle {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Italic = m5122constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Normal = m5122constructorimpl(0);
    private final int value;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bø\u0001\u0000R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/font/FontStyle$Companion;", "", "()V", "Italic", "Landroidx/compose/ui/text/font/FontStyle;", "getItalic-_-LCdwA", "()I", "I", "Normal", "getNormal-_-LCdwA", "values", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getItalic-_-LCdwA  reason: not valid java name */
        public final int m5128getItalic_LCdwA() {
            return FontStyle.Italic;
        }

        /* renamed from: getNormal-_-LCdwA  reason: not valid java name */
        public final int m5129getNormal_LCdwA() {
            return FontStyle.Normal;
        }

        @NotNull
        public final List<FontStyle> values() {
            return CollectionsKt__CollectionsKt.listOf(FontStyle.m5121boximpl(m5129getNormal_LCdwA()), FontStyle.m5121boximpl(m5128getItalic_LCdwA()));
        }
    }

    private /* synthetic */ FontStyle(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FontStyle m5121boximpl(int i11) {
        return new FontStyle(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m5122constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5123equalsimpl(int i11, Object obj) {
        return (obj instanceof FontStyle) && i11 == ((FontStyle) obj).m5127unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5124equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5125hashCodeimpl(int i11) {
        return i11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5126toStringimpl(int i11) {
        if (m5124equalsimpl0(i11, Normal)) {
            return "Normal";
        }
        if (m5124equalsimpl0(i11, Italic)) {
            return "Italic";
        }
        return "Invalid";
    }

    public boolean equals(Object obj) {
        return m5123equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m5125hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m5126toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5127unboximpl() {
        return this.value;
    }
}
