package androidx.compose.ui.text.input;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.JvmCharHelpers_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/input/MoveCursorCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "amount", "", "(I)V", "getAmount", "()I", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MoveCursorCommand implements EditCommand {
    public static final int $stable = 0;
    private final int amount;

    public MoveCursorCommand(int i11) {
        this.amount = i11;
    }

    public void applyTo(@NotNull EditingBuffer editingBuffer) {
        Intrinsics.checkNotNullParameter(editingBuffer, "buffer");
        if (editingBuffer.getCursor$ui_text_release() == -1) {
            editingBuffer.setCursor$ui_text_release(editingBuffer.getSelectionStart$ui_text_release());
        }
        int selectionStart$ui_text_release = editingBuffer.getSelectionStart$ui_text_release();
        String editingBuffer2 = editingBuffer.toString();
        int i11 = this.amount;
        int i12 = 0;
        if (i11 <= 0) {
            int i13 = -i11;
            while (i12 < i13) {
                int findPrecedingBreak = JvmCharHelpers_androidKt.findPrecedingBreak(editingBuffer2, selectionStart$ui_text_release);
                if (findPrecedingBreak == -1) {
                    break;
                }
                i12++;
                selectionStart$ui_text_release = findPrecedingBreak;
            }
        } else {
            while (i12 < i11) {
                int findFollowingBreak = JvmCharHelpers_androidKt.findFollowingBreak(editingBuffer2, selectionStart$ui_text_release);
                if (findFollowingBreak == -1) {
                    break;
                }
                i12++;
                selectionStart$ui_text_release = findFollowingBreak;
            }
        }
        editingBuffer.setCursor$ui_text_release(selectionStart$ui_text_release);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof MoveCursorCommand) && this.amount == ((MoveCursorCommand) obj).amount) {
            return true;
        }
        return false;
    }

    public final int getAmount() {
        return this.amount;
    }

    public int hashCode() {
        return this.amount;
    }

    @NotNull
    public String toString() {
        return "MoveCursorCommand(amount=" + this.amount + ')';
    }
}
