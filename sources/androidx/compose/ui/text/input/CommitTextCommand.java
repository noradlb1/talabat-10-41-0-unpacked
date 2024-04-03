package androidx.compose.ui.text.input;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/input/CommitTextCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "text", "", "newCursorPosition", "", "(Ljava/lang/String;I)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;I)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getNewCursorPosition", "()I", "getText", "()Ljava/lang/String;", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CommitTextCommand implements EditCommand {
    public static final int $stable = 0;
    @NotNull
    private final AnnotatedString annotatedString;
    private final int newCursorPosition;

    public CommitTextCommand(@NotNull AnnotatedString annotatedString2, int i11) {
        Intrinsics.checkNotNullParameter(annotatedString2, "annotatedString");
        this.annotatedString = annotatedString2;
        this.newCursorPosition = i11;
    }

    public void applyTo(@NotNull EditingBuffer editingBuffer) {
        int i11;
        Intrinsics.checkNotNullParameter(editingBuffer, "buffer");
        if (editingBuffer.hasComposition$ui_text_release()) {
            editingBuffer.replace$ui_text_release(editingBuffer.getCompositionStart$ui_text_release(), editingBuffer.getCompositionEnd$ui_text_release(), getText());
        } else {
            editingBuffer.replace$ui_text_release(editingBuffer.getSelectionStart$ui_text_release(), editingBuffer.getSelectionEnd$ui_text_release(), getText());
        }
        int cursor$ui_text_release = editingBuffer.getCursor$ui_text_release();
        int i12 = this.newCursorPosition;
        if (i12 > 0) {
            i11 = (cursor$ui_text_release + i12) - 1;
        } else {
            i11 = (cursor$ui_text_release + i12) - getText().length();
        }
        editingBuffer.setCursor$ui_text_release(RangesKt___RangesKt.coerceIn(i11, 0, editingBuffer.getLength$ui_text_release()));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommitTextCommand)) {
            return false;
        }
        CommitTextCommand commitTextCommand = (CommitTextCommand) obj;
        if (Intrinsics.areEqual((Object) getText(), (Object) commitTextCommand.getText()) && this.newCursorPosition == commitTextCommand.newCursorPosition) {
            return true;
        }
        return false;
    }

    @NotNull
    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final int getNewCursorPosition() {
        return this.newCursorPosition;
    }

    @NotNull
    public final String getText() {
        return this.annotatedString.getText();
    }

    public int hashCode() {
        return (getText().hashCode() * 31) + this.newCursorPosition;
    }

    @NotNull
    public String toString() {
        return "CommitTextCommand(text='" + getText() + "', newCursorPosition=" + this.newCursorPosition + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CommitTextCommand(@NotNull String str, int i11) {
        this(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null), i11);
        Intrinsics.checkNotNullParameter(str, "text");
    }
}
