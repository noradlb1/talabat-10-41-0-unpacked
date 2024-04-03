package com.talabat.feature.tpro.presentation.helperview.mov;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewKt;
import androidx.lifecycle.ViewModelLazy;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.model.ProVendorMov;
import com.talabat.feature.tpro.presentation.databinding.TproVendorMovBinding;
import com.talabat.feature.tpro.presentation.di.DaggerTproPresentationComponent;
import com.talabat.feature.tpro.presentation.di.TproPresentationComponent;
import com.talabat.feature.tpro.presentation.util.DisplayAmountUtil;
import com.talabat.feature.tpro.presentation.util.ExtensionsKt;
import com.talabat.localization.R;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wo.a;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020'H\u0002J\b\u0010+\u001a\u00020'H\u0014J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020.H\u0002J\u0016\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010 \u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00062"}, d2 = {"Lcom/talabat/feature/tpro/presentation/helperview/mov/TProVendorMovView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/TproVendorMovBinding;", "branchId", "isNfvFlagEnabled", "Ljavax/inject/Provider;", "", "isNfvFlagEnabled$annotations", "()V", "()Ljavax/inject/Provider;", "setNfvFlagEnabled", "(Ljavax/inject/Provider;)V", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "viewModel", "Lcom/talabat/feature/tpro/presentation/helperview/mov/VendorMovViewModel;", "getViewModel", "()Lcom/talabat/feature/tpro/presentation/helperview/mov/VendorMovViewModel;", "viewModel$delegate", "Landroidx/lifecycle/ViewModelLazy;", "viewModelFactory", "Lcom/talabat/feature/tpro/presentation/helperview/mov/VendorMovViewModelFactory;", "getViewModelFactory", "()Lcom/talabat/feature/tpro/presentation/helperview/mov/VendorMovViewModelFactory;", "setViewModelFactory", "(Lcom/talabat/feature/tpro/presentation/helperview/mov/VendorMovViewModelFactory;)V", "handleProVendorMov", "", "proMov", "Lcom/talabat/feature/subscriptions/domain/model/ProVendorMov;", "initDagger", "onAttachedToWindow", "setupObservers", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "showTProMovIfApplicable", "isTProVendor", "vendorId", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProVendorMovView extends ConstraintLayout {
    @NotNull
    private final TproVendorMovBinding binding;
    private int branchId;
    @Inject
    public Provider<Boolean> isNfvFlagEnabled;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final ViewModelLazy viewModel$delegate;
    @Inject
    public VendorMovViewModelFactory viewModelFactory;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TProVendorMovView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TProVendorMovView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TProVendorMovView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final VendorMovViewModel getViewModel() {
        return (VendorMovViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void handleProVendorMov(ProVendorMov proVendorMov) {
        Float mov = proVendorMov.getMov();
        if (proVendorMov.getBranchId() == this.branchId && mov != null && !Intrinsics.areEqual(mov, 0.0f)) {
            ConstraintLayout constraintLayout = this.binding.layMov;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.layMov");
            constraintLayout.setVisibility(0);
            TextView textView = this.binding.tvMov;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvMov");
            Context context = getContext();
            int i11 = R.string.tpro_mov;
            String displayAmount = DisplayAmountUtil.INSTANCE.getDisplayAmount(getLocationConfigurationRepository(), mov.floatValue());
            String string = context.getString(i11, new Object[]{"<b>" + displayAmount + "</b>"});
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     …)}</b>\"\n                )");
            ExtensionsKt.renderContentAsHtml(textView, string);
        }
    }

    private final void initDagger() {
        TproPresentationComponent.Factory factory = DaggerTproPresentationComponent.factory();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        factory.create(context, (ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationRemoteCoreLibApi.class), (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((View) this).getFeature(SubscriptionsFeatureApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(DeepLinkCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
    }

    @Named("isTproNfvEnabled")
    public static /* synthetic */ void isNfvFlagEnabled$annotations() {
    }

    private final void setupObservers(LifecycleOwner lifecycleOwner) {
        getViewModel().getVendorMovLiveData().observe(lifecycleOwner, new a(this));
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
    public final VendorMovViewModelFactory getViewModelFactory() {
        VendorMovViewModelFactory vendorMovViewModelFactory = this.viewModelFactory;
        if (vendorMovViewModelFactory != null) {
            return vendorMovViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @NotNull
    public final Provider<Boolean> isNfvFlagEnabled() {
        Provider<Boolean> provider = this.isNfvFlagEnabled;
        if (provider != null) {
            return provider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("isNfvFlagEnabled");
        return null;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifecycleOwner findViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(this);
        if (findViewTreeLifecycleOwner != null) {
            setupObservers(findViewTreeLifecycleOwner);
        }
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setNfvFlagEnabled(@NotNull Provider<Boolean> provider) {
        Intrinsics.checkNotNullParameter(provider, "<set-?>");
        this.isNfvFlagEnabled = provider;
    }

    public final void setViewModelFactory(@NotNull VendorMovViewModelFactory vendorMovViewModelFactory) {
        Intrinsics.checkNotNullParameter(vendorMovViewModelFactory, "<set-?>");
        this.viewModelFactory = vendorMovViewModelFactory;
    }

    public final void showTProMovIfApplicable(boolean z11, int i11) {
        Boolean bool = isNfvFlagEnabled().get();
        Intrinsics.checkNotNullExpressionValue(bool, "isNfvFlagEnabled.get()");
        if (bool.booleanValue()) {
            this.branchId = i11;
            getViewModel().loadVendorMov(i11, z11);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TProVendorMovView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        TproVendorMovBinding inflate = TproVendorMovBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
        TProVendorMovView$viewModel$2 tProVendorMovView$viewModel$2 = new TProVendorMovView$viewModel$2(this);
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(VendorMovViewModel.class), new TProVendorMovView$special$$inlined$viewModels$1(this), tProVendorMovView$viewModel$2);
        initDagger();
        ConstraintLayout constraintLayout = inflate.layMov;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.layMov");
        constraintLayout.setVisibility(8);
    }
}
