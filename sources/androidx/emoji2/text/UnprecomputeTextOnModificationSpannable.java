package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.text.PrecomputedTextCompat;
import j$.util.stream.IntStream;

class UnprecomputeTextOnModificationSpannable implements Spannable {
    @NonNull
    private Spannable mDelegate;
    private boolean mSafeToWrite = false;

    @RequiresApi(24)
    public static class CharSequenceHelper_API24 {
        private CharSequenceHelper_API24() {
        }

        public static IntStream a(CharSequence charSequence) {
            return IntStream.VivifiedWrapper.convert(charSequence.chars());
        }

        public static IntStream b(CharSequence charSequence) {
            return IntStream.VivifiedWrapper.convert(charSequence.codePoints());
        }
    }

    public static class PrecomputedTextDetector {
        public boolean a(CharSequence charSequence) {
            return charSequence instanceof PrecomputedTextCompat;
        }
    }

    @RequiresApi(28)
    public static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        public boolean a(CharSequence charSequence) {
            return (charSequence instanceof PrecomputedText) || (charSequence instanceof PrecomputedTextCompat);
        }
    }

    public UnprecomputeTextOnModificationSpannable(@NonNull Spannable spannable) {
        this.mDelegate = spannable;
    }

    public static PrecomputedTextDetector b() {
        if (Build.VERSION.SDK_INT < 28) {
            return new PrecomputedTextDetector();
        }
        return new PrecomputedTextDetector_28();
    }

    private void ensureSafeWrites() {
        Spannable spannable = this.mDelegate;
        if (!this.mSafeToWrite && b().a(spannable)) {
            this.mDelegate = new SpannableString(spannable);
        }
        this.mSafeToWrite = true;
    }

    public Spannable a() {
        return this.mDelegate;
    }

    public char charAt(int i11) {
        return this.mDelegate.charAt(i11);
    }

    @RequiresApi(api = 24)
    @NonNull
    public IntStream chars() {
        return CharSequenceHelper_API24.a(this.mDelegate);
    }

    @RequiresApi(api = 24)
    @NonNull
    public IntStream codePoints() {
        return CharSequenceHelper_API24.b(this.mDelegate);
    }

    public int getSpanEnd(Object obj) {
        return this.mDelegate.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.mDelegate.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.mDelegate.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i11, int i12, Class<T> cls) {
        return this.mDelegate.getSpans(i11, i12, cls);
    }

    public int length() {
        return this.mDelegate.length();
    }

    public int nextSpanTransition(int i11, int i12, Class cls) {
        return this.mDelegate.nextSpanTransition(i11, i12, cls);
    }

    public void removeSpan(Object obj) {
        ensureSafeWrites();
        this.mDelegate.removeSpan(obj);
    }

    public void setSpan(Object obj, int i11, int i12, int i13) {
        ensureSafeWrites();
        this.mDelegate.setSpan(obj, i11, i12, i13);
    }

    @NonNull
    public CharSequence subSequence(int i11, int i12) {
        return this.mDelegate.subSequence(i11, i12);
    }

    @NonNull
    public String toString() {
        return this.mDelegate.toString();
    }

    public UnprecomputeTextOnModificationSpannable(@NonNull CharSequence charSequence) {
        this.mDelegate = new SpannableString(charSequence);
    }
}
