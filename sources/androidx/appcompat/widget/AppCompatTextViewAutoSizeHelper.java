package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class AppCompatTextViewAutoSizeHelper {
    private static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
    private static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
    private static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
    private static final String TAG = "ACTVAutoSizeHelper";
    private static final RectF TEMP_RECTF = new RectF();
    private static final int VERY_WIDE = 1048576;
    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Field> sTextViewFieldByNameCache = new ConcurrentHashMap<>();
    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Method> sTextViewMethodByNameCache = new ConcurrentHashMap<>();
    private float mAutoSizeMaxTextSizeInPx = -1.0f;
    private float mAutoSizeMinTextSizeInPx = -1.0f;
    private float mAutoSizeStepGranularityInPx = -1.0f;
    private int[] mAutoSizeTextSizesInPx = new int[0];
    private int mAutoSizeTextType = 0;
    private final Context mContext;
    private boolean mHasPresetAutoSizeValues = false;
    private final Impl mImpl;
    private boolean mNeedsAutoSizeText = false;
    private TextPaint mTempTextPaint;
    @NonNull
    private final TextView mTextView;

    @RequiresApi(16)
    public static final class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        @NonNull
        public static StaticLayout a(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i11, @NonNull TextView textView, @NonNull TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i11, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        @DoNotInline
        public static int b(@NonNull TextView textView) {
            return textView.getMaxLines();
        }
    }

    @RequiresApi(18)
    public static final class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        public static boolean a(@NonNull View view) {
            return view.isInLayout();
        }
    }

    @RequiresApi(23)
    public static final class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        @NonNull
        public static StaticLayout a(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i11, int i12, @NonNull TextView textView, @NonNull TextPaint textPaint, @NonNull Impl impl) {
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i11);
            StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i12 == -1) {
                i12 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i12);
            try {
                impl.a(obtain, textView);
            } catch (ClassCastException unused) {
                Log.w(AppCompatTextViewAutoSizeHelper.TAG, "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return obtain.build();
        }
    }

    public static class Impl {
        public void a(StaticLayout.Builder builder, TextView textView) {
        }

        public boolean b(TextView textView) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.i(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    @RequiresApi(23)
    public static class Impl23 extends Impl {
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.i(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    @RequiresApi(29)
    public static class Impl29 extends Impl23 {
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    public AppCompatTextViewAutoSizeHelper(@NonNull TextView textView) {
        this.mTextView = textView;
        this.mContext = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.mImpl = new Impl29();
        } else {
            this.mImpl = new Impl23();
        }
    }

    private static <T> T accessAndReturnWithDefault(@NonNull Object obj, @NonNull String str, @NonNull T t11) {
        try {
            Field textViewField = getTextViewField(str);
            if (textViewField == null) {
                return t11;
            }
            return textViewField.get(obj);
        } catch (IllegalAccessException e11) {
            Log.w(TAG, "Failed to access TextView#" + str + " member", e11);
            return t11;
        }
    }

    private int[] cleanupAutoSizePresetSizes(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i11 : iArr) {
            if (i11 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i11)) < 0) {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i12 = 0; i12 < size; i12++) {
            iArr2[i12] = ((Integer) arrayList.get(i12)).intValue();
        }
        return iArr2;
    }

    private void clearAutoSizeConfiguration() {
        this.mAutoSizeTextType = 0;
        this.mAutoSizeMinTextSizeInPx = -1.0f;
        this.mAutoSizeMaxTextSizeInPx = -1.0f;
        this.mAutoSizeStepGranularityInPx = -1.0f;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mNeedsAutoSizeText = false;
    }

    private StaticLayout createStaticLayoutForMeasuringPre16(CharSequence charSequence, Layout.Alignment alignment, int i11) {
        return new StaticLayout(charSequence, this.mTempTextPaint, i11, alignment, ((Float) accessAndReturnWithDefault(this.mTextView, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) accessAndReturnWithDefault(this.mTextView, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) accessAndReturnWithDefault(this.mTextView, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    private int findLargestTextSizeWhichFits(RectF rectF) {
        int length = this.mAutoSizeTextSizesInPx.length;
        if (length != 0) {
            int i11 = 1;
            int i12 = length - 1;
            int i13 = 0;
            while (i11 <= i12) {
                int i14 = (i11 + i12) / 2;
                if (suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[i14], rectF)) {
                    int i15 = i14 + 1;
                    i13 = i11;
                    i11 = i15;
                } else {
                    i13 = i14 - 1;
                    i12 = i13;
                }
            }
            return this.mAutoSizeTextSizesInPx[i13];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    @Nullable
    private static Field getTextViewField(@NonNull String str) {
        try {
            Field field = sTextViewFieldByNameCache.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                sTextViewFieldByNameCache.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException e11) {
            Log.w(TAG, "Failed to access TextView#" + str + " member", e11);
            return null;
        }
    }

    @Nullable
    private static Method getTextViewMethod(@NonNull String str) {
        try {
            Method method = sTextViewMethodByNameCache.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                sTextViewMethodByNameCache.put(str, method);
            }
            return method;
        } catch (Exception e11) {
            Log.w(TAG, "Failed to retrieve TextView#" + str + "() method", e11);
            return null;
        }
    }

    public static <T> T i(@NonNull Object obj, @NonNull String str, @NonNull T t11) {
        try {
            return getTextViewMethod(str).invoke(obj, new Object[0]);
        } catch (Exception e11) {
            Log.w(TAG, "Failed to invoke TextView#" + str + "() method", e11);
            return t11;
        }
    }

    private void setRawTextSize(float f11) {
        if (f11 != this.mTextView.getPaint().getTextSize()) {
            this.mTextView.getPaint().setTextSize(f11);
            boolean a11 = Api18Impl.a(this.mTextView);
            if (this.mTextView.getLayout() != null) {
                this.mNeedsAutoSizeText = false;
                try {
                    Method textViewMethod = getTextViewMethod("nullLayouts");
                    if (textViewMethod != null) {
                        textViewMethod.invoke(this.mTextView, new Object[0]);
                    }
                } catch (Exception e11) {
                    Log.w(TAG, "Failed to invoke TextView#nullLayouts() method", e11);
                }
                if (!a11) {
                    this.mTextView.requestLayout();
                } else {
                    this.mTextView.forceLayout();
                }
                this.mTextView.invalidate();
            }
        }
    }

    private boolean setupAutoSizeText() {
        if (!supportsAutoSizeText() || this.mAutoSizeTextType != 1) {
            this.mNeedsAutoSizeText = false;
        } else {
            if (!this.mHasPresetAutoSizeValues || this.mAutoSizeTextSizesInPx.length == 0) {
                int floor = ((int) Math.floor((double) ((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx))) + 1;
                int[] iArr = new int[floor];
                for (int i11 = 0; i11 < floor; i11++) {
                    iArr[i11] = Math.round(this.mAutoSizeMinTextSizeInPx + (((float) i11) * this.mAutoSizeStepGranularityInPx));
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
            }
            this.mNeedsAutoSizeText = true;
        }
        return this.mNeedsAutoSizeText;
    }

    private void setupAutoSizeUniformPresetSizes(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i11 = 0; i11 < length; i11++) {
                iArr[i11] = typedArray.getDimensionPixelSize(i11, -1);
            }
            this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
            setupAutoSizeUniformPresetSizesConfiguration();
        }
    }

    private boolean setupAutoSizeUniformPresetSizesConfiguration() {
        boolean z11;
        int[] iArr = this.mAutoSizeTextSizesInPx;
        int length = iArr.length;
        if (length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.mHasPresetAutoSizeValues = z11;
        if (z11) {
            this.mAutoSizeTextType = 1;
            this.mAutoSizeMinTextSizeInPx = (float) iArr[0];
            this.mAutoSizeMaxTextSizeInPx = (float) iArr[length - 1];
            this.mAutoSizeStepGranularityInPx = -1.0f;
        }
        return z11;
    }

    private boolean suggestedSizeFitsInSpace(int i11, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.mTextView.getText();
        TransformationMethod transformationMethod = this.mTextView.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.mTextView)) == null)) {
            text = transformation;
        }
        int b11 = Api16Impl.b(this.mTextView);
        h(i11);
        StaticLayout b12 = b(text, (Layout.Alignment) i(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), b11);
        if ((b11 == -1 || (b12.getLineCount() <= b11 && b12.getLineEnd(b12.getLineCount() - 1) == text.length())) && ((float) b12.getHeight()) <= rectF.bottom) {
            return true;
        }
        return false;
    }

    private boolean supportsAutoSizeText() {
        return !(this.mTextView instanceof AppCompatEditText);
    }

    private void validateAndSetAutoSizeTextTypeUniformConfiguration(float f11, float f12, float f13) throws IllegalArgumentException {
        if (f11 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f11 + "px) is less or equal to (0px)");
        } else if (f12 <= f11) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f12 + "px) is less or equal to minimum auto-size text size (" + f11 + "px)");
        } else if (f13 > 0.0f) {
            this.mAutoSizeTextType = 1;
            this.mAutoSizeMinTextSizeInPx = f11;
            this.mAutoSizeMaxTextSizeInPx = f12;
            this.mAutoSizeStepGranularityInPx = f13;
            this.mHasPresetAutoSizeValues = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f13 + "px) is less or equal to (0px)");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void a() {
        int i11;
        if (j()) {
            if (this.mNeedsAutoSizeText) {
                if (this.mTextView.getMeasuredHeight() > 0 && this.mTextView.getMeasuredWidth() > 0) {
                    if (this.mImpl.b(this.mTextView)) {
                        i11 = 1048576;
                    } else {
                        i11 = (this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft()) - this.mTextView.getTotalPaddingRight();
                    }
                    int height = (this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom()) - this.mTextView.getCompoundPaddingTop();
                    if (i11 > 0 && height > 0) {
                        RectF rectF = TEMP_RECTF;
                        synchronized (rectF) {
                            rectF.setEmpty();
                            rectF.right = (float) i11;
                            rectF.bottom = (float) height;
                            float findLargestTextSizeWhichFits = (float) findLargestTextSizeWhichFits(rectF);
                            if (findLargestTextSizeWhichFits != this.mTextView.getTextSize()) {
                                o(0, findLargestTextSizeWhichFits);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.mNeedsAutoSizeText = true;
        }
    }

    @VisibleForTesting
    @NonNull
    public StaticLayout b(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i11, int i12) {
        return Api23Impl.a(charSequence, alignment, i11, i12, this.mTextView, this.mTempTextPaint, this.mImpl);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int c() {
        return Math.round(this.mAutoSizeMaxTextSizeInPx);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int d() {
        return Math.round(this.mAutoSizeMinTextSizeInPx);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int e() {
        return Math.round(this.mAutoSizeStepGranularityInPx);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] f() {
        return this.mAutoSizeTextSizesInPx;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int g() {
        return this.mAutoSizeTextType;
    }

    @VisibleForTesting
    public void h(int i11) {
        TextPaint textPaint = this.mTempTextPaint;
        if (textPaint == null) {
            this.mTempTextPaint = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.mTempTextPaint.set(this.mTextView.getPaint());
        this.mTempTextPaint.setTextSize((float) i11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean j() {
        return supportsAutoSizeText() && this.mAutoSizeTextType != 0;
    }

    public void k(@Nullable AttributeSet attributeSet, int i11) {
        float f11;
        float f12;
        float f13;
        int resourceId;
        Context context = this.mContext;
        int[] iArr = R.styleable.AppCompatTextView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i11, 0);
        TextView textView = this.mTextView;
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i11, 0);
        int i12 = R.styleable.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes.hasValue(i12)) {
            this.mAutoSizeTextType = obtainStyledAttributes.getInt(i12, 0);
        }
        int i13 = R.styleable.AppCompatTextView_autoSizeStepGranularity;
        if (obtainStyledAttributes.hasValue(i13)) {
            f11 = obtainStyledAttributes.getDimension(i13, -1.0f);
        } else {
            f11 = -1.0f;
        }
        int i14 = R.styleable.AppCompatTextView_autoSizeMinTextSize;
        if (obtainStyledAttributes.hasValue(i14)) {
            f12 = obtainStyledAttributes.getDimension(i14, -1.0f);
        } else {
            f12 = -1.0f;
        }
        int i15 = R.styleable.AppCompatTextView_autoSizeMaxTextSize;
        if (obtainStyledAttributes.hasValue(i15)) {
            f13 = obtainStyledAttributes.getDimension(i15, -1.0f);
        } else {
            f13 = -1.0f;
        }
        int i16 = R.styleable.AppCompatTextView_autoSizePresetSizes;
        if (obtainStyledAttributes.hasValue(i16) && (resourceId = obtainStyledAttributes.getResourceId(i16, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            setupAutoSizeUniformPresetSizes(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!supportsAutoSizeText()) {
            this.mAutoSizeTextType = 0;
        } else if (this.mAutoSizeTextType == 1) {
            if (!this.mHasPresetAutoSizeValues) {
                DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                if (f12 == -1.0f) {
                    f12 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (f13 == -1.0f) {
                    f13 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (f11 == -1.0f) {
                    f11 = 1.0f;
                }
                validateAndSetAutoSizeTextTypeUniformConfiguration(f12, f13, f11);
            }
            setupAutoSizeText();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void l(int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        if (supportsAutoSizeText()) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(i14, (float) i11, displayMetrics), TypedValue.applyDimension(i14, (float) i12, displayMetrics), TypedValue.applyDimension(i14, (float) i13, displayMetrics));
            if (setupAutoSizeText()) {
                a();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void m(@NonNull int[] iArr, int i11) throws IllegalArgumentException {
        if (supportsAutoSizeText()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i11 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    for (int i12 = 0; i12 < length; i12++) {
                        iArr2[i12] = Math.round(TypedValue.applyDimension(i11, (float) iArr[i12], displayMetrics));
                    }
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr2);
                if (!setupAutoSizeUniformPresetSizesConfiguration()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.mHasPresetAutoSizeValues = false;
            }
            if (setupAutoSizeText()) {
                a();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void n(int i11) {
        if (!supportsAutoSizeText()) {
            return;
        }
        if (i11 == 0) {
            clearAutoSizeConfiguration();
        } else if (i11 == 1) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (setupAutoSizeText()) {
                a();
            }
        } else {
            throw new IllegalArgumentException("Unknown auto-size text type: " + i11);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void o(int i11, float f11) {
        Resources resources;
        Context context = this.mContext;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i11, f11, resources.getDisplayMetrics()));
    }
}
