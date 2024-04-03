package com.talabat.feature.mission.control.presentation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewKt;
import androidx.lifecycle.ViewModelLazy;
import bn.b;
import com.designsystem.marshmallow.R;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.mission.control.domain.MissionControlFeatureApi;
import com.talabat.feature.mission.control.domain.model.LifeStyleMissionControl;
import com.talabat.feature.mission.control.domain.model.LifeStyleMissionControlData;
import com.talabat.feature.mission.control.presentation.databinding.LifeStyleMissionViewBinding;
import com.talabat.feature.mission.control.presentation.di.DaggerMissionControlViewComponent;
import com.talabat.feature.mission.control.presentation.viewmodel.LifeStyleMissionViewModel;
import com.talabat.feature.mission.control.presentation.viewmodel.LifeStyleMissionViewModelFactory;
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

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J^\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2>\u0010$\u001a:\u0012\u0013\u0012\u00110 ¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110 ¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0018\u0018\u00010%j\u0004\u0018\u0001`)J\b\u0010*\u001a\u00020\u0018H\u0014JH\u0010+\u001a\u00020\u00182>\u0010$\u001a:\u0012\u0013\u0012\u00110 ¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110 ¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0018\u0018\u00010%j\u0004\u0018\u0001`)H\u0002J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020.H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006/"}, d2 = {"Lcom/talabat/feature/mission/control/presentation/LifeStyleMissionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/feature/mission/control/presentation/databinding/LifeStyleMissionViewBinding;", "factory", "Lcom/talabat/feature/mission/control/presentation/viewmodel/LifeStyleMissionViewModelFactory;", "getFactory", "()Lcom/talabat/feature/mission/control/presentation/viewmodel/LifeStyleMissionViewModelFactory;", "setFactory", "(Lcom/talabat/feature/mission/control/presentation/viewmodel/LifeStyleMissionViewModelFactory;)V", "viewModel", "Lcom/talabat/feature/mission/control/presentation/viewmodel/LifeStyleMissionViewModel;", "getViewModel", "()Lcom/talabat/feature/mission/control/presentation/viewmodel/LifeStyleMissionViewModel;", "viewModel$delegate", "Landroidx/lifecycle/ViewModelLazy;", "bindOneLifeStyleMission", "", "mission", "Lcom/talabat/feature/mission/control/domain/model/LifeStyleMissionControlData;", "bindTwoLifeStyleMission", "firstLifeStyleMission", "secondLifeStyleMission", "load", "vendorId", "", "vendorCode", "isDarkstores", "", "lifeStyleMissionClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "code", "Lcom/talabat/feature/mission/control/presentation/listener/LifeStyleMissionClickListener;", "onAttachedToWindow", "setClickListeners", "setContent", "lifeStyleMission", "Lcom/talabat/feature/mission/control/domain/model/LifeStyleMissionControl;", "com_talabat_feature_mission-control_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifeStyleMissionView extends LinearLayout {
    @NotNull
    private final LifeStyleMissionViewBinding binding;
    @Inject
    public LifeStyleMissionViewModelFactory factory;
    @NotNull
    private final ViewModelLazy viewModel$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LifeStyleMissionView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LifeStyleMissionView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LifeStyleMissionView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void bindOneLifeStyleMission(LifeStyleMissionControlData lifeStyleMissionControlData) {
        setVisibility(0);
        OneLifeStyleMissionItem oneLifeStyleMissionItem = this.binding.oneLifeStyleMission;
        Intrinsics.checkNotNullExpressionValue(oneLifeStyleMissionItem, "binding.oneLifeStyleMission");
        oneLifeStyleMissionItem.setVisibility(0);
        TwoLifeStyleMissionItem twoLifeStyleMissionItem = this.binding.twoLifeStyleMission;
        Intrinsics.checkNotNullExpressionValue(twoLifeStyleMissionItem, "binding.twoLifeStyleMission");
        twoLifeStyleMissionItem.setVisibility(8);
        this.binding.oneLifeStyleMission.setContent(lifeStyleMissionControlData, 0);
    }

    private final void bindTwoLifeStyleMission(LifeStyleMissionControlData lifeStyleMissionControlData, LifeStyleMissionControlData lifeStyleMissionControlData2) {
        setVisibility(0);
        TwoLifeStyleMissionItem twoLifeStyleMissionItem = this.binding.twoLifeStyleMission;
        Intrinsics.checkNotNullExpressionValue(twoLifeStyleMissionItem, "binding.twoLifeStyleMission");
        twoLifeStyleMissionItem.setVisibility(0);
        OneLifeStyleMissionItem oneLifeStyleMissionItem = this.binding.oneLifeStyleMission;
        Intrinsics.checkNotNullExpressionValue(oneLifeStyleMissionItem, "binding.oneLifeStyleMission");
        oneLifeStyleMissionItem.setVisibility(8);
        this.binding.twoLifeStyleMission.setContent(lifeStyleMissionControlData, lifeStyleMissionControlData2);
    }

    /* access modifiers changed from: private */
    public final LifeStyleMissionViewModel getViewModel() {
        return (LifeStyleMissionViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachedToWindow$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10222onAttachedToWindow$lambda1$lambda0(LifeStyleMissionView lifeStyleMissionView, LifeStyleMissionControl lifeStyleMissionControl) {
        Intrinsics.checkNotNullParameter(lifeStyleMissionView, "this$0");
        Intrinsics.checkNotNullExpressionValue(lifeStyleMissionControl, "lifeStyleMission");
        lifeStyleMissionView.setContent(lifeStyleMissionControl);
    }

    private final void setClickListeners(Function2<? super String, ? super String, Unit> function2) {
        this.binding.oneLifeStyleMission.setMissionClickListener(new LifeStyleMissionView$setClickListeners$1(function2, this));
        this.binding.twoLifeStyleMission.setMissionClickListener(new LifeStyleMissionView$setClickListeners$2(function2, this));
    }

    private final void setContent(LifeStyleMissionControl lifeStyleMissionControl) {
        int size = lifeStyleMissionControl.getMissions().size();
        if (size == 1) {
            bindOneLifeStyleMission(lifeStyleMissionControl.getMissions().get(0));
        } else if (size == 2) {
            bindTwoLifeStyleMission(lifeStyleMissionControl.getMissions().get(0), lifeStyleMissionControl.getMissions().get(1));
        }
    }

    @NotNull
    public final LifeStyleMissionViewModelFactory getFactory() {
        LifeStyleMissionViewModelFactory lifeStyleMissionViewModelFactory = this.factory;
        if (lifeStyleMissionViewModelFactory != null) {
            return lifeStyleMissionViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    public final void load(@NotNull String str, @NotNull String str2, boolean z11, @Nullable Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        setClickListeners(function2);
        getViewModel().getLifeStyleMissionControls(str, str2, z11);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifecycleOwner findViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(this);
        if (findViewTreeLifecycleOwner != null) {
            getViewModel().getLifeStyleMission().observe(findViewTreeLifecycleOwner, new b(this));
        }
    }

    public final void setFactory(@NotNull LifeStyleMissionViewModelFactory lifeStyleMissionViewModelFactory) {
        Intrinsics.checkNotNullParameter(lifeStyleMissionViewModelFactory, "<set-?>");
        this.factory = lifeStyleMissionViewModelFactory;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LifeStyleMissionView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        LifeStyleMissionView$viewModel$2 lifeStyleMissionView$viewModel$2 = new LifeStyleMissionView$viewModel$2(this);
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(LifeStyleMissionViewModel.class), new LifeStyleMissionView$special$$inlined$viewModels$1(this), lifeStyleMissionView$viewModel$2);
        LifeStyleMissionViewBinding inflate = LifeStyleMissionViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
        int dimension = (int) getResources().getDimension(R.dimen.ds_s);
        setPadding(dimension, dimension, dimension, 0);
        setVisibility(8);
        DaggerMissionControlViewComponent.factory().create((ExperimentCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ExperimentCoreLibApi.class), (MissionControlFeatureApi) AndroidComponentsKt.apiContainer((View) this).getFeature(MissionControlFeatureApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(TrackingCoreLibApi.class)).inject(this);
    }
}
