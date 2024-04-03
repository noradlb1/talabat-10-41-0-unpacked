package androidx.compose.ui.text.input;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB*\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0007B&\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0002\u0010\nJ3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/input/TextFieldValue;", "", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE", "()J", "J", "getText", "()Ljava/lang/String;", "copy", "copy-3r_uNRQ", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "equals", "", "other", "hashCode", "", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextFieldValue {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Saver<TextFieldValue, Object> Saver = SaverKt.Saver(TextFieldValue$Companion$Saver$1.INSTANCE, TextFieldValue$Companion$Saver$2.INSTANCE);
    @NotNull
    private final AnnotatedString annotatedString;
    @Nullable
    private final TextRange composition;
    private final long selection;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/input/TextFieldValue$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/input/TextFieldValue;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Saver<TextFieldValue, Object> getSaver() {
            return TextFieldValue.Saver;
        }
    }

    private TextFieldValue(AnnotatedString annotatedString2, long j11, TextRange textRange) {
        this.annotatedString = annotatedString2;
        this.selection = TextRangeKt.m5044constrain8ffj60Q(j11, 0, getText().length());
        this.composition = textRange != null ? TextRange.m5026boximpl(TextRangeKt.m5044constrain8ffj60Q(textRange.m5042unboximpl(), 0, getText().length())) : null;
    }

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString2, long j11, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString2, j11, textRange);
    }

    public /* synthetic */ TextFieldValue(String str, long j11, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j11, textRange);
    }

    /* renamed from: copy-3r_uNRQ$default  reason: not valid java name */
    public static /* synthetic */ TextFieldValue m5229copy3r_uNRQ$default(TextFieldValue textFieldValue, AnnotatedString annotatedString2, long j11, TextRange textRange, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            annotatedString2 = textFieldValue.annotatedString;
        }
        if ((i11 & 2) != 0) {
            j11 = textFieldValue.selection;
        }
        if ((i11 & 4) != 0) {
            textRange = textFieldValue.composition;
        }
        return textFieldValue.m5231copy3r_uNRQ(annotatedString2, j11, textRange);
    }

    @NotNull
    /* renamed from: copy-3r_uNRQ  reason: not valid java name */
    public final TextFieldValue m5231copy3r_uNRQ(@NotNull AnnotatedString annotatedString2, long j11, @Nullable TextRange textRange) {
        Intrinsics.checkNotNullParameter(annotatedString2, "annotatedString");
        return new TextFieldValue(annotatedString2, j11, textRange, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldValue)) {
            return false;
        }
        TextFieldValue textFieldValue = (TextFieldValue) obj;
        if (!TextRange.m5031equalsimpl0(this.selection, textFieldValue.selection) || !Intrinsics.areEqual((Object) this.composition, (Object) textFieldValue.composition) || !Intrinsics.areEqual((Object) this.annotatedString, (Object) textFieldValue.annotatedString)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    @Nullable
    /* renamed from: getComposition-MzsxiRA  reason: not valid java name */
    public final TextRange m5233getCompositionMzsxiRA() {
        return this.composition;
    }

    /* renamed from: getSelection-d9O1mEE  reason: not valid java name */
    public final long m5234getSelectiond9O1mEE() {
        return this.selection;
    }

    @NotNull
    public final String getText() {
        return this.annotatedString.getText();
    }

    public int hashCode() {
        int i11;
        int hashCode = ((this.annotatedString.hashCode() * 31) + TextRange.m5039hashCodeimpl(this.selection)) * 31;
        TextRange textRange = this.composition;
        if (textRange != null) {
            i11 = TextRange.m5039hashCodeimpl(textRange.m5042unboximpl());
        } else {
            i11 = 0;
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "TextFieldValue(text='" + this.annotatedString + "', selection=" + TextRange.m5041toStringimpl(this.selection) + ", composition=" + this.composition + ')';
    }

    @NotNull
    /* renamed from: copy-3r_uNRQ  reason: not valid java name */
    public final TextFieldValue m5232copy3r_uNRQ(@NotNull String str, long j11, @Nullable TextRange textRange) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new TextFieldValue(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null), j11, textRange, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString2, long j11, TextRange textRange, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString2, (i11 & 2) != 0 ? TextRange.Companion.m5043getZerod9O1mEE() : j11, (i11 & 4) != 0 ? null : textRange, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-3r_uNRQ$default  reason: not valid java name */
    public static /* synthetic */ TextFieldValue m5230copy3r_uNRQ$default(TextFieldValue textFieldValue, String str, long j11, TextRange textRange, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = textFieldValue.selection;
        }
        if ((i11 & 4) != 0) {
            textRange = textFieldValue.composition;
        }
        return textFieldValue.m5232copy3r_uNRQ(str, j11, textRange);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldValue(String str, long j11, TextRange textRange, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? TextRange.Companion.m5043getZerod9O1mEE() : j11, (i11 & 4) != 0 ? null : textRange, (DefaultConstructorMarker) null);
    }

    private TextFieldValue(String str, long j11, TextRange textRange) {
        this(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null), j11, textRange, (DefaultConstructorMarker) null);
    }
}
