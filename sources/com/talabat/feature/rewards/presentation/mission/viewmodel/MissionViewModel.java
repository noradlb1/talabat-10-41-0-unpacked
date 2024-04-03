package com.talabat.feature.rewards.presentation.mission.viewmodel;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.feature.rewards.domain.MissionTracker;
import com.talabat.feature.rewards.domain.model.Mission;
import com.talabat.feature.rewards.domain.model.MissionClickType;
import com.talabat.feature.rewards.domain.model.MissionDetails;
import com.talabat.feature.rewards.domain.model.MissionOrigin;
import com.talabat.feature.rewards.domain.usecases.AcceptMissionRewardUseCase;
import com.talabat.feature.rewards.domain.usecases.ClaimMissionRewardUseCase;
import com.talabat.feature.rewards.domain.usecases.GetMissionUseCase;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.SingleLiveEvent;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 62\u00020\u0001:\u000267B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010(\u001a\u00020\"J\u0006\u0010)\u001a\u00020\"J\u0011\u0010*\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020\u0016H\u0002J\u0006\u0010-\u001a\u00020\"J\b\u0010.\u001a\u00020\"H\u0002J\u0010\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u0012H\u0002J\u000e\u00101\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u00102\u001a\u00020\"2\u0006\u00100\u001a\u00020\u0012J\u000e\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\u001fJ\u0006\u00105\u001a\u00020\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u00160\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u00160\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0!¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel;", "Landroidx/lifecycle/ViewModel;", "getMissionUseCase", "Lcom/talabat/feature/rewards/domain/usecases/GetMissionUseCase;", "acceptMissionRewardUseCase", "Lcom/talabat/feature/rewards/domain/usecases/AcceptMissionRewardUseCase;", "claimMissionRewardUseCase", "Lcom/talabat/feature/rewards/domain/usecases/ClaimMissionRewardUseCase;", "funWithFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "missionTracker", "Lcom/talabat/feature/rewards/domain/MissionTracker;", "(Lcom/talabat/feature/rewards/domain/usecases/GetMissionUseCase;Lcom/talabat/feature/rewards/domain/usecases/AcceptMissionRewardUseCase;Lcom/talabat/feature/rewards/domain/usecases/ClaimMissionRewardUseCase;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/feature/rewards/domain/MissionTracker;)V", "chainId", "", "Ljava/lang/Integer;", "hasMission", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/feature/rewards/domain/model/Mission;", "getHasMission", "()Landroidx/lifecycle/MutableLiveData;", "loadingIndicatorAcceptMission", "", "kotlin.jvm.PlatformType", "getLoadingIndicatorAcceptMission", "loadingIndicatorClaimReward", "getLoadingIndicatorClaimReward", "missionState", "Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel$MissionState;", "getMissionState", "origin", "Lcom/talabat/feature/rewards/domain/model/MissionOrigin;", "rewardClaimedEvent", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;", "", "getRewardClaimedEvent", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;", "showMissionDetailsEvent", "Lcom/talabat/feature/rewards/domain/model/MissionDetails;", "getShowMissionDetailsEvent", "acceptMission", "claimReward", "getMission", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFwfMissionEnabled", "loadMission", "setHasNoMission", "setMission", "mission", "setupChainId", "setupMission", "setupOrigin", "original", "showActiveMission", "Companion", "MissionState", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionViewModel extends ViewModel {
    public static final int $stable = 8;
    @NotNull
    @Deprecated
    public static final String COMPLETED = "Completed";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String IN_PROGRESS = "InProgress";
    @NotNull
    @Deprecated
    public static final String PENDING_OPT_IN = "PendingOptIn";
    /* access modifiers changed from: private */
    @NotNull
    public final AcceptMissionRewardUseCase acceptMissionRewardUseCase;
    @Nullable
    private Integer chainId;
    /* access modifiers changed from: private */
    @NotNull
    public final ClaimMissionRewardUseCase claimMissionRewardUseCase;
    @NotNull
    private final ITalabatFeatureFlag funWithFlags;
    @NotNull
    private final GetMissionUseCase getMissionUseCase;
    @NotNull
    private final MutableLiveData<Mission> hasMission = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Boolean> loadingIndicatorAcceptMission;
    @NotNull
    private final MutableLiveData<Boolean> loadingIndicatorClaimReward;
    @NotNull
    private final MutableLiveData<MissionState> missionState = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MissionTracker missionTracker;
    /* access modifiers changed from: private */
    @Nullable
    public MissionOrigin origin;
    @NotNull
    private final SingleLiveEvent<Unit> rewardClaimedEvent;
    @NotNull
    private final SingleLiveEvent<MissionDetails> showMissionDetailsEvent;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel$Companion;", "", "()V", "COMPLETED", "", "IN_PROGRESS", "PENDING_OPT_IN", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel$MissionState;", "", "mission", "Lcom/talabat/feature/rewards/domain/model/Mission;", "(Lcom/talabat/feature/rewards/domain/model/Mission;)V", "getMission", "()Lcom/talabat/feature/rewards/domain/model/Mission;", "Active", "OptIn", "Success", "Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel$MissionState$OptIn;", "Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel$MissionState$Active;", "Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel$MissionState$Success;", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class MissionState {
        public static final int $stable = 8;
        @NotNull
        private final Mission mission;

        @StabilityInferred(parameters = 0)
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel$MissionState$Active;", "Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel$MissionState;", "mission", "Lcom/talabat/feature/rewards/domain/model/Mission;", "(Lcom/talabat/feature/rewards/domain/model/Mission;)V", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Active extends MissionState {
            public static final int $stable = 0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Active(@NotNull Mission mission) {
                super(mission, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(mission, "mission");
            }
        }

        @StabilityInferred(parameters = 0)
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel$MissionState$OptIn;", "Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel$MissionState;", "mission", "Lcom/talabat/feature/rewards/domain/model/Mission;", "(Lcom/talabat/feature/rewards/domain/model/Mission;)V", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class OptIn extends MissionState {
            public static final int $stable = 0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OptIn(@NotNull Mission mission) {
                super(mission, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(mission, "mission");
            }
        }

        @StabilityInferred(parameters = 0)
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel$MissionState$Success;", "Lcom/talabat/feature/rewards/presentation/mission/viewmodel/MissionViewModel$MissionState;", "mission", "Lcom/talabat/feature/rewards/domain/model/Mission;", "(Lcom/talabat/feature/rewards/domain/model/Mission;)V", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Success extends MissionState {
            public static final int $stable = 0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(@NotNull Mission mission) {
                super(mission, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(mission, "mission");
            }
        }

        private MissionState(Mission mission2) {
            this.mission = mission2;
        }

        public /* synthetic */ MissionState(Mission mission2, DefaultConstructorMarker defaultConstructorMarker) {
            this(mission2);
        }

        @NotNull
        public final Mission getMission() {
            return this.mission;
        }
    }

    @Inject
    public MissionViewModel(@NotNull GetMissionUseCase getMissionUseCase2, @NotNull AcceptMissionRewardUseCase acceptMissionRewardUseCase2, @NotNull ClaimMissionRewardUseCase claimMissionRewardUseCase2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull MissionTracker missionTracker2) {
        Intrinsics.checkNotNullParameter(getMissionUseCase2, "getMissionUseCase");
        Intrinsics.checkNotNullParameter(acceptMissionRewardUseCase2, "acceptMissionRewardUseCase");
        Intrinsics.checkNotNullParameter(claimMissionRewardUseCase2, "claimMissionRewardUseCase");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "funWithFlags");
        Intrinsics.checkNotNullParameter(missionTracker2, "missionTracker");
        this.getMissionUseCase = getMissionUseCase2;
        this.acceptMissionRewardUseCase = acceptMissionRewardUseCase2;
        this.claimMissionRewardUseCase = claimMissionRewardUseCase2;
        this.funWithFlags = iTalabatFeatureFlag;
        this.missionTracker = missionTracker2;
        Boolean bool = Boolean.FALSE;
        this.loadingIndicatorAcceptMission = new MutableLiveData<>(bool);
        this.loadingIndicatorClaimReward = new MutableLiveData<>(bool);
        this.showMissionDetailsEvent = new SingleLiveEvent<>();
        this.rewardClaimedEvent = new SingleLiveEvent<>();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getMission(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel$getMission$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel$getMission$1 r0 = (com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel$getMission$1) r0
            int r1 = r0.f58786k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58786k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel$getMission$1 r0 = new com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel$getMission$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f58784i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58786k
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r0 = r0.f58783h
            com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel r0 = (com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel) r0
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r7 = r7.m6338unboximpl()
            goto L_0x0059
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.feature.rewards.domain.usecases.GetMissionUseCase r7 = r6.getMissionUseCase
            java.lang.Integer r2 = r6.chainId
            com.talabat.feature.rewards.domain.model.MissionOrigin r5 = r6.origin
            if (r5 == 0) goto L_0x004c
            java.lang.String r5 = r5.getScreen()
            goto L_0x004d
        L_0x004c:
            r5 = r4
        L_0x004d:
            r0.f58783h = r6
            r0.f58786k = r3
            java.lang.Object r7 = r7.m10282getMission0E7RQCE(r2, r5, r0)
            if (r7 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r0 = r6
        L_0x0059:
            boolean r1 = kotlin.Result.m6336isSuccessimpl(r7)
            if (r1 == 0) goto L_0x0075
            boolean r1 = kotlin.Result.m6335isFailureimpl(r7)
            if (r1 == 0) goto L_0x0066
            r7 = r4
        L_0x0066:
            com.talabat.feature.rewards.domain.model.Mission r7 = (com.talabat.feature.rewards.domain.model.Mission) r7
            if (r7 == 0) goto L_0x006f
            r0.setMission(r7)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x006f:
            if (r4 != 0) goto L_0x0078
            r0.setHasNoMission()
            goto L_0x0078
        L_0x0075:
            r0.setHasNoMission()
        L_0x0078:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel.getMission(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final boolean isFwfMissionEnabled() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.funWithFlags, EcosystemsFeatureFlagsKeys.IS_MISSIONS_WIDGET_ENABLED, false, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void setHasNoMission() {
        this.hasMission.postValue(null);
    }

    private final void setMission(Mission mission) {
        Object obj;
        MissionOrigin missionOrigin = this.origin;
        if (missionOrigin == MissionOrigin.HOME_OF_FOOD) {
            this.missionTracker.onMissionsShopListLoaded(missionOrigin, CollectionsKt__CollectionsJVMKt.listOf(mission));
        }
        this.hasMission.postValue(mission);
        String phase = mission.getPhase();
        if (Intrinsics.areEqual((Object) phase, (Object) PENDING_OPT_IN)) {
            obj = new MissionState.OptIn(mission);
        } else if (Intrinsics.areEqual((Object) phase, (Object) "Completed")) {
            obj = new MissionState.Success(mission);
        } else {
            obj = new MissionState.Active(mission);
        }
        this.missionState.postValue(obj);
    }

    public final void acceptMission() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new MissionViewModel$acceptMission$1(this, (Continuation<? super MissionViewModel$acceptMission$1>) null), 3, (Object) null);
    }

    public final void claimReward() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new MissionViewModel$claimReward$1(this, (Continuation<? super MissionViewModel$claimReward$1>) null), 3, (Object) null);
    }

    @NotNull
    public final MutableLiveData<Mission> getHasMission() {
        return this.hasMission;
    }

    @NotNull
    public final MutableLiveData<Boolean> getLoadingIndicatorAcceptMission() {
        return this.loadingIndicatorAcceptMission;
    }

    @NotNull
    public final MutableLiveData<Boolean> getLoadingIndicatorClaimReward() {
        return this.loadingIndicatorClaimReward;
    }

    @NotNull
    public final MutableLiveData<MissionState> getMissionState() {
        return this.missionState;
    }

    @NotNull
    public final SingleLiveEvent<Unit> getRewardClaimedEvent() {
        return this.rewardClaimedEvent;
    }

    @NotNull
    public final SingleLiveEvent<MissionDetails> getShowMissionDetailsEvent() {
        return this.showMissionDetailsEvent;
    }

    public final void loadMission() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new MissionViewModel$loadMission$1(this, (Continuation<? super MissionViewModel$loadMission$1>) null), 3, (Object) null);
    }

    public final void setupChainId(int i11) {
        this.chainId = Integer.valueOf(i11);
    }

    public final void setupMission(@NotNull Mission mission) {
        Intrinsics.checkNotNullParameter(mission, "mission");
        if (isFwfMissionEnabled()) {
            setMission(mission);
        } else {
            setHasNoMission();
        }
    }

    public final void setupOrigin(@NotNull MissionOrigin missionOrigin) {
        Intrinsics.checkNotNullParameter(missionOrigin, "original");
        this.origin = missionOrigin;
    }

    public final void showActiveMission() {
        Mission mission;
        MissionState value = this.missionState.getValue();
        if (value != null && (mission = value.getMission()) != null) {
            this.missionTracker.onMissionClicked(this.origin, mission, MissionClickType.CLICK);
            MissionDetails details = mission.getDetails();
            if (details != null) {
                this.missionTracker.onMissionDetailLoaded(this.origin, mission);
                this.showMissionDetailsEvent.postValue(details);
            }
        }
    }
}
