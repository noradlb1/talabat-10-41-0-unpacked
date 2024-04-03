package com.talabat.fees;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.talabat.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\b\b\u0001\u0010\u0014\u001a\u00020\u0007J\u001a\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/fees/ServiceFeeView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickableArea", "Landroid/view/View;", "serviceFeeLabelView", "Landroid/widget/TextView;", "serviceFeeValueView", "serviceInfoIcon", "setOnInfoClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setTextColor", "color", "showServiceFee", "serviceFeeLabel", "", "serviceFeeValue", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ServiceFeeView extends RelativeLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final View clickableArea;
    @NotNull
    private final TextView serviceFeeLabelView;
    @NotNull
    private final TextView serviceFeeValueView;
    @NotNull
    private final View serviceInfoIcon;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ServiceFeeView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ServiceFeeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ServiceFeeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.view_service_fee, this);
        View findViewById = findViewById(R.id.service_fee_label);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.service_fee_label)");
        this.serviceFeeLabelView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.service_fee_value_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.service_fee_value_text)");
        this.serviceFeeValueView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.service_fee_tooltip_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.service_fee_tooltip_icon)");
        this.serviceInfoIcon = findViewById3;
        View findViewById4 = findViewById(R.id.service_fee_clickable_area);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.service_fee_clickable_area)");
        this.clickableArea = findViewById4;
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

    public final void setOnInfoClickListener(@Nullable View.OnClickListener onClickListener) {
        boolean z11;
        View view = this.serviceInfoIcon;
        int i11 = 0;
        if (onClickListener == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = 8;
        }
        view.setVisibility(i11);
        this.clickableArea.setOnClickListener(onClickListener);
    }

    public final void setTextColor(@ColorInt int i11) {
        this.serviceFeeLabelView.setTextColor(i11);
        this.serviceFeeValueView.setTextColor(i11);
    }

    public final void showServiceFee(@Nullable String str, @Nullable String str2) {
        boolean z11;
        int i11 = 0;
        if (str == null || str2 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = 8;
        }
        setVisibility(i11);
        this.serviceFeeLabelView.setText(str);
        this.serviceFeeValueView.setText(str2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ServiceFeeView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
