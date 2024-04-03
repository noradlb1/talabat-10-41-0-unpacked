package com.talabat.darkstores.common.lists.adapters.compact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import bi.a;
import bi.b;
import bi.c;
import com.bumptech.glide.load.Transformation;
import com.designsystem.ds_stepper.DSCollapsibleQuantityStepper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.OnProductQuantityChangeListener;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.darkstores.common.SwimlaneTrackingData;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.common.bindingAdapters.ResizeStrategy;
import com.talabat.darkstores.common.extensions.DsCounterExtensionsKt;
import com.talabat.darkstores.common.extensions.FloatExtensionsKt;
import com.talabat.darkstores.common.lists.ProductDiffCallback;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.darkstores.model.CompactSwimlaneLayoutType;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.talabatcommon.extension.ViewKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001*BO\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u001c\u0010 \u001a\u00020\u001b2\n\u0010!\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u001c\u0010\"\u001a\u00060\u0003R\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\bH\u0016J\u0014\u0010&\u001a\u00020\u001b2\n\u0010!\u001a\u00060\u0003R\u00020\u0000H\u0016J\u0018\u0010'\u001a\u00020\u001b2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010)H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000RL\u0010\u0015\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010\u000e\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/talabat/darkstores/common/lists/adapters/compact/CompactSwimlaneAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "Lcom/talabat/darkstores/common/lists/adapters/compact/CompactSwimlaneAdapter$ViewHolder;", "cartContent", "Landroidx/lifecycle/LiveData;", "", "", "", "addToCartListener", "Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;", "trackingCategoryId", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "swimlaneStrategy", "swimlaneRequestId", "compactSwimlaneLayoutType", "Lcom/talabat/darkstores/model/CompactSwimlaneLayoutType;", "useCounter", "", "(Landroidx/lifecycle/LiveData;Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/darkstores/model/CompactSwimlaneLayoutType;Z)V", "hasDiscountedItems", "onItemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "item", "position", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "submitList", "products", "", "ViewHolder", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CompactSwimlaneAdapter extends ListAdapter<Product, ViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public final OnProductQuantityChangeTrackingListener addToCartListener;
    /* access modifiers changed from: private */
    @NotNull
    public final LiveData<Map<String, Integer>> cartContent;
    /* access modifiers changed from: private */
    @NotNull
    public final CompactSwimlaneLayoutType compactSwimlaneLayoutType;
    /* access modifiers changed from: private */
    public boolean hasDiscountedItems;
    @Nullable
    private Function2<? super Product, ? super Integer, Unit> onItemClickListener;
    /* access modifiers changed from: private */
    @NotNull
    public final String swimlaneRequestId;
    /* access modifiers changed from: private */
    @NotNull
    public final String swimlaneStrategy;
    /* access modifiers changed from: private */
    @NotNull
    public final TrackingCategoryId trackingCategoryId;
    /* access modifiers changed from: private */
    public final boolean useCounter;

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u001fJ\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u001f\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u00152\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b(R\u001c\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\n \u0007*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\n \u0007*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010\u001c\u001a\n \u0007*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019¨\u0006)"}, d2 = {"Lcom/talabat/darkstores/common/lists/adapters/compact/CompactSwimlaneAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/talabat/darkstores/common/lists/adapters/compact/CompactSwimlaneAdapter;Landroid/view/View;)V", "campaign", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "getCampaign$com_talabat_NewArchi_darkstores_darkstores", "()Landroid/widget/RelativeLayout;", "image", "Landroid/widget/ImageView;", "itemButton", "Lcom/talabat/darkstores/common/lists/adapters/compact/CompactSwimlaneItemButton;", "itemCounter", "Lcom/designsystem/ds_stepper/DSCollapsibleQuantityStepper;", "name", "Landroid/widget/TextView;", "observer", "Landroidx/lifecycle/Observer;", "", "", "", "oldPrice", "getOldPrice$com_talabat_NewArchi_darkstores_darkstores", "()Landroid/widget/TextView;", "outOfStock", "getOutOfStock$com_talabat_NewArchi_darkstores_darkstores", "price", "getPrice$com_talabat_NewArchi_darkstores_darkstores", "bind", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "clear", "setupLabels", "setupPreviousPrice", "shouldShowCampaign", "", "campaignLabel", "shouldShowCampaign$com_talabat_NewArchi_darkstores_darkstores", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final RelativeLayout campaign = ((RelativeLayout) this.itemView.findViewById(R.id.compact_swimlane_campaign));

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CompactSwimlaneAdapter f56160h;
        private final ImageView image = ((ImageView) this.itemView.findViewById(R.id.compact_swimlane_item_image));
        private final CompactSwimlaneItemButton itemButton = ((CompactSwimlaneItemButton) this.itemView.findViewById(R.id.compact_swimlane_item_button));
        private final DSCollapsibleQuantityStepper itemCounter = ((DSCollapsibleQuantityStepper) this.itemView.findViewById(R.id.compact_swimlane_counter));

        /* renamed from: name  reason: collision with root package name */
        private final TextView f56161name = ((TextView) this.itemView.findViewById(R.id.compact_swimlane_name));
        @Nullable
        private Observer<Map<String, Integer>> observer;
        private final TextView oldPrice = ((TextView) this.itemView.findViewById(R.id.compact_swimlane_old_price));
        private final TextView outOfStock = ((TextView) this.itemView.findViewById(R.id.compact_swimlane_out_of_stock));
        private final TextView price = ((TextView) this.itemView.findViewById(R.id.compact_swimlane_price));

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull CompactSwimlaneAdapter compactSwimlaneAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.f56160h = compactSwimlaneAdapter;
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m9637bind$lambda0(CompactSwimlaneAdapter compactSwimlaneAdapter, Product product, ViewHolder viewHolder, View view) {
            Intrinsics.checkNotNullParameter(compactSwimlaneAdapter, "this$0");
            Intrinsics.checkNotNullParameter(product, "$product");
            Intrinsics.checkNotNullParameter(viewHolder, "this$1");
            OnProductQuantityChangeTrackingListener.DefaultImpls.increaseProductCount$default(compactSwimlaneAdapter.addToCartListener, product, 1, Integer.valueOf(viewHolder.getBindingAdapterPosition()), compactSwimlaneAdapter.trackingCategoryId, (SwimlaneTrackingData) null, compactSwimlaneAdapter.swimlaneRequestId, compactSwimlaneAdapter.swimlaneStrategy, false, (Function0) null, 400, (Object) null);
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-1  reason: not valid java name */
        public static final void m9638bind$lambda1(ViewHolder viewHolder, Product product, Map map) {
            Intrinsics.checkNotNullParameter(viewHolder, "this$0");
            Intrinsics.checkNotNullParameter(product, "$product");
            CompactSwimlaneItemButton compactSwimlaneItemButton = viewHolder.itemButton;
            Intrinsics.checkNotNullExpressionValue(map, "cartContent");
            compactSwimlaneItemButton.setChecked(map.containsKey(product.getId()));
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x006a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void setupLabels(com.talabat.feature.darkstorescart.data.model.Product r7) {
            /*
                r6 = this;
                java.lang.String r0 = r7.getOfferText()
                r1 = 0
                r2 = 0
                r3 = 1
                if (r0 == 0) goto L_0x0016
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r0)
                if (r4 != 0) goto L_0x0010
                goto L_0x0011
            L_0x0010:
                r0 = r1
            L_0x0011:
                if (r0 != 0) goto L_0x0014
                goto L_0x0016
            L_0x0014:
                r1 = r0
                goto L_0x0036
            L_0x0016:
                com.talabat.feature.darkstorescart.data.model.CampaignTrigger r0 = r7.getCampaignTrigger()
                if (r0 == 0) goto L_0x0036
                android.view.View r1 = r6.itemView
                android.content.res.Resources r1 = r1.getResources()
                java.lang.String r4 = "itemView.resources"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
                android.view.View r4 = r6.itemView
                int r4 = r4.getLayoutDirection()
                if (r4 != r3) goto L_0x0031
                r4 = r3
                goto L_0x0032
            L_0x0031:
                r4 = r2
            L_0x0032:
                java.lang.String r1 = com.talabat.darkstores.common.extensions.CampaignTriggerExtensionsKt.toLabel(r0, r1, r4)
            L_0x0036:
                android.widget.RelativeLayout r0 = r6.campaign
                java.lang.String r4 = "campaign"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
                boolean r4 = r6.shouldShowCampaign$com_talabat_NewArchi_darkstores_darkstores(r1, r7)
                r5 = 8
                if (r4 == 0) goto L_0x0047
                r4 = r2
                goto L_0x0048
            L_0x0047:
                r4 = r5
            L_0x0048:
                r0.setVisibility(r4)
                android.widget.RelativeLayout r0 = r6.campaign
                int r4 = com.talabat.darkstores.R.id.promo_title
                android.view.View r0 = r0.findViewById(r4)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r0.setText(r1)
                android.widget.TextView r0 = r6.outOfStock
                java.lang.String r1 = "outOfStock"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                int r7 = r7.getStock()
                if (r7 >= r3) goto L_0x0066
                goto L_0x0067
            L_0x0066:
                r3 = r2
            L_0x0067:
                if (r3 == 0) goto L_0x006a
                goto L_0x006b
            L_0x006a:
                r2 = r5
            L_0x006b:
                r0.setVisibility(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.common.lists.adapters.compact.CompactSwimlaneAdapter.ViewHolder.setupLabels(com.talabat.feature.darkstorescart.data.model.Product):void");
        }

        private final void setupPreviousPrice(Product product) {
            String str;
            if (!this.f56160h.hasDiscountedItems) {
                TextView textView = this.oldPrice;
                Intrinsics.checkNotNullExpressionValue(textView, "oldPrice");
                ViewKt.invisible(textView);
                return;
            }
            TextView textView2 = this.oldPrice;
            textView2.setPaintFlags(textView2.getPaintFlags() | 16);
            TextView textView3 = this.oldPrice;
            Float previousPrice = product.getPreviousPrice();
            if (previousPrice == null || (str = FloatExtensionsKt.formatCurrency(previousPrice.floatValue())) == null) {
                str = "";
            }
            textView3.setText(str);
        }

        public final void bind(@NotNull Product product) {
            boolean z11;
            Intrinsics.checkNotNullParameter(product, "product");
            if (this.f56160h.compactSwimlaneLayoutType == CompactSwimlaneLayoutType.COMPACT_WITH_TEXT) {
                TextView textView = this.f56161name;
                Intrinsics.checkNotNullExpressionValue(textView, "name");
                ViewKt.visible(textView);
                TextView textView2 = this.price;
                Intrinsics.checkNotNullExpressionValue(textView2, FirebaseAnalytics.Param.PRICE);
                ViewKt.visible(textView2);
                this.f56161name.setText(product.getName());
                if (this.f56160h.useCounter) {
                    TextView textView3 = this.price;
                    float price2 = product.getPrice();
                    Context context = this.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                    if (product.getPreviousPrice() != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    textView3.setText(FloatExtensionsKt.getFormattedPriceAndCurrency$default(price2, context, z11, com.designsystem.marshmallow.R.style.DSTextAppearance_Body1Bold, 0, 8, (Object) null));
                    setupPreviousPrice(product);
                } else {
                    TextView textView4 = this.price;
                    float price3 = product.getPrice();
                    Context context2 = this.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
                    textView4.setText(FloatExtensionsKt.getFormattedPriceAndCurrency$default(price3, context2, false, com.designsystem.marshmallow.R.style.DSTextAppearance_Body1Bold, 0, 8, (Object) null));
                }
            } else {
                TextView textView5 = this.f56161name;
                Intrinsics.checkNotNullExpressionValue(textView5, "name");
                ViewKt.invisible(textView5);
                TextView textView6 = this.price;
                Intrinsics.checkNotNullExpressionValue(textView6, FirebaseAnalytics.Param.PRICE);
                ViewKt.invisible(textView6);
                TextView textView7 = this.oldPrice;
                Intrinsics.checkNotNullExpressionValue(textView7, "oldPrice");
                ViewKt.invisible(textView7);
            }
            ImageView imageView = this.image;
            Intrinsics.checkNotNullExpressionValue(imageView, "image");
            BindingAdaptersKt.loadImageWithGlide$default(imageView, product.getImageUrl(), Integer.valueOf(R.drawable.product_tile_placeholder_new), (ResizeStrategy) null, (Transformation) null, (Integer) null, 28, (Object) null);
            if (this.f56160h.useCounter) {
                setupLabels(product);
            }
            if (this.f56160h.useCounter) {
                this.itemButton.setVisibility(8);
                this.itemCounter.setVisibility(0);
                DSCollapsibleQuantityStepper dSCollapsibleQuantityStepper = this.itemCounter;
                Intrinsics.checkNotNullExpressionValue(dSCollapsibleQuantityStepper, "itemCounter");
                View view = this.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "itemView");
                DsCounterExtensionsKt.setupDesignSystemStepper(dSCollapsibleQuantityStepper, view, product, this.f56160h.addToCartListener, (OnProductQuantityChangeListener) null, getBindingAdapterPosition(), this.f56160h.swimlaneStrategy);
                return;
            }
            this.itemButton.setVisibility(0);
            this.itemCounter.setVisibility(8);
            this.itemButton.setOnClickListener(new b(this.f56160h, product, this));
            c cVar = new c(this, product);
            this.f56160h.cartContent.observeForever(cVar);
            this.observer = cVar;
        }

        public final void clear() {
            Observer<Map<String, Integer>> observer2 = this.observer;
            if (observer2 != null) {
                this.f56160h.cartContent.removeObserver(observer2);
            }
            this.observer = null;
            this.itemButton.setOnClickListener((View.OnClickListener) null);
            this.itemCounter.setOnValueChanged((Function1<? super Integer, Unit>) null);
        }

        public final RelativeLayout getCampaign$com_talabat_NewArchi_darkstores_darkstores() {
            return this.campaign;
        }

        public final TextView getOldPrice$com_talabat_NewArchi_darkstores_darkstores() {
            return this.oldPrice;
        }

        public final TextView getOutOfStock$com_talabat_NewArchi_darkstores_darkstores() {
            return this.outOfStock;
        }

        public final TextView getPrice$com_talabat_NewArchi_darkstores_darkstores() {
            return this.price;
        }

        public final boolean shouldShowCampaign$com_talabat_NewArchi_darkstores_darkstores(@Nullable String str, @NotNull Product product) {
            boolean z11;
            Intrinsics.checkNotNullParameter(product, "product");
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
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CompactSwimlaneAdapter(@NotNull LiveData<Map<String, Integer>> liveData, @NotNull OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, @NotNull TrackingCategoryId trackingCategoryId2, @NotNull String str, @NotNull String str2, @NotNull CompactSwimlaneLayoutType compactSwimlaneLayoutType2, boolean z11) {
        super(new ProductDiffCallback());
        Intrinsics.checkNotNullParameter(liveData, "cartContent");
        Intrinsics.checkNotNullParameter(onProductQuantityChangeTrackingListener, "addToCartListener");
        Intrinsics.checkNotNullParameter(trackingCategoryId2, "trackingCategoryId");
        Intrinsics.checkNotNullParameter(str, "swimlaneStrategy");
        Intrinsics.checkNotNullParameter(str2, "swimlaneRequestId");
        Intrinsics.checkNotNullParameter(compactSwimlaneLayoutType2, "compactSwimlaneLayoutType");
        this.cartContent = liveData;
        this.addToCartListener = onProductQuantityChangeTrackingListener;
        this.trackingCategoryId = trackingCategoryId2;
        this.swimlaneStrategy = str;
        this.swimlaneRequestId = str2;
        this.compactSwimlaneLayoutType = compactSwimlaneLayoutType2;
        this.useCounter = z11;
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m9636onBindViewHolder$lambda1(CompactSwimlaneAdapter compactSwimlaneAdapter, int i11, View view) {
        Intrinsics.checkNotNullParameter(compactSwimlaneAdapter, "this$0");
        Function2<? super Product, ? super Integer, Unit> function2 = compactSwimlaneAdapter.onItemClickListener;
        if (function2 != null) {
            Object item = compactSwimlaneAdapter.getItem(i11);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
            function2.invoke(item, Integer.valueOf(i11));
        }
    }

    @Nullable
    public final Function2<Product, Integer, Unit> getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public final void setOnItemClickListener(@Nullable Function2<? super Product, ? super Integer, Unit> function2) {
        this.onItemClickListener = function2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.talabat.feature.darkstorescart.data.model.Product} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.talabat.feature.darkstorescart.data.model.Product} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.talabat.feature.darkstorescart.data.model.Product} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.talabat.feature.darkstorescart.data.model.Product} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.talabat.feature.darkstorescart.data.model.Product} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void submitList(@org.jetbrains.annotations.Nullable java.util.List<com.talabat.feature.darkstorescart.data.model.Product> r6) {
        /*
            r5 = this;
            super.submitList(r6)
            r0 = 1
            r1 = 0
            r2 = 0
            if (r6 == 0) goto L_0x0029
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x000e:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L_0x0027
            java.lang.Object r3 = r6.next()
            r4 = r3
            com.talabat.feature.darkstorescart.data.model.Product r4 = (com.talabat.feature.darkstorescart.data.model.Product) r4
            java.lang.Float r4 = r4.getPreviousPrice()
            if (r4 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r1
        L_0x0024:
            if (r4 == 0) goto L_0x000e
            r2 = r3
        L_0x0027:
            com.talabat.feature.darkstorescart.data.model.Product r2 = (com.talabat.feature.darkstorescart.data.model.Product) r2
        L_0x0029:
            if (r2 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r0 = r1
        L_0x002d:
            r5.hasDiscountedItems = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.common.lists.adapters.compact.CompactSwimlaneAdapter.submitList(java.util.List):void");
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Object item = getItem(i11);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        viewHolder.bind((Product) item);
        viewHolder.itemView.setOnClickListener(new a(this, i11));
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new ViewHolder(this, ViewKt.inflate(viewGroup, R.layout.compact_swimlane_item));
    }

    public void onViewRecycled(@NotNull ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        viewHolder.clear();
    }
}
