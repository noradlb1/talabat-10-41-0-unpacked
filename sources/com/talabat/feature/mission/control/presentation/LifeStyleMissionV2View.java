package com.talabat.feature.mission.control.presentation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.marshmallow.R;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMission;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMissionItem;
import com.talabat.feature.mission.control.domain.MissionControlFeatureApi;
import com.talabat.feature.mission.control.presentation.adapter.LifestyleMissionAdapter;
import com.talabat.feature.mission.control.presentation.adapter.LifestyleMissionItemDecoration;
import com.talabat.feature.mission.control.presentation.databinding.LifeStyleMissionViewV2Binding;
import com.talabat.feature.mission.control.presentation.di.DaggerMissionControlViewComponent;
import com.talabat.feature.mission.control.presentation.viewmodel.LifeStyleMissionViewModel;
import com.talabat.feature.mission.control.presentation.viewmodel.LifeStyleMissionViewModelFactory;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJk\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2S\u0010\u001c\u001aO\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001dj\u0004\u0018\u0001`#H\u0002J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u001bH\u0002JH\u0010&\u001a\u00020\u00182>\u0010'\u001a:\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0018\u0018\u00010(j\u0004\u0018\u0001`)H\u0002JN\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,2>\u0010'\u001a:\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0018\u0018\u00010(j\u0004\u0018\u0001`)R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006-"}, d2 = {"Lcom/talabat/feature/mission/control/presentation/LifeStyleMissionV2View;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/feature/mission/control/presentation/databinding/LifeStyleMissionViewV2Binding;", "factory", "Lcom/talabat/feature/mission/control/presentation/viewmodel/LifeStyleMissionViewModelFactory;", "getFactory", "()Lcom/talabat/feature/mission/control/presentation/viewmodel/LifeStyleMissionViewModelFactory;", "setFactory", "(Lcom/talabat/feature/mission/control/presentation/viewmodel/LifeStyleMissionViewModelFactory;)V", "viewModel", "Lcom/talabat/feature/mission/control/presentation/viewmodel/LifeStyleMissionViewModel;", "getViewModel", "()Lcom/talabat/feature/mission/control/presentation/viewmodel/LifeStyleMissionViewModel;", "viewModel$delegate", "Landroidx/lifecycle/ViewModelLazy;", "bindLifeStyleMissionItems", "", "lifestyleMissionItems", "", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMissionItem;", "missionClickListener", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "code", "position", "Lcom/talabat/feature/mission/control/presentation/listener/MissionClickListener;", "bindOneLifeStyleMission", "lifestyleMissionData", "setClickListeners", "lifeStyleMissionClickListener", "Lkotlin/Function2;", "Lcom/talabat/feature/mission/control/presentation/listener/LifeStyleMissionClickListener;", "setContent", "lifeStyleMission", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;", "com_talabat_feature_mission-control_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifeStyleMissionV2View extends LinearLayout {
    @NotNull
    private final LifeStyleMissionViewV2Binding binding;
    @Inject
    public LifeStyleMissionViewModelFactory factory;
    @NotNull
    private final ViewModelLazy viewModel$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LifeStyleMissionV2View(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LifeStyleMissionV2View(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LifeStyleMissionV2View(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void bindLifeStyleMissionItems(List<LifestyleMissionItem> list, Function3<? super String, ? super String, ? super Integer, Unit> function3) {
        boolean z11 = true;
        if (!list.isEmpty()) {
            setVisibility(0);
            RecyclerView recyclerView = this.binding.lifestyleRecyclerview;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.lifestyleRecyclerview");
            recyclerView.setVisibility(0);
            this.binding.lifestyleRecyclerview.setLayoutManager(new LinearLayoutManager(this.binding.getRoot().getContext(), 0, false));
            RecyclerView recyclerView2 = this.binding.lifestyleRecyclerview;
            if (recyclerView2.getItemDecorationCount() < 1) {
                Context context = this.binding.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
                if (getLayoutDirection() != 1) {
                    z11 = false;
                }
                recyclerView2.addItemDecoration(new LifestyleMissionItemDecoration(context, z11));
            }
            this.binding.lifestyleRecyclerview.setAdapter(new LifestyleMissionAdapter(list, function3));
        } else {
            setVisibility(8);
            RecyclerView recyclerView3 = this.binding.lifestyleRecyclerview;
            Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.lifestyleRecyclerview");
            recyclerView3.setVisibility(8);
        }
        OneLifeStyleMissionItem oneLifeStyleMissionItem = this.binding.oneLifeStyleMission;
        Intrinsics.checkNotNullExpressionValue(oneLifeStyleMissionItem, "binding.oneLifeStyleMission");
        oneLifeStyleMissionItem.setVisibility(8);
    }

    private final void bindOneLifeStyleMission(LifestyleMissionItem lifestyleMissionItem) {
        setVisibility(0);
        OneLifeStyleMissionItem oneLifeStyleMissionItem = this.binding.oneLifeStyleMission;
        Intrinsics.checkNotNullExpressionValue(oneLifeStyleMissionItem, "binding.oneLifeStyleMission");
        oneLifeStyleMissionItem.setVisibility(0);
        RecyclerView recyclerView = this.binding.lifestyleRecyclerview;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.lifestyleRecyclerview");
        recyclerView.setVisibility(8);
        this.binding.oneLifeStyleMission.setContent(lifestyleMissionItem, 0);
    }

    /* access modifiers changed from: private */
    public final LifeStyleMissionViewModel getViewModel() {
        return (LifeStyleMissionViewModel) this.viewModel$delegate.getValue();
    }

    private final void setClickListeners(Function2<? super String, ? super String, Unit> function2) {
        this.binding.oneLifeStyleMission.setMissionClickListener(new LifeStyleMissionV2View$setClickListeners$1(function2, this));
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

    public final void setContent(@NotNull LifestyleMission lifestyleMission, @Nullable Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(lifestyleMission, "lifeStyleMission");
        if (lifestyleMission.getItems().size() == 1) {
            setClickListeners(function2);
            bindOneLifeStyleMission(lifestyleMission.getItems().get(0));
            return;
        }
        bindLifeStyleMissionItems(lifestyleMission.getItems(), new LifeStyleMissionV2View$setContent$1(function2, this));
    }

    public final void setFactory(@NotNull LifeStyleMissionViewModelFactory lifeStyleMissionViewModelFactory) {
        Intrinsics.checkNotNullParameter(lifeStyleMissionViewModelFactory, "<set-?>");
        this.factory = lifeStyleMissionViewModelFactory;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LifeStyleMissionV2View(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        LifeStyleMissionV2View$viewModel$2 lifeStyleMissionV2View$viewModel$2 = new LifeStyleMissionV2View$viewModel$2(this);
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(LifeStyleMissionViewModel.class), new LifeStyleMissionV2View$special$$inlined$viewModels$1(this), lifeStyleMissionV2View$viewModel$2);
        LifeStyleMissionViewV2Binding inflate = LifeStyleMissionViewV2Binding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
        setPadding(0, getResources().getDimensionPixelOffset(R.dimen.ds_s), 0, 0);
        setVisibility(8);
        DaggerMissionControlViewComponent.factory().create((ExperimentCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ExperimentCoreLibApi.class), (MissionControlFeatureApi) AndroidComponentsKt.apiContainer((View) this).getFeature(MissionControlFeatureApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(TrackingCoreLibApi.class)).inject(this);
    }
}
