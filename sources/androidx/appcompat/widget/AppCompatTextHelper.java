package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;
    @NonNull
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private int mFontWeight = -1;
    private int mStyle = 0;
    @NonNull
    private final TextView mView;

    @RequiresApi(17)
    public static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        public static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        @DoNotInline
        public static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        @DoNotInline
        public static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        @DoNotInline
        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        @DoNotInline
        public static void b(TextView textView, int i11, int i12, int i13, int i14) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i11, i12, i13, i14);
        }

        @DoNotInline
        public static void c(TextView textView, int[] iArr, int i11) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i11);
        }

        @DoNotInline
        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static Typeface a(Typeface typeface, int i11, boolean z11) {
            return Typeface.create(typeface, i11, z11);
        }
    }

    public AppCompatTextHelper(@NonNull TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(textView);
    }

    private void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.d(drawable, tintInfo, this.mView.getDrawableState());
        }
    }

    private static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i11) {
        ColorStateList c11 = appCompatDrawableManager.c(context, i11);
        if (c11 == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = c11;
        return tintInfo;
    }

    private void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] a11 = Api17Impl.a(this.mView);
            TextView textView = this.mView;
            if (drawable5 == null) {
                drawable5 = a11[0];
            }
            if (drawable2 == null) {
                drawable2 = a11[1];
            }
            if (drawable6 == null) {
                drawable6 = a11[2];
            }
            if (drawable4 == null) {
                drawable4 = a11[3];
            }
            Api17Impl.b(textView, drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            Drawable[] a12 = Api17Impl.a(this.mView);
            Drawable drawable7 = a12[0];
            if (drawable7 == null && a12[2] == null) {
                Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
                TextView textView2 = this.mView;
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                return;
            }
            TextView textView3 = this.mView;
            if (drawable2 == null) {
                drawable2 = a12[1];
            }
            Drawable drawable8 = a12[2];
            if (drawable4 == null) {
                drawable4 = a12[3];
            }
            Api17Impl.b(textView3, drawable7, drawable2, drawable8, drawable4);
        }
    }

    private void setCompoundTints() {
        TintInfo tintInfo = this.mDrawableTint;
        this.mDrawableLeftTint = tintInfo;
        this.mDrawableTopTint = tintInfo;
        this.mDrawableRightTint = tintInfo;
        this.mDrawableBottomTint = tintInfo;
        this.mDrawableStartTint = tintInfo;
        this.mDrawableEndTint = tintInfo;
    }

    private void setTextSizeInternal(int i11, float f11) {
        this.mAutoSizeTextHelper.o(i11, f11);
    }

    private void updateTypefaceAndStyle(Context context, TintTypedArray tintTypedArray) {
        String string;
        boolean z11;
        boolean z12;
        this.mStyle = tintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
        int i11 = Build.VERSION.SDK_INT;
        boolean z13 = false;
        if (i11 >= 28) {
            int i12 = tintTypedArray.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.mFontWeight = i12;
            if (i12 != -1) {
                this.mStyle = (this.mStyle & 2) | 0;
            }
        }
        int i13 = R.styleable.TextAppearance_android_fontFamily;
        if (tintTypedArray.hasValue(i13) || tintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
            this.mFontTypeface = null;
            int i14 = R.styleable.TextAppearance_fontFamily;
            if (tintTypedArray.hasValue(i14)) {
                i13 = i14;
            }
            final int i15 = this.mFontWeight;
            final int i16 = this.mStyle;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.mView);
                try {
                    Typeface font = tintTypedArray.getFont(i13, this.mStyle, new ResourcesCompat.FontCallback() {
                        public void onFontRetrievalFailed(int i11) {
                        }

                        public void onFontRetrieved(@NonNull Typeface typeface) {
                            int i11;
                            boolean z11;
                            if (Build.VERSION.SDK_INT >= 28 && (i11 = i15) != -1) {
                                if ((i16 & 2) != 0) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                typeface = Api28Impl.a(typeface, i11, z11);
                            }
                            AppCompatTextHelper.this.l(weakReference, typeface);
                        }
                    });
                    if (font != null) {
                        if (i11 < 28 || this.mFontWeight == -1) {
                            this.mFontTypeface = font;
                        } else {
                            Typeface create = Typeface.create(font, 0);
                            int i17 = this.mFontWeight;
                            if ((this.mStyle & 2) != 0) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            this.mFontTypeface = Api28Impl.a(create, i17, z12);
                        }
                    }
                    if (this.mFontTypeface == null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    this.mAsyncFontPending = z11;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.mFontTypeface == null && (string = tintTypedArray.getString(i13)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.mFontWeight == -1) {
                    this.mFontTypeface = Typeface.create(string, this.mStyle);
                    return;
                }
                Typeface create2 = Typeface.create(string, 0);
                int i18 = this.mFontWeight;
                if ((this.mStyle & 2) != 0) {
                    z13 = true;
                }
                this.mFontTypeface = Api28Impl.a(create2, i18, z13);
                return;
            }
            return;
        }
        int i19 = R.styleable.TextAppearance_android_typeface;
        if (tintTypedArray.hasValue(i19)) {
            this.mAsyncFontPending = false;
            int i21 = tintTypedArray.getInt(i19, 1);
            if (i21 == 1) {
                this.mFontTypeface = Typeface.SANS_SERIF;
            } else if (i21 == 2) {
                this.mFontTypeface = Typeface.SERIF;
            } else if (i21 == 3) {
                this.mFontTypeface = Typeface.MONOSPACE;
            }
        }
    }

    public void a() {
        if (!(this.mDrawableLeftTint == null && this.mDrawableTopTint == null && this.mDrawableRightTint == null && this.mDrawableBottomTint == null)) {
            Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
        if (this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
            Drawable[] a11 = Api17Impl.a(this.mView);
            applyCompoundDrawableTint(a11[0], this.mDrawableStartTint);
            applyCompoundDrawableTint(a11[2], this.mDrawableEndTint);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void b() {
        this.mAutoSizeTextHelper.a();
    }

    public int c() {
        return this.mAutoSizeTextHelper.c();
    }

    public int d() {
        return this.mAutoSizeTextHelper.d();
    }

    public int e() {
        return this.mAutoSizeTextHelper.e();
    }

    public int[] f() {
        return this.mAutoSizeTextHelper.f();
    }

    public int g() {
        return this.mAutoSizeTextHelper.g();
    }

    @Nullable
    public ColorStateList h() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    @Nullable
    public PorterDuff.Mode i() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean j() {
        return this.mAutoSizeTextHelper.j();
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0208  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(@androidx.annotation.Nullable android.util.AttributeSet r20, int r21) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r9 = r21
            android.widget.TextView r0 = r7.mView
            android.content.Context r10 = r0.getContext()
            androidx.appcompat.widget.AppCompatDrawableManager r11 = androidx.appcompat.widget.AppCompatDrawableManager.get()
            int[] r2 = androidx.appcompat.R.styleable.AppCompatTextHelper
            r12 = 0
            androidx.appcompat.widget.TintTypedArray r13 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r10, r8, r2, r9, r12)
            android.widget.TextView r0 = r7.mView
            android.content.Context r1 = r0.getContext()
            android.content.res.TypedArray r4 = r13.getWrappedTypeArray()
            r6 = 0
            r3 = r20
            r5 = r21
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r0, r1, r2, r3, r4, r5, r6)
            int r0 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_textAppearance
            r14 = -1
            int r0 = r13.getResourceId(r0, r14)
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableLeft
            boolean r2 = r13.hasValue(r1)
            if (r2 == 0) goto L_0x0042
            int r1 = r13.getResourceId(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = createTintInfo(r10, r11, r1)
            r7.mDrawableLeftTint = r1
        L_0x0042:
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableTop
            boolean r2 = r13.hasValue(r1)
            if (r2 == 0) goto L_0x0054
            int r1 = r13.getResourceId(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = createTintInfo(r10, r11, r1)
            r7.mDrawableTopTint = r1
        L_0x0054:
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableRight
            boolean r2 = r13.hasValue(r1)
            if (r2 == 0) goto L_0x0066
            int r1 = r13.getResourceId(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = createTintInfo(r10, r11, r1)
            r7.mDrawableRightTint = r1
        L_0x0066:
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableBottom
            boolean r2 = r13.hasValue(r1)
            if (r2 == 0) goto L_0x0078
            int r1 = r13.getResourceId(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = createTintInfo(r10, r11, r1)
            r7.mDrawableBottomTint = r1
        L_0x0078:
            int r1 = android.os.Build.VERSION.SDK_INT
            int r2 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableStart
            boolean r3 = r13.hasValue(r2)
            if (r3 == 0) goto L_0x008c
            int r2 = r13.getResourceId(r2, r12)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r10, r11, r2)
            r7.mDrawableStartTint = r2
        L_0x008c:
            int r2 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableEnd
            boolean r3 = r13.hasValue(r2)
            if (r3 == 0) goto L_0x009e
            int r2 = r13.getResourceId(r2, r12)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r10, r11, r2)
            r7.mDrawableEndTint = r2
        L_0x009e:
            r13.recycle()
            android.widget.TextView r2 = r7.mView
            android.text.method.TransformationMethod r2 = r2.getTransformationMethod()
            boolean r2 = r2 instanceof android.text.method.PasswordTransformationMethod
            r3 = 26
            if (r0 == r14) goto L_0x00ea
            int[] r5 = androidx.appcompat.R.styleable.TextAppearance
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes((android.content.Context) r10, (int) r0, (int[]) r5)
            if (r2 != 0) goto L_0x00c3
            int r5 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps
            boolean r6 = r0.hasValue(r5)
            if (r6 == 0) goto L_0x00c3
            boolean r5 = r0.getBoolean(r5, r12)
            r6 = 1
            goto L_0x00c5
        L_0x00c3:
            r5 = r12
            r6 = r5
        L_0x00c5:
            r7.updateTypefaceAndStyle(r10, r0)
            int r15 = androidx.appcompat.R.styleable.TextAppearance_textLocale
            boolean r16 = r0.hasValue(r15)
            if (r16 == 0) goto L_0x00d5
            java.lang.String r15 = r0.getString(r15)
            goto L_0x00d6
        L_0x00d5:
            r15 = 0
        L_0x00d6:
            if (r1 < r3) goto L_0x00e5
            int r4 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings
            boolean r17 = r0.hasValue(r4)
            if (r17 == 0) goto L_0x00e5
            java.lang.String r4 = r0.getString(r4)
            goto L_0x00e6
        L_0x00e5:
            r4 = 0
        L_0x00e6:
            r0.recycle()
            goto L_0x00ee
        L_0x00ea:
            r5 = r12
            r6 = r5
            r4 = 0
            r15 = 0
        L_0x00ee:
            int[] r0 = androidx.appcompat.R.styleable.TextAppearance
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r10, r8, r0, r9, r12)
            if (r2 != 0) goto L_0x0105
            int r13 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps
            boolean r18 = r0.hasValue(r13)
            if (r18 == 0) goto L_0x0105
            boolean r5 = r0.getBoolean(r13, r12)
            r16 = 1
            goto L_0x0107
        L_0x0105:
            r16 = r6
        L_0x0107:
            int r6 = androidx.appcompat.R.styleable.TextAppearance_textLocale
            boolean r13 = r0.hasValue(r6)
            if (r13 == 0) goto L_0x0113
            java.lang.String r15 = r0.getString(r6)
        L_0x0113:
            if (r1 < r3) goto L_0x0121
            int r3 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings
            boolean r6 = r0.hasValue(r3)
            if (r6 == 0) goto L_0x0121
            java.lang.String r4 = r0.getString(r3)
        L_0x0121:
            r3 = 28
            if (r1 < r3) goto L_0x0139
            int r3 = androidx.appcompat.R.styleable.TextAppearance_android_textSize
            boolean r6 = r0.hasValue(r3)
            if (r6 == 0) goto L_0x0139
            int r3 = r0.getDimensionPixelSize(r3, r14)
            if (r3 != 0) goto L_0x0139
            android.widget.TextView r3 = r7.mView
            r6 = 0
            r3.setTextSize(r12, r6)
        L_0x0139:
            r7.updateTypefaceAndStyle(r10, r0)
            r0.recycle()
            if (r2 != 0) goto L_0x0146
            if (r16 == 0) goto L_0x0146
            r7.q(r5)
        L_0x0146:
            android.graphics.Typeface r0 = r7.mFontTypeface
            if (r0 == 0) goto L_0x015b
            int r2 = r7.mFontWeight
            if (r2 != r14) goto L_0x0156
            android.widget.TextView r2 = r7.mView
            int r3 = r7.mStyle
            r2.setTypeface(r0, r3)
            goto L_0x015b
        L_0x0156:
            android.widget.TextView r2 = r7.mView
            r2.setTypeface(r0)
        L_0x015b:
            if (r4 == 0) goto L_0x0162
            android.widget.TextView r0 = r7.mView
            androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.d(r0, r4)
        L_0x0162:
            if (r15 == 0) goto L_0x0183
            r0 = 24
            if (r1 < r0) goto L_0x0172
            android.widget.TextView r0 = r7.mView
            android.os.LocaleList r1 = androidx.appcompat.widget.AppCompatTextHelper.Api24Impl.a(r15)
            androidx.appcompat.widget.AppCompatTextHelper.Api24Impl.b(r0, r1)
            goto L_0x0183
        L_0x0172:
            java.lang.String r0 = ","
            java.lang.String[] r0 = r15.split(r0)
            r0 = r0[r12]
            android.widget.TextView r1 = r7.mView
            java.util.Locale r0 = androidx.appcompat.widget.AppCompatTextHelper.Api21Impl.a(r0)
            androidx.appcompat.widget.AppCompatTextHelper.Api17Impl.c(r1, r0)
        L_0x0183:
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r0 = r7.mAutoSizeTextHelper
            r0.k(r8, r9)
            boolean r0 = androidx.appcompat.widget.ViewUtils.f919a
            if (r0 == 0) goto L_0x01c7
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r0 = r7.mAutoSizeTextHelper
            int r0 = r0.g()
            if (r0 == 0) goto L_0x01c7
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r0 = r7.mAutoSizeTextHelper
            int[] r0 = r0.f()
            int r1 = r0.length
            if (r1 <= 0) goto L_0x01c7
            android.widget.TextView r1 = r7.mView
            int r1 = androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.a(r1)
            float r1 = (float) r1
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x01c2
            android.widget.TextView r0 = r7.mView
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r1 = r7.mAutoSizeTextHelper
            int r1 = r1.d()
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r2 = r7.mAutoSizeTextHelper
            int r2 = r2.c()
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r3 = r7.mAutoSizeTextHelper
            int r3 = r3.e()
            androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.b(r0, r1, r2, r3, r12)
            goto L_0x01c7
        L_0x01c2:
            android.widget.TextView r1 = r7.mView
            androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.c(r1, r0, r12)
        L_0x01c7:
            int[] r0 = androidx.appcompat.R.styleable.AppCompatTextView
            androidx.appcompat.widget.TintTypedArray r8 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes((android.content.Context) r10, (android.util.AttributeSet) r8, (int[]) r0)
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableLeftCompat
            int r0 = r8.getResourceId(r0, r14)
            if (r0 == r14) goto L_0x01db
            android.graphics.drawable.Drawable r0 = r11.getDrawable(r10, r0)
            r1 = r0
            goto L_0x01dc
        L_0x01db:
            r1 = 0
        L_0x01dc:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTopCompat
            int r0 = r8.getResourceId(r0, r14)
            if (r0 == r14) goto L_0x01ea
            android.graphics.drawable.Drawable r0 = r11.getDrawable(r10, r0)
            r2 = r0
            goto L_0x01eb
        L_0x01ea:
            r2 = 0
        L_0x01eb:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableRightCompat
            int r0 = r8.getResourceId(r0, r14)
            if (r0 == r14) goto L_0x01f9
            android.graphics.drawable.Drawable r0 = r11.getDrawable(r10, r0)
            r3 = r0
            goto L_0x01fa
        L_0x01f9:
            r3 = 0
        L_0x01fa:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableBottomCompat
            int r0 = r8.getResourceId(r0, r14)
            if (r0 == r14) goto L_0x0208
            android.graphics.drawable.Drawable r0 = r11.getDrawable(r10, r0)
            r4 = r0
            goto L_0x0209
        L_0x0208:
            r4 = 0
        L_0x0209:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableStartCompat
            int r0 = r8.getResourceId(r0, r14)
            if (r0 == r14) goto L_0x0217
            android.graphics.drawable.Drawable r0 = r11.getDrawable(r10, r0)
            r5 = r0
            goto L_0x0218
        L_0x0217:
            r5 = 0
        L_0x0218:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableEndCompat
            int r0 = r8.getResourceId(r0, r14)
            if (r0 == r14) goto L_0x0226
            android.graphics.drawable.Drawable r0 = r11.getDrawable(r10, r0)
            r6 = r0
            goto L_0x0227
        L_0x0226:
            r6 = 0
        L_0x0227:
            r0 = r19
            r0.setCompoundDrawables(r1, r2, r3, r4, r5, r6)
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTint
            boolean r1 = r8.hasValue(r0)
            if (r1 == 0) goto L_0x023d
            android.content.res.ColorStateList r0 = r8.getColorStateList(r0)
            android.widget.TextView r1 = r7.mView
            androidx.core.widget.TextViewCompat.setCompoundDrawableTintList(r1, r0)
        L_0x023d:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTintMode
            boolean r1 = r8.hasValue(r0)
            if (r1 == 0) goto L_0x0253
            int r0 = r8.getInt(r0, r14)
            r1 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r0, r1)
            android.widget.TextView r1 = r7.mView
            androidx.core.widget.TextViewCompat.setCompoundDrawableTintMode(r1, r0)
        L_0x0253:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_firstBaselineToTopHeight
            int r0 = r8.getDimensionPixelSize(r0, r14)
            int r1 = androidx.appcompat.R.styleable.AppCompatTextView_lastBaselineToBottomHeight
            int r1 = r8.getDimensionPixelSize(r1, r14)
            int r2 = androidx.appcompat.R.styleable.AppCompatTextView_lineHeight
            int r2 = r8.getDimensionPixelSize(r2, r14)
            r8.recycle()
            if (r0 == r14) goto L_0x026f
            android.widget.TextView r3 = r7.mView
            androidx.core.widget.TextViewCompat.setFirstBaselineToTopHeight(r3, r0)
        L_0x026f:
            if (r1 == r14) goto L_0x0276
            android.widget.TextView r0 = r7.mView
            androidx.core.widget.TextViewCompat.setLastBaselineToBottomHeight(r0, r1)
        L_0x0276:
            if (r2 == r14) goto L_0x027d
            android.widget.TextView r0 = r7.mView
            androidx.core.widget.TextViewCompat.setLineHeight(r0, r2)
        L_0x027d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.k(android.util.AttributeSet, int):void");
    }

    public void l(WeakReference<TextView> weakReference, final Typeface typeface) {
        if (this.mAsyncFontPending) {
            this.mFontTypeface = typeface;
            final TextView textView = weakReference.get();
            if (textView == null) {
                return;
            }
            if (ViewCompat.isAttachedToWindow(textView)) {
                final int i11 = this.mStyle;
                textView.post(new Runnable() {
                    public void run() {
                        textView.setTypeface(typeface, i11);
                    }
                });
                return;
            }
            textView.setTypeface(typeface, this.mStyle);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void m(boolean z11, int i11, int i12, int i13, int i14) {
        if (!ViewUtils.f919a) {
            b();
        }
    }

    public void n() {
        a();
    }

    public void o(Context context, int i11) {
        String string;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i11, R.styleable.TextAppearance);
        int i12 = R.styleable.TextAppearance_textAllCaps;
        if (obtainStyledAttributes.hasValue(i12)) {
            q(obtainStyledAttributes.getBoolean(i12, false));
        }
        int i13 = Build.VERSION.SDK_INT;
        int i14 = R.styleable.TextAppearance_android_textSize;
        if (obtainStyledAttributes.hasValue(i14) && obtainStyledAttributes.getDimensionPixelSize(i14, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, obtainStyledAttributes);
        if (i13 >= 26) {
            int i15 = R.styleable.TextAppearance_fontVariationSettings;
            if (obtainStyledAttributes.hasValue(i15) && (string = obtainStyledAttributes.getString(i15)) != null) {
                Api26Impl.d(this.mView, string);
            }
        }
        obtainStyledAttributes.recycle();
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            this.mView.setTypeface(typeface, this.mStyle);
        }
    }

    public void p(@NonNull TextView textView, @Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            EditorInfoCompat.setInitialSurroundingText(editorInfo, textView.getText());
        }
    }

    public void q(boolean z11) {
        this.mView.setAllCaps(z11);
    }

    public void r(int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.l(i11, i12, i13, i14);
    }

    public void s(@NonNull int[] iArr, int i11) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.m(iArr, i11);
    }

    public void t(int i11) {
        this.mAutoSizeTextHelper.n(i11);
    }

    public void u(@Nullable ColorStateList colorStateList) {
        boolean z11;
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintList = colorStateList;
        if (colorStateList != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        tintInfo.mHasTintList = z11;
        setCompoundTints();
    }

    public void v(@Nullable PorterDuff.Mode mode) {
        boolean z11;
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintMode = mode;
        if (mode != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        tintInfo.mHasTintMode = z11;
        setCompoundTints();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void w(int i11, float f11) {
        if (!ViewUtils.f919a && !j()) {
            setTextSizeInternal(i11, f11);
        }
    }
}
