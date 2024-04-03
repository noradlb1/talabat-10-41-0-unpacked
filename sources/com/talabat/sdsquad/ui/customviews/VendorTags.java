package com.talabat.sdsquad.ui.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.extentions.ViewExtentionsKt;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0017"}, d2 = {"Lcom/talabat/sdsquad/ui/customviews/VendorTags;", "Lcom/google/android/flexbox/FlexboxLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "applyFontSize", "", "attributeFloatValue", "", "setCashOnlyVisibility", "isVisible", "", "setDiscountVisibility", "discountTxt", "", "setExtraTagVisibility", "setLiveTrackingVisibility", "setOffersVisibility", "setSafeDropOffTagVisibility", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorTags extends FlexboxLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VendorTags(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VendorTags(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VendorTags(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.view_vendor_tags, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.VendorTags, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyl…endorTags, 0, 0\n        )");
        applyFontSize(((float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.VendorTags_tagsFontSize, 0)) / getResources().getDisplayMetrics().scaledDensity);
    }

    private final void applyFontSize(float f11) {
        ((TextView) _$_findCachedViewById(R.id.vendorDiscountTag)).setTextSize(f11);
        ((TextView) _$_findCachedViewById(R.id.vendorOfferTag)).setTextSize(f11);
        ((TextView) _$_findCachedViewById(R.id.vendorCashOnlyTag)).setTextSize(f11);
        ((TextView) _$_findCachedViewById(R.id.vendorLiveTrackingTag)).setTextSize(f11);
        ((TextView) _$_findCachedViewById(R.id.isSafeDropOffTag)).setTextSize(f11);
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

    public final void setCashOnlyVisibility(boolean z11) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.vendorCashOnlyTag);
        Intrinsics.checkNotNullExpressionValue(textView, "vendorCashOnlyTag");
        ViewExtentionsKt.show$default(textView, z11, 0, 2, (Object) null);
    }

    public final void setDiscountVisibility(boolean z11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "discountTxt");
        if (z11) {
            int i11 = R.id.vendorDiscountTag;
            TextView textView = (TextView) _$_findCachedViewById(i11);
            Intrinsics.checkNotNullExpressionValue(textView, "vendorDiscountTag");
            ViewExtentionsKt.show$default(textView, z11, 0, 2, (Object) null);
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "%", false, 2, (Object) null)) {
                Object[] array = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"%"}, false, 0, 6, (Object) null).toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%s%% %s", Arrays.copyOf(new Object[]{((String[]) array)[0], "Discount"}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                ((TextView) _$_findCachedViewById(i11)).setText(format);
                return;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(LogWriteConstants.LOCATION_MSG_FORMAT, Arrays.copyOf(new Object[]{"Discount"}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            ((TextView) _$_findCachedViewById(i11)).setText(format2);
            return;
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.vendorDiscountTag);
        Intrinsics.checkNotNullExpressionValue(textView2, "vendorDiscountTag");
        ViewExtentionsKt.show$default(textView2, z11, 0, 2, (Object) null);
    }

    public final void setExtraTagVisibility(boolean z11) {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.vendorExtraTag);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "vendorExtraTag");
        ViewExtentionsKt.show$default(linearLayout, z11, 0, 2, (Object) null);
    }

    public final void setLiveTrackingVisibility(boolean z11) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.vendorLiveTrackingTag);
        Intrinsics.checkNotNullExpressionValue(textView, "vendorLiveTrackingTag");
        ViewExtentionsKt.show$default(textView, z11, 0, 2, (Object) null);
    }

    public final void setOffersVisibility(boolean z11) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.vendorOfferTag);
        Intrinsics.checkNotNullExpressionValue(textView, "vendorOfferTag");
        ViewExtentionsKt.show$default(textView, z11, 0, 2, (Object) null);
    }

    public final void setSafeDropOffTagVisibility(boolean z11) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.isSafeDropOffTag);
        Intrinsics.checkNotNullExpressionValue(textView, "isSafeDropOffTag");
        ViewExtentionsKt.show$default(textView, z11, 0, 2, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorTags(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
