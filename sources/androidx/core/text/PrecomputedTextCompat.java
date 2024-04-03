package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.os.TraceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class PrecomputedTextCompat implements Spannable {
    private static final char LINE_FEED = '\n';
    @GuardedBy("sLock")
    @NonNull
    private static Executor sExecutor;
    private static final Object sLock = new Object();
    @NonNull
    private final int[] mParagraphEnds;
    @NonNull
    private final Params mParams;
    @NonNull
    private final Spannable mText;
    @Nullable
    private final PrecomputedText mWrapped;

    public static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        public static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
            private Params mParams;
            private CharSequence mText;

            public PrecomputedTextCallback(@NonNull Params params, @NonNull CharSequence charSequence) {
                this.mParams = params;
                this.mText = charSequence;
            }

            public PrecomputedTextCompat call() throws Exception {
                return PrecomputedTextCompat.create(this.mText, this.mParams);
            }
        }

        public PrecomputedTextFutureTask(@NonNull Params params, @NonNull CharSequence charSequence) {
            super(new PrecomputedTextCallback(params, charSequence));
        }
    }

    private PrecomputedTextCompat(@NonNull CharSequence charSequence, @NonNull Params params, @NonNull int[] iArr) {
        this.mText = new SpannableString(charSequence);
        this.mParams = params;
        this.mParagraphEnds = iArr;
        this.mWrapped = null;
    }

    @SuppressLint({"WrongConstant"})
    public static PrecomputedTextCompat create(@NonNull CharSequence charSequence, @NonNull Params params) {
        PrecomputedText.Params params2;
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(params);
        try {
            TraceCompat.beginSection("PrecomputedText");
            if (Build.VERSION.SDK_INT >= 29 && (params2 = params.f11421a) != null) {
                return new PrecomputedTextCompat(PrecomputedText.create(charSequence, params2), params);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i11 = 0;
            while (i11 < length) {
                int indexOf = TextUtils.indexOf(charSequence, 10, i11, length);
                if (indexOf < 0) {
                    i11 = length;
                } else {
                    i11 = indexOf + 1;
                }
                arrayList.add(Integer.valueOf(i11));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                iArr[i12] = ((Integer) arrayList.get(i12)).intValue();
            }
            StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), params.getTextPaint(), Integer.MAX_VALUE).setBreakStrategy(params.getBreakStrategy()).setHyphenationFrequency(params.getHyphenationFrequency()).setTextDirection(params.getTextDirection()).build();
            PrecomputedTextCompat precomputedTextCompat = new PrecomputedTextCompat(charSequence, params, iArr);
            TraceCompat.endSection();
            return precomputedTextCompat;
        } finally {
            TraceCompat.endSection();
        }
    }

    @UiThread
    public static Future<PrecomputedTextCompat> getTextFuture(@NonNull CharSequence charSequence, @NonNull Params params, @Nullable Executor executor) {
        PrecomputedTextFutureTask precomputedTextFutureTask = new PrecomputedTextFutureTask(params, charSequence);
        if (executor == null) {
            synchronized (sLock) {
                if (sExecutor == null) {
                    sExecutor = Executors.newFixedThreadPool(1);
                }
                executor = sExecutor;
            }
        }
        executor.execute(precomputedTextFutureTask);
        return precomputedTextFutureTask;
    }

    public char charAt(int i11) {
        return this.mText.charAt(i11);
    }

    @IntRange(from = 0)
    public int getParagraphCount() {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mWrapped.getParagraphCount();
        }
        return this.mParagraphEnds.length;
    }

    @IntRange(from = 0)
    public int getParagraphEnd(@IntRange(from = 0) int i11) {
        Preconditions.checkArgumentInRange(i11, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mWrapped.getParagraphEnd(i11);
        }
        return this.mParagraphEnds[i11];
    }

    @IntRange(from = 0)
    public int getParagraphStart(@IntRange(from = 0) int i11) {
        Preconditions.checkArgumentInRange(i11, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mWrapped.getParagraphStart(i11);
        }
        if (i11 == 0) {
            return 0;
        }
        return this.mParagraphEnds[i11 - 1];
    }

    @NonNull
    public Params getParams() {
        return this.mParams;
    }

    @RequiresApi(28)
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PrecomputedText getPrecomputedText() {
        Spannable spannable = this.mText;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public int getSpanEnd(Object obj) {
        return this.mText.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.mText.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.mText.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i11, int i12, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mWrapped.getSpans(i11, i12, cls);
        }
        return this.mText.getSpans(i11, i12, cls);
    }

    public int length() {
        return this.mText.length();
    }

    public int nextSpanTransition(int i11, int i12, Class cls) {
        return this.mText.nextSpanTransition(i11, i12, cls);
    }

    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.mWrapped.removeSpan(obj);
        } else {
            this.mText.removeSpan(obj);
        }
    }

    public void setSpan(Object obj, int i11, int i12, int i13) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.mWrapped.setSpan(obj, i11, i12, i13);
        } else {
            this.mText.setSpan(obj, i11, i12, i13);
        }
    }

    public CharSequence subSequence(int i11, int i12) {
        return this.mText.subSequence(i11, i12);
    }

    @NonNull
    public String toString() {
        return this.mText.toString();
    }

    @RequiresApi(28)
    private PrecomputedTextCompat(@NonNull PrecomputedText precomputedText, @NonNull Params params) {
        this.mText = precomputedText;
        this.mParams = params;
        this.mParagraphEnds = null;
        this.mWrapped = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    public static final class Params {

        /* renamed from: a  reason: collision with root package name */
        public final PrecomputedText.Params f11421a;
        private final int mBreakStrategy;
        private final int mHyphenationFrequency;
        @NonNull
        private final TextPaint mPaint;
        @Nullable
        private final TextDirectionHeuristic mTextDir;

        public static class Builder {
            private int mBreakStrategy = 1;
            private int mHyphenationFrequency = 1;
            @NonNull
            private final TextPaint mPaint;
            private TextDirectionHeuristic mTextDir = TextDirectionHeuristics.FIRSTSTRONG_LTR;

            public Builder(@NonNull TextPaint textPaint) {
                this.mPaint = textPaint;
            }

            @NonNull
            public Params build() {
                return new Params(this.mPaint, this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency);
            }

            @RequiresApi(23)
            public Builder setBreakStrategy(int i11) {
                this.mBreakStrategy = i11;
                return this;
            }

            @RequiresApi(23)
            public Builder setHyphenationFrequency(int i11) {
                this.mHyphenationFrequency = i11;
                return this;
            }

            @RequiresApi(18)
            public Builder setTextDirection(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
                this.mTextDir = textDirectionHeuristic;
                return this;
            }
        }

        public Params(@NonNull TextPaint textPaint, @NonNull TextDirectionHeuristic textDirectionHeuristic, int i11, int i12) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f11421a = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i11).setHyphenationFrequency(i12).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f11421a = null;
            }
            this.mPaint = textPaint;
            this.mTextDir = textDirectionHeuristic;
            this.mBreakStrategy = i11;
            this.mHyphenationFrequency = i12;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            if (equalsWithoutTextDirection(params) && this.mTextDir == params.getTextDirection()) {
                return true;
            }
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean equalsWithoutTextDirection(@NonNull Params params) {
            int i11 = Build.VERSION.SDK_INT;
            if (this.mBreakStrategy != params.getBreakStrategy() || this.mHyphenationFrequency != params.getHyphenationFrequency() || this.mPaint.getTextSize() != params.getTextPaint().getTextSize() || this.mPaint.getTextScaleX() != params.getTextPaint().getTextScaleX() || this.mPaint.getTextSkewX() != params.getTextPaint().getTextSkewX() || this.mPaint.getLetterSpacing() != params.getTextPaint().getLetterSpacing() || !TextUtils.equals(this.mPaint.getFontFeatureSettings(), params.getTextPaint().getFontFeatureSettings()) || this.mPaint.getFlags() != params.getTextPaint().getFlags()) {
                return false;
            }
            if (i11 >= 24) {
                if (!this.mPaint.getTextLocales().equals(params.getTextPaint().getTextLocales())) {
                    return false;
                }
            } else if (!this.mPaint.getTextLocale().equals(params.getTextPaint().getTextLocale())) {
                return false;
            }
            if (this.mPaint.getTypeface() == null) {
                if (params.getTextPaint().getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.mPaint.getTypeface().equals(params.getTextPaint().getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        @RequiresApi(23)
        public int getBreakStrategy() {
            return this.mBreakStrategy;
        }

        @RequiresApi(23)
        public int getHyphenationFrequency() {
            return this.mHyphenationFrequency;
        }

        @RequiresApi(18)
        @Nullable
        public TextDirectionHeuristic getTextDirection() {
            return this.mTextDir;
        }

        @NonNull
        public TextPaint getTextPaint() {
            return this.mPaint;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return ObjectsCompat.hash(Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency));
            }
            return ObjectsCompat.hash(Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency));
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.mPaint.getTextSize());
            sb2.append(", textScaleX=" + this.mPaint.getTextScaleX());
            sb2.append(", textSkewX=" + this.mPaint.getTextSkewX());
            int i11 = Build.VERSION.SDK_INT;
            sb2.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
            if (i11 >= 24) {
                sb2.append(", textLocale=" + this.mPaint.getTextLocales());
            } else {
                sb2.append(", textLocale=" + this.mPaint.getTextLocale());
            }
            sb2.append(", typeface=" + this.mPaint.getTypeface());
            if (i11 >= 26) {
                sb2.append(", variationSettings=" + this.mPaint.getFontVariationSettings());
            }
            sb2.append(", textDir=" + this.mTextDir);
            sb2.append(", breakStrategy=" + this.mBreakStrategy);
            sb2.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
            sb2.append("}");
            return sb2.toString();
        }

        @RequiresApi(28)
        public Params(@NonNull PrecomputedText.Params params) {
            this.mPaint = params.getTextPaint();
            this.mTextDir = params.getTextDirection();
            this.mBreakStrategy = params.getBreakStrategy();
            this.mHyphenationFrequency = params.getHyphenationFrequency();
            this.f11421a = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
