package com.talabat.feature.nfvinvendorsearch.presentation.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.bnplcheckout.BNPLCheckoutFlutterBottomSheetKt;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstoresflutter.domain.DarkstoresFlutterCartApi;
import com.talabat.feature.darkstoresvendor.domain.DarkstoresVendorApi;
import com.talabat.feature.nfvinvendorsearch.domain.di.QCommerceFlutterFeatureApi;
import com.talabat.feature.nfvinvendorsearch.presentation.di.DaggerQCommerceFlutterPresentationComponent;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.model.NavigationCommand;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.viewmodel.QCommerceViewModel;
import com.talabat.feature.nfvinvendorsearch.presentation.viewmodel.QCommerceViewModelFactory;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.engine.PreWarmedEngines;
import com.talabat.fluttercore.presentation.PreWarmedFlutterFragment;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import in.a;
import io.flutter.embedding.engine.FlutterEngine;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u000b\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001fH\u0016J\u0012\u0010'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u001fH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00060"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/fragment/QCommerceFlutterFragment;", "Lcom/talabat/fluttercore/presentation/PreWarmedFlutterFragment;", "()V", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "getConfigurationParams", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "configurationParams$delegate", "Lkotlin/Lazy;", "route", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "getRoute", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "route$delegate", "routeOnBackPressToFlutter", "Landroidx/activity/OnBackPressedCallback;", "viewModel", "Lcom/talabat/feature/nfvinvendorsearch/presentation/viewmodel/QCommerceViewModel;", "getViewModel", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/viewmodel/QCommerceViewModel;", "viewModel$delegate", "viewModelFactory", "Lcom/talabat/feature/nfvinvendorsearch/presentation/viewmodel/QCommerceViewModelFactory;", "getViewModelFactory", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/viewmodel/QCommerceViewModelFactory;", "setViewModelFactory", "(Lcom/talabat/feature/nfvinvendorsearch/presentation/viewmodel/QCommerceViewModelFactory;)V", "getEntryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "", "handleNavigationCommand", "", "command", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand;", "injectDependencies", "onAttach", "context", "Landroid/content/Context;", "onBackPressedFromFlutter", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpExtraChannels", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "shouldAttachEngineToActivity", "", "subscribeToNavigationCommands", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QCommerceFlutterFragment extends PreWarmedFlutterFragment {
    @NotNull
    private final Lazy configurationParams$delegate;
    @NotNull
    private final Lazy route$delegate;
    @Nullable
    private OnBackPressedCallback routeOnBackPressToFlutter;
    @NotNull
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(QCommerceViewModel.class), new QCommerceFlutterFragment$special$$inlined$viewModels$default$2(new QCommerceFlutterFragment$special$$inlined$viewModels$default$1(this)), new QCommerceFlutterFragment$viewModel$2(this));
    @Inject
    public QCommerceViewModelFactory viewModelFactory;

    public QCommerceFlutterFragment() {
        super(PreWarmedEngines.ENGINE_QCOMMERCE, (RemoteConfiguration) null, 2, (DefaultConstructorMarker) null);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.configurationParams$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new QCommerceFlutterFragment$configurationParams$2(this));
        this.route$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new QCommerceFlutterFragment$route$2(this));
    }

    private final FlutterConfigurationParams getConfigurationParams() {
        return (FlutterConfigurationParams) this.configurationParams$delegate.getValue();
    }

    private final FlutterRoute getRoute() {
        return (FlutterRoute) this.route$delegate.getValue();
    }

    private final QCommerceViewModel getViewModel() {
        return (QCommerceViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void handleNavigationCommand(NavigationCommand navigationCommand) {
        if (navigationCommand instanceof NavigationCommand.ProductDetails) {
            getViewModel().onNavigateToProductDetails(this, ((NavigationCommand.ProductDetails) navigationCommand).getProductInfo());
        } else if (navigationCommand instanceof NavigationCommand.Cart) {
            getViewModel().onNavigateToCart(this);
        } else if (navigationCommand instanceof NavigationCommand.VendorLanding) {
            getViewModel().onNavigateToVendorLanding(this);
        } else if (navigationCommand instanceof NavigationCommand.BannerCampaignProductListing) {
            getViewModel().onBannerCampaignProductListing(this, ((NavigationCommand.BannerCampaignProductListing) navigationCommand).getTag());
        } else if (navigationCommand instanceof NavigationCommand.Checkout) {
            getViewModel().onNavigateToCheckout(((NavigationCommand.Checkout) navigationCommand).getSpecialRequest());
        } else if (!(navigationCommand instanceof NavigationCommand.VoucherProductListing)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void injectDependencies() {
        DaggerQCommerceFlutterPresentationComponent.factory().create((DarkstoresFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DarkstoresFeatureApi.class), (DarkstoresVendorApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DarkstoresVendorApi.class), (QCommerceFlutterFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(QCommerceFlutterFeatureApi.class), (DarkstoresFlutterCartApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DarkstoresFlutterCartApi.class), getConfigurationParams()).inject(this);
    }

    private final void subscribeToNavigationCommands() {
        getViewModel().getNavigationCommands().observe(this, new a(this));
    }

    @NotNull
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.DEEPLINK;
    }

    @NotNull
    public final QCommerceViewModelFactory getViewModelFactory() {
        QCommerceViewModelFactory qCommerceViewModelFactory = this.viewModelFactory;
        if (qCommerceViewModelFactory != null) {
            return qCommerceViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        injectDependencies();
        super.onAttach(context);
        Bundle arguments = getArguments();
        boolean z11 = false;
        if (arguments != null && arguments.getBoolean(BNPLCheckoutFlutterBottomSheetKt.ARGS_SHOULD_AUTOMATICALLY_HANDLE_ON_BACK_PRESSED, true)) {
            z11 = true;
        }
        if (z11) {
            QCommerceFlutterFragment$onAttach$1 qCommerceFlutterFragment$onAttach$1 = new QCommerceFlutterFragment$onAttach$1(this);
            this.routeOnBackPressToFlutter = qCommerceFlutterFragment$onAttach$1;
            requireActivity().getOnBackPressedDispatcher().addCallback(this, qCommerceFlutterFragment$onAttach$1);
        }
    }

    public void onBackPressedFromFlutter() {
        OnBackPressedDispatcher onBackPressedDispatcher;
        super.onBackPressedFromFlutter();
        OnBackPressedCallback onBackPressedCallback = this.routeOnBackPressToFlutter;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.setEnabled(false);
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.onBackPressed();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        subscribeToNavigationCommands();
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        getViewModel().setUpChannels(flutterEngine);
    }

    public final void setViewModelFactory(@NotNull QCommerceViewModelFactory qCommerceViewModelFactory) {
        Intrinsics.checkNotNullParameter(qCommerceViewModelFactory, "<set-?>");
        this.viewModelFactory = qCommerceViewModelFactory;
    }

    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    @NotNull
    /* renamed from: getRoute  reason: collision with other method in class */
    public String m10232getRoute() {
        return getRoute().buildRoute();
    }
}
