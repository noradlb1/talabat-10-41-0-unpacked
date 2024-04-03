package com.talabat.feature.nfvinvendorsearch.presentation.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.ViewModelLazy;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstoresflutter.domain.DarkstoresFlutterCartApi;
import com.talabat.feature.darkstoresvendor.domain.DarkstoresVendorApi;
import com.talabat.feature.nfvinvendorsearch.domain.di.QCommerceFlutterFeatureApi;
import com.talabat.feature.nfvinvendorsearch.presentation.di.DaggerQCommerceFlutterPresentationComponent;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.model.NavigationCommand;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import com.talabat.feature.nfvinvendorsearch.presentation.viewmodel.QCommerceViewModel;
import com.talabat.feature.nfvinvendorsearch.presentation.viewmodel.QCommerceViewModelFactory;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import gn.a;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterEngine;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/activity/QCommerceFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "()V", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "getConfigurationParams", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "configurationParams$delegate", "Lkotlin/Lazy;", "route", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "getRoute", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "route$delegate", "viewModel", "Lcom/talabat/feature/nfvinvendorsearch/presentation/viewmodel/QCommerceViewModel;", "getViewModel", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/viewmodel/QCommerceViewModel;", "viewModel$delegate", "viewModelFactory", "Lcom/talabat/feature/nfvinvendorsearch/presentation/viewmodel/QCommerceViewModelFactory;", "getViewModelFactory", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/viewmodel/QCommerceViewModelFactory;", "setViewModelFactory", "(Lcom/talabat/feature/nfvinvendorsearch/presentation/viewmodel/QCommerceViewModelFactory;)V", "", "handleNavigationCommand", "", "command", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/NavigationCommand;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpExtraChannels", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "subscribeToNavigationCommands", "Companion", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QCommerceFlutterActivity extends TalabatFlutterFragmentActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Lazy configurationParams$delegate;
    @NotNull
    private final Lazy route$delegate;
    @NotNull
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(QCommerceViewModel.class), new QCommerceFlutterActivity$special$$inlined$viewModels$default$2(this), new QCommerceFlutterActivity$viewModel$2(this), new QCommerceFlutterActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    @Inject
    public QCommerceViewModelFactory viewModelFactory;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/activity/QCommerceFlutterActivity$Companion;", "", "()V", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "route", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "backgroundMode", "Lio/flutter/embedding/android/FlutterActivityLaunchConfigs$BackgroundMode;", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent getIntent$default(Companion companion, Context context, FlutterConfigurationParams flutterConfigurationParams, FlutterRoute flutterRoute, FlutterActivityLaunchConfigs.BackgroundMode backgroundMode, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                backgroundMode = FlutterActivityLaunchConfigs.BackgroundMode.opaque;
            }
            return companion.getIntent(context, flutterConfigurationParams, flutterRoute, backgroundMode);
        }

        @NotNull
        public final Intent getIntent(@NotNull Context context, @NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute, @NotNull FlutterActivityLaunchConfigs.BackgroundMode backgroundMode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
            Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
            Intrinsics.checkNotNullParameter(backgroundMode, "backgroundMode");
            Intent intent = new Intent(context, QCommerceFlutterActivity.class);
            intent.putExtra(Constants.ARG_BACKGROUND_MODE, backgroundMode.name());
            intent.putExtra(Constants.ARG_CONFIGURATION_PARAMS, flutterConfigurationParams);
            intent.putExtra(Constants.ARG_ROUTE, flutterRoute);
            return intent;
        }
    }

    public QCommerceFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.configurationParams$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new QCommerceFlutterActivity$configurationParams$2(this));
        this.route$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new QCommerceFlutterActivity$route$2(this));
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
        if (navigationCommand instanceof NavigationCommand.Checkout) {
            setResult(-1);
            finish();
        } else if (navigationCommand instanceof NavigationCommand.ProductDetails) {
            Intent intent = new Intent();
            intent.putExtra(QCommerceFlutterActivityKt.KEY_PRODUCT_INFO, ((NavigationCommand.ProductDetails) navigationCommand).getProductInfo());
            setResult(-1, intent);
            finish();
        } else if (navigationCommand instanceof NavigationCommand.VoucherProductListing) {
            Intent intent2 = new Intent();
            NavigationCommand.VoucherProductListing voucherProductListing = (NavigationCommand.VoucherProductListing) navigationCommand;
            intent2.putExtra(QCommerceFlutterActivityKt.KEY_VOUCHER_ID, voucherProductListing.getVoucherDetails().getId());
            intent2.putExtra("voucher_name", voucherProductListing.getVoucherDetails().getName());
            intent2.putExtra(QCommerceFlutterActivityKt.KEY_VOUCHER_ORIGIN, voucherProductListing.getVoucherDetails().getEventOrigin());
            setResult(-1, intent2);
            finish();
        }
    }

    private final void subscribeToNavigationCommands() {
        getViewModel().getNavigationCommands().observe(this, new a(this));
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

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerQCommerceFlutterPresentationComponent.factory().create((DarkstoresFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DarkstoresFeatureApi.class), (DarkstoresVendorApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DarkstoresVendorApi.class), (QCommerceFlutterFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(QCommerceFlutterFeatureApi.class), (DarkstoresFlutterCartApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DarkstoresFlutterCartApi.class), getConfigurationParams()).inject(this);
        subscribeToNavigationCommands();
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.setUpExtraChannels(flutterEngine);
        getViewModel().setUpChannels(flutterEngine);
    }

    public final void setViewModelFactory(@NotNull QCommerceViewModelFactory qCommerceViewModelFactory) {
        Intrinsics.checkNotNullParameter(qCommerceViewModelFactory, "<set-?>");
        this.viewModelFactory = qCommerceViewModelFactory;
    }

    @NotNull
    /* renamed from: getRoute  reason: collision with other method in class */
    public String m10231getRoute() {
        return getRoute().buildRoute();
    }
}
