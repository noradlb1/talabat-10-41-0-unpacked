package com.talabat.darkstores.feature.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.SwimlaneTrackingData;
import com.talabat.darkstores.common.lists.adapters.compact.CompactSwimlaneAdapter;
import com.talabat.darkstores.common.view.CartItemViewHolder;
import com.talabat.darkstores.common.view.CartItemViewHolderCompact;
import com.talabat.darkstores.data.partialFulfillment.model.Control;
import com.talabat.darkstores.databinding.DarkstoresItemCartSectionHeaderBinding;
import com.talabat.darkstores.databinding.DarkstoresItemProductCartNewCompactBinding;
import com.talabat.darkstores.feature.cart.model.CartProductViewType;
import com.talabat.darkstores.feature.cart.views.CompactSwimlaneView;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.darkstores.model.CompactSwimlaneLayoutType;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.views.banners.DisclaimerBannerView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ri.k1;
import ri.l1;
import ri.m1;
import ri.n1;

@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0013\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0006,-./01BY\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0002J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010#\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001fH\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0016\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cartFragmentViewModel", "Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel;", "onProductClicked", "Lkotlin/Function1;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "", "onSpecialRequestChanged", "", "onPartialFulfillmentClicked", "Lkotlin/Function0;", "onOosPredictionAlertShown", "cartProductViewType", "Lcom/talabat/darkstores/feature/cart/model/CartProductViewType;", "(Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/talabat/darkstores/feature/cart/model/CartProductViewType;)V", "quantityChangedListener", "com/talabat/darkstores/feature/cart/CartListAdapter$quantityChangedListener$1", "Lcom/talabat/darkstores/feature/cart/CartListAdapter$quantityChangedListener$1;", "swimlaneTrackingData", "Lcom/talabat/darkstores/common/SwimlaneTrackingData;", "bindCartProduct", "item", "Lcom/talabat/darkstores/feature/cart/CartProduct;", "holder", "bindSwimlane", "cartSwimlane", "Lcom/talabat/darkstores/feature/cart/CartSwimlane;", "getItemViewType", "", "position", "getProductLayout", "getViewTypeForCartSwimlane", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "setSwimlaneTrackingData", "swimlaneTitle", "swimlaneLength", "CartPartialFulfillmentViewHolder", "CartSectionHeaderViewHolder", "CartSpecialRequestViewHolder", "CompactSwimlaneViewHolder", "DiffCallback", "DisclaimerViewHolder", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartListAdapter extends ListAdapter<Object, RecyclerView.ViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public final CartFragmentViewModel cartFragmentViewModel;
    @NotNull
    private final CartProductViewType cartProductViewType;
    @NotNull
    private final Function0<Unit> onOosPredictionAlertShown;
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<Unit> onPartialFulfillmentClicked;
    @NotNull
    private final Function1<Product, Unit> onProductClicked;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<String, Unit> onSpecialRequestChanged;
    @NotNull
    private final CartListAdapter$quantityChangedListener$1 quantityChangedListener = new CartListAdapter$quantityChangedListener$1(this);
    @Nullable
    private SwimlaneTrackingData swimlaneTrackingData;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartListAdapter$CartPartialFulfillmentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "(Lcom/talabat/darkstores/feature/cart/CartListAdapter;Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "model", "Lcom/talabat/darkstores/feature/cart/CartPartialFulfillment;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class CartPartialFulfillmentViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
        @NotNull
        private final View containerView;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CartListAdapter f56275h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CartPartialFulfillmentViewHolder(@NotNull CartListAdapter cartListAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.f56275h = cartListAdapter;
            this.containerView = view;
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-3$lambda-0  reason: not valid java name */
        public static final void m9828bind$lambda3$lambda0(CartListAdapter cartListAdapter, View view) {
            Intrinsics.checkNotNullParameter(cartListAdapter, "this$0");
            cartListAdapter.onPartialFulfillmentClicked.invoke();
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-3$lambda-1  reason: not valid java name */
        public static final void m9829bind$lambda3$lambda1(CartListAdapter cartListAdapter, View view) {
            Intrinsics.checkNotNullParameter(cartListAdapter, "this$0");
            cartListAdapter.onPartialFulfillmentClicked.invoke();
        }

        public final void bind(@NotNull CartPartialFulfillment cartPartialFulfillment) {
            boolean z11;
            int i11;
            Intrinsics.checkNotNullParameter(cartPartialFulfillment, DeviceRequestsHelper.DEVICE_INFO_MODEL);
            View containerView2 = getContainerView();
            CartListAdapter cartListAdapter = this.f56275h;
            ConstraintLayout constraintLayout = (ConstraintLayout) containerView2.findViewById(R.id.not_selected_control_container);
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "not_selected_control_container");
            boolean z12 = true;
            int i12 = 0;
            if (cartPartialFulfillment.getSelectedControl() == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            constraintLayout.setVisibility(i11);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) containerView2.findViewById(R.id.selected_control_container);
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "selected_control_container");
            if (cartPartialFulfillment.getSelectedControl() == null) {
                z12 = false;
            }
            if (!z12) {
                i12 = 8;
            }
            constraintLayout2.setVisibility(i12);
            ((AppCompatTextView) containerView2.findViewById(R.id.selection_change)).setOnClickListener(new k1(cartListAdapter));
            ((AppCompatTextView) containerView2.findViewById(R.id.no_selection_select)).setOnClickListener(new l1(cartListAdapter));
            ((AppCompatTextView) containerView2.findViewById(R.id.partial_fulfillment_title)).setText(cartPartialFulfillment.getName());
            Control selectedControl = cartPartialFulfillment.getSelectedControl();
            if (selectedControl != null) {
                ((AppCompatTextView) containerView2.findViewById(R.id.selection_control_title)).setText(selectedControl.getName());
                ((AppCompatTextView) containerView2.findViewById(R.id.selection_control_body)).setText(selectedControl.getDescription());
            }
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartListAdapter$CartSectionHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/darkstores/databinding/DarkstoresItemCartSectionHeaderBinding;", "(Lcom/talabat/darkstores/feature/cart/CartListAdapter;Lcom/talabat/darkstores/databinding/DarkstoresItemCartSectionHeaderBinding;)V", "getBinding", "()Lcom/talabat/darkstores/databinding/DarkstoresItemCartSectionHeaderBinding;", "bind", "", "cartSectionHeader", "Lcom/talabat/darkstores/feature/cart/CartSectionHeader;", "getSubtitle", "", "cartSectionType", "Lcom/talabat/darkstores/feature/cart/CartSectionType;", "getTitle", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class CartSectionHeaderViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final DarkstoresItemCartSectionHeaderBinding binding;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CartListAdapter f56276h;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CartSectionType.values().length];
                iArr[CartSectionType.OOS.ordinal()] = 1;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CartSectionHeaderViewHolder(@NotNull CartListAdapter cartListAdapter, DarkstoresItemCartSectionHeaderBinding darkstoresItemCartSectionHeaderBinding) {
            super(darkstoresItemCartSectionHeaderBinding.getRoot());
            Intrinsics.checkNotNullParameter(darkstoresItemCartSectionHeaderBinding, "binding");
            this.f56276h = cartListAdapter;
            this.binding = darkstoresItemCartSectionHeaderBinding;
        }

        private final int getSubtitle(CartSectionType cartSectionType) {
            if (WhenMappings.$EnumSwitchMapping$0[cartSectionType.ordinal()] == 1) {
                return com.talabat.localization.R.string.oos_cart_section_subtitle;
            }
            throw new NoWhenBranchMatchedException();
        }

        private final int getTitle(CartSectionType cartSectionType) {
            if (WhenMappings.$EnumSwitchMapping$0[cartSectionType.ordinal()] == 1) {
                return com.talabat.localization.R.string.oos_cart_section_title;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final void bind(@NotNull CartSectionHeader cartSectionHeader) {
            Intrinsics.checkNotNullParameter(cartSectionHeader, "cartSectionHeader");
            this.binding.tvTitle.setText(getTitle(cartSectionHeader.getCartSectionType()));
            this.binding.tvSubtitle.setText(getSubtitle(cartSectionHeader.getCartSectionType()));
        }

        @NotNull
        public final DarkstoresItemCartSectionHeaderBinding getBinding() {
            return this.binding;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartListAdapter$CartSpecialRequestViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "(Lcom/talabat/darkstores/feature/cart/CartListAdapter;Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class CartSpecialRequestViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
        @NotNull
        private final View containerView;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CartListAdapter f56277h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CartSpecialRequestViewHolder(@NotNull CartListAdapter cartListAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.f56277h = cartListAdapter;
            this.containerView = view;
        }

        public final void bind() {
            ((AppCompatEditText) getContainerView().findViewById(R.id.edit_cart_speical_comment)).addTextChangedListener(new CartListAdapter$CartSpecialRequestViewHolder$bind$1(this.f56277h));
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartListAdapter$CompactSwimlaneViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "(Lcom/talabat/darkstores/feature/cart/CartListAdapter;Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "cartSwimlane", "Lcom/talabat/darkstores/feature/cart/CartSwimlane;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class CompactSwimlaneViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
        @NotNull
        private final View containerView;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CartListAdapter f56279h;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CartSwimlaneViewType.values().length];
                iArr[CartSwimlaneViewType.COMPACT_WITH_INFO.ordinal()] = 1;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CompactSwimlaneViewHolder(@NotNull CartListAdapter cartListAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.f56279h = cartListAdapter;
            this.containerView = view;
        }

        public final void bind(@NotNull CartSwimlane cartSwimlane) {
            CompactSwimlaneLayoutType compactSwimlaneLayoutType;
            Intrinsics.checkNotNullParameter(cartSwimlane, "cartSwimlane");
            LiveData<Map<String, Integer>> cartMapLiveData = this.f56279h.cartFragmentViewModel.getCartMapLiveData();
            CartFragmentViewModel access$getCartFragmentViewModel$p = this.f56279h.cartFragmentViewModel;
            TrackingCategoryId.CustomSwimlane customSwimlane = new TrackingCategoryId.CustomSwimlane(cartSwimlane.getTitle());
            String trackingId = cartSwimlane.getSwimlane().getTracking().getTrackingId();
            String swimlaneId = cartSwimlane.getSwimlane().getTracking().getSwimlaneId();
            if (WhenMappings.$EnumSwitchMapping$0[cartSwimlane.getViewType().ordinal()] == 1) {
                compactSwimlaneLayoutType = CompactSwimlaneLayoutType.COMPACT_WITH_TEXT;
            } else {
                compactSwimlaneLayoutType = CompactSwimlaneLayoutType.COMPACT;
            }
            CompactSwimlaneAdapter compactSwimlaneAdapter = new CompactSwimlaneAdapter(cartMapLiveData, access$getCartFragmentViewModel$p, customSwimlane, trackingId, swimlaneId, compactSwimlaneLayoutType, false);
            View containerView2 = getContainerView();
            int i11 = R.id.compact_swimlane;
            ((CompactSwimlaneView) containerView2.findViewById(i11)).setOnSwipeOnceListener(new CartListAdapter$CompactSwimlaneViewHolder$bind$1(this.f56279h, cartSwimlane));
            this.f56279h.cartFragmentViewModel.trackSwimlaneShown(cartSwimlane);
            ((CompactSwimlaneView) getContainerView().findViewById(i11)).setupAdapterAndProducts(compactSwimlaneAdapter, cartSwimlane.getProducts());
            ((CompactSwimlaneView) getContainerView().findViewById(i11)).setTitle(cartSwimlane.getTitle());
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartListAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "getChangePayload", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<Object> {
        @NotNull
        public static final DiffCallback INSTANCE = new DiffCallback();

        private DiffCallback() {
        }

        public boolean areContentsTheSame(@NotNull Object obj, @NotNull Object obj2) {
            Intrinsics.checkNotNullParameter(obj, "oldItem");
            Intrinsics.checkNotNullParameter(obj2, "newItem");
            if (obj2 instanceof CartProduct) {
                if ((obj instanceof CartProduct) && Intrinsics.areEqual(obj, obj2)) {
                    return true;
                }
            } else if (obj2 instanceof CartDisclaimer) {
                return obj instanceof CartDisclaimer;
            } else {
                if (obj2 instanceof CartSwimlane) {
                    if ((obj instanceof CartSwimlane) && Intrinsics.areEqual(obj, obj2)) {
                        return true;
                    }
                } else if (obj2 instanceof CartSpecialRequest) {
                    return obj instanceof CartSpecialRequest;
                } else {
                    if (obj2 instanceof CartPartialFulfillment) {
                        if ((obj instanceof CartPartialFulfillment) && Intrinsics.areEqual((Object) ((CartPartialFulfillment) obj).getSelectedControl(), (Object) ((CartPartialFulfillment) obj2).getSelectedControl())) {
                            return true;
                        }
                    } else if (!(obj2 instanceof CartSectionHeader)) {
                        throw new IllegalArgumentException("Unsupported item type");
                    } else if ((obj instanceof CartSectionHeader) && ((CartSectionHeader) obj).getCartSectionType() == ((CartSectionHeader) obj2).getCartSectionType()) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean areItemsTheSame(@NotNull Object obj, @NotNull Object obj2) {
            Intrinsics.checkNotNullParameter(obj, "oldItem");
            Intrinsics.checkNotNullParameter(obj2, "newItem");
            if (obj2 instanceof CartProduct) {
                if (obj instanceof CartProduct) {
                    CartProduct cartProduct = (CartProduct) obj;
                    CartProduct cartProduct2 = (CartProduct) obj2;
                    if (Intrinsics.areEqual((Object) cartProduct.getProduct().getId(), (Object) cartProduct2.getProduct().getId()) && cartProduct.isCampaignFulfilled() == cartProduct2.isCampaignFulfilled() && cartProduct.isOOS() == cartProduct2.isOOS() && cartProduct.getShowAlerts() == cartProduct2.getShowAlerts()) {
                        return true;
                    }
                }
            } else if (obj2 instanceof CartDisclaimer) {
                return obj instanceof CartDisclaimer;
            } else {
                if (obj2 instanceof CartSwimlane) {
                    return obj instanceof CartSwimlane;
                }
                if (obj2 instanceof CartSpecialRequest) {
                    return obj instanceof CartSpecialRequest;
                }
                if (obj2 instanceof CartPartialFulfillment) {
                    if ((obj instanceof CartPartialFulfillment) && Intrinsics.areEqual((Object) ((CartPartialFulfillment) obj).getSelectedControl(), (Object) ((CartPartialFulfillment) obj2).getSelectedControl())) {
                        return true;
                    }
                } else if (!(obj2 instanceof CartSectionHeader)) {
                    throw new IllegalArgumentException("Unsupported item type");
                } else if ((obj instanceof CartSectionHeader) && ((CartSectionHeader) obj).getCartSectionType() == ((CartSectionHeader) obj2).getCartSectionType()) {
                    return true;
                }
            }
            return false;
        }

        @Nullable
        public Object getChangePayload(@NotNull Object obj, @NotNull Object obj2) {
            Intrinsics.checkNotNullParameter(obj, "oldItem");
            Intrinsics.checkNotNullParameter(obj2, "newItem");
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0014\u0010\u000f\u001a\u00020\t*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartListAdapter$DisclaimerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "(Lcom/talabat/darkstores/feature/cart/CartListAdapter;Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "title", "", "description", "actionText", "url", "setVisibilityAndLayoutParams", "Lcom/talabat/talabatcommon/views/banners/DisclaimerBannerView;", "visible", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class DisclaimerViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
        @NotNull
        private final View containerView;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CartListAdapter f56282h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DisclaimerViewHolder(@NotNull CartListAdapter cartListAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.f56282h = cartListAdapter;
            this.containerView = view;
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-2$lambda-0  reason: not valid java name */
        public static final void m9830bind$lambda2$lambda0(DisclaimerViewHolder disclaimerViewHolder, DisclaimerBannerView disclaimerBannerView, CartListAdapter cartListAdapter, String str, View view) {
            Intrinsics.checkNotNullParameter(disclaimerViewHolder, "this$0");
            Intrinsics.checkNotNullParameter(cartListAdapter, "this$1");
            Intrinsics.checkNotNullParameter(str, "$url");
            Intrinsics.checkNotNullExpressionValue(disclaimerBannerView, "");
            disclaimerViewHolder.setVisibilityAndLayoutParams(disclaimerBannerView, false);
            cartListAdapter.cartFragmentViewModel.dismissDisclaimer();
            Context context = disclaimerViewHolder.getContainerView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
            StringUtils.openUrlInBrowser(str, context);
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-2$lambda-1  reason: not valid java name */
        public static final void m9831bind$lambda2$lambda1(DisclaimerViewHolder disclaimerViewHolder, DisclaimerBannerView disclaimerBannerView, CartListAdapter cartListAdapter, View view) {
            Intrinsics.checkNotNullParameter(disclaimerViewHolder, "this$0");
            Intrinsics.checkNotNullParameter(cartListAdapter, "this$1");
            Intrinsics.checkNotNullExpressionValue(disclaimerBannerView, "");
            disclaimerViewHolder.setVisibilityAndLayoutParams(disclaimerBannerView, false);
            cartListAdapter.cartFragmentViewModel.dismissDisclaimer();
        }

        private final void setVisibilityAndLayoutParams(DisclaimerBannerView disclaimerBannerView, boolean z11) {
            int i11;
            int i12;
            int i13 = 0;
            if (z11) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            disclaimerBannerView.setVisibility(i11);
            ViewGroup.LayoutParams layoutParams = disclaimerBannerView.getLayoutParams();
            if (z11) {
                i12 = -2;
            } else {
                i12 = 0;
            }
            layoutParams.height = i12;
            ViewGroup.LayoutParams layoutParams2 = disclaimerBannerView.getLayoutParams();
            if (z11) {
                i13 = -1;
            }
            layoutParams2.width = i13;
        }

        public final void bind(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "description");
            Intrinsics.checkNotNullParameter(str3, "actionText");
            Intrinsics.checkNotNullParameter(str4, "url");
            DisclaimerBannerView disclaimerBannerView = (DisclaimerBannerView) getContainerView().findViewById(R.id.disclaimer_banner);
            CartListAdapter cartListAdapter = this.f56282h;
            disclaimerBannerView.setData(str, str2, str3);
            disclaimerBannerView.setOnMoreInfoClickListener(new m1(this, disclaimerBannerView, cartListAdapter, str4));
            disclaimerBannerView.setOnCloseClickListener(new n1(this, disclaimerBannerView, cartListAdapter));
            Intrinsics.checkNotNullExpressionValue(disclaimerBannerView, "");
            setVisibilityAndLayoutParams(disclaimerBannerView, !cartListAdapter.cartFragmentViewModel.isDisclaimerDismissed());
            this.f56282h.cartFragmentViewModel.trackDisclaimerDisplayed();
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CartSwimlaneViewType.values().length];
            iArr[CartSwimlaneViewType.COMPACT.ordinal()] = 1;
            iArr[CartSwimlaneViewType.COMPACT_WITH_INFO.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CartProductViewType.values().length];
            iArr2[CartProductViewType.NEW_COMPACT_WITH_ALERTS.ordinal()] = 1;
            iArr2[CartProductViewType.NEW_COMPACT.ordinal()] = 2;
            iArr2[CartProductViewType.NEW.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartListAdapter(@NotNull CartFragmentViewModel cartFragmentViewModel2, @NotNull Function1<? super Product, Unit> function1, @NotNull Function1<? super String, Unit> function12, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull CartProductViewType cartProductViewType2) {
        super(DiffCallback.INSTANCE);
        Intrinsics.checkNotNullParameter(cartFragmentViewModel2, "cartFragmentViewModel");
        Intrinsics.checkNotNullParameter(function1, "onProductClicked");
        Intrinsics.checkNotNullParameter(function12, "onSpecialRequestChanged");
        Intrinsics.checkNotNullParameter(function0, "onPartialFulfillmentClicked");
        Intrinsics.checkNotNullParameter(function02, "onOosPredictionAlertShown");
        Intrinsics.checkNotNullParameter(cartProductViewType2, "cartProductViewType");
        this.cartFragmentViewModel = cartFragmentViewModel2;
        this.onProductClicked = function1;
        this.onSpecialRequestChanged = function12;
        this.onPartialFulfillmentClicked = function0;
        this.onOosPredictionAlertShown = function02;
        this.cartProductViewType = cartProductViewType2;
    }

    private final void bindCartProduct(CartProduct cartProduct, RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof CartItemViewHolderCompact) {
            ((CartItemViewHolderCompact) viewHolder).bind(cartProduct);
        } else if (viewHolder instanceof CartItemViewHolder) {
            ((CartItemViewHolder) viewHolder).bind(cartProduct.getProduct(), cartProduct.isCampaignFulfilled());
        }
    }

    private final void bindSwimlane(CartSwimlane cartSwimlane, RecyclerView.ViewHolder viewHolder) {
        CompactSwimlaneViewHolder compactSwimlaneViewHolder;
        int i11 = WhenMappings.$EnumSwitchMapping$0[cartSwimlane.getViewType().ordinal()];
        if (i11 == 1 || i11 == 2) {
            if (viewHolder instanceof CompactSwimlaneViewHolder) {
                compactSwimlaneViewHolder = (CompactSwimlaneViewHolder) viewHolder;
            } else {
                compactSwimlaneViewHolder = null;
            }
            if (compactSwimlaneViewHolder != null) {
                compactSwimlaneViewHolder.bind(cartSwimlane);
            }
        }
    }

    private final int getProductLayout() {
        int i11 = WhenMappings.$EnumSwitchMapping$1[this.cartProductViewType.ordinal()];
        if (i11 == 1 || i11 == 2) {
            return R.layout.darkstores_item_product_cart_new_compact;
        }
        if (i11 == 3) {
            return R.layout.darkstores_item_product_cart_new;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int getViewTypeForCartSwimlane(CartSwimlane cartSwimlane) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[cartSwimlane.getViewType().ordinal()];
        if (i11 == 1 || i11 == 2) {
            return R.layout.darkstores_compact_swimlane;
        }
        throw new NoWhenBranchMatchedException();
    }

    public int getItemViewType(int i11) {
        Object item = getItem(i11);
        if (item instanceof CartProduct) {
            return getProductLayout();
        }
        if (item instanceof CartDisclaimer) {
            return R.layout.darkstores_item_disclaimer_banner;
        }
        if (item instanceof CartSummary) {
            return R.layout.darkstores_fragment_cart_summary;
        }
        if (item instanceof CartSpecialRequest) {
            return R.layout.darkstores_cart_special_request;
        }
        if (item instanceof CartPartialFulfillment) {
            return R.layout.darkstores_partial_fulfillment_cart_section;
        }
        if (item instanceof CartSwimlane) {
            return getViewTypeForCartSwimlane((CartSwimlane) item);
        }
        if (item instanceof CartSectionHeader) {
            return R.layout.darkstores_item_cart_section_header;
        }
        throw new IllegalArgumentException("Unsupported item view type");
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        DisclaimerViewHolder disclaimerViewHolder;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Object item = getItem(i11);
        if (item instanceof CartProduct) {
            bindCartProduct((CartProduct) item, viewHolder);
        } else if (item instanceof CartDisclaimer) {
            if (viewHolder instanceof DisclaimerViewHolder) {
                disclaimerViewHolder = (DisclaimerViewHolder) viewHolder;
            } else {
                disclaimerViewHolder = null;
            }
            if (disclaimerViewHolder != null) {
                CartDisclaimer cartDisclaimer = (CartDisclaimer) item;
                String title = cartDisclaimer.getTitle();
                String str = "";
                if (title == null) {
                    title = str;
                }
                String description = cartDisclaimer.getDescription();
                if (description == null) {
                    description = str;
                }
                String actionText = cartDisclaimer.getActionText();
                if (actionText == null) {
                    actionText = str;
                }
                String url = cartDisclaimer.getUrl();
                if (url != null) {
                    str = url;
                }
                disclaimerViewHolder.bind(title, description, actionText, str);
            }
        } else if (item instanceof CartSwimlane) {
            bindSwimlane((CartSwimlane) item, viewHolder);
        } else if (item instanceof CartSpecialRequest) {
            ((CartSpecialRequestViewHolder) viewHolder).bind();
        } else if (item instanceof CartPartialFulfillment) {
            ((CartPartialFulfillmentViewHolder) viewHolder).bind((CartPartialFulfillment) item);
        } else if (item instanceof CartSectionHeader) {
            ((CartSectionHeaderViewHolder) viewHolder).bind((CartSectionHeader) item);
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        RecyclerView.ViewHolder viewHolder;
        boolean z11;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i11 == R.layout.darkstores_item_cart_section_header) {
            DarkstoresItemCartSectionHeaderBinding inflate = DarkstoresItemCartSectionHeaderBinding.inflate(from, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, parent, false)");
            viewHolder = new CartSectionHeaderViewHolder(this, inflate);
        } else if (i11 == R.layout.darkstores_item_product_cart_new_compact) {
            DarkstoresItemProductCartNewCompactBinding inflate2 = DarkstoresItemProductCartNewCompactBinding.inflate(from, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(layoutInflater, parent, false)");
            viewHolder = new CartItemViewHolderCompact(inflate2, this.quantityChangedListener, this.cartFragmentViewModel.showOosPredictionAlert(), this.onOosPredictionAlertShown);
        } else {
            viewHolder = null;
        }
        if (viewHolder != null) {
            return viewHolder;
        }
        View inflate3 = from.inflate(i11, viewGroup, false);
        if (i11 == R.layout.darkstores_item_product_cart_new) {
            Intrinsics.checkNotNullExpressionValue(inflate3, "view");
            CartListAdapter$quantityChangedListener$1 cartListAdapter$quantityChangedListener$1 = this.quantityChangedListener;
            if (viewGroup.getLayoutDirection() == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            return new CartItemViewHolder(inflate3, cartListAdapter$quantityChangedListener$1, z11, this.onProductClicked, this.onOosPredictionAlertShown, this.cartFragmentViewModel.showOosPredictionAlert());
        } else if (i11 == R.layout.darkstores_item_disclaimer_banner) {
            Intrinsics.checkNotNullExpressionValue(inflate3, "view");
            return new DisclaimerViewHolder(this, inflate3);
        } else if (i11 == R.layout.darkstores_compact_swimlane) {
            Intrinsics.checkNotNullExpressionValue(inflate3, "view");
            return new CompactSwimlaneViewHolder(this, inflate3);
        } else if (i11 == R.layout.darkstores_cart_special_request) {
            Intrinsics.checkNotNullExpressionValue(inflate3, "view");
            return new CartSpecialRequestViewHolder(this, inflate3);
        } else if (i11 == R.layout.darkstores_partial_fulfillment_cart_section) {
            Intrinsics.checkNotNullExpressionValue(inflate3, "view");
            return new CartPartialFulfillmentViewHolder(this, inflate3);
        } else {
            throw new IllegalArgumentException("Unsupported item view type");
        }
    }

    public void onViewRecycled(@NotNull RecyclerView.ViewHolder viewHolder) {
        CartItemViewHolder cartItemViewHolder;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        CartItemViewHolderCompact cartItemViewHolderCompact = null;
        if (viewHolder instanceof CartItemViewHolder) {
            cartItemViewHolder = (CartItemViewHolder) viewHolder;
        } else {
            cartItemViewHolder = null;
        }
        if (cartItemViewHolder != null) {
            cartItemViewHolder.clear();
        }
        if (viewHolder instanceof CartItemViewHolderCompact) {
            cartItemViewHolderCompact = (CartItemViewHolderCompact) viewHolder;
        }
        if (cartItemViewHolderCompact != null) {
            cartItemViewHolderCompact.clear();
        }
    }

    public final void setSwimlaneTrackingData(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "swimlaneTitle");
        this.swimlaneTrackingData = new SwimlaneTrackingData(str, Integer.valueOf(i11));
    }
}
