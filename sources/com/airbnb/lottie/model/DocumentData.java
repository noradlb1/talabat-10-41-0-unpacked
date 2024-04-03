package com.airbnb.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DocumentData {
    public float baselineShift;
    @ColorInt
    public int color;
    public String fontName;
    public Justification justification;
    public float lineHeight;
    public float size;
    @ColorInt
    public int strokeColor;
    public boolean strokeOverFill;
    public float strokeWidth;
    public String text;

    /* renamed from: tracking  reason: collision with root package name */
    public int f40642tracking;

    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f11, Justification justification2, int i11, float f12, float f13, @ColorInt int i12, @ColorInt int i13, float f14, boolean z11) {
        set(str, str2, f11, justification2, i11, f12, f13, i12, i13, f14, z11);
    }

    public int hashCode() {
        int hashCode = (((((int) (((float) (((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31)) + this.size)) * 31) + this.justification.ordinal()) * 31) + this.f40642tracking;
        long floatToRawIntBits = (long) Float.floatToRawIntBits(this.lineHeight);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.color;
    }

    public void set(String str, String str2, float f11, Justification justification2, int i11, float f12, float f13, @ColorInt int i12, @ColorInt int i13, float f14, boolean z11) {
        this.text = str;
        this.fontName = str2;
        this.size = f11;
        this.justification = justification2;
        this.f40642tracking = i11;
        this.lineHeight = f12;
        this.baselineShift = f13;
        this.color = i12;
        this.strokeColor = i13;
        this.strokeWidth = f14;
        this.strokeOverFill = z11;
    }

    public DocumentData() {
    }
}
