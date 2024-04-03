package com.materialedittext;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.view.ViewCompat;
import com.materialedittext.validation.METLengthChecker;
import com.materialedittext.validation.METValidator;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.nineoldandroids.animation.ArgbEvaluator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

@Instrumented
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    public static final int FLOATING_LABEL_HIGHLIGHT = 2;
    public static final int FLOATING_LABEL_NONE = 0;
    public static final int FLOATING_LABEL_NORMAL = 1;
    private Typeface accentTypeface;
    /* access modifiers changed from: private */
    public boolean autoValidate;

    /* renamed from: b  reason: collision with root package name */
    public Paint f52720b = new Paint(1);
    private int baseColor;
    private int bottomEllipsisSize;
    private float bottomLines;
    private int bottomSpacing;
    private int bottomTextSize;

    /* renamed from: c  reason: collision with root package name */
    public TextPaint f52721c = new TextPaint(1);
    private boolean charactersCountValid;
    private boolean checkCharactersCountAtBeginning;
    private Bitmap[] clearButtonBitmaps;
    private boolean clearButtonClicking;
    private boolean clearButtonTouched;
    private float currentBottomLines;

    /* renamed from: d  reason: collision with root package name */
    public StaticLayout f52722d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f52723e;
    private int errorColor;
    private int extraPaddingBottom;
    private int extraPaddingLeft;
    private int extraPaddingRight;
    private int extraPaddingTop;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f52724f;
    private boolean firstShown;
    private boolean floatingLabelAlwaysShown;
    private boolean floatingLabelAnimating;
    /* access modifiers changed from: private */
    public boolean floatingLabelEnabled;
    private float floatingLabelFraction;
    private int floatingLabelPadding;
    /* access modifiers changed from: private */
    public boolean floatingLabelShown;
    private CharSequence floatingLabelText;
    private int floatingLabelTextColor;
    private int floatingLabelTextSize;
    private ArgbEvaluator focusEvaluator = new ArgbEvaluator();
    private float focusFraction;

    /* renamed from: g  reason: collision with root package name */
    public ObjectAnimator f52725g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnFocusChangeListener f52726h;
    private String helperText;
    private boolean helperTextAlwaysShown;
    private int helperTextColor = -1;
    private boolean hideUnderline;
    /* access modifiers changed from: private */
    public boolean highlightFloatingLabel;

    /* renamed from: i  reason: collision with root package name */
    public View.OnFocusChangeListener f52727i;
    private Bitmap[] iconLeftBitmaps;
    private int iconOuterHeight;
    private int iconOuterWidth;
    private int iconPadding;
    private Bitmap[] iconRightBitmaps;
    private int iconSize;
    private int innerPaddingBottom;
    private int innerPaddingLeft;
    private int innerPaddingRight;
    private int innerPaddingTop;
    private METLengthChecker lengthChecker;
    private int maxCharacters;
    private int minBottomLines;
    private int minBottomTextLines;
    private int minCharacters;
    private int primaryColor;
    private boolean showClearButton;
    private boolean singleLineEllipsis;
    private String tempErrorText;
    private ColorStateList textColorHintStateList;
    private ColorStateList textColorStateList;
    private Typeface typeface;
    private int underlineColor;
    /* access modifiers changed from: private */
    public boolean validateOnFocusLost;
    private List<METValidator> validators;

    public @interface FloatingLabelType {
    }

    public MaterialAutoCompleteTextView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private boolean adjustBottomLines() {
        int i11;
        Layout.Alignment alignment;
        if (getWidth() == 0) {
            return false;
        }
        this.f52721c.setTextSize((float) this.bottomTextSize);
        if (this.tempErrorText == null && this.helperText == null) {
            i11 = this.minBottomLines;
        } else {
            if ((getGravity() & 5) == 5 || isRTL()) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if ((getGravity() & 3) == 3) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            Layout.Alignment alignment2 = alignment;
            String str = this.tempErrorText;
            if (str == null) {
                str = this.helperText;
            }
            StaticLayout staticLayout = new StaticLayout(str, this.f52721c, (((getWidth() - getBottomTextLeftOffset()) - getBottomTextRightOffset()) - getPaddingLeft()) - getPaddingRight(), alignment2, 1.0f, 0.0f, true);
            this.f52722d = staticLayout;
            i11 = Math.max(staticLayout.getLineCount(), this.minBottomTextLines);
        }
        float f11 = (float) i11;
        if (this.bottomLines != f11) {
            getBottomLinesAnimator(f11).start();
        }
        this.bottomLines = f11;
        return true;
    }

    /* access modifiers changed from: private */
    public void checkCharactersCount() {
        int i11;
        int i12;
        boolean z11 = true;
        if ((this.firstShown || this.checkCharactersCountAtBeginning) && hasCharactersCounter()) {
            Editable text = getText();
            if (text == null) {
                i11 = 0;
            } else {
                i11 = checkLength(text);
            }
            if (i11 < this.minCharacters || ((i12 = this.maxCharacters) > 0 && i11 > i12)) {
                z11 = false;
            }
            this.charactersCountValid = z11;
            return;
        }
        this.charactersCountValid = true;
    }

    private int checkLength(CharSequence charSequence) {
        METLengthChecker mETLengthChecker = this.lengthChecker;
        if (mETLengthChecker == null) {
            return charSequence.length();
        }
        return mETLengthChecker.getLength(charSequence);
    }

    private void correctPaddings() {
        int buttonsCount = this.iconOuterWidth * getButtonsCount();
        int i11 = 0;
        if (!isRTL()) {
            i11 = buttonsCount;
            buttonsCount = 0;
        }
        super.setPadding(this.innerPaddingLeft + this.extraPaddingLeft + buttonsCount, this.innerPaddingTop + this.extraPaddingTop, this.innerPaddingRight + this.extraPaddingRight + i11, this.innerPaddingBottom + this.extraPaddingBottom);
    }

    private Bitmap[] generateIconBitmaps(@DrawableRes int i11) {
        if (i11 == -1) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i12 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactoryInstrumentation.decodeResource(getResources(), i11, options);
        int max = Math.max(options.outWidth, options.outHeight);
        int i13 = this.iconSize;
        if (max > i13) {
            i12 = max / i13;
        }
        options.inSampleSize = i12;
        options.inJustDecodeBounds = false;
        return generateIconBitmaps(BitmapFactoryInstrumentation.decodeResource(getResources(), i11, options));
    }

    private int getBottomEllipsisWidth() {
        if (this.singleLineEllipsis) {
            return (this.bottomEllipsisSize * 5) + getPixel(4);
        }
        return 0;
    }

    private ObjectAnimator getBottomLinesAnimator(float f11) {
        ObjectAnimator objectAnimator = this.f52725g;
        if (objectAnimator == null) {
            this.f52725g = ObjectAnimator.ofFloat((Object) this, "currentBottomLines", f11);
        } else {
            objectAnimator.cancel();
            this.f52725g.setFloatValues(f11);
        }
        return this.f52725g;
    }

    private int getBottomTextLeftOffset() {
        return isRTL() ? getCharactersCounterWidth() : getBottomEllipsisWidth();
    }

    private int getBottomTextRightOffset() {
        return isRTL() ? getBottomEllipsisWidth() : getCharactersCounterWidth();
    }

    private int getButtonsCount() {
        return isShowClearButton() ? 1 : 0;
    }

    private String getCharactersCounterText() {
        if (this.minCharacters <= 0) {
            if (isRTL()) {
                return this.maxCharacters + " / " + checkLength(getText());
            }
            return checkLength(getText()) + " / " + this.maxCharacters;
        } else if (this.maxCharacters <= 0) {
            if (isRTL()) {
                return "+" + this.minCharacters + " / " + checkLength(getText());
            }
            return checkLength(getText()) + " / " + this.minCharacters + "+";
        } else if (isRTL()) {
            return this.maxCharacters + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + this.minCharacters + " / " + checkLength(getText());
        } else {
            return checkLength(getText()) + " / " + this.minCharacters + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + this.maxCharacters;
        }
    }

    private int getCharactersCounterWidth() {
        if (hasCharactersCounter()) {
            return (int) this.f52721c.measureText(getCharactersCounterText());
        }
        return 0;
    }

    private Typeface getCustomTypeface(@NonNull String str) {
        return Typeface.createFromAsset(getContext().getAssets(), str);
    }

    /* access modifiers changed from: private */
    public ObjectAnimator getLabelAnimator() {
        long j11;
        if (this.f52723e == null) {
            this.f52723e = ObjectAnimator.ofFloat((Object) this, "floatingLabelFraction", 0.0f, 1.0f);
        }
        ObjectAnimator objectAnimator = this.f52723e;
        if (this.floatingLabelAnimating) {
            j11 = 300;
        } else {
            j11 = 0;
        }
        objectAnimator.setDuration(j11);
        return this.f52723e;
    }

    /* access modifiers changed from: private */
    public ObjectAnimator getLabelFocusAnimator() {
        if (this.f52724f == null) {
            this.f52724f = ObjectAnimator.ofFloat((Object) this, "focusFraction", 0.0f, 1.0f);
        }
        return this.f52724f;
    }

    private int getPixel(int i11) {
        return Density.dp2px(getContext(), (float) i11);
    }

    private boolean hasCharactersCounter() {
        return this.minCharacters > 0 || this.maxCharacters > 0;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0061 */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0077 A[Catch:{ Exception -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0081 A[Catch:{ Exception -> 0x0089 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void init(android.content.Context r8, android.util.AttributeSet r9) {
        /*
            r7 = this;
            r0 = 32
            int r1 = r7.getPixel(r0)
            r7.iconSize = r1
            r1 = 48
            int r1 = r7.getPixel(r1)
            r7.iconOuterWidth = r1
            int r0 = r7.getPixel(r0)
            r7.iconOuterHeight = r0
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.materialedittext.R.dimen.inner_components_spacing
            int r0 = r0.getDimensionPixelSize(r1)
            r7.bottomSpacing = r0
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.materialedittext.R.dimen.bottom_ellipsis_height
            int r0 = r0.getDimensionPixelSize(r1)
            r7.bottomEllipsisSize = r0
            int[] r0 = com.materialedittext.R.styleable.MaterialEditText
            android.content.res.TypedArray r0 = r8.obtainStyledAttributes(r9, r0)
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_textColor
            android.content.res.ColorStateList r1 = r0.getColorStateList(r1)
            r7.textColorStateList = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_textColorHint
            android.content.res.ColorStateList r1 = r0.getColorStateList(r1)
            r7.textColorHintStateList = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_baseColor
            r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            int r1 = r0.getColor(r1, r2)
            r7.baseColor = r1
            android.util.TypedValue r1 = new android.util.TypedValue
            r1.<init>()
            r2 = 1
            android.content.res.Resources$Theme r3 = r8.getTheme()     // Catch:{ Exception -> 0x0061 }
            r4 = 16843827(0x1010433, float:2.369657E-38)
            r3.resolveAttribute(r4, r1, r2)     // Catch:{ Exception -> 0x0061 }
            int r1 = r1.data     // Catch:{ Exception -> 0x0061 }
            goto L_0x008b
        L_0x0061:
            android.content.res.Resources r3 = r7.getResources()     // Catch:{ Exception -> 0x0089 }
            java.lang.String r4 = "colorPrimary"
            java.lang.String r5 = "attr"
            android.content.Context r6 = r7.getContext()     // Catch:{ Exception -> 0x0089 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ Exception -> 0x0089 }
            int r3 = r3.getIdentifier(r4, r5, r6)     // Catch:{ Exception -> 0x0089 }
            if (r3 == 0) goto L_0x0081
            android.content.res.Resources$Theme r4 = r8.getTheme()     // Catch:{ Exception -> 0x0089 }
            r4.resolveAttribute(r3, r1, r2)     // Catch:{ Exception -> 0x0089 }
            int r1 = r1.data     // Catch:{ Exception -> 0x0089 }
            goto L_0x008b
        L_0x0081:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0089 }
            java.lang.String r3 = "colorPrimary not found"
            r1.<init>(r3)     // Catch:{ Exception -> 0x0089 }
            throw r1     // Catch:{ Exception -> 0x0089 }
        L_0x0089:
            int r1 = r7.baseColor
        L_0x008b:
            int r3 = com.materialedittext.R.styleable.MaterialEditText_met_primaryColor
            int r1 = r0.getColor(r3, r1)
            r7.primaryColor = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_floatingLabel
            r3 = 0
            int r1 = r0.getInt(r1, r3)
            r7.setFloatingLabelInternal(r1)
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_errorColor
            java.lang.String r4 = "#e7492E"
            int r4 = android.graphics.Color.parseColor(r4)
            int r1 = r0.getColor(r1, r4)
            r7.errorColor = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_minCharacters
            int r1 = r0.getInt(r1, r3)
            r7.minCharacters = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_maxCharacters
            int r1 = r0.getInt(r1, r3)
            r7.maxCharacters = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_singleLineEllipsis
            boolean r1 = r0.getBoolean(r1, r3)
            r7.singleLineEllipsis = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_helperText
            java.lang.String r1 = r0.getString(r1)
            r7.helperText = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_helperTextColor
            r4 = -1
            int r1 = r0.getColor(r1, r4)
            r7.helperTextColor = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_minBottomTextLines
            int r1 = r0.getInt(r1, r3)
            r7.minBottomTextLines = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_accentTypeface
            java.lang.String r1 = r0.getString(r1)
            if (r1 == 0) goto L_0x00f5
            boolean r5 = r7.isInEditMode()
            if (r5 != 0) goto L_0x00f5
            android.graphics.Typeface r1 = r7.getCustomTypeface(r1)
            r7.accentTypeface = r1
            android.text.TextPaint r5 = r7.f52721c
            r5.setTypeface(r1)
        L_0x00f5:
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_typeface
            java.lang.String r1 = r0.getString(r1)
            if (r1 == 0) goto L_0x010c
            boolean r5 = r7.isInEditMode()
            if (r5 != 0) goto L_0x010c
            android.graphics.Typeface r1 = r7.getCustomTypeface(r1)
            r7.typeface = r1
            r7.setTypeface(r1)
        L_0x010c:
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_floatingLabelText
            java.lang.String r1 = r0.getString(r1)
            r7.floatingLabelText = r1
            if (r1 != 0) goto L_0x011c
            java.lang.CharSequence r1 = r7.getHint()
            r7.floatingLabelText = r1
        L_0x011c:
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_floatingLabelPadding
            int r5 = r7.bottomSpacing
            int r1 = r0.getDimensionPixelSize(r1, r5)
            r7.floatingLabelPadding = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_floatingLabelTextSize
            android.content.res.Resources r5 = r7.getResources()
            int r6 = com.materialedittext.R.dimen.floating_label_text_size
            int r5 = r5.getDimensionPixelSize(r6)
            int r1 = r0.getDimensionPixelSize(r1, r5)
            r7.floatingLabelTextSize = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_floatingLabelTextColor
            int r1 = r0.getColor(r1, r4)
            r7.floatingLabelTextColor = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_floatingLabelAnimating
            boolean r1 = r0.getBoolean(r1, r2)
            r7.floatingLabelAnimating = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_bottomTextSize
            android.content.res.Resources r5 = r7.getResources()
            int r6 = com.materialedittext.R.dimen.bottom_text_size
            int r5 = r5.getDimensionPixelSize(r6)
            int r1 = r0.getDimensionPixelSize(r1, r5)
            r7.bottomTextSize = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_hideUnderline
            boolean r1 = r0.getBoolean(r1, r3)
            r7.hideUnderline = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_underlineColor
            int r1 = r0.getColor(r1, r4)
            r7.underlineColor = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_autoValidate
            boolean r1 = r0.getBoolean(r1, r3)
            r7.autoValidate = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_iconLeft
            int r1 = r0.getResourceId(r1, r4)
            android.graphics.Bitmap[] r1 = r7.generateIconBitmaps((int) r1)
            r7.iconLeftBitmaps = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_iconRight
            int r1 = r0.getResourceId(r1, r4)
            android.graphics.Bitmap[] r1 = r7.generateIconBitmaps((int) r1)
            r7.iconRightBitmaps = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_clearButton
            boolean r1 = r0.getBoolean(r1, r3)
            r7.showClearButton = r1
            int r1 = com.materialedittext.R.drawable.met_ic_clear
            android.graphics.Bitmap[] r1 = r7.generateIconBitmaps((int) r1)
            r7.clearButtonBitmaps = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_iconPadding
            r4 = 16
            int r4 = r7.getPixel(r4)
            int r1 = r0.getDimensionPixelSize(r1, r4)
            r7.iconPadding = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_floatingLabelAlwaysShown
            boolean r1 = r0.getBoolean(r1, r3)
            r7.floatingLabelAlwaysShown = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_helperTextAlwaysShown
            boolean r1 = r0.getBoolean(r1, r3)
            r7.helperTextAlwaysShown = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_validateOnFocusLost
            boolean r1 = r0.getBoolean(r1, r3)
            r7.validateOnFocusLost = r1
            int r1 = com.materialedittext.R.styleable.MaterialEditText_met_checkCharactersCountAtBeginning
            boolean r1 = r0.getBoolean(r1, r2)
            r7.checkCharactersCountAtBeginning = r1
            r0.recycle()
            r0 = 5
            int[] r0 = new int[r0]
            r0 = {16842965, 16842966, 16842967, 16842968, 16842969} // fill-array
            android.content.res.TypedArray r8 = r8.obtainStyledAttributes(r9, r0)
            int r9 = r8.getDimensionPixelSize(r3, r3)
            int r0 = r8.getDimensionPixelSize(r2, r9)
            r7.innerPaddingLeft = r0
            r0 = 2
            int r0 = r8.getDimensionPixelSize(r0, r9)
            r7.innerPaddingTop = r0
            r0 = 3
            int r0 = r8.getDimensionPixelSize(r0, r9)
            r7.innerPaddingRight = r0
            r0 = 4
            int r9 = r8.getDimensionPixelSize(r0, r9)
            r7.innerPaddingBottom = r9
            r8.recycle()
            r8 = 0
            r7.setBackground(r8)
            boolean r8 = r7.singleLineEllipsis
            if (r8 == 0) goto L_0x0209
            android.text.method.TransformationMethod r8 = r7.getTransformationMethod()
            r7.setSingleLine()
            r7.setTransformationMethod(r8)
        L_0x0209:
            r7.initMinBottomLines()
            r7.initPadding()
            r7.initText()
            r7.initFloatingLabel()
            r7.initTextWatcher()
            r7.checkCharactersCount()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.materialedittext.MaterialAutoCompleteTextView.init(android.content.Context, android.util.AttributeSet):void");
    }

    private void initFloatingLabel() {
        addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (!MaterialAutoCompleteTextView.this.floatingLabelEnabled) {
                    return;
                }
                if (editable.length() == 0) {
                    if (MaterialAutoCompleteTextView.this.floatingLabelShown) {
                        MaterialAutoCompleteTextView.this.floatingLabelShown = false;
                        MaterialAutoCompleteTextView.this.getLabelAnimator().reverse();
                    }
                } else if (!MaterialAutoCompleteTextView.this.floatingLabelShown) {
                    MaterialAutoCompleteTextView.this.floatingLabelShown = true;
                    MaterialAutoCompleteTextView.this.getLabelAnimator().start();
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        AnonymousClass3 r02 = new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z11) {
                if (MaterialAutoCompleteTextView.this.floatingLabelEnabled && MaterialAutoCompleteTextView.this.highlightFloatingLabel) {
                    if (z11) {
                        MaterialAutoCompleteTextView.this.getLabelFocusAnimator().start();
                    } else {
                        MaterialAutoCompleteTextView.this.getLabelFocusAnimator().reverse();
                    }
                }
                if (MaterialAutoCompleteTextView.this.validateOnFocusLost && !z11) {
                    MaterialAutoCompleteTextView.this.validate();
                }
                View.OnFocusChangeListener onFocusChangeListener = MaterialAutoCompleteTextView.this.f52727i;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(view, z11);
                }
            }
        };
        this.f52726h = r02;
        super.setOnFocusChangeListener(r02);
    }

    private void initMinBottomLines() {
        boolean z11;
        int i11 = 0;
        if (this.minCharacters > 0 || this.maxCharacters > 0 || this.singleLineEllipsis || this.tempErrorText != null || this.helperText != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i12 = this.minBottomTextLines;
        if (i12 > 0) {
            i11 = i12;
        } else if (z11) {
            i11 = 1;
        }
        this.minBottomLines = i11;
        this.currentBottomLines = (float) i11;
    }

    private void initPadding() {
        int i11;
        int i12;
        int i13;
        if (this.floatingLabelEnabled) {
            i11 = this.floatingLabelTextSize + this.floatingLabelPadding;
        } else {
            i11 = this.floatingLabelPadding;
        }
        this.extraPaddingTop = i11;
        this.f52721c.setTextSize((float) this.bottomTextSize);
        Paint.FontMetrics fontMetrics = this.f52721c.getFontMetrics();
        int i14 = (int) ((fontMetrics.descent - fontMetrics.ascent) * this.currentBottomLines);
        if (this.hideUnderline) {
            i12 = this.bottomSpacing;
        } else {
            i12 = this.bottomSpacing * 2;
        }
        this.extraPaddingBottom = i14 + i12;
        int i15 = 0;
        if (this.iconLeftBitmaps == null) {
            i13 = 0;
        } else {
            i13 = this.iconOuterWidth + this.iconPadding;
        }
        this.extraPaddingLeft = i13;
        if (this.iconRightBitmaps != null) {
            i15 = this.iconPadding + this.iconOuterWidth;
        }
        this.extraPaddingRight = i15;
        correctPaddings();
    }

    private void initText() {
        if (!TextUtils.isEmpty(getText())) {
            Editable text = getText();
            setText((CharSequence) null);
            resetHintTextColor();
            setText(text);
            setSelection(text.length());
            this.floatingLabelFraction = 1.0f;
            this.floatingLabelShown = true;
        } else {
            resetHintTextColor();
        }
        resetTextColor();
    }

    private void initTextWatcher() {
        addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                MaterialAutoCompleteTextView.this.checkCharactersCount();
                if (MaterialAutoCompleteTextView.this.autoValidate) {
                    MaterialAutoCompleteTextView.this.validate();
                } else {
                    MaterialAutoCompleteTextView.this.setError((CharSequence) null);
                }
                MaterialAutoCompleteTextView.this.postInvalidate();
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
    }

    private boolean insideClearButton(MotionEvent motionEvent) {
        int i11;
        int i12;
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        int scrollX = getScrollX();
        if (this.iconLeftBitmaps == null) {
            i11 = 0;
        } else {
            i11 = this.iconOuterWidth + this.iconPadding;
        }
        int i13 = scrollX + i11;
        int scrollX2 = getScrollX();
        if (this.iconRightBitmaps == null) {
            i12 = getWidth();
        } else {
            i12 = (getWidth() - this.iconOuterWidth) - this.iconPadding;
        }
        int i14 = scrollX2 + i12;
        if (!isRTL()) {
            i13 = i14 - this.iconOuterWidth;
        }
        int scrollY = ((getScrollY() + getHeight()) - getPaddingBottom()) + this.bottomSpacing;
        int i15 = this.iconOuterHeight;
        int i16 = scrollY - i15;
        if (x11 < ((float) i13) || x11 >= ((float) (i13 + this.iconOuterWidth)) || y11 < ((float) i16) || y11 >= ((float) (i16 + i15))) {
            return false;
        }
        return true;
    }

    private boolean isInternalValid() {
        return this.tempErrorText == null && isCharactersCountValid();
    }

    @TargetApi(17)
    private boolean isRTL() {
        if (getResources().getConfiguration().getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private void resetHintTextColor() {
        ColorStateList colorStateList = this.textColorHintStateList;
        if (colorStateList == null) {
            setHintTextColor((this.baseColor & 16777215) | 1140850688);
        } else {
            setHintTextColor(colorStateList);
        }
    }

    private void resetTextColor() {
        ColorStateList colorStateList = this.textColorStateList;
        if (colorStateList == null) {
            int[][] iArr = {new int[]{16842910}, AutoCompleteTextView.EMPTY_STATE_SET};
            int i11 = this.baseColor;
            ColorStateList colorStateList2 = new ColorStateList(iArr, new int[]{(i11 & 16777215) | -553648128, (i11 & 16777215) | 1140850688});
            this.textColorStateList = colorStateList2;
            setTextColor(colorStateList2);
            return;
        }
        setTextColor(colorStateList);
    }

    private Bitmap scaleIcon(Bitmap bitmap) {
        int i11;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int max = Math.max(width, height);
        int i12 = this.iconSize;
        if (max == i12 || max <= i12) {
            return bitmap;
        }
        if (width > i12) {
            i11 = (int) (((float) i12) * (((float) height) / ((float) width)));
        } else {
            int i13 = i12;
            i12 = (int) (((float) i12) * (((float) width) / ((float) height)));
            i11 = i13;
        }
        return Bitmap.createScaledBitmap(bitmap, i12, i11, false);
    }

    private void setFloatingLabelInternal(int i11) {
        if (i11 == 1) {
            this.floatingLabelEnabled = true;
            this.highlightFloatingLabel = false;
        } else if (i11 != 2) {
            this.floatingLabelEnabled = false;
            this.highlightFloatingLabel = false;
        } else {
            this.floatingLabelEnabled = true;
            this.highlightFloatingLabel = true;
        }
    }

    public MaterialAutoCompleteTextView addValidator(METValidator mETValidator) {
        if (this.validators == null) {
            this.validators = new ArrayList();
        }
        this.validators.add(mETValidator);
        return this;
    }

    public void clearValidators() {
        List<METValidator> list = this.validators;
        if (list != null) {
            list.clear();
        }
    }

    @Nullable
    public Typeface getAccentTypeface() {
        return this.accentTypeface;
    }

    public int getBottomTextSize() {
        return this.bottomTextSize;
    }

    public float getCurrentBottomLines() {
        return this.currentBottomLines;
    }

    public CharSequence getError() {
        return this.tempErrorText;
    }

    public int getErrorColor() {
        return this.errorColor;
    }

    public float getFloatingLabelFraction() {
        return this.floatingLabelFraction;
    }

    public int getFloatingLabelPadding() {
        return this.floatingLabelPadding;
    }

    public CharSequence getFloatingLabelText() {
        return this.floatingLabelText;
    }

    public int getFloatingLabelTextColor() {
        return this.floatingLabelTextColor;
    }

    public int getFloatingLabelTextSize() {
        return this.floatingLabelTextSize;
    }

    public float getFocusFraction() {
        return this.focusFraction;
    }

    public String getHelperText() {
        return this.helperText;
    }

    public int getHelperTextColor() {
        return this.helperTextColor;
    }

    public int getInnerPaddingBottom() {
        return this.innerPaddingBottom;
    }

    public int getInnerPaddingLeft() {
        return this.innerPaddingLeft;
    }

    public int getInnerPaddingRight() {
        return this.innerPaddingRight;
    }

    public int getInnerPaddingTop() {
        return this.innerPaddingTop;
    }

    public int getMaxCharacters() {
        return this.maxCharacters;
    }

    public int getMinBottomTextLines() {
        return this.minBottomTextLines;
    }

    public int getMinCharacters() {
        return this.minCharacters;
    }

    public int getUnderlineColor() {
        return this.underlineColor;
    }

    @Nullable
    public List<METValidator> getValidators() {
        return this.validators;
    }

    public boolean hasValidators() {
        List<METValidator> list = this.validators;
        return list != null && !list.isEmpty();
    }

    public boolean isAutoValidate() {
        return this.autoValidate;
    }

    public boolean isCharactersCountValid() {
        return this.charactersCountValid;
    }

    public boolean isFloatingLabelAlwaysShown() {
        return this.floatingLabelAlwaysShown;
    }

    public boolean isFloatingLabelAnimating() {
        return this.floatingLabelAnimating;
    }

    public boolean isHelperTextAlwaysShown() {
        return this.helperTextAlwaysShown;
    }

    public boolean isHideUnderline() {
        return this.hideUnderline;
    }

    public boolean isShowClearButton() {
        return this.showClearButton;
    }

    @Deprecated
    public boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile(str).matcher(getText()).matches();
    }

    public boolean isValidateOnFocusLost() {
        return this.validateOnFocusLost;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.firstShown) {
            this.firstShown = true;
        }
    }

    public void onDraw(@NonNull Canvas canvas) {
        int i11;
        int i12;
        int i13;
        int i14;
        float f11;
        float f12;
        int i15;
        int i16;
        float f13;
        int i17;
        int i18;
        char c11;
        char c12;
        Canvas canvas2 = canvas;
        int scrollX = getScrollX();
        if (this.iconLeftBitmaps == null) {
            i11 = 0;
        } else {
            i11 = this.iconOuterWidth + this.iconPadding;
        }
        int i19 = scrollX + i11;
        int scrollX2 = getScrollX();
        if (this.iconRightBitmaps == null) {
            i12 = getWidth();
        } else {
            i12 = (getWidth() - this.iconOuterWidth) - this.iconPadding;
        }
        int i21 = scrollX2 + i12;
        int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
        this.f52720b.setAlpha(255);
        Bitmap[] bitmapArr = this.iconLeftBitmaps;
        int i22 = 1;
        if (bitmapArr != null) {
            if (!isInternalValid()) {
                c12 = 3;
            } else if (!isEnabled()) {
                c12 = 2;
            } else if (hasFocus()) {
                c12 = 1;
            } else {
                c12 = 0;
            }
            Bitmap bitmap = bitmapArr[c12];
            int i23 = this.iconOuterWidth;
            int width = ((i19 - this.iconPadding) - i23) + ((i23 - bitmap.getWidth()) / 2);
            int i24 = this.iconOuterHeight;
            canvas2.drawBitmap(bitmap, (float) width, (float) (((this.bottomSpacing + scrollY) - i24) + ((i24 - bitmap.getHeight()) / 2)), this.f52720b);
        }
        Bitmap[] bitmapArr2 = this.iconRightBitmaps;
        if (bitmapArr2 != null) {
            if (!isInternalValid()) {
                c11 = 3;
            } else if (!isEnabled()) {
                c11 = 2;
            } else if (hasFocus()) {
                c11 = 1;
            } else {
                c11 = 0;
            }
            Bitmap bitmap2 = bitmapArr2[c11];
            int width2 = this.iconPadding + i21 + ((this.iconOuterWidth - bitmap2.getWidth()) / 2);
            int i25 = this.iconOuterHeight;
            canvas2.drawBitmap(bitmap2, (float) width2, (float) (((this.bottomSpacing + scrollY) - i25) + ((i25 - bitmap2.getHeight()) / 2)), this.f52720b);
        }
        if (hasFocus() && this.showClearButton && !TextUtils.isEmpty(getText()) && isEnabled()) {
            this.f52720b.setAlpha(255);
            if (isRTL()) {
                i18 = i19;
            } else {
                i18 = i21 - this.iconOuterWidth;
            }
            Bitmap bitmap3 = this.clearButtonBitmaps[0];
            int width3 = i18 + ((this.iconOuterWidth - bitmap3.getWidth()) / 2);
            int i26 = this.iconOuterHeight;
            canvas2.drawBitmap(bitmap3, (float) width3, (float) (((this.bottomSpacing + scrollY) - i26) + ((i26 - bitmap3.getHeight()) / 2)), this.f52720b);
        }
        if (!this.hideUnderline) {
            int i27 = scrollY + this.bottomSpacing;
            if (!isInternalValid()) {
                this.f52720b.setColor(this.errorColor);
                i17 = i27;
                canvas.drawRect((float) i19, (float) i27, (float) i21, (float) (getPixel(2) + i27), this.f52720b);
            } else {
                i17 = i27;
                if (!isEnabled()) {
                    Paint paint = this.f52720b;
                    int i28 = this.underlineColor;
                    if (i28 == -1) {
                        i28 = (this.baseColor & 16777215) | 1140850688;
                    }
                    paint.setColor(i28);
                    float pixel = (float) getPixel(1);
                    float f14 = 0.0f;
                    while (f14 < ((float) getWidth())) {
                        float f15 = ((float) i19) + f14;
                        float f16 = pixel;
                        canvas.drawRect(f15, (float) i17, f15 + pixel, (float) (getPixel(1) + i17), this.f52720b);
                        f14 += f16 * 3.0f;
                        pixel = f16;
                    }
                } else if (hasFocus()) {
                    this.f52720b.setColor(this.primaryColor);
                    canvas.drawRect((float) i19, (float) i17, (float) i21, (float) (i17 + getPixel(2)), this.f52720b);
                } else {
                    Paint paint2 = this.f52720b;
                    int i29 = this.underlineColor;
                    if (i29 == -1) {
                        i29 = (this.baseColor & 16777215) | 503316480;
                    }
                    paint2.setColor(i29);
                    canvas.drawRect((float) i19, (float) i17, (float) i21, (float) (i17 + getPixel(1)), this.f52720b);
                }
            }
            scrollY = i17;
        }
        this.f52721c.setTextSize((float) this.bottomTextSize);
        Paint.FontMetrics fontMetrics = this.f52721c.getFontMetrics();
        float f17 = fontMetrics.ascent;
        float f18 = fontMetrics.descent;
        float f19 = (-f17) - f18;
        float f21 = ((float) this.bottomTextSize) + f17 + f18;
        if ((hasFocus() && hasCharactersCounter()) || !isCharactersCountValid()) {
            TextPaint textPaint = this.f52721c;
            if (isCharactersCountValid()) {
                i16 = (this.baseColor & 16777215) | 1140850688;
            } else {
                i16 = this.errorColor;
            }
            textPaint.setColor(i16);
            String charactersCounterText = getCharactersCounterText();
            if (isRTL()) {
                f13 = (float) i19;
            } else {
                f13 = ((float) i21) - this.f52721c.measureText(charactersCounterText);
            }
            canvas2.drawText(charactersCounterText, f13, ((float) (this.bottomSpacing + scrollY)) + f19, this.f52721c);
        }
        if (this.f52722d != null && (this.tempErrorText != null || ((this.helperTextAlwaysShown || hasFocus()) && !TextUtils.isEmpty(this.helperText)))) {
            TextPaint textPaint2 = this.f52721c;
            if (this.tempErrorText != null) {
                i15 = this.errorColor;
            } else {
                i15 = this.helperTextColor;
                if (i15 == -1) {
                    i15 = (this.baseColor & 16777215) | 1140850688;
                }
            }
            textPaint2.setColor(i15);
            canvas.save();
            if (isRTL()) {
                canvas2.translate((float) (i21 - this.f52722d.getWidth()), ((float) (this.bottomSpacing + scrollY)) - f21);
            } else {
                canvas2.translate((float) (getBottomTextLeftOffset() + i19), ((float) (this.bottomSpacing + scrollY)) - f21);
            }
            this.f52722d.draw(canvas2);
            canvas.restore();
        }
        if (this.floatingLabelEnabled && !TextUtils.isEmpty(this.floatingLabelText)) {
            this.f52721c.setTextSize((float) this.floatingLabelTextSize);
            TextPaint textPaint3 = this.f52721c;
            ArgbEvaluator argbEvaluator = this.focusEvaluator;
            float f22 = this.focusFraction * (isEnabled() ? 1.0f : 0.0f);
            int i31 = this.floatingLabelTextColor;
            if (i31 == -1) {
                i31 = (this.baseColor & 16777215) | 1140850688;
            }
            textPaint3.setColor(((Integer) argbEvaluator.evaluate(f22, Integer.valueOf(i31), Integer.valueOf(this.primaryColor))).intValue());
            float measureText = this.f52721c.measureText(this.floatingLabelText.toString());
            if ((getGravity() & 5) == 5 || isRTL()) {
                i14 = (int) (((float) i21) - measureText);
            } else if ((getGravity() & 3) == 3) {
                i14 = i19;
            } else {
                i14 = ((int) (((float) getInnerPaddingLeft()) + ((((float) ((getWidth() - getInnerPaddingLeft()) - getInnerPaddingRight())) - measureText) / 2.0f))) + i19;
            }
            int i32 = this.floatingLabelPadding;
            float f23 = (float) (this.innerPaddingTop + this.floatingLabelTextSize + i32);
            float f24 = (float) i32;
            float f25 = 1.0f;
            if (this.floatingLabelAlwaysShown) {
                f11 = 1.0f;
            } else {
                f11 = this.floatingLabelFraction;
            }
            int scrollY2 = (int) ((f23 - (f24 * f11)) + ((float) getScrollY()));
            if (this.floatingLabelAlwaysShown) {
                f12 = 1.0f;
            } else {
                f12 = this.floatingLabelFraction;
            }
            float f26 = f12 * 255.0f * ((this.focusFraction * 0.74f * (isEnabled() ? 1.0f : 0.0f)) + 0.26f);
            int i33 = this.floatingLabelTextColor;
            if (i33 == -1) {
                f25 = ((float) Color.alpha(i33)) / 256.0f;
            }
            this.f52721c.setAlpha((int) (f26 * f25));
            canvas2.drawText(this.floatingLabelText.toString(), (float) i14, (float) scrollY2, this.f52721c);
        }
        if (hasFocus() && this.singleLineEllipsis && getScrollX() != 0) {
            Paint paint3 = this.f52720b;
            if (isInternalValid()) {
                i13 = this.primaryColor;
            } else {
                i13 = this.errorColor;
            }
            paint3.setColor(i13);
            float f27 = (float) (scrollY + this.bottomSpacing);
            if (isRTL()) {
                i19 = i21;
            }
            if (isRTL()) {
                i22 = -1;
            }
            int i34 = this.bottomEllipsisSize;
            canvas2.drawCircle((float) (((i22 * i34) / 2) + i19), ((float) (i34 / 2)) + f27, (float) (i34 / 2), this.f52720b);
            int i35 = this.bottomEllipsisSize;
            canvas2.drawCircle((float) ((((i22 * i35) * 5) / 2) + i19), ((float) (i35 / 2)) + f27, (float) (i35 / 2), this.f52720b);
            int i36 = this.bottomEllipsisSize;
            canvas2.drawCircle((float) (i19 + (((i22 * i36) * 9) / 2)), f27 + ((float) (i36 / 2)), (float) (i36 / 2), this.f52720b);
        }
        super.onDraw(canvas);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (z11) {
            adjustBottomLines();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.singleLineEllipsis || getScrollX() <= 0 || motionEvent.getAction() != 0 || motionEvent.getX() >= ((float) getPixel(20)) || motionEvent.getY() <= ((float) ((getHeight() - this.extraPaddingBottom) - this.innerPaddingBottom)) || motionEvent.getY() >= ((float) (getHeight() - this.innerPaddingBottom))) {
            if (hasFocus() && this.showClearButton && isEnabled()) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        if (this.clearButtonClicking) {
                            if (!TextUtils.isEmpty(getText())) {
                                setText((CharSequence) null);
                            }
                            this.clearButtonClicking = false;
                        }
                        if (this.clearButtonTouched) {
                            this.clearButtonTouched = false;
                            return true;
                        }
                        this.clearButtonTouched = false;
                    } else if (action != 2) {
                        if (action == 3) {
                            this.clearButtonTouched = false;
                            this.clearButtonClicking = false;
                        }
                    }
                } else if (insideClearButton(motionEvent)) {
                    this.clearButtonTouched = true;
                    this.clearButtonClicking = true;
                    return true;
                }
                if (this.clearButtonClicking && !insideClearButton(motionEvent)) {
                    this.clearButtonClicking = false;
                }
                if (this.clearButtonTouched) {
                    return true;
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        setSelection(0);
        return false;
    }

    public void setAccentTypeface(Typeface typeface2) {
        this.accentTypeface = typeface2;
        this.f52721c.setTypeface(typeface2);
        postInvalidate();
    }

    public void setAutoValidate(boolean z11) {
        this.autoValidate = z11;
        if (z11) {
            validate();
        }
    }

    public void setBaseColor(int i11) {
        if (this.baseColor != i11) {
            this.baseColor = i11;
        }
        initText();
        postInvalidate();
    }

    public void setBottomTextSize(int i11) {
        this.bottomTextSize = i11;
        initPadding();
    }

    public void setCurrentBottomLines(float f11) {
        this.currentBottomLines = f11;
        initPadding();
    }

    public void setError(CharSequence charSequence) {
        String str;
        if (charSequence == null) {
            str = null;
        } else {
            str = charSequence.toString();
        }
        this.tempErrorText = str;
        if (adjustBottomLines()) {
            postInvalidate();
        }
    }

    public void setErrorColor(int i11) {
        this.errorColor = i11;
        postInvalidate();
    }

    public void setFloatingLabel(@FloatingLabelType int i11) {
        setFloatingLabelInternal(i11);
        initPadding();
    }

    public void setFloatingLabelAlwaysShown(boolean z11) {
        this.floatingLabelAlwaysShown = z11;
        invalidate();
    }

    public void setFloatingLabelAnimating(boolean z11) {
        this.floatingLabelAnimating = z11;
    }

    public void setFloatingLabelFraction(float f11) {
        this.floatingLabelFraction = f11;
        invalidate();
    }

    public void setFloatingLabelPadding(int i11) {
        this.floatingLabelPadding = i11;
        postInvalidate();
    }

    public void setFloatingLabelText(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = getHint();
        }
        this.floatingLabelText = charSequence;
        postInvalidate();
    }

    public void setFloatingLabelTextColor(int i11) {
        this.floatingLabelTextColor = i11;
        postInvalidate();
    }

    public void setFloatingLabelTextSize(int i11) {
        this.floatingLabelTextSize = i11;
        initPadding();
    }

    public void setFocusFraction(float f11) {
        this.focusFraction = f11;
        invalidate();
    }

    public void setHelperText(CharSequence charSequence) {
        String str;
        if (charSequence == null) {
            str = null;
        } else {
            str = charSequence.toString();
        }
        this.helperText = str;
        if (adjustBottomLines()) {
            postInvalidate();
        }
    }

    public void setHelperTextAlwaysShown(boolean z11) {
        this.helperTextAlwaysShown = z11;
        invalidate();
    }

    public void setHelperTextColor(int i11) {
        this.helperTextColor = i11;
        postInvalidate();
    }

    public void setHideUnderline(boolean z11) {
        this.hideUnderline = z11;
        initPadding();
        postInvalidate();
    }

    public void setIconLeft(@DrawableRes int i11) {
        this.iconLeftBitmaps = generateIconBitmaps(i11);
        initPadding();
    }

    public void setIconRight(@DrawableRes int i11) {
        this.iconRightBitmaps = generateIconBitmaps(i11);
        initPadding();
    }

    public void setLengthChecker(METLengthChecker mETLengthChecker) {
        this.lengthChecker = mETLengthChecker;
    }

    public void setMaxCharacters(int i11) {
        this.maxCharacters = i11;
        initMinBottomLines();
        initPadding();
        postInvalidate();
    }

    public void setMetHintTextColor(int i11) {
        this.textColorHintStateList = ColorStateList.valueOf(i11);
        resetHintTextColor();
    }

    public void setMetTextColor(int i11) {
        this.textColorStateList = ColorStateList.valueOf(i11);
        resetTextColor();
    }

    public void setMinBottomTextLines(int i11) {
        this.minBottomTextLines = i11;
        initMinBottomLines();
        initPadding();
        postInvalidate();
    }

    public void setMinCharacters(int i11) {
        this.minCharacters = i11;
        initMinBottomLines();
        initPadding();
        postInvalidate();
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        if (this.f52726h == null) {
            super.setOnFocusChangeListener(onFocusChangeListener);
        } else {
            this.f52727i = onFocusChangeListener;
        }
    }

    @Deprecated
    public final void setPadding(int i11, int i12, int i13, int i14) {
        super.setPadding(i11, i12, i13, i14);
    }

    public void setPaddings(int i11, int i12, int i13, int i14) {
        this.innerPaddingTop = i12;
        this.innerPaddingBottom = i14;
        this.innerPaddingLeft = i11;
        this.innerPaddingRight = i13;
        correctPaddings();
    }

    public void setPrimaryColor(int i11) {
        this.primaryColor = i11;
        postInvalidate();
    }

    public void setShowClearButton(boolean z11) {
        this.showClearButton = z11;
        correctPaddings();
    }

    public void setSingleLineEllipsis() {
        setSingleLineEllipsis(true);
    }

    public void setUnderlineColor(int i11) {
        this.underlineColor = i11;
        postInvalidate();
    }

    public void setValidateOnFocusLost(boolean z11) {
        this.validateOnFocusLost = z11;
    }

    @Deprecated
    public boolean validate(String str, CharSequence charSequence) {
        boolean isValid = isValid(str);
        if (!isValid) {
            setError(charSequence);
        }
        postInvalidate();
        return isValid;
    }

    public boolean validateWith(@NonNull METValidator mETValidator) {
        boolean z11;
        Editable text = getText();
        if (text.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean isValid = mETValidator.isValid(text, z11);
        if (!isValid) {
            setError(mETValidator.getErrorMessage());
        }
        postInvalidate();
        return isValid;
    }

    public void setSingleLineEllipsis(boolean z11) {
        this.singleLineEllipsis = z11;
        initMinBottomLines();
        initPadding();
        postInvalidate();
    }

    public void setIconLeft(Drawable drawable) {
        this.iconLeftBitmaps = generateIconBitmaps(drawable);
        initPadding();
    }

    public void setIconRight(Drawable drawable) {
        this.iconRightBitmaps = generateIconBitmaps(drawable);
        initPadding();
    }

    public void setMetHintTextColor(ColorStateList colorStateList) {
        this.textColorHintStateList = colorStateList;
        resetHintTextColor();
    }

    public void setMetTextColor(ColorStateList colorStateList) {
        this.textColorStateList = colorStateList;
        resetTextColor();
    }

    public boolean validate() {
        List<METValidator> list = this.validators;
        if (list == null || list.isEmpty()) {
            return true;
        }
        Editable text = getText();
        boolean z11 = text.length() == 0;
        Iterator<METValidator> it = this.validators.iterator();
        boolean z12 = true;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            METValidator next = it.next();
            if (!z12 || !next.isValid(text, z11)) {
                z12 = false;
                continue;
            } else {
                z12 = true;
                continue;
            }
            if (!z12) {
                setError(next.getErrorMessage());
                break;
            }
        }
        if (z12) {
            setError((CharSequence) null);
        }
        postInvalidate();
        return z12;
    }

    public void setIconLeft(Bitmap bitmap) {
        this.iconLeftBitmaps = generateIconBitmaps(bitmap);
        initPadding();
    }

    public void setIconRight(Bitmap bitmap) {
        this.iconRightBitmaps = generateIconBitmaps(bitmap);
        initPadding();
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private Bitmap[] generateIconBitmaps(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        int i11 = this.iconSize;
        return generateIconBitmaps(Bitmap.createScaledBitmap(createBitmap, i11, i11, false));
    }

    @TargetApi(21)
    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }

    private Bitmap[] generateIconBitmaps(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap[] bitmapArr = new Bitmap[4];
        Bitmap scaleIcon = scaleIcon(bitmap);
        bitmapArr[0] = scaleIcon.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bitmapArr[0]);
        int i11 = this.baseColor;
        canvas.drawColor((Colors.isLight(i11) ? ViewCompat.MEASURED_STATE_MASK : -1979711488) | (i11 & 16777215), PorterDuff.Mode.SRC_IN);
        bitmapArr[1] = scaleIcon.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(bitmapArr[1]).drawColor(this.primaryColor, PorterDuff.Mode.SRC_IN);
        bitmapArr[2] = scaleIcon.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas2 = new Canvas(bitmapArr[2]);
        int i12 = this.baseColor;
        canvas2.drawColor((Colors.isLight(i12) ? 1275068416 : 1107296256) | (16777215 & i12), PorterDuff.Mode.SRC_IN);
        bitmapArr[3] = scaleIcon.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(bitmapArr[3]).drawColor(this.errorColor, PorterDuff.Mode.SRC_IN);
        return bitmapArr;
    }
}
