package com.talabat.fluid.homescreen.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.fluid.ParseConfig;
import com.deliveryhero.fluid.expression.reference.providers.ValueProvider;
import com.deliveryhero.fluid.expression.reference.providers.ValueProviders;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.providers.CoreValueProviders;
import com.deliveryhero.fluid.widgets.collections.grid.FreeSpacingLayoutManager;
import com.deliveryhero.fluid.widgets.collections.list.ListCell;
import com.deliveryhero.fluid.widgets.collections.list.ListWidget;
import com.deliveryhero.fluid.widgets.utils.WidgetTags;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorFeatureApi;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences;
import com.talabat.feature.ulcampaign.domain.usecase.VoucherCampaignCacheUseCase;
import com.talabat.fluid.TalabatFluidHost;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import com.talabat.fluid.homescreen.domain.usecase.business.ShowItemReplacementBottomSheetUseCase;
import com.talabat.fluid.homescreen.presentation.displaymodel.CollectionItem;
import com.talabat.fluid.homescreen.presentation.displaymodel.Configuration;
import com.talabat.fluid.homescreen.presentation.displaymodel.HeaderColour;
import com.talabat.fluid.homescreen.presentation.displaymodel.SwimLaneEvent;
import com.talabat.fluid.homescreen.presentation.mapper.EntryPointItem;
import com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel;
import com.talabat.fluid.homescreen.ui.fragment.di.DaggerFluidHomeScreenFragmentComponent;
import com.talabat.fluid.homescreen.ui.integration.FluidHomeScreenIntegrable;
import com.talabat.homescreen.HomeScreenFragmentInteractionListener;
import com.talabat.homescreen.R;
import com.talabat.homescreen.adapter.model.banner.BannerAdItem;
import com.talabat.homescreen.adapter.model.vetrical.VerticalItem;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yp.a;
import yp.b;
import yp.c;
import yp.d;
import yp.e;
import yp.f;
import yp.g;
import yp.h;
import yp.i;
import yp.j;
import yp.k;
import yp.l;

