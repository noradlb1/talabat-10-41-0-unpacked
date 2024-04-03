package com.talabat.feature.rewards.presentation.mission.viewmodel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel$loadMission$1", f = "MissionViewModel.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
public final class MissionViewModel$loadMission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f58787h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MissionViewModel f58788i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MissionViewModel$loadMission$1(MissionViewModel missionViewModel, Continuation<? super MissionViewModel$loadMission$1> continuation) {
        super(2, continuation);
        this.f58788i = missionViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MissionViewModel$loadMission$1(this.f58788i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MissionViewModel$loadMission$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58787h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f58788i.isFwfMissionEnabled()) {
                MissionViewModel missionViewModel = this.f58788i;
                this.f58787h = 1;
                if (missionViewModel.getMission(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.f58788i.setHasNoMission();
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
