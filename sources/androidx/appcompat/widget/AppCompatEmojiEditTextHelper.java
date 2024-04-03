package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

class AppCompatEmojiEditTextHelper {
    @NonNull
    private final EmojiEditTextHelper mEmojiEditTextHelper;
    @NonNull
    private final EditText mView;

    public AppCompatEmojiEditTextHelper(@NonNull EditText editText) {
        this.mView = editText;
        this.mEmojiEditTextHelper = new EmojiEditTextHelper(editText, false);
    }

    @Nullable
    public KeyListener a(@Nullable KeyListener keyListener) {
        if (b(keyListener)) {
            return this.mEmojiEditTextHelper.getKeyListener(keyListener);
        }
        return keyListener;
    }

    public boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    public boolean c() {
        return this.mEmojiEditTextHelper.isEnabled();
    }

    /* JADX INFO: finally extract failed */
    public void d(@Nullable AttributeSet attributeSet, int i11) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i11, 0);
        try {
            int i12 = R.styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z11 = true;
            if (obtainStyledAttributes.hasValue(i12)) {
                z11 = obtainStyledAttributes.getBoolean(i12, true);
            }
            obtainStyledAttributes.recycle();
            f(z11);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Nullable
    public InputConnection e(@Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        return this.mEmojiEditTextHelper.onCreateInputConnection(inputConnection, editorInfo);
    }

    public void f(boolean z11) {
        this.mEmojiEditTextHelper.setEnabled(z11);
    }
}
