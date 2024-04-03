package com.talabat.darkstores.common.view;

import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ci.c;
import ci.d;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.OnProductQuantityChangeListener;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.IntKt;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0007J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0006\u0010\u0017\u001a\u00020\u000bJ\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0014\u0010\"\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\nH\u0002R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/talabat/darkstores/common/view/CartItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "quantityChangedListener", "Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;", "isRtl", "", "onProductClicked", "Lkotlin/Function1;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "", "onOosPredictionAlertShown", "Lkotlin/Function0;", "showOosPredictionAlert", "(Landroid/view/View;Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Z)V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "bind", "product", "isCampaignFulfilled", "checkIfCampaignMatched", "fulfilled", "clear", "collectEvents", "getScoreMessage", "discountValue", "", "setupFreeQuantityTag", "resources", "Landroid/content/res/Resources;", "showCampaign", "campaignLabel", "", "preparePreCheckoutAlertView", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartItemViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final CompositeDisposable disposable = new CompositeDisposable();
    private final boolean isRtl;
    @NotNull
    private final Function0<Unit> onOosPredictionAlertShown;
    @NotNull
    private final Function1<Product, Unit> onProductClicked;
    @NotNull
    private final OnProductQuantityChangeListener quantityChangedListener;
    private final boolean showOosPredictionAlert;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartItemViewHolder(@NotNull View view, @NotNull OnProductQuantityChangeListener onProductQuantityChangeListener, boolean z11, @NotNull Function1<? super Product, Unit> function1, @NotNull Function0<Unit> function0, boolean z12) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(onProductQuantityChangeListener, "quantityChangedListener");
        Intrinsics.checkNotNullParameter(function1, "onProductClicked");
        Intrinsics.checkNotNullParameter(function0, "onOosPredictionAlertShown");
        this.quantityChangedListener = onProductQuantityChangeListener;
        this.isRtl = z11;
        this.onProductClicked = function1;
        this.onOosPredictionAlertShown = function0;
        this.showOosPredictionAlert = z12;
    }

    public static /* synthetic */ void bind$default(CartItemViewHolder cartItemViewHolder, Product product, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        cartItemViewHolder.bind(product, z11);
    }

    private final void checkIfCampaignMatched(Product product, boolean z11) {
        boolean z12;
        View view = this.itemView;
        int i11 = R.id.promo_score_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(i11);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "promo_score_container");
        int i12 = 8;
        linearLayout.setVisibility(8);
        CampaignTrigger campaignTrigger = product.getCampaignTrigger();
        if (campaignTrigger != null) {
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "promo_score_container");
            if (campaignTrigger.getCampaignType() != Campaign.CampaignType.MixAndMatch || product.getCartCount() < campaignTrigger.getTriggerQty() || z11) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                i12 = 0;
            }
            linearLayout2.setVisibility(i12);
            if (campaignTrigger.getDiscountType() == Campaign.Type.PERCENTAGE) {
                getScoreMessage(campaignTrigger.getDiscountValue());
            }
        }
        ((LinearLayout) view.findViewById(i11)).setOnClickListener(new d(this, product));
    }

    /* access modifiers changed from: private */
    /* renamed from: checkIfCampaignMatched$lambda-4$lambda-3  reason: not valid java name */
    public static final void m9641checkIfCampaignMatched$lambda4$lambda3(CartItemViewHolder cartItemViewHolder, Product product, View view) {
        Intrinsics.checkNotNullParameter(cartItemViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(product, "$product");
        cartItemViewHolder.onProductClicked.invoke(product);
    }

    private final void collectEvents(Product product) {
        if (this.disposable.size() == 0) {
            this.disposable.add(((ItemCounterNew) this.itemView.findViewById(R.id.product_tile_counter)).getProductStateForTrackingEvents().subscribe(new c(this, product)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: collectEvents$lambda-6  reason: not valid java name */
    public static final void m9642collectEvents$lambda6(CartItemViewHolder cartItemViewHolder, Product product, Pair pair) {
        Intrinsics.checkNotNullParameter(cartItemViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(product, "$product");
        int intValue = ((Number) pair.component1()).intValue();
        if (((Boolean) pair.component2()).booleanValue()) {
            cartItemViewHolder.quantityChangedListener.decreaseProductCount(product, intValue, Integer.valueOf(cartItemViewHolder.getBindingAdapterPosition()));
        } else {
            cartItemViewHolder.quantityChangedListener.increaseProductCount(product, intValue, Integer.valueOf(cartItemViewHolder.getBindingAdapterPosition()), new CartItemViewHolder$collectEvents$1$1(cartItemViewHolder, product));
        }
    }

    private final void getScoreMessage(float f11) {
        boolean z11;
        View view = this.itemView;
        boolean z12 = true;
        if (f11 == 100.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            ((TextView) view.findViewById(R.id.campaign_message)).setText(view.getResources().getText(com.talabat.localization.R.string.ds_item_campaign_can_score_free));
            return;
        }
        if (f11 != 0.0f) {
            z12 = false;
        }
        if (!z12) {
            ((TextView) view.findViewById(R.id.campaign_message)).setText(view.getResources().getText(com.talabat.localization.R.string.ds_item_campaign_can_score_discount));
        }
    }

    private final void preparePreCheckoutAlertView(View view, Product product) {
        if (!Intrinsics.areEqual((Object) product.getPredictedToBeOOS(), (Object) Boolean.TRUE) || !this.showOosPredictionAlert) {
            ((FrameLayout) view.findViewById(R.id.oos_alert_container)).setVisibility(8);
            return;
        }
        ((FrameLayout) view.findViewById(R.id.oos_alert_container)).setVisibility(0);
        this.onOosPredictionAlertShown.invoke();
    }

    private final void setupFreeQuantityTag(Product product, Resources resources) {
        boolean z11;
        int orZero = IntKt.orZero(product.getFreeCount());
        if ((!BooleanKt.orFalse(product.getPredictedToBeOOS()) || !this.showOosPredictionAlert) && orZero > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.itemView.findViewById(R.id.free_quantity_container).setVisibility(0);
            ((TextView) this.itemView.findViewById(R.id.free_quantity_count)).setText("+" + orZero);
            ((TextView) this.itemView.findViewById(R.id.free_quantity_msg)).setText(resources.getQuantityText(com.talabat.localization.R.plurals.ds_item_cart_free_item, orZero));
            return;
        }
        this.itemView.findViewById(R.id.free_quantity_container).setVisibility(8);
    }

    private final boolean showCampaign(String str, Product product) {
        boolean z11;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || product.getStock() <= 0 || product.getAgeLimit() != 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bind(@org.jetbrains.annotations.Nullable com.talabat.feature.darkstorescart.data.model.Product r12, boolean r13) {
        /*
            r11 = this;
            android.view.View r0 = r11.itemView
            r1 = 8
            if (r12 == 0) goto L_0x0170
            r11.collectEvents(r12)
            int r2 = com.talabat.darkstores.R.id.image
            android.view.View r3 = r0.findViewById(r2)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            android.content.Context r4 = r0.getContext()
            java.lang.String r5 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            int r5 = com.talabat.darkstores.R.color.darkstoresProductTileOverlay
            int r4 = com.talabat.darkstores.common.extensions.ContextExtensionsKt.getColorCompat(r4, r5)
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.SRC_OVER
            r3.setColorFilter(r4, r5)
            android.view.View r2 = r0.findViewById(r2)
            r3 = r2
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            java.lang.String r2 = "image"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            java.lang.String r4 = r12.getImageUrl()
            int r2 = com.talabat.darkstores.R.drawable.product_tile_placeholder_new
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 28
            r10 = 0
            com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt.loadImageWithGlide$default(r3, r4, r5, r6, r7, r8, r9, r10)
            int r2 = com.talabat.darkstores.R.id.tvTitle
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = r12.getName()
            r2.setText(r3)
            int r2 = com.talabat.darkstores.R.id.tvPreviousPrice
            android.view.View r3 = r0.findViewById(r2)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.view.View r4 = r0.findViewById(r2)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r4 = r4.getPaintFlags()
            r4 = r4 | 16
            r3.setPaintFlags(r4)
            android.view.View r3 = r0.findViewById(r2)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "tvPreviousPrice"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.Float r4 = r12.getPreviousPrice()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0080
            r4 = r5
            goto L_0x0081
        L_0x0080:
            r4 = r6
        L_0x0081:
            if (r4 == 0) goto L_0x0085
            r4 = r6
            goto L_0x0086
        L_0x0085:
            r4 = r1
        L_0x0086:
            r3.setVisibility(r4)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.Float r3 = r12.getPreviousPrice()
            r4 = 0
            if (r3 == 0) goto L_0x009f
            float r3 = r3.floatValue()
            java.lang.String r3 = com.talabat.darkstores.common.extensions.FloatExtensionsKt.formatCurrency(r3)
            goto L_0x00a0
        L_0x009f:
            r3 = r4
        L_0x00a0:
            r2.setText(r3)
            int r2 = com.talabat.darkstores.R.id.tvPrice
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            float r3 = r12.getPrice()
            java.lang.String r3 = com.talabat.darkstores.common.extensions.FloatExtensionsKt.formatCurrency(r3)
            r2.setText(r3)
            java.lang.String r2 = r12.getOfferText()
            java.lang.String r3 = "resources"
            if (r2 == 0) goto L_0x00cb
            boolean r7 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r2)
            if (r7 != 0) goto L_0x00c5
            goto L_0x00c6
        L_0x00c5:
            r2 = r4
        L_0x00c6:
            if (r2 != 0) goto L_0x00c9
            goto L_0x00cb
        L_0x00c9:
            r4 = r2
            goto L_0x00de
        L_0x00cb:
            com.talabat.feature.darkstorescart.data.model.CampaignTrigger r2 = r12.getCampaignTrigger()
            if (r2 == 0) goto L_0x00de
            android.content.res.Resources r4 = r0.getResources()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)
            boolean r7 = r11.isRtl
            java.lang.String r4 = com.talabat.darkstores.common.extensions.CampaignTriggerExtensionsKt.toLabel(r2, r4, r7)
        L_0x00de:
            int r2 = com.talabat.darkstores.R.id.tvOfferBadge
            android.view.View r2 = r0.findViewById(r2)
            java.lang.String r7 = "tvOfferBadge"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            boolean r7 = r11.showCampaign(r4, r12)
            if (r7 == 0) goto L_0x00f2
            r7 = r6
            goto L_0x00f3
        L_0x00f2:
            r7 = r1
        L_0x00f3:
            r2.setVisibility(r7)
            int r2 = com.talabat.darkstores.R.id.promo_title
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setText(r4)
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r11.preparePreCheckoutAlertView(r0, r12)
            int r2 = com.talabat.darkstores.R.id.product_age_restriction
            android.view.View r4 = r0.findViewById(r2)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r7 = "product_age_restriction"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            int r7 = r12.getAgeLimit()
            if (r7 == 0) goto L_0x011e
            r7 = r5
            goto L_0x011f
        L_0x011e:
            r7 = r6
        L_0x011f:
            if (r7 == 0) goto L_0x0122
            r1 = r6
        L_0x0122:
            r4.setVisibility(r1)
            android.view.View r1 = r0.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.content.res.Resources r2 = r0.getResources()
            int r4 = com.talabat.localization.R.string.ds_age_restriction
            java.lang.Object[] r5 = new java.lang.Object[r5]
            int r7 = r12.getAgeLimit()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r5[r6] = r7
            java.lang.String r2 = r2.getString(r4, r5)
            r1.setText(r2)
            int r1 = com.talabat.darkstores.R.id.product_tile_counter
            android.view.View r1 = r0.findViewById(r1)
            r4 = r1
            com.talabat.darkstores.common.view.ItemCounterNew r4 = (com.talabat.darkstores.common.view.ItemCounterNew) r4
            java.lang.String r1 = "product_tile_counter"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            int r5 = r12.getCartCount()
            int r6 = r12.getStock()
            r7 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            com.talabat.darkstores.common.view.ItemCounterNew.setup$default(r4, r5, r6, r7, r8, r9, r10)
            android.content.res.Resources r0 = r0.getResources()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            r11.setupFreeQuantityTag(r12, r0)
            r11.checkIfCampaignMatched(r12, r13)
            goto L_0x0173
        L_0x0170:
            r0.setVisibility(r1)
        L_0x0173:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.common.view.CartItemViewHolder.bind(com.talabat.feature.darkstorescart.data.model.Product, boolean):void");
    }

    public final void clear() {
        this.disposable.clear();
    }
}
