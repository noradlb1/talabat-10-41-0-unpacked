package com.talabat.feature.mission.control.presentation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewKt;
import androidx.lifecycle.ViewModelLazy;
import bn.e;
import com.designsystem.marshmallow.R;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.mission.control.domain.MissionControlFeatureApi;
import com.talabat.feature.mission.control.domain.model.PrimaryMissionControl;
import com.talabat.feature.mission.control.domain.model.PrimaryMissionControlData;
import com.talabat.feature.mission.control.presentation.databinding.PrimaryMissionViewBinding;
import com.talabat.feature.mission.control.presentation.di.DaggerMissionControlViewComponent;
import com.talabat.feature.mission.control.presentation.viewmodel.PrimaryMissionViewModel;
import com.talabat.feature.mission.control.presentation.viewmodel.PrimaryMissionViewModelFactory;
import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J^\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2>\u0010$\u001a:\u0012\u0013\u0012\u00110 ¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110 ¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0018\u0018\u00010%j\u0004\u0018\u0001`)J\b\u0010*\u001a\u00020\u0018H\u0014JH\u0010+\u001a\u00020\u00182>\u0010$\u001a:\u0012\u0013\u0012\u00110 ¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110 ¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0018\u0018\u00010%j\u0004\u0018\u0001`)H\u0002J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020.H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006/"}, d2 = {"Lcom/talabat/feature/mission/control/presentation/PrimaryMissionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/feature/mission/control/presentation/databinding/PrimaryMissionViewBinding;", "factory", "Lcom/talabat/feature/mission/control/presentation/viewmodel/PrimaryMissionViewModelFactory;", "getFactory", "()Lcom/talabat/feature/mission/control/presentation/viewmodel/PrimaryMissionViewModelFactory;", "setFactory", "(Lcom/talabat/feature/mission/control/presentation/viewmodel/PrimaryMissionViewModelFactory;)V", "viewModel", "Lcom/talabat/feature/mission/control/presentation/viewmodel/PrimaryMissionViewModel;", "getViewModel", "()Lcom/talabat/feature/mission/control/presentation/viewmodel/PrimaryMissionViewModel;", "viewModel$delegate", "Landroidx/lifecycle/ViewModelLazy;", "bindThreePrimaryMission", "", "firstPrimaryMission", "Lcom/talabat/feature/mission/control/domain/model/PrimaryMissionControlData;", "secondPrimaryMission", "thirdPrimaryMission", "bindTwoPrimaryMission", "load", "vendorId", "", "vendorCode", "isDarkstores", "", "primaryMissionClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "code", "Lcom/talabat/feature/mission/control/presentation/listener/PrimaryMissionClickListener;", "onAttachedToWindow", "setClickListeners", "setContent", "primaryMission", "Lcom/talabat/feature/mission/control/domain/model/PrimaryMissionControl;", "com_talabat_feature_mission-control_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrimaryMissionView extends LinearLayout {
    @NotNull
    private final PrimaryMissionViewBinding binding;
    @Inject
    public PrimaryMissionViewModelFactory factory;
    @NotNull
    private final ViewModelLazy viewModel$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PrimaryMissionView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PrimaryMissionView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PrimaryMissionView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void bindThreePrimaryMission(PrimaryMissionControlData primaryMissionControlData, PrimaryMissionControlData primaryMissionControlData2, PrimaryMissionControlData primaryMissionControlData3) {
        setVisibility(0);
        ThreePrimaryMissionView threePrimaryMissionView = this.binding.threePrimaryMissionView;
        Intrinsics.checkNotNullExpressionValue(threePrimaryMissionView, "binding.threePrimaryMissionView");
        threePrimaryMissionView.setVisibility(0);
        TwoPrimaryMissionView twoPrimaryMissionView = this.binding.twoPrimaryMissionView;
        Intrinsics.checkNotNullExpressionValue(twoPrimaryMissionView, "binding.twoPrimaryMissionView");
        twoPrimaryMissionView.setVisibility(8);
        this.binding.threePrimaryMissionView.setContent(primaryMissionControlData, primaryMissionControlData2, primaryMissionControlData3);
    }

    private final void bindTwoPrimaryMission(PrimaryMissionControlData primaryMissionControlData, PrimaryMissionControlData primaryMissionControlData2) {
        setVisibility(0);
        TwoPrimaryMissionView twoPrimaryMissionView = this.binding.twoPrimaryMissionView;
        Intrinsics.checkNotNullExpressionValue(twoPrimaryMissionView, "binding.twoPrimaryMissionView");
        twoPrimaryMissionView.setVisibility(0);
        ThreePrimaryMissionView threePrimaryMissionView = this.binding.threePrimaryMissionView;
        Intrinsics.checkNotNullExpressionValue(threePrimaryMissionView, "binding.threePrimaryMissionView");
        threePrimaryMissionView.setVisibility(8);
        this.binding.twoPrimaryMissionView.setContent(primaryMissionControlData, primaryMissionControlData2, getViewModel().isPrimaryMissionTwoTiles(), getViewModel().isNewIcon());
    }

    /* access modifiers changed from: private */
    public final PrimaryMissionViewModel getViewModel() {
        return (PrimaryMissionViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachedToWindow$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10225onAttachedToWindow$lambda1$lambda0(PrimaryMissionView primaryMissionView, PrimaryMissionControl primaryMissionControl) {
        Intrinsics.checkNotNullParameter(primaryMissionView, "this$0");
        Intrinsics.checkNotNullExpressionValue(primaryMissionControl, "primaryMission");
        primaryMissionView.setContent(primaryMissionControl);
    }

    private final void setClickListeners(Function2<? super String, ? super String, Unit> function2) {
        this.binding.twoPrimaryMissionView.setMissionClickListener(new PrimaryMissionView$setClickListeners$1(function2, this));
        this.binding.threePrimaryMissionView.setMissionClickListener(new PrimaryMissionView$setClickListeners$2(function2, this));
    }

    private final void setContent(PrimaryMissionControl primaryMissionControl) {
        int size = primaryMissionControl.getMissions().size();
        if (size == 2) {
            bindTwoPrimaryMission(primaryMissionControl.getMissions().get(0), primaryMissionControl.getMissions().get(1));
        } else if (size == 3) {
            bindThreePrimaryMission(primaryMissionControl.getMissions().get(0), primaryMissionControl.getMissions().get(1), primaryMissionControl.getMissions().get(2));
        }
    }

    @NotNull
    public final PrimaryMissionViewModelFactory getFactory() {
        PrimaryMissionViewModelFactory primaryMissionViewModelFactory = this.factory;
        if (primaryMissionViewModelFactory != null) {
            return primaryMissionViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    public final void load(@NotNull String str, @NotNull String str2, boolean z11, @Nullable Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        setClickListeners(function2);
        getViewModel().getPrimaryMissionControls(str, str2, z11);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifecycleOwner findViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(this);
        if (findViewTreeLifecycleOwner != null) {
            getViewModel().getPrimaryMission().observe(findViewTreeLifecycleOwner, new e(this));
        }
    }

    public final void setFactory(@NotNull PrimaryMissionViewModelFactory primaryMissionViewModelFactory) {
        Intrinsics.checkNotNullParameter(primaryMissionViewModelFactory, "<set-?>");
        this.factory = primaryMissionViewModelFactory;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PrimaryMissionView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        PrimaryMissionView$viewModel$2 primaryMissionView$viewModel$2 = new PrimaryMissionView$viewModel$2(this);
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PrimaryMissionViewModel.class), new PrimaryMissionView$special$$inlined$viewModels$1(this), primaryMissionView$viewModel$2);
        PrimaryMissionViewBinding inflate = PrimaryMissionViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds_xs);
        setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0);
        setVisibility(8);
        DaggerMissionControlViewComponent.factory().create((ExperimentCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ExperimentCoreLibApi.class), (MissionControlFeatureApi) AndroidComponentsKt.apiContainer((View) this).getFeature(MissionControlFeatureApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(TrackingCoreLibApi.class)).inject(this);
    }
}
