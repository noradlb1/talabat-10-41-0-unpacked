package com.talabat.talabatcommon.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.talabat.talabatcommon.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\f¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/views/TalabatRateView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "applyFontSize", "", "attributeFloatValue", "", "setRateValue", "rateValue", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatRateView extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TalabatRateView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TalabatRateView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TalabatRateView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.view_rate_widget, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.RateWidget, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyl…ateWidget, 0, 0\n        )");
        applyFontSize(((float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.RateWidget_statusFontSize, 0)) / getResources().getDisplayMetrics().scaledDensity);
    }

    private final void applyFontSize(float f11) {
        ((TextView) _$_findCachedViewById(R.id.vendorRateStatusM)).setTextSize(f11);
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

    public final void setRateValue(float f11) {
        if (f11 <= 2.7f) {
            ((ImageView) _$_findCachedViewById(R.id.vendorRateAvatar)).setImageResource(R.drawable.ic_vendor_rate_ok);
            ((TextView) _$_findCachedViewById(R.id.vendorRateStatusM)).setText(com.talabat.localization.R.string.rate_fair);
        } else if (f11 <= 3.7f) {
            ((ImageView) _$_findCachedViewById(R.id.vendorRateAvatar)).setImageResource(R.drawable.ic_vendor_rate_good);
            ((TextView) _$_findCachedViewById(R.id.vendorRateStatusM)).setText(com.talabat.localization.R.string.rate_okay);
        } else if (f11 <= 4.5f) {
            ((ImageView) _$_findCachedViewById(R.id.vendorRateAvatar)).setImageResource(R.drawable.ic_vendor_rate_very_good);
            ((TextView) _$_findCachedViewById(R.id.vendorRateStatusM)).setText(com.talabat.localization.R.string.rate_very_good);
        } else {
            ((ImageView) _$_findCachedViewById(R.id.vendorRateAvatar)).setImageResource(R.drawable.ic_vendor_rate_amazing);
            ((TextView) _$_findCachedViewById(R.id.vendorRateStatusM)).setText(com.talabat.localization.R.string.rate_amazing);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TalabatRateView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
