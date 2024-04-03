package androidx.compose.ui.text.input;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.compose.ui.text.TextRange;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\u001cH\u0016J\u0012\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\"\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001a\u0010/\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\fH\u0016J\u0018\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\fH\u0016J\u0018\u00105\u001a\u00020\u00072\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\fH\u0016J\b\u00106\u001a\u00020\u0007H\u0016J\b\u00107\u001a\u00020\u0007H\u0002J\u0017\u00108\u001a\u00020\u00072\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001c0:H\bJ\b\u0010;\u001a\u00020\u0007H\u0016J\u0010\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020\fH\u0016J\u001a\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010)\u001a\u00020\fH\u0016J\n\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010D\u001a\u0004\u0018\u0001002\u0006\u0010)\u001a\u00020\fH\u0016J\u0018\u0010E\u001a\u0002002\u0006\u0010F\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0016J\u0018\u0010G\u001a\u0002002\u0006\u0010F\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\fH\u0016J\u0010\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\fH\u0016J\u001c\u0010O\u001a\u00020\u00072\b\u0010P\u001a\u0004\u0018\u00010J2\b\u0010Q\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u0007H\u0016J\u0010\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\fH\u0016J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u00020\u001c2\u0006\u0010Z\u001a\u00020\fH\u0002J\u0018\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\f2\u0006\u0010]\u001a\u00020\fH\u0016J\u001a\u0010^\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\fH\u0016J\u0018\u0010_\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\f2\u0006\u0010]\u001a\u00020\fH\u0016J\u001e\u0010`\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020\u00032\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006f"}, d2 = {"Landroidx/compose/ui/text/input/RecordingInputConnection;", "Landroid/view/inputmethod/InputConnection;", "initState", "Landroidx/compose/ui/text/input/TextFieldValue;", "eventCallback", "Landroidx/compose/ui/text/input/InputEventCallback2;", "autoCorrect", "", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/InputEventCallback2;Z)V", "getAutoCorrect", "()Z", "batchDepth", "", "currentExtractedTextRequestToken", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "getEventCallback", "()Landroidx/compose/ui/text/input/InputEventCallback2;", "extractedTextMonitorMode", "isActive", "value", "mTextFieldValue", "getMTextFieldValue$ui_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setMTextFieldValue$ui_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "addEditCommandWithBatch", "", "editCommand", "beginBatchEdit", "beginBatchEditInternal", "clearMetaKeyStates", "states", "closeConnection", "commitCompletion", "text", "Landroid/view/inputmethod/CompletionInfo;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "flags", "opts", "Landroid/os/Bundle;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "commitText", "", "newCursorPosition", "deleteSurroundingText", "beforeLength", "afterLength", "deleteSurroundingTextInCodePoints", "endBatchEdit", "endBatchEditInternal", "ensureActive", "block", "Lkotlin/Function0;", "finishComposingText", "getCursorCapsMode", "reqModes", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "getHandler", "Landroid/os/Handler;", "getSelectedText", "getTextAfterCursor", "maxChars", "getTextBeforeCursor", "logDebug", "message", "", "performContextMenuAction", "id", "performEditorAction", "editorAction", "performPrivateCommand", "action", "data", "reportFullscreenMode", "enabled", "requestCursorUpdates", "cursorUpdateMode", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "sendSynthesizedKeyEvent", "code", "setComposingRegion", "start", "end", "setComposingText", "setSelection", "updateInputState", "state", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RecordingInputConnection implements InputConnection {
    private final boolean autoCorrect;
    private int batchDepth;
    private int currentExtractedTextRequestToken;
    @NotNull
    private final List<EditCommand> editCommands = new ArrayList();
    @NotNull
    private final InputEventCallback2 eventCallback;
    private boolean extractedTextMonitorMode;
    private boolean isActive = true;
    @NotNull
    private TextFieldValue mTextFieldValue;

    public RecordingInputConnection(@NotNull TextFieldValue textFieldValue, @NotNull InputEventCallback2 inputEventCallback2, boolean z11) {
        Intrinsics.checkNotNullParameter(textFieldValue, "initState");
        Intrinsics.checkNotNullParameter(inputEventCallback2, "eventCallback");
        this.eventCallback = inputEventCallback2;
        this.autoCorrect = z11;
        this.mTextFieldValue = textFieldValue;
    }

    private final void addEditCommandWithBatch(EditCommand editCommand) {
        beginBatchEditInternal();
        try {
            this.editCommands.add(editCommand);
        } finally {
            endBatchEditInternal();
        }
    }

    private final boolean beginBatchEditInternal() {
        this.batchDepth++;
        return true;
    }

    private final boolean endBatchEditInternal() {
        int i11 = this.batchDepth - 1;
        this.batchDepth = i11;
        if (i11 == 0 && (!this.editCommands.isEmpty())) {
            this.eventCallback.onEditCommands(CollectionsKt___CollectionsKt.toMutableList(this.editCommands));
            this.editCommands.clear();
        }
        if (this.batchDepth > 0) {
            return true;
        }
        return false;
    }

    private final boolean ensureActive(Function0<Unit> function0) {
        boolean z11 = this.isActive;
        if (z11) {
            function0.invoke();
        }
        return z11;
    }

    private final void logDebug(String str) {
    }

    private final void sendSynthesizedKeyEvent(int i11) {
        sendKeyEvent(new KeyEvent(0, i11));
        sendKeyEvent(new KeyEvent(1, i11));
    }

    public boolean beginBatchEdit() {
        boolean z11 = this.isActive;
        if (z11) {
            return beginBatchEditInternal();
        }
        return z11;
    }

    public boolean clearMetaKeyStates(int i11) {
        boolean z11 = this.isActive;
        if (z11) {
            return false;
        }
        return z11;
    }

    public void closeConnection() {
        this.editCommands.clear();
        this.batchDepth = 0;
        this.isActive = false;
        this.eventCallback.onConnectionClosed(this);
    }

    public boolean commitCompletion(@Nullable CompletionInfo completionInfo) {
        boolean z11 = this.isActive;
        if (z11) {
            return false;
        }
        return z11;
    }

    public boolean commitContent(@NotNull InputContentInfo inputContentInfo, int i11, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inputContentInfo, "inputContentInfo");
        boolean z11 = this.isActive;
        if (z11) {
            return false;
        }
        return z11;
    }

    public boolean commitCorrection(@Nullable CorrectionInfo correctionInfo) {
        boolean z11 = this.isActive;
        if (z11) {
            return this.autoCorrect;
        }
        return z11;
    }

    public boolean commitText(@Nullable CharSequence charSequence, int i11) {
        boolean z11 = this.isActive;
        if (z11) {
            addEditCommandWithBatch(new CommitTextCommand(String.valueOf(charSequence), i11));
        }
        return z11;
    }

    public boolean deleteSurroundingText(int i11, int i12) {
        boolean z11 = this.isActive;
        if (!z11) {
            return z11;
        }
        addEditCommandWithBatch(new DeleteSurroundingTextCommand(i11, i12));
        return true;
    }

    public boolean deleteSurroundingTextInCodePoints(int i11, int i12) {
        boolean z11 = this.isActive;
        if (!z11) {
            return z11;
        }
        addEditCommandWithBatch(new DeleteSurroundingTextInCodePointsCommand(i11, i12));
        return true;
    }

    public boolean endBatchEdit() {
        return endBatchEditInternal();
    }

    public boolean finishComposingText() {
        boolean z11 = this.isActive;
        if (!z11) {
            return z11;
        }
        addEditCommandWithBatch(new FinishComposingTextCommand());
        return true;
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    public int getCursorCapsMode(int i11) {
        return TextUtils.getCapsMode(this.mTextFieldValue.getText(), TextRange.m5036getMinimpl(this.mTextFieldValue.m5234getSelectiond9O1mEE()), i11);
    }

    @NotNull
    public final InputEventCallback2 getEventCallback() {
        return this.eventCallback;
    }

    @NotNull
    public ExtractedText getExtractedText(@Nullable ExtractedTextRequest extractedTextRequest, int i11) {
        boolean z11 = true;
        int i12 = 0;
        if ((i11 & 1) == 0) {
            z11 = false;
        }
        this.extractedTextMonitorMode = z11;
        if (z11) {
            if (extractedTextRequest != null) {
                i12 = extractedTextRequest.token;
            }
            this.currentExtractedTextRequestToken = i12;
        }
        return InputState_androidKt.toExtractedText(this.mTextFieldValue);
    }

    @Nullable
    public Handler getHandler() {
        return null;
    }

    @NotNull
    public final TextFieldValue getMTextFieldValue$ui_release() {
        return this.mTextFieldValue;
    }

    @Nullable
    public CharSequence getSelectedText(int i11) {
        if (TextRange.m5032getCollapsedimpl(this.mTextFieldValue.m5234getSelectiond9O1mEE())) {
            return null;
        }
        return TextFieldValueKt.getSelectedText(this.mTextFieldValue).toString();
    }

    @NotNull
    public CharSequence getTextAfterCursor(int i11, int i12) {
        return TextFieldValueKt.getTextAfterSelection(this.mTextFieldValue, i11).toString();
    }

    @NotNull
    public CharSequence getTextBeforeCursor(int i11, int i12) {
        return TextFieldValueKt.getTextBeforeSelection(this.mTextFieldValue, i11).toString();
    }

    public boolean performContextMenuAction(int i11) {
        boolean z11 = this.isActive;
        if (z11) {
            z11 = false;
            switch (i11) {
                case 16908319:
                    addEditCommandWithBatch(new SetSelectionCommand(0, this.mTextFieldValue.getText().length()));
                    break;
                case 16908320:
                    sendSynthesizedKeyEvent(277);
                    break;
                case 16908321:
                    sendSynthesizedKeyEvent(278);
                    break;
                case 16908322:
                    sendSynthesizedKeyEvent(279);
                    break;
            }
        }
        return z11;
    }

    public boolean performEditorAction(int i11) {
        int i12;
        boolean z11 = this.isActive;
        if (!z11) {
            return z11;
        }
        if (i11 != 0) {
            switch (i11) {
                case 2:
                    i12 = ImeAction.Companion.m5189getGoeUduSuo();
                    break;
                case 3:
                    i12 = ImeAction.Companion.m5193getSearcheUduSuo();
                    break;
                case 4:
                    i12 = ImeAction.Companion.m5194getSendeUduSuo();
                    break;
                case 5:
                    i12 = ImeAction.Companion.m5190getNexteUduSuo();
                    break;
                case 6:
                    i12 = ImeAction.Companion.m5188getDoneeUduSuo();
                    break;
                case 7:
                    i12 = ImeAction.Companion.m5192getPreviouseUduSuo();
                    break;
                default:
                    Log.w(RecordingInputConnection_androidKt.TAG, "IME sends unsupported Editor Action: " + i11);
                    i12 = ImeAction.Companion.m5187getDefaulteUduSuo();
                    break;
            }
        } else {
            i12 = ImeAction.Companion.m5187getDefaulteUduSuo();
        }
        this.eventCallback.m5201onImeActionKlQnJC8(i12);
        return true;
    }

    public boolean performPrivateCommand(@Nullable String str, @Nullable Bundle bundle) {
        boolean z11 = this.isActive;
        if (z11) {
            return true;
        }
        return z11;
    }

    public boolean reportFullscreenMode(boolean z11) {
        return false;
    }

    public boolean requestCursorUpdates(int i11) {
        boolean z11 = this.isActive;
        if (!z11) {
            return z11;
        }
        Log.w(RecordingInputConnection_androidKt.TAG, "requestCursorUpdates is not supported");
        return false;
    }

    public boolean sendKeyEvent(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        boolean z11 = this.isActive;
        if (!z11) {
            return z11;
        }
        this.eventCallback.onKeyEvent(keyEvent);
        return true;
    }

    public boolean setComposingRegion(int i11, int i12) {
        boolean z11 = this.isActive;
        if (z11) {
            addEditCommandWithBatch(new SetComposingRegionCommand(i11, i12));
        }
        return z11;
    }

    public boolean setComposingText(@Nullable CharSequence charSequence, int i11) {
        boolean z11 = this.isActive;
        if (z11) {
            addEditCommandWithBatch(new SetComposingTextCommand(String.valueOf(charSequence), i11));
        }
        return z11;
    }

    public final void setMTextFieldValue$ui_release(@NotNull TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        this.mTextFieldValue = textFieldValue;
    }

    public boolean setSelection(int i11, int i12) {
        boolean z11 = this.isActive;
        if (!z11) {
            return z11;
        }
        addEditCommandWithBatch(new SetSelectionCommand(i11, i12));
        return true;
    }

    public final void updateInputState(@NotNull TextFieldValue textFieldValue, @NotNull InputMethodManager inputMethodManager, @NotNull View view) {
        int i11;
        Intrinsics.checkNotNullParameter(textFieldValue, "state");
        Intrinsics.checkNotNullParameter(inputMethodManager, "inputMethodManager");
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.isActive) {
            setMTextFieldValue$ui_release(textFieldValue);
            if (this.extractedTextMonitorMode) {
                inputMethodManager.updateExtractedText(view, this.currentExtractedTextRequestToken, InputState_androidKt.toExtractedText(textFieldValue));
            }
            TextRange r02 = textFieldValue.m5233getCompositionMzsxiRA();
            int i12 = -1;
            if (r02 != null) {
                i11 = TextRange.m5036getMinimpl(r02.m5042unboximpl());
            } else {
                i11 = -1;
            }
            TextRange r03 = textFieldValue.m5233getCompositionMzsxiRA();
            if (r03 != null) {
                i12 = TextRange.m5035getMaximpl(r03.m5042unboximpl());
            }
            inputMethodManager.updateSelection(view, TextRange.m5036getMinimpl(textFieldValue.m5234getSelectiond9O1mEE()), TextRange.m5035getMaximpl(textFieldValue.m5234getSelectiond9O1mEE()), i11, i12);
        }
    }
}
