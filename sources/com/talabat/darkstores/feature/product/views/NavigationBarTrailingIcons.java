package com.talabat.darkstores.feature.product.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.designsystem.ds_counter.DSCounter;
import com.designsystem.ds_icon_button.DSIconButton;
import com.talabat.darkstores.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/NavigationBarTrailingIcons;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getBagIcon", "Landroid/view/View;", "setOnCartClickListener", "", "onClick", "Lkotlin/Function0;", "setQuantity", "quantity", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavigationBarTrailingIcons extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NavigationBarTrailingIcons(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NavigationBarTrailingIcons(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NavigationBarTrailingIcons(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.darkstores_navigation_bar_trailing_icons, this);
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
    public final View getBagIcon() {
        DSIconButton dSIconButton = (DSIconButton) _$_findCachedViewById(R.id.bagIconButton);
        Intrinsics.checkNotNullExpressionValue(dSIconButton, "bagIconButton");
        return dSIconButton;
    }

    public final void setOnCartClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        ((DSIconButton) _$_findCachedViewById(R.id.bagIconButton)).setOnTap(function0);
    }

    public final void setQuantity(int i11) {
        int i12;
        Integer num;
        int i13 = R.id.cartCounter;
        int visibility = ((DSCounter) _$_findCachedViewById(i13)).getVisibility();
        DSCounter dSCounter = (DSCounter) _$_findCachedViewById(i13);
        if (i11 > 0) {
            i12 = 0;
        } else {
            i12 = 8;
        }
        dSCounter.setVisibility(i12);
        if (visibility == 8) {
            ((DSCounter) _$_findCachedViewById(i13)).setValue(Integer.valueOf(i11));
            QuantityPopAnimator quantityPopAnimator = QuantityPopAnimator.INSTANCE;
            DSCounter dSCounter2 = (DSCounter) _$_findCachedViewById(i13);
            Intrinsics.checkNotNullExpressionValue(dSCounter2, "cartCounter");
            quantityPopAnimator.animate(dSCounter2);
        } else {
            ((DSCounter) _$_findCachedViewById(i13)).setValue(Integer.valueOf(i11));
        }
        DSIconButton dSIconButton = (DSIconButton) _$_findCachedViewById(R.id.bagIconButton);
        if (i11 > 0) {
            num = Integer.valueOf(com.designsystem.marshmallow.R.drawable.ds_bag_filled);
        } else {
            num = Integer.valueOf(com.designsystem.marshmallow.R.drawable.ds_bag);
        }
        dSIconButton.setIcon(num);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavigationBarTrailingIcons(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
