package androidx.compose.ui.text.input;

import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"DEBUG_CLASS", "", "hasFlag", "", "bits", "", "flag", "update", "", "Landroid/view/inputmethod/EditorInfo;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextInputServiceAndroid_androidKt {
    @NotNull
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    private static final boolean hasFlag(int i11, int i12) {
        return (i11 & i12) == i12;
    }

    public static final void update(@NotNull EditorInfo editorInfo, @NotNull ImeOptions imeOptions, @NotNull TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(editorInfo, "<this>");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        int r02 = imeOptions.m5198getImeActioneUduSuo();
        ImeAction.Companion companion = ImeAction.Companion;
        int i11 = 6;
        if (ImeAction.m5183equalsimpl0(r02, companion.m5187getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i11 = 0;
            }
        } else if (ImeAction.m5183equalsimpl0(r02, companion.m5191getNoneeUduSuo())) {
            i11 = 1;
        } else if (ImeAction.m5183equalsimpl0(r02, companion.m5189getGoeUduSuo())) {
            i11 = 2;
        } else if (ImeAction.m5183equalsimpl0(r02, companion.m5190getNexteUduSuo())) {
            i11 = 5;
        } else if (ImeAction.m5183equalsimpl0(r02, companion.m5192getPreviouseUduSuo())) {
            i11 = 7;
        } else if (ImeAction.m5183equalsimpl0(r02, companion.m5193getSearcheUduSuo())) {
            i11 = 3;
        } else if (ImeAction.m5183equalsimpl0(r02, companion.m5194getSendeUduSuo())) {
            i11 = 4;
        } else if (!ImeAction.m5183equalsimpl0(r02, companion.m5188getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i11;
        int r03 = imeOptions.m5199getKeyboardTypePjHm6EE();
        KeyboardType.Companion companion2 = KeyboardType.Companion;
        if (KeyboardType.m5216equalsimpl0(r03, companion2.m5227getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m5216equalsimpl0(r03, companion2.m5220getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m5216equalsimpl0(r03, companion2.m5223getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m5216equalsimpl0(r03, companion2.m5226getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m5216equalsimpl0(r03, companion2.m5228getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m5216equalsimpl0(r03, companion2.m5222getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m5216equalsimpl0(r03, companion2.m5225getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m5216equalsimpl0(r03, companion2.m5224getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else if (KeyboardType.m5216equalsimpl0(r03, companion2.m5221getDecimalPjHm6EE())) {
            editorInfo.inputType = 8194;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type".toString());
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m5183equalsimpl0(imeOptions.m5198getImeActioneUduSuo(), companion.m5187getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int r04 = imeOptions.m5197getCapitalizationIUNYP9k();
            KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.Companion;
            if (KeyboardCapitalization.m5205equalsimpl0(r04, companion3.m5209getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m5205equalsimpl0(r04, companion3.m5212getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m5205equalsimpl0(r04, companion3.m5211getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m5038getStartimpl(textFieldValue.m5234getSelectiond9O1mEE());
        editorInfo.initialSelEnd = TextRange.m5033getEndimpl(textFieldValue.m5234getSelectiond9O1mEE());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }
}
