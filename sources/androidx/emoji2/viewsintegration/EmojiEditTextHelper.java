package androidx.emoji2.viewsintegration;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

public final class EmojiEditTextHelper {
    private int mEmojiReplaceStrategy;
    private final HelperInternal mHelper;
    private int mMaxEmojiCount;

    public static class HelperInternal {
        @Nullable
        public KeyListener a(@Nullable KeyListener keyListener) {
            return keyListener;
        }

        public boolean b() {
            return false;
        }

        public InputConnection c(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            return inputConnection;
        }

        public void d(int i11) {
        }

        public void e(boolean z11) {
        }

        public void f(int i11) {
        }
    }

    @RequiresApi(19)
    public static class HelperInternal19 extends HelperInternal {
        private final EditText mEditText;
        private final EmojiTextWatcher mTextWatcher;

        public HelperInternal19(@NonNull EditText editText, boolean z11) {
            this.mEditText = editText;
            EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText, z11);
            this.mTextWatcher = emojiTextWatcher;
            editText.addTextChangedListener(emojiTextWatcher);
            editText.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        public KeyListener a(@Nullable KeyListener keyListener) {
            if (keyListener instanceof EmojiKeyListener) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            if (keyListener instanceof NumberKeyListener) {
                return keyListener;
            }
            return new EmojiKeyListener(keyListener);
        }

        public boolean b() {
            return this.mTextWatcher.isEnabled();
        }

        public InputConnection c(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            if (inputConnection instanceof EmojiInputConnection) {
                return inputConnection;
            }
            return new EmojiInputConnection(this.mEditText, inputConnection, editorInfo);
        }

        public void d(int i11) {
            this.mTextWatcher.b(i11);
        }

        public void e(boolean z11) {
            this.mTextWatcher.setEnabled(z11);
        }

        public void f(int i11) {
            this.mTextWatcher.c(i11);
        }
    }

    public EmojiEditTextHelper(@NonNull EditText editText) {
        this(editText, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    @Nullable
    public KeyListener getKeyListener(@Nullable KeyListener keyListener) {
        return this.mHelper.a(keyListener);
    }

    public int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    public boolean isEnabled() {
        return this.mHelper.b();
    }

    @Nullable
    public InputConnection onCreateInputConnection(@Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.mHelper.c(inputConnection, editorInfo);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEmojiReplaceStrategy(int i11) {
        this.mEmojiReplaceStrategy = i11;
        this.mHelper.d(i11);
    }

    public void setEnabled(boolean z11) {
        this.mHelper.e(z11);
    }

    public void setMaxEmojiCount(@IntRange(from = 0) int i11) {
        Preconditions.checkArgumentNonnegative(i11, "maxEmojiCount should be greater than 0");
        this.mMaxEmojiCount = i11;
        this.mHelper.f(i11);
    }

    public EmojiEditTextHelper(@NonNull EditText editText, boolean z11) {
        this.mMaxEmojiCount = Integer.MAX_VALUE;
        this.mEmojiReplaceStrategy = 0;
        Preconditions.checkNotNull(editText, "editText cannot be null");
        this.mHelper = new HelperInternal19(editText, z11);
    }
}
