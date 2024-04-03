package com.talabat.feature.activecarts.presentation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.ViewModelLazy;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.activecarts.domain.di.ActiveCartsApi;
import com.talabat.feature.activecarts.presentation.di.DaggerBasketListPresentationComponent;
import com.talabat.feature.activecarts.presentation.viewmodel.BasketListViewModel;
import com.talabat.feature.activecarts.presentation.viewmodel.BasketListViewModelFactory;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterEngine;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/activecarts/presentation/BasketListActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "()V", "viewModel", "Lcom/talabat/feature/activecarts/presentation/viewmodel/BasketListViewModel;", "getViewModel", "()Lcom/talabat/feature/activecarts/presentation/viewmodel/BasketListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Lcom/talabat/feature/activecarts/presentation/viewmodel/BasketListViewModelFactory;", "getViewModelFactory", "()Lcom/talabat/feature/activecarts/presentation/viewmodel/BasketListViewModelFactory;", "setViewModelFactory", "(Lcom/talabat/feature/activecarts/presentation/viewmodel/BasketListViewModelFactory;)V", "getRoute", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setUpExtraChannels", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "Companion", "com_talabat_feature_active-carts_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BasketListActivity extends TalabatFlutterFragmentActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String EXTRA_BACKGROUND_MODE = "background_mode";
    @NotNull
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(BasketListViewModel.class), new BasketListActivity$special$$inlined$viewModels$default$2(this), new BasketListActivity$viewModel$2(this), new BasketListActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    @Inject
    public BasketListViewModelFactory viewModelFactory;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/activecarts/presentation/BasketListActivity$Companion;", "", "()V", "EXTRA_BACKGROUND_MODE", "", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "com_talabat_feature_active-carts_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent getIntent(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, BasketListActivity.class);
            intent.putExtra("background_mode", FlutterActivityLaunchConfigs.BackgroundMode.transparent.name());
            return intent;
        }
    }

    public BasketListActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
    }

    private final BasketListViewModel getViewModel() {
        return (BasketListViewModel) this.viewModel$delegate.getValue();
    }

    @NotNull
    public String getRoute() {
        return "/basket-listing";
    }

    @NotNull
    public final BasketListViewModelFactory getViewModelFactory() {
        BasketListViewModelFactory basketListViewModelFactory = this.viewModelFactory;
        if (basketListViewModelFactory != null) {
            return basketListViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerBasketListPresentationComponent.factory().create((ActiveCartsApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ActiveCartsApi.class), (DarkstoresFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DarkstoresFeatureApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(NavigationCoreLibApi.class), this).inject(this);
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.setUpExtraChannels(flutterEngine);
        getViewModel().setUpChannels(flutterEngine);
    }

    public final void setViewModelFactory(@NotNull BasketListViewModelFactory basketListViewModelFactory) {
        Intrinsics.checkNotNullParameter(basketListViewModelFactory, "<set-?>");
        this.viewModelFactory = basketListViewModelFactory;
    }
}
