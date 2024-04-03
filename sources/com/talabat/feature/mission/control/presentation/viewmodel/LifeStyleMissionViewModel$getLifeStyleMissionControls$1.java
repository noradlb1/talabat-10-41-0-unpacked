package com.talabat.feature.mission.control.presentation.viewmodel;

import com.talabat.feature.mission.control.domain.model.LifeStyleMissionControl;
import com.talabat.feature.mission.control.domain.model.MissionControlRequest;
import com.talabat.feature.mission.control.domain.usecases.LifeStyleMissionControlsUseCase;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.talabat.feature.mission.control.presentation.viewmodel.LifeStyleMissionViewModel$getLifeStyleMissionControls$1", f = "LifeStyleMissionViewModel.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
public final class LifeStyleMissionViewModel$getLifeStyleMissionControls$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f58607h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LifeStyleMissionViewModel f58608i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MissionControlRequest f58609j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LifeStyleMissionViewModel$getLifeStyleMissionControls$1(LifeStyleMissionViewModel lifeStyleMissionViewModel, MissionControlRequest missionControlRequest, Continuation<? super LifeStyleMissionViewModel$getLifeStyleMissionControls$1> continuation) {
        super(2, continuation);
        this.f58608i = lifeStyleMissionViewModel;
        this.f58609j = missionControlRequest;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        LifeStyleMissionViewModel$getLifeStyleMissionControls$1 lifeStyleMissionViewModel$getLifeStyleMissionControls$1 = new LifeStyleMissionViewModel$getLifeStyleMissionControls$1(this.f58608i, this.f58609j, continuation);
        lifeStyleMissionViewModel$getLifeStyleMissionControls$1.L$0 = obj;
        return lifeStyleMissionViewModel$getLifeStyleMissionControls$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LifeStyleMissionViewModel$getLifeStyleMissionControls$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58607h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            LifeStyleMissionViewModel lifeStyleMissionViewModel = this.f58608i;
            MissionControlRequest missionControlRequest = this.f58609j;
            Result.Companion companion = Result.Companion;
            LifeStyleMissionControlsUseCase access$getUseCase$p = lifeStyleMissionViewModel.useCase;
            this.f58607h = 1;
            obj = access$getUseCase$p.getLifeStyleMissionControls(missionControlRequest, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl((LifeStyleMissionControl) obj);
        LifeStyleMissionViewModel lifeStyleMissionViewModel2 = this.f58608i;
        if (Result.m6336isSuccessimpl(obj2)) {
            LifeStyleMissionControl lifeStyleMissionControl = (LifeStyleMissionControl) obj2;
            lifeStyleMissionViewModel2.trackMissionShown(lifeStyleMissionControl);
            lifeStyleMissionViewModel2.lifeStyleMissionLiveData.postValue(lifeStyleMissionControl);
        }
        return Unit.INSTANCE;
    }
}
