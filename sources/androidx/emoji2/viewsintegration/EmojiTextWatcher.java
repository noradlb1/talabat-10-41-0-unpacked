package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiTextWatcher implements TextWatcher {
    private final EditText mEditText;
    private int mEmojiReplaceStrategy = 0;
    private boolean mEnabled;
    private final boolean mExpectInitializedEmojiCompat;
    private EmojiCompat.InitCallback mInitCallback;
    private int mMaxEmojiCount = Integer.MAX_VALUE;

    @RequiresApi(19)
    public static class InitCallbackImpl extends EmojiCompat.InitCallback {
        private final Reference<EditText> mViewRef;

        public InitCallbackImpl(EditText editText) {
            this.mViewRef = new WeakReference(editText);
        }

        public void onInitialized() {
            super.onInitialized();
            EmojiTextWatcher.a(this.mViewRef.get(), 1);
        }
    }

    public EmojiTextWatcher(EditText editText, boolean z11) {
        this.mEditText = editText;
        this.mExpectInitializedEmojiCompat = z11;
        this.mEnabled = true;
    }

    public static void a(@Nullable EditText editText, int i11) {
        if (i11 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.get().process(editableText);
            EmojiInputFilter.a(editableText, selectionStart, selectionEnd);
        }
    }

    private EmojiCompat.InitCallback getInitCallback() {
        if (this.mInitCallback == null) {
            this.mInitCallback = new InitCallbackImpl(this.mEditText);
        }
        return this.mInitCallback;
    }

    private boolean shouldSkipForDisabledOrNotConfigured() {
        return !this.mEnabled || (!this.mExpectInitializedEmojiCompat && !EmojiCompat.isConfigured());
    }

    public void afterTextChanged(Editable editable) {
    }

    public void b(int i11) {
        this.mEmojiReplaceStrategy = i11;
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void c(int i11) {
        this.mMaxEmojiCount = i11;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        if (!this.mEditText.isInEditMode() && !shouldSkipForDisabledOrNotConfigured() && i12 <= i13 && (charSequence instanceof Spannable)) {
            int loadState = EmojiCompat.get().getLoadState();
            if (loadState != 0) {
                if (loadState == 1) {
                    EmojiCompat.get().process((Spannable) charSequence, i11, i11 + i13, this.mMaxEmojiCount, this.mEmojiReplaceStrategy);
                    return;
                } else if (loadState != 3) {
                    return;
                }
            }
            EmojiCompat.get().registerInitCallback(getInitCallback());
        }
    }

    public void setEnabled(boolean z11) {
        if (this.mEnabled != z11) {
            if (this.mInitCallback != null) {
                EmojiCompat.get().unregisterInitCallback(this.mInitCallback);
            }
            this.mEnabled = z11;
            if (z11) {
                a(this.mEditText, EmojiCompat.get().getLoadState());
            }
        }
    }
}
