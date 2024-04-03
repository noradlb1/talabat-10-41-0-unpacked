package com.talabat.darkstores.common.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import ci.e;
import com.bumptech.glide.load.Transformation;
import com.talabat.darkstores.common.OnProductQuantityChangeListener;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.common.bindingAdapters.ResizeStrategy;
import com.talabat.darkstores.common.extensions.ContextExtensionsKt;
import com.talabat.darkstores.common.extensions.FloatExtensionsKt;
import com.talabat.darkstores.databinding.DarkstoresItemProductCartNewCompactBinding;
import com.talabat.darkstores.feature.cart.CartProduct;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extentions.IntKt;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/common/view/CartItemViewHolderCompact;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/darkstores/databinding/DarkstoresItemProductCartNewCompactBinding;", "quantityChangedListener", "Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;", "showOosPredictionAlert", "", "onOosPredictionAlertShown", "Lkotlin/Function0;", "", "(Lcom/talabat/darkstores/databinding/DarkstoresItemProductCartNewCompactBinding;Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;ZLkotlin/jvm/functions/Function0;)V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "bind", "item", "Lcom/talabat/darkstores/feature/cart/CartProduct;", "clear", "collectEvents", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "getAlertMessage", "", "preparePreCheckoutAlertView", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartItemViewHolderCompact extends RecyclerView.ViewHolder {
    /* access modifiers changed from: private */
    @NotNull
    public final DarkstoresItemProductCartNewCompactBinding binding;
    @NotNull
    private final CompositeDisposable disposable = new CompositeDisposable();
    @NotNull
    private final Function0<Unit> onOosPredictionAlertShown;
    @NotNull
    private final OnProductQuantityChangeListener quantityChangedListener;
    private final boolean showOosPredictionAlert;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartItemViewHolderCompact(@NotNull DarkstoresItemProductCartNewCompactBinding darkstoresItemProductCartNewCompactBinding, @NotNull OnProductQuantityChangeListener onProductQuantityChangeListener, boolean z11, @NotNull Function0<Unit> function0) {
        super(darkstoresItemProductCartNewCompactBinding.getRoot());
        Intrinsics.checkNotNullParameter(darkstoresItemProductCartNewCompactBinding, "binding");
        Intrinsics.checkNotNullParameter(onProductQuantityChangeListener, "quantityChangedListener");
        Intrinsics.checkNotNullParameter(function0, "onOosPredictionAlertShown");
        this.binding = darkstoresItemProductCartNewCompactBinding;
        this.quantityChangedListener = onProductQuantityChangeListener;
        this.showOosPredictionAlert = z11;
        this.onOosPredictionAlertShown = function0;
    }

    private final void collectEvents(Product product) {
        if (this.disposable.size() == 0) {
            this.disposable.add(this.binding.itemCounter.getProductStateForTrackingEvents().subscribe(new e(this, product)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: collectEvents$lambda-2  reason: not valid java name */
    public static final void m9643collectEvents$lambda2(CartItemViewHolderCompact cartItemViewHolderCompact, Product product, Pair pair) {
        Intrinsics.checkNotNullParameter(cartItemViewHolderCompact, "this$0");
        Intrinsics.checkNotNullParameter(product, "$product");
        int intValue = ((Number) pair.component1()).intValue();
        if (((Boolean) pair.component2()).booleanValue()) {
            cartItemViewHolderCompact.quantityChangedListener.decreaseProductCount(product, intValue, Integer.valueOf(cartItemViewHolderCompact.getBindingAdapterPosition()));
        } else {
            cartItemViewHolderCompact.quantityChangedListener.increaseProductCount(product, intValue, Integer.valueOf(cartItemViewHolderCompact.getBindingAdapterPosition()), new CartItemViewHolderCompact$collectEvents$1$1(cartItemViewHolderCompact, product));
        }
    }

    private final String getAlertMessage(CartProduct cartProduct) {
        if (!cartProduct.getShowAlerts()) {
            return null;
        }
        Boolean hasPriceChanged = cartProduct.getProduct().getHasPriceChanged();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual((Object) hasPriceChanged, (Object) bool)) {
            return this.itemView.getContext().getString(R.string.alert_price_changed);
        }
        if (!Intrinsics.areEqual((Object) cartProduct.getProduct().getHasQuantityChanged(), (Object) bool)) {
            return null;
        }
        return this.itemView.getContext().getString(R.string.alert_quantity_changed, new Object[]{String.valueOf(cartProduct.getProduct().getStock())});
    }

    private final void preparePreCheckoutAlertView(Product product) {
        if (!Intrinsics.areEqual((Object) product.getPredictedToBeOOS(), (Object) Boolean.TRUE) || !this.showOosPredictionAlert) {
            this.binding.oosAlertContainer.setVisibility(8);
            return;
        }
        this.binding.oosAlertContainer.setVisibility(0);
        this.onOosPredictionAlertShown.invoke();
    }

    public final void bind(@NotNull CartProduct cartProduct) {
        boolean z11;
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(cartProduct, "item");
        Product product = cartProduct.getProduct();
        ImageView imageView = this.binding.ivProductImage;
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setColorFilter(ContextExtensionsKt.getColorCompat(context, com.talabat.darkstores.R.color.darkstoresProductTileOverlay), PorterDuff.Mode.SRC_OVER);
        String str = "";
        Intrinsics.checkNotNullExpressionValue(imageView, str);
        BindingAdaptersKt.loadImageWithGlide$default(imageView, product.getImageUrl(), Integer.valueOf(com.talabat.darkstores.R.drawable.product_tile_placeholder_new), (ResizeStrategy) null, (Transformation) null, (Integer) null, 28, (Object) null);
        this.binding.tvTitle.setText(product.getName());
        this.binding.tvPrice.setText(FloatExtensionsKt.formatCurrency(product.getPrice()));
        collectEvents(product);
        ItemCounterNew itemCounterNew = this.binding.itemCounter;
        Intrinsics.checkNotNullExpressionValue(itemCounterNew, "binding.itemCounter");
        ItemCounterNew.setup$default(itemCounterNew, product.getCartCount(), product.getStock(), false, IntKt.orZero(product.getFreeCount()), 4, (Object) null);
        String alertMessage = getAlertMessage(cartProduct);
        if (alertMessage != null) {
            str = alertMessage;
        }
        this.binding.tvAlert.setText(str);
        int i13 = 0;
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        AppCompatImageView appCompatImageView = this.binding.ivAlert;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.ivAlert");
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        appCompatImageView.setVisibility(i11);
        TextView textView = this.binding.tvAlert;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvAlert");
        if (z11) {
            i12 = 0;
        } else {
            i12 = 8;
        }
        textView.setVisibility(i12);
        View view = this.binding.overlay;
        Intrinsics.checkNotNullExpressionValue(view, "binding.overlay");
        if (!cartProduct.isOOS()) {
            i13 = 8;
        }
        view.setVisibility(i13);
        this.binding.itemCounter.setOverlayVisibility(cartProduct.isOOS());
        preparePreCheckoutAlertView(product);
    }

    public final void clear() {
        this.disposable.clear();
    }
}