@Instrumented
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010]\u001a\u00020^2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020a0`H\u0002J\b\u0010b\u001a\u00020^H\u0002J\u000e\u0010c\u001a\b\u0012\u0004\u0012\u00020d0`H\u0016J\u0012\u0010e\u001a\u00020f2\b\b\u0001\u0010g\u001a\u00020fH\u0002J\u0010\u0010h\u001a\u00020f2\u0006\u0010i\u001a\u00020jH\u0002J\u001e\u0010k\u001a\u00020^2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020a0`2\u0006\u0010l\u001a\u00020mH\u0002J\u001e\u0010n\u001a\u00020^2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020a0`2\u0006\u0010l\u001a\u00020mH\u0002J\u001e\u0010o\u001a\u00020^2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020a0`2\u0006\u0010l\u001a\u00020mH\u0002J\b\u0010p\u001a\u00020^H\u0002J\u0018\u0010q\u001a\u00020r2\u0006\u0010l\u001a\u00020m2\u0006\u0010s\u001a\u00020fH\u0002J\b\u0010t\u001a\u00020^H\u0002J\u0010\u0010u\u001a\u00020^2\u0006\u0010v\u001a\u00020wH\u0016J&\u0010x\u001a\u0004\u0018\u00010y2\u0006\u0010z\u001a\u00020{2\b\u0010|\u001a\u0004\u0018\u00010}2\b\u0010~\u001a\u0004\u0018\u00010H\u0017J\t\u0010\u0001\u001a\u00020^H\u0016J\t\u0010\u0001\u001a\u00020^H\u0016J\t\u0010\u0001\u001a\u00020^H\u0016J\t\u0010\u0001\u001a\u00020^H\u0016J\t\u0010\u0001\u001a\u00020^H\u0016J\t\u0010\u0001\u001a\u00020^H\u0016J\u0013\u0010\u0001\u001a\u00020^2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001c\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020y2\b\u0010~\u001a\u0004\u0018\u00010H\u0016J\t\u0010\u0001\u001a\u00020^H\u0016J\u0013\u0010\u0001\u001a\u00020^2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0019\u0010\u0001\u001a\u00020^2\u0006\u0010l\u001a\u00020m2\u0006\u0010_\u001a\u00020aH\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0002038\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u00108\u001a\u0002098BX\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b:\u0010;R\u000e\u0010>\u001a\u00020?X.¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u00020A8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u000e\u0010F\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u001e\u0010G\u001a\u00020H8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001b\u0010M\u001a\u00020N8BX\u0002¢\u0006\f\n\u0004\bQ\u0010=\u001a\u0004\bO\u0010PR\u001e\u0010R\u001a\u00020S8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001b\u0010X\u001a\u00020Y8BX\u0002¢\u0006\f\n\u0004\b\\\u0010=\u001a\u0004\bZ\u0010[¨\u0006\u0001"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/fragment/FluidHomeScreenFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/homescreen/HomeScreenFragmentInteractionListener;", "()V", "campaignCacheUseCase", "Lcom/talabat/feature/ulcampaign/domain/usecase/VoucherCampaignCacheUseCase;", "getCampaignCacheUseCase", "()Lcom/talabat/feature/ulcampaign/domain/usecase/VoucherCampaignCacheUseCase;", "setCampaignCacheUseCase", "(Lcom/talabat/feature/ulcampaign/domain/usecase/VoucherCampaignCacheUseCase;)V", "campaignMigratorSharedPreferences", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;", "getCampaignMigratorSharedPreferences", "()Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;", "setCampaignMigratorSharedPreferences", "(Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;)V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "getCustomerRepository", "()Lcom/talabat/customer/domain/CustomerRepository;", "setCustomerRepository", "(Lcom/talabat/customer/domain/CustomerRepository;)V", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "groceryCategoriesScrollListener", "Lcom/talabat/fluid/homescreen/ui/fragment/SwimlaneScrollListener;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "setGson", "(Lcom/google/gson/Gson;)V", "homeScreenPerformanceObservability", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "getHomeScreenPerformanceObservability", "()Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "setHomeScreenPerformanceObservability", "(Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;)V", "integration", "Lcom/talabat/fluid/homescreen/ui/integration/FluidHomeScreenIntegrable;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "parseConfig", "Lcom/deliveryhero/fluid/ParseConfig;", "getParseConfig", "()Lcom/deliveryhero/fluid/ParseConfig;", "parseConfig$delegate", "Lkotlin/Lazy;", "screenScrollListener", "Lcom/talabat/fluid/homescreen/ui/fragment/ScreenScrollListener;", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "getScreenTracker", "()Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "setScreenTracker", "(Lcom/talabat/core/observabilityNew/domain/IScreenTracker;)V", "swimlaneScrollListener", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "talabatFluidHost", "Lcom/talabat/fluid/TalabatFluidHost;", "getTalabatFluidHost", "()Lcom/talabat/fluid/TalabatFluidHost;", "talabatFluidHost$delegate", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTalabatTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "setTalabatTracker", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "viewModel", "Lcom/talabat/fluid/homescreen/presentation/viewmodel/FluidHomeScreenViewModel;", "getViewModel", "()Lcom/talabat/fluid/homescreen/presentation/viewmodel/FluidHomeScreenViewModel;", "viewModel$delegate", "addScrollHandling", "", "collectionData", "", "Lcom/deliveryhero/fluid/widgets/collections/list/ListCell;", "checkProStatus", "getAvailableVerticals", "Lcom/talabat/homescreen/adapter/model/vetrical/VerticalItem;", "getColour", "", "colourRes", "getColourFrom", "headerColour", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/HeaderColour;", "handleGroceryCategoryWidgetScroll", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "handleSecondaryBannerScroll", "handleSwimLaneScroll", "inject", "isComponentVisible", "", "position", "observeViewModel", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onGemExpired", "onLeavingHomeTab", "onPause", "onResume", "onReturningToHomeTab", "onStart", "onVerticalClick", "entryPointItem", "Lcom/talabat/fluid/homescreen/presentation/mapper/EntryPointItem;", "onViewCreated", "view", "refreshHomeScreen", "setConfigurations", "configuration", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/Configuration;", "trackImpression", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenFragment extends Fragment implements HomeScreenFragmentInteractionListener, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Inject
    public VoucherCampaignCacheUseCase campaignCacheUseCase;
    @Inject
    public CampaignMigratorSharedPreferences campaignMigratorSharedPreferences;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public CustomerRepository customerRepository;
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    private SwimlaneScrollListener groceryCategoriesScrollListener;
    @Inject
    public Gson gson;
    @Inject
    public HomeScreenPerformanceObservability homeScreenPerformanceObservability;
    /* access modifiers changed from: private */
    @Nullable
    public FluidHomeScreenIntegrable integration;
    @Inject
    public IObservabilityManager observabilityManager;
    @NotNull
    private final Lazy parseConfig$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new FluidHomeScreenFragment$parseConfig$2(this));
    private ScreenScrollListener screenScrollListener;
    @Inject
    public IScreenTracker screenTracker;
    private SwimlaneScrollListener swimlaneScrollListener;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private final Lazy talabatFluidHost$delegate;
    @Inject
    public TalabatTracker talabatTracker;
    @NotNull
    private final Lazy viewModel$delegate;

    public FluidHomeScreenFragment() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        this.talabatFluidHost$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new FluidHomeScreenFragment$talabatFluidHost$2(this));
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new FluidHomeScreenFragment$viewModel$2(this));
    }

    private final void addScrollHandling(List<ListCell> list) {
        ScreenScrollListener screenScrollListener2 = null;
        if (this.screenScrollListener != null) {
            ListWidget listWidget = (ListWidget) _$_findCachedViewById(R.id.componentList);
            ScreenScrollListener screenScrollListener3 = this.screenScrollListener;
            if (screenScrollListener3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenScrollListener");
                screenScrollListener3 = null;
            }
            listWidget.removeOnScrollListener(screenScrollListener3);
        }
        this.screenScrollListener = new ScreenScrollListener(new FluidHomeScreenFragment$addScrollHandling$2(this, list));
        ListWidget listWidget2 = (ListWidget) _$_findCachedViewById(R.id.componentList);
        ScreenScrollListener screenScrollListener4 = this.screenScrollListener;
        if (screenScrollListener4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenScrollListener");
        } else {
            screenScrollListener2 = screenScrollListener4;
        }
        listWidget2.addOnScrollListener(screenScrollListener2);
    }

    private final void checkProStatus() {
        int i11;
        boolean isTPro = getCustomerRepository().isTPro();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) requireActivity().findViewById(R.id.home_nav);
        Context requireContext = requireContext();
        if (isTPro) {
            i11 = com.talabat.feature.tpro.presentation.R.drawable.ic_account_filled_pro;
        } else {
            i11 = com.designsystem.marshmallow.R.drawable.ds_profile_filled;
        }
        Drawable drawable = AppCompatResources.getDrawable(requireContext, i11);
        MenuItem findItem = bottomNavigationView.getMenu().findItem(R.id.account_nav);
        if (findItem != null) {
            findItem.setIcon(drawable);
        }
    }

    private final int getColour(@ColorRes int i11) {
        return getResources().getColor(i11, requireActivity().getTheme());
    }

    private final int getColourFrom(HeaderColour headerColour) {
        CoreValueProviders coreValueProviders;
        Color color;
        if (headerColour instanceof HeaderColour.Custom) {
            ValueProviders valueProviders = getParseConfig().getValueProviders();
            ValueProvider<Color> valueProvider = null;
            if (valueProviders instanceof CoreValueProviders) {
                coreValueProviders = (CoreValueProviders) valueProviders;
            } else {
                coreValueProviders = null;
            }
            if (coreValueProviders != null) {
                valueProvider = coreValueProviders.getColor();
            }
            if (valueProvider == null || (color = valueProvider.get(((HeaderColour.Custom) headerColour).getValue())) == null) {
                return getColour(com.designsystem.marshmallow.R.color.ds_neutral_white);
            }
            return color.getArgb();
        } else if (Intrinsics.areEqual((Object) headerColour, (Object) HeaderColour.White.INSTANCE)) {
            return getColour(com.designsystem.marshmallow.R.color.ds_neutral_white);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public final ParseConfig getParseConfig() {
        return (ParseConfig) this.parseConfig$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TalabatFluidHost getTalabatFluidHost() {
        return (TalabatFluidHost) this.talabatFluidHost$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final FluidHomeScreenViewModel getViewModel() {
        return (FluidHomeScreenViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void handleGroceryCategoryWidgetScroll(List<ListCell> list, RecyclerView recyclerView) {
        SwimlaneScrollListener swimlaneScrollListener2;
        View view;
        RecyclerView recyclerView2;
        WidgetTags widgetTags;
        String str;
        int groceryCategoriesComponentPosition = getViewModel().getGroceryCategoriesComponentPosition(list);
        if (isComponentVisible(recyclerView, groceryCategoriesComponentPosition)) {
            String groceryCategoriesComponentTag = getViewModel().getGroceryCategoriesComponentTag();
            Iterator<View> it = ViewKt.getAllViews(recyclerView).iterator();
            while (true) {
                swimlaneScrollListener2 = null;
                if (!it.hasNext()) {
                    view = null;
                    break;
                }
                view = it.next();
                Object tag = view.getTag();
                if (tag instanceof WidgetTags) {
                    widgetTags = (WidgetTags) tag;
                } else {
                    widgetTags = null;
                }
                if (widgetTags != null) {
                    str = widgetTags.getAccessibilityId();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual((Object) str, (Object) groceryCategoriesComponentTag)) {
                    break;
                }
            }
            if (view instanceof RecyclerView) {
                recyclerView2 = (RecyclerView) view;
            } else {
                recyclerView2 = null;
            }
            if (recyclerView2 != null) {
                ListCell listCell = list.get(groceryCategoriesComponentPosition);
                trackImpression(recyclerView2, listCell);
                SwimlaneScrollListener swimlaneScrollListener3 = this.groceryCategoriesScrollListener;
                if (swimlaneScrollListener3 != null) {
                    if (swimlaneScrollListener3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("groceryCategoriesScrollListener");
                    } else {
                        swimlaneScrollListener2 = swimlaneScrollListener3;
                    }
                    recyclerView2.removeOnScrollListener(swimlaneScrollListener2);
                }
                SwimlaneScrollListener swimlaneScrollListener4 = new SwimlaneScrollListener(new FluidHomeScreenFragment$handleGroceryCategoryWidgetScroll$2$2(this, listCell));
                this.groceryCategoriesScrollListener = swimlaneScrollListener4;
                recyclerView2.addOnScrollListener(swimlaneScrollListener4);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void handleSecondaryBannerScroll(List<ListCell> list, RecyclerView recyclerView) {
        int i11 = 0;
        for (Object next : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ListCell listCell = (ListCell) next;
            if (getViewModel().isSecondaryBanner(listCell.getData()) && isComponentVisible(recyclerView, i11)) {
                getViewModel().trackSecondaryBannerShown(listCell);
            }
            i11 = i12;
        }
    }

    /* access modifiers changed from: private */
    public final void handleSwimLaneScroll(List<ListCell> list, RecyclerView recyclerView) {
        RecyclerView recyclerView2;
        int pastOrdersComponentPosition = getViewModel().getPastOrdersComponentPosition(list);
        if (isComponentVisible(recyclerView, pastOrdersComponentPosition) && (recyclerView2 = (RecyclerView) recyclerView.findViewWithTag(getViewModel().getPastOrdersComponentTag())) != null) {
            ListCell listCell = list.get(pastOrdersComponentPosition);
            trackImpression(recyclerView2, listCell);
            SwimlaneScrollListener swimlaneScrollListener2 = this.swimlaneScrollListener;
            if (swimlaneScrollListener2 != null) {
                if (swimlaneScrollListener2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("swimlaneScrollListener");
                    swimlaneScrollListener2 = null;
                }
                recyclerView2.removeOnScrollListener(swimlaneScrollListener2);
            }
            SwimlaneScrollListener swimlaneScrollListener3 = new SwimlaneScrollListener(new FluidHomeScreenFragment$handleSwimLaneScroll$1$2(this, listCell));
            this.swimlaneScrollListener = swimlaneScrollListener3;
            recyclerView2.addOnScrollListener(swimlaneScrollListener3);
        }
    }

    private final void inject() {
        DaggerFluidHomeScreenFragmentComponent.factory().create((CampaignMigratorFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(CampaignMigratorFeatureApi.class), (ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (CustomerCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(CustomerCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DeepLinkCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class), (ParserCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ParserCoreLibApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(TrackingCoreLibApi.class)).inject(this);
    }

    private final boolean isComponentVisible(RecyclerView recyclerView, int i11) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition == -1 || findLastCompletelyVisibleItemPosition == -1) {
                return false;
            }
            return new IntRange(findFirstCompletelyVisibleItemPosition, findLastCompletelyVisibleItemPosition).contains(i11);
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    private final void observeViewModel() {
        getViewModel().getComponents().observe(getViewLifecycleOwner(), new a(this));
        getViewModel().getTransitionHeaderColour().observe(getViewLifecycleOwner(), new f(this));
        getViewModel().getConfiguration().observe(getViewLifecycleOwner(), new g(this));
        getViewModel().getShouldShowRatingBottomSheet().observe(getViewLifecycleOwner(), new h(this));
        getViewModel().isLoadingVisible().observe(getViewLifecycleOwner(), new i(this));
        getViewModel().isToolBarHidden().observe(getViewLifecycleOwner(), new j(this));
        getViewModel().getHandleDeepLinkEvent().observe(getViewLifecycleOwner(), new k(this));
        getViewModel().getVerticalClickedEvent().observe(getViewLifecycleOwner(), new l(this));
        getViewModel().getBannerClickEvent().observe(getViewLifecycleOwner(), new b(this));
        getViewModel().getCollectionClickedEvent().observe(getViewLifecycleOwner(), new c(this));
        getViewModel().getSwimLaneClickedEvent().observe(getViewLifecycleOwner(), new d(this));
        getViewModel().getShouldShowItemReplacementBottomSheet().observe(getViewLifecycleOwner(), new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-10  reason: not valid java name */
    public static final void m10449observeViewModel$lambda10(FluidHomeScreenFragment fluidHomeScreenFragment, BannerAdItem bannerAdItem) {
        Intrinsics.checkNotNullParameter(fluidHomeScreenFragment, "this$0");
        FluidHomeScreenIntegrable fluidHomeScreenIntegrable = fluidHomeScreenFragment.integration;
        if (fluidHomeScreenIntegrable != null) {
            Intrinsics.checkNotNullExpressionValue(bannerAdItem, "it");
            fluidHomeScreenIntegrable.onBannerClick(bannerAdItem);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-11  reason: not valid java name */
    public static final void m10450observeViewModel$lambda11(FluidHomeScreenFragment fluidHomeScreenFragment, CollectionItem collectionItem) {
        Intrinsics.checkNotNullParameter(fluidHomeScreenFragment, "this$0");
        FluidHomeScreenIntegrable fluidHomeScreenIntegrable = fluidHomeScreenFragment.integration;
        if (fluidHomeScreenIntegrable != null) {
            fluidHomeScreenIntegrable.setSelectedVertical(collectionItem.getVerticalId());
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(fluidHomeScreenFragment), (CoroutineContext) null, (CoroutineStart) null, new FluidHomeScreenFragment$observeViewModel$10$1(fluidHomeScreenFragment, collectionItem, (Continuation<? super FluidHomeScreenFragment$observeViewModel$10$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-12  reason: not valid java name */
    public static final void m10451observeViewModel$lambda12(FluidHomeScreenFragment fluidHomeScreenFragment, SwimLaneEvent swimLaneEvent) {
        Intrinsics.checkNotNullParameter(fluidHomeScreenFragment, "this$0");
        Navigator.Companion companion = Navigator.Companion;
        Context requireContext = fluidHomeScreenFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        companion.navigate(requireContext, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity$default(OPNavigatorActions.Companion, swimLaneEvent.getBranchId(), swimLaneEvent.getShopType(), swimLaneEvent.isGlrEnabled(), swimLaneEvent.isDarkStore(), swimLaneEvent.isMigrated(), false, (String) null, (Bundle) null, 224, (Object) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-13  reason: not valid java name */
    public static final void m10452observeViewModel$lambda13(FluidHomeScreenFragment fluidHomeScreenFragment, ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo itemReplacementInfo) {
        Intrinsics.checkNotNullParameter(fluidHomeScreenFragment, "this$0");
        FluidHomeScreenIntegrable fluidHomeScreenIntegrable = fluidHomeScreenFragment.integration;
        if (fluidHomeScreenIntegrable != null) {
            Intrinsics.checkNotNullExpressionValue(itemReplacementInfo, CustomerInfoLocalDataSourceImpl.KEY);
            fluidHomeScreenIntegrable.showItemReplacementBottomSheet(itemReplacementInfo);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-2  reason: not valid java name */
    public static final void m10453observeViewModel$lambda2(FluidHomeScreenFragment fluidHomeScreenFragment, List list) {
        Intrinsics.checkNotNullParameter(fluidHomeScreenFragment, "this$0");
        HomeScreenPerformanceObservability homeScreenPerformanceObservability2 = fluidHomeScreenFragment.getHomeScreenPerformanceObservability();
        HomeScreenPerformanceObservability.Level level = HomeScreenPerformanceObservability.Level.INFO;
        Intrinsics.checkNotNullExpressionValue(list, "collectionData");
        Collection collection = list;
        homeScreenPerformanceObservability2.traceStart(level, "fluidHomeScreenFragment.viewModel.components.observe", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("numberOfComponents", String.valueOf(collection.size()))));
        int i11 = R.id.componentList;
        ((ListWidget) fluidHomeScreenFragment._$_findCachedViewById(i11)).setCells(list);
        ((ListWidget) fluidHomeScreenFragment._$_findCachedViewById(i11)).setVisibility(0);
        fluidHomeScreenFragment.addScrollHandling(list);
        fluidHomeScreenFragment.getHomeScreenPerformanceObservability().traceEnd(level, "fluidHomeScreenFragment.viewModel.components.observe", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("numberOfComponents", String.valueOf(collection.size()))));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-3  reason: not valid java name */
    public static final void m10454observeViewModel$lambda3(FluidHomeScreenFragment fluidHomeScreenFragment, HeaderColour headerColour) {
        Intrinsics.checkNotNullParameter(fluidHomeScreenFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(headerColour, "headerColour");
        int colourFrom = fluidHomeScreenFragment.getColourFrom(headerColour);
        FluidHomeScreenIntegrable fluidHomeScreenIntegrable = fluidHomeScreenFragment.integration;
        if (fluidHomeScreenIntegrable != null) {
            fluidHomeScreenIntegrable.transitionHeaderColour(colourFrom);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-4  reason: not valid java name */
    public static final void m10455observeViewModel$lambda4(FluidHomeScreenFragment fluidHomeScreenFragment, Configuration configuration) {
        Intrinsics.checkNotNullParameter(fluidHomeScreenFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(configuration, "it");
        fluidHomeScreenFragment.setConfigurations(configuration);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-5  reason: not valid java name */
    public static final void m10456observeViewModel$lambda5(FluidHomeScreenFragment fluidHomeScreenFragment, String str) {
        Intrinsics.checkNotNullParameter(fluidHomeScreenFragment, "this$0");
        FluidHomeScreenIntegrable fluidHomeScreenIntegrable = fluidHomeScreenFragment.integration;
        if (fluidHomeScreenIntegrable != null) {
            Intrinsics.checkNotNullExpressionValue(str, "it");
            fluidHomeScreenIntegrable.showRatingBottomSheet(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-6  reason: not valid java name */
    public static final void m10457observeViewModel$lambda6(FluidHomeScreenFragment fluidHomeScreenFragment, Boolean bool) {
        int i11;
        Intrinsics.checkNotNullParameter(fluidHomeScreenFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue()) {
            fluidHomeScreenFragment.requireActivity().getWindow().setStatusBarColor(fluidHomeScreenFragment.getColour(com.designsystem.marshmallow.R.color.ds_primary_10));
        }
        View _$_findCachedViewById = fluidHomeScreenFragment._$_findCachedViewById(R.id.loadingLayout);
        if (bool.booleanValue()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        _$_findCachedViewById.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-7  reason: not valid java name */
    public static final void m10458observeViewModel$lambda7(FluidHomeScreenFragment fluidHomeScreenFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(fluidHomeScreenFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        boolean booleanValue = bool.booleanValue();
        FluidHomeScreenIntegrable fluidHomeScreenIntegrable = fluidHomeScreenFragment.integration;
        if (booleanValue) {
            if (fluidHomeScreenIntegrable != null) {
                fluidHomeScreenIntegrable.hideToolBar();
            }
        } else if (fluidHomeScreenIntegrable != null) {
            fluidHomeScreenIntegrable.showToolBar();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-8  reason: not valid java name */
    public static final void m10459observeViewModel$lambda8(FluidHomeScreenFragment fluidHomeScreenFragment, String str) {
        Intrinsics.checkNotNullParameter(fluidHomeScreenFragment, "this$0");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(fluidHomeScreenFragment), (CoroutineContext) null, (CoroutineStart) null, new FluidHomeScreenFragment$observeViewModel$7$1(fluidHomeScreenFragment, str, (Continuation<? super FluidHomeScreenFragment$observeViewModel$7$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-9  reason: not valid java name */
    public static final void m10460observeViewModel$lambda9(FluidHomeScreenFragment fluidHomeScreenFragment, EntryPointItem entryPointItem) {
        Intrinsics.checkNotNullParameter(fluidHomeScreenFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(entryPointItem, "it");
        fluidHomeScreenFragment.onVerticalClick(entryPointItem);
    }

    private final void onVerticalClick(EntryPointItem entryPointItem) {
        FluidHomeScreenIntegrable fluidHomeScreenIntegrable = this.integration;
        if (fluidHomeScreenIntegrable != null) {
            fluidHomeScreenIntegrable.onEntryPointClicked(entryPointItem);
        }
    }

    private final void setConfigurations(Configuration configuration) {
        CoreValueProviders coreValueProviders;
        FluidHomeScreenIntegrable fluidHomeScreenIntegrable;
        ValueProviders valueProviders = getParseConfig().getValueProviders();
        ValueProvider<Color> valueProvider = null;
        if (valueProviders instanceof CoreValueProviders) {
            coreValueProviders = (CoreValueProviders) valueProviders;
        } else {
            coreValueProviders = null;
        }
        if (coreValueProviders != null) {
            valueProvider = coreValueProviders.getColor();
        }
        if (valueProvider != null && (fluidHomeScreenIntegrable = this.integration) != null) {
            fluidHomeScreenIntegrable.configure(new FluidHomeScreenIntegrable.Configuration(valueProvider.get(configuration.getNavigationBarColor()).getArgb(), valueProvider.get(configuration.getLocationHintColor()).getArgb(), valueProvider.get(configuration.getLocationTitleColor()).getArgb(), valueProvider.get(configuration.getLocationArrowTintColor()).getArgb()));
        }
    }

    /* access modifiers changed from: private */
    public final void trackImpression(RecyclerView recyclerView, ListCell listCell) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            Integer findFirstCompletelyVisibleItemPosition = ((FreeSpacingLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            if (layoutManager2 != null) {
                Integer findLastCompletelyVisibleItemPosition = ((FreeSpacingLayoutManager) layoutManager2).findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition != null && findLastCompletelyVisibleItemPosition != null) {
                    getViewModel().onSwiped(CollectionsKt__CollectionsKt.listOf(findFirstCompletelyVisibleItemPosition, findLastCompletelyVisibleItemPosition), listCell.getData());
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.deliveryhero.fluid.widgets.collections.grid.FreeSpacingLayoutManager");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.deliveryhero.fluid.widgets.collections.grid.FreeSpacingLayoutManager");
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
    public List<VerticalItem> getAvailableVerticals() {
        return getViewModel().getVerticals();
    }

    @NotNull
    public final VoucherCampaignCacheUseCase getCampaignCacheUseCase() {
        VoucherCampaignCacheUseCase voucherCampaignCacheUseCase = this.campaignCacheUseCase;
        if (voucherCampaignCacheUseCase != null) {
            return voucherCampaignCacheUseCase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("campaignCacheUseCase");
        return null;
    }

    @NotNull
    public final CampaignMigratorSharedPreferences getCampaignMigratorSharedPreferences() {
        CampaignMigratorSharedPreferences campaignMigratorSharedPreferences2 = this.campaignMigratorSharedPreferences;
        if (campaignMigratorSharedPreferences2 != null) {
            return campaignMigratorSharedPreferences2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("campaignMigratorSharedPreferences");
        return null;
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
    public final CustomerRepository getCustomerRepository() {
        CustomerRepository customerRepository2 = this.customerRepository;
        if (customerRepository2 != null) {
            return customerRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("customerRepository");
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
    public final Gson getGson() {
        Gson gson2 = this.gson;
        if (gson2 != null) {
            return gson2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gson");
        return null;
    }

    @NotNull
    public final HomeScreenPerformanceObservability getHomeScreenPerformanceObservability() {
        HomeScreenPerformanceObservability homeScreenPerformanceObservability2 = this.homeScreenPerformanceObservability;
        if (homeScreenPerformanceObservability2 != null) {
            return homeScreenPerformanceObservability2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("homeScreenPerformanceObservability");
        return null;
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            return iObservabilityManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
        return null;
    }

    @NotNull
    public final IScreenTracker getScreenTracker() {
        IScreenTracker iScreenTracker = this.screenTracker;
        if (iScreenTracker != null) {
            return iScreenTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
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
    public final TalabatTracker getTalabatTracker() {
        TalabatTracker talabatTracker2 = this.talabatTracker;
        if (talabatTracker2 != null) {
            return talabatTracker2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatTracker");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        inject();
        super.onAttach(context);
        if (context instanceof FluidHomeScreenIntegrable) {
            FluidHomeScreenIntegrable fluidHomeScreenIntegrable = (FluidHomeScreenIntegrable) context;
            this.integration = fluidHomeScreenIntegrable;
            if (fluidHomeScreenIntegrable != null) {
                fluidHomeScreenIntegrable.onFragmentAttached(this);
                return;
            }
            return;
        }
        IObservabilityManager observabilityManager2 = getObservabilityManager();
        IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(observabilityManager2, "RuntimeException(" + context + " must implement FluidHomeScreenIntegrable)", (Map) null, 2, (Object) null);
    }

    @Nullable
    @SuppressLint({"InflateParams"})
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "FluidHomeScreenFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "FluidHomeScreenFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        HomeScreenPerformanceObservability homeScreenPerformanceObservability2 = getHomeScreenPerformanceObservability();
        HomeScreenPerformanceObservability.Level level = HomeScreenPerformanceObservability.Level.INFO;
        HomeScreenPerformanceObservability.DefaultImpls.traceStart$default(homeScreenPerformanceObservability2, level, "fluidHomeScreenFragment.onCreateView", (Map) null, 4, (Object) null);
        View inflate = layoutInflater.inflate(R.layout.fragment_fluid_home_screen, (ViewGroup) null, false);
        HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(getHomeScreenPerformanceObservability(), level, "fluidHomeScreenFragment.onCreateView", (Map) null, 4, (Object) null);
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onGemExpired() {
        getViewModel().onGemExpired();
    }

    public void onLeavingHomeTab() {
        getViewModel().onLeavingHomeTab();
    }

    public void onPause() {
        super.onPause();
        getViewModel().onPause();
    }

    public void onResume() {
        super.onResume();
        getViewModel().onResume();
        checkProStatus();
    }

    public void onReturningToHomeTab() {
        getViewModel().onReturningToHomeTab();
    }

    public void onStart() {
        super.onStart();
        List value = getViewModel().getComponents().getValue();
        if (value != null) {
            ListWidget listWidget = (ListWidget) _$_findCachedViewById(R.id.componentList);
            Intrinsics.checkNotNullExpressionValue(listWidget, "componentList");
            handleSwimLaneScroll(value, listWidget);
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        HomeScreenPerformanceObservability homeScreenPerformanceObservability2 = getHomeScreenPerformanceObservability();
        HomeScreenPerformanceObservability.Level level = HomeScreenPerformanceObservability.Level.INFO;
        HomeScreenPerformanceObservability.DefaultImpls.traceStart$default(homeScreenPerformanceObservability2, level, "fluidHomeScreenFragment.onViewCreated", (Map) null, 4, (Object) null);
        super.onViewCreated(view, bundle);
        observeViewModel();
        ((ListWidget) _$_findCachedViewById(R.id.componentList)).init(getTalabatFluidHost());
        HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(getHomeScreenPerformanceObservability(), level, "fluidHomeScreenFragment.onViewCreated", (Map) null, 4, (Object) null);
    }

    public void refreshHomeScreen() {
        getViewModel().onViewModelCreated();
    }

    public final void setCampaignCacheUseCase(@NotNull VoucherCampaignCacheUseCase voucherCampaignCacheUseCase) {
        Intrinsics.checkNotNullParameter(voucherCampaignCacheUseCase, "<set-?>");
        this.campaignCacheUseCase = voucherCampaignCacheUseCase;
    }

    public final void setCampaignMigratorSharedPreferences(@NotNull CampaignMigratorSharedPreferences campaignMigratorSharedPreferences2) {
        Intrinsics.checkNotNullParameter(campaignMigratorSharedPreferences2, "<set-?>");
        this.campaignMigratorSharedPreferences = campaignMigratorSharedPreferences2;
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setCustomerRepository(@NotNull CustomerRepository customerRepository2) {
        Intrinsics.checkNotNullParameter(customerRepository2, "<set-?>");
        this.customerRepository = customerRepository2;
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setGson(@NotNull Gson gson2) {
        Intrinsics.checkNotNullParameter(gson2, "<set-?>");
        this.gson = gson2;
    }

    public final void setHomeScreenPerformanceObservability(@NotNull HomeScreenPerformanceObservability homeScreenPerformanceObservability2) {
        Intrinsics.checkNotNullParameter(homeScreenPerformanceObservability2, "<set-?>");
        this.homeScreenPerformanceObservability = homeScreenPerformanceObservability2;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setScreenTracker(@NotNull IScreenTracker iScreenTracker) {
        Intrinsics.checkNotNullParameter(iScreenTracker, "<set-?>");
        this.screenTracker = iScreenTracker;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public final void setTalabatTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "<set-?>");
        this.talabatTracker = talabatTracker2;
    }
}
