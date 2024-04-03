package com.talabat.restaurants.v2.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.FreshVerticalSpaceItemDecoration;
import com.talabat.restaurants.v2.di.DaggerFavouritesRestaurantActivityComponent;
import com.talabat.restaurants.v2.ui.adapters.FavouriteRestaurantsAdapter;
import com.talabat.restaurants.v2.ui.viewmodels.FavouriteRestaurantsViewModel;
import com.talabat.talabatcommon.views.ShimmerLayout;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import datamodels.Restaurant;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qt.a;
import qt.b;
import qt.c;

@Instrumented
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\u0012\u0010$\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020\"H\u0014J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\"H\u0002J\u001e\u0010,\u001a\u00020\"2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020*0.2\u0006\u0010/\u001a\u000200H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u00061"}, d2 = {"Lcom/talabat/restaurants/v2/ui/activities/FavouriteRestaurantsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "loadingShimmer", "Lcom/talabat/talabatcommon/views/ShimmerLayout;", "mainContentContainer", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "noResultsContainer", "Landroid/widget/LinearLayout;", "restaurantListView", "Landroidx/recyclerview/widget/RecyclerView;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "getRxSchedulersFactory", "()Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "setRxSchedulersFactory", "(Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;)V", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "setTracker", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "viewModel", "Lcom/talabat/restaurants/v2/ui/viewmodels/FavouriteRestaurantsViewModel;", "getViewModel", "()Lcom/talabat/restaurants/v2/ui/viewmodels/FavouriteRestaurantsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initDagger", "", "observeAndLoadFavouriteList", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "selectRestaurant", "restaurant", "Ldatamodels/Restaurant;", "showNoResult", "showRestaurants", "restaurants", "", "isCardView", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FavouriteRestaurantsActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ShimmerLayout loadingShimmer;
    private CoordinatorLayout mainContentContainer;
    private LinearLayout noResultsContainer;
    private RecyclerView restaurantListView;
    @Inject
    public RxSchedulersFactory rxSchedulersFactory;
    private Toolbar toolbar;
    @Inject
    public TalabatTracker tracker;
    @NotNull
    private final Lazy viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new FavouriteRestaurantsActivity$viewModel$2(this));

    private final FavouriteRestaurantsViewModel getViewModel() {
        return (FavouriteRestaurantsViewModel) this.viewModel$delegate.getValue();
    }

    private final void initDagger() {
        DaggerFavouritesRestaurantActivityComponent.factory().create((TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(TrackingCoreLibApi.class), (DispatcherCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DispatcherCoreLibApi.class)).inject(this);
    }

    private final void observeAndLoadFavouriteList() {
        Disposable subscribe = getViewModel().getShowNoResult().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "viewModel.showNoResult.s… showNoResult()\n        }");
        DisposableKt.addTo(subscribe, this.compositeDisposable);
        Disposable subscribe2 = getViewModel().getShowRestaurants().subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "viewModel.showRestaurant…rst, it.second)\n        }");
        DisposableKt.addTo(subscribe2, this.compositeDisposable);
        getViewModel().loadFavouriteList();
    }

    /* access modifiers changed from: private */
    /* renamed from: observeAndLoadFavouriteList$lambda-1  reason: not valid java name */
    public static final void m10753observeAndLoadFavouriteList$lambda1(FavouriteRestaurantsActivity favouriteRestaurantsActivity, Unit unit) {
        Intrinsics.checkNotNullParameter(favouriteRestaurantsActivity, "this$0");
        favouriteRestaurantsActivity.showNoResult();
    }

    /* access modifiers changed from: private */
    /* renamed from: observeAndLoadFavouriteList$lambda-2  reason: not valid java name */
    public static final void m10754observeAndLoadFavouriteList$lambda2(FavouriteRestaurantsActivity favouriteRestaurantsActivity, Pair pair) {
        Intrinsics.checkNotNullParameter(favouriteRestaurantsActivity, "this$0");
        favouriteRestaurantsActivity.showRestaurants((List) pair.getFirst(), ((Boolean) pair.getSecond()).booleanValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m10755onCreate$lambda0(FavouriteRestaurantsActivity favouriteRestaurantsActivity, View view) {
        Intrinsics.checkNotNullParameter(favouriteRestaurantsActivity, "this$0");
        favouriteRestaurantsActivity.onBackPressed();
    }

    /* access modifiers changed from: private */
    public final void selectRestaurant(Restaurant restaurant) {
        Navigator.Companion.navigate((Context) this, new NavigatorModel("talabat.action.flutter.vendorMenu", (Bundle) null, new FavouriteRestaurantsActivity$selectRestaurant$1(restaurant), 2, (DefaultConstructorMarker) null));
    }

    private final void showNoResult() {
        ViewGroup[] viewGroupArr = new ViewGroup[2];
        ShimmerLayout shimmerLayout = this.loadingShimmer;
        CoordinatorLayout coordinatorLayout = null;
        if (shimmerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingShimmer");
            shimmerLayout = null;
        }
        viewGroupArr[0] = shimmerLayout;
        RecyclerView recyclerView = this.restaurantListView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restaurantListView");
            recyclerView = null;
        }
        viewGroupArr[1] = recyclerView;
        for (ViewGroup visibility : CollectionsKt__CollectionsKt.listOf(viewGroupArr)) {
            visibility.setVisibility(8);
        }
        ViewGroup[] viewGroupArr2 = new ViewGroup[2];
        LinearLayout linearLayout = this.noResultsContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noResultsContainer");
            linearLayout = null;
        }
        viewGroupArr2[0] = linearLayout;
        CoordinatorLayout coordinatorLayout2 = this.mainContentContainer;
        if (coordinatorLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContentContainer");
        } else {
            coordinatorLayout = coordinatorLayout2;
        }
        viewGroupArr2[1] = coordinatorLayout;
        for (ViewGroup visibility2 : CollectionsKt__CollectionsKt.listOf(viewGroupArr2)) {
            visibility2.setVisibility(0);
        }
    }

    private final void showRestaurants(List<? extends Restaurant> list, boolean z11) {
        FavouriteRestaurantsAdapter favouriteRestaurantsAdapter = new FavouriteRestaurantsAdapter(list, z11, new FavouriteRestaurantsActivity$showRestaurants$adapter$1(this));
        RecyclerView recyclerView = this.restaurantListView;
        CoordinatorLayout coordinatorLayout = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restaurantListView");
            recyclerView = null;
        }
        recyclerView.setAdapter(favouriteRestaurantsAdapter);
        ShimmerLayout shimmerLayout = this.loadingShimmer;
        if (shimmerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingShimmer");
            shimmerLayout = null;
        }
        shimmerLayout.setVisibility(8);
        ViewGroup[] viewGroupArr = new ViewGroup[2];
        RecyclerView recyclerView2 = this.restaurantListView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restaurantListView");
            recyclerView2 = null;
        }
        viewGroupArr[0] = recyclerView2;
        CoordinatorLayout coordinatorLayout2 = this.mainContentContainer;
        if (coordinatorLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContentContainer");
        } else {
            coordinatorLayout = coordinatorLayout2;
        }
        viewGroupArr[1] = coordinatorLayout;
        for (ViewGroup visibility : CollectionsKt__CollectionsKt.listOf(viewGroupArr)) {
            visibility.setVisibility(0);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @NotNull
    public final RxSchedulersFactory getRxSchedulersFactory() {
        RxSchedulersFactory rxSchedulersFactory2 = this.rxSchedulersFactory;
        if (rxSchedulersFactory2 != null) {
            return rxSchedulersFactory2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rxSchedulersFactory");
        return null;
    }

    @NotNull
    public final TalabatTracker getTracker() {
        TalabatTracker talabatTracker = this.tracker;
        if (talabatTracker != null) {
            return talabatTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tracker");
        return null;
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("FavouriteRestaurantsActivity");
        RecyclerView recyclerView = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "FavouriteRestaurantsActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "FavouriteRestaurantsActivity#onCreate", (ArrayList<String>) null);
        }
        initDagger();
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_favourite_restaurants);
        View findViewById = findViewById(R.id.favouriteRestaurantList);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.favouriteRestaurantList)");
        this.restaurantListView = (RecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.mainToolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.mainToolbar)");
        this.toolbar = (Toolbar) findViewById2;
        View findViewById3 = findViewById(R.id.loadingShimmer);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.loadingShimmer)");
        this.loadingShimmer = (ShimmerLayout) findViewById3;
        View findViewById4 = findViewById(R.id.mainContentContainer);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.mainContentContainer)");
        this.mainContentContainer = (CoordinatorLayout) findViewById4;
        View findViewById5 = findViewById(R.id.noRestaurantContainer);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.noRestaurantContainer)");
        this.noResultsContainer = (LinearLayout) findViewById5;
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(getResources().getColor(R.color.ds_secondary_10));
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            toolbar2 = null;
        }
        toolbar2.setNavigationOnClickListener(new a(this));
        RecyclerView recyclerView2 = this.restaurantListView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restaurantListView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView3 = this.restaurantListView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restaurantListView");
            recyclerView3 = null;
        }
        recyclerView3.setBackgroundColor(getResources().getColor(R.color.ds_neutral_white));
        RecyclerView recyclerView4 = this.restaurantListView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restaurantListView");
        } else {
            recyclerView = recyclerView4;
        }
        recyclerView.addItemDecoration(new FreshVerticalSpaceItemDecoration(getResources(), true));
        observeAndLoadFavouriteList();
        TraceMachine.exitMethod();
    }

    public void onDestroy() {
        this.compositeDisposable.dispose();
        super.onDestroy();
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public final void setRxSchedulersFactory(@NotNull RxSchedulersFactory rxSchedulersFactory2) {
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "<set-?>");
        this.rxSchedulersFactory = rxSchedulersFactory2;
    }

    public final void setTracker(@NotNull TalabatTracker talabatTracker) {
        Intrinsics.checkNotNullParameter(talabatTracker, "<set-?>");
        this.tracker = talabatTracker;
    }
}
