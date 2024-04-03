package androidx.compose.ui.text.input;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u001a\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\bJ\r\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&J\r\u0010'\u001a\u00020%H\u0000¢\u0006\u0002\b(J\u001d\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0000¢\u0006\u0002\b,J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\rH\u0002¢\u0006\u0002\b0J\r\u00101\u001a\u000202H\u0000¢\u0006\u0002\b3J%\u00104\u001a\u00020%2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0007H\u0000¢\u0006\u0002\b5J%\u00104\u001a\u00020%2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b5J\u001d\u00106\u001a\u00020%2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0000¢\u0006\u0002\b7J\u001d\u00108\u001a\u00020%2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0000¢\u0006\u0002\b9J\r\u0010:\u001a\u00020\u0007H\u0000¢\u0006\u0002\b;J\b\u0010<\u001a\u00020\u0003H\u0016R\u001f\u0010\t\u001a\u0004\u0018\u00010\u00058@X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r8@@@X\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\r8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0010R\u001d\u0010\u0004\u001a\u00020\u00058@X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0016R$\u0010!\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0016\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, d2 = {"Landroidx/compose/ui/text/input/EditingBuffer;", "", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "composition", "getComposition-MzsxiRA$ui_text_release", "()Landroidx/compose/ui/text/TextRange;", "<set-?>", "", "compositionEnd", "getCompositionEnd$ui_text_release", "()I", "compositionStart", "getCompositionStart$ui_text_release", "cursor", "getCursor$ui_text_release", "setCursor$ui_text_release", "(I)V", "gapBuffer", "Landroidx/compose/ui/text/input/PartialGapBuffer;", "length", "getLength$ui_text_release", "getSelection-d9O1mEE$ui_text_release", "()J", "value", "selectionEnd", "getSelectionEnd$ui_text_release", "setSelectionEnd", "selectionStart", "getSelectionStart$ui_text_release", "setSelectionStart", "cancelComposition", "", "cancelComposition$ui_text_release", "commitComposition", "commitComposition$ui_text_release", "delete", "start", "end", "delete$ui_text_release", "get", "", "index", "get$ui_text_release", "hasComposition", "", "hasComposition$ui_text_release", "replace", "replace$ui_text_release", "setComposition", "setComposition$ui_text_release", "setSelection", "setSelection$ui_text_release", "toAnnotatedString", "toAnnotatedString$ui_text_release", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EditingBuffer {
    public static final int $stable = 8;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NOWHERE = -1;
    private int compositionEnd;
    private int compositionStart;
    @NotNull
    private final PartialGapBuffer gapBuffer;
    private int selectionEnd;
    private int selectionStart;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/text/input/EditingBuffer$Companion;", "", "()V", "NOWHERE", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private EditingBuffer(AnnotatedString annotatedString, long j11) {
        this.gapBuffer = new PartialGapBuffer(annotatedString.getText());
        this.selectionStart = TextRange.m5036getMinimpl(j11);
        this.selectionEnd = TextRange.m5035getMaximpl(j11);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        int r02 = TextRange.m5036getMinimpl(j11);
        int r52 = TextRange.m5035getMaximpl(j11);
        if (r02 < 0 || r02 > annotatedString.length()) {
            throw new IndexOutOfBoundsException("start (" + r02 + ") offset is outside of text region " + annotatedString.length());
        } else if (r52 < 0 || r52 > annotatedString.length()) {
            throw new IndexOutOfBoundsException("end (" + r52 + ") offset is outside of text region " + annotatedString.length());
        } else if (r02 > r52) {
            throw new IllegalArgumentException("Do not set reversed range: " + r02 + " > " + r52);
        }
    }

    public /* synthetic */ EditingBuffer(AnnotatedString annotatedString, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j11);
    }

    public /* synthetic */ EditingBuffer(String str, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j11);
    }

    private final void setSelectionEnd(int i11) {
        boolean z11;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.selectionEnd = i11;
            return;
        }
        throw new IllegalArgumentException(("Cannot set selectionEnd to a negative value: " + i11).toString());
    }

    private final void setSelectionStart(int i11) {
        boolean z11;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.selectionStart = i11;
            return;
        }
        throw new IllegalArgumentException(("Cannot set selectionStart to a negative value: " + i11).toString());
    }

    public final void cancelComposition$ui_text_release() {
        replace$ui_text_release(this.compositionStart, this.compositionEnd, "");
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void commitComposition$ui_text_release() {
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void delete$ui_text_release(int i11, int i12) {
        long TextRange = TextRangeKt.TextRange(i11, i12);
        this.gapBuffer.replace(i11, i12, "");
        long r52 = EditingBufferKt.m5179updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), TextRange);
        setSelectionStart(TextRange.m5036getMinimpl(r52));
        setSelectionEnd(TextRange.m5035getMaximpl(r52));
        if (hasComposition$ui_text_release()) {
            long r53 = EditingBufferKt.m5179updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd), TextRange);
            if (TextRange.m5032getCollapsedimpl(r53)) {
                commitComposition$ui_text_release();
                return;
            }
            this.compositionStart = TextRange.m5036getMinimpl(r53);
            this.compositionEnd = TextRange.m5035getMaximpl(r53);
        }
    }

    public final char get$ui_text_release(int i11) {
        return this.gapBuffer.get(i11);
    }

    @Nullable
    /* renamed from: getComposition-MzsxiRA$ui_text_release  reason: not valid java name */
    public final TextRange m5177getCompositionMzsxiRA$ui_text_release() {
        if (hasComposition$ui_text_release()) {
            return TextRange.m5026boximpl(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd));
        }
        return null;
    }

    public final int getCompositionEnd$ui_text_release() {
        return this.compositionEnd;
    }

    public final int getCompositionStart$ui_text_release() {
        return this.compositionStart;
    }

    public final int getCursor$ui_text_release() {
        int i11 = this.selectionStart;
        int i12 = this.selectionEnd;
        if (i11 == i12) {
            return i12;
        }
        return -1;
    }

    public final int getLength$ui_text_release() {
        return this.gapBuffer.getLength();
    }

    /* renamed from: getSelection-d9O1mEE$ui_text_release  reason: not valid java name */
    public final long m5178getSelectiond9O1mEE$ui_text_release() {
        return TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    public final int getSelectionEnd$ui_text_release() {
        return this.selectionEnd;
    }

    public final int getSelectionStart$ui_text_release() {
        return this.selectionStart;
    }

    public final boolean hasComposition$ui_text_release() {
        return this.compositionStart != -1;
    }

    public final void replace$ui_text_release(int i11, int i12, @NotNull AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        replace$ui_text_release(i11, i12, annotatedString.getText());
    }

    public final void setComposition$ui_text_release(int i11, int i12) {
        if (i11 < 0 || i11 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i11 + ") offset is outside of text region " + this.gapBuffer.getLength());
        } else if (i12 < 0 || i12 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i12 + ") offset is outside of text region " + this.gapBuffer.getLength());
        } else if (i11 < i12) {
            this.compositionStart = i11;
            this.compositionEnd = i12;
        } else {
            throw new IllegalArgumentException("Do not set reversed or empty range: " + i11 + " > " + i12);
        }
    }

    public final void setCursor$ui_text_release(int i11) {
        setSelection$ui_text_release(i11, i11);
    }

    public final void setSelection$ui_text_release(int i11, int i12) {
        if (i11 < 0 || i11 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i11 + ") offset is outside of text region " + this.gapBuffer.getLength());
        } else if (i12 < 0 || i12 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i12 + ") offset is outside of text region " + this.gapBuffer.getLength());
        } else if (i11 <= i12) {
            setSelectionStart(i11);
            setSelectionEnd(i12);
        } else {
            throw new IllegalArgumentException("Do not set reversed range: " + i11 + " > " + i12);
        }
    }

    @NotNull
    public final AnnotatedString toAnnotatedString$ui_text_release() {
        return new AnnotatedString(toString(), (List) null, (List) null, 6, (DefaultConstructorMarker) null);
    }

    @NotNull
    public String toString() {
        return this.gapBuffer.toString();
    }

    public final void replace$ui_text_release(int i11, int i12, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        if (i11 < 0 || i11 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i11 + ") offset is outside of text region " + this.gapBuffer.getLength());
        } else if (i12 < 0 || i12 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i12 + ") offset is outside of text region " + this.gapBuffer.getLength());
        } else if (i11 <= i12) {
            this.gapBuffer.replace(i11, i12, str);
            setSelectionStart(str.length() + i11);
            setSelectionEnd(i11 + str.length());
            this.compositionStart = -1;
            this.compositionEnd = -1;
        } else {
            throw new IllegalArgumentException("Do not set reversed range: " + i11 + " > " + i12);
        }
    }

    private EditingBuffer(String str, long j11) {
        this(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null), j11, (DefaultConstructorMarker) null);
    }
}
