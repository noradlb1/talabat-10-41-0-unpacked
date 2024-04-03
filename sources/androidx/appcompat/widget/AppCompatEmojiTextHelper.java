package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

class AppCompatEmojiTextHelper {
    @NonNull
    private final EmojiTextViewHelper mEmojiTextViewHelper;
    @NonNull
    private final TextView mView;

    public AppCompatEmojiTextHelper(@NonNull TextView textView) {
        this.mView = textView;
        this.mEmojiTextViewHelper = new EmojiTextViewHelper(textView, false);
    }

    @NonNull
    public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
        return this.mEmojiTextViewHelper.getFilters(inputFilterArr);
    }

    /* JADX INFO: finally extract failed */
    public void b(@Nullable AttributeSet attributeSet, int i11) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i11, 0);
        try {
            int i12 = R.styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z11 = true;
            if (obtainStyledAttributes.hasValue(i12)) {
                z11 = obtainStyledAttributes.getBoolean(i12, true);
            }
            obtainStyledAttributes.recycle();
            d(z11);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public void c(boolean z11) {
        this.mEmojiTextViewHelper.setAllCaps(z11);
    }

    public void d(boolean z11) {
        this.mEmojiTextViewHelper.setEnabled(z11);
    }

    public boolean isEnabled() {
        return this.mEmojiTextViewHelper.isEnabled();
    }

    @Nullable
    public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod transformationMethod) {
        return this.mEmojiTextViewHelper.wrapTransformationMethod(transformationMethod);
    }
}
