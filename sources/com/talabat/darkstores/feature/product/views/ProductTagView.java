package com.talabat.darkstores.feature.product.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import com.designsystem.marshmallow.R;
import com.google.android.material.card.MaterialCardView;
import com.talabat.darkstores.databinding.ProductTagViewBinding;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.UrlConstantsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\r\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/ProductTagView;", "Lcom/google/android/material/card/MaterialCardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/darkstores/databinding/ProductTagViewBinding;", "getBinding", "()Lcom/talabat/darkstores/databinding/ProductTagViewBinding;", "getColor", "color", "", "fallbackColor", "setProductTag", "", "productTag", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$Tag;", "showAsMoreLessTag", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductTagView extends MaterialCardView {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final ProductTagViewBinding binding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProductTagView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProductTagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProductTagView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        ProductTagViewBinding inflate = ProductTagViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
        setVisibility(8);
        setCardElevation(0.0f);
        setRadius(getResources().getDimension(R.dimen.ds_xxxs));
    }

    private final int getColor(Context context, String str, @ColorRes int i11) {
        Integer num;
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            num = Result.m6329constructorimpl(Integer.valueOf(Color.parseColor(str)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6332exceptionOrNullimpl(num) != null) {
            try {
                obj = Result.m6329constructorimpl(Integer.valueOf(Color.parseColor("#" + str)));
            } catch (Throwable th3) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th3));
            }
            num = obj;
        }
        Integer valueOf = Integer.valueOf(ContextCompat.getColor(context, i11));
        if (Result.m6335isFailureimpl(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
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
    public final ProductTagViewBinding getBinding() {
        return this.binding;
    }

    public final void setProductTag(@NotNull ProductExtendedInfo.Tag tag) {
        String str;
        Intrinsics.checkNotNullParameter(tag, UrlConstantsKt.PRODUCT_TAG);
        String text = tag.getText();
        if (text != null) {
            setVisibility(0);
            this.binding.txtProductTag.setText(text);
            this.binding.moreProductTag.setText(text);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ProductExtendedInfo.ColorResource textColor = tag.getTextColor();
            String str2 = null;
            if (textColor != null) {
                str = textColor.getHex();
            } else {
                str = null;
            }
            int color = getColor(context, str, R.color.ds_yellow_80);
            this.binding.txtProductTag.setTextColor(color);
            this.binding.moreProductTag.setTextColor(color);
            float dimensionPixelOffset = (float) getResources().getDimensionPixelOffset(R.dimen.ds_xxxs);
            GradientDrawable gradientDrawable = new GradientDrawable();
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            ProductExtendedInfo.ColorResource backgroundColor = tag.getBackgroundColor();
            if (backgroundColor != null) {
                str2 = backgroundColor.getHex();
            }
            gradientDrawable.setColor(getColor(context2, str2, R.color.ds_yellow_10));
            gradientDrawable.setCornerRadius(dimensionPixelOffset);
            ((LinearLayout) _$_findCachedViewById(com.talabat.darkstores.R.id.tag_root)).setBackground(gradientDrawable);
        }
    }

    public final void showAsMoreLessTag() {
        this.binding.txtProductTag.setVisibility(8);
        this.binding.moreProductTag.setVisibility(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductTagView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
