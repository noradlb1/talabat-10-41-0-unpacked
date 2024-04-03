package com.talabat.darkstores.feature.product.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.talabat.darkstores.R;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR#\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\u00010\u00018BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0014\u001a\n \u000b*\u0004\u0018\u00010\u00150\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CartIndicator;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "count", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getCount", "()Landroid/widget/TextView;", "count$delegate", "Lkotlin/Lazy;", "countLayout", "getCountLayout", "()Landroid/widget/FrameLayout;", "countLayout$delegate", "image", "Landroid/widget/ImageView;", "getImage", "()Landroid/widget/ImageView;", "image$delegate", "previousQuantity", "setQuantity", "", "quantity", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartIndicator extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final Lazy count$delegate;
    @NotNull
    private final Lazy countLayout$delegate;
    @NotNull
    private final Lazy image$delegate;
    private int previousQuantity;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CartIndicator(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CartIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CartIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.count$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CartIndicator$count$2(this));
        this.countLayout$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CartIndicator$countLayout$2(this));
        this.image$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CartIndicator$image$2(this));
        View.inflate(context, R.layout.darkstores_cart_indicator, this);
        setClipChildren(false);
        setClipToPadding(false);
    }

    private final TextView getCount() {
        return (TextView) this.count$delegate.getValue();
    }

    private final FrameLayout getCountLayout() {
        return (FrameLayout) this.countLayout$delegate.getValue();
    }

    private final ImageView getImage() {
        return (ImageView) this.image$delegate.getValue();
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

    public final void setQuantity(int i11) {
        boolean z11;
        ImageView image = getImage();
        boolean z12 = true;
        int i12 = 0;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        image.setEnabled(z11);
        FrameLayout countLayout = getCountLayout();
        Intrinsics.checkNotNullExpressionValue(countLayout, "countLayout");
        if (i11 <= 0) {
            z12 = false;
        }
        if (!z12) {
            i12 = 8;
        }
        countLayout.setVisibility(i12);
        if (i11 != this.previousQuantity) {
            getCount().setText(String.valueOf(i11));
            QuantityPopAnimator quantityPopAnimator = QuantityPopAnimator.INSTANCE;
            FrameLayout countLayout2 = getCountLayout();
            Intrinsics.checkNotNullExpressionValue(countLayout2, "countLayout");
            quantityPopAnimator.animate(countLayout2);
            this.previousQuantity = i11;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CartIndicator(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
