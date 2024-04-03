package com.talabat.darkstores.feature.home;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.LayoutMode;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.bottomsheets.BottomSheet;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.base.BaseFragment;
import com.talabat.darkstores.common.customScrollingViews.CustomVerticalNestedScrollView;
import com.talabat.darkstores.common.extensions.SearchViewExtensionsKt;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$1;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$2;
import com.talabat.darkstores.common.lists.adapters.CartMapProductListAdapter;
import com.talabat.darkstores.common.lists.adapters.compact.CompactSwimlaneAdapter;
import com.talabat.darkstores.common.view.BlockableAppBarLayout;
import com.talabat.darkstores.common.view.GridSwimlaneView;
import com.talabat.darkstores.common.view.SwimlaneView;
import com.talabat.darkstores.data.darkstores.model.BannersResponse;
import com.talabat.darkstores.data.dynamicPricing.remote.DeliveryDetails;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.darkstores.data.tracking.impression.TrackingData;
import com.talabat.darkstores.di.ApplicationComponent;
import com.talabat.darkstores.di.InjectorKt;
import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.darkstores.feature.home.HomeFragmentDirections;
import com.talabat.darkstores.feature.home.HomeRecyclerViewItem;
import com.talabat.darkstores.feature.home.banner.BannerView;
import com.talabat.darkstores.feature.home.categories.CategoriesMissionView;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.home.tpro.TProView;
import com.talabat.darkstores.feature.main.viewmodel.DeliveryTierBottomSheetViewStateViewModel;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.darkstores.feature.tracking.data.DarkstoresTrackingConstantsKt;
import com.talabat.darkstores.model.Banner;
import com.talabat.darkstores.model.Category;
import com.talabat.darkstores.model.CompactSwimlaneLayoutType;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.darkstores.model.SwimlaneTracking;
import com.talabat.feature.customervouchersswimlane.presentation.adapter.CustomerVouchersSwimLaneAdapter;
import com.talabat.feature.customervouchersswimlane.presentation.adapter.VoucherHorizontalSpaceDecoration;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMission;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import com.talabat.feature.mission.control.presentation.LifeStyleMissionV2View;
import com.talabat.feature.nfvinvendorsearch.presentation.activity.QCommerceFlutterActivityKt;
import com.talabat.feature.nfvinvendorsearch.presentation.model.ProductInfo;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionView;
import com.talabat.features.swimlanevoucherslist.domain.model.CustomerVoucher;
import com.talabat.features.swimlanevoucherslist.domain.model.VoucherType;
import com.talabat.talabatnavigation.tpro.TproNavigatorActionsKt;
import com.talabat.wrapper.EventWrapper;
import datamodels.Restaurant;
import dj.c;
import dj.d;
import dj.e;
import dj.f;
import dj.g;
import dj.h;
import dj.i;
import dj.j;
import dj.k;
import dj.l;
import dj.m;
import dj.n;
import dj.o;
import dj.p;
import dj.q;
import dj.r;
import dj.s;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00012\u00020\u0001:\u0004\u0001\u0001B\t¢\u0006\u0006\b\u0001\u0010\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u001e\u0010 \u001a\u00020\n2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u0002H\u0002J\u0016\u0010$\u001a\u00020\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u001bH\u0002J\"\u0010*\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020%2\u0006\u0010)\u001a\u00020(H\u0002J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\nH\u0002J\u0016\u0010.\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020-0\u0007H\u0002J\b\u0010/\u001a\u00020\u0002H\u0002J2\u00104\u001a\u00020\u00022\f\u00101\u001a\b\u0012\u0004\u0012\u0002000\u001b2\f\u00102\u001a\b\u0012\u0004\u0012\u0002000\u001b2\f\u00103\u001a\b\u0012\u0004\u0012\u0002000\u001bH\u0002J$\u00108\u001a\u00020\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u0002050\u001b2\f\u00107\u001a\b\u0012\u0004\u0012\u0002050\u001bH\u0002J\u0012\u0010;\u001a\u00020\u00022\b\u0010:\u001a\u0004\u0018\u000109H\u0002J\u0016\u0010=\u001a\u00020<2\f\u00107\u001a\b\u0012\u0004\u0012\u0002050\u001bH\u0002J\"\u0010C\u001a\u00020\u00022\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u0002002\b\u0010B\u001a\u0004\u0018\u00010AH\u0002J\u0010\u0010D\u001a\u00020\u00022\u0006\u0010@\u001a\u000200H\u0002J\b\u0010E\u001a\u00020\u0002H\u0002J\b\u0010F\u001a\u00020\u0002H\u0002J\u0018\u0010J\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020HH\u0002J\u0018\u0010K\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020HH\u0002J \u0010M\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010L\u001a\u00020%2\u0006\u0010I\u001a\u00020HH\u0002J\u0016\u0010N\u001a\u00020\u00022\f\u00107\u001a\b\u0012\u0004\u0012\u0002050\u001bH\u0002J\u0010\u0010O\u001a\u00020\u00022\u0006\u0010@\u001a\u000200H\u0002J$\u0010U\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020P2\b\u0010R\u001a\u0004\u0018\u00010%2\b\u0010T\u001a\u0004\u0018\u00010SH\u0002J \u0010V\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010L\u001a\u00020%2\u0006\u0010I\u001a\u00020HH\u0002J\u0010\u0010Y\u001a\u00020\u00022\u0006\u0010X\u001a\u00020WH\u0002J\b\u0010Z\u001a\u00020\u0002H\u0002J\u0012\u0010]\u001a\u00020\u00022\b\u0010\\\u001a\u0004\u0018\u00010[H\u0016J\u001a\u0010_\u001a\u00020\u00022\u0006\u0010^\u001a\u00020\u00132\b\u0010\\\u001a\u0004\u0018\u00010[H\u0016J\u0006\u0010`\u001a\u00020\u0002J\b\u0010a\u001a\u00020\u0002H\u0016J\b\u0010b\u001a\u00020\u0002H\u0014J\b\u0010c\u001a\u00020\u0002H\u0016J\b\u0010d\u001a\u00020\u0002H\u0016J\u0010\u0010g\u001a\u00020\u00022\u0006\u0010f\u001a\u00020eH\u0016J\b\u0010h\u001a\u00020\u0002H\u0016R\u001a\u0010i\u001a\u00020H8\u0016X\u0004¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\u001a\u0010m\u001a\u00020%8\u0016XD¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR\u001a\u0010r\u001a\u00020q8\u0016X\u0004¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR\u001b\u0010{\u001a\u00020v8BX\u0002¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010zR\u001c\u0010\u0001\u001a\u00020|8BX\u0002¢\u0006\f\n\u0004\b}\u0010x\u001a\u0004\b~\u0010R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u0014\u0012\u000f\u0012\r \u0001*\u0005\u0018\u00010\u00010\u00010\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u0014\u0012\u000f\u0012\r \u0001*\u0005\u0018\u00010\u00010\u00010\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeFragment;", "Lcom/talabat/darkstores/common/base/BaseFragment;", "", "setupTalabatAiButton", "setUpSearchView", "maybeApplyVLPUplift", "setUpListeners", "Lcom/talabat/darkstores/common/Result;", "result", "onCartReady", "", "showSubscribeButton", "showTproSubscriptionHeader", "hideTproSubscriptionHeader", "Landroid/view/MenuItem;", "item", "onMenuItemClick", "showSearchMenuIcon", "shouldShowSearchMenuIcon", "Landroid/view/View;", "getNavigationIconView", "getSearchIconView", "observeData", "setupMissions", "Lcom/talabat/darkstores/data/darkstores/model/BannersResponse;", "bannersResponse", "updateHomeBannerItems", "", "Lcom/talabat/darkstores/model/Banner;", "banners", "Lcom/talabat/darkstores/feature/home/HomeFragment$BannerType;", "bannerType", "getBannerItemViewHolder", "observeNavigationActions", "Lcom/talabat/features/swimlanevoucherslist/domain/model/CustomerVoucher;", "customerVouchers", "setVouchersSwimLane", "", "sku", "voucherId", "Lcom/talabat/features/swimlanevoucherslist/domain/model/VoucherType;", "voucherType", "loadVoucherDetails", "isError", "handleErrorView", "Lcom/talabat/darkstores/feature/home/HomeFragmentData;", "onSwimlanesResultsReceived", "setupRewardsMissionWidget", "Lcom/talabat/darkstores/model/Swimlane;", "swimlanes", "topSwimlanes", "highlightedSwimlanes", "setupSwimlanes", "Lcom/talabat/darkstores/model/Category;", "topTwoCategories", "categories", "setupCategories", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;", "lifestyleMission", "setupLifestyleMission", "Lcom/talabat/darkstores/feature/home/CategoriesListAdapter;", "createCategoriesAdapter", "Landroid/widget/LinearLayout;", "compactSwimlaneContainer", "swimlane", "Lcom/talabat/darkstores/model/CompactSwimlaneLayoutType;", "compactSwimlaneViewType", "addCompactSwimlaneView", "addSwimlaneView", "onSearchFieldClicked", "onSubscribeClicked", "banner", "", "position", "onHeroBannerClicked", "onSmallBannerClicked", "type", "onBannerClicked", "onCategoriesViewAllClicked", "onSwimlaneClicked", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "product", "swimlaneRequestId", "Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "productClickTrackingAttribute", "onProductClicked", "onBannerShown", "Landroidx/navigation/NavDirections;", "direction", "navigateOnlyIfCurrentScreenIsHomeFragment", "submitHomeItemList", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "view", "onViewCreated", "setupRecyclerView", "onDestroyView", "i0", "onRetryClicked", "onResume", "", "error", "showError", "hideError", "contentViewId", "I", "getContentViewId", "()I", "screenName", "Ljava/lang/String;", "getScreenName", "()Ljava/lang/String;", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "eventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "getEventOriginType", "()Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "Lcom/talabat/darkstores/feature/home/HomeFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/talabat/darkstores/feature/home/HomeFragmentViewModel;", "viewModel", "Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierBottomSheetViewStateViewModel;", "bottomSheetViewStateViewModel$delegate", "getBottomSheetViewStateViewModel", "()Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierBottomSheetViewStateViewModel;", "bottomSheetViewStateViewModel", "Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;", "productImpressionTracker", "Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;", "getProductImpressionTracker", "()Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;", "setProductImpressionTracker", "(Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;)V", "", "searchBarLocation", "[I", "toolbarLocation", "", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "homeItemList", "Ljava/util/List;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "qCommerceVoucherBottomSheetWithVoucherPLPLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "qCommerceVoucherBottomSheetWithPDPLauncher", "<init>", "()V", "Companion", "BannerType", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class HomeFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SCREEN_NAME = "vendor_landing";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final Lazy bottomSheetViewStateViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DeliveryTierBottomSheetViewStateViewModel.class), new ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$1(this), new ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$2((Function0) null, this), new HomeFragment$special$$inlined$activityViewModel$2());
    private final int contentViewId = R.layout.darkstores_fragment_home;
    @NotNull
    private final EventOriginType eventOriginType = EventOriginType.Swimlane;
    /* access modifiers changed from: private */
    @NotNull
    public final List<HomeRecyclerViewItem> homeItemList = new ArrayList();
    public ProductImpressionTracker productImpressionTracker;
    @NotNull
    private final ActivityResultLauncher<Intent> qCommerceVoucherBottomSheetWithPDPLauncher;
    @NotNull
    private final ActivityResultLauncher<Intent> qCommerceVoucherBottomSheetWithVoucherPLPLauncher;
    @NotNull
    private final String screenName = SCREEN_NAME;
    @NotNull
    private int[] searchBarLocation = new int[2];
    @NotNull
    private int[] toolbarLocation = new int[2];
    @NotNull
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(HomeFragmentViewModel.class), new ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$1(this), new ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$2((Function0) null, this), new HomeFragment$special$$inlined$activityViewModel$1());

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeFragment$BannerType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "HERO", "SMALL", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum BannerType {
        HERO("hero_banner"),
        SMALL("small_banner");
        
        @NotNull
        private final String type;

        private BannerType(String str) {
            this.type = str;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeFragment$Companion;", "", "()V", "SCREEN_NAME", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BannerType.values().length];
            iArr[BannerType.HERO.ordinal()] = 1;
            iArr[BannerType.SMALL.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public HomeFragment() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new i(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…        }\n        }\n    }");
        this.qCommerceVoucherBottomSheetWithVoucherPLPLauncher = registerForActivityResult;
        ActivityResultLauncher<Intent> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new j(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResul…        }\n        }\n    }");
        this.qCommerceVoucherBottomSheetWithPDPLauncher = registerForActivityResult2;
    }

    private final void addCompactSwimlaneView(LinearLayout linearLayout, Swimlane swimlane, CompactSwimlaneLayoutType compactSwimlaneLayoutType) {
        String str;
        String str2;
        String str3;
        String trackingId;
        LiveData<Map<String, Integer>> cartMapLiveData = getCartFragmentViewModel().getCartMapLiveData();
        CartFragmentViewModel cartFragmentViewModel = getCartFragmentViewModel();
        TrackingCategoryId.CustomSwimlane customSwimlane = new TrackingCategoryId.CustomSwimlane(swimlane.getHeadline());
        SwimlaneTracking tracking2 = swimlane.getTracking();
        if (tracking2 == null || (trackingId = tracking2.getTrackingId()) == null) {
            str = "";
        } else {
            str = trackingId;
        }
        String requestId = swimlane.getRequestId();
        if (requestId == null) {
            str2 = "";
        } else {
            str2 = requestId;
        }
        if (compactSwimlaneLayoutType == null) {
            compactSwimlaneLayoutType = CompactSwimlaneLayoutType.COMPACT_WITH_TEXT;
        }
        CompactSwimlaneAdapter compactSwimlaneAdapter = new CompactSwimlaneAdapter(cartMapLiveData, cartFragmentViewModel, customSwimlane, str, str2, compactSwimlaneLayoutType, true);
        compactSwimlaneAdapter.submitList(swimlane.getProducts());
        SwimlaneTracking tracking3 = swimlane.getTracking();
        if (tracking3 != null) {
            str3 = tracking3.getTrackingId();
        } else {
            str3 = null;
        }
        compactSwimlaneAdapter.setOnItemClickListener(new HomeFragment$addCompactSwimlaneView$1(this, swimlane, new ProductClickTrackingAttribute("storefront:swimlane", str3, swimlane.getHeadline(), swimlane.getProducts().size())));
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        SwimlaneView swimlaneView = new SwimlaneView(requireContext, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        swimlaneView.setTitle(swimlane.getHeadline());
        ((RecyclerView) swimlaneView._$_findCachedViewById(R.id.recyclerView)).setAdapter(compactSwimlaneAdapter);
        ((AppCompatImageButton) swimlaneView._$_findCachedViewById(R.id.btnViewAll)).setOnClickListener(new k(this, swimlane));
        linearLayout.addView(swimlaneView, linearLayout.getChildCount() - 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: addCompactSwimlaneView$lambda-44$lambda-43  reason: not valid java name */
    public static final void m9945addCompactSwimlaneView$lambda44$lambda43(HomeFragment homeFragment, Swimlane swimlane, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        Intrinsics.checkNotNullParameter(swimlane, "$swimlane");
        homeFragment.onSwimlaneClicked(swimlane);
    }

    private final void addSwimlaneView(Swimlane swimlane) {
        String str;
        String str2 = null;
        CartMapProductListAdapter cartMapProductListAdapter = new CartMapProductListAdapter(getCartFragmentViewModel(), false, 2, (DefaultConstructorMarker) null);
        cartMapProductListAdapter.setTrackingCategoryId(new TrackingCategoryId.CustomSwimlane(swimlane.getHeadline()));
        String requestId = swimlane.getRequestId();
        SwimlaneTracking tracking2 = swimlane.getTracking();
        if (tracking2 != null) {
            str = tracking2.getTrackingId();
        } else {
            str = null;
        }
        cartMapProductListAdapter.setSwimlaneTrackingInfo(requestId, str);
        cartMapProductListAdapter.submitList(swimlane.getProducts());
        SwimlaneTracking tracking3 = swimlane.getTracking();
        if (tracking3 != null) {
            str2 = tracking3.getTrackingId();
        }
        cartMapProductListAdapter.setOnItemClickListener(new HomeFragment$addSwimlaneView$1(this, swimlane, new ProductClickTrackingAttribute("storefront:swimlane", str2, swimlane.getHeadline(), swimlane.getProducts().size())));
        getCartFragmentViewModel().getCartMapLiveData().observe(getViewLifecycleOwner(), new l(cartMapProductListAdapter));
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        SwimlaneView swimlaneView = new SwimlaneView(requireContext, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        swimlaneView.setTitle(swimlane.getHeadline());
        ((RecyclerView) swimlaneView._$_findCachedViewById(R.id.recyclerView)).setAdapter(cartMapProductListAdapter);
        ((AppCompatImageButton) swimlaneView._$_findCachedViewById(R.id.btnViewAll)).setOnClickListener(new m(this, swimlane));
        ((LinearLayout) _$_findCachedViewById(R.id.swimlanesContainer)).addView(swimlaneView);
    }

    /* access modifiers changed from: private */
    /* renamed from: addSwimlaneView$lambda-45  reason: not valid java name */
    public static final void m9946addSwimlaneView$lambda45(CartMapProductListAdapter cartMapProductListAdapter, Map map) {
        Intrinsics.checkNotNullParameter(cartMapProductListAdapter, "$adapter");
        Intrinsics.checkNotNullExpressionValue(map, "it");
        cartMapProductListAdapter.setCartCountMap(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: addSwimlaneView$lambda-47$lambda-46  reason: not valid java name */
    public static final void m9947addSwimlaneView$lambda47$lambda46(HomeFragment homeFragment, Swimlane swimlane, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        Intrinsics.checkNotNullParameter(swimlane, "$swimlane");
        homeFragment.onSwimlaneClicked(swimlane);
    }

    private final CategoriesListAdapter createCategoriesAdapter(List<Category> list) {
        CategoriesListAdapter categoriesListAdapter = new CategoriesListAdapter(new HomeFragment$createCategoriesAdapter$1(this), new HomeFragment$createCategoriesAdapter$2(this, list), true, getCartFragmentViewModel().getCategoriesRowsCount());
        categoriesListAdapter.submitCategories(list);
        return categoriesListAdapter;
    }

    private final boolean getBannerItemViewHolder(List<Banner> list, BannerType bannerType) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[bannerType.ordinal()];
        if (i11 == 1) {
            return this.homeItemList.add(new HomeRecyclerViewItem.HeroBannerItem(new BannerItemViewHolderData(list, new HomeFragment$getBannerItemViewHolder$1(this), 11, new HomeFragment$getBannerItemViewHolder$2(this), BannerType.HERO.getType())));
        } else if (i11 == 2) {
            return this.homeItemList.add(new HomeRecyclerViewItem.SmallBannerItem(new BannerItemViewHolderData(list, new HomeFragment$getBannerItemViewHolder$3(this), 13, new HomeFragment$getBannerItemViewHolder$4(this), BannerType.SMALL.getType())));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final DeliveryTierBottomSheetViewStateViewModel getBottomSheetViewStateViewModel() {
        return (DeliveryTierBottomSheetViewStateViewModel) this.bottomSheetViewStateViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final View getNavigationIconView() {
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        int childCount = toolbar.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = toolbar.getChildAt(i11);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            if (childAt instanceof AppCompatImageButton) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final View getSearchIconView() {
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        int childCount = toolbar.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = toolbar.getChildAt(i11);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            if (childAt instanceof ActionMenuView) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final HomeFragmentViewModel getViewModel() {
        return (HomeFragmentViewModel) this.viewModel$delegate.getValue();
    }

    private final void handleErrorView(boolean z11) {
        int i11;
        int i12 = R.id.appBar;
        BlockableAppBarLayout blockableAppBarLayout = (BlockableAppBarLayout) _$_findCachedViewById(i12);
        if (blockableAppBarLayout != null) {
            blockableAppBarLayout.setExpanded(!z11);
        }
        BlockableAppBarLayout blockableAppBarLayout2 = (BlockableAppBarLayout) _$_findCachedViewById(i12);
        if (blockableAppBarLayout2 != null) {
            blockableAppBarLayout2.setScrollingEnabled(!z11);
        }
        View _$_findCachedViewById = _$_findCachedViewById(R.id.content);
        if (_$_findCachedViewById != null) {
            if (!z11) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            _$_findCachedViewById.setVisibility(i11);
        }
    }

    /* access modifiers changed from: private */
    public final void hideTproSubscriptionHeader() {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.subscription_header);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "subscription_header");
        _$_findCachedViewById.setVisibility(8);
        TProView tProView = (TProView) _$_findCachedViewById(R.id.subscription_header_top);
        Intrinsics.checkNotNullExpressionValue(tProView, "subscription_header_top");
        tProView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void loadVoucherDetails(String str, String str2, VoucherType voucherType) {
        ActivityResultLauncher<Intent> activityResultLauncher;
        if (voucherType == VoucherType.ItemVoucher) {
            activityResultLauncher = this.qCommerceVoucherBottomSheetWithPDPLauncher;
        } else {
            activityResultLauncher = this.qCommerceVoucherBottomSheetWithVoucherPLPLauncher;
        }
        getViewModel().handleVoucherDetailsNavigation(str, str2, new HomeFragment$loadVoucherDetails$1(activityResultLauncher, this), new HomeFragment$loadVoucherDetails$2(this));
    }

    private final void maybeApplyVLPUplift() {
        int i11;
        int i12;
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.search_bottom_view);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "search_bottom_view");
        if (getViewModel().canShowTopHeaderChanges()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        linearLayout.setVisibility(i11);
        ViewGroup.LayoutParams layoutParams = ((ConstraintLayout) _$_findCachedViewById(R.id.search_view_layout)).getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (getViewModel().canShowTopHeaderChanges()) {
                i12 = com.designsystem.marshmallow.R.dimen.ds_xxxs;
            } else {
                i12 = com.designsystem.marshmallow.R.dimen.ds_s;
            }
            layoutParams2.bottomMargin = getResources().getDimensionPixelOffset(i12);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    private final void navigateOnlyIfCurrentScreenIsHomeFragment(NavDirections navDirections) {
        NavDestination currentDestination = FragmentKt.findNavController(this).getCurrentDestination();
        boolean z11 = false;
        if (currentDestination != null && currentDestination.getId() == R.id.homeFragment) {
            z11 = true;
        }
        if (z11) {
            FragmentKt.findNavController(this).navigate(navDirections);
        }
    }

    private final void observeData() {
        setupMissions();
        BaseFragment.observeNonNull$default(this, getViewModel().getBannersListLiveData(), (LifecycleOwner) null, new HomeFragment$observeData$1(this), 1, (Object) null);
        BaseFragment.observeHandleErrors$default(this, getViewModel().getSwimlanesLiveData(), (LifecycleOwner) null, new HomeFragment$observeData$2(this), 1, (Object) null);
        getViewModel().getCustomerVouchersSwimLane().observe(getViewLifecycleOwner(), new d(this));
        getViewModel().getVoucherProduct().observe(getViewLifecycleOwner(), new e(this));
        BaseFragment.observeNonNull$default(this, getViewModel().getTproBannerLiveData(), (LifecycleOwner) null, new HomeFragment$observeData$5(this), 1, (Object) null);
        getCartFragmentViewModel().deliveryDetails().observe(getViewLifecycleOwner(), new f(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeData$lambda-17  reason: not valid java name */
    public static final void m9948observeData$lambda17(HomeFragment homeFragment, Product product) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        homeFragment.getViewModel().trackNavigateToVoucherProductDetails(homeFragment.getScreenName(), homeFragment.getEventOriginType().getTrackingName());
        Intrinsics.checkNotNullExpressionValue(product, "product");
        homeFragment.onProductClicked(product, (String) null, (ProductClickTrackingAttribute) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeData$lambda-19  reason: not valid java name */
    public static final void m9949observeData$lambda19(HomeFragment homeFragment, Result result) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        if (result instanceof Result.Success) {
            DeliveryDetails deliveryDetails = (DeliveryDetails) ((Result.Success) result).getData();
            homeFragment.getCartFragmentViewModel().onHomeReady();
            homeFragment.hideError();
        }
        if (result instanceof Result.Error) {
            homeFragment.showError(((Result.Error) result).getError());
        }
    }

    private final void observeNavigationActions() {
        getViewModel().getNavigationActions().observe(getViewLifecycleOwner(), new p(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeNavigationActions$lambda-25  reason: not valid java name */
    public static final void m9950observeNavigationActions$lambda25(HomeFragment homeFragment, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        NavDirections navDirections = (NavDirections) eventWrapper.getContentIfNotHandled();
        if (navDirections != null) {
            homeFragment.navigateOnlyIfCurrentScreenIsHomeFragment(navDirections);
        }
    }

    private final void onBannerClicked(Banner banner, String str, int i11) {
        if (!banner.isStatic()) {
            getViewModel().onBannerClicked(banner, str, i11);
            return;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        MaterialDialog materialDialog = new MaterialDialog(requireContext, new BottomSheet(LayoutMode.WRAP_CONTENT));
        MaterialDialog.cornerRadius$default(materialDialog, (Float) null, Integer.valueOf(R.dimen.bottom_sheet_corner_radius), 1, (Object) null);
        MaterialDialog.title$default(materialDialog, (Integer) null, banner.getName(), 1, (Object) null);
        MaterialDialog.message$default(materialDialog, (Integer) null, banner.getDescription(), (Function1) null, 5, (Object) null);
        materialDialog.show();
    }

    /* access modifiers changed from: private */
    public final void onBannerShown(Banner banner, String str, int i11) {
        getViewModel().trackBannerShown(banner, str, i11);
    }

    /* access modifiers changed from: private */
    public final void onCartReady(Result<Unit> result) {
        if (result.isSuccess()) {
            observeNavigationActions();
        }
    }

    /* access modifiers changed from: private */
    public final void onCategoriesViewAllClicked(List<Category> list) {
        HomeFragmentViewModel.trackAllButtonClicked$default(getViewModel(), DarkstoresTrackingConstantsKt.ALL_BTN_CATEGORY_TILE, (String) null, "category", 2, (Object) null);
        HomeFragmentDirections.Companion companion = HomeFragmentDirections.Companion;
        Object[] array = list.toArray(new Category[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        navigateOnlyIfCurrentScreenIsHomeFragment(companion.actionHomeFragmentToCategoriesOverviewBottomSheet((Category[]) array));
    }

    /* access modifiers changed from: private */
    public final void onHeroBannerClicked(Banner banner, int i11) {
        onBannerClicked(banner, BannerType.HERO.getType(), i11);
    }

    /* access modifiers changed from: private */
    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.searchFragment) {
            return false;
        }
        getViewModel().onSearchFieldClicked();
        return true;
    }

    /* access modifiers changed from: private */
    public final void onProductClicked(Product product, String str, ProductClickTrackingAttribute productClickTrackingAttribute) {
        HomeFragmentDirections.Companion companion = HomeFragmentDirections.Companion;
        if (str == null) {
            str = "";
        }
        navigateOnlyIfCurrentScreenIsHomeFragment(HomeFragmentDirections.Companion.actionToProductFragment$default(companion, product, false, (String) null, (String) null, productClickTrackingAttribute, str, (String) null, (String) null, 206, (Object) null));
    }

    /* access modifiers changed from: private */
    public final void onSearchFieldClicked() {
        getViewModel().onSearchFieldClicked();
    }

    /* access modifiers changed from: private */
    public final void onSmallBannerClicked(Banner banner, int i11) {
        onBannerClicked(banner, BannerType.SMALL.getType(), i11);
    }

    /* access modifiers changed from: private */
    public final void onSubscribeClicked() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        TproNavigatorActionsKt.navigateToBenefitsActivity(requireActivity);
    }

    /* access modifiers changed from: private */
    public final void onSwimlaneClicked(Swimlane swimlane) {
        getViewModel().trackAllButtonClicked(swimlane.getHeadline(), swimlane.getCategoryId(), DarkstoresTrackingConstantsKt.ORIGIN_TYPE_CUSTOM_SWIMLANE);
        getViewModel().onSwimlaneClicked(swimlane, EventOriginType.Swimlane);
    }

    /* access modifiers changed from: private */
    public final void onSwimlanesResultsReceived(Result<HomeFragmentData> result) {
        int i11;
        boolean z11 = result instanceof Result.Loading;
        if (getViewModel().shouldBuildUIUsingRecyclerView()) {
            Boolean valueOf = Boolean.valueOf(z11);
            if (!(!valueOf.booleanValue())) {
                valueOf = null;
            }
            if (valueOf != null) {
                valueOf.booleanValue();
                this.homeItemList.remove(HomeRecyclerViewItem.ProgressViewItem.INSTANCE);
            }
        } else {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.progressBar);
            Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
            if (z11) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            progressBar.setVisibility(i11);
        }
        if (result instanceof Result.Success) {
            Result.Success success = (Result.Success) result;
            setupCategories(((HomeFragmentData) success.getData()).getTopTwoCategories(), ((HomeFragmentData) success.getData()).getCategories());
            setupSwimlanes(((HomeFragmentData) success.getData()).getSwimlanes(), ((HomeFragmentData) success.getData()).getTopSwimlanes(), ((HomeFragmentData) success.getData()).getHighlightSwimlanes());
            setupLifestyleMission(((HomeFragmentData) success.getData()).getLifestyleMission());
            if (getViewModel().shouldBuildUIUsingRecyclerView()) {
                submitHomeItemList();
            }
            HomeFragmentViewModel.trackDarkstoreLoadTime$default(getViewModel(), 0, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: qCommerceVoucherBottomSheetWithPDPLauncher$lambda-51  reason: not valid java name */
    public static final void m9951qCommerceVoucherBottomSheetWithPDPLauncher$lambda51(HomeFragment homeFragment, ActivityResult activityResult) {
        ProductInfo productInfo;
        HomeFragment homeFragment2 = homeFragment;
        Intrinsics.checkNotNullParameter(homeFragment2, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            if (data != null) {
                productInfo = (ProductInfo) data.getParcelableExtra(QCommerceFlutterActivityKt.KEY_PRODUCT_INFO);
            } else {
                productInfo = null;
            }
            if (productInfo != null) {
                Product product = r2;
                Product product2 = new Product((String) null, (String) null, (String) null, 0.0f, (Float) null, 0, 0, (Integer) null, (Float) null, (Tracking) null, (String) null, 0, false, (List) null, (List) null, (String) null, (List) null, (String) null, false, (String) null, false, (CampaignTrigger) null, 0, (ProductExtendedInfo) null, (List) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, Integer.MAX_VALUE, (DefaultConstructorMarker) null);
                Product product3 = product;
                product3.setId(productInfo.getProductId());
                homeFragment2.navigateOnlyIfCurrentScreenIsHomeFragment(HomeFragmentDirections.Companion.actionToProductFragment$default(HomeFragmentDirections.Companion, product3, false, (String) null, (String) null, (ProductClickTrackingAttribute) null, (String) null, (String) null, (String) null, 252, (Object) null));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: qCommerceVoucherBottomSheetWithVoucherPLPLauncher$lambda-50  reason: not valid java name */
    public static final void m9952qCommerceVoucherBottomSheetWithVoucherPLPLauncher$lambda50(HomeFragment homeFragment, ActivityResult activityResult) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            String str3 = null;
            if (data != null) {
                str = data.getStringExtra(QCommerceFlutterActivityKt.KEY_VOUCHER_ID);
            } else {
                str = null;
            }
            Intent data2 = activityResult.getData();
            if (data2 != null) {
                str3 = data2.getStringExtra("voucher_name");
            }
            if (str3 == null) {
                str3 = "";
            }
            Intent data3 = activityResult.getData();
            if (data3 == null || (str2 = data3.getStringExtra(QCommerceFlutterActivityKt.KEY_VOUCHER_ORIGIN)) == null) {
                str2 = EventOriginType.VoucherSwimlane.getTrackingName();
            }
            Intrinsics.checkNotNullExpressionValue(str2, "it.data?.getStringExtra(…cherSwimlane.trackingName");
            if (str != null) {
                homeFragment.getViewModel().navigateToVoucherProductListing(str, str3, str2);
            }
        }
    }

    private final void setUpListeners() {
        HomeFragmentViewModel viewModel = getViewModel();
        int i11 = R.id.heroBanner;
        BannerView bannerView = (BannerView) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(bannerView, "heroBanner");
        int i12 = R.id.banner;
        BannerView bannerView2 = (BannerView) _$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(bannerView2, "banner");
        viewModel.setupBannerImpressionTracking(bannerView, bannerView2, new TrackingData(getScreenName(), getEventOriginType().getTrackingName()));
        ((BannerView) _$_findCachedViewById(i11)).setOnBannerShownListener(new HomeFragment$setUpListeners$1(this));
        ((BannerView) _$_findCachedViewById(i12)).setOnBannerShownListener(new HomeFragment$setUpListeners$2(this));
        ((CustomVerticalNestedScrollView) _$_findCachedViewById(R.id.darkstore_home_container)).setOnScrollChangeListener(new g(this, getViewModel().shouldListenToScrollChange()));
        _$_findCachedViewById(R.id.btnSearch).setOnClickListener(new h(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpListeners$lambda-4  reason: not valid java name */
    public static final void m9953setUpListeners$lambda4(HomeFragment homeFragment, boolean z11, View view, int i11, int i12, int i13, int i14) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        homeFragment.showSearchMenuIcon();
        if (z11) {
            HomeFragmentViewModel viewModel = homeFragment.getViewModel();
            BannerView bannerView = (BannerView) homeFragment._$_findCachedViewById(R.id.heroBanner);
            Intrinsics.checkNotNullExpressionValue(bannerView, "heroBanner");
            BannerView bannerView2 = (BannerView) homeFragment._$_findCachedViewById(R.id.banner);
            Intrinsics.checkNotNullExpressionValue(bannerView2, "banner");
            viewModel.onParentScrolled(bannerView, bannerView2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpListeners$lambda-5  reason: not valid java name */
    public static final void m9954setUpListeners$lambda5(HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        homeFragment.onSearchFieldClicked();
    }

    private final void setUpSearchView() {
        maybeApplyVLPUplift();
        if (getViewModel().canShowGreySearchBar()) {
            SearchView searchView = (SearchView) _$_findCachedViewById(R.id.searchView);
            Intrinsics.checkNotNullExpressionValue(searchView, "searchView");
            SearchViewExtensionsKt.styleGreySearchBar(searchView);
            return;
        }
        SearchView searchView2 = (SearchView) _$_findCachedViewById(R.id.searchView);
        Intrinsics.checkNotNullExpressionValue(searchView2, "searchView");
        SearchViewExtensionsKt.styleMarshmallowSearchBar(searchView2);
    }

    /* access modifiers changed from: private */
    public final void setVouchersSwimLane(List<CustomerVoucher> list) {
        int i11;
        CustomerVouchersSwimLaneAdapter customerVouchersSwimLaneAdapter = new CustomerVouchersSwimLaneAdapter(new HomeFragment$setVouchersSwimLane$voucherAdapter$1(this));
        int i12 = R.id.vouchers_swimlane;
        View _$_findCachedViewById = _$_findCachedViewById(i12);
        boolean z11 = false;
        if (_$_findCachedViewById != null) {
            if (!list.isEmpty()) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            _$_findCachedViewById.setVisibility(i11);
        }
        ((LinearLayout) _$_findCachedViewById(R.id.search_bottom_view)).setBackgroundResource(com.designsystem.marshmallow.R.color.ds_neutral_4);
        View _$_findCachedViewById2 = _$_findCachedViewById(i12);
        if (_$_findCachedViewById2 != null) {
            if (_$_findCachedViewById2.getVisibility() == 0) {
                z11 = true;
            }
            if (!z11) {
                _$_findCachedViewById2 = null;
            }
            if (_$_findCachedViewById2 != null) {
                RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById2.findViewById(com.talabat.feature.swimlanevoucherslist.presentation.R.id.vouchers_list);
                recyclerView.setAdapter(customerVouchersSwimLaneAdapter);
                recyclerView.addItemDecoration(new VoucherHorizontalSpaceDecoration());
                customerVouchersSwimLaneAdapter.addVouchersList(list);
                HomeFragmentViewModel viewModel = getViewModel();
                String screenName2 = getScreenName();
                Iterable<CustomerVoucher> iterable = list;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                for (CustomerVoucher campaignTitle : iterable) {
                    arrayList.add(campaignTitle.getCampaignTitle());
                }
                viewModel.trackVoucherSwimLaneLoaded(screenName2, arrayList);
            }
        }
    }

    private final void setupCategories(List<Category> list, List<Category> list2) {
        List<Category> list3;
        if (getViewModel().shouldBuildUIUsingRecyclerView()) {
            if (!list2.isEmpty()) {
                list3 = list2;
            } else {
                list3 = null;
            }
            if (list3 != null) {
                this.homeItemList.add(new HomeRecyclerViewItem.CategoryGridItem(new CategoryViewHolderData(list, list2)));
                return;
            }
            return;
        }
        GridSwimlaneView gridSwimlaneView = (GridSwimlaneView) _$_findCachedViewById(R.id.gridCategoriesSwimlane);
        Intrinsics.checkNotNullExpressionValue(gridSwimlaneView, "");
        gridSwimlaneView.setVisibility(0);
        if (list.size() == 2) {
            int i11 = R.id.topTwoCategoriesView;
            CategoriesMissionView categoriesMissionView = (CategoriesMissionView) gridSwimlaneView._$_findCachedViewById(i11);
            Intrinsics.checkNotNullExpressionValue(categoriesMissionView, "topTwoCategoriesView");
            categoriesMissionView.setVisibility(0);
            ((CategoriesMissionView) gridSwimlaneView._$_findCachedViewById(i11)).setContent(list.get(0), list.get(1), new HomeFragment$setupCategories$3$1(this));
        } else {
            CategoriesMissionView categoriesMissionView2 = (CategoriesMissionView) gridSwimlaneView._$_findCachedViewById(R.id.topTwoCategoriesView);
            Intrinsics.checkNotNullExpressionValue(categoriesMissionView2, "topTwoCategoriesView");
            categoriesMissionView2.setVisibility(8);
        }
        ((RecyclerView) gridSwimlaneView._$_findCachedViewById(R.id.recyclerView)).setAdapter(createCategoriesAdapter(list2));
    }

    private final void setupLifestyleMission(LifestyleMission lifestyleMission) {
        if (getViewModel().isLifestyleMissionV2() && lifestyleMission != null) {
            if (getViewModel().shouldBuildUIUsingRecyclerView()) {
                this.homeItemList.add(new HomeRecyclerViewItem.LifestyleMissionV2Item(new LifestyleMissionV2Data(lifestyleMission, new HomeFragment$setupLifestyleMission$1$1(getViewModel()))));
            } else {
                ((LifeStyleMissionV2View) _$_findCachedViewById(R.id.lifeStyleMissionV2)).setContent(lifestyleMission, new HomeFragment$setupLifestyleMission$1$2(getViewModel()));
            }
        }
    }

    private final void setupMissions() {
        BaseFragment.observeNonNull$default(this, getViewModel().getVendor(), (LifecycleOwner) null, new HomeFragment$setupMissions$1(this), 1, (Object) null);
    }

    private final void setupRewardsMissionWidget() {
        Restaurant restaurant = InjectorKt.getAppComponent().getConfigurationParameters().getRestaurant();
        if (restaurant.isDarkStore) {
            int i11 = restaurant.f13872id;
            if (getViewModel().shouldBuildUIUsingRecyclerView()) {
                this.homeItemList.add(new HomeRecyclerViewItem.RewardsMissionItem(new RewardsMissionItemData(i11)));
                return;
            }
            int i12 = R.id.rewardsMissionView;
            RewardsMissionView rewardsMissionView = (RewardsMissionView) _$_findCachedViewById(i12);
            Intrinsics.checkNotNullExpressionValue(rewardsMissionView, "rewardsMissionView");
            rewardsMissionView.setVisibility(0);
            ((RewardsMissionView) _$_findCachedViewById(i12)).setChainId(i11);
        }
    }

    private final void setupSwimlanes(List<Swimlane> list, List<Swimlane> list2, List<Swimlane> list3) {
        ArrayList arrayList;
        if (getViewModel().shouldBuildUIUsingRecyclerView()) {
            Iterable<Swimlane> iterable = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (Swimlane swimlaneViewHolderData : iterable) {
                arrayList2.add(new HomeRecyclerViewItem.SwimlaneItem(new SwimlaneViewHolderData(swimlaneViewHolderData, getCartFragmentViewModel(), new HomeFragment$setupSwimlanes$swimlaneItems$1$1(this), new HomeFragment$setupSwimlanes$swimlaneItems$1$2(this), getCartFragmentViewModel().getCartMapLiveData())));
            }
            if (!arrayList2.isEmpty()) {
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                this.homeItemList.addAll(arrayList2);
                return;
            }
            return;
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.homeRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "homeRecyclerView");
        recyclerView.setVisibility(8);
        if (isAdded()) {
            for (Swimlane swimlane : list2) {
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.topCompactSwimlanesContainer);
                Intrinsics.checkNotNullExpressionValue(linearLayout, "topCompactSwimlanesContainer");
                addCompactSwimlaneView(linearLayout, swimlane, swimlane.getCompactSwimlaneLayoutType());
            }
            for (Swimlane swimlane2 : list3) {
                LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.midCompactSwimlanesContainer);
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "midCompactSwimlanesContainer");
                addCompactSwimlaneView(linearLayout2, swimlane2, swimlane2.getCompactSwimlaneLayoutType());
            }
            for (Swimlane addSwimlaneView : list) {
                addSwimlaneView(addSwimlaneView);
            }
        }
    }

    private final void setupTalabatAiButton() {
        getViewModel().getTalabatAiShowEventLiveData().observe(getViewLifecycleOwner(), new s(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupTalabatAiButton$lambda-3  reason: not valid java name */
    public static final void m9955setupTalabatAiButton$lambda3(HomeFragment homeFragment, Boolean bool) {
        int i11;
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        int i12 = R.id.talabatAiButton;
        ImageView imageView = (ImageView) homeFragment._$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(imageView, "talabatAiButton");
        Intrinsics.checkNotNullExpressionValue(bool, "enabled");
        int i13 = 0;
        if (bool.booleanValue()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        imageView.setVisibility(i11);
        View _$_findCachedViewById = homeFragment._$_findCachedViewById(R.id.talabatAiBottomOffset);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "talabatAiBottomOffset");
        if (!bool.booleanValue()) {
            i13 = 8;
        }
        _$_findCachedViewById.setVisibility(i13);
        ((ImageView) homeFragment._$_findCachedViewById(i12)).setOnClickListener(new c(homeFragment));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupTalabatAiButton$lambda-3$lambda-2  reason: not valid java name */
    public static final void m9956setupTalabatAiButton$lambda3$lambda2(HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        homeFragment.getViewModel().onTalabatAiIconClicked();
    }

    /* access modifiers changed from: private */
    public final boolean shouldShowSearchMenuIcon() {
        ((SearchView) _$_findCachedViewById(R.id.searchView)).getLocationOnScreen(this.searchBarLocation);
        int i11 = R.id.toolbar;
        ((Toolbar) _$_findCachedViewById(i11)).getLocationOnScreen(this.toolbarLocation);
        int i12 = this.searchBarLocation[1];
        if (i12 == 0 && this.toolbarLocation[1] == 0) {
            return false;
        }
        if (i12 < this.toolbarLocation[1] + ((Toolbar) _$_findCachedViewById(i11)).getHeight()) {
            return true;
        }
        return false;
    }

    private final void showSearchMenuIcon() {
        MenuItem findItem = ((Toolbar) _$_findCachedViewById(R.id.toolbar)).getMenu().findItem(R.id.searchFragment);
        boolean shouldShowSearchMenuIcon = shouldShowSearchMenuIcon();
        if (findItem != null) {
            findItem.setEnabled(shouldShowSearchMenuIcon);
        }
        if (findItem != null) {
            findItem.setVisible(shouldShowSearchMenuIcon);
        }
    }

    /* access modifiers changed from: private */
    public final void showTproSubscriptionHeader(boolean z11) {
        Object obj;
        if (getViewModel().shouldBuildUIUsingRecyclerView()) {
            TproSubscriptionInfoData tproSubscriptionInfoData = new TproSubscriptionInfoData(z11, new HomeFragment$showTproSubscriptionHeader$tProSubscriptionInfoData$1(this));
            if (getViewModel().canShowTopHeaderChanges()) {
                obj = new HomeRecyclerViewItem.TproSubscriptionItemV2(tproSubscriptionInfoData);
            } else {
                obj = new HomeRecyclerViewItem.TproSubscriptionItem(tproSubscriptionInfoData);
            }
            this.homeItemList.add(obj);
            submitHomeItemList();
            return;
        }
        hideTproSubscriptionHeader();
        int i11 = 0;
        if (getViewModel().canShowTopHeaderChanges()) {
            int i12 = R.id.subscription_header_top;
            TProView tProView = (TProView) _$_findCachedViewById(i12);
            Intrinsics.checkNotNullExpressionValue(tProView, "subscription_header_top");
            tProView.setVisibility(0);
            ((TProView) _$_findCachedViewById(i12)).setContent(z11);
            if (z11) {
                ((TProView) _$_findCachedViewById(i12)).setOnClickListener(new n(this));
                return;
            }
            return;
        }
        int i13 = R.id.subscription_header;
        _$_findCachedViewById(i13).setVisibility(0);
        View _$_findCachedViewById = _$_findCachedViewById(i13);
        int i14 = com.talabat.feature.tpro.presentation.R.id.subscribe_button;
        View findViewById = _$_findCachedViewById.findViewById(i14);
        Intrinsics.checkNotNullExpressionValue(findViewById, "subscription_header.find…ProR.id.subscribe_button)");
        if (!z11) {
            i11 = 8;
        }
        findViewById.setVisibility(i11);
        ((Button) _$_findCachedViewById(i13).findViewById(i14)).setOnClickListener(new o(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: showTproSubscriptionHeader$lambda-6  reason: not valid java name */
    public static final void m9957showTproSubscriptionHeader$lambda6(HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        homeFragment.onSubscribeClicked();
    }

    /* access modifiers changed from: private */
    /* renamed from: showTproSubscriptionHeader$lambda-7  reason: not valid java name */
    public static final void m9958showTproSubscriptionHeader$lambda7(HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        homeFragment.onSubscribeClicked();
    }

    /* access modifiers changed from: private */
    public final void submitHomeItemList() {
        List sortedWith = CollectionsKt___CollectionsKt.sortedWith(this.homeItemList, new HomeFragment$submitHomeItemList$$inlined$sortedBy$1());
        RecyclerView.Adapter adapter = ((RecyclerView) _$_findCachedViewById(R.id.homeRecyclerView)).getAdapter();
        if (adapter != null) {
            ((HomeFragmentRecyclerViewAdapter) adapter).submitList(sortedWith);
            getViewModel().setSwimlaneImpressionData(sortedWith);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.darkstores.feature.home.HomeFragmentRecyclerViewAdapter");
    }

    /* access modifiers changed from: private */
    public final void updateHomeBannerItems(BannersResponse bannersResponse) {
        boolean z11;
        List<Banner> heroBanners = bannersResponse.getHeroBanners();
        List<Banner> list = null;
        if (!(!heroBanners.isEmpty())) {
            heroBanners = null;
        }
        boolean z12 = false;
        if (heroBanners != null) {
            z11 = getBannerItemViewHolder(heroBanners, BannerType.HERO);
        } else {
            z11 = false;
        }
        List<Banner> banners = bannersResponse.getBanners();
        if (!banners.isEmpty()) {
            list = banners;
        }
        if (list != null) {
            z12 = getBannerItemViewHolder(list, BannerType.SMALL);
        }
        if (z11 || z12) {
            submitHomeItemList();
        }
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

    @NotNull
    public EventOriginType getEventOriginType() {
        return this.eventOriginType;
    }

    @NotNull
    public final ProductImpressionTracker getProductImpressionTracker() {
        ProductImpressionTracker productImpressionTracker2 = this.productImpressionTracker;
        if (productImpressionTracker2 != null) {
            return productImpressionTracker2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("productImpressionTracker");
        return null;
    }

    @NotNull
    public String getScreenName() {
        return this.screenName;
    }

    public void hideError() {
        super.hideError();
        handleErrorView(false);
    }

    public void i0() {
        int i11;
        int i12;
        super.i0();
        int i13 = R.id.toolbar;
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(i13);
        toolbar.inflateMenu(R.menu.darkstores_home_screen_toolbar_menu);
        toolbar.setOnMenuItemClickListener(new r(this));
        showSearchMenuIcon();
        ((Toolbar) _$_findCachedViewById(i13)).setNavigationIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_m_back_white_bg, (Resources.Theme) null));
        ApplicationComponent appComponent = InjectorKt.getAppComponent();
        if (appComponent != null) {
            ((TextView) _$_findCachedViewById(R.id.home_title)).setText(appComponent.getConfigurationParameters().getTalabatVendorInfo().getName());
            ((TextView) _$_findCachedViewById(R.id.home_title_only)).setText(appComponent.getConfigurationParameters().getTalabatVendorInfo().getName());
        }
        boolean canShowTopHeaderChanges = getViewModel().canShowTopHeaderChanges();
        TextView textView = (TextView) _$_findCachedViewById(R.id.home_title_only);
        Intrinsics.checkNotNullExpressionValue(textView, "home_title_only");
        int i14 = 8;
        int i15 = 0;
        if (!canShowTopHeaderChanges) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        textView.setVisibility(i11);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.logo_and_title_container);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "logo_and_title_container");
        if (canShowTopHeaderChanges) {
            i14 = 0;
        }
        linearLayout.setVisibility(i14);
        Toolbar toolbar2 = (Toolbar) _$_findCachedViewById(i13);
        Intrinsics.checkNotNullExpressionValue(toolbar2, "toolbar");
        if (!ViewCompat.isLaidOut(toolbar2) || toolbar2.isLayoutRequested()) {
            toolbar2.addOnLayoutChangeListener(new HomeFragment$setupToolbar$$inlined$doOnLayout$1(this));
            return;
        }
        Toolbar toolbar3 = (Toolbar) _$_findCachedViewById(i13);
        Intrinsics.checkNotNullExpressionValue(toolbar3, "toolbar");
        int childCount = toolbar3.getChildCount();
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = toolbar3.getChildAt(i17);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            i16 += childAt.getWidth();
        }
        int i18 = R.id.toolbar;
        int width = ((Toolbar) _$_findCachedViewById(i18)).getWidth() - i16;
        View access$getNavigationIconView = getNavigationIconView();
        if (access$getNavigationIconView != null) {
            i12 = access$getNavigationIconView.getWidth();
        } else {
            i12 = 0;
        }
        View access$getSearchIconView = getSearchIconView();
        if (access$getSearchIconView != null) {
            i15 = access$getSearchIconView.getWidth();
        }
        ((Toolbar) _$_findCachedViewById(i18)).setTitleMargin((-width) - (i12 - i15), ((Toolbar) _$_findCachedViewById(i18)).getTitleMarginTop(), ((Toolbar) _$_findCachedViewById(i18)).getTitleMarginEnd(), ((Toolbar) _$_findCachedViewById(i18)).getTitleMarginBottom());
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getViewModel().startVendorListingPageTTITrace();
        getViewModel().startVendorListingPageTTFLTrace();
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, this, false, new HomeFragment$onCreate$1(this), 2, (Object) null);
        setProductImpressionTracker(InjectorKt.getAppComponent().getTracker());
    }

    public void onDestroyView() {
        getProductImpressionTracker().unregister();
        getViewModel().unregisterImpressions();
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        super.onResume();
        getViewModel().onReadyForInteractionDhDefinition();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, com.designsystem.marshmallow.R.color.ds_neutral_white));
        }
        int i11 = R.id.toolbar;
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        if (!ViewCompat.isLaidOut(toolbar) || toolbar.isLayoutRequested()) {
            toolbar.addOnLayoutChangeListener(new HomeFragment$onResume$$inlined$doOnLayout$1(this));
            return;
        }
        ((Toolbar) _$_findCachedViewById(i11)).setNavigationIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_m_back_white_bg, (Resources.Theme) null));
        MenuItem findItem = ((Toolbar) _$_findCachedViewById(i11)).getMenu().findItem(R.id.searchFragment);
        if (findItem != null) {
            findItem.setVisible(shouldShowSearchMenuIcon());
        }
    }

    public void onRetryClicked() {
        getViewModel().onRetry();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.homeItemList.clear();
        view.getViewTreeObserver().addOnGlobalLayoutListener(new HomeFragment$onViewCreated$1(view, this));
        if (getViewModel().shouldBuildUIUsingRecyclerView()) {
            ((CustomVerticalNestedScrollView) _$_findCachedViewById(R.id.darkstore_home_container)).setVisibility(8);
            ((RecyclerView) _$_findCachedViewById(R.id.homeRecyclerView)).setVisibility(0);
        } else {
            ((CustomVerticalNestedScrollView) _$_findCachedViewById(R.id.darkstore_home_container)).setVisibility(0);
            ((RecyclerView) _$_findCachedViewById(R.id.homeRecyclerView)).setVisibility(8);
            setUpSearchView();
            setUpListeners();
        }
        if (getViewModel().shouldBuildUIUsingRecyclerView()) {
            setupRecyclerView();
        }
        observeData();
        getCartFragmentViewModel().getCartReadyLiveData().observe(getViewLifecycleOwner(), new q(this));
        setupRewardsMissionWidget();
        setupTalabatAiButton();
    }

    public final void setProductImpressionTracker(@NotNull ProductImpressionTracker productImpressionTracker2) {
        Intrinsics.checkNotNullParameter(productImpressionTracker2, "<set-?>");
        this.productImpressionTracker = productImpressionTracker2;
    }

    public final void setupRecyclerView() {
        HomeFragmentViewModel viewModel = getViewModel();
        int i11 = R.id.homeRecyclerView;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "homeRecyclerView");
        viewModel.setupSwimlaneImpression(recyclerView, this);
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(new HomeFragmentRecyclerViewAdapter(getCartFragmentViewModel(), getCartFragmentViewModel().getCartMapLiveData(), new HomeFragment$setupRecyclerView$1(this), new HomeFragment$setupRecyclerView$2(this), getCartFragmentViewModel().getCategoriesRowsCount(), new HomeFragment$setupRecyclerView$3(this), this, getViewModel().getHeroBannerImpressionTracker(), getViewModel().getSmallBannerImpressionTracker(), new TrackingData(getScreenName(), getEventOriginType().getTrackingName())));
        this.homeItemList.add(new HomeRecyclerViewItem.SearchViewItem(new SearchViewHolderData(getViewModel().canShowGreySearchBar(), getViewModel().canShowTopHeaderChanges())));
        this.homeItemList.add(HomeRecyclerViewItem.ProgressViewItem.INSTANCE);
        ((RecyclerView) _$_findCachedViewById(i11)).addOnScrollListener(new HomeFragment$setupRecyclerView$4(this));
    }

    public void showError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "error");
        super.showError(th2);
        handleErrorView(true);
    }
}
