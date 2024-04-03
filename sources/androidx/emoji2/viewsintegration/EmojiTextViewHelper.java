package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;

public final class EmojiTextViewHelper {
    private final HelperInternal mHelper;

    public static class HelperInternal {
        @NonNull
        public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        public void b(boolean z11) {
        }

        public void c(boolean z11) {
        }

        public void d() {
        }

        @Nullable
        public TransformationMethod e(@Nullable TransformationMethod transformationMethod) {
            return transformationMethod;
        }

        public boolean isEnabled() {
            return false;
        }
    }

    @RequiresApi(19)
    public static class HelperInternal19 extends HelperInternal {
        private final EmojiInputFilter mEmojiInputFilter;
        private boolean mEnabled = true;
        private final TextView mTextView;

        public HelperInternal19(TextView textView) {
            this.mTextView = textView;
            this.mEmojiInputFilter = new EmojiInputFilter(textView);
        }

        @NonNull
        private InputFilter[] addEmojiInputFilterIfMissing(@NonNull InputFilter[] inputFilterArr) {
            for (EmojiInputFilter emojiInputFilter : inputFilterArr) {
                if (emojiInputFilter == this.mEmojiInputFilter) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, r0);
            inputFilterArr2[r0] = this.mEmojiInputFilter;
            return inputFilterArr2;
        }

        private SparseArray<InputFilter> getEmojiInputFilterPositionArray(@NonNull InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i11 = 0; i11 < inputFilterArr.length; i11++) {
                InputFilter inputFilter = inputFilterArr[i11];
                if (inputFilter instanceof EmojiInputFilter) {
                    sparseArray.put(i11, inputFilter);
                }
            }
            return sparseArray;
        }

        @NonNull
        private InputFilter[] removeEmojiInputFilterIfPresent(@NonNull InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> emojiInputFilterPositionArray = getEmojiInputFilterPositionArray(inputFilterArr);
            if (emojiInputFilterPositionArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length - emojiInputFilterPositionArray.size())];
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                if (emojiInputFilterPositionArray.indexOfKey(i12) < 0) {
                    inputFilterArr2[i11] = inputFilterArr[i12];
                    i11++;
                }
            }
            return inputFilterArr2;
        }

        @Nullable
        private TransformationMethod unwrapForDisabled(@Nullable TransformationMethod transformationMethod) {
            if (transformationMethod instanceof EmojiTransformationMethod) {
                return ((EmojiTransformationMethod) transformationMethod).getOriginalTransformationMethod();
            }
            return transformationMethod;
        }

        private void updateFilters() {
            this.mTextView.setFilters(a(this.mTextView.getFilters()));
        }

        @NonNull
        private TransformationMethod wrapForEnabled(@Nullable TransformationMethod transformationMethod) {
            if (!(transformationMethod instanceof EmojiTransformationMethod) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                return new EmojiTransformationMethod(transformationMethod);
            }
            return transformationMethod;
        }

        @NonNull
        public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            if (!this.mEnabled) {
                return removeEmojiInputFilterIfPresent(inputFilterArr);
            }
            return addEmojiInputFilterIfMissing(inputFilterArr);
        }

        public void b(boolean z11) {
            if (z11) {
                d();
            }
        }

        public void c(boolean z11) {
            this.mEnabled = z11;
            d();
            updateFilters();
        }

        public void d() {
            this.mTextView.setTransformationMethod(e(this.mTextView.getTransformationMethod()));
        }

        @Nullable
        public TransformationMethod e(@Nullable TransformationMethod transformationMethod) {
            if (this.mEnabled) {
                return wrapForEnabled(transformationMethod);
            }
            return unwrapForDisabled(transformationMethod);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void f(boolean z11) {
            this.mEnabled = z11;
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }
    }

    @RequiresApi(19)
    public static class SkippingHelper19 extends HelperInternal {
        private final HelperInternal19 mHelperDelegate;

        public SkippingHelper19(TextView textView) {
            this.mHelperDelegate = new HelperInternal19(textView);
        }

        private boolean skipBecauseEmojiCompatNotInitialized() {
            return !EmojiCompat.isConfigured();
        }

        @NonNull
        public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            if (skipBecauseEmojiCompatNotInitialized()) {
                return inputFilterArr;
            }
            return this.mHelperDelegate.a(inputFilterArr);
        }

        public void b(boolean z11) {
            if (!skipBecauseEmojiCompatNotInitialized()) {
                this.mHelperDelegate.b(z11);
            }
        }

        public void c(boolean z11) {
            if (skipBecauseEmojiCompatNotInitialized()) {
                this.mHelperDelegate.f(z11);
            } else {
                this.mHelperDelegate.c(z11);
            }
        }

        public void d() {
            if (!skipBecauseEmojiCompatNotInitialized()) {
                this.mHelperDelegate.d();
            }
        }

        @Nullable
        public TransformationMethod e(@Nullable TransformationMethod transformationMethod) {
            if (skipBecauseEmojiCompatNotInitialized()) {
                return transformationMethod;
            }
            return this.mHelperDelegate.e(transformationMethod);
        }

        public boolean isEnabled() {
            return this.mHelperDelegate.isEnabled();
        }
    }

    public EmojiTextViewHelper(@NonNull TextView textView) {
        this(textView, true);
    }

    @NonNull
    public InputFilter[] getFilters(@NonNull InputFilter[] inputFilterArr) {
        return this.mHelper.a(inputFilterArr);
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    public void setAllCaps(boolean z11) {
        this.mHelper.b(z11);
    }

    public void setEnabled(boolean z11) {
        this.mHelper.c(z11);
    }

    public void updateTransformationMethod() {
        this.mHelper.d();
    }

    @Nullable
    public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod transformationMethod) {
        return this.mHelper.e(transformationMethod);
    }

    public EmojiTextViewHelper(@NonNull TextView textView, boolean z11) {
        Preconditions.checkNotNull(textView, "textView cannot be null");
        if (!z11) {
            this.mHelper = new SkippingHelper19(textView);
        } else {
            this.mHelper = new HelperInternal19(textView);
        }
    }
}
