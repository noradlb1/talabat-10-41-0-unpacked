package com.talabat.darkstores.feature.categories.subcategories.list;

import aj.a;
import aj.b;
import aj.c;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.OnProductQuantityChangeListener;
import com.talabat.darkstores.common.extensions.FloatExtensionsKt;
import com.talabat.darkstores.common.view.ItemCounterNew;
import com.talabat.darkstores.data.tracking.NewProductQuantityListener;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.Product;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\u0012J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J7\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/list/ProductTileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "quantityChangedListener", "Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;", "isRtl", "", "newProductQuantityListener", "Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;", "useDesignSystemStepper", "(Landroid/view/View;Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;ZLcom/talabat/darkstores/data/tracking/NewProductQuantityListener;Z)V", "getContainerView", "()Landroid/view/View;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "bind", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "isLoading", "clear", "collectEvents", "setupPrice", "context", "Landroid/content/Context;", "productTilePrice", "Landroid/widget/TextView;", "productTileOldPrice", "price", "", "previousPrice", "(Landroid/content/Context;Landroid/widget/TextView;Landroid/widget/TextView;FLjava/lang/Float;)V", "setupStepper", "view", "showCampaign", "campaignLabel", "", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductTileViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    private static final long ANIMATION_DURATION = 300;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final View containerView;
    @NotNull
    private final CompositeDisposable disposable;
    private final boolean isRtl;
    @Nullable
    private final NewProductQuantityListener newProductQuantityListener;
    @NotNull
    private final OnProductQuantityChangeListener quantityChangedListener;
    private final boolean useDesignSystemStepper;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/list/ProductTileViewHolder$Companion;", "", "()V", "ANIMATION_DURATION", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductTileViewHolder(View view, OnProductQuantityChangeListener onProductQuantityChangeListener, boolean z11, NewProductQuantityListener newProductQuantityListener2, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, onProductQuantityChangeListener, z11, (i11 & 8) != 0 ? null : newProductQuantityListener2, (i11 & 16) != 0 ? false : z12);
    }

    public static /* synthetic */ void bind$default(ProductTileViewHolder productTileViewHolder, Product product, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        productTileViewHolder.bind(product, z11);
    }

    private final void collectEvents(Product product) {
        Campaign.CampaignType campaignType;
        if (this.disposable.size() == 0) {
            CompositeDisposable compositeDisposable = this.disposable;
            View view = this.itemView;
            int i11 = R.id.product_tile_counter;
            compositeDisposable.add(((ItemCounterNew) view.findViewById(i11)).getProductStateForTrackingEvents().subscribe(new a(this, product)));
            CampaignTrigger campaignTrigger = product.getCampaignTrigger();
            if (campaignTrigger != null) {
                campaignType = campaignTrigger.getCampaignType();
            } else {
                campaignType = null;
            }
            if (campaignType == Campaign.CampaignType.Strikethrough) {
                this.disposable.add(((ItemCounterNew) this.itemView.findViewById(i11)).getProductQuantityState().map(new b(product)).startWith(Boolean.FALSE).distinctUntilChanged().subscribe(new c(this)));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: collectEvents$lambda-11  reason: not valid java name */
    public static final void m9928collectEvents$lambda11(ProductTileViewHolder productTileViewHolder, Boolean bool) {
        int i11;
        Intrinsics.checkNotNullParameter(productTileViewHolder, "this$0");
        Slide slide = new Slide(48);
        slide.setDuration(ANIMATION_DURATION);
        TransitionManager.beginDelayedTransition((ConstraintLayout) productTileViewHolder.itemView.findViewById(R.id.product_tile_root), slide);
        TextView textView = (TextView) productTileViewHolder.itemView.findViewById(R.id.product_tile_usage_label);
        Intrinsics.checkNotNullExpressionValue(textView, "itemView.product_tile_usage_label");
        Intrinsics.checkNotNullExpressionValue(bool, "show");
        if (bool.booleanValue()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        textView.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: collectEvents$lambda-6  reason: not valid java name */
    public static final void m9929collectEvents$lambda6(ProductTileViewHolder productTileViewHolder, Product product, Pair pair) {
        Intrinsics.checkNotNullParameter(productTileViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(product, "$product");
        int intValue = ((Number) pair.component1()).intValue();
        if (((Boolean) pair.component2()).booleanValue()) {
            productTileViewHolder.quantityChangedListener.decreaseProductCount(product, intValue, Integer.valueOf(productTileViewHolder.getBindingAdapterPosition()));
            NewProductQuantityListener newProductQuantityListener2 = productTileViewHolder.newProductQuantityListener;
            if (newProductQuantityListener2 != null) {
                newProductQuantityListener2.onProductRemoved(product, intValue, Integer.valueOf(productTileViewHolder.getBindingAdapterPosition()));
                return;
            }
            return;
        }
        productTileViewHolder.quantityChangedListener.increaseProductCount(product, intValue, Integer.valueOf(productTileViewHolder.getBindingAdapterPosition()), new ProductTileViewHolder$collectEvents$1$1(productTileViewHolder, product));
        NewProductQuantityListener newProductQuantityListener3 = productTileViewHolder.newProductQuantityListener;
        if (newProductQuantityListener3 != null) {
            newProductQuantityListener3.onProductAdded(product, intValue, Integer.valueOf(productTileViewHolder.getBindingAdapterPosition()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: collectEvents$lambda-9  reason: not valid java name */
    public static final Boolean m9930collectEvents$lambda9(Product product, Integer num) {
        Boolean bool;
        boolean z11;
        Intrinsics.checkNotNullParameter(product, "$product");
        Intrinsics.checkNotNullParameter(num, FirebaseAnalytics.Param.QUANTITY);
        CampaignTrigger campaignTrigger = product.getCampaignTrigger();
        boolean z12 = false;
        if (campaignTrigger != null) {
            Integer usageLimit = campaignTrigger.getUsageLimit();
            if (usageLimit != null) {
                if (num.intValue() > usageLimit.intValue()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                bool = Boolean.valueOf(z11);
            } else {
                bool = null;
            }
            if (bool != null) {
                z12 = bool.booleanValue();
            }
        }
        return Boolean.valueOf(z12);
    }

    private final void setupPrice(Context context, TextView textView, TextView textView2, float f11, Float f12) {
        boolean z11;
        if (f12 != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        textView.setText(FloatExtensionsKt.getFormattedPriceAndCurrency$default(f11, context, z11, 0, 0, 12, (Object) null));
        if (f12 != null) {
            textView2.setVisibility(0);
            textView2.setPaintFlags(textView2.getPaintFlags() | 16);
            textView2.setText(FloatExtensionsKt.formatCurrency(f12.floatValue()));
            return;
        }
        textView2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void setupStepper(View view, Product product) {
        ItemCounterNew itemCounterNew = (ItemCounterNew) view.findViewById(R.id.product_tile_counter);
        Intrinsics.checkNotNullExpressionValue(itemCounterNew, "view.product_tile_counter");
        ItemCounterNew.setup$default(itemCounterNew, product.getCartCount(), product.getStock(), true, 0, 8, (Object) null);
    }

    private final boolean showCampaign(String str, Product product) {
        boolean z11;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || product.getStock() <= 0 || product.getAgeLimit() != 0 || product.isSponsored()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0122, code lost:
        if (r0 == null) goto L_0x0124;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bind(@org.jetbrains.annotations.Nullable com.talabat.feature.darkstorescart.data.model.Product r22, boolean r23) {
        /*
            r21 = this;
            r6 = r21
            r5 = r22
            android.view.View r4 = r6.itemView
            int r0 = com.talabat.darkstores.R.id.loading_mask
            android.view.View r1 = r4.findViewById(r0)
            com.talabat.talabatcommon.views.ShimmerLayout r1 = (com.talabat.talabatcommon.views.ShimmerLayout) r1
            java.lang.String r2 = "loading_mask"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r16 = 0
            if (r23 == 0) goto L_0x001a
            r2 = r16
            goto L_0x001c
        L_0x001a:
            r2 = 8
        L_0x001c:
            r1.setVisibility(r2)
            int r1 = com.talabat.darkstores.R.id.product_tile_name
            android.view.View r2 = r4.findViewById(r1)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r7 = "product_tile_name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            r7 = 4
            if (r23 == 0) goto L_0x0031
            r8 = r7
            goto L_0x0033
        L_0x0031:
            r8 = r16
        L_0x0033:
            r2.setVisibility(r8)
            int r2 = com.talabat.darkstores.R.id.product_tile_old_price
            android.view.View r8 = r4.findViewById(r2)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.String r15 = "product_tile_old_price"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r15)
            if (r23 == 0) goto L_0x0047
            r9 = r7
            goto L_0x0049
        L_0x0047:
            r9 = r16
        L_0x0049:
            r8.setVisibility(r9)
            int r14 = com.talabat.darkstores.R.id.product_tile_price
            android.view.View r8 = r4.findViewById(r14)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.String r13 = "product_tile_price"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r13)
            if (r23 == 0) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r7 = r16
        L_0x005e:
            r8.setVisibility(r7)
            android.view.View r7 = r21.getContainerView()
            r8 = r23 ^ 1
            r7.setEnabled(r8)
            if (r5 == 0) goto L_0x0248
            if (r23 != 0) goto L_0x0248
            r21.collectEvents(r22)
            boolean r0 = r6.useDesignSystemStepper
            java.lang.String r7 = "this"
            if (r0 == 0) goto L_0x00a7
            int r0 = com.talabat.darkstores.R.id.product_tile_counter_ds
            android.view.View r0 = r4.findViewById(r0)
            com.designsystem.ds_stepper.DSCollapsibleQuantityStepper r0 = (com.designsystem.ds_stepper.DSCollapsibleQuantityStepper) r0
            java.lang.String r8 = "product_tile_counter_ds"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            r10 = 0
            com.talabat.darkstores.common.OnProductQuantityChangeListener r11 = r6.quantityChangedListener
            int r12 = r21.getBindingAdapterPosition()
            r17 = 0
            r18 = 32
            r19 = 0
            r7 = r0
            r8 = r4
            r9 = r22
            r0 = r13
            r13 = r17
            r3 = r14
            r14 = r18
            r20 = r15
            r15 = r19
            com.talabat.darkstores.common.extensions.DsCounterExtensionsKt.setupDesignSystemStepper$default(r7, r8, r9, r10, r11, r12, r13, r14, r15)
            goto L_0x00b1
        L_0x00a7:
            r0 = r13
            r3 = r14
            r20 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            r6.setupStepper(r4, r5)
        L_0x00b1:
            int r7 = com.talabat.darkstores.R.id.product_tile_image
            android.view.View r7 = r4.findViewById(r7)
            r8 = r7
            com.google.android.material.imageview.ShapeableImageView r8 = (com.google.android.material.imageview.ShapeableImageView) r8
            java.lang.String r7 = "product_tile_image"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            java.lang.String r9 = r22.getImageUrl()
            int r7 = com.talabat.darkstores.R.drawable.product_tile_placeholder_new
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)
            com.talabat.darkstores.common.bindingAdapters.ResizeStrategy r11 = com.talabat.darkstores.common.bindingAdapters.ResizeStrategy.FitCenter
            r12 = 0
            r13 = 0
            r14 = 24
            r15 = 0
            com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt.loadImageWithGlide$default(r8, r9, r10, r11, r12, r13, r14, r15)
            android.view.View r1 = r4.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r7 = r22.getName()
            r1.setText(r7)
            android.content.Context r1 = r4.getContext()
            java.lang.String r7 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r7)
            android.view.View r3 = r4.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            android.view.View r0 = r4.findViewById(r2)
            r7 = r0
            android.widget.TextView r7 = (android.widget.TextView) r7
            r0 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            float r8 = r22.getPrice()
            java.lang.Float r9 = r22.getPreviousPrice()
            r0 = r21
            r2 = r3
            r10 = 8
            r3 = r7
            r7 = r4
            r4 = r8
            r8 = r5
            r5 = r9
            r0.setupPrice(r1, r2, r3, r4, r5)
            java.lang.String r0 = r22.getOfferText()
            r1 = 0
            if (r0 == 0) goto L_0x0124
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r0)
            if (r2 != 0) goto L_0x0121
            goto L_0x0122
        L_0x0121:
            r0 = r1
        L_0x0122:
            if (r0 != 0) goto L_0x013b
        L_0x0124:
            com.talabat.feature.darkstorescart.data.model.CampaignTrigger r0 = r22.getCampaignTrigger()
            if (r0 == 0) goto L_0x013a
            android.content.res.Resources r2 = r7.getResources()
            java.lang.String r3 = "resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            boolean r3 = r6.isRtl
            java.lang.String r0 = com.talabat.darkstores.common.extensions.CampaignTriggerExtensionsKt.toLabel(r0, r2, r3)
            goto L_0x013b
        L_0x013a:
            r0 = r1
        L_0x013b:
            int r2 = com.talabat.darkstores.R.id.product_tile_campaign
            android.view.View r2 = r7.findViewById(r2)
            java.lang.String r3 = "product_tile_campaign"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            boolean r3 = r6.showCampaign(r0, r8)
            if (r3 == 0) goto L_0x014f
            r3 = r16
            goto L_0x0150
        L_0x014f:
            r3 = r10
        L_0x0150:
            r2.setVisibility(r3)
            int r2 = com.talabat.darkstores.R.id.promo_title
            android.view.View r2 = r7.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setText(r0)
            int r0 = com.talabat.darkstores.R.id.product_tile_out_of_stock
            android.view.View r0 = r7.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "product_tile_out_of_stock"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            int r2 = r22.getStock()
            r3 = 1
            if (r2 >= r3) goto L_0x0174
            r2 = r3
            goto L_0x0176
        L_0x0174:
            r2 = r16
        L_0x0176:
            if (r2 == 0) goto L_0x017b
            r2 = r16
            goto L_0x017c
        L_0x017b:
            r2 = r10
        L_0x017c:
            r0.setVisibility(r2)
            int r0 = com.talabat.darkstores.R.id.product_tile_age_restriction
            android.view.View r2 = r7.findViewById(r0)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r4 = "product_tile_age_restriction"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            int r4 = r22.getAgeLimit()
            if (r4 == 0) goto L_0x0194
            r4 = r3
            goto L_0x0196
        L_0x0194:
            r4 = r16
        L_0x0196:
            if (r4 == 0) goto L_0x019b
            r4 = r16
            goto L_0x019c
        L_0x019b:
            r4 = r10
        L_0x019c:
            r2.setVisibility(r4)
            android.view.View r0 = r7.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.content.res.Resources r2 = r7.getResources()
            int r4 = com.talabat.localization.R.string.ds_age_restriction
            java.lang.Object[] r5 = new java.lang.Object[r3]
            int r9 = r22.getAgeLimit()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r5[r16] = r9
            java.lang.String r2 = r2.getString(r4, r5)
            r0.setText(r2)
            com.talabat.feature.darkstorescart.data.model.CampaignTrigger r0 = r22.getCampaignTrigger()
            if (r0 == 0) goto L_0x0222
            com.talabat.feature.darkstorescart.data.model.Campaign$CampaignType r2 = r0.getCampaignType()
            com.talabat.feature.darkstorescart.data.model.Campaign$CampaignType r4 = com.talabat.feature.darkstorescart.data.model.Campaign.CampaignType.Strikethrough
            if (r2 != r4) goto L_0x01ce
            r2 = r3
            goto L_0x01d0
        L_0x01ce:
            r2 = r16
        L_0x01d0:
            if (r2 == 0) goto L_0x01d3
            goto L_0x01d4
        L_0x01d3:
            r0 = r1
        L_0x01d4:
            if (r0 == 0) goto L_0x0222
            java.lang.Integer r0 = r0.getUsageLimit()
            if (r0 == 0) goto L_0x0222
            int r2 = r0.intValue()
            if (r2 <= 0) goto L_0x01e4
            r2 = r3
            goto L_0x01e6
        L_0x01e4:
            r2 = r16
        L_0x01e6:
            if (r2 == 0) goto L_0x01e9
            goto L_0x01ea
        L_0x01e9:
            r0 = r1
        L_0x01ea:
            if (r0 == 0) goto L_0x0222
            int r0 = r0.intValue()
            int r1 = com.talabat.darkstores.R.id.product_tile_usage_label
            android.view.View r2 = r7.findViewById(r1)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.content.res.Resources r4 = r7.getResources()
            int r5 = com.talabat.marshmallow.R.dimen.margin_tiny
            float r4 = r4.getDimension(r5)
            androidx.core.view.ViewCompat.setElevation(r2, r4)
            android.view.View r1 = r7.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.content.res.Resources r2 = r7.getResources()
            int r4 = com.talabat.localization.R.string.usage_limit
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3[r16] = r0
            java.lang.String r0 = r2.getString(r4, r3)
            r1.setText(r0)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x0222:
            if (r1 != 0) goto L_0x022f
            int r0 = com.talabat.darkstores.R.id.product_tile_usage_label
            android.view.View r0 = r7.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r10)
        L_0x022f:
            int r0 = com.talabat.darkstores.R.id.product_sponsor_tag
            android.view.View r0 = r7.findViewById(r0)
            java.lang.String r1 = "product_sponsor_tag"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r1 = r22.isSponsored()
            if (r1 == 0) goto L_0x0243
            r3 = r16
            goto L_0x0244
        L_0x0243:
            r3 = r10
        L_0x0244:
            r0.setVisibility(r3)
            goto L_0x0252
        L_0x0248:
            r7 = r4
            android.view.View r0 = r7.findViewById(r0)
            com.talabat.talabatcommon.views.ShimmerLayout r0 = (com.talabat.talabatcommon.views.ShimmerLayout) r0
            r0.startShimmerAnimation()
        L_0x0252:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.categories.subcategories.list.ProductTileViewHolder.bind(com.talabat.feature.darkstorescart.data.model.Product, boolean):void");
    }

    public final void clear() {
        this.disposable.clear();
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductTileViewHolder(@NotNull View view, @NotNull OnProductQuantityChangeListener onProductQuantityChangeListener, boolean z11, @Nullable NewProductQuantityListener newProductQuantityListener2, boolean z12) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        Intrinsics.checkNotNullParameter(onProductQuantityChangeListener, "quantityChangedListener");
        this.containerView = view;
        this.quantityChangedListener = onProductQuantityChangeListener;
        this.isRtl = z11;
        this.newProductQuantityListener = newProductQuantityListener2;
        this.useDesignSystemStepper = z12;
        this.disposable = new CompositeDisposable();
    }
}
