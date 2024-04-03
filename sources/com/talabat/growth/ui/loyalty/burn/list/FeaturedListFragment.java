package com.talabat.growth.ui.loyalty.burn.list;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.ds_alert.DSAlert;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.screen.rewards.BurnOptionsScreen;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding;
import com.talabat.growth.R;
import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.BurnOptionsDetailsActivity;
import com.talabat.growth.ui.loyalty.burn.list.di.DaggerFeaturedListFragmentComponent;
import com.talabat.growth.ui.loyalty.burn.list.viewModel.FeaturedListViewModel;
import com.talabat.growth.ui.loyalty.burn.list.viewModel.FeaturedListViewModelBuilder;
import com.talabat.growth.ui.loyalty.burn.list.views.FeaturedListAdapter;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import ir.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0016\u0010!\u001a\u00020\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u001cH\u0016J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020\u001c2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u0002052\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0012\u00106\u001a\u00020\u001c2\b\u00107\u001a\u0004\u0018\u000108H\u0002J\b\u00109\u001a\u00020\u001cH\u0002J\b\u0010:\u001a\u00020\u001cH\u0002J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+H\u0002J\u0012\u0010<\u001a\u00020\u001c2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020(H\u0002J\b\u0010A\u001a\u00020\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006B"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/list/FeaturedListFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/growth/ui/loyalty/burn/list/viewModel/FeaturedListViewModel;", "()V", "bottomSheet", "Lcom/talabat/feature/rewards/presentation/DSBottomSheetFragmentWithoutPadding;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "featureFlagRepository", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepository", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepository", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "featuredListItemClickListener", "com/talabat/growth/ui/loyalty/burn/list/FeaturedListFragment$featuredListItemClickListener$1", "Lcom/talabat/growth/ui/loyalty/burn/list/FeaturedListFragment$featuredListItemClickListener$1;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "failureHere", "", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getBurnOptionsScreenData", "Lcom/talabat/core/navigation/domain/screen/rewards/BurnOptionsScreen$Data;", "getCategoryDetails", "burnItemDisplayModels", "", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "getViewModelClass", "Ljava/lang/Class;", "layoutId", "", "navigateToActivity", "burnOptionDetails", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetails;", "observatory", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "populateFeaturedList", "displayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;", "setupData", "setupUI", "showBottomSheet", "showBurnOptionDetails", "burnOptionDetailsTarget", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget;", "showNotEnoughPointsWarning", "points", "viewModelBuilder", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeaturedListFragment extends BaseFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private DSBottomSheetFragmentWithoutPadding bottomSheet;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public ITalabatFeatureFlag featureFlagRepository;
    @NotNull
    private final FeaturedListFragment$featuredListItemClickListener$1 featuredListItemClickListener = new FeaturedListFragment$featuredListItemClickListener$1(this);
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;

    public static final /* synthetic */ FeaturedListViewModel access$getViewModel(FeaturedListFragment featuredListFragment) {
        return (FeaturedListViewModel) featuredListFragment.getViewModel();
    }

    /* access modifiers changed from: private */
    public final BurnOptionsScreen.Data getBurnOptionsScreenData() {
        if (Build.VERSION.SDK_INT >= 33) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                return (BurnOptionsScreen.Data) arguments.getParcelable("navigatorData", BurnOptionsScreen.Data.class);
            }
            return null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            return (BurnOptionsScreen.Data) arguments2.getParcelable("navigatorData");
        }
        return null;
    }

    private final void getCategoryDetails(List<BurnItemDisplayModel> list) {
        if (Intrinsics.areEqual((Object) ((FeaturedListViewModel) getViewModel()).getCategoryId(), (Object) "0")) {
            BurnItemCategoryDisplayModel burnItemCategoryDisplayModel = new BurnItemCategoryDisplayModel();
            burnItemCategoryDisplayModel.setCategoryId(((FeaturedListViewModel) getViewModel()).getCategoryId());
            burnItemCategoryDisplayModel.setCategoryName(((FeaturedListViewModel) getViewModel()).getCategoryName());
            burnItemCategoryDisplayModel.setCategoryType(((FeaturedListViewModel) getViewModel()).getCategoryType());
            burnItemCategoryDisplayModel.setBurnItemsDisplayModel(list);
            ((FeaturedListViewModel) getViewModel()).setCategoryDetails(burnItemCategoryDisplayModel);
            return;
        }
        SafeLetKt.safeLet(((FeaturedListViewModel) getViewModel()).getCategoryId(), ((FeaturedListViewModel) getViewModel()).getCategoryType(), new FeaturedListFragment$getCategoryDetails$1(this));
    }

    private final void navigateToActivity(BurnOptionDetailsNavigator.BurnOptionDetails burnOptionDetails) {
        Context context = getContext();
        if (context != null) {
            BurnOptionsDetailsActivity.Companion.navigateToActivity(context, burnOptionDetails.getBurnItemDisplayModel(), burnOptionDetails.getTotalPoints(), burnOptionDetails.getPosition());
        }
    }

    /* access modifiers changed from: private */
    public final void populateFeaturedList(BurnItemCategoryDisplayModel burnItemCategoryDisplayModel) {
        hideProgress();
        if (burnItemCategoryDisplayModel != null) {
            ((RecyclerView) _$_findCachedViewById(R.id.featuredVouchersRecyclerView)).setAdapter(new FeaturedListAdapter(burnItemCategoryDisplayModel.getBurnItemsDisplayModel(), this.featuredListItemClickListener));
        }
    }

    private final void setupData() {
        String str;
        String str2;
        String str3;
        Integer num;
        List<Parcelable> burnItemsDisplayModel;
        BurnOptionsScreen.Data burnOptionsScreenData = getBurnOptionsScreenData();
        FeaturedListViewModel featuredListViewModel = (FeaturedListViewModel) getViewModel();
        List list = null;
        if (burnOptionsScreenData != null) {
            str = burnOptionsScreenData.getCategoryId();
        } else {
            str = null;
        }
        String str4 = "";
        if (str == null) {
            str = str4;
        }
        featuredListViewModel.setCategoryId(str);
        FeaturedListViewModel featuredListViewModel2 = (FeaturedListViewModel) getViewModel();
        if (burnOptionsScreenData != null) {
            str2 = burnOptionsScreenData.getCategoryName();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = str4;
        }
        featuredListViewModel2.setCategoryName(str2);
        ((TextView) _$_findCachedViewById(R.id.titleTextView)).setText(((FeaturedListViewModel) getViewModel()).getCategoryName());
        FeaturedListViewModel featuredListViewModel3 = (FeaturedListViewModel) getViewModel();
        if (burnOptionsScreenData != null) {
            str3 = burnOptionsScreenData.getCategoryType();
        } else {
            str3 = null;
        }
        if (str3 != null) {
            str4 = str3;
        }
        featuredListViewModel3.setCategoryType(str4);
        FeaturedListViewModel featuredListViewModel4 = (FeaturedListViewModel) getViewModel();
        if (burnOptionsScreenData != null) {
            num = Integer.valueOf(burnOptionsScreenData.getTotalPoints());
        } else {
            num = null;
        }
        featuredListViewModel4.setTotalPoints(IntKt.orZero(num));
        if (!(burnOptionsScreenData == null || (burnItemsDisplayModel = burnOptionsScreenData.getBurnItemsDisplayModel()) == null)) {
            list = new ArrayList();
            for (Object next : burnItemsDisplayModel) {
                if (next instanceof BurnItemDisplayModel) {
                    list.add(next);
                }
            }
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        getCategoryDetails(CollectionsKt___CollectionsKt.toMutableList(list));
    }

    private final void setupUI() {
        ((ImageButton) _$_findCachedViewById(R.id.backButton)).setOnClickListener(new a(this));
        Context context = getContext();
        if (context != null) {
            ((RecyclerView) _$_findCachedViewById(R.id.featuredVouchersRecyclerView)).setLayoutManager(new LinearLayoutManager(context));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setupUI$lambda-2  reason: not valid java name */
    public static final void m10602setupUI$lambda2(FeaturedListFragment featuredListFragment, View view) {
        Intrinsics.checkNotNullParameter(featuredListFragment, "this$0");
        FragmentActivity activity = featuredListFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private final void showBottomSheet(BurnOptionDetailsNavigator.BurnOptionDetails burnOptionDetails) {
        DSBottomSheetFragmentWithoutPadding dSBottomSheetFragmentWithoutPadding = this.bottomSheet;
        if (dSBottomSheetFragmentWithoutPadding != null) {
            BurnOptionsDetailsActivity.Companion companion = BurnOptionsDetailsActivity.Companion;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showBottomSheet(parentFragmentManager, dSBottomSheetFragmentWithoutPadding, burnOptionDetails.getBurnItemDisplayModel(), burnOptionDetails.getTotalPoints(), burnOptionDetails.getPosition());
        }
    }

    /* access modifiers changed from: private */
    public final void showBurnOptionDetails(BurnOptionDetailsNavigator.BurnOptionDetailsTarget burnOptionDetailsTarget) {
        if (burnOptionDetailsTarget instanceof BurnOptionDetailsNavigator.BurnOptionDetailsTarget.BottomSheet) {
            showBottomSheet(((BurnOptionDetailsNavigator.BurnOptionDetailsTarget.BottomSheet) burnOptionDetailsTarget).getDetails());
        } else if (burnOptionDetailsTarget instanceof BurnOptionDetailsNavigator.BurnOptionDetailsTarget.View) {
            navigateToActivity(((BurnOptionDetailsNavigator.BurnOptionDetailsTarget.View) burnOptionDetailsTarget).getDetails());
        } else if (burnOptionDetailsTarget instanceof BurnOptionDetailsNavigator.BurnOptionDetailsTarget.WarningNotEnoughPoints) {
            showNotEnoughPointsWarning(((BurnOptionDetailsNavigator.BurnOptionDetailsTarget.WarningNotEnoughPoints) burnOptionDetailsTarget).getPoints());
        }
    }

    private final void showNotEnoughPointsWarning(int i11) {
        Context context = getContext();
        if (context != null) {
            BurnOptionsDetailsActivity.Companion companion = BurnOptionsDetailsActivity.Companion;
            DSAlert dSAlert = (DSAlert) _$_findCachedViewById(R.id.dsAlert);
            Intrinsics.checkNotNullExpressionValue(dSAlert, "dsAlert");
            companion.showNotEnoughPointsWarning(context, dSAlert, i11);
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

    public void failureHere(@Nullable Failure failure) {
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
    }

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlagRepository() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlagRepository;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagRepository");
        return null;
    }

    @NotNull
    public final LocationConfigurationRepository getLocationConfigurationRepository() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        if (locationConfigurationRepository2 != null) {
            return locationConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationConfigurationRepository");
        return null;
    }

    @NotNull
    public Class<FeaturedListViewModel> getViewModelClass() {
        return FeaturedListViewModel.class;
    }

    public int layoutId() {
        return R.layout.frag_featured_list;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((FeaturedListViewModel) getViewModel()).getCategoryData(), new FeaturedListFragment$observatory$1(this));
        LifecycleKt.observe(this, ((FeaturedListViewModel) getViewModel()).getShowBurnOptionDetailsEvent(), new FeaturedListFragment$observatory$2(this));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerFeaturedListFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    public void onCreate(@Nullable Bundle bundle) {
        DSBottomSheetFragmentWithoutPadding dSBottomSheetFragmentWithoutPadding;
        super.onCreate(bundle);
        Fragment findFragmentByTag = getParentFragmentManager().findFragmentByTag(DSBottomSheetFragmentWithoutPadding.Companion.getTAG());
        if (findFragmentByTag instanceof DSBottomSheetFragmentWithoutPadding) {
            dSBottomSheetFragmentWithoutPadding = (DSBottomSheetFragmentWithoutPadding) findFragmentByTag;
        } else {
            dSBottomSheetFragmentWithoutPadding = null;
        }
        if (dSBottomSheetFragmentWithoutPadding == null) {
            dSBottomSheetFragmentWithoutPadding = new DSBottomSheetFragmentWithoutPadding();
        }
        this.bottomSheet = dSBottomSheetFragmentWithoutPadding;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupUI();
        setupData();
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setFeatureFlagRepository(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepository = iTalabatFeatureFlag;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    @NotNull
    public FeaturedListViewModel viewModelBuilder() {
        FeaturedListViewModelBuilder.Companion companion = FeaturedListViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getFeaturedListViewModel(requireContext, getCoroutineScope(), getFeatureFlagRepository(), getLocationConfigurationRepository());
    }
}
