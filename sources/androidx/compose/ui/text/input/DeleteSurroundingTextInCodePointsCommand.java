package androidx.compose.ui.text.input;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/input/DeleteSurroundingTextInCodePointsCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "lengthBeforeCursor", "", "lengthAfterCursor", "(II)V", "getLengthAfterCursor", "()I", "getLengthBeforeCursor", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DeleteSurroundingTextInCodePointsCommand implements EditCommand {
    public static final int $stable = 0;
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;

    public DeleteSurroundingTextInCodePointsCommand(int i11, int i12) {
        boolean z11;
        this.lengthBeforeCursor = i11;
        this.lengthAfterCursor = i12;
        if (i11 < 0 || i12 < 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            throw new IllegalArgumentException(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i11 + " and " + i12 + " respectively.").toString());
        }
    }

    public void applyTo(@NotNull EditingBuffer editingBuffer) {
        Intrinsics.checkNotNullParameter(editingBuffer, "buffer");
        int i11 = this.lengthBeforeCursor;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12++;
            if (editingBuffer.getSelectionStart$ui_text_release() > i12 && EditCommandKt.isSurrogatePair(editingBuffer.get$ui_text_release((editingBuffer.getSelectionStart$ui_text_release() - i12) - 1), editingBuffer.get$ui_text_release(editingBuffer.getSelectionStart$ui_text_release() - i12))) {
                i12++;
            }
            if (i12 == editingBuffer.getSelectionStart$ui_text_release()) {
                break;
            }
        }
        int i14 = this.lengthAfterCursor;
        int i15 = 0;
        for (int i16 = 0; i16 < i14; i16++) {
            i15++;
            if (editingBuffer.getSelectionEnd$ui_text_release() + i15 < editingBuffer.getLength$ui_text_release() && EditCommandKt.isSurrogatePair(editingBuffer.get$ui_text_release((editingBuffer.getSelectionEnd$ui_text_release() + i15) - 1), editingBuffer.get$ui_text_release(editingBuffer.getSelectionEnd$ui_text_release() + i15))) {
                i15++;
            }
            if (editingBuffer.getSelectionEnd$ui_text_release() + i15 == editingBuffer.getLength$ui_text_release()) {
                break;
            }
        }
        editingBuffer.delete$ui_text_release(editingBuffer.getSelectionEnd$ui_text_release(), editingBuffer.getSelectionEnd$ui_text_release() + i15);
        editingBuffer.delete$ui_text_release(editingBuffer.getSelectionStart$ui_text_release() - i12, editingBuffer.getSelectionStart$ui_text_release());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteSurroundingTextInCodePointsCommand)) {
            return false;
        }
        DeleteSurroundingTextInCodePointsCommand deleteSurroundingTextInCodePointsCommand = (DeleteSurroundingTextInCodePointsCommand) obj;
        if (this.lengthBeforeCursor == deleteSurroundingTextInCodePointsCommand.lengthBeforeCursor && this.lengthAfterCursor == deleteSurroundingTextInCodePointsCommand.lengthAfterCursor) {
            return true;
        }
        return false;
    }

    public final int getLengthAfterCursor() {
        return this.lengthAfterCursor;
    }

    public final int getLengthBeforeCursor() {
        return this.lengthBeforeCursor;
    }

    public int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    @NotNull
    public String toString() {
        return "DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=" + this.lengthBeforeCursor + ", lengthAfterCursor=" + this.lengthAfterCursor + ')';
    }
}
