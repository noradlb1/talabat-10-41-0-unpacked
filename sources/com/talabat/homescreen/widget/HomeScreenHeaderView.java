package com.talabat.homescreen.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.talabat.homescreen.R;
import java.util.LinkedHashMap;
import java.util.Map;
import js.b;
import js.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007J\u0014\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eJ\u0006\u0010\u0019\u001a\u00020\u000bJ\u0010\u0010\u001a\u001a\u00020\u000b2\b\b\u0001\u0010\u001b\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0007¨\u0006\u001e"}, d2 = {"Lcom/talabat/homescreen/widget/HomeScreenHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getHeaderBackgroundColor", "hideBasket", "", "onBasketClicked", "onClick", "Lkotlin/Function0;", "setAddressIconTint", "color", "setAddressText", "addressText", "", "setAddressTextColor", "setCaptionTextColor", "setHeaderBackgroundColor", "setOnAddressClicked", "onAddressClicked", "showBasket", "updateBasketIcon", "iconRes", "updateBasketOrderCount", "count", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenHeaderView extends ConstraintLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeScreenHeaderView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeScreenHeaderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeScreenHeaderView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.home_screen_header, this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBasketClicked$lambda-1  reason: not valid java name */
    public static final void m10657onBasketClicked$lambda1(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnAddressClicked$lambda-0  reason: not valid java name */
    public static final void m10658setOnAddressClicked$lambda0(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onAddressClicked");
        function0.invoke();
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

    public final int getHeaderBackgroundColor() {
        ColorDrawable colorDrawable;
        Drawable background = ((ConstraintLayout) _$_findCachedViewById(R.id.fluidHomeToolbar)).getBackground();
        if (background instanceof ColorDrawable) {
            colorDrawable = (ColorDrawable) background;
        } else {
            colorDrawable = null;
        }
        if (colorDrawable != null) {
            return colorDrawable.getColor();
        }
        return -1;
    }

    public final void hideBasket() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.basket_container)).setVisibility(8);
        ((AppCompatTextView) _$_findCachedViewById(R.id.cartCountTextView)).setVisibility(8);
    }

    public final void onBasketClicked(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        ((ConstraintLayout) _$_findCachedViewById(R.id.basket_container)).setOnClickListener(new b(function0));
    }

    public final void setAddressIconTint(int i11) {
        ((AppCompatImageView) _$_findCachedViewById(R.id.ivToolbarAddressArrow)).setColorFilter(i11);
    }

    public final void setAddressText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "addressText");
        ((AppCompatTextView) _$_findCachedViewById(R.id.tvToolbarAddressDelivery)).setText(str);
    }

    public final void setAddressTextColor(int i11) {
        ((AppCompatTextView) _$_findCachedViewById(R.id.tvToolbarAddressDelivery)).setTextColor(i11);
    }

    public final void setCaptionTextColor(int i11) {
        ((AppCompatTextView) _$_findCachedViewById(R.id.captionTextView)).setTextColor(i11);
    }

    public final void setHeaderBackgroundColor(int i11) {
        ((ConstraintLayout) _$_findCachedViewById(R.id.fluidHomeToolbar)).setBackgroundColor(i11);
    }

    public final void setOnAddressClicked(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onAddressClicked");
        ((LinearLayout) _$_findCachedViewById(R.id.address_text_container)).setOnClickListener(new c(function0));
    }

    public final void showBasket() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.basket_container)).setVisibility(0);
        ((AppCompatTextView) _$_findCachedViewById(R.id.cartCountTextView)).setVisibility(0);
    }

    public final void updateBasketIcon(@DrawableRes int i11) {
        ((AppCompatImageView) _$_findCachedViewById(R.id.ivHomeToolbarCart)).setImageResource(i11);
    }

    public final void updateBasketOrderCount(int i11) {
        boolean z11;
        ((AppCompatTextView) _$_findCachedViewById(R.id.cartCountTextView)).setText(String.valueOf(i11));
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.cartCountTextViewContainer);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "cartCountTextViewContainer");
        int i12 = 0;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            i12 = 8;
        }
        linearLayout.setVisibility(i12);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeScreenHeaderView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
