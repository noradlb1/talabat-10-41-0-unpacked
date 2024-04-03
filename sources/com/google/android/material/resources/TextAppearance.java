package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextPaint;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextAppearance {
    private static final String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    /* access modifiers changed from: private */
    public Typeface font;
    @Nullable
    public final String fontFamily;
    @FontRes
    private final int fontFamilyResourceId;
    /* access modifiers changed from: private */
    public boolean fontResolved = false;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;
    @Nullable
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;
    @Nullable
    private ColorStateList textColor;
    @Nullable
    public final ColorStateList textColorHint;
    @Nullable
    public final ColorStateList textColorLink;
    private float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(@NonNull Context context, @StyleRes int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i11, R.styleable.TextAppearance);
        setTextSize(obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f));
        setTextColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor));
        this.textColorHint = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int indexWithValue = MaterialResources.getIndexWithValue(obtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = obtainStyledAttributes.getResourceId(indexWithValue, 0);
        this.fontFamily = obtainStyledAttributes.getString(indexWithValue);
        this.textAllCaps = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i11, R.styleable.MaterialTextAppearance);
        int i12 = R.styleable.MaterialTextAppearance_android_letterSpacing;
        this.hasLetterSpacing = obtainStyledAttributes2.hasValue(i12);
        this.letterSpacing = obtainStyledAttributes2.getFloat(i12, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    private void createFallbackFont() {
        String str;
        if (this.font == null && (str = this.fontFamily) != null) {
            this.font = Typeface.create(str, this.textStyle);
        }
        if (this.font == null) {
            int i11 = this.typeface;
            if (i11 == 1) {
                this.font = Typeface.SANS_SERIF;
            } else if (i11 == 2) {
                this.font = Typeface.SERIF;
            } else if (i11 != 3) {
                this.font = Typeface.DEFAULT;
            } else {
                this.font = Typeface.MONOSPACE;
            }
            this.font = Typeface.create(this.font, this.textStyle);
        }
    }

    private boolean shouldLoadFontSynchronously(Context context) {
        Typeface typeface2;
        if (TextAppearanceConfig.shouldLoadFontSynchronously()) {
            return true;
        }
        int i11 = this.fontFamilyResourceId;
        if (i11 != 0) {
            typeface2 = ResourcesCompat.getCachedFont(context, i11);
        } else {
            typeface2 = null;
        }
        if (typeface2 != null) {
            return true;
        }
        return false;
    }

    public Typeface getFallbackFont() {
        createFallbackFont();
        return this.font;
    }

    @VisibleForTesting
    @NonNull
    public Typeface getFont(@NonNull Context context) {
        if (this.fontResolved) {
            return this.font;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font2 = ResourcesCompat.getFont(context, this.fontFamilyResourceId);
                this.font = font2;
                if (font2 != null) {
                    this.font = Typeface.create(font2, this.textStyle);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception unused2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error loading font ");
                sb2.append(this.fontFamily);
            }
        }
        createFallbackFont();
        this.fontResolved = true;
        return this.font;
    }

    public void getFontAsync(@NonNull Context context, @NonNull final TextAppearanceFontCallback textAppearanceFontCallback) {
        if (shouldLoadFontSynchronously(context)) {
            getFont(context);
        } else {
            createFallbackFont();
        }
        int i11 = this.fontFamilyResourceId;
        if (i11 == 0) {
            this.fontResolved = true;
        }
        if (this.fontResolved) {
            textAppearanceFontCallback.onFontRetrieved(this.font, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i11, new ResourcesCompat.FontCallback() {
                public void onFontRetrievalFailed(int i11) {
                    boolean unused = TextAppearance.this.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrievalFailed(i11);
                }

                public void onFontRetrieved(@NonNull Typeface typeface) {
                    TextAppearance textAppearance = TextAppearance.this;
                    Typeface unused = textAppearance.font = Typeface.create(typeface, textAppearance.textStyle);
                    boolean unused2 = TextAppearance.this.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrieved(TextAppearance.this.font, false);
                }
            }, (Handler) null);
        } catch (Resources.NotFoundException unused) {
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(1);
        } catch (Exception unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error loading font ");
            sb2.append(this.fontFamily);
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(-3);
        }
    }

    @Nullable
    public ColorStateList getTextColor() {
        return this.textColor;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        this.textColor = colorStateList;
    }

    public void setTextSize(float f11) {
        this.textSize = f11;
    }

    public void updateDrawState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        int i11;
        int i12;
        updateMeasureState(context, textPaint, textAppearanceFontCallback);
        ColorStateList colorStateList = this.textColor;
        if (colorStateList != null) {
            i11 = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
        } else {
            i11 = ViewCompat.MEASURED_STATE_MASK;
        }
        textPaint.setColor(i11);
        float f11 = this.shadowRadius;
        float f12 = this.shadowDx;
        float f13 = this.shadowDy;
        ColorStateList colorStateList2 = this.shadowColor;
        if (colorStateList2 != null) {
            i12 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
        } else {
            i12 = 0;
        }
        textPaint.setShadowLayer(f11, f12, f13, i12);
    }

    public void updateMeasureState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        if (shouldLoadFontSynchronously(context)) {
            updateTextPaintMeasureState(textPaint, getFont(context));
        } else {
            getFontAsync(context, textPaint, textAppearanceFontCallback);
        }
    }

    public void updateTextPaintMeasureState(@NonNull TextPaint textPaint, @NonNull Typeface typeface2) {
        boolean z11;
        float f11;
        textPaint.setTypeface(typeface2);
        int i11 = (~typeface2.getStyle()) & this.textStyle;
        if ((i11 & 1) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        textPaint.setFakeBoldText(z11);
        if ((i11 & 2) != 0) {
            f11 = -0.25f;
        } else {
            f11 = 0.0f;
        }
        textPaint.setTextSkewX(f11);
        textPaint.setTextSize(this.textSize);
        if (this.hasLetterSpacing) {
            textPaint.setLetterSpacing(this.letterSpacing);
        }
    }

    public void getFontAsync(@NonNull Context context, @NonNull final TextPaint textPaint, @NonNull final TextAppearanceFontCallback textAppearanceFontCallback) {
        updateTextPaintMeasureState(textPaint, getFallbackFont());
        getFontAsync(context, new TextAppearanceFontCallback() {
            public void onFontRetrievalFailed(int i11) {
                textAppearanceFontCallback.onFontRetrievalFailed(i11);
            }

            public void onFontRetrieved(@NonNull Typeface typeface, boolean z11) {
                TextAppearance.this.updateTextPaintMeasureState(textPaint, typeface);
                textAppearanceFontCallback.onFontRetrieved(typeface, z11);
            }
        });
    }
}
