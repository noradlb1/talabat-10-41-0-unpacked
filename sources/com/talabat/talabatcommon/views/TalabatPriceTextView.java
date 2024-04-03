package com.talabat.talabatcommon.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.LocationExtensionsKt;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/talabatcommon/views/TalabatPriceTextView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "rawText", "", "showCurrency", "", "getText", "", "setText", "", "text", "type", "Landroid/widget/TextView$BufferType;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatPriceTextView extends TextView {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private String rawText;
    private boolean showCurrency;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatPriceTextView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rawText = "";
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

    @NotNull
    public CharSequence getText() {
        return this.rawText;
    }

    public void setText(@NotNull CharSequence charSequence, @NotNull TextView.BufferType bufferType) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(bufferType, "type");
        this.rawText = charSequence.toString();
        Country selectedCountry = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationRemoteCoreLibApi.class)).getLocationConfigurationRepository().selectedCountry();
        Intrinsics.checkNotNull(selectedCountry);
        super.setText(CurrencyFormatter.Companion.getFormattedCurrency(this.rawText, this.showCurrency, selectedCountry.getCurrencyCode(), selectedCountry.getNumberOfDecimalPlaces(), LocationExtensionsKt.decimalPattern(selectedCountry)), bufferType);
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatPriceTextView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        this.rawText = "";
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TalabatPriceTextView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…,\n            0\n        )");
        try {
            boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.TalabatPriceTextView_showCurrencySymbol, false);
            obtainStyledAttributes.recycle();
            this.showCurrency = z11;
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatPriceTextView(@NotNull Context context, @NotNull AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        this.rawText = "";
    }
}
