package com.talabat.feature.mission.control.presentation.viewmodel;

import com.talabat.feature.mission.control.domain.model.MissionControlRequest;
import com.talabat.feature.mission.control.domain.model.PrimaryMissionControl;
import com.talabat.feature.mission.control.domain.usecases.PrimaryMissionControlsUseCase;
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
@DebugMetadata(c = "com.talabat.feature.mission.control.presentation.viewmodel.PrimaryMissionViewModel$getPrimaryMissionControls$1", f = "PrimaryMissionViewModel.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
public final class PrimaryMissionViewModel$getPrimaryMissionControls$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f58610h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PrimaryMissionViewModel f58611i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MissionControlRequest f58612j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrimaryMissionViewModel$getPrimaryMissionControls$1(PrimaryMissionViewModel primaryMissionViewModel, MissionControlRequest missionControlRequest, Continuation<? super PrimaryMissionViewModel$getPrimaryMissionControls$1> continuation) {
        super(2, continuation);
        this.f58611i = primaryMissionViewModel;
        this.f58612j = missionControlRequest;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PrimaryMissionViewModel$getPrimaryMissionControls$1 primaryMissionViewModel$getPrimaryMissionControls$1 = new PrimaryMissionViewModel$getPrimaryMissionControls$1(this.f58611i, this.f58612j, continuation);
        primaryMissionViewModel$getPrimaryMissionControls$1.L$0 = obj;
        return primaryMissionViewModel$getPrimaryMissionControls$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PrimaryMissionViewModel$getPrimaryMissionControls$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58610h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            PrimaryMissionViewModel primaryMissionViewModel = this.f58611i;
            MissionControlRequest missionControlRequest = this.f58612j;
            Result.Companion companion = Result.Companion;
            PrimaryMissionControlsUseCase access$getUseCase$p = primaryMissionViewModel.useCase;
            this.f58610h = 1;
            obj = access$getUseCase$p.getPrimaryMissionControls(missionControlRequest, this);
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
        obj2 = Result.m6329constructorimpl((PrimaryMissionControl) obj);
        PrimaryMissionViewModel primaryMissionViewModel2 = this.f58611i;
        if (Result.m6336isSuccessimpl(obj2)) {
            PrimaryMissionControl primaryMissionControl = (PrimaryMissionControl) obj2;
            primaryMissionViewModel2.trackMissionShown(primaryMissionControl);
            primaryMissionViewModel2.primaryMissionLiveData.postValue(primaryMissionControl);
        }
        return Unit.INSTANCE;
    }
}
