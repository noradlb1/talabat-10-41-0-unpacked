package com.talabat.talabatlife.ui.vendorList;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.integration.tLife.IntegrationAppTrackerTLife;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.talabatcommon.extentions.ActivityKt;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.DoubleKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.helpers.LocationHelper;
import com.talabat.talabatcommon.listeners.DebounceQueryTextListener;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.domain.entity.Cuisine;
import com.talabat.talabatlife.domain.entity.Filter;
import com.talabat.talabatlife.ui.cuisine.TDineCuisineButton;
import com.talabat.talabatlife.ui.onBoarding.di.DaggerVendorsListFragmentComponent;
import com.talabat.talabatlife.ui.vendorList.model.VendorAreasDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorListDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorLocationFilterDisplayModel;
import com.talabat.talabatlife.ui.vendorList.viewModel.VendorsListViewModel;
import com.talabat.talabatlife.ui.vendorList.viewModel.VendorsListViewModelBuilder;
import com.talabat.talabatlife.ui.vendorList.viewModel.VendorsListViewModelImpl;
import com.talabat.talabatlife.ui.vendorList.views.VendorsListAdaptor;
import com.talabat.talabatlife.ui.vendorList.views.VendorsLocationFilterBottomSheet;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lw.a;
import lw.b;
import lw.c;
import lw.d;
import lw.e;
import lw.f;
import lw.g;
import lw.h;
import lw.i;
import lw.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000å\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0003.1A\u0018\u0000 \u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000205H\u0002J\b\u00107\u001a\u000205H\u0002J\b\u00108\u001a\u000205H\u0002J\b\u00109\u001a\u000205H\u0002J\u0012\u0010:\u001a\u0002052\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010=\u001a\u000205H\u0002J\b\u0010>\u001a\u00020*H\u0002J\b\u0010?\u001a\u000205H\u0002J\u0015\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002¢\u0006\u0002\u0010DJ\\\u0010E\u001a\u0002052\b\b\u0002\u0010F\u001a\u00020\f2\b\b\u0002\u0010G\u001a\u00020\f2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010I\u001a\u00020*2\b\b\u0002\u0010J\u001a\u00020*2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010L\u001a\u00020\f2\b\b\u0002\u0010M\u001a\u00020\fH\u0002J\u000e\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00020OH\u0016J\u0018\u0010P\u001a\u0002052\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010S\u001a\u000205H\u0002J\b\u0010T\u001a\u00020\fH\u0016J\b\u0010U\u001a\u000205H\u0002J\b\u0010V\u001a\u000205H\u0016J\u0010\u0010W\u001a\u0002052\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010Z\u001a\u0002052\u0006\u0010[\u001a\u00020*H\u0002J\b\u0010\\\u001a\u000205H\u0016J-\u0010]\u001a\u0002052\u0006\u0010^\u001a\u00020\f2\u000e\u0010_\u001a\n\u0012\u0006\b\u0001\u0012\u00020*0`2\u0006\u0010a\u001a\u00020bH\u0016¢\u0006\u0002\u0010cJ\b\u0010d\u001a\u000205H\u0016J\u001a\u0010e\u001a\u0002052\u0006\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010iH\u0017J\b\u0010j\u001a\u000205H\u0002J\b\u0010k\u001a\u000205H\u0002J\b\u0010l\u001a\u000205H\u0002J\b\u0010m\u001a\u000205H\u0002J\u0010\u0010n\u001a\u0002052\u0006\u0010f\u001a\u00020gH\u0003J\u0010\u0010o\u001a\u0002052\u0006\u0010p\u001a\u00020\fH\u0002J\b\u0010q\u001a\u000205H\u0002J\u0010\u0010r\u001a\u0002052\u0006\u0010s\u001a\u00020tH\u0002J\b\u0010u\u001a\u000205H\u0002J\b\u0010v\u001a\u000205H\u0002J\b\u0010w\u001a\u000205H\u0002J\b\u0010x\u001a\u000205H\u0002J\b\u0010y\u001a\u000205H\u0002J\u0018\u0010z\u001a\u0002052\u000e\u0010{\u001a\n\u0012\u0004\u0012\u00020}\u0018\u00010|H\u0002J\u0013\u0010~\u001a\u0002052\t\u0010\u001a\u0005\u0018\u00010\u0001H\u0002J\u0013\u0010\u0001\u001a\u0002052\b\u0010s\u001a\u0004\u0018\u00010tH\u0002J\u0015\u0010\u0001\u001a\u0002052\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010\u0001\u001a\u000205H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0004¢\u0006\u0004\n\u0002\u0010/R\u0010\u00100\u001a\u000201X\u0004¢\u0006\u0004\n\u0002\u00102R\u000e\u00103\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/VendorsListFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/talabatlife/ui/vendorList/viewModel/VendorsListViewModel;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "()V", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "getConfigurationLocalCoreLibApi", "()Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "setConfigurationLocalCoreLibApi", "(Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;)V", "currentPage", "", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "helpCenterDeeplinkBuilder", "Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "getHelpCenterDeeplinkBuilder", "()Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "setHelpCenterDeeplinkBuilder", "(Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;)V", "isCoffeeMode", "", "isLastPage", "isLoading", "listAdaptor", "Lcom/talabat/talabatlife/ui/vendorList/views/VendorsListAdaptor;", "locationHelper", "Lcom/talabat/talabatcommon/helpers/LocationHelper;", "locationUpdateListener", "Landroid/location/LocationListener;", "searchText", "", "selectedCuisineId", "selectedFilterId", "vendorsItemClickListener", "com/talabat/talabatlife/ui/vendorList/VendorsListFragment$vendorsItemClickListener$1", "Lcom/talabat/talabatlife/ui/vendorList/VendorsListFragment$vendorsItemClickListener$1;", "vendorsLocationBottomSheetInterface", "com/talabat/talabatlife/ui/vendorList/VendorsListFragment$vendorsLocationBottomSheetInterface$1", "Lcom/talabat/talabatlife/ui/vendorList/VendorsListFragment$vendorsLocationBottomSheetInterface$1;", "wasLoadLifeListEventSent", "addCancelButtonListener", "", "addClearButtonListener", "addEditTextOnFocusListener", "addTextChangeListener", "askLocationPermissionIfNeeded", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "freeCoffeeMode", "getCurrentLocationText", "getMoreVendor", "getPaginationListener", "com/talabat/talabatlife/ui/vendorList/VendorsListFragment$getPaginationListener$1", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "(Landroidx/recyclerview/widget/LinearLayoutManager;)Lcom/talabat/talabatlife/ui/vendorList/VendorsListFragment$getPaginationListener$1;", "getVendorList", "pageNumber", "pageSize", "searchString", "lat", "long", "areaID", "offerFilterId", "cuisineId", "getViewModelClass", "Ljava/lang/Class;", "goToVendorOffersScreen", "model", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "initLocationListening", "layoutId", "navigateToDashboard", "observatory", "onAttach", "context", "Landroid/content/Context;", "onDebounce", "text", "onPause", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "removeClearButton", "resetListModeView", "resetPaginationParameters", "setCurrentLocationText", "setStatusBarHeight", "setVendorsListButtonHeader", "resId", "setupUI", "showAreaBottomSheet", "displayModel", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorAreasDisplayModel;", "showClearButton", "showEmptyResultView", "showGlobalHelpCenter", "showLoyaltyIcon", "showRecyclerView", "updateCuisineButton", "list", "", "Lcom/talabat/talabatlife/domain/entity/Cuisine;", "updateFilterButton", "filterName", "Lcom/talabat/talabatlife/domain/entity/Filter;", "updateVendorAreasList", "updateVendorList", "vendorListDisplayModel", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModel;", "vendorsListMode", "viewModelBuilder", "Lcom/talabat/talabatlife/ui/vendorList/viewModel/VendorsListViewModelImpl;", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListFragment extends BaseFragment implements AnimationHelper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String FREE_COFFEE_MODE = "isCoffeeMode";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
    private int currentPage = 1;
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;
    @Inject
    public IHelpCenterDeeplinkBuilder helpCenterDeeplinkBuilder;
    /* access modifiers changed from: private */
    public boolean isCoffeeMode;
    /* access modifiers changed from: private */
    public boolean isLastPage;
    /* access modifiers changed from: private */
    public boolean isLoading;
    @NotNull
    private final VendorsListAdaptor listAdaptor = new VendorsListAdaptor(false, (List) null, 3, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public LocationHelper locationHelper;
    @NotNull
    private final LocationListener locationUpdateListener = new VendorsListFragment$locationUpdateListener$1(this);
    @NotNull
    private String searchText = "";
    /* access modifiers changed from: private */
    public int selectedCuisineId;
    private int selectedFilterId;
    @NotNull
    private final VendorsListFragment$vendorsItemClickListener$1 vendorsItemClickListener = new VendorsListFragment$vendorsItemClickListener$1(this);
    @NotNull
    private final VendorsListFragment$vendorsLocationBottomSheetInterface$1 vendorsLocationBottomSheetInterface = new VendorsListFragment$vendorsLocationBottomSheetInterface$1(this);
    private boolean wasLoadLifeListEventSent;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/VendorsListFragment$Companion;", "", "()V", "FREE_COFFEE_MODE", "", "getInstance", "Lcom/talabat/talabatlife/ui/vendorList/VendorsListFragment;", "freeCoffeeMode", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ VendorsListFragment getInstance$default(Companion companion, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            return companion.getInstance(z11);
        }

        @NotNull
        public final VendorsListFragment getInstance(boolean z11) {
            VendorsListFragment vendorsListFragment = new VendorsListFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isCoffeeMode", z11);
            vendorsListFragment.setArguments(bundle);
            return vendorsListFragment;
        }
    }

    public static final /* synthetic */ VendorsListViewModel access$getViewModel(VendorsListFragment vendorsListFragment) {
        return (VendorsListViewModel) vendorsListFragment.getViewModel();
    }

    private final void addCancelButtonListener() {
        int i11 = R.id.cancelBtn;
        ((TextView) _$_findCachedViewById(i11)).setVisibility(8);
        ((TextView) _$_findCachedViewById(i11)).setOnClickListener(new i(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addCancelButtonListener$lambda-23  reason: not valid java name */
    public static final void m5845addCancelButtonListener$lambda23(VendorsListFragment vendorsListFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        vendorsListFragment.resetListModeView();
        vendorsListFragment.resetPaginationParameters();
        vendorsListFragment.updateVendorList(((VendorsListViewModel) vendorsListFragment.getViewModel()).getDefaultResult());
    }

    private final void addClearButtonListener() {
        int i11 = R.id.clearBtn;
        ((ImageView) _$_findCachedViewById(i11)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(i11)).setOnClickListener(new g(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addClearButtonListener$lambda-25  reason: not valid java name */
    public static final void m5846addClearButtonListener$lambda25(VendorsListFragment vendorsListFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        ((EditText) vendorsListFragment._$_findCachedViewById(R.id.searchEdt)).getText().clear();
    }

    private final void addEditTextOnFocusListener() {
        ((EditText) _$_findCachedViewById(R.id.searchEdt)).setOnFocusChangeListener(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addEditTextOnFocusListener$lambda-24  reason: not valid java name */
    public static final void m5847addEditTextOnFocusListener$lambda24(VendorsListFragment vendorsListFragment, View view, boolean z11) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        if (z11) {
            int i11 = R.id.anim_toolbar;
            Toolbar toolbar = (Toolbar) vendorsListFragment._$_findCachedViewById(i11);
            Intrinsics.checkNotNullExpressionValue(toolbar, "anim_toolbar");
            vendorsListFragment.adjustViewHeight(toolbar, ((Toolbar) vendorsListFragment._$_findCachedViewById(i11)).getHeight(), 0, AnimationSpeed.NORMAL);
            vendorsListFragment.delay(200, new VendorsListFragment$addEditTextOnFocusListener$1$1(vendorsListFragment));
            return;
        }
        ((LinearLayout) vendorsListFragment._$_findCachedViewById(R.id.vendorsListSearchLinearLayout)).setSelected(false);
    }

    private final void addTextChangeListener() {
        ((EditText) _$_findCachedViewById(R.id.searchEdt)).addTextChangedListener(new DebounceQueryTextListener(0, new VendorsListFragment$addTextChangeListener$1(this), getLifecycle(), new VendorsListFragment$addTextChangeListener$2(this), (Function1) null, 17, (DefaultConstructorMarker) null));
    }

    private final void askLocationPermissionIfNeeded() {
        Boolean bool;
        LocationHelper locationHelper2 = this.locationHelper;
        if (locationHelper2 != null) {
            bool = Boolean.valueOf(locationHelper2.isAnyLocationPermissionGranted());
        } else {
            bool = null;
        }
        if (!BooleanKt.orFalse(bool) && ((VendorsListViewModel) getViewModel()).getSelectedArea() == null) {
            ((LinearLayout) _$_findCachedViewById(R.id.vendorsListToolbarAreaLinearLayout)).performClick();
        }
    }

    private final void freeCoffeeMode() {
        setVendorsListButtonHeader(com.talabat.localization.R.string.life_dine_in_near);
        ((LinearLayout) _$_findCachedViewById(R.id.filtersContainer)).setVisibility(8);
        ((CardView) _$_findCachedViewById(R.id.loyaltyWidgetContainer)).setVisibility(8);
        int i11 = R.id.getHelpButton;
        ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i11)).setOnClickListener(new j(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: freeCoffeeMode$lambda-9  reason: not valid java name */
    public static final void m5848freeCoffeeMode$lambda9(VendorsListFragment vendorsListFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        vendorsListFragment.showGlobalHelpCenter();
    }

    private final String getCurrentLocationText() {
        String str;
        int i11 = R.id.vendorsListToolbarAreaTextView;
        if (Intrinsics.areEqual((Object) ((TextView) _$_findCachedViewById(i11)).getText().toString(), (Object) getString(com.talabat.localization.R.string.current_location))) {
            str = getString(com.talabat.localization.R.string.more_restaurants_around_you);
        } else {
            str = getString(com.talabat.localization.R.string.more_restaurants_around) + " " + ((TextView) _$_findCachedViewById(i11)).getText();
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (vendorsListToolbarAr…text.toString()\n        }");
        return str;
    }

    /* access modifiers changed from: private */
    public final void getMoreVendor() {
        int i11 = this.currentPage + 1;
        this.currentPage = i11;
        k(this, i11, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, 254, (Object) null);
    }

    private final VendorsListFragment$getPaginationListener$1 getPaginationListener(LinearLayoutManager linearLayoutManager) {
        return new VendorsListFragment$getPaginationListener$1(linearLayoutManager, this);
    }

    private final void getVendorList(int i11, int i12, String str, String str2, String str3, String str4, int i13, int i14) {
        showProgress();
        VendorsListViewModel.getVendorsList$default((VendorsListViewModel) getViewModel(), 0, str2, str3, i11, i12, str, str4, i13, i14, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void goToVendorOffersScreen(VendorDisplayModel vendorDisplayModel, boolean z11) {
        Context context = getContext();
        if (context != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(TLifeNavigationActions.EXTRA_VENDOR_OFFER_MODEL, vendorDisplayModel);
            bundle.putBoolean(TLifeNavigationActions.EXTRA_IS_FREE_COFFEE_MODE, z11);
            Navigator.Companion.navigate(context, new NavigatorModel(TLifeNavigationActions.OPEN_TALABAT_LIFE_VENDOR_OFFERS_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null));
        }
    }

    private final void initLocationListening() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            LocationHelper locationHelper2 = new LocationHelper(activity);
            locationHelper2.setAskPermission(false);
            locationHelper2.setLocationListener(this.locationUpdateListener);
            this.locationHelper = locationHelper2;
        }
    }

    public static /* synthetic */ void k(VendorsListFragment vendorsListFragment, int i11, int i12, String str, String str2, String str3, String str4, int i13, int i14, int i15, Object obj) {
        int i16;
        int i17;
        String str5;
        String str6;
        String str7;
        String str8;
        int i18;
        int i19;
        Integer num;
        VendorsListFragment vendorsListFragment2 = vendorsListFragment;
        int i21 = i15;
        if ((i21 & 1) != 0) {
            i16 = 1;
        } else {
            i16 = i11;
        }
        if ((i21 & 2) != 0) {
            i17 = 20;
        } else {
            i17 = i12;
        }
        if ((i21 & 4) != 0) {
            str5 = vendorsListFragment2.searchText;
        } else {
            str5 = str;
        }
        if ((i21 & 8) != 0) {
            str6 = String.valueOf(((VendorsListViewModel) vendorsListFragment.getViewModel()).getUserLatitude());
        } else {
            str6 = str2;
        }
        if ((i21 & 16) != 0) {
            str7 = String.valueOf(((VendorsListViewModel) vendorsListFragment.getViewModel()).getUserLongitude());
        } else {
            str7 = str3;
        }
        if ((i21 & 32) != 0) {
            VendorLocationFilterDisplayModel selectedArea = ((VendorsListViewModel) vendorsListFragment.getViewModel()).getSelectedArea();
            if (selectedArea != null) {
                num = Integer.valueOf(selectedArea.getAreaId());
            } else {
                num = null;
            }
            str8 = String.valueOf(IntKt.orZero(num));
        } else {
            str8 = str4;
        }
        if ((i21 & 64) != 0) {
            i18 = vendorsListFragment2.selectedFilterId;
        } else {
            i18 = i13;
        }
        if ((i21 & 128) != 0) {
            i19 = vendorsListFragment2.selectedCuisineId;
        } else {
            i19 = i14;
        }
        vendorsListFragment.getVendorList(i16, i17, str5, str6, str7, str8, i18, i19);
    }

    /* access modifiers changed from: private */
    public final void navigateToDashboard() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            GrowthNavigatorActions.Companion.startLoyaltyDashboardActivity$default(GrowthNavigatorActions.Companion, activity, LoyaltyDashboardScreen.RewardsCatalogueOrigin.OTHER, (Function1) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void onDebounce(String str) {
        this.searchText = str;
        k(this, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, 255, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void removeClearButton() {
        ((ImageView) _$_findCachedViewById(R.id.clearBtn)).setVisibility(8);
    }

    private final void resetListModeView() {
        TypedArray typedArray;
        Resources.Theme theme;
        Context context = getContext();
        Integer num = null;
        if (context == null || (theme = context.getTheme()) == null) {
            typedArray = null;
        } else {
            typedArray = theme.obtainStyledAttributes(new int[]{16843499});
        }
        if (typedArray != null) {
            num = Integer.valueOf((int) typedArray.getDimension(0, 0.0f));
        }
        int orZero = IntKt.orZero(num);
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(R.id.anim_toolbar);
        Intrinsics.checkNotNullExpressionValue(toolbar, "anim_toolbar");
        adjustViewHeight(toolbar, 0, orZero, AnimationSpeed.NORMAL);
        delay(200, new VendorsListFragment$resetListModeView$1(this));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ActivityKt.hideKeyBoard(activity);
        }
        int i11 = R.id.searchEdt;
        ((EditText) _$_findCachedViewById(i11)).getText().clear();
        ((EditText) _$_findCachedViewById(i11)).clearFocus();
    }

    /* access modifiers changed from: private */
    public final void resetPaginationParameters() {
        this.isLoading = false;
        this.currentPage = 1;
    }

    /* access modifiers changed from: private */
    public final void setCurrentLocationText() {
        Unit unit;
        VendorLocationFilterDisplayModel selectedArea = ((VendorsListViewModel) getViewModel()).getSelectedArea();
        if (selectedArea != null) {
            ((TextView) _$_findCachedViewById(R.id.vendorsListToolbarAreaTextView)).setText(selectedArea.getAreaName());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ((TextView) _$_findCachedViewById(R.id.vendorsListToolbarAreaTextView)).setText(getString(com.talabat.localization.R.string.current_location));
        }
    }

    @RequiresApi(20)
    private final void setStatusBarHeight(View view) {
        view.setOnApplyWindowInsetsListener(new f(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setStatusBarHeight$lambda-5  reason: not valid java name */
    public static final WindowInsets m5849setStatusBarHeight$lambda5(VendorsListFragment vendorsListFragment, View view, WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        ViewGroup.LayoutParams layoutParams = ((Toolbar) vendorsListFragment._$_findCachedViewById(R.id.anim_toolbar)).getLayoutParams();
        if (layoutParams != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = systemWindowInsetTop;
            return windowInsets;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void setVendorsListButtonHeader(int i11) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((TextView) activity.findViewById(R.id.vendorsListAreaButtonHeader)).setText(getString(i11));
        }
    }

    private final void setupUI() {
        boolean z11;
        ((ImageButton) _$_findCachedViewById(R.id.offersBackButton)).setOnClickListener(new b(this));
        ((LinearLayout) _$_findCachedViewById(R.id.vendorsListToolbarAreaLinearLayout)).setOnClickListener(new c(this));
        ((Button) _$_findCachedViewById(R.id.offersFilterButton)).setOnClickListener(new d(this));
        Context context = getContext();
        if (context != null) {
            this.listAdaptor.setVendorClickListener(this.vendorsItemClickListener);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.tLifeOffersRecyclerView);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(this.listAdaptor);
            recyclerView.addOnScrollListener(getPaginationListener(linearLayoutManager));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            z11 = arguments.getBoolean("isCoffeeMode");
        } else {
            z11 = false;
        }
        this.isCoffeeMode = z11;
        if (z11) {
            freeCoffeeMode();
        } else {
            vendorsListMode();
        }
        addCancelButtonListener();
        addEditTextOnFocusListener();
        addClearButtonListener();
        addTextChangeListener();
    }

    /* access modifiers changed from: private */
    /* renamed from: setupUI$lambda-10  reason: not valid java name */
    public static final void m5850setupUI$lambda10(VendorsListFragment vendorsListFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        FragmentActivity activity = vendorsListFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setupUI$lambda-11  reason: not valid java name */
    public static final void m5851setupUI$lambda11(VendorsListFragment vendorsListFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        vendorsListFragment.showProgress();
        VendorsListViewModel.getVendorsAreasList$default((VendorsListViewModel) vendorsListFragment.getViewModel(), 0, (String) null, (String) null, 7, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupUI$lambda-12  reason: not valid java name */
    public static final void m5852setupUI$lambda12(VendorsListFragment vendorsListFragment, View view) {
        int i11;
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        vendorsListFragment.resetPaginationParameters();
        if (view.isSelected()) {
            i11 = 0;
        } else {
            Object tag = view.getTag();
            if (tag != null) {
                i11 = ((Integer) tag).intValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
        vendorsListFragment.selectedFilterId = i11;
        k(vendorsListFragment, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, 255, (Object) null);
        view.setSelected(!view.isSelected());
    }

    private final void showAreaBottomSheet(VendorAreasDisplayModel vendorAreasDisplayModel) {
        Integer num;
        ArrayList arrayList = new ArrayList(vendorAreasDisplayModel.getAreas());
        Double valueOf = Double.valueOf(DoubleKt.orZero(Double.valueOf(((VendorsListViewModel) getViewModel()).getUserLatitude())));
        Double valueOf2 = Double.valueOf(DoubleKt.orZero(Double.valueOf(((VendorsListViewModel) getViewModel()).getUserLongitude())));
        VendorLocationFilterDisplayModel selectedArea = ((VendorsListViewModel) getViewModel()).getSelectedArea();
        if (selectedArea != null) {
            num = Integer.valueOf(selectedArea.getAreaId());
        } else {
            num = null;
        }
        VendorsLocationFilterBottomSheet vendorsLocationFilterBottomSheet = new VendorsLocationFilterBottomSheet(arrayList, valueOf, valueOf2, "", num, this.vendorsLocationBottomSheetInterface);
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.beginTransaction();
            vendorsLocationFilterBottomSheet.show(fragmentManager, "");
        }
    }

    /* access modifiers changed from: private */
    public final void showClearButton() {
        ((ImageView) _$_findCachedViewById(R.id.clearBtn)).setVisibility(0);
    }

    private final void showEmptyResultView() {
        ((RecyclerView) _$_findCachedViewById(R.id.tLifeOffersRecyclerView)).setVisibility(8);
        _$_findCachedViewById(R.id.searchEmptyView).setVisibility(0);
    }

    private final void showGlobalHelpCenter() {
        DeepLinkNavigator deepLinkNavigator2 = getDeepLinkNavigator();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        DeepLinkNavigator.DefaultImpls.navigateTo$default(deepLinkNavigator2, requireActivity, IHelpCenterDeeplinkBuilder.DefaultImpls.build$default(getHelpCenterDeeplinkBuilder(), (String) null, (String) null, 3, (Object) null), (Function0) null, 4, (Object) null);
    }

    private final void showLoyaltyIcon() {
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(getFeatureFlagRepo(), EcosystemsFeatureFlagsKeys.IS_REWARDS_ENABLED, false, 2, (Object) null)) {
            ((CardView) _$_findCachedViewById(R.id.loyaltyWidgetContainer)).setVisibility(0);
        }
        ((CardView) _$_findCachedViewById(R.id.loyaltyWidgetContainer)).setOnClickListener(new h(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: showLoyaltyIcon$lambda-15  reason: not valid java name */
    public static final void m5853showLoyaltyIcon$lambda15(VendorsListFragment vendorsListFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        vendorsListFragment.navigateToDashboard();
    }

    private final void showRecyclerView() {
        ((RecyclerView) _$_findCachedViewById(R.id.tLifeOffersRecyclerView)).setVisibility(0);
        _$_findCachedViewById(R.id.searchEmptyView).setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void updateCuisineButton(List<Cuisine> list) {
        if (list != null) {
            int i11 = R.id.cuisineButton;
            ((TDineCuisineButton) _$_findCachedViewById(i11)).invoke(list, new VendorsListFragment$updateCuisineButton$1$1(this));
            ((TDineCuisineButton) _$_findCachedViewById(i11)).setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void updateFilterButton(Filter filter) {
        if (filter != null) {
            int i11 = R.id.offersFilterButton;
            ((Button) _$_findCachedViewById(i11)).setText(filter.getName());
            ((Button) _$_findCachedViewById(i11)).setTag(Integer.valueOf(filter.getId()));
            ((Button) _$_findCachedViewById(i11)).setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void updateVendorAreasList(VendorAreasDisplayModel vendorAreasDisplayModel) {
        hideProgress();
        if (vendorAreasDisplayModel != null) {
            showAreaBottomSheet(vendorAreasDisplayModel);
        }
    }

    /* access modifiers changed from: private */
    public final void updateVendorList(VendorListDisplayModel vendorListDisplayModel) {
        if (vendorListDisplayModel != null) {
            boolean z11 = false;
            if (this.isLoading) {
                this.isLoading = false;
                this.listAdaptor.addToVendorsItems(vendorListDisplayModel.getVendors(), getCurrentLocationText());
            } else {
                this.listAdaptor.updateVendorList(vendorListDisplayModel.getVendors(), getCurrentLocationText());
            }
            if (getContext() != null && !this.wasLoadLifeListEventSent) {
                IntegrationAppTrackerTLife.Companion.onTLifeListLoaded(vendorListDisplayModel.getTotalCount());
                this.wasLoadLifeListEventSent = true;
            }
            if (((double) this.currentPage) >= ((double) vendorListDisplayModel.getTotalCount()) / ((double) vendorListDisplayModel.getPageSize())) {
                z11 = true;
            }
            this.isLastPage = z11;
            if (vendorListDisplayModel.getTotalCount() == 0) {
                showEmptyResultView();
            } else {
                showRecyclerView();
            }
        }
        hideProgress();
    }

    private final void vendorsListMode() {
        setVendorsListButtonHeader(com.talabat.localization.R.string.life_restaurants_in);
        ((LinearLayout) _$_findCachedViewById(R.id.filtersContainer)).setVisibility(0);
        showLoyaltyIcon();
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(getFeatureFlagRepo(), TalabatFeatureFlagConstants.ENABLE_HELP, false, 2, (Object) null)) {
            ((TextView) _$_findCachedViewById(R.id.getHelpButton)).setVisibility(0);
        } else {
            ((TextView) _$_findCachedViewById(R.id.getHelpButton)).setVisibility(8);
        }
        ((TextView) _$_findCachedViewById(R.id.getHelpButton)).setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: vendorsListMode$lambda-8  reason: not valid java name */
    public static final void m5854vendorsListMode$lambda8(VendorsListFragment vendorsListFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        FragmentActivity activity = vendorsListFragment.getActivity();
        if (activity != null) {
            Navigator.Companion.navigate((Context) activity, new NavigatorModel(TLifeNavigationActions.FLUTTER_ONBOARDING_DETAILS_ACTIVITY, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
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

    public void adjustViewHeight(@NotNull View view, int i11, int i12, @NotNull AnimationSpeed animationSpeed) {
        AnimationHelper.DefaultImpls.adjustViewHeight(this, view, i11, i12, animationSpeed);
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    public void failureHere(@Nullable Failure failure) {
        hideProgress();
    }

    @NotNull
    public final ConfigurationLocalCoreLibApi getConfigurationLocalCoreLibApi() {
        ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2 = this.configurationLocalCoreLibApi;
        if (configurationLocalCoreLibApi2 != null) {
            return configurationLocalCoreLibApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalCoreLibApi");
        return null;
    }

    @NotNull
    public final DeepLinkNavigator getDeepLinkNavigator() {
        DeepLinkNavigator deepLinkNavigator2 = this.deepLinkNavigator;
        if (deepLinkNavigator2 != null) {
            return deepLinkNavigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkNavigator");
        return null;
    }

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlagRepo() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlagRepo;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagRepo");
        return null;
    }

    @NotNull
    public final IHelpCenterDeeplinkBuilder getHelpCenterDeeplinkBuilder() {
        IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder = this.helpCenterDeeplinkBuilder;
        if (iHelpCenterDeeplinkBuilder != null) {
            return iHelpCenterDeeplinkBuilder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("helpCenterDeeplinkBuilder");
        return null;
    }

    @NotNull
    public Class<VendorsListViewModel> getViewModelClass() {
        return VendorsListViewModel.class;
    }

    public int layoutId() {
        return R.layout.frag_layout_vendors;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((VendorsListViewModel) getViewModel()).getVendorListData(), new VendorsListFragment$observatory$1(this));
        LifecycleKt.observe(this, ((VendorsListViewModel) getViewModel()).getVendorAreasListData(), new VendorsListFragment$observatory$2(this));
        LifecycleKt.observe(this, ((VendorsListViewModel) getViewModel()).getFilterButtonLiveData(), new VendorsListFragment$observatory$3(this));
        LifecycleKt.observe(this, ((VendorsListViewModel) getViewModel()).getCuisineButtonLiveData(), new VendorsListFragment$observatory$4(this));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        DaggerVendorsListFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DeepLinkCoreLibApi.class), (HelpCenterFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(HelpCenterFeatureApi.class)).inject(this);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onPause() {
        super.onPause();
        LocationHelper locationHelper2 = this.locationHelper;
        if (locationHelper2 != null) {
            locationHelper2.onPause();
        }
    }

    public void onRequestPermissionsResult(int i11, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i11, strArr, iArr);
        LocationHelper locationHelper2 = this.locationHelper;
        if (locationHelper2 != null) {
            locationHelper2.onRequestPermissionsResult(i11, strArr, iArr);
        }
    }

    public void onResume() {
        super.onResume();
        askLocationPermissionIfNeeded();
        k(this, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, 255, (Object) null);
        LocationHelper locationHelper2 = this.locationHelper;
        if (locationHelper2 != null) {
            locationHelper2.onResume();
        }
    }

    @RequiresApi(20)
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setStatusBarHeight(view);
        initLocationListening();
        setupUI();
    }

    public final void setConfigurationLocalCoreLibApi(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
        Intrinsics.checkNotNullParameter(configurationLocalCoreLibApi2, "<set-?>");
        this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    public final void setHelpCenterDeeplinkBuilder(@NotNull IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder) {
        Intrinsics.checkNotNullParameter(iHelpCenterDeeplinkBuilder, "<set-?>");
        this.helpCenterDeeplinkBuilder = iHelpCenterDeeplinkBuilder;
    }

    @NotNull
    public VendorsListViewModelImpl viewModelBuilder() {
        VendorsListViewModelBuilder.Companion companion = VendorsListViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getVendorListViewModel(requireContext, getCoroutineScope(), getConfigurationLocalCoreLibApi().getRepository());
    }
}
