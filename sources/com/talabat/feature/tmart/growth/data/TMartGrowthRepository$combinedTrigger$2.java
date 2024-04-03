package com.talabat.feature.tmart.growth.data;

import com.talabat.feature.tmart.growth.data.TMartGrowthRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H@"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository$RequestType;", "trigger", "", "<anonymous parameter 1>", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.data.TMartGrowthRepository$combinedTrigger$2", f = "TMartGrowthRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthRepository$combinedTrigger$2 extends SuspendLambda implements Function3<TMartGrowthRepository.RequestType, Unit, Continuation<? super TMartGrowthRepository.RequestType>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59055h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59056i;

    public TMartGrowthRepository$combinedTrigger$2(Continuation<? super TMartGrowthRepository$combinedTrigger$2> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull TMartGrowthRepository.RequestType requestType, @NotNull Unit unit, @Nullable Continuation<? super TMartGrowthRepository.RequestType> continuation) {
        TMartGrowthRepository$combinedTrigger$2 tMartGrowthRepository$combinedTrigger$2 = new TMartGrowthRepository$combinedTrigger$2(continuation);
        tMartGrowthRepository$combinedTrigger$2.f59056i = requestType;
        return tMartGrowthRepository$combinedTrigger$2.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f59055h == 0) {
            ResultKt.throwOnFailure(obj);
            return (TMartGrowthRepository.RequestType) this.f59056i;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
