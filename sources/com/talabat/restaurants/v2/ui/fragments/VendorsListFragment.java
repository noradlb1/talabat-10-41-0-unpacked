package com.talabat.restaurants.v2.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.annotation.VisibleForTesting;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.customerchat.eventTracking.constants.EventDetailsKeys;
import com.talabat.R;
import com.talabat.adapters.restaurantslist.OnRestaurantClick;
import com.talabat.adapters.restaurantslist.RestaurantsListAdapterRefactor;
import com.talabat.adapters.restaurantslist.viewholders.ToggleHeaderViewHolder;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.pharmacy.presentation.ui.fragment.PrescriptionFragment;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionViewHolder;
import com.talabat.helpers.FreshVerticalSpaceItemDecoration;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.impressions.BatchImpressionTracker;
import com.talabat.impressions.ImpressionRecordable;
import com.talabat.impressions.ImpressionsIntegrationKt;
import com.talabat.observability.tracker.TimeTrackerImplementation;
import com.talabat.observability.tracker.TimeTrackerKt;
import com.talabat.restaurants.OnAllRestaurantsLoadedAnalytics;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import com.talabat.restaurants.inlineads.RxAdLoader;
import com.talabat.restaurants.inlineads.data.InlineAdsApi;
import com.talabat.restaurants.inlineads.data.InlineAdsRepositoryImpl;
import com.talabat.restaurants.v2.data.vendors.FilterParamsRepository;
import com.talabat.restaurants.v2.di.DaggerVendorsListFragmentComponent;
import com.talabat.restaurants.v2.domain.swimlane.GetDisplayFeatureProductsUseCase;
import com.talabat.restaurants.v2.domain.vendors.GetInlineAdsUseCase;
import com.talabat.restaurants.v2.domain.vendors.GetVendorsUseCase;
import com.talabat.restaurants.v2.domain.vendors.PagedUsedCase;
import com.talabat.restaurants.v2.domain.vendors.PagedUsedCaseImpl;
import com.talabat.restaurants.v2.domain.vendors.RequestVendorsUseCase;
import com.talabat.restaurants.v2.domain.vendors.ShouldUsePolygonApiUseCase;
import com.talabat.restaurants.v2.ui.adapters.viewholders.FeatureProductItemViewHolder;
import com.talabat.restaurants.v2.ui.adapters.viewholders.FeatureProductListViewHolder;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductDisplayModel;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductListDisplayModel;
import com.talabat.restaurants.v2.ui.viewmodels.FeatureProductTracker;
import com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged;
import com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import com.talabat.wrapper.EventWrapper;
import datamodels.Restaurant;
import datamodels.RestaurantListItemModel;
import datamodels.Strategy;
import datamodels.Swimlane;
import io.reactivex.Scheduler;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import library.talabat.SharedPreferencesManager;
import library.talabat.inlineadsengine.AdsWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import st.a;
import tracking.AppTracker;
import tracking.gtm.RestaurantsEventsKt;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000Ï\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000f*\u0001^\u0018\u0000 u2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0001uB\u000f\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010)\u001a\u00020\u0002J\u001e\u0010*\u001a\u00020+2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\rH\u0002J\u0006\u0010-\u001a\u00020+J\b\u0010.\u001a\u00020+H\u0016J\u0012\u0010/\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00102\u001a\u00020+2\u0006\u00103\u001a\u000204H\u0016J \u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u000209H\u0016J \u0010:\u001a\u00020+2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u000209H\u0016J\u000e\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00020<H\u0016J\b\u0010=\u001a\u00020+H\u0002J\u000e\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020@J\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020BH\u0002J\b\u0010F\u001a\u00020\nH\u0016J\b\u0010G\u001a\u00020+H\u0016J\b\u0010H\u001a\u00020+H\u0016J\u0010\u0010I\u001a\u00020+2\u0006\u0010J\u001a\u00020KH\u0016J\u001a\u0010L\u001a\u00020+2\b\u0010M\u001a\u0004\u0018\u00010N2\u0006\u00106\u001a\u00020\nH\u0016J\u001a\u0010O\u001a\u00020+2\b\u0010P\u001a\u0004\u0018\u00010N2\u0006\u00106\u001a\u00020\nH\u0016J\u0012\u0010O\u001a\u00020+2\b\u0010Q\u001a\u0004\u0018\u00010@H\u0016J\b\u0010R\u001a\u00020+H\u0016J\u001a\u0010S\u001a\u00020+2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u00106\u001a\u00020\nH\u0016J\b\u0010V\u001a\u00020+H\u0016J\b\u0010W\u001a\u00020+H\u0002J\u001a\u0010X\u001a\u00020+2\u0006\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\r\u0010]\u001a\u00020^H\u0002¢\u0006\u0002\u0010_J\b\u0010`\u001a\u00020+H\u0002J\u000e\u0010a\u001a\u00020+2\u0006\u00108\u001a\u000209J*\u0010b\u001a\u00020+2 \u0010,\u001a\u001c\u0012\u0004\u0012\u00020N\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020N0c\u0018\u00010\rH\u0002J\b\u0010d\u001a\u00020+H\u0002J\u0016\u0010e\u001a\u00020+2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u000e0gH\u0002J\b\u0010h\u001a\u00020+H\u0002J\u0017\u0010i\u001a\u00020+2\b\u0010j\u001a\u0004\u0018\u00010BH\u0002¢\u0006\u0002\u0010kJ\u0017\u0010l\u001a\u00020+2\b\u0010j\u001a\u0004\u0018\u00010BH\u0002¢\u0006\u0002\u0010kJ\b\u0010m\u001a\u00020+H\u0002J\u0018\u0010n\u001a\u00020+2\u000e\u0010o\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010gH\u0002J\u0018\u0010p\u001a\u00020+2\u000e\u0010o\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010gH\u0002J4\u0010q\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020U0\r0g2\u0018\u0010r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\r0gH\u0007J\u0006\u0010s\u001a\u00020+J\b\u0010t\u001a\u00020\u0002H\u0016R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006v"}, d2 = {"Lcom/talabat/restaurants/v2/ui/fragments/VendorsListFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/restaurants/v2/ui/viewmodels/VendorsListFragmentViewModel;", "Lcom/talabat/adapters/restaurantslist/OnRestaurantClick;", "Lcom/talabat/adapters/restaurantslist/viewholders/ToggleHeaderViewHolder$OnHeaderToggleClickListener;", "Lcom/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductItemViewHolder$OnFeatureProductClick;", "Lcom/talabat/adapters/restaurantslist/RestaurantsListAdapterRefactor$OnFeatureProductAppeared;", "Lcom/talabat/restaurants/v2/ui/adapters/viewholders/FeatureProductListViewHolder$OnFeatureProductShown;", "Lcom/talabat/feature/rewards/presentation/mission/RewardsMissionViewHolder$OnMissionUpdated;", "verticalId", "", "(I)V", "featureProductsSwimlane", "Lkotlin/Pair;", "Ldatamodels/RestaurantListItemModel;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "timeTracker", "Lcom/talabat/observability/tracker/TimeTrackerImplementation;", "getTimeTracker", "()Lcom/talabat/observability/tracker/TimeTrackerImplementation;", "setTimeTracker", "(Lcom/talabat/observability/tracker/TimeTrackerImplementation;)V", "vendorsListAdapter", "Lcom/talabat/adapters/restaurantslist/RestaurantsListAdapterRefactor;", "getVendorsListAdapter", "()Lcom/talabat/adapters/restaurantslist/RestaurantsListAdapterRefactor;", "vendorsListAdapter$delegate", "Lkotlin/Lazy;", "getVerticalId", "()I", "accessViewModel", "addInlineAd", "", "pair", "cancelInlineAdSubscription", "cardViewClicked", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "featureProductAppeared", "featuredProducts", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductListDisplayModel;", "featureProductClick", "position", "listSize", "featureProduct", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "featureProductShown", "getViewModelClass", "Ljava/lang/Class;", "initRecyclerView", "insertInlineAd", "adsWrapper", "Llibrary/talabat/inlineadsengine/AdsWrapper;", "isFPSwimlaneVisible", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isPaginationOn", "layoutId", "listViewClicked", "observatory", "onAttach", "context", "Landroid/content/Context;", "onInlineAdsAppeared", "adsLink", "", "onInlineAdsClick", "adLink", "ad", "onMissionUpdated", "onRestaurantClick", "restaurant", "Ldatamodels/Restaurant;", "onResume", "onShakeImage", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "recyclerScrollListener", "com/talabat/restaurants/v2/ui/fragments/VendorsListFragment$recyclerScrollListener$1", "()Lcom/talabat/restaurants/v2/ui/fragments/VendorsListFragment$recyclerScrollListener$1;", "restoreScrollPositionAfterAdAdded", "selectItem", "sendEvent", "", "sendLayoutFinishedTrack", "setFeatureProductsSwimlane", "items", "", "setRecyclerViewAdapter", "showLoading", "show", "(Ljava/lang/Boolean;)V", "showNoResult", "showPrescriptionCard", "showVendors", "list", "trackShopListExpandedImpressions", "updatePositionByVendorNaturalOrder", "pairs", "updateVendorList", "viewModelBuilder", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListFragment extends BaseFragment implements OnRestaurantClick, ToggleHeaderViewHolder.OnHeaderToggleClickListener, FeatureProductItemViewHolder.OnFeatureProductClick, RestaurantsListAdapterRefactor.OnFeatureProductAppeared, FeatureProductListViewHolder.OnFeatureProductShown, RewardsMissionViewHolder.OnMissionUpdated {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String PRESCRIPTION_CARD = "prescriptionCard";
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    /* access modifiers changed from: private */
    @Nullable
    public Pair<Integer, ? extends RestaurantListItemModel> featureProductsSwimlane;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private TimeTrackerImplementation timeTracker;
    @NotNull
    private final Lazy vendorsListAdapter$delegate;
    private final int verticalId;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/restaurants/v2/ui/fragments/VendorsListFragment$Companion;", "", "()V", "PRESCRIPTION_CARD", "", "getInstance", "Lcom/talabat/restaurants/v2/ui/fragments/VendorsListFragment;", "verticalId", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final VendorsListFragment getInstance(int i11) {
            return new VendorsListFragment(i11);
        }
    }

    public VendorsListFragment() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public VendorsListFragment(int i11) {
        this._$_findViewCache = new LinkedHashMap();
        this.verticalId = i11;
        this.timeTracker = TimeTrackerKt.getTimeTracker();
        this.vendorsListAdapter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new VendorsListFragment$vendorsListAdapter$2(this));
    }

    public static final /* synthetic */ VendorsListFragmentViewModel access$getViewModel(VendorsListFragment vendorsListFragment) {
        return (VendorsListFragmentViewModel) vendorsListFragment.getViewModel();
    }

    /* access modifiers changed from: private */
    public final void addInlineAd(Pair<? extends RestaurantListItemModel, Integer> pair) {
        if (pair != null) {
            if (pair.getSecond().intValue() == 0) {
                restoreScrollPositionAfterAdAdded();
            }
            getVendorsListAdapter().insertItem((RestaurantListItemModel) pair.getFirst(), pair.getSecond().intValue());
        }
    }

    @JvmStatic
    @NotNull
    public static final VendorsListFragment getInstance(int i11) {
        return Companion.getInstance(i11);
    }

    /* access modifiers changed from: private */
    public final RestaurantsListAdapterRefactor getVendorsListAdapter() {
        return (RestaurantsListAdapterRefactor) this.vendorsListAdapter$delegate.getValue();
    }

    private final void initRecyclerView() {
        int i11 = R.id.recyclerView_restaurantsList;
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new LinearLayoutManager(getActivity()));
        ((RecyclerView) _$_findCachedViewById(i11)).setBackgroundColor(getResources().getColor(R.color.white));
        ((RecyclerView) _$_findCachedViewById(i11)).addItemDecoration(new FreshVerticalSpaceItemDecoration(getResources(), false));
        ((RecyclerView) _$_findCachedViewById(i11)).addOnScrollListener(recyclerScrollListener());
        setRecyclerViewAdapter();
        sendLayoutFinishedTrack();
    }

    /* access modifiers changed from: private */
    public final boolean isFPSwimlaneVisible(RecyclerView recyclerView) {
        Integer num;
        if (this.featureProductsSwimlane == null) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition == -1 || findLastCompletelyVisibleItemPosition == -1) {
                return false;
            }
            IntRange intRange = new IntRange(findFirstCompletelyVisibleItemPosition, findLastCompletelyVisibleItemPosition);
            Pair<Integer, ? extends RestaurantListItemModel> pair = this.featureProductsSwimlane;
            if (pair != null) {
                num = pair.getFirst();
            } else {
                num = null;
            }
            if (num == null || !intRange.contains(num.intValue())) {
                return false;
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    private final boolean isPaginationOn() {
        return this.verticalId == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: observatory$lambda-1  reason: not valid java name */
    public static final void m10757observatory$lambda1(VendorsListFragment vendorsListFragment, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        if (((Unit) eventWrapper.getContentIfNotHandled()) != null) {
            vendorsListFragment.showPrescriptionCard();
        }
    }

    private final void onShakeImage() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(activity, …labatcommon.R.anim.shake)");
        ((ImageView) _$_findCachedViewById(R.id.imageView_noRestaurants)).setAnimation(loadAnimation);
    }

    private final VendorsListFragment$recyclerScrollListener$1 recyclerScrollListener() {
        return new VendorsListFragment$recyclerScrollListener$1(this);
    }

    private final void restoreScrollPositionAfterAdAdded() {
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) _$_findCachedViewById(R.id.recyclerView_restaurantsList)).getLayoutManager();
        if (layoutManager != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager.findFirstVisibleItemPosition() == 0) {
                linearLayoutManager.scrollToPosition(0);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    /* access modifiers changed from: private */
    public final void sendEvent(Pair<String, ? extends Map<String, String>> pair) {
        Context context = getContext();
        if (context != null && pair != null) {
            TalabatGTM.Companion.trackEvent(context, pair.getFirst(), (Map) pair.getSecond());
        }
    }

    private final void sendLayoutFinishedTrack() {
        ViewTreeObserver viewTreeObserver;
        VendorsListFragment$sendLayoutFinishedTrack$layoutListener$1 vendorsListFragment$sendLayoutFinishedTrack$layoutListener$1 = new VendorsListFragment$sendLayoutFinishedTrack$layoutListener$1(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.recyclerView_restaurantsList);
        if (recyclerView != null && (viewTreeObserver = recyclerView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(vendorsListFragment$sendLayoutFinishedTrack$layoutListener$1);
        }
    }

    /* access modifiers changed from: private */
    public final void setFeatureProductsSwimlane(List<? extends RestaurantListItemModel> list) {
        int i11 = 0;
        for (Object next : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            RestaurantListItemModel restaurantListItemModel = (RestaurantListItemModel) next;
            if (restaurantListItemModel.type == 14) {
                this.featureProductsSwimlane = new Pair<>(Integer.valueOf(i11), restaurantListItemModel);
            }
            i11 = i12;
        }
    }

    private final void setRecyclerViewAdapter() {
        ((RecyclerView) _$_findCachedViewById(R.id.recyclerView_restaurantsList)).setAdapter(getVendorsListAdapter());
        getVendorsListAdapter().setClickListener(this);
        getVendorsListAdapter().setHeaderToggleClickListener(this);
        getVendorsListAdapter().setFeatureProductClickListener(this);
        getVendorsListAdapter().setFeatureProductShownListener(this);
        getVendorsListAdapter().setFeatureProductImpressionListener(this);
        getVendorsListAdapter().setOnMissionUpdatedListener(this);
        getVendorsListAdapter().setIsTgoStyle(SharedPreferencesManager.getInstance(getActivity()).isCardViewFavStyle(Boolean.FALSE));
    }

    /* access modifiers changed from: private */
    public final void showLoading(Boolean bool) {
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            _$_findCachedViewById(R.id.progressShimmer).setVisibility(0);
        } else {
            _$_findCachedViewById(R.id.progressShimmer).setVisibility(8);
        }
    }

    /* JADX WARNING: type inference failed for: r6v10, types: [androidx.fragment.app.FragmentActivity] */
    /* JADX WARNING: type inference failed for: r6v22, types: [androidx.fragment.app.FragmentActivity] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showNoResult(java.lang.Boolean r6) {
        /*
            r5 = this;
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
            r0 = 0
            r1 = 8
            r2 = 0
            if (r6 == 0) goto L_0x004d
            int r6 = com.talabat.R.id.recyclerView_restaurantsList
            android.view.View r6 = r5._$_findCachedViewById(r6)
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            r6.setVisibility(r1)
            int r6 = com.talabat.R.id.scrollView_noRestaurantsContainer
            android.view.View r6 = r5._$_findCachedViewById(r6)
            androidx.core.widget.NestedScrollView r6 = (androidx.core.widget.NestedScrollView) r6
            r6.setVisibility(r0)
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            if (r6 == 0) goto L_0x0049
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            boolean r0 = r6 instanceof com.talabat.restaurants.RestaurantsListScreenRefactor
            if (r0 == 0) goto L_0x0033
            com.talabat.restaurants.RestaurantsListScreenRefactor r6 = (com.talabat.restaurants.RestaurantsListScreenRefactor) r6
            goto L_0x0034
        L_0x0033:
            r6 = r2
        L_0x0034:
            if (r6 == 0) goto L_0x0039
            r6.disableSerchView()
        L_0x0039:
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            boolean r0 = r6 instanceof com.talabat.restaurants.RestaurantsListScreenRefactor
            if (r0 == 0) goto L_0x0044
            r2 = r6
            com.talabat.restaurants.RestaurantsListScreenRefactor r2 = (com.talabat.restaurants.RestaurantsListScreenRefactor) r2
        L_0x0044:
            if (r2 == 0) goto L_0x0049
            r2.hideDarkStore()
        L_0x0049:
            r5.onShakeImage()
            goto L_0x009a
        L_0x004d:
            int r6 = com.talabat.R.id.recyclerView_restaurantsList
            android.view.View r3 = r5._$_findCachedViewById(r6)
            androidx.recyclerview.widget.RecyclerView r3 = (androidx.recyclerview.widget.RecyclerView) r3
            if (r3 == 0) goto L_0x009a
            int r3 = com.talabat.R.id.scrollView_noRestaurantsContainer
            android.view.View r4 = r5._$_findCachedViewById(r3)
            androidx.core.widget.NestedScrollView r4 = (androidx.core.widget.NestedScrollView) r4
            if (r4 == 0) goto L_0x009a
            android.view.View r6 = r5._$_findCachedViewById(r6)
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            r6.setVisibility(r0)
            android.view.View r6 = r5._$_findCachedViewById(r3)
            androidx.core.widget.NestedScrollView r6 = (androidx.core.widget.NestedScrollView) r6
            r6.setVisibility(r1)
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            if (r6 == 0) goto L_0x009a
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            boolean r0 = r6 instanceof com.talabat.restaurants.RestaurantsListScreenRefactor
            if (r0 == 0) goto L_0x0084
            com.talabat.restaurants.RestaurantsListScreenRefactor r6 = (com.talabat.restaurants.RestaurantsListScreenRefactor) r6
            goto L_0x0085
        L_0x0084:
            r6 = r2
        L_0x0085:
            if (r6 == 0) goto L_0x008a
            r6.enableSerchView()
        L_0x008a:
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            boolean r0 = r6 instanceof com.talabat.restaurants.RestaurantsListScreenRefactor
            if (r0 == 0) goto L_0x0095
            r2 = r6
            com.talabat.restaurants.RestaurantsListScreenRefactor r2 = (com.talabat.restaurants.RestaurantsListScreenRefactor) r2
        L_0x0095:
            if (r2 == 0) goto L_0x009a
            r2.showDarkStore()
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.v2.ui.fragments.VendorsListFragment.showNoResult(java.lang.Boolean):void");
    }

    private final void showPrescriptionCard() {
        PrescriptionFragment instance = PrescriptionFragment.Companion.getInstance();
        if (!instance.isAdded()) {
            getParentFragmentManager().beginTransaction().replace((int) R.id.prescription_fragment_container, (Fragment) instance, PRESCRIPTION_CARD).commit();
        }
    }

    /* access modifiers changed from: private */
    public final void showVendors(List<? extends RestaurantListItemModel> list) {
        getVendorsListAdapter().setRestaurantsListModels(list);
        trackShopListExpandedImpressions(list);
        ((RecyclerView) _$_findCachedViewById(R.id.recyclerView_restaurantsList)).setVisibility(0);
        ((NestedScrollView) _$_findCachedViewById(R.id.scrollView_noRestaurantsContainer)).setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void trackShopListExpandedImpressions(List<? extends RestaurantListItemModel> list) {
        RestaurantsListScreenRefactor restaurantsListScreenRefactor;
        FragmentActivity activity = getActivity();
        String str = null;
        if (activity instanceof RestaurantsListScreenRefactor) {
            restaurantsListScreenRefactor = (RestaurantsListScreenRefactor) activity;
        } else {
            restaurantsListScreenRefactor = null;
        }
        if (restaurantsListScreenRefactor != null) {
            str = restaurantsListScreenRefactor.getListingPage();
        }
        int i11 = R.id.recyclerView_restaurantsList;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView_restaurantsList");
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(i11);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ImpressionsIntegrationKt.trackImpressionsExclusively(recyclerView, new BatchImpressionTracker(recyclerView2, list, 5, new VendorsListFragment$trackShopListExpandedImpressions$1(this, str), (ImpressionRecordable) null, 16, (DefaultConstructorMarker) null));
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

    @NotNull
    public final VendorsListFragmentViewModel accessViewModel() {
        return (VendorsListFragmentViewModel) getViewModel();
    }

    public final void cancelInlineAdSubscription() {
        ((VendorsListFragmentViewModel) getViewModel()).getInlineAdDisposable().dispose();
    }

    public void cardViewClicked() {
        RestaurantsListScreenRefactor restaurantsListScreenRefactor = (RestaurantsListScreenRefactor) getActivity();
        if (restaurantsListScreenRefactor != null) {
            restaurantsListScreenRefactor.GaOnRestaurantListUpdated(EventDetailsKeys.CALL_BUTTONS_TOGGLE);
        }
        SharedPreferencesManager.getInstance(getActivity()).setIsCardViewFavStyle(true);
        getVendorsListAdapter().setIsTgoStyle(true);
    }

    public void failureHere(@Nullable Failure failure) {
    }

    public void featureProductAppeared(@NotNull FeatureProductListDisplayModel featureProductListDisplayModel) {
        Intrinsics.checkNotNullParameter(featureProductListDisplayModel, "featuredProducts");
        ((VendorsListFragmentViewModel) getViewModel()).sendFeatureProductsAppearedEvent(featureProductListDisplayModel);
    }

    public void featureProductClick(int i11, int i12, @NotNull FeatureProductDisplayModel featureProductDisplayModel) {
        Intrinsics.checkNotNullParameter(featureProductDisplayModel, "featureProduct");
        GlobalDataModel.SELECTED.updateRestaurant(featureProductDisplayModel.getVendor());
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        if (restaurant != null) {
            restaurant.itemPosition = i11;
        }
        GlobalDataModel.ShopClickOrigin = "swimlane_item";
        Pair<Integer, ? extends RestaurantListItemModel> pair = this.featureProductsSwimlane;
        if (pair != null) {
            GlobalDataModel.SelectedSwimlane = new Swimlane((String) null, (String) null, pair.getFirst().intValue(), (Strategy) null, (ArrayList) null, 27, (DefaultConstructorMarker) null);
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        String str = GlobalDataModel.ShopClickOrigin;
        Intrinsics.checkNotNullExpressionValue(str, "ShopClickOrigin");
        ((VendorsListFragmentViewModel) getViewModel()).sendFeatureProductClickEvent(requireContext, i11, i12, str, featureProductDisplayModel);
        selectItem(featureProductDisplayModel);
    }

    public void featureProductShown(int i11, int i12, @NotNull FeatureProductDisplayModel featureProductDisplayModel) {
        Intrinsics.checkNotNullParameter(featureProductDisplayModel, "featureProduct");
        ((VendorsListFragmentViewModel) getViewModel()).sendFeatureProductImpressionEvent(i11, i12, featureProductDisplayModel);
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
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatFeatureFlag");
        return null;
    }

    @NotNull
    public final TimeTrackerImplementation getTimeTracker() {
        return this.timeTracker;
    }

    public final int getVerticalId() {
        return this.verticalId;
    }

    @NotNull
    public Class<VendorsListFragmentViewModel> getViewModelClass() {
        return VendorsListFragmentViewModel.class;
    }

    public final void insertInlineAd(@NotNull AdsWrapper adsWrapper) {
        Intrinsics.checkNotNullParameter(adsWrapper, "adsWrapper");
        ((VendorsListFragmentViewModel) getViewModel()).insertInlineAds(adsWrapper);
    }

    public int layoutId() {
        return R.layout.fragment_restaurnts_list;
    }

    public void listViewClicked() {
        RestaurantsListScreenRefactor restaurantsListScreenRefactor = (RestaurantsListScreenRefactor) getActivity();
        if (restaurantsListScreenRefactor != null) {
            restaurantsListScreenRefactor.GaOnRestaurantListUpdated(EventDetailsKeys.CALL_BUTTONS_TOGGLE);
        }
        SharedPreferencesManager.getInstance(getActivity()).setIsCardViewFavStyle(false);
        getVendorsListAdapter().setIsTgoStyle(false);
    }

    public void observatory() {
        LifecycleKt.observe(this, ((VendorsListFragmentViewModel) getViewModel()).getShowNoResult(), new VendorsListFragment$observatory$1(this));
        LifecycleKt.observe(this, ((VendorsListFragmentViewModel) getViewModel()).getVendorList(), new VendorsListFragment$observatory$2(this));
        LifecycleKt.observe(this, ((VendorsListFragmentViewModel) getViewModel()).getSendEvent(), new VendorsListFragment$observatory$3(this));
        LifecycleKt.observe(this, ((VendorsListFragmentViewModel) getViewModel()).getInlineAds(), new VendorsListFragment$observatory$4(this));
        LifecycleKt.observe(this, ((VendorsListFragmentViewModel) getViewModel()).getVendorsSwimlanes(), new VendorsListFragment$observatory$5(this));
        LifecycleKt.observe(this, ((VendorsListFragmentViewModel) getViewModel()).getLoading(), new VendorsListFragment$observatory$6(this));
        ((VendorsListFragmentViewModel) getViewModel()).getShowPharmacyPrescription().observe(this, new a(this));
        if (isPaginationOn()) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new VendorsListFragment$observatory$8(this, (Continuation<? super VendorsListFragment$observatory$8>) null), 3, (Object) null);
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new VendorsListFragment$observatory$9(this, (Continuation<? super VendorsListFragment$observatory$9>) null), 3, (Object) null);
            getVendorsListAdapter().addLoadStateListener(new VendorsListFragment$observatory$10(this));
        }
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        DaggerVendorsListFragmentComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onInlineAdsAppeared(@Nullable String str, int i11) {
        RestaurantsListScreenRefactor restaurantsListScreenRefactor = (RestaurantsListScreenRefactor) getActivity();
        if (restaurantsListScreenRefactor != null) {
            restaurantsListScreenRefactor.onInlineAdsAppeard(str, i11);
        }
    }

    public void onInlineAdsClick(@Nullable String str, int i11) {
        RestaurantsListScreenRefactor restaurantsListScreenRefactor = (RestaurantsListScreenRefactor) getActivity();
        if (restaurantsListScreenRefactor != null) {
            restaurantsListScreenRefactor.onInlineAdsClick(str, i11);
        }
    }

    public void onMissionUpdated() {
        PagedUsedCaseImpl.CachedFirstPage.clearCache();
        updateVendorList();
    }

    public void onRestaurantClick(@Nullable Restaurant restaurant, int i11) {
        AppTracker.onRestaurantClicked(getActivity(), TalabatGTM.Companion.restaurantType(restaurant), restaurant);
        RestaurantsListScreenRefactor restaurantsListScreenRefactor = (RestaurantsListScreenRefactor) getActivity();
        if (restaurantsListScreenRefactor != null) {
            restaurantsListScreenRefactor.selectRestaurant(restaurant);
        }
    }

    public void onResume() {
        super.onResume();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.recyclerView_restaurantsList);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView_restaurantsList");
        if (isFPSwimlaneVisible(recyclerView)) {
            getVendorsListAdapter().enableFeatureProductTracking();
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (getActivity() instanceof RestaurantsListScreenRefactor) {
            OnAllRestaurantsLoadedAnalytics onAllRestaurantsLoadedAnalytics = new OnAllRestaurantsLoadedAnalytics();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                onAllRestaurantsLoadedAnalytics.accept((RestaurantsListScreenRefactor) activity);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.restaurants.RestaurantsListScreenRefactor");
            }
        }
        initRecyclerView();
        updateVendorList();
    }

    public final void selectItem(@NotNull FeatureProductDisplayModel featureProductDisplayModel) {
        Intrinsics.checkNotNullParameter(featureProductDisplayModel, "featureProduct");
        Restaurant vendor = featureProductDisplayModel.getVendor();
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity$default(OPNavigatorActions.Companion, vendor.branchId, vendor.shopType, vendor.isGlrEnabled, vendor.isDarkStore, vendor.isMigrated, false, String.valueOf(featureProductDisplayModel.getItemId()), (Bundle) null, 128, (Object) null));
        }
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public final void setTimeTracker(@NotNull TimeTrackerImplementation timeTrackerImplementation) {
        Intrinsics.checkNotNullParameter(timeTrackerImplementation, "<set-?>");
        this.timeTracker = timeTrackerImplementation;
    }

    @NotNull
    @VisibleForTesting
    public final List<Pair<Integer, Restaurant>> updatePositionByVendorNaturalOrder(@NotNull List<? extends Pair<Integer, ? extends RestaurantListItemModel>> list) {
        int i11;
        Restaurant restaurant;
        Restaurant restaurant2;
        Intrinsics.checkNotNullParameter(list, "pairs");
        Iterable<Pair> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Pair pair : iterable) {
            RestaurantListItemModel restaurantListItemModel = (RestaurantListItemModel) pair.getSecond();
            if (restaurantListItemModel == null || (restaurant2 = restaurantListItemModel.restaurant) == null) {
                i11 = ((Number) pair.getFirst()).intValue();
            } else {
                i11 = restaurant2.itemPosition;
            }
            Integer valueOf = Integer.valueOf(i11);
            RestaurantListItemModel restaurantListItemModel2 = (RestaurantListItemModel) pair.getSecond();
            if (restaurantListItemModel2 != null) {
                restaurant = restaurantListItemModel2.restaurant;
            } else {
                restaurant = null;
            }
            if (restaurant == null) {
                restaurant = new Restaurant();
            }
            arrayList.add(new Pair(valueOf, restaurant));
        }
        return arrayList;
    }

    public final void updateVendorList() {
        this.featureProductsSwimlane = null;
        ((VendorsListFragmentViewModel) getViewModel()).loadVendorList(this.verticalId);
        if (isPaginationOn()) {
            getVendorsListAdapter().refresh();
        }
    }

    public void onInlineAdsClick(@Nullable AdsWrapper adsWrapper) {
        Restaurant restaurant;
        if (adsWrapper != null && (restaurant = adsWrapper.getRestaurant()) != null) {
            RestaurantsEventsKt.clearSponsoringData(restaurant);
            RestaurantsListScreenRefactor restaurantsListScreenRefactor = (RestaurantsListScreenRefactor) getActivity();
            if (restaurantsListScreenRefactor != null) {
                restaurantsListScreenRefactor.selectRestaurant(restaurant);
            }
        }
    }

    @NotNull
    public VendorsListFragmentViewModel viewModelBuilder() {
        TalabatTracker talabatTracker = ((TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(TrackingCoreLibApi.class)).getTalabatTracker();
        ITalabatFeatureFlag talabatFeatureFlag2 = ((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag();
        GetVendorsUseCase getVendorsUseCase = new GetVendorsUseCase(getTalabatFeatureFlag(), new RequestVendorsUseCase((Function6) null, (Function5) null, new ShouldUsePolygonApiUseCase(getLocationConfigurationRepository(), (Function0) null, 2, (DefaultConstructorMarker) null), 3, (DefaultConstructorMarker) null));
        GetDisplayFeatureProductsUseCase getDisplayFeatureProductsUseCase = new GetDisplayFeatureProductsUseCase(getTalabatFeatureFlag(), (Function6) null, getVendorsUseCase, 2, (DefaultConstructorMarker) null);
        if (isPaginationOn()) {
            return new VendorListFragmentViewModelPaged(new RxAdLoader(getContext(), new InlineAdsRepositoryImpl((InlineAdsApi) null, 1, (DefaultConstructorMarker) null)), (FilterParamsRepository) null, (PagedUsedCase) null, (GetInlineAdsUseCase) null, (Scheduler) null, (Scheduler) null, talabatTracker, talabatFeatureFlag2, getVendorsUseCase, getDisplayFeatureProductsUseCase, 62, (DefaultConstructorMarker) null);
        }
        return new VendorsListFragmentViewModel(talabatFeatureFlag2, getVendorsUseCase, (Function6) null, getDisplayFeatureProductsUseCase, (FeatureProductTracker) null, (Function0) null, new RxAdLoader(getContext(), new InlineAdsRepositoryImpl((InlineAdsApi) null, 1, (DefaultConstructorMarker) null)), (Function0) null, (Function1) null, (Scheduler) null, (Scheduler) null, talabatTracker, 1972, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorsListFragment(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11);
    }
}
