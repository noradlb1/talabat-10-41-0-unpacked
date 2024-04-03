package com.talabat.feature.darkstorescarrierbag.presentation;

import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.darkstorescarrierbag.presentation.di.DaggerDarkstoresCarrierBagComponent;
import com.talabat.feature.darkstorescarrierbag.presentation.model.CarrierBagOption;
import com.talabat.feature.darkstorescarrierbag.presentation.model.DarkstoresCarrierBagEvent;
import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import com.talabat.wrapper.EventWrapper;
import dm.f;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010%\u001a\u00020\bH\u0002J\u0015\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)J\u0010\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020,H\u0002J\u0006\u0010-\u001a\u00020\bJ\b\u0010.\u001a\u00020\bH\u0002R&\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006/"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/presentation/DarkstoresCarrierBagManager;", "", "parentFragment", "Landroidx/fragment/app/Fragment;", "vendorCode", "", "continueToCheckout", "Lkotlin/Function0;", "", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "bottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "getBottomSheet$com_talabat_feature_darkstores_carrier_bag_presentation_presentation$annotations", "()V", "getBottomSheet$com_talabat_feature_darkstores_carrier_bag_presentation_presentation", "()Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "setBottomSheet$com_talabat_feature_darkstores_carrier_bag_presentation_presentation", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;)V", "darkstoresCarrierBagFragment", "Lcom/talabat/feature/darkstorescarrierbag/presentation/DarkstoresCarrierBagFragment;", "getDarkstoresCarrierBagFragment$com_talabat_feature_darkstores_carrier_bag_presentation_presentation$annotations", "getDarkstoresCarrierBagFragment$com_talabat_feature_darkstores_carrier_bag_presentation_presentation", "()Lcom/talabat/feature/darkstorescarrierbag/presentation/DarkstoresCarrierBagFragment;", "setDarkstoresCarrierBagFragment$com_talabat_feature_darkstores_carrier_bag_presentation_presentation", "(Lcom/talabat/feature/darkstorescarrierbag/presentation/DarkstoresCarrierBagFragment;)V", "viewModel", "Lcom/talabat/feature/darkstorescarrierbag/presentation/DarkstoresCarrierBagViewModel;", "getViewModel", "()Lcom/talabat/feature/darkstorescarrierbag/presentation/DarkstoresCarrierBagViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "dismissBottomSheet", "handleEvent", "event", "Lcom/talabat/feature/darkstorescarrierbag/presentation/model/DarkstoresCarrierBagEvent;", "handleEvent$com_talabat_feature_darkstores_carrier_bag_presentation_presentation", "onOptionSelected", "option", "Lcom/talabat/feature/darkstorescarrierbag/presentation/model/CarrierBagOption;", "show", "showBottomSheet", "com_talabat_feature_darkstores-carrier-bag_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresCarrierBagManager {
    @Nullable
    private DSBottomSheet bottomSheet;
    @NotNull
    private final Function0<Unit> continueToCheckout;
    @Nullable
    private DarkstoresCarrierBagFragment darkstoresCarrierBagFragment;
    @NotNull
    private final Fragment parentFragment;
    @NotNull
    private final String vendorCode;
    @NotNull
    private final Lazy viewModel$delegate;
    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    public DarkstoresCarrierBagManager(@NotNull Fragment fragment, @NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(fragment, "parentFragment");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(function0, "continueToCheckout");
        this.parentFragment = fragment;
        this.vendorCode = str;
        this.continueToCheckout = function0;
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DarkstoresCarrierBagViewModel.class), new DarkstoresCarrierBagManager$special$$inlined$activityViewModels$1(fragment), new DarkstoresCarrierBagManager$viewModel$2(this));
    }

    private final void dismissBottomSheet() {
        DSBottomSheet dSBottomSheet = this.bottomSheet;
        if (dSBottomSheet != null) {
            dSBottomSheet.dismiss();
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getBottomSheet$com_talabat_feature_darkstores_carrier_bag_presentation_presentation$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getDarkstoresCarrierBagFragment$com_talabat_feature_darkstores_carrier_bag_presentation_presentation$annotations() {
    }

    private final DarkstoresCarrierBagViewModel getViewModel() {
        return (DarkstoresCarrierBagViewModel) this.viewModel$delegate.getValue();
    }

    private final void onOptionSelected(CarrierBagOption carrierBagOption) {
        DarkstoresCarrierBagFragment darkstoresCarrierBagFragment2 = this.darkstoresCarrierBagFragment;
        if (darkstoresCarrierBagFragment2 != null) {
            darkstoresCarrierBagFragment2.updateOptionSelected(carrierBagOption);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-0  reason: not valid java name */
    public static final void m10164show$lambda0(DarkstoresCarrierBagManager darkstoresCarrierBagManager, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(darkstoresCarrierBagManager, "this$0");
        DarkstoresCarrierBagEvent darkstoresCarrierBagEvent = (DarkstoresCarrierBagEvent) eventWrapper.getContentIfNotHandled();
        if (darkstoresCarrierBagEvent != null) {
            darkstoresCarrierBagManager.handleEvent$com_talabat_feature_darkstores_carrier_bag_presentation_presentation(darkstoresCarrierBagEvent);
        }
    }

    private final void showBottomSheet() {
        DSBottomSheet dSBottomSheet = this.bottomSheet;
        if (dSBottomSheet != null) {
            dSBottomSheet.dismiss();
        }
        this.darkstoresCarrierBagFragment = new DarkstoresCarrierBagFragment();
        DSBottomSheet dSBottomSheet2 = new DSBottomSheet();
        dSBottomSheet2.setBody(this.darkstoresCarrierBagFragment);
        dSBottomSheet2.setCancelable(false);
        FragmentManager childFragmentManager = this.parentFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "parentFragment.childFragmentManager");
        dSBottomSheet2.show(childFragmentManager);
        this.bottomSheet = dSBottomSheet2;
    }

    @Nullable
    public final DSBottomSheet getBottomSheet$com_talabat_feature_darkstores_carrier_bag_presentation_presentation() {
        return this.bottomSheet;
    }

    @Nullable
    public final DarkstoresCarrierBagFragment getDarkstoresCarrierBagFragment$com_talabat_feature_darkstores_carrier_bag_presentation_presentation() {
        return this.darkstoresCarrierBagFragment;
    }

    @NotNull
    public final ViewModelProvider.Factory getViewModelFactory() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @VisibleForTesting
    public final void handleEvent$com_talabat_feature_darkstores_carrier_bag_presentation_presentation(@NotNull DarkstoresCarrierBagEvent darkstoresCarrierBagEvent) {
        Intrinsics.checkNotNullParameter(darkstoresCarrierBagEvent, "event");
        if (darkstoresCarrierBagEvent instanceof DarkstoresCarrierBagEvent.ShowBottomSheet) {
            showBottomSheet();
        } else if (darkstoresCarrierBagEvent instanceof DarkstoresCarrierBagEvent.HideBottomSheet) {
            dismissBottomSheet();
        } else if (darkstoresCarrierBagEvent instanceof DarkstoresCarrierBagEvent.OnOptionSelected) {
            onOptionSelected(((DarkstoresCarrierBagEvent.OnOptionSelected) darkstoresCarrierBagEvent).getOption());
        } else if (darkstoresCarrierBagEvent instanceof DarkstoresCarrierBagEvent.ContinueToCheckout) {
            dismissBottomSheet();
            this.continueToCheckout.invoke();
        }
    }

    public final void setBottomSheet$com_talabat_feature_darkstores_carrier_bag_presentation_presentation(@Nullable DSBottomSheet dSBottomSheet) {
        this.bottomSheet = dSBottomSheet;
    }

    public final void setDarkstoresCarrierBagFragment$com_talabat_feature_darkstores_carrier_bag_presentation_presentation(@Nullable DarkstoresCarrierBagFragment darkstoresCarrierBagFragment2) {
        this.darkstoresCarrierBagFragment = darkstoresCarrierBagFragment2;
    }

    public final void setViewModelFactory(@NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    public final void show() {
        ApiContainer apiContainer = AndroidComponentsKt.apiContainer(this.parentFragment);
        DaggerDarkstoresCarrierBagComponent.factory().create(this.vendorCode, (ContextCoreLibApi) apiContainer.getFeature(ContextCoreLibApi.class), (DispatcherCoreLibApi) apiContainer.getFeature(DispatcherCoreLibApi.class), (ExperimentCoreLibApi) apiContainer.getFeature(ExperimentCoreLibApi.class), (TrackingCoreLibApi) apiContainer.getFeature(TrackingCoreLibApi.class)).inject(this);
        getViewModel().getEvents().observe(this.parentFragment.getViewLifecycleOwner(), new f(this));
        getViewModel().onInitialized();
    }
}
