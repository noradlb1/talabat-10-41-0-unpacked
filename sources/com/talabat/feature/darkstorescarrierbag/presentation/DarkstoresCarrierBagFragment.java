package com.talabat.feature.darkstorescarrierbag.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.designsystem.ds_radio_button.DSRadioButton;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.darkstorescarrierbag.presentation.databinding.FragmentCarrierBagBinding;
import com.talabat.feature.darkstorescarrierbag.presentation.model.CarrierBagOption;
import com.talabat.localization.R;
import dm.a;
import dm.b;
import dm.c;
import dm.d;
import dm.e;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u000e\u0010)\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u0011J\u0014\u0010*\u001a\u00020+*\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J\u0014\u0010,\u001a\u00020-*\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0011H\u0002R$\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR&\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u0018¨\u0006."}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/presentation/DarkstoresCarrierBagFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/talabat/feature/darkstorescarrierbag/presentation/databinding/FragmentCarrierBagBinding;", "getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation$annotations", "getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation", "()Lcom/talabat/feature/darkstorescarrierbag/presentation/databinding/FragmentCarrierBagBinding;", "setBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation", "(Lcom/talabat/feature/darkstorescarrierbag/presentation/databinding/FragmentCarrierBagBinding;)V", "realViewModel", "Lcom/talabat/feature/darkstorescarrierbag/presentation/DarkstoresCarrierBagViewModel;", "getRealViewModel", "()Lcom/talabat/feature/darkstorescarrierbag/presentation/DarkstoresCarrierBagViewModel;", "realViewModel$delegate", "Lkotlin/Lazy;", "selectedOption", "Lcom/talabat/feature/darkstorescarrierbag/presentation/model/CarrierBagOption;", "viewModel", "getViewModel", "viewModelOverride", "getViewModelOverride$com_talabat_feature_darkstores_carrier_bag_presentation_presentation$annotations", "getViewModelOverride$com_talabat_feature_darkstores_carrier_bag_presentation_presentation", "setViewModelOverride$com_talabat_feature_darkstores_carrier_bag_presentation_presentation", "(Lcom/talabat/feature/darkstorescarrierbag/presentation/DarkstoresCarrierBagViewModel;)V", "getOptionSelectedDescription", "", "option", "getOptionSelectedTitle", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onOptionClick", "", "onViewCreated", "view", "updateOptionSelected", "getContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRadioButton", "Lcom/designsystem/ds_radio_button/DSRadioButton;", "com_talabat_feature_darkstores-carrier-bag_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresCarrierBagFragment extends Fragment implements TraceFieldInterface {
    public Trace _nr_trace;
    public FragmentCarrierBagBinding binding;
    @NotNull
    private final Lazy realViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DarkstoresCarrierBagViewModel.class), new DarkstoresCarrierBagFragment$special$$inlined$activityViewModels$default$1(this), new DarkstoresCarrierBagFragment$special$$inlined$activityViewModels$default$2(this));
    @Nullable
    private CarrierBagOption selectedOption;
    @Nullable
    private DarkstoresCarrierBagViewModel viewModelOverride;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CarrierBagOption.values().length];
            iArr[CarrierBagOption.WITHOUT_BAG.ordinal()] = 1;
            iArr[CarrierBagOption.WITH_ECO_FRIENDLY_BAG.ordinal()] = 2;
            iArr[CarrierBagOption.WITH_PLASTIC_BAG.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation$annotations() {
    }

    private final ConstraintLayout getContainer(FragmentCarrierBagBinding fragmentCarrierBagBinding, CarrierBagOption carrierBagOption) {
        ConstraintLayout constraintLayout;
        int i11 = WhenMappings.$EnumSwitchMapping$0[carrierBagOption.ordinal()];
        if (i11 == 1) {
            constraintLayout = fragmentCarrierBagBinding.llOptions.clWithoutBag;
        } else if (i11 == 2) {
            constraintLayout = fragmentCarrierBagBinding.llOptions.clWithEcoFriendlyBag;
        } else if (i11 == 3) {
            constraintLayout = fragmentCarrierBagBinding.llOptions.clWithPlasticBag;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "when (option) {\n        …lWithPlasticBag\n        }");
        return constraintLayout;
    }

    private final int getOptionSelectedDescription(CarrierBagOption carrierBagOption) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[carrierBagOption.ordinal()];
        if (i11 == 1) {
            return R.string.darkstores_carrier_bag_without_bag_option_selected_description;
        }
        if (i11 == 2) {
            return R.string.darkstores_carrier_bag_eco_friendly_bag_option_selected_description;
        }
        if (i11 == 3) {
            return R.string.darkstores_carrier_bag_plastic_bag_option_selected_description;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int getOptionSelectedTitle(CarrierBagOption carrierBagOption) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[carrierBagOption.ordinal()];
        if (i11 == 1) {
            return R.string.darkstores_carrier_bag_without_bag_option_selected_title;
        }
        if (i11 == 2) {
            return R.string.darkstores_carrier_bag_eco_friendly_bag_option_selected_title;
        }
        if (i11 == 3) {
            return R.string.darkstores_carrier_bag_plastic_bag_option_selected_title;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final DSRadioButton getRadioButton(FragmentCarrierBagBinding fragmentCarrierBagBinding, CarrierBagOption carrierBagOption) {
        DSRadioButton dSRadioButton;
        int i11 = WhenMappings.$EnumSwitchMapping$0[carrierBagOption.ordinal()];
        if (i11 == 1) {
            dSRadioButton = fragmentCarrierBagBinding.llOptions.rbWithoutBag;
        } else if (i11 == 2) {
            dSRadioButton = fragmentCarrierBagBinding.llOptions.rbWithEcoFriendlyBag;
        } else if (i11 == 3) {
            dSRadioButton = fragmentCarrierBagBinding.llOptions.rbWithPlasticBag;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNullExpressionValue(dSRadioButton, "when (option) {\n        …bWithPlasticBag\n        }");
        return dSRadioButton;
    }

    private final DarkstoresCarrierBagViewModel getRealViewModel() {
        return (DarkstoresCarrierBagViewModel) this.realViewModel$delegate.getValue();
    }

    private final DarkstoresCarrierBagViewModel getViewModel() {
        DarkstoresCarrierBagViewModel darkstoresCarrierBagViewModel = this.viewModelOverride;
        return darkstoresCarrierBagViewModel == null ? getRealViewModel() : darkstoresCarrierBagViewModel;
    }

    @VisibleForTesting
    public static /* synthetic */ void getViewModelOverride$com_talabat_feature_darkstores_carrier_bag_presentation_presentation$annotations() {
    }

    private final void onOptionClick(CarrierBagOption carrierBagOption) {
        CarrierBagOption[] values = CarrierBagOption.values();
        int length = values.length;
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 < length) {
                CarrierBagOption carrierBagOption2 = values[i11];
                DSRadioButton radioButton = getRadioButton(getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation(), carrierBagOption2);
                if (carrierBagOption != carrierBagOption2) {
                    z11 = false;
                }
                radioButton.setRadioButtonChecked(z11);
                i11++;
            } else {
                this.selectedOption = carrierBagOption;
                getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation().llOptions.btnContinue.setEnabled(true);
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10159onViewCreated$lambda1$lambda0(DarkstoresCarrierBagFragment darkstoresCarrierBagFragment, CarrierBagOption carrierBagOption, View view) {
        Intrinsics.checkNotNullParameter(darkstoresCarrierBagFragment, "this$0");
        Intrinsics.checkNotNullParameter(carrierBagOption, "$option");
        darkstoresCarrierBagFragment.onOptionClick(carrierBagOption);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m10160onViewCreated$lambda2(DarkstoresCarrierBagFragment darkstoresCarrierBagFragment, View view) {
        Intrinsics.checkNotNullParameter(darkstoresCarrierBagFragment, "this$0");
        darkstoresCarrierBagFragment.getViewModel().onCloseClicked();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m10161onViewCreated$lambda3(DarkstoresCarrierBagFragment darkstoresCarrierBagFragment, View view) {
        Intrinsics.checkNotNullParameter(darkstoresCarrierBagFragment, "this$0");
        CarrierBagOption carrierBagOption = darkstoresCarrierBagFragment.selectedOption;
        if (carrierBagOption != null) {
            darkstoresCarrierBagFragment.getViewModel().onOptionSelected(carrierBagOption);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateOptionSelected$lambda-4  reason: not valid java name */
    public static final void m10162updateOptionSelected$lambda4(DarkstoresCarrierBagFragment darkstoresCarrierBagFragment, CarrierBagOption carrierBagOption, View view) {
        Intrinsics.checkNotNullParameter(darkstoresCarrierBagFragment, "this$0");
        Intrinsics.checkNotNullParameter(carrierBagOption, "$option");
        darkstoresCarrierBagFragment.getViewModel().onContinueToCheckoutClicked(carrierBagOption);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateOptionSelected$lambda-5  reason: not valid java name */
    public static final void m10163updateOptionSelected$lambda5(DarkstoresCarrierBagFragment darkstoresCarrierBagFragment, CarrierBagOption carrierBagOption, View view) {
        Intrinsics.checkNotNullParameter(darkstoresCarrierBagFragment, "this$0");
        Intrinsics.checkNotNullParameter(carrierBagOption, "$option");
        darkstoresCarrierBagFragment.getViewModel().onContinueToCheckoutClicked(carrierBagOption);
    }

    @NotNull
    public final FragmentCarrierBagBinding getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation() {
        FragmentCarrierBagBinding fragmentCarrierBagBinding = this.binding;
        if (fragmentCarrierBagBinding != null) {
            return fragmentCarrierBagBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @Nullable
    public final DarkstoresCarrierBagViewModel getViewModelOverride$com_talabat_feature_darkstores_carrier_bag_presentation_presentation() {
        return this.viewModelOverride;
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "DarkstoresCarrierBagFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "DarkstoresCarrierBagFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentCarrierBagBinding inflate = FragmentCarrierBagBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation(inflate);
        LinearLayout root = getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        TraceMachine.exitMethod();
        return root;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        for (CarrierBagOption carrierBagOption : CarrierBagOption.values()) {
            getContainer(getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation(), carrierBagOption).setOnClickListener(new c(this, carrierBagOption));
        }
        getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation().ivClose.setOnClickListener(new d(this));
        getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation().llOptions.btnContinue.setOnClickListener(new e(this));
    }

    public final void setBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation(@NotNull FragmentCarrierBagBinding fragmentCarrierBagBinding) {
        Intrinsics.checkNotNullParameter(fragmentCarrierBagBinding, "<set-?>");
        this.binding = fragmentCarrierBagBinding;
    }

    public final void setViewModelOverride$com_talabat_feature_darkstores_carrier_bag_presentation_presentation(@Nullable DarkstoresCarrierBagViewModel darkstoresCarrierBagViewModel) {
        this.viewModelOverride = darkstoresCarrierBagViewModel;
    }

    public final void updateOptionSelected(@NotNull CarrierBagOption carrierBagOption) {
        Intrinsics.checkNotNullParameter(carrierBagOption, "option");
        getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation().llOptions.getRoot().setVisibility(8);
        getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation().clSelectedOption.getRoot().setVisibility(0);
        getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation().clSelectedOption.tvOptionSelectedTitle.setText(getOptionSelectedTitle(carrierBagOption));
        getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation().clSelectedOption.tvOptionSelectedDescription.setText(getOptionSelectedDescription(carrierBagOption));
        getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation().ivClose.setOnClickListener(new a(this, carrierBagOption));
        getBinding$com_talabat_feature_darkstores_carrier_bag_presentation_presentation().clSelectedOption.tvContinueToCheckout.setOnClickListener(new b(this, carrierBagOption));
    }
}
