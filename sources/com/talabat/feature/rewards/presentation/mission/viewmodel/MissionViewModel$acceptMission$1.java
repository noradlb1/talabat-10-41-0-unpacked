package com.talabat.feature.rewards.presentation.mission.viewmodel;

import com.talabat.feature.rewards.domain.model.Mission;
import com.talabat.feature.rewards.domain.model.MissionClickType;
import com.talabat.feature.rewards.domain.model.MissionDetails;
import com.talabat.feature.rewards.domain.model.MissionOrigin;
import com.talabat.feature.rewards.domain.usecases.AcceptMissionRewardUseCase;
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
@DebugMetadata(c = "com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel$acceptMission$1", f = "MissionViewModel.kt", i = {0}, l = {101}, m = "invokeSuspend", n = {"mission"}, s = {"L$0"})
public final class MissionViewModel$acceptMission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f58777h;

    /* renamed from: i  reason: collision with root package name */
    public int f58778i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MissionViewModel f58779j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MissionViewModel$acceptMission$1(MissionViewModel missionViewModel, Continuation<? super MissionViewModel$acceptMission$1> continuation) {
        super(2, continuation);
        this.f58779j = missionViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MissionViewModel$acceptMission$1(this.f58779j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MissionViewModel$acceptMission$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Mission mission;
        Mission mission2;
        Integer id2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58778i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MissionViewModel.MissionState value = this.f58779j.getMissionState().getValue();
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
            this.f58779j.missionTracker.onMissionClicked(this.f58779j.origin, mission2, MissionClickType.ACCEPT);
            this.f58779j.getLoadingIndicatorAcceptMission().postValue(Boxing.boxBoolean(true));
            AcceptMissionRewardUseCase access$getAcceptMissionRewardUseCase$p = this.f58779j.acceptMissionRewardUseCase;
            MissionOrigin access$getOrigin$p = this.f58779j.origin;
            if (access$getOrigin$p != null) {
                str = access$getOrigin$p.getScreen();
            }
            this.f58777h = mission2;
            this.f58778i = 1;
            Object r12 = access$getAcceptMissionRewardUseCase$p.m10280acceptMissionReward0E7RQCE(intValue, str, this);
            if (r12 == coroutine_suspended) {
                return coroutine_suspended;
            }
            mission = mission2;
            obj2 = r12;
        } else if (i11 == 1) {
            mission = (Mission) this.f58777h;
            ResultKt.throwOnFailure(obj);
            obj2 = ((Result) obj).m6338unboximpl();
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f58779j.getLoadingIndicatorAcceptMission().postValue(Boxing.boxBoolean(false));
        if (Result.m6336isSuccessimpl(obj2)) {
            MissionDetails details = mission.getDetails();
            if (details == null) {
                return Unit.INSTANCE;
            }
            this.f58779j.getShowMissionDetailsEvent().postValue(details);
            mission.setPhase(MissionViewModel.IN_PROGRESS);
            this.f58779j.getMissionState().postValue(new MissionViewModel.MissionState.Active(mission));
        }
        return Unit.INSTANCE;
    }
}
