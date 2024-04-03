package com.talabat.growth.ui.vouchers.entrypoint;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import com.talabat.core.navigation.domain.screen.voucherlist.VouchersListDeeplinkBuilder;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.growth.R;
import com.talabat.growth.ui.loyalty.HomeScreenHeaderRewardsViewModel;
import com.talabat.growth.ui.vouchers.entrypoint.di.DaggerHomeScreenHeaderVouchersComponent;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModel;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModelFactory;
import com.talabat.talabatcommon.extension.ViewKt;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sr.a;
import sr.b;
import sr.c;
import sr.d;
import sr.e;

@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020?H\u0002J\u0017\u0010@\u001a\u00020<2\b\u0010A\u001a\u0004\u0018\u00010?H\u0002¢\u0006\u0002\u0010BJ\u0010\u0010C\u001a\u00020<2\u0006\u0010D\u001a\u00020EH\u0002J\u0017\u0010F\u001a\u00020<2\b\u0010G\u001a\u0004\u0018\u00010?H\u0002¢\u0006\u0002\u0010BJ\b\u0010H\u001a\u00020<H\u0014R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001b\u00100\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103R\u001b\u00106\u001a\u0002078BX\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b8\u00109¨\u0006I"}, d2 = {"Lcom/talabat/growth/ui/vouchers/entrypoint/HomeScreenHeaderVouchersView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "getCoroutineDispatchersFactory", "()Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "setCoroutineDispatchersFactory", "(Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "coroutineScope", "com/talabat/growth/ui/vouchers/entrypoint/HomeScreenHeaderVouchersView$coroutineScope$1", "Lcom/talabat/growth/ui/vouchers/entrypoint/HomeScreenHeaderVouchersView$coroutineScope$1;", "factory", "Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModelFactory;", "getFactory", "()Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModelFactory;", "setFactory", "(Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModelFactory;)V", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "rewardsViewModel", "Lcom/talabat/growth/ui/loyalty/HomeScreenHeaderRewardsViewModel;", "getRewardsViewModel", "()Lcom/talabat/growth/ui/loyalty/HomeScreenHeaderRewardsViewModel;", "rewardsViewModel$delegate", "Landroidx/lifecycle/ViewModelLazy;", "viewModel", "Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModel;", "getViewModel", "()Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModel;", "viewModel$delegate", "bindView", "", "getActiveVouchers", "isEligible", "", "handleActiveVoucherVisibility", "hide", "(Ljava/lang/Boolean;)V", "handleActiveVouchers", "activeVouchers", "", "handleUserEligible", "isEnabled", "onAttachedToWindow", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenHeaderVouchersView extends RelativeLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public CoroutineDispatchersFactory coroutineDispatchersFactory;
    /* access modifiers changed from: private */
    @NotNull
    public final HomeScreenHeaderVouchersView$coroutineScope$1 coroutineScope;
    @Inject
    public VoucherEntryPointViewModelFactory factory;
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Inject
    public Navigator navigator;
    @NotNull
    private final ViewModelLazy rewardsViewModel$delegate;
    @NotNull
    private final ViewModelLazy viewModel$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeScreenHeaderVouchersView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeScreenHeaderVouchersView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeScreenHeaderVouchersView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        HomeScreenHeaderVouchersView$viewModel$2 homeScreenHeaderVouchersView$viewModel$2 = new HomeScreenHeaderVouchersView$viewModel$2(this);
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(VoucherEntryPointViewModel.class), new HomeScreenHeaderVouchersView$special$$inlined$viewModels$1(this), homeScreenHeaderVouchersView$viewModel$2);
        this.coroutineScope = new HomeScreenHeaderVouchersView$coroutineScope$1(this);
        HomeScreenHeaderVouchersView$rewardsViewModel$2 homeScreenHeaderVouchersView$rewardsViewModel$2 = new HomeScreenHeaderVouchersView$rewardsViewModel$2(context, this);
        this.rewardsViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(HomeScreenHeaderRewardsViewModel.class), new HomeScreenHeaderVouchersView$special$$inlined$viewModels$2(this), homeScreenHeaderVouchersView$rewardsViewModel$2);
        if (!isInEditMode()) {
            DaggerHomeScreenHeaderVouchersComponent.factory().create((ContextCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ContextCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(FeatureFlagCoreLibApi.class), (DispatcherCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(DispatcherCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ObservabilityCoreLibApi.class), (ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationLocalCoreLibApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(NavigationCoreLibApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(TrackingCoreLibApi.class)).inject(this);
        }
        View.inflate(context, R.layout.home_header_vouchers, this);
        bindView();
    }

    private final void bindView() {
        ((LinearLayout) _$_findCachedViewById(R.id.voucher_container)).setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-0  reason: not valid java name */
    public static final void m10613bindView$lambda0(HomeScreenHeaderVouchersView homeScreenHeaderVouchersView, View view) {
        Intrinsics.checkNotNullParameter(homeScreenHeaderVouchersView, "this$0");
        homeScreenHeaderVouchersView.getViewModel().trackViewClicked("Home Screen");
        Navigator navigator2 = homeScreenHeaderVouchersView.getNavigator();
        Context context = homeScreenHeaderVouchersView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Navigator.DefaultImpls.navigateTo$default(navigator2, context, new FlutterScreen(new FlutterScreen.FlutterScreenData(VouchersListDeeplinkBuilder.build$default(new VouchersListDeeplinkBuilder(), (String) null, (String) null, (String) null, false, false, 31, (Object) null))), (Function1) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void getActiveVouchers(boolean z11) {
        if (!z11) {
            getViewModel().getActiveVouchers();
        }
    }

    private final HomeScreenHeaderRewardsViewModel getRewardsViewModel() {
        return (HomeScreenHeaderRewardsViewModel) this.rewardsViewModel$delegate.getValue();
    }

    private final VoucherEntryPointViewModel getViewModel() {
        return (VoucherEntryPointViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void handleActiveVoucherVisibility(Boolean bool) {
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual((Object) bool, (Object) bool2) || Intrinsics.areEqual((Object) getRewardsViewModel().getShowRewardsBanner().getValue(), (Object) bool2)) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.voucher_container);
            Intrinsics.checkNotNullExpressionValue(linearLayout, "voucher_container");
            ViewKt.invisible(linearLayout);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.voucher_container);
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "voucher_container");
        ViewKt.visible(linearLayout2);
        getViewModel().trackViewShown("Home Screen");
    }

    /* access modifiers changed from: private */
    public final void handleActiveVouchers(String str) {
        ((AppCompatTextView) _$_findCachedViewById(R.id.vouchers_header_title)).setText(str);
    }

    private final void handleUserEligible(Boolean bool) {
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual((Object) bool, (Object) bool2)) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.voucher_container);
            Intrinsics.checkNotNullExpressionValue(linearLayout, "voucher_container");
            ViewKt.invisible(linearLayout);
        }
        getViewModel().updateRewardsUserEligibility(Intrinsics.areEqual((Object) bool, (Object) bool2));
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachedToWindow$lambda-2$lambda-1  reason: not valid java name */
    public static final void m10614onAttachedToWindow$lambda2$lambda1(HomeScreenHeaderVouchersView homeScreenHeaderVouchersView, Boolean bool) {
        Intrinsics.checkNotNullParameter(homeScreenHeaderVouchersView, "this$0");
        homeScreenHeaderVouchersView.handleUserEligible(bool);
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
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
    }

    @NotNull
    public final CoroutineDispatchersFactory getCoroutineDispatchersFactory() {
        CoroutineDispatchersFactory coroutineDispatchersFactory2 = this.coroutineDispatchersFactory;
        if (coroutineDispatchersFactory2 != null) {
            return coroutineDispatchersFactory2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coroutineDispatchersFactory");
        return null;
    }

    @NotNull
    public final VoucherEntryPointViewModelFactory getFactory() {
        VoucherEntryPointViewModelFactory voucherEntryPointViewModelFactory = this.factory;
        if (voucherEntryPointViewModelFactory != null) {
            return voucherEntryPointViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
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
    public final LocationConfigurationRepository getLocationConfigurationRepository() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        if (locationConfigurationRepository2 != null) {
            return locationConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationConfigurationRepository");
        return null;
    }

    @NotNull
    public final Navigator getNavigator() {
        Navigator navigator2 = this.navigator;
        if (navigator2 != null) {
            return navigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifecycleOwner findViewTreeLifecycleOwner = androidx.lifecycle.ViewKt.findViewTreeLifecycleOwner(this);
        if (findViewTreeLifecycleOwner != null) {
            getViewModel().getActiveVouchers().observe(findViewTreeLifecycleOwner, new a(this));
            getViewModel().getHideActiveVouchers().observe(findViewTreeLifecycleOwner, new b(this));
            getViewModel().getRewardsUserEligibility().observe(findViewTreeLifecycleOwner, new c(this));
            getRewardsViewModel().getShowRewardsBanner().observe(findViewTreeLifecycleOwner, new d(this));
        }
        if (Customer.getInstance().isLoggedIn(getContext())) {
            getRewardsViewModel().isRewardsPointsBannerVisible();
        }
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setCoroutineDispatchersFactory(@NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2) {
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "<set-?>");
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
    }

    public final void setFactory(@NotNull VoucherEntryPointViewModelFactory voucherEntryPointViewModelFactory) {
        Intrinsics.checkNotNullParameter(voucherEntryPointViewModelFactory, "<set-?>");
        this.factory = voucherEntryPointViewModelFactory;
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setNavigator(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeScreenHeaderVouchersView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
