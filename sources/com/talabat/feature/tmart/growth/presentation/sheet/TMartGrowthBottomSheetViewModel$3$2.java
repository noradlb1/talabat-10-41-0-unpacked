package com.talabat.feature.tmart.growth.presentation.sheet;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimConfirmation;
import com.talabat.feature.tmart.growth.presentation.sheet.BottomSheetState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$3$2", f = "TMartGrowthBottomSheetViewModel.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthBottomSheetViewModel$3$2 extends SuspendLambda implements Function2<FlowCollector<? super BottomSheetState>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59167h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthBottomSheetViewModel f59168i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthClaimConfirmation f59169j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthBottomSheetViewModel$3$2(TMartGrowthBottomSheetViewModel tMartGrowthBottomSheetViewModel, TMartGrowthClaimConfirmation tMartGrowthClaimConfirmation, Continuation<? super TMartGrowthBottomSheetViewModel$3$2> continuation) {
        super(2, continuation);
        this.f59168i = tMartGrowthBottomSheetViewModel;
        this.f59169j = tMartGrowthClaimConfirmation;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TMartGrowthBottomSheetViewModel$3$2 tMartGrowthBottomSheetViewModel$3$2 = new TMartGrowthBottomSheetViewModel$3$2(this.f59168i, this.f59169j, continuation);
        tMartGrowthBottomSheetViewModel$3$2.L$0 = obj;
        return tMartGrowthBottomSheetViewModel$3$2;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super BottomSheetState> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((TMartGrowthBottomSheetViewModel$3$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59167h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            BottomSheetState.ShowInfo access$toInfoState = this.f59168i.toInfoState(this.f59169j);
            this.f59167h = 1;
            if (((FlowCollector) this.L$0).emit(access$toInfoState, this) == coroutine_suspended) {
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
