package com.talabat.feature.darkstores.presentation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelLazy;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.feature.darkstores.presentation.databinding.ActivityDarkstoreDeepLinkBinding;
import com.talabat.feature.darkstores.presentation.di.DaggerDarkStoresViewComponent;
import com.talabat.feature.darkstores.presentation.di.DarkStoresDeepLinkViewModelFactory;
import com.talabat.feature.darkstores.presentation.viewmodel.DarkStoresDeepLinkViewModel;
import com.talabat.feature.darkstores.presentation.viewstate.DarkStoreViewState;
import com.talabat.localization.R;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.a;
import tl.b;
import tl.c;

@Instrumented
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000204H\u0002J\u0012\u00106\u001a\u0002042\b\u00107\u001a\u0004\u0018\u000108H\u0014J\u0010\u00109\u001a\u0002042\u0006\u0010:\u001a\u00020 H\u0002J\u0010\u0010;\u001a\u0002042\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u0002042\u0006\u0010?\u001a\u00020 H\u0002J\b\u0010@\u001a\u000204H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00068BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0012\u0010\bR\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00068BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001a\u0010\bR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00068BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001d\u0010\bR\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b\u001f\u0010!R\u001b\u0010#\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b$\u0010\n\u001a\u0004\b#\u0010!R\u001d\u0010%\u001a\u0004\u0018\u00010\u00068BX\u0002¢\u0006\f\n\u0004\b'\u0010\n\u001a\u0004\b&\u0010\bR\u001b\u0010(\u001a\u00020)8BX\u0002¢\u0006\f\n\u0004\b,\u0010\n\u001a\u0004\b*\u0010+R\u001e\u0010-\u001a\u00020.8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006A"}, d2 = {"Lcom/talabat/feature/darkstores/presentation/activity/DarkStoresDeepLinkActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/talabat/feature/darkstores/presentation/databinding/ActivityDarkstoreDeepLinkBinding;", "branchId", "", "getBranchId", "()Ljava/lang/String;", "branchId$delegate", "Lkotlin/Lazy;", "darkStoresNavigator", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;", "getDarkStoresNavigator", "()Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;", "setDarkStoresNavigator", "(Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;)V", "deeplinkInfo", "getDeeplinkInfo", "deeplinkInfo$delegate", "deeplinkType", "", "getDeeplinkType", "()Ljava/lang/Integer;", "deeplinkType$delegate", "eventOrigin", "getEventOrigin", "eventOrigin$delegate", "experimentKey", "getExperimentKey", "experimentKey$delegate", "isDarkStore", "", "()Z", "isDarkStore$delegate", "isMigrated", "isMigrated$delegate", "shopClickOrigin", "getShopClickOrigin", "shopClickOrigin$delegate", "viewModel", "Lcom/talabat/feature/darkstores/presentation/viewmodel/DarkStoresDeepLinkViewModel;", "getViewModel", "()Lcom/talabat/feature/darkstores/presentation/viewmodel/DarkStoresDeepLinkViewModel;", "viewModel$delegate", "viewModelFactory", "Lcom/talabat/feature/darkstores/presentation/di/DarkStoresDeepLinkViewModelFactory;", "getViewModelFactory$com_talabat_feature_darkstores_presentation_presentation", "()Lcom/talabat/feature/darkstores/presentation/di/DarkStoresDeepLinkViewModelFactory;", "setViewModelFactory$com_talabat_feature_darkstores_presentation_presentation", "(Lcom/talabat/feature/darkstores/presentation/di/DarkStoresDeepLinkViewModelFactory;)V", "hideLoading", "", "initDagger", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDarkStoresErrorStatusChange", "hasError", "onDarkStoresViewStateChange", "viewState", "Lcom/talabat/feature/darkstores/presentation/viewstate/DarkStoreViewState;", "onValidVendor", "isValid", "showLoading", "com_talabat_feature_darkstores_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkStoresDeepLinkActivity extends AppCompatActivity implements TraceFieldInterface {
    public Trace _nr_trace;
    private ActivityDarkstoreDeepLinkBinding binding;
    @NotNull
    private final Lazy branchId$delegate;
    @Inject
    public DarkstoresNavigator darkStoresNavigator;
    @NotNull
    private final Lazy deeplinkInfo$delegate;
    @NotNull
    private final Lazy deeplinkType$delegate;
    @NotNull
    private final Lazy eventOrigin$delegate;
    @NotNull
    private final Lazy experimentKey$delegate;
    @NotNull
    private final Lazy isDarkStore$delegate;
    @NotNull
    private final Lazy isMigrated$delegate;
    @NotNull
    private final Lazy shopClickOrigin$delegate;
    @NotNull
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DarkStoresDeepLinkViewModel.class), new DarkStoresDeepLinkActivity$special$$inlined$viewModels$default$2(this), new DarkStoresDeepLinkActivity$viewModel$2(this), new DarkStoresDeepLinkActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    @Inject
    public DarkStoresDeepLinkViewModelFactory viewModelFactory;

    public DarkStoresDeepLinkActivity() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.deeplinkType$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DarkStoresDeepLinkActivity$deeplinkType$2(this));
        this.deeplinkInfo$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DarkStoresDeepLinkActivity$deeplinkInfo$2(this));
        this.eventOrigin$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DarkStoresDeepLinkActivity$eventOrigin$2(this));
        this.isDarkStore$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DarkStoresDeepLinkActivity$isDarkStore$2(this));
        this.isMigrated$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DarkStoresDeepLinkActivity$isMigrated$2(this));
        this.branchId$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DarkStoresDeepLinkActivity$branchId$2(this));
        this.experimentKey$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DarkStoresDeepLinkActivity$experimentKey$2(this));
        this.shopClickOrigin$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DarkStoresDeepLinkActivity$shopClickOrigin$2(this));
    }

    private final String getBranchId() {
        return (String) this.branchId$delegate.getValue();
    }

    private final String getDeeplinkInfo() {
        return (String) this.deeplinkInfo$delegate.getValue();
    }

    private final Integer getDeeplinkType() {
        return (Integer) this.deeplinkType$delegate.getValue();
    }

    private final String getEventOrigin() {
        return (String) this.eventOrigin$delegate.getValue();
    }

    private final String getExperimentKey() {
        return (String) this.experimentKey$delegate.getValue();
    }

    private final String getShopClickOrigin() {
        return (String) this.shopClickOrigin$delegate.getValue();
    }

    private final DarkStoresDeepLinkViewModel getViewModel() {
        return (DarkStoresDeepLinkViewModel) this.viewModel$delegate.getValue();
    }

    private final void hideLoading() {
        ActivityDarkstoreDeepLinkBinding activityDarkstoreDeepLinkBinding = this.binding;
        if (activityDarkstoreDeepLinkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDarkstoreDeepLinkBinding = null;
        }
        activityDarkstoreDeepLinkBinding.darkstoreDeeplinkLoadingView.setVisibility(8);
        finish();
    }

    private final void initDagger() {
        DaggerDarkStoresViewComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (DarkstoresFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DarkstoresFeatureApi.class)).inject(this);
    }

    private final boolean isDarkStore() {
        return ((Boolean) this.isDarkStore$delegate.getValue()).booleanValue();
    }

    private final boolean isMigrated() {
        return ((Boolean) this.isMigrated$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final void onDarkStoresErrorStatusChange(boolean z11) {
        if (z11) {
            Toast.makeText(this, getString(R.string.something_went_wrong), 1).show();
            finish();
        }
    }

    /* access modifiers changed from: private */
    public final void onDarkStoresViewStateChange(DarkStoreViewState darkStoreViewState) {
        DarkStoreViewState darkStoreViewState2 = darkStoreViewState;
        if (darkStoreViewState2 instanceof DarkStoreViewState.Loading) {
            showLoading();
        } else if (darkStoreViewState2 instanceof DarkStoreViewState.Navigating) {
            DarkstoresNavigator.DefaultImpls.navigateToDarkStore$default(getDarkStoresNavigator(), this, ((DarkStoreViewState.Navigating) darkStoreViewState2).getRestaurant(), getDeeplinkType(), getDeeplinkInfo(), (String) null, (String) null, false, (String) null, getEventOrigin(), getShopClickOrigin(), getExperimentKey(), (DarkstoresTrackingData) null, 2288, (Object) null);
            finish();
        } else if (Intrinsics.areEqual((Object) darkStoreViewState2, (Object) DarkStoreViewState.Hidden.INSTANCE)) {
            hideLoading();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public final void onValidVendor(boolean z11) {
        if (!z11) {
            return;
        }
        if (!isDarkStore() || isMigrated()) {
            getViewModel().fetchMigratedVendorInfo(getBranchId());
        } else {
            getViewModel().fetchDarkStoreInfo();
        }
    }

    private final void showLoading() {
        ActivityDarkstoreDeepLinkBinding activityDarkstoreDeepLinkBinding = this.binding;
        if (activityDarkstoreDeepLinkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDarkstoreDeepLinkBinding = null;
        }
        activityDarkstoreDeepLinkBinding.darkstoreDeeplinkLoadingView.setVisibility(0);
    }

    @NotNull
    public final DarkstoresNavigator getDarkStoresNavigator() {
        DarkstoresNavigator darkstoresNavigator = this.darkStoresNavigator;
        if (darkstoresNavigator != null) {
            return darkstoresNavigator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("darkStoresNavigator");
        return null;
    }

    @NotNull
    public final DarkStoresDeepLinkViewModelFactory getViewModelFactory$com_talabat_feature_darkstores_presentation_presentation() {
        DarkStoresDeepLinkViewModelFactory darkStoresDeepLinkViewModelFactory = this.viewModelFactory;
        if (darkStoresDeepLinkViewModelFactory != null) {
            return darkStoresDeepLinkViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("DarkStoresDeepLinkActivity");
        ActivityDarkstoreDeepLinkBinding activityDarkstoreDeepLinkBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "DarkStoresDeepLinkActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "DarkStoresDeepLinkActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        initDagger();
        ActivityDarkstoreDeepLinkBinding inflate = ActivityDarkstoreDeepLinkBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityDarkstoreDeepLinkBinding = inflate;
        }
        setContentView((View) activityDarkstoreDeepLinkBinding.getRoot());
        getViewModel().isValidVendorLiveData().observe(this, new a(this));
        getViewModel().getDarkStoreViewStateLiveData().observe(this, new b(this));
        getViewModel().getDarkStoreErrorLiveData().observe(this, new c(this));
        getViewModel().validateIfValidVendor(isDarkStore(), isMigrated());
        TraceMachine.exitMethod();
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public final void setDarkStoresNavigator(@NotNull DarkstoresNavigator darkstoresNavigator) {
        Intrinsics.checkNotNullParameter(darkstoresNavigator, "<set-?>");
        this.darkStoresNavigator = darkstoresNavigator;
    }

    public final void setViewModelFactory$com_talabat_feature_darkstores_presentation_presentation(@NotNull DarkStoresDeepLinkViewModelFactory darkStoresDeepLinkViewModelFactory) {
        Intrinsics.checkNotNullParameter(darkStoresDeepLinkViewModelFactory, "<set-?>");
        this.viewModelFactory = darkStoresDeepLinkViewModelFactory;
    }
}
