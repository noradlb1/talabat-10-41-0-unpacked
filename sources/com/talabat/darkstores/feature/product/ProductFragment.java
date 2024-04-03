package com.talabat.darkstores.feature.product;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.LayoutMode;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.bottomsheets.BottomSheet;
import com.bumptech.glide.load.Transformation;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.designsystem.ds_navigation_bar.behaviour.DSNavigationBarAnimationBehaviorImageRatio;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.base.BaseFragment;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.common.bindingAdapters.ResizeStrategy;
import com.talabat.darkstores.common.extensions.ContextExtensionsKt;
import com.talabat.darkstores.common.extensions.FloatExtensionsKt;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7;
import com.talabat.darkstores.common.lists.adapters.CartMapProductListAdapter;
import com.talabat.darkstores.common.view.ErrorView;
import com.talabat.darkstores.common.view.LoadingFailedView;
import com.talabat.darkstores.common.view.SwimlaneView;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.product.ProductFragmentDirections;
import com.talabat.darkstores.feature.product.models.ProductCampaign;
import com.talabat.darkstores.feature.product.models.ProductCampaignLabel;
import com.talabat.darkstores.feature.product.views.AddToCartButton;
import com.talabat.darkstores.feature.product.views.BottomProductExtendedInfoView;
import com.talabat.darkstores.feature.product.views.CampaignProgressView;
import com.talabat.darkstores.feature.product.views.CartIndicator;
import com.talabat.darkstores.feature.product.views.NavigationBarTrailingIcons;
import com.talabat.darkstores.feature.product.views.ProductExtendedInfoView;
import com.talabat.darkstores.feature.product.views.ProductTagsContainer;
import com.talabat.darkstores.feature.product.views.TopProductExtendedInfoView;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import com.talabat.feature.darkstorestooltip.domain.model.TooltipKey;
import com.talabat.feature.darkstorestooltip.presentation.ShowStrategy;
import com.talabat.feature.darkstorestooltip.presentation.TooltipData;
import com.talabat.feature.darkstorestooltip.presentation.TooltipView;
import com.talabat.wrapper.EventWrapper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jj.a;
import jj.b;
import jj.c;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020)H\u0002J\n\u0010*\u001a\u0004\u0018\u00010+H\u0002J\n\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020)H\u0002J\b\u00104\u001a\u00020)H\u0002J\b\u00105\u001a\u00020)H\u0002J\b\u00106\u001a\u00020)H\u0002J\u0010\u00107\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0002J\u000e\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020<J\u0010\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020)H\u0016J\b\u0010A\u001a\u00020)H\u0016J\b\u0010B\u001a\u00020)H\u0016J\u001a\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020+2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020)H\u0002J\u001a\u0010H\u001a\u00020)2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010>\u001a\u00020?H\u0007J\u0010\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010N\u001a\u00020)2\u0006\u0010>\u001a\u00020?H\u0002J\u0016\u0010O\u001a\u00020)2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020R0QH\u0002J\u0010\u0010S\u001a\u00020)2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010T\u001a\u00020)2\u0006\u0010L\u001a\u00020MH\u0002J\u0012\u0010U\u001a\u00020)2\b\u0010V\u001a\u0004\u0018\u00010WH\u0002J\b\u0010X\u001a\u00020)H\u0002J\b\u0010Y\u001a\u00020)H\u0002J\b\u0010Z\u001a\u00020)H\u0002J\u0010\u0010[\u001a\u00020)2\u0006\u0010\\\u001a\u00020\nH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020 XD¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001b\u0010#\u001a\u00020$8FX\u0002¢\u0006\f\n\u0004\b'\u0010\u001e\u001a\u0004\b%\u0010&¨\u0006^"}, d2 = {"Lcom/talabat/darkstores/feature/product/ProductFragment;", "Lcom/talabat/darkstores/common/base/BaseFragment;", "()V", "args", "Lcom/talabat/darkstores/feature/product/ProductFragmentArgs;", "getArgs", "()Lcom/talabat/darkstores/feature/product/ProductFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "contentViewId", "", "getContentViewId", "()I", "dsNavBarTrailingIcons", "Lcom/talabat/darkstores/feature/product/views/NavigationBarTrailingIcons;", "getDsNavBarTrailingIcons", "()Lcom/talabat/darkstores/feature/product/views/NavigationBarTrailingIcons;", "dsNavigationBar", "Lcom/designsystem/ds_navigation_bar/DSNavigationBar;", "eventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "getEventOriginType", "()Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "originalStatusBarColor", "Ljava/lang/Integer;", "productListAdapter", "Lcom/talabat/darkstores/common/lists/adapters/CartMapProductListAdapter;", "getProductListAdapter", "()Lcom/talabat/darkstores/common/lists/adapters/CartMapProductListAdapter;", "productListAdapter$delegate", "Lkotlin/Lazy;", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "Lcom/talabat/darkstores/feature/product/ProductFragmentViewModel;", "getViewModel", "()Lcom/talabat/darkstores/feature/product/ProductFragmentViewModel;", "viewModel$delegate", "changeStatusBarColor", "", "getCartIndicatorView", "Landroid/view/View;", "getErrorView", "Lcom/talabat/darkstores/common/view/ErrorView;", "isRtl", "", "navigate", "action", "Landroidx/navigation/NavDirections;", "observeData", "observeMoreData", "observeProductExtendedInfo", "observerAddToCartButton", "onCampaignInfoClicked", "campaign", "Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "onDataReceived", "data", "Lcom/talabat/darkstores/feature/product/ProductFragmentData;", "onProductClicked", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "onRetryClicked", "onStart", "onStop", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "resetStatusBarColor", "setAppliedCampaign", "label", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel;", "setBottomProductExtendedInfo", "productExtendedInfo", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo;", "setProductDetails", "setProductTags", "productTags", "", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$Tag;", "setProductsSwimlane", "setTopProductExtendedInfo", "setUpExtendedInfoViewScrollListener", "productExtendedInfoView", "Lcom/talabat/darkstores/feature/product/views/ProductExtendedInfoView;", "setupDesignSystemNavigationBar", "setupNavigationBar", "showBasketLifeTimeTooltip", "updateCartIndicator", "cartCount", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SCREEN_NAME = "Product Details Screen";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final NavArgsLazy args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(ProductFragmentArgs.class), new ProductFragment$special$$inlined$navArgs$1(this));
    private final int contentViewId = R.layout.darkstores_fragment_product;
    @Nullable
    private DSNavigationBar dsNavigationBar;
    @NotNull
    private final EventOriginType eventOriginType = EventOriginType.Details;
    @Nullable
    private Integer originalStatusBarColor;
    @NotNull
    private final Lazy productListAdapter$delegate;
    @NotNull
    private final String screenName = SCREEN_NAME;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/product/ProductFragment$Companion;", "", "()V", "SCREEN_NAME", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ProductFragment() {
        ProductFragment$special$$inlined$viewModel$1 productFragment$special$$inlined$viewModel$1 = new ProductFragment$special$$inlined$viewModel$1(this);
        ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4 viewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4 = new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4(this);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Lazy lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5(viewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4));
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProductFragmentViewModel.class), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6(lazy), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7((Function0) null, lazy), productFragment$special$$inlined$viewModel$1);
        this.productListAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ProductFragment$productListAdapter$2(this));
    }

    private final void changeStatusBarColor() {
        Integer num;
        Window window;
        FragmentActivity activity = getActivity();
        Window window2 = null;
        if (activity == null || (window = activity.getWindow()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(window.getStatusBarColor());
        }
        this.originalStatusBarColor = num;
        Context context = getContext();
        if (context != null) {
            int colorCompat = ContextExtensionsKt.getColorCompat(context, R.color.darkstoresProductTileOverlay);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                window2 = activity2.getWindow();
            }
            if (window2 != null) {
                window2.setStatusBarColor(colorCompat);
            }
        }
    }

    /* access modifiers changed from: private */
    public final ProductFragmentArgs getArgs() {
        return (ProductFragmentArgs) this.args$delegate.getValue();
    }

    private final View getCartIndicatorView() {
        if (!getViewModel().isDesignSystemEnabled()) {
            return (CartIndicator) _$_findCachedViewById(R.id.cartIndicator);
        }
        NavigationBarTrailingIcons dsNavBarTrailingIcons = getDsNavBarTrailingIcons();
        if (dsNavBarTrailingIcons != null) {
            return dsNavBarTrailingIcons.getBagIcon();
        }
        return null;
    }

    private final NavigationBarTrailingIcons getDsNavBarTrailingIcons() {
        DSNavigationBar dSNavigationBar = this.dsNavigationBar;
        KeyEvent.Callback trailingContainer = dSNavigationBar != null ? dSNavigationBar.getTrailingContainer() : null;
        if (trailingContainer instanceof NavigationBarTrailingIcons) {
            return (NavigationBarTrailingIcons) trailingContainer;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final CartMapProductListAdapter getProductListAdapter() {
        return (CartMapProductListAdapter) this.productListAdapter$delegate.getValue();
    }

    private final boolean isRtl() {
        return requireView().getLayoutDirection() == 1;
    }

    private final void navigate(NavDirections navDirections) {
        FragmentKt.findNavController(this).navigate(navDirections);
    }

    private final void observeData() {
        BaseFragment.observeNonNull$default(this, getCartFragmentViewModel().getCartMapLiveData(), (LifecycleOwner) null, new ProductFragment$observeData$1(this), 1, (Object) null);
        BaseFragment.observeNonNull$default(this, getCartFragmentViewModel().getCartFragmentLiveData(), (LifecycleOwner) null, new ProductFragment$observeData$2(this), 1, (Object) null);
        BaseFragment.observeHandleErrors$default(this, getViewModel().productFragmentLiveData(), (LifecycleOwner) null, new ProductFragment$observeData$3(this), 1, (Object) null);
        BaseFragment.observeNonNull$default(this, getViewModel().campaignProgressData(), (LifecycleOwner) null, new ProductFragment$observeData$4(this), 1, (Object) null);
        getViewModel().navigationActions().observe(getViewLifecycleOwner(), new a(this));
        observeMoreData();
    }

    /* access modifiers changed from: private */
    /* renamed from: observeData$lambda-6  reason: not valid java name */
    public static final void m10008observeData$lambda6(ProductFragment productFragment, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(productFragment, "this$0");
        NavDirections navDirections = (NavDirections) eventWrapper.getContentIfNotHandled();
        if (navDirections != null) {
            productFragment.navigate(navDirections);
        }
    }

    private final void observeMoreData() {
        observerAddToCartButton();
        BaseFragment.observeNonNull$default(this, ((CampaignProgressView) _$_findCachedViewById(R.id.campaignProgressView)).canAddFreeItemLiveData(), (LifecycleOwner) null, new ProductFragment$observeMoreData$1(this), 1, (Object) null);
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ((SwimlaneView) _$_findCachedViewById(R.id.suggestedProductsSwimlane))._$_findCachedViewById(R.id.btnViewAll);
        Intrinsics.checkNotNullExpressionValue(appCompatImageButton, "suggestedProductsSwimlane.btnViewAll");
        appCompatImageButton.setVisibility(4);
        BaseFragment.observeNonNull$default(this, getViewModel().swimlaneLabelLiveData(), (LifecycleOwner) null, new ProductFragment$observeMoreData$2(this), 1, (Object) null);
        BaseFragment.observeNonNull$default(this, getViewModel().getProductReadyLiveData(), (LifecycleOwner) null, new ProductFragment$observeMoreData$3(this), 1, (Object) null);
        observeProductExtendedInfo();
        BaseFragment.observeNonNull$default(this, getViewModel().getProductImagesZoomState(), (LifecycleOwner) null, new ProductFragment$observeMoreData$4(this), 1, (Object) null);
        BaseFragment.observeNonNull$default(this, getViewModel().getProductDescriptionExpandState(), (LifecycleOwner) null, new ProductFragment$observeMoreData$5(this), 1, (Object) null);
        BaseFragment.observeNonNull$default(this, getViewModel().showDiscountUsageLabelLiveData(), (LifecycleOwner) null, new ProductFragment$observeMoreData$6(this), 1, (Object) null);
        BaseFragment.observeNonNull$default(this, getViewModel().basketLifetimeTooltipLiveData(), (LifecycleOwner) null, new ProductFragment$observeMoreData$7(this), 1, (Object) null);
    }

    private final void observeProductExtendedInfo() {
        BaseFragment.observeNonNull$default(this, getViewModel().topProductExtendedInfo(), (LifecycleOwner) null, new ProductFragment$observeProductExtendedInfo$1(this), 1, (Object) null);
        BaseFragment.observeNonNull$default(this, getViewModel().bottomProductExtendedInfo(), (LifecycleOwner) null, new ProductFragment$observeProductExtendedInfo$2(this), 1, (Object) null);
    }

    private final void observerAddToCartButton() {
        BaseFragment.observeNonNull$default(this, ((AddToCartButton) _$_findCachedViewById(R.id.addToCartButton)).quantityLiveData(), (LifecycleOwner) null, new ProductFragment$observerAddToCartButton$1(this), 1, (Object) null);
    }

    private final void onCampaignInfoClicked(Campaign campaign) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        MaterialDialog materialDialog = new MaterialDialog(requireContext, new BottomSheet(LayoutMode.WRAP_CONTENT));
        MaterialDialog.cornerRadius$default(materialDialog, (Float) null, Integer.valueOf(R.dimen.bottom_sheet_corner_radius), 1, (Object) null);
        MaterialDialog.title$default(materialDialog, (Integer) null, campaign.getName(), 1, (Object) null);
        MaterialDialog.message$default(materialDialog, (Integer) null, campaign.getDescription(), (Function1) null, 5, (Object) null);
        materialDialog.show();
    }

    /* access modifiers changed from: private */
    public final void onProductClicked(Product product) {
        FragmentKt.findNavController(this).navigate(ProductFragmentDirections.Companion.actionToProductFragment$default(ProductFragmentDirections.Companion, product, false, (String) null, (String) null, (ProductClickTrackingAttribute) null, (String) null, (String) null, (String) null, 254, (Object) null));
    }

    private final void resetStatusBarColor() {
        Integer num = this.originalStatusBarColor;
        if (num != null) {
            int intValue = num.intValue();
            FragmentActivity activity = getActivity();
            Window window = activity != null ? activity.getWindow() : null;
            if (window != null) {
                window.setStatusBarColor(intValue);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void setBottomProductExtendedInfo(ProductExtendedInfo productExtendedInfo) {
        List<ProductExtendedInfo.Tag> tags = productExtendedInfo.getTags();
        if (tags == null) {
            tags = CollectionsKt__CollectionsKt.emptyList();
        }
        setProductTags(tags);
        int i11 = R.id.bottomExtendedInfo;
        setUpExtendedInfoViewScrollListener((ProductExtendedInfoView) ((BottomProductExtendedInfoView) _$_findCachedViewById(i11)).findViewById(R.id.productExtendedInfo));
        ((BottomProductExtendedInfoView) _$_findCachedViewById(i11)).setProductExtendedInfo(productExtendedInfo, getViewModel().getSelectedLanguage());
    }

    /* access modifiers changed from: private */
    public final void setProductDetails(Product product) {
        boolean z11;
        String str;
        int i11;
        boolean z12;
        if (product.getPreviousPrice() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        ((TextView) _$_findCachedViewById(R.id.tvProductName)).setText(product.getName());
        ProductFragmentViewModel viewModel = getViewModel();
        float price = product.getPrice();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ((TextView) _$_findCachedViewById(R.id.tvPrice)).setText(viewModel.getFormattedPrice(price, requireContext, z11));
        int i12 = R.id.tvPreviousPrice;
        TextView textView = (TextView) _$_findCachedViewById(i12);
        Float previousPrice = product.getPreviousPrice();
        String str2 = null;
        if (previousPrice != null) {
            str = FloatExtensionsKt.formatCurrency(previousPrice.floatValue());
        } else {
            str = null;
        }
        textView.setText(str);
        TextView textView2 = (TextView) _$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(textView2, "tvPreviousPrice");
        int i13 = 8;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        textView2.setVisibility(i11);
        TextView textView3 = (TextView) _$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(textView3, "tvPreviousPrice");
        BindingAdaptersKt.setStrike(textView3, true);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.imgProductPicture);
        Intrinsics.checkNotNullExpressionValue(imageView, "imgProductPicture");
        BindingAdaptersKt.loadImageWithGlide$default(imageView, product.getImageUrl(), Integer.valueOf(R.drawable.product_tile_placeholder), (ResizeStrategy) null, (Transformation) null, (Integer) null, 28, (Object) null);
        getViewModel().handleProductImages(product);
        ProductFragmentViewModel viewModel2 = getViewModel();
        String description = product.getDescription();
        if (description != null) {
            str2 = StringsKt__StringsKt.trimStart((CharSequence) description).toString();
        }
        viewModel2.handleProductDescription(str2);
        int i14 = R.id.product_age_restriction;
        TextView textView4 = (TextView) _$_findCachedViewById(i14);
        Intrinsics.checkNotNullExpressionValue(textView4, "product_age_restriction");
        if (product.getAgeLimit() != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            i13 = 0;
        }
        textView4.setVisibility(i13);
        ((TextView) _$_findCachedViewById(i14)).setText(getResources().getString(com.talabat.localization.R.string.ds_age_restriction, new Object[]{String.valueOf(product.getAgeLimit())}));
        getViewModel().onProductExtendedInfoReceived(product.getExtendedInfo(), product.getDescription());
    }

    private final void setProductTags(List<ProductExtendedInfo.Tag> list) {
        if (!list.isEmpty()) {
            int i11 = R.id.tagsContainerExt;
            ((ProductTagsContainer) _$_findCachedViewById(i11)).setVisibility(0);
            ((ProductTagsContainer) _$_findCachedViewById(i11)).setProductTags(list);
        }
    }

    private final void setProductsSwimlane(ProductFragmentData productFragmentData) {
        boolean z11;
        SwimlaneView swimlaneView = (SwimlaneView) _$_findCachedViewById(R.id.suggestedProductsSwimlane);
        if (productFragmentData.getSwimlaneName().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            swimlaneView.setTitle(productFragmentData.getSwimlaneName());
        }
        getProductListAdapter().setOnItemClickListener(new ProductFragment$setProductsSwimlane$1$1(this));
        getProductListAdapter().setSwimlaneLength(productFragmentData.getSwimlanes().size());
        getProductListAdapter().setSwimlaneTrackingInfo(productFragmentData.getSwimlaneRequestId(), productFragmentData.getSwimlaneStrategy());
        ((RecyclerView) swimlaneView._$_findCachedViewById(R.id.recyclerView)).setAdapter(getProductListAdapter());
        getProductListAdapter().submitList(productFragmentData.getSwimlanes());
        Intrinsics.checkNotNullExpressionValue(swimlaneView, "");
        swimlaneView.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void setTopProductExtendedInfo(ProductExtendedInfo productExtendedInfo) {
        List<ProductExtendedInfo.Tag> tags = productExtendedInfo.getTags();
        if (tags == null) {
            tags = CollectionsKt__CollectionsKt.emptyList();
        }
        setProductTags(tags);
        int i11 = R.id.topExtendedInfo;
        setUpExtendedInfoViewScrollListener((ProductExtendedInfoView) ((TopProductExtendedInfoView) _$_findCachedViewById(i11)).findViewById(R.id.productExtendedInfo));
        if (!productExtendedInfo.isInValidProductExtendedInfo()) {
            View _$_findCachedViewById = _$_findCachedViewById(R.id.topRoundedView);
            Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "topRoundedView");
            _$_findCachedViewById.setVisibility(8);
            View _$_findCachedViewById2 = _$_findCachedViewById(R.id.topNormalView);
            Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById2, "topNormalView");
            _$_findCachedViewById2.setVisibility(0);
        }
        ((TopProductExtendedInfoView) _$_findCachedViewById(i11)).setProductExtendedInfo(productExtendedInfo, getViewModel().getSelectedLanguage());
    }

    private final void setUpExtendedInfoViewScrollListener(ProductExtendedInfoView productExtendedInfoView) {
        if (productExtendedInfoView != null) {
            _$_findCachedViewById(R.id.nestedProductScrollView).setOnScrollChangeListener(productExtendedInfoView);
        }
    }

    private final void setupDesignSystemNavigationBar() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        DSNavigationBar dSNavigationBar = new DSNavigationBar(requireContext, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        dSNavigationBar.setLeadingIconButton(new DSIconButtonModel(com.designsystem.marshmallow.R.drawable.ds_close, new ProductFragment$setupDesignSystemNavigationBar$1$1(this)));
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        NavigationBarTrailingIcons navigationBarTrailingIcons = new NavigationBarTrailingIcons(requireContext2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        navigationBarTrailingIcons.setOnCartClickListener(new ProductFragment$setupDesignSystemNavigationBar$1$2$1(getViewModel()));
        dSNavigationBar.setTrailingContainer(navigationBarTrailingIcons);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.imgProductPicture);
        Intrinsics.checkNotNullExpressionValue(imageView, "imgProductPicture");
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.scrollContainer);
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "scrollContainer");
        dSNavigationBar.setAnimationBehavior(new DSNavigationBarAnimationBehaviorImageRatio(imageView, constraintLayout));
        this.dsNavigationBar = dSNavigationBar;
        ((ConstraintLayout) _$_findCachedViewById(R.id.container)).addView(dSNavigationBar);
        this.dsNavigationBar = dSNavigationBar;
    }

    private final void setupNavigationBar() {
        int i11 = R.id.btnClose;
        ((ImageView) _$_findCachedViewById(i11)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(i11)).setOnClickListener(new b(this));
        int i12 = R.id.cartIndicator;
        ((CartIndicator) _$_findCachedViewById(i12)).setVisibility(0);
        ((CartIndicator) _$_findCachedViewById(i12)).setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupNavigationBar$lambda-4  reason: not valid java name */
    public static final void m10009setupNavigationBar$lambda4(ProductFragment productFragment, View view) {
        Intrinsics.checkNotNullParameter(productFragment, "this$0");
        FragmentKt.findNavController(productFragment).navigateUp();
    }

    /* access modifiers changed from: private */
    /* renamed from: setupNavigationBar$lambda-5  reason: not valid java name */
    public static final void m10010setupNavigationBar$lambda5(ProductFragment productFragment, View view) {
        Intrinsics.checkNotNullParameter(productFragment, "this$0");
        productFragment.getViewModel().onCartIndicatorClick();
    }

    /* access modifiers changed from: private */
    public final void showBasketLifeTimeTooltip() {
        View cartIndicatorView = getCartIndicatorView();
        if (cartIndicatorView != null) {
            TooltipKey tooltipKey = TooltipKey.BASKET_LIFETIME;
            String string = getString(com.talabat.localization.R.string.basket_lifetime_tooltip);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo….basket_lifetime_tooltip)");
            ((TooltipView) _$_findCachedViewById(R.id.basketLifetimeTooltipView)).initialize(new TooltipData(tooltipKey, cartIndicatorView, string, false, 0, ShowStrategy.Once, 24, (DefaultConstructorMarker) null));
        }
    }

    /* access modifiers changed from: private */
    public final void updateCartIndicator(int i11) {
        if (getViewModel().isDesignSystemEnabled()) {
            NavigationBarTrailingIcons dsNavBarTrailingIcons = getDsNavBarTrailingIcons();
            if (dsNavBarTrailingIcons != null) {
                dsNavBarTrailingIcons.setQuantity(i11);
                return;
            }
            return;
        }
        ((CartIndicator) _$_findCachedViewById(R.id.cartIndicator)).setQuantity(i11);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public int getContentViewId() {
        return this.contentViewId;
    }

    @Nullable
    public ErrorView getErrorView() {
        return (LoadingFailedView) _$_findCachedViewById(R.id.loadingFailedView);
    }

    @NotNull
    public EventOriginType getEventOriginType() {
        return this.eventOriginType;
    }

    @NotNull
    public String getScreenName() {
        return this.screenName;
    }

    @NotNull
    public final ProductFragmentViewModel getViewModel() {
        return (ProductFragmentViewModel) this.viewModel$delegate.getValue();
    }

    public final void onDataReceived(@NotNull ProductFragmentData productFragmentData) {
        Integer usageLimit;
        boolean z11;
        Intrinsics.checkNotNullParameter(productFragmentData, "data");
        ProductCampaign campaign = productFragmentData.getCampaign();
        ProductCampaignLabel productCampaignLabel = null;
        if (!(campaign instanceof ProductCampaign.Discount)) {
            campaign = null;
        }
        if (!(campaign == null || (usageLimit = campaign.getUsageLimit()) == null)) {
            if (usageLimit.intValue() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                usageLimit = null;
            }
            if (usageLimit != null) {
                ((TextView) _$_findCachedViewById(R.id.strikeThroughCampaignUsageLimit)).setText(getString(com.talabat.localization.R.string.usage_limit, Integer.valueOf(usageLimit.intValue())));
            }
        }
        if (productFragmentData.getCampaign() instanceof ProductCampaign.Free) {
            ((CampaignProgressView) _$_findCachedViewById(R.id.campaignProgressView)).setup((ProductCampaign.Free) productFragmentData.getCampaign());
        }
        ProductCampaign campaign2 = productFragmentData.getCampaign();
        if (campaign2 != null) {
            String id2 = getArgs().getProduct().getId();
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "this.resources");
            productCampaignLabel = campaign2.getLabel(id2, resources, isRtl());
        }
        setAppliedCampaign(productCampaignLabel, productFragmentData.getProduct());
        if (!productFragmentData.getSwimlanes().isEmpty()) {
            setProductsSwimlane(productFragmentData);
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onRetryClicked() {
        getViewModel().onRetry();
    }

    public void onStart() {
        super.onStart();
        changeStatusBarColor();
    }

    public void onStop() {
        resetStatusBarColor();
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (getViewModel().isDesignSystemEnabled()) {
            setupDesignSystemNavigationBar();
        } else {
            setupNavigationBar();
        }
        observeData();
    }

    @VisibleForTesting
    public final void setAppliedCampaign(@Nullable ProductCampaignLabel productCampaignLabel, @NotNull Product product) {
        boolean z11;
        Intrinsics.checkNotNullParameter(product, "product");
        if (productCampaignLabel != null) {
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            String asString = productCampaignLabel.asString(resources);
            if (asString != null) {
                ((TextView) _$_findCachedViewById(R.id.campaignLabel)).setText(asString);
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.campaignContainer);
                Intrinsics.checkNotNullExpressionValue(linearLayout, "campaignContainer");
                int i11 = 0;
                if (product.getAgeLimit() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    i11 = 8;
                }
                linearLayout.setVisibility(i11);
            }
        }
    }
}
