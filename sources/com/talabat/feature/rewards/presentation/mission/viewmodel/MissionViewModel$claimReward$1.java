package com.talabat.feature.rewards.presentation.mission.viewmodel;

import com.talabat.feature.rewards.domain.model.Mission;
import com.talabat.feature.rewards.domain.model.MissionDetails;
import com.talabat.feature.rewards.domain.model.MissionOrigin;
import com.talabat.feature.rewards.domain.usecases.ClaimMissionRewardUseCase;
import com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel$claimReward$1", f = "MissionViewModel.kt", i = {0}, l = {118}, m = "invokeSuspend", n = {"mission"}, s = {"L$0"})
public final class MissionViewModel$claimReward$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f58780h;

    /* renamed from: i  reason: collision with root package name */
    public int f58781i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MissionViewModel f58782j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MissionViewModel$claimReward$1(MissionViewModel missionViewModel, Continuation<? super MissionViewModel$claimReward$1> continuation) {
        super(2, continuation);
        this.f58782j = missionViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MissionViewModel$claimReward$1(this.f58782j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MissionViewModel$claimReward$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Mission mission;
        Mission mission2;
        Integer id2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58781i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MissionViewModel.MissionState value = this.f58782j.getMissionState().getValue();
            String str = null;
            if (value != null) {
                mission2 = value.getMission();
            } else {
                mission2 = null;
            }
            if (mission2 == null || (id2 = mission2.getId()) == null) {
                return Unit.INSTANCE;
            }
            int intValue = id2.intValue();
            this.f58782j.missionTracker.onMissionCompleted(this.f58782j.origin, mission2);
            this.f58782j.getLoadingIndicatorClaimReward().postValue(Boxing.boxBoolean(true));
            ClaimMissionRewardUseCase access$getClaimMissionRewardUseCase$p = this.f58782j.claimMissionRewardUseCase;
            MissionOrigin access$getOrigin$p = this.f58782j.origin;
            if (access$getOrigin$p != null) {
                str = access$getOrigin$p.getScreen();
            }
            this.f58780h = mission2;
            this.f58781i = 1;
            Object r12 = access$getClaimMissionRewardUseCase$p.m10281claimMissionReward0E7RQCE(intValue, str, this);
            if (r12 == coroutine_suspended) {
                return coroutine_suspended;
            }
            mission = mission2;
            obj2 = r12;
        } else if (i11 == 1) {
            mission = (Mission) this.f58780h;
            ResultKt.throwOnFailure(obj);
            obj2 = ((Result) obj).m6338unboximpl();
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f58782j.getLoadingIndicatorClaimReward().postValue(Boxing.boxBoolean(false));
        if (Result.m6336isSuccessimpl(obj2)) {
            MissionDetails details = mission.getDetails();
            if (details == null) {
                return Unit.INSTANCE;
            }
            this.f58782j.missionTracker.onMissionSuccessLoaded(this.f58782j.origin, mission);
            this.f58782j.getShowMissionDetailsEvent().postValue(details);
            this.f58782j.getRewardClaimedEvent().call();
        }
        return Unit.INSTANCE;
    }
}
