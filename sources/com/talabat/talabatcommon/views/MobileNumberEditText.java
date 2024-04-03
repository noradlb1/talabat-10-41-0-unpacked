package com.talabat.talabatcommon.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import com.materialedittext.MaterialEditText;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0014J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/talabat/talabatcommon/views/MobileNumberEditText;", "Lcom/materialedittext/MaterialEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "calculatedLeftPadding", "", "countryCodeColor", "getCountryCodeColor", "()I", "countryCodeColor$delegate", "Lkotlin/Lazy;", "countryCodeTextPaint", "Landroid/text/TextPaint;", "getCountryCodeTextPaint", "()Landroid/text/TextPaint;", "countryCodeTextPaint$delegate", "countryCodeToDraw", "", "calculatePrefix", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setCountryCode", "countryCode", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"RtlHardcoded"})
public final class MobileNumberEditText extends MaterialEditText {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    private float calculatedLeftPadding;
    @NotNull
    private final Lazy countryCodeColor$delegate;
    @NotNull
    private final Lazy countryCodeTextPaint$delegate;
    @Nullable
    private String countryCodeToDraw;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MobileNumberEditText(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MobileNumberEditText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MobileNumberEditText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.countryCodeTextPaint$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, MobileNumberEditText$countryCodeTextPaint$2.INSTANCE);
        this.countryCodeColor$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new MobileNumberEditText$countryCodeColor$2(context));
        this.calculatedLeftPadding = -1.0f;
        if (isRTLDirection()) {
            setTextDirection(3);
            setGravity(3);
        }
    }

    private final void calculatePrefix() {
        boolean z11;
        String str = this.countryCodeToDraw;
        if (this.calculatedLeftPadding == -1.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && str != null) {
            float[] fArr = new float[str.length()];
            getPaint().getTextWidths(str, fArr);
            this.calculatedLeftPadding = (float) getCompoundPaddingLeft();
            setPaddings((int) (ArraysKt___ArraysKt.sum(fArr) + this.calculatedLeftPadding), 0, getPaddingRight(), 0);
        }
    }

    private final int getCountryCodeColor() {
        return ((Number) this.countryCodeColor$delegate.getValue()).intValue();
    }

    private final TextPaint getCountryCodeTextPaint() {
        return (TextPaint) this.countryCodeTextPaint$delegate.getValue();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        String str = this.countryCodeToDraw;
        if (str != null) {
            TextPaint countryCodeTextPaint = getCountryCodeTextPaint();
            countryCodeTextPaint.set(getPaint());
            countryCodeTextPaint.setColor(getCountryCodeColor());
            canvas.drawText(str, this.calculatedLeftPadding, (float) getLineBounds(0, (Rect) null), getCountryCodeTextPaint());
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        calculatePrefix();
    }

    public final void setCountryCode(int i11) {
        this.countryCodeToDraw = "+" + i11 + " - ";
        invalidate();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MobileNumberEditText(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.editTextStyle : i11);
    }
}
