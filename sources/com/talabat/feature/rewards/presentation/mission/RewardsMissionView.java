package com.talabat.feature.rewards.presentation.mission;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewKt;
import androidx.lifecycle.ViewModelLazy;
import bo.c;
import bo.d;
import bo.e;
import bo.f;
import bo.g;
import bo.h;
import bo.i;
import bo.j;
import bo.k;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
import com.talabat.feature.rewards.domain.model.Mission;
import com.talabat.feature.rewards.domain.model.MissionDetails;
import com.talabat.feature.rewards.domain.model.MissionOrigin;
import com.talabat.feature.rewards.domain.model.MissionProgress;
import com.talabat.feature.rewards.domain.model.MissionWidget;
import com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding;
import com.talabat.feature.rewards.presentation.R;
import com.talabat.feature.rewards.presentation.databinding.MissionWidgetBinding;
import com.talabat.feature.rewards.presentation.mission.details.MissionDetailsDialogFragment;
import com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel;
import com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModelFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002EFB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010%\u001a\u00020&H\u0002J\u0006\u0010'\u001a\u00020&J\b\u0010(\u001a\u00020&H\u0014J\u000e\u0010)\u001a\u00020&2\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010*\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010+\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010,\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010-\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010.\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010/\u001a\u00020&H\u0002J\b\u00100\u001a\u00020&H\u0002J\u0012\u00101\u001a\u00020&2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u00102\u001a\u00020&2\u0006\u00103\u001a\u00020\tH\u0002J\u0010\u00104\u001a\u00020&2\u0006\u00103\u001a\u00020\tH\u0002J\b\u00105\u001a\u00020&H\u0002J\b\u00106\u001a\u00020&H\u0002J\u0010\u00107\u001a\u00020&2\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010>\u001a\u00020&H\u0002J\u0010\u0010?\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010@\u001a\u00020&H\u0002J\u0010\u0010A\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020DH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"¨\u0006G"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/RewardsMissionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "shouldLoadMission", "", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "binding", "Lcom/talabat/feature/rewards/presentation/databinding/MissionWidgetBinding;", "bottomSheet", "Lcom/talabat/feature/rewards/presentation/DSBottomSheetFragmentWithoutPadding;", "chainId", "Ljava/lang/Integer;", "claimedListener", "Lcom/talabat/feature/rewards/presentation/mission/RewardsMissionView$ClaimedListener;", "factory", "Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModelFactory;", "getFactory", "()Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModelFactory;", "setFactory", "(Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModelFactory;)V", "listener", "Lcom/talabat/feature/rewards/presentation/mission/RewardsMissionView$Listener;", "mission", "Lcom/talabat/feature/rewards/domain/model/Mission;", "origin", "Lcom/talabat/feature/rewards/domain/model/MissionOrigin;", "viewModel", "Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel;", "getViewModel", "()Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel;", "viewModel$delegate", "Landroidx/lifecycle/ViewModelLazy;", "initDagger", "", "loadMission", "onAttachedToWindow", "setChainId", "setClaimedListener", "setListener", "setMission", "setOrigin", "setupActiveMission", "setupChainId", "setupDetailsBottomSheet", "setupHasMission", "setupLoadingIndicatorAcceptMission", "isLoading", "setupLoadingIndicatorClaimReward", "setupMission", "setupMissionClick", "setupMissionState", "missionState", "Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel$MissionState;", "setupObservers", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "setupOptInMission", "setupOrigin", "setupOriginAttribute", "setupRewardClaimedEvent", "setupSuccessMission", "showMissionDetails", "missionDetails", "Lcom/talabat/feature/rewards/domain/model/MissionDetails;", "ClaimedListener", "Listener", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RewardsMissionView extends LinearLayout {
    public static final int $stable = 8;
    @NotNull
    private final MissionWidgetBinding binding;
    @Nullable
    private DSBottomSheetFragmentWithoutPadding bottomSheet;
    @Nullable
    private Integer chainId;
    @Nullable
    private ClaimedListener claimedListener;
    @Inject
    public MissionViewModelFactory factory;
    @Nullable
    private Listener listener;
    @Nullable
    private Mission mission;
    @Nullable
    private MissionOrigin origin;
    private final boolean shouldLoadMission;
    @NotNull
    private final ViewModelLazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/RewardsMissionView$ClaimedListener;", "", "onRewardClaimed", "", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ClaimedListener {
        void onRewardClaimed();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/RewardsMissionView$Listener;", "", "onHasMission", "", "mission", "Lcom/talabat/feature/rewards/domain/model/Mission;", "onHasNoMission", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Listener {
        void onHasMission(@NotNull Mission mission);

        void onHasNoMission();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RewardsMissionView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, false, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RewardsMissionView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, false, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RewardsMissionView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, false, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RewardsMissionView(Context context, AttributeSet attributeSet, int i11, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? true : z11);
    }

    private final MissionViewModel getViewModel() {
        return (MissionViewModel) this.viewModel$delegate.getValue();
    }

    private final void initDagger() {
        DaggerMissionViewComponent.factory().create((RewardsFeatureApi) AndroidComponentsKt.apiContainer((View) this).getFeature(RewardsFeatureApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
    }

    private final void setupActiveMission(Mission mission2) {
        OptInMissionWidgetView optInMissionWidgetView = this.binding.layoutMissionOptIn;
        Intrinsics.checkNotNullExpressionValue(optInMissionWidgetView, "binding.layoutMissionOptIn");
        optInMissionWidgetView.setVisibility(8);
        SuccessMissionWidgetView successMissionWidgetView = this.binding.layoutMissionSuccess;
        Intrinsics.checkNotNullExpressionValue(successMissionWidgetView, "binding.layoutMissionSuccess");
        successMissionWidgetView.setVisibility(8);
        ActiveMissionWidgetView activeMissionWidgetView = this.binding.layoutMissionActive;
        Intrinsics.checkNotNullExpressionValue(activeMissionWidgetView, "");
        activeMissionWidgetView.setVisibility(0);
        MissionWidget widget = mission2.getWidget();
        if (widget != null) {
            activeMissionWidgetView.setup(widget);
        }
        MissionProgress progress = mission2.getProgress();
        if (progress != null) {
            activeMissionWidgetView.setupStepProgressIndicator(progress);
        }
    }

    private final void setupChainId() {
        Integer num = this.chainId;
        if (num != null) {
            getViewModel().setupChainId(num.intValue());
        }
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [androidx.fragment.app.Fragment] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setupDetailsBottomSheet() {
        /*
            r3 = this;
            android.content.Context r0 = r3.getContext()
            boolean r1 = r0 instanceof androidx.appcompat.app.AppCompatActivity
            r2 = 0
            if (r1 == 0) goto L_0x000c
            androidx.appcompat.app.AppCompatActivity r0 = (androidx.appcompat.app.AppCompatActivity) r0
            goto L_0x000d
        L_0x000c:
            r0 = r2
        L_0x000d:
            if (r0 == 0) goto L_0x0030
            androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
            if (r0 != 0) goto L_0x0016
            goto L_0x0030
        L_0x0016:
            com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding$Companion r1 = com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding.Companion
            java.lang.String r1 = r1.getTAG()
            androidx.fragment.app.Fragment r0 = r0.findFragmentByTag(r1)
            boolean r1 = r0 instanceof com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding
            if (r1 == 0) goto L_0x0027
            r2 = r0
            com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding r2 = (com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding) r2
        L_0x0027:
            if (r2 != 0) goto L_0x002e
            com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding r2 = new com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding
            r2.<init>()
        L_0x002e:
            r3.bottomSheet = r2
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rewards.presentation.mission.RewardsMissionView.setupDetailsBottomSheet():void");
    }

    /* access modifiers changed from: private */
    public final void setupHasMission(Mission mission2) {
        if (mission2 == null) {
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onHasNoMission();
                return;
            }
            return;
        }
        Listener listener3 = this.listener;
        if (listener3 != null) {
            listener3.onHasMission(mission2);
        }
    }

    /* access modifiers changed from: private */
    public final void setupLoadingIndicatorAcceptMission(boolean z11) {
        this.binding.layoutMissionOptIn.setupLoadingIndicatorAcceptMission(z11);
    }

    /* access modifiers changed from: private */
    public final void setupLoadingIndicatorClaimReward(boolean z11) {
        this.binding.layoutMissionSuccess.setupLoadingIndicatorClaimReward(z11);
    }

    private final void setupMission() {
        if (this.shouldLoadMission) {
            loadMission();
            return;
        }
        Mission mission2 = this.mission;
        if (mission2 != null) {
            getViewModel().setupMission(mission2);
        }
    }

    private final void setupMissionClick() {
        this.binding.layoutMissionOptIn.setOnClickListener(new i(this));
        this.binding.layoutMissionActive.setOnClickListener(new j(this));
        this.binding.layoutMissionSuccess.setOnClickListener(new k(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupMissionClick$lambda-12  reason: not valid java name */
    public static final void m10283setupMissionClick$lambda12(RewardsMissionView rewardsMissionView, View view) {
        Intrinsics.checkNotNullParameter(rewardsMissionView, "this$0");
        rewardsMissionView.getViewModel().acceptMission();
    }

    /* access modifiers changed from: private */
    /* renamed from: setupMissionClick$lambda-13  reason: not valid java name */
    public static final void m10284setupMissionClick$lambda13(RewardsMissionView rewardsMissionView, View view) {
        Intrinsics.checkNotNullParameter(rewardsMissionView, "this$0");
        rewardsMissionView.getViewModel().showActiveMission();
    }

    /* access modifiers changed from: private */
    /* renamed from: setupMissionClick$lambda-14  reason: not valid java name */
    public static final void m10285setupMissionClick$lambda14(RewardsMissionView rewardsMissionView, View view) {
        Intrinsics.checkNotNullParameter(rewardsMissionView, "this$0");
        rewardsMissionView.getViewModel().claimReward();
    }

    /* access modifiers changed from: private */
    public final void setupMissionState(MissionViewModel.MissionState missionState) {
        Mission mission2 = missionState.getMission();
        if (missionState instanceof MissionViewModel.MissionState.OptIn) {
            setupOptInMission(mission2);
        } else if (missionState instanceof MissionViewModel.MissionState.Active) {
            setupActiveMission(mission2);
        } else if (missionState instanceof MissionViewModel.MissionState.Success) {
            setupSuccessMission(mission2);
        }
    }

    private final void setupObservers(LifecycleOwner lifecycleOwner) {
        getViewModel().getMissionState().observe(lifecycleOwner, new c(this));
        getViewModel().getHasMission().observe(lifecycleOwner, new d(this));
        getViewModel().getLoadingIndicatorAcceptMission().observe(lifecycleOwner, new e(this));
        getViewModel().getLoadingIndicatorClaimReward().observe(lifecycleOwner, new f(this));
        getViewModel().getShowMissionDetailsEvent().observe(lifecycleOwner, new g(this));
        getViewModel().getRewardClaimedEvent().observe(lifecycleOwner, new h(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupObservers$lambda-6  reason: not valid java name */
    public static final void m10286setupObservers$lambda6(RewardsMissionView rewardsMissionView, Unit unit) {
        Intrinsics.checkNotNullParameter(rewardsMissionView, "this$0");
        rewardsMissionView.setupRewardClaimedEvent();
    }

    private final void setupOptInMission(Mission mission2) {
        ActiveMissionWidgetView activeMissionWidgetView = this.binding.layoutMissionActive;
        Intrinsics.checkNotNullExpressionValue(activeMissionWidgetView, "binding.layoutMissionActive");
        activeMissionWidgetView.setVisibility(8);
        SuccessMissionWidgetView successMissionWidgetView = this.binding.layoutMissionSuccess;
        Intrinsics.checkNotNullExpressionValue(successMissionWidgetView, "binding.layoutMissionSuccess");
        successMissionWidgetView.setVisibility(8);
        OptInMissionWidgetView optInMissionWidgetView = this.binding.layoutMissionOptIn;
        Intrinsics.checkNotNullExpressionValue(optInMissionWidgetView, "");
        optInMissionWidgetView.setVisibility(0);
        MissionWidget widget = mission2.getWidget();
        if (widget != null) {
            optInMissionWidgetView.setup(widget);
        }
    }

    private final void setupOrigin() {
        MissionOrigin missionOrigin = this.origin;
        if (missionOrigin != null) {
            getViewModel().setupOrigin(missionOrigin);
        }
    }

    private final void setupOriginAttribute(AttributeSet attributeSet) {
        MissionOrigin missionOrigin;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MissionWidgetView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr….MissionWidgetView, 0, 0)");
        int i11 = obtainStyledAttributes.getInt(R.styleable.MissionWidgetView_original, -1);
        if (i11 >= 0) {
            missionOrigin = MissionOrigin.values()[i11];
        } else {
            missionOrigin = null;
        }
        this.origin = missionOrigin;
    }

    private final void setupRewardClaimedEvent() {
        ClaimedListener claimedListener2 = this.claimedListener;
        if (claimedListener2 != null) {
            claimedListener2.onRewardClaimed();
        }
        SuccessMissionWidgetView successMissionWidgetView = this.binding.layoutMissionSuccess;
        Intrinsics.checkNotNullExpressionValue(successMissionWidgetView, "binding.layoutMissionSuccess");
        successMissionWidgetView.setVisibility(8);
    }

    private final void setupSuccessMission(Mission mission2) {
        OptInMissionWidgetView optInMissionWidgetView = this.binding.layoutMissionOptIn;
        Intrinsics.checkNotNullExpressionValue(optInMissionWidgetView, "binding.layoutMissionOptIn");
        optInMissionWidgetView.setVisibility(8);
        ActiveMissionWidgetView activeMissionWidgetView = this.binding.layoutMissionActive;
        Intrinsics.checkNotNullExpressionValue(activeMissionWidgetView, "binding.layoutMissionActive");
        activeMissionWidgetView.setVisibility(8);
        SuccessMissionWidgetView successMissionWidgetView = this.binding.layoutMissionSuccess;
        Intrinsics.checkNotNullExpressionValue(successMissionWidgetView, "");
        successMissionWidgetView.setVisibility(0);
        MissionWidget widget = mission2.getWidget();
        if (widget != null) {
            successMissionWidgetView.setup(widget);
        }
    }

    /* access modifiers changed from: private */
    public final void showMissionDetails(MissionDetails missionDetails) {
        AppCompatActivity appCompatActivity;
        FragmentManager supportFragmentManager;
        DSBottomSheetFragmentWithoutPadding dSBottomSheetFragmentWithoutPadding;
        Context context = getContext();
        if (context instanceof AppCompatActivity) {
            appCompatActivity = (AppCompatActivity) context;
        } else {
            appCompatActivity = null;
        }
        if (appCompatActivity != null && (supportFragmentManager = appCompatActivity.getSupportFragmentManager()) != null && (dSBottomSheetFragmentWithoutPadding = this.bottomSheet) != null && !dSBottomSheetFragmentWithoutPadding.isAdded()) {
            dSBottomSheetFragmentWithoutPadding.setBody(MissionDetailsDialogFragment.Companion.newInstance(missionDetails, this.origin));
            dSBottomSheetFragmentWithoutPadding.setWithNavigationBar(false);
            dSBottomSheetFragmentWithoutPadding.show(supportFragmentManager);
        }
    }

    @NotNull
    public final MissionViewModelFactory getFactory() {
        MissionViewModelFactory missionViewModelFactory = this.factory;
        if (missionViewModelFactory != null) {
            return missionViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    public final void loadMission() {
        getViewModel().loadMission();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifecycleOwner findViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(this);
        if (findViewTreeLifecycleOwner != null) {
            setupObservers(findViewTreeLifecycleOwner);
            setupOrigin();
            setupChainId();
            setupMission();
            setupMissionClick();
            setupDetailsBottomSheet();
        }
    }

    public final void setChainId(int i11) {
        this.chainId = Integer.valueOf(i11);
    }

    public final void setClaimedListener(@NotNull ClaimedListener claimedListener2) {
        Intrinsics.checkNotNullParameter(claimedListener2, "claimedListener");
        this.claimedListener = claimedListener2;
    }

    public final void setFactory(@NotNull MissionViewModelFactory missionViewModelFactory) {
        Intrinsics.checkNotNullParameter(missionViewModelFactory, "<set-?>");
        this.factory = missionViewModelFactory;
    }

    public final void setListener(@NotNull Listener listener2) {
        Intrinsics.checkNotNullParameter(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = listener2;
    }

    public final void setMission(@NotNull Mission mission2) {
        Intrinsics.checkNotNullParameter(mission2, "mission");
        this.mission = mission2;
    }

    public final void setOrigin(@NotNull MissionOrigin missionOrigin) {
        Intrinsics.checkNotNullParameter(missionOrigin, "origin");
        this.origin = missionOrigin;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RewardsMissionView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11, boolean z11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.shouldLoadMission = z11;
        MissionWidgetBinding inflate = MissionWidgetBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
        RewardsMissionView$viewModel$2 rewardsMissionView$viewModel$2 = new RewardsMissionView$viewModel$2(this);
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(MissionViewModel.class), new RewardsMissionView$special$$inlined$viewModels$1(this), rewardsMissionView$viewModel$2);
        if (attributeSet != null) {
            setupOriginAttribute(attributeSet);
        }
        initDagger();
    }
}
