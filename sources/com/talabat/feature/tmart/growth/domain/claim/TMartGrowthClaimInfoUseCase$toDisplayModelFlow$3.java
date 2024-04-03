package com.talabat.feature.tmart.growth.domain.claim;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$toDisplayModelFlow$3", f = "TMartGrowthClaimInfoUseCase.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthClaimInfoUseCase$toDisplayModelFlow$3 extends SuspendLambda implements Function3<FlowCollector<? super TMartGrowthFilePath>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59104h;

    public TMartGrowthClaimInfoUseCase$toDisplayModelFlow$3(Continuation<? super TMartGrowthClaimInfoUseCase$toDisplayModelFlow$3> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super TMartGrowthFilePath> flowCollector, @NotNull Throwable th2, @Nullable Continuation<? super Unit> continuation) {
        TMartGrowthClaimInfoUseCase$toDisplayModelFlow$3 tMartGrowthClaimInfoUseCase$toDisplayModelFlow$3 = new TMartGrowthClaimInfoUseCase$toDisplayModelFlow$3(continuation);
        tMartGrowthClaimInfoUseCase$toDisplayModelFlow$3.L$0 = flowCollector;
        return tMartGrowthClaimInfoUseCase$toDisplayModelFlow$3.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59104h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            TMartGrowthFilePath r12 = TMartGrowthFilePath.m10323boximpl(TMartGrowthFilePath.m10324constructorimpl(""));
            this.f59104h = 1;
            if (((FlowCollector) this.L$0).emit(r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
