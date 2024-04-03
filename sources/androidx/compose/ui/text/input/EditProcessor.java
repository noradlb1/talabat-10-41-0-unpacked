package androidx.compose.ui.text.input;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ \u0010\u0010\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u0018\u001a\u00020\bJ\f\u0010\u0019\u001a\u00020\u0011*\u00020\u000fH\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/input/EditProcessor;", "", "()V", "<set-?>", "Landroidx/compose/ui/text/input/EditingBuffer;", "mBuffer", "getMBuffer$ui_text_release", "()Landroidx/compose/ui/text/input/EditingBuffer;", "Landroidx/compose/ui/text/input/TextFieldValue;", "mBufferState", "getMBufferState$ui_text_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "apply", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "generateBatchErrorMessage", "", "failedCommand", "reset", "", "value", "textInputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "toTextFieldValue", "toStringForLog", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EditProcessor {
    public static final int $stable = 8;
    @NotNull
    private EditingBuffer mBuffer = new EditingBuffer(this.mBufferState.getAnnotatedString(), this.mBufferState.m5234getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
    @NotNull
    private TextFieldValue mBufferState = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.Companion.m5043getZerod9O1mEE(), (TextRange) null, (DefaultConstructorMarker) null);

    private final String generateBatchErrorMessage(List<? extends EditCommand> list, EditCommand editCommand) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Error while applying EditCommand batch to buffer (length=" + this.mBuffer.getLength$ui_text_release() + ", composition=" + this.mBuffer.m5177getCompositionMzsxiRA$ui_text_release() + ", selection=" + TextRange.m5041toStringimpl(this.mBuffer.m5178getSelectiond9O1mEE$ui_text_release()) + "):");
        Intrinsics.checkNotNullExpressionValue(sb2, "append(value)");
        sb2.append(10);
        Intrinsics.checkNotNullExpressionValue(sb2, "append('\\n')");
        Appendable unused = CollectionsKt___CollectionsKt.joinTo$default(list, sb2, StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new EditProcessor$generateBatchErrorMessage$1$1(editCommand, this), 60, (Object) null);
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    /* access modifiers changed from: private */
    public final String toStringForLog(EditCommand editCommand) {
        if (editCommand instanceof CommitTextCommand) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CommitTextCommand(text.length=");
            CommitTextCommand commitTextCommand = (CommitTextCommand) editCommand;
            sb2.append(commitTextCommand.getText().length());
            sb2.append(", newCursorPosition=");
            sb2.append(commitTextCommand.getNewCursorPosition());
            sb2.append(')');
            return sb2.toString();
        } else if (editCommand instanceof SetComposingTextCommand) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("SetComposingTextCommand(text.length=");
            SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) editCommand;
            sb3.append(setComposingTextCommand.getText().length());
            sb3.append(", newCursorPosition=");
            sb3.append(setComposingTextCommand.getNewCursorPosition());
            sb3.append(')');
            return sb3.toString();
        } else if (editCommand instanceof SetComposingRegionCommand) {
            return editCommand.toString();
        } else {
            if (editCommand instanceof DeleteSurroundingTextCommand) {
                return editCommand.toString();
            }
            if (editCommand instanceof DeleteSurroundingTextInCodePointsCommand) {
                return editCommand.toString();
            }
            if (editCommand instanceof SetSelectionCommand) {
                return editCommand.toString();
            }
            if (editCommand instanceof FinishComposingTextCommand) {
                return editCommand.toString();
            }
            if (editCommand instanceof BackspaceCommand) {
                return editCommand.toString();
            }
            if (editCommand instanceof MoveCursorCommand) {
                return editCommand.toString();
            }
            if (editCommand instanceof DeleteAllCommand) {
                return editCommand.toString();
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Unknown EditCommand: ");
            String simpleName = Reflection.getOrCreateKotlinClass(editCommand.getClass()).getSimpleName();
            if (simpleName == null) {
                simpleName = "{anonymous EditCommand}";
            }
            sb4.append(simpleName);
            return sb4.toString();
        }
    }

    @NotNull
    public final TextFieldValue apply(@NotNull List<? extends EditCommand> list) {
        EditCommand editCommand;
        Exception e11;
        Intrinsics.checkNotNullParameter(list, "editCommands");
        try {
            int size = list.size();
            int i11 = 0;
            while (i11 < size) {
                editCommand = (EditCommand) list.get(i11);
                try {
                    editCommand.applyTo(this.mBuffer);
                    i11++;
                    EditCommand editCommand2 = editCommand;
                } catch (Exception e12) {
                    e11 = e12;
                    throw new RuntimeException(generateBatchErrorMessage(list, editCommand), e11);
                }
            }
            TextFieldValue textFieldValue = new TextFieldValue(this.mBuffer.toAnnotatedString$ui_text_release(), this.mBuffer.m5178getSelectiond9O1mEE$ui_text_release(), this.mBuffer.m5177getCompositionMzsxiRA$ui_text_release(), (DefaultConstructorMarker) null);
            this.mBufferState = textFieldValue;
            return textFieldValue;
        } catch (Exception e13) {
            editCommand = null;
            e11 = e13;
            throw new RuntimeException(generateBatchErrorMessage(list, editCommand), e11);
        }
    }

    @NotNull
    public final EditingBuffer getMBuffer$ui_text_release() {
        return this.mBuffer;
    }

    @NotNull
    public final TextFieldValue getMBufferState$ui_text_release() {
        return this.mBufferState;
    }

    public final void reset(@NotNull TextFieldValue textFieldValue, @Nullable TextInputSession textInputSession) {
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        boolean z11 = true;
        boolean z12 = !Intrinsics.areEqual((Object) textFieldValue.m5233getCompositionMzsxiRA(), (Object) this.mBuffer.m5177getCompositionMzsxiRA$ui_text_release());
        boolean z13 = false;
        if (!Intrinsics.areEqual((Object) this.mBufferState.getAnnotatedString(), (Object) textFieldValue.getAnnotatedString())) {
            this.mBuffer = new EditingBuffer(textFieldValue.getAnnotatedString(), textFieldValue.m5234getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
        } else if (!TextRange.m5031equalsimpl0(this.mBufferState.m5234getSelectiond9O1mEE(), textFieldValue.m5234getSelectiond9O1mEE())) {
            this.mBuffer.setSelection$ui_text_release(TextRange.m5036getMinimpl(textFieldValue.m5234getSelectiond9O1mEE()), TextRange.m5035getMaximpl(textFieldValue.m5234getSelectiond9O1mEE()));
            z13 = true;
            z11 = false;
        } else {
            z11 = false;
        }
        if (textFieldValue.m5233getCompositionMzsxiRA() == null) {
            this.mBuffer.commitComposition$ui_text_release();
        } else if (!TextRange.m5032getCollapsedimpl(textFieldValue.m5233getCompositionMzsxiRA().m5042unboximpl())) {
            this.mBuffer.setComposition$ui_text_release(TextRange.m5036getMinimpl(textFieldValue.m5233getCompositionMzsxiRA().m5042unboximpl()), TextRange.m5035getMaximpl(textFieldValue.m5233getCompositionMzsxiRA().m5042unboximpl()));
        }
        if (z11 || (!z13 && z12)) {
            this.mBuffer.commitComposition$ui_text_release();
            textFieldValue = TextFieldValue.m5229copy3r_uNRQ$default(textFieldValue, (AnnotatedString) null, 0, (TextRange) null, 3, (Object) null);
        }
        TextFieldValue textFieldValue2 = this.mBufferState;
        this.mBufferState = textFieldValue;
        if (textInputSession != null) {
            textInputSession.updateState(textFieldValue2, textFieldValue);
        }
    }

    @NotNull
    public final TextFieldValue toTextFieldValue() {
        return this.mBufferState;
    }
}
