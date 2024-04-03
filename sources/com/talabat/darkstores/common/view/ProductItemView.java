package com.talabat.darkstores.common.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.load.Transformation;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.OnProductQuantityChangeListener;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.common.bindingAdapters.ResizeStrategy;
import com.talabat.darkstores.common.extensions.CampaignTriggerExtensionsKt;
import com.talabat.darkstores.common.extensions.FloatExtensionsKt;
import com.talabat.darkstores.data.tracking.NewProductQuantityListener;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001d\u001a\u00020\u001bH\u0002J)\u0010\u001e\u001a\u00020\u001b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001f\u001a\u00020 2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\bH\u0002J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0002R\u0012\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/talabat/darkstores/common/view/ProductItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/talabat/darkstores/common/view/ProductView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listPosition", "Ljava/lang/Integer;", "newQuantityListener", "Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;", "getNewQuantityListener", "()Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;", "setNewQuantityListener", "(Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;)V", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "productQuantityChangeListener", "Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;", "getProductQuantityChangeListener", "()Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;", "setProductQuantityChangeListener", "(Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;)V", "applyPromoTriggerIfNeeded", "", "onFinishInflate", "setEmptyProductTile", "setProduct", "canShowSponsored", "", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ZLjava/lang/Integer;)V", "setProductCount", "count", "setProductTile", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductItemView extends ConstraintLayout implements ProductView {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    /* access modifiers changed from: private */
    @Nullable
    public Integer listPosition;
    @Nullable
    private NewProductQuantityListener newQuantityListener;
    /* access modifiers changed from: private */
    @Nullable
    public Product product;
    @Nullable
    private OnProductQuantityChangeListener productQuantityChangeListener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProductItemView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProductItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProductItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.darkstores_product_item_view_search_suggestion_row, this);
    }

    private final void setEmptyProductTile() {
        ((TextView) _$_findCachedViewById(R.id.tvTitle)).setText((CharSequence) null);
        ((TextView) _$_findCachedViewById(R.id.tvPrice)).setText((CharSequence) null);
        ((TextView) _$_findCachedViewById(R.id.tvPreviousPrice)).setText((CharSequence) null);
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvOfferBadge);
        if (textView != null) {
            textView.setVisibility(8);
        }
        ((ImageView) _$_findCachedViewById(R.id.image)).setImageBitmap((Bitmap) null);
        ItemsCounter itemsCounter = (ItemsCounter) _$_findCachedViewById(R.id.counter);
        Intrinsics.checkNotNullExpressionValue(itemsCounter, "counter");
        itemsCounter.setVisibility(8);
    }

    private final void setProductCount(int i11) {
        boolean z11;
        ((ItemsCounter) _$_findCachedViewById(R.id.counter)).setCount(i11);
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.imageContainerFrameLayout);
        if (frameLayout != null) {
            if (i11 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            frameLayout.setSelected(z11);
        }
    }

    private final void setProductTile(Product product2, boolean z11) {
        boolean z12;
        int i11;
        String str;
        boolean z13;
        this.product = product2;
        ((TextView) _$_findCachedViewById(R.id.tvTitle)).setText(product2.getName());
        ((TextView) _$_findCachedViewById(R.id.tvPrice)).setText(FloatExtensionsKt.formatCurrency(product2.getPrice()));
        int i12 = R.id.tvPreviousPrice;
        TextView textView = (TextView) _$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(textView, "tvPreviousPrice");
        if (product2.getPreviousPrice() != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        int i13 = 8;
        if (z12) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        textView.setVisibility(i11);
        TextView textView2 = (TextView) _$_findCachedViewById(i12);
        Float previousPrice = product2.getPreviousPrice();
        if (previousPrice == null || (str = FloatExtensionsKt.formatCurrency(previousPrice.floatValue())) == null) {
            str = "";
        }
        textView2.setText(str);
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.tvOfferBadge);
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(imageView, "image");
        BindingAdaptersKt.loadImageWithGlide$default(imageView, product2.getImageUrl(), Integer.valueOf(R.drawable.product_tile_placeholder), (ResizeStrategy) null, (Transformation) null, (Integer) null, 28, (Object) null);
        setProductCount(product2.getTotalCountWithFreeItems());
        int i14 = R.id.counter;
        ((ItemsCounter) _$_findCachedViewById(i14)).setStock(product2.getStock());
        ItemsCounter itemsCounter = (ItemsCounter) _$_findCachedViewById(i14);
        Intrinsics.checkNotNullExpressionValue(itemsCounter, "counter");
        itemsCounter.setVisibility(0);
        int i15 = R.id.product_age_restriction;
        TextView textView4 = (TextView) _$_findCachedViewById(i15);
        if (textView4 != null) {
            if (product2.getAgeLimit() != 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                i13 = 0;
            }
            textView4.setVisibility(i13);
        }
        TextView textView5 = (TextView) _$_findCachedViewById(i15);
        if (textView5 != null) {
            textView5.setText(getResources().getString(com.talabat.localization.R.string.ds_age_restriction, new Object[]{String.valueOf(product2.getAgeLimit())}));
        }
        applyPromoTriggerIfNeeded(product2);
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

    @VisibleForTesting
    public final void applyPromoTriggerIfNeeded(@NotNull Product product2) {
        boolean z11;
        Intrinsics.checkNotNullParameter(product2, "product");
        CampaignTrigger campaignTrigger = product2.getCampaignTrigger();
        if (campaignTrigger != null) {
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            String label = CampaignTriggerExtensionsKt.toLabel(campaignTrigger, resources, isRtl());
            int i11 = R.id.tvOfferBadge;
            TextView textView = (TextView) _$_findCachedViewById(i11);
            if (textView != null) {
                Intrinsics.checkNotNullExpressionValue(textView, "tvOfferBadge");
                boolean z12 = true;
                int i12 = 0;
                if (label.length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11 || product2.getAgeLimit() != 0) {
                    z12 = false;
                }
                if (!z12) {
                    i12 = 8;
                }
                textView.setVisibility(i12);
            }
            TextView textView2 = (TextView) _$_findCachedViewById(i11);
            if (!(textView2 instanceof TextView)) {
                textView2 = null;
            }
            if (textView2 != null) {
                textView2.setText(label);
            }
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.promo_title);
            if (textView3 != null) {
                textView3.setText(label);
            }
        }
    }

    @Nullable
    public NewProductQuantityListener getNewQuantityListener() {
        return this.newQuantityListener;
    }

    @Nullable
    public OnProductQuantityChangeListener getProductQuantityChangeListener() {
        return this.productQuantityChangeListener;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvPreviousPrice);
        Intrinsics.checkNotNullExpressionValue(textView, "tvPreviousPrice");
        BindingAdaptersKt.setStrike(textView, true);
        ((ItemsCounter) _$_findCachedViewById(R.id.counter)).setQuantityChangeListener(new ProductItemView$onFinishInflate$1(this));
    }

    public void setNewQuantityListener(@Nullable NewProductQuantityListener newProductQuantityListener) {
        this.newQuantityListener = newProductQuantityListener;
    }

    public void setProduct(@Nullable Product product2, boolean z11, @Nullable Integer num) {
        this.product = product2;
        this.listPosition = num;
        if (product2 == null) {
            setEmptyProductTile();
        } else {
            setProductTile(product2, z11);
        }
    }

    public void setProductQuantityChangeListener(@Nullable OnProductQuantityChangeListener onProductQuantityChangeListener) {
        this.productQuantityChangeListener = onProductQuantityChangeListener;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductItemView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
